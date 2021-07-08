package com.github.nikartm.support;

import static ohos.agp.components.AttrHelper.getDensity;
import ohos.agp.components.AttrSet;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.app.Context;
import com.github.nikartm.support.constant.Constants;

/**
 * Striped process button.
 */
public class StripedProcessButton extends Button implements Component.BindStateChangedListener, Component.DrawTask {
    private AnimatedStripedDrawable mAnimatedDrawable;
    private StripedDrawable mStripedDrawable;
    private State mState = State.STOP;
    private long mStartAnimDuration = Constants.NO_INIT;
    private long mStopAnimDuration = Constants.NO_INIT;
    private boolean mButtonAnimated = Constants.DEF_BUTTON_ANIM;
    private String mDefaultText;
    private float mDensity;

    public StripedProcessButton(Context context) {
        super(context);
        initAttrs(null);
    }

    public StripedProcessButton(Context context, AttrSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public StripedProcessButton(Context context, AttrSet attrs, String defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    private void initAttrs(AttrSet attrs) {
        mDensity = getDensity(getContext());
        AttributeController attrController = new AttributeController(attrs);
        mStripedDrawable = attrController.getStripedDrawable();
        addOhosAttr(mStripedDrawable);
        mAnimatedDrawable = new AnimatedStripedDrawable(mStripedDrawable);
        mAnimatedDrawable.setComponent(this);
        setBindStateChangedListener(this);
        addDrawTask(this:: onDraw);
    }

    /**
     * Store attributes of ohosButton in stripedDrawable.
     */
    private void addOhosAttr(StripedDrawable stripedDrawable) {
        stripedDrawable.setButtonText(getText());
        stripedDrawable.setTextColor(getTextColor().getValue());
        stripedDrawable.setTextSize(getTextSize());
        stripedDrawable.setFont(getFont());
    }

    @Override
    public void onComponentBoundToWindow(Component component) {
        mDefaultText = getText() != null ? getText() : "test...";
        launchAnimationWithDelay();
    }

    @Override
    public void onComponentUnboundFromWindow(Component component) {
        // This method is not required.
    }

    /**
     * Launch animation with delay when view attached to window.
     */
    private void launchAnimationWithDelay() {
        switch (mState) {
            case START:
                start();
                break;
            case STOP:
                stop();
                break;
            default:
                break;
        }
    }

    @Override
    public void onDraw(Component component, Canvas canvas) {
        setBackground(mAnimatedDrawable);
        setEnabled(!isRunning());
        mAnimatedDrawable.drawToCanvas(canvas);
    }

    /**
     * when called, checks state, if Start
     * then start AnimatedStripedDrawable.
     */
    public void start() {
        mState = State.START;
        if (isRunning() || !isBoundToWindow()) {
            return;
        }
        setEnabled(isRunning());
        mAnimatedDrawable.start();
        animateButton(isRunning());
    }

    /**
     * when called, checks state, if Stop
     * then stop AnimatedStripedDrawable.
     */
    public void stop() {
        mState = State.STOP;
        if (!isRunning() || !isBoundToWindow()) {
            return;
        }
        setEnabled(isRunning());
        mAnimatedDrawable.stop();
        animateButton(isRunning());
    }

    /**
     * Check if AnimatedStripeDrawable is running.
     */
    public boolean isRunning() {
        return isBoundToWindow() && mAnimatedDrawable.isRunning();
    }

    private void animateButton(boolean start) {
        if (isButtonAnimated()) {
            setCurrentText(start);
        }
    }

    /**
     * Set the button Text which gets hidden by rectangle drawn on it,
     * but takes care for match content and related width.
     *
     * @param start helps in determining about which text to show.
     */
    private void setCurrentText(boolean start) {
        String currentText;
        if (start) {
            currentText = mStripedDrawable.getLoadingText() == null
                    ? mDefaultText
                    : mStripedDrawable.getLoadingText();
        } else {
            currentText = mDefaultText;
        }
        setText(currentText);
    }

    /**
     * Get current start animation duration.
     *
     * @return start duration in ms
     */
    public long getStartAnimDuration() {
        return mStartAnimDuration;
    }

    /**
     * Set start animation duration in ms.
     *
     * @param startAnimDuration set duration in ms.
     */
    public StripedProcessButton setStartAnimDuration(long startAnimDuration) {
        this.mStartAnimDuration = startAnimDuration;
        invalidate();
        return this;
    }

    /**
     * Get current stop animation duration in ms.
     */
    public long getStopAnimDuration() {
        return mStopAnimDuration;
    }

    /**
     * Set stop animation duration in ms.
     *
     * @param stopAnimDuration set duration.
     */
    public StripedProcessButton setStopAnimDuration(long stopAnimDuration) {
        this.mStopAnimDuration = stopAnimDuration;
        invalidate();
        return this;
    }

    /**
     * Get text when button has loading state.
     */
    public String getLoadingText() {
        return mStripedDrawable.getLoadingText();
    }

    /**
     * Set text when button has loading state.
     *
     * @param loadingText sets text when loading started
     */
    public StripedProcessButton setLoadingText(String loadingText) {
        mStripedDrawable.setLoadingText(loadingText);
        invalidate();
        return this;
    }

    /**
     * Get button stripe animation state.
     *
     * @return true if button is animated else false
     */
    public boolean isButtonAnimated() {
        return mButtonAnimated;
    }

    /**
     * Set button stripe animation state.
     *
     * @param buttonAnimated if true button can be animated
     */
    public StripedProcessButton setButtonAnimated(boolean buttonAnimated) {
        this.mButtonAnimated = buttonAnimated;
        invalidate();
        return this;
    }

    /**
     * Get width of stripes.
     */
    public float getStripeWidth() {
        return mStripedDrawable.getStripeWidth();
    }

    /**
     * Set width of stripes.
     *
     * @param stripeWidth on view
     */
    public StripedProcessButton setStripeWidth(float stripeWidth) {
        mStripedDrawable.setStripeWidth(stripeWidth * mDensity);
        invalidate();
        return this;
    }

    /**
     * Get drawable background color.
     */
    public int getColorBack() {
        return mStripedDrawable.getColorBack();
    }

    /**
     * Set drawable background color.
     *
     * @param colorBack background color
     */
    public StripedProcessButton setColorBack(int colorBack) {
        mStripedDrawable.setColorBack(colorBack);
        invalidate();
        return this;
    }

    /**
     * Get color the main stripe.
     */
    public int getColorMain() {
        return mStripedDrawable.getColorMain();
    }

    /**
     * Set color the main stripe.
     *
     * @param colorMain color of main stripe
     */
    public StripedProcessButton setColorMain(int colorMain) {
        mStripedDrawable.setColorMain(colorMain);
        invalidate();
        return this;
    }

    /**
     * Get color the sub stripe.
     */
    public int getColorSub() {
        return mStripedDrawable.getColorSub();
    }

    /**
     * Set color the sub stripe.
     *
     * @param colorSub color of sub stripe
     */
    public StripedProcessButton setColorSub(int colorSub) {
        mStripedDrawable.setColorSub(colorSub);
        invalidate();
        return this;
    }

    /**
     * Get alpha stripes.
     */
    public float getStripeAlpha() {
        return mStripedDrawable.getStripeAlpha();
    }

    /**
     * Set alpha drawable stripes.
     *
     * @param alpha stripes
     */
    public StripedProcessButton setStripeAlpha(float alpha) {
        mStripedDrawable.setStripeAlpha(alpha);
        invalidate();
        return this;
    }

    /**
     * Get drawable corner radius.
     */
    public float getCornerRadius() {
        return mStripedDrawable.getCornerRadius();
    }

    /**
     * Set drawable corner radius.
     *
     * @param cornerRadius radius
     */
    public StripedProcessButton setCornerRadius(float cornerRadius) {
        mStripedDrawable.setCornerRadius(cornerRadius);
        invalidate();
        return this;
    }

    /**
     * Get duration of stripes animation.
     */
    public int getStripeDuration() {
        return mStripedDrawable.getStripeDuration();
    }

    /**
     * Set duration of stripes animation.
     *
     * @param stripeDuration set duration.
     */
    public StripedProcessButton setStripeDuration(int stripeDuration) {
        mStripedDrawable.setStripeDuration(stripeDuration);
        invalidate();
        return this;
    }

    /**
     * Get tilt of stripes.
     */
    public float getTilt() {
        return mStripedDrawable.getTilt();
    }

    /**
     * Set tilt of stripes.
     *
     * @param tilt of stripes.
     */
    public StripedProcessButton setTilt(float tilt) {
        mStripedDrawable.setTilt(tilt);
        invalidate();
        return this;
    }

    /**
     * Get state of tilt stripes. If true - tilt to left, false - tilt to right.
     */
    public boolean isStripeRevert() {
        return mStripedDrawable.isStripeRevert();
    }

    /**
     * Get state of tilt stripes.
     *
     * @param stripeRevert If true - tilt to left, false - tilt to right.
     */
    public StripedProcessButton setStripeRevert(boolean stripeRevert) {
        mStripedDrawable.setStripeRevert(stripeRevert);
        invalidate();
        return this;
    }

    /**
     * Get states of showing stripes.
     */
    public boolean isShowStripes() {
        return mStripedDrawable.isShowStripes();
    }

    /**
     * Set states of showing stripes.
     *
     * @param showStripes If true - stripes showing, false - stripes gone.
     */
    public StripedProcessButton setShowStripes(boolean showStripes) {
        mStripedDrawable.setShowStripes(showStripes);
        invalidate();
        return this;
    }

    /**
     * Get states of stripes appearance.
     */
    public boolean isStripeGradient() {
        return mStripedDrawable.isStripeGradient();
    }

    /**
     * Set the state of striped appearance of drawable.
     *
     * @param stripeGradient if true stripes has gradient style, false - flat strips.
     */
    public StripedProcessButton setStripeGradient(boolean stripeGradient) {
        mStripedDrawable.setStripeGradient(stripeGradient);
        invalidate();
        return this;
    }

    /**
     * State of launch methods with delay.
     */
    private enum State {
        START, STOP
    }

}
