package com.github.nikartm.support;

import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorValue;
import ohos.agp.components.Component;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.render.Canvas;
import ohos.agp.render.LinearShader;
import ohos.agp.render.Paint;
import ohos.agp.render.Shader;
import ohos.agp.utils.Color;
import ohos.agp.utils.Point;
import ohos.agp.utils.Rect;
import ohos.agp.utils.RectFloat;
import ohos.agp.utils.TextAlignment;

/**
 * AnimatedStripedDrawable Class.
 */
public class AnimatedStripedDrawable extends ShapeElement implements Element.OnChangeListener {
    private int mViewHeight;
    private int mViewWidth;
    private float mTiltLeft = 0f;
    private float mTiltRight = 0f;
    private boolean mRunning = false;
    private StripedDrawable mDrawable;
    private AnimatorValue mAnimator;
    private Shader mStripesShader;
    private Component mComponent;

    public AnimatedStripedDrawable(StripedDrawable drawable) {
        this.mDrawable = drawable;
        setCallback(this);
    }

    @Override
    public void onChange(Element element) {
        mViewHeight = mComponent.getEstimatedHeight();
        mViewWidth = mComponent.getEstimatedWidth();
        adjustStripes();
    }

    private void adjustStripes() {
        if (!mDrawable.isStripeRevert()) {
            mTiltLeft = mDrawable.getTilt();
            mTiltRight = 0;
        } else {
            mTiltRight = mDrawable.getTilt();
            mTiltLeft = 0;
        }
    }

    private void initAnimator() {
        if (mAnimator == null) {
            mAnimator = new AnimatorValue();
            mAnimator.setCurveType(Animator.CurveType.LINEAR);
            mAnimator.setDuration(mDrawable.getStripeDuration());
            mAnimator.setLoopedCount(-1);
            mAnimator.setLoopedListener(animator -> {
                shiftColor(mDrawable.getColorMain(), mDrawable.getColorSub());
                invalidateSelf();
            });
        }
    }

    @Override
    public int getWidth() {
        return mViewWidth > 0 ? mViewWidth : super.getWidth();
    }

    @Override
    public int getHeight() {
        return mViewHeight > 0 ? mViewHeight : super.getHeight();
    }

    @Override
    public void drawToCanvas(Canvas canvas) {
        super.drawToCanvas(canvas);
        drawStripes(canvas);
        startStripesAnimation();
    }

    private void startStripesAnimation() {
        if (mRunning) {
            start();
        } else {
            mDrawable.setShowStripes(false);
        }
    }

    private void drawStripes(Canvas canvas) {
        final Paint paintBack = new Paint();
        final Paint paintStripes = new Paint();
        final Paint textPaint = new Paint();
        final Rect rect = new Rect(0, 0, mViewWidth, mViewHeight);
        final RectFloat rectF = new RectFloat(rect);
        final int stripesAlpha = Util.computeAlpha(mDrawable.getStripeAlpha());
        paintBack.setAntiAlias(true);
        paintStripes.setAntiAlias(true);
        if (mDrawable.isStripeGradient()) {
            mStripesShader = createGradientShader();
        } else {
            mStripesShader = createShader();
        }
        textPaint.setAntiAlias(true);
        textPaint.setColor(new Color(mDrawable.getTextColor()));
        textPaint.setTextAlign(TextAlignment.CENTER);
        textPaint.setTextSize(mDrawable.getTextSize());
        textPaint.setFont(mDrawable.getFont());
        paintBack.setColor(new Color(mDrawable.getColorBack()));
        float cornerRadius = mDrawable.getCornerRadius();
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paintBack);
        canvas.drawText(textPaint, mDrawable.getButtonText(),
                mViewWidth / 2f, (mViewHeight + textPaint.getTextSize()) / 2f);
        if (mDrawable.isShowStripes()) {
            paintStripes.setAlpha(stripesAlpha);
            paintStripes.setShader(mStripesShader, Paint.ShaderType.LINEAR_SHADER);
            canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paintStripes);
            canvas.drawText(textPaint, mDrawable.getLoadingText(),
                    mViewWidth / 2f, (mViewHeight + textPaint.getTextSize()) / 2f);
        }
    }

    private LinearShader createShader() {
        return new LinearShader(new Point[] {new Point(mDrawable.getStripeWidth(), mTiltLeft),
                                                new Point(0, mTiltRight)},
                new float[]{0.5f, 0.5f},
                new Color[] { new Color(mDrawable.getColorMain()), new Color(mDrawable.getColorSub())},
                Shader.TileMode.REPEAT_TILEMODE);
    }

    private LinearShader createGradientShader() {
        return new LinearShader(new Point[] {new Point(mDrawable.getStripeWidth(), mTiltLeft),
                                                new Point(0, mTiltRight)},
                null,
                new Color[] { new Color(mDrawable.getColorMain()), new Color(mDrawable.getColorSub())},
                Shader.TileMode.REPEAT_TILEMODE);
    }

    private void shiftColor(int mainColor, int subColor) {
        mDrawable.setColorMain(subColor);
        mDrawable.setColorSub(mainColor);
    }

    /**
     * Start stripes animation.
     */
    protected void start() {
        if (isRunning()) {
            return;
        }
        mRunning = true;
        initAnimator();
        mAnimator.start();
        mDrawable.setShowStripes(true);
        invalidateSelf();
    }

    /**
     * Stop stripes animation.
     */
    protected void stop() {
        if (!isRunning()) {
            return;
        }
        mRunning = false;
        mAnimator.cancel();
        mDrawable.setShowStripes(false);
        invalidateSelf();
    }

    /**
     * Check if stripes animation running.
     */
    protected boolean isRunning() {
        return mAnimator != null && mAnimator.isRunning();
    }

    /**
     * mcomponent is used to get viewHeight and viewWidth in this class.
     *
     * @param component is set to mcomponent here.
     */
    public void setComponent(Component component) {
        mComponent = component;
    }

    /**
     * Used to check if component is linked or not.
     */
    public void invalidateSelf() {
        if (mComponent != null) {
            mComponent.invalidate();
        }
    }
}