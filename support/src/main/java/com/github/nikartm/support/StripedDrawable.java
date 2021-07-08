package com.github.nikartm.support;

import ohos.agp.text.Font;
import ohos.agp.utils.Color;

/**
 * Striped Drawable class, has getters and setters for attributes to store.
 */
public class StripedDrawable {
    private float mStripeWidth;
    private int mColorBack;
    private int mColorMain;
    private int mColorSub;
    private float mAlpha;
    private float mCornerRadius;
    private int mStripeDuration;
    private float mTilt;
    private boolean mStripeRevert;
    private boolean mShowStripes;
    private boolean mStripeGradient;
    private String mLoadingText;
    private String mButtonText = "default";
    private int mTextColor = Color.BLACK.getValue();
    private int mTextSize = 30;
    private Font mFontName;

    public StripedDrawable() {
        // empty constructor
    }

    /**
     * Get width of stripes.
     */
    public float getStripeWidth() {
        return mStripeWidth;
    }

    /**
     * Set width of stripes.
     *
     * @param stripeWidth is width
     */
    public StripedDrawable setStripeWidth(float stripeWidth) {
        this.mStripeWidth = stripeWidth;
        return this;
    }

    /**
     * Get drawable background color.
     */
    public int getColorBack() {
        return mColorBack;
    }

    /**
     * Set drawable background color.
     *
     * @param colorBack background color
     */
    public StripedDrawable setColorBack(int colorBack) {
        this.mColorBack = colorBack;
        return this;
    }

    /**
     * Get color the main stripe.
     */
    public int getColorMain() {
        return mColorMain;
    }

    /**
     * Set color the main stripe.
     *
     * @param colorMain color of main stripe
     */
    public StripedDrawable setColorMain(int colorMain) {
        this.mColorMain = colorMain;
        return this;
    }

    /**
     * Get color the sub stripe.
     */
    public int getColorSub() {
        return mColorSub;
    }

    /**
     * Set color the sub stripe.
     *
     * @param colorSub color of sub stripe.
     */
    public StripedDrawable setColorSub(int colorSub) {
        this.mColorSub = colorSub;
        return this;
    }

    /**
     * Get alpha stripes.
     */
    public float getStripeAlpha() {
        return mAlpha;
    }

    /**
     * Set alpha drawable stripes.
     *
     * @param alpha stripes
     */
    public StripedDrawable setStripeAlpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    /**
     * Get custom button corner radius.
     */
    public float getCornerRadius() {
        return mCornerRadius;
    }

    /**
     * Set drawable corner radius.
     *
     * @param cornerRadius radius
     */
    public StripedDrawable setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
        return this;
    }

    /**
     * Get duration of stripes animation.
     */
    public int getStripeDuration() {
        return mStripeDuration;
    }

    /**
     * Set duration of stripes animation.
     *
     * @param stripeDuration stripes animation
     */
    public StripedDrawable setStripeDuration(int stripeDuration) {
        this.mStripeDuration = stripeDuration;
        return this;
    }

    /**
     * Get tilt of stripes.
     */
    public float getTilt() {
        return mTilt;
    }

    /**
     * Set tilt of stripes.
     *
     * @param tilt of stripes
     */
    public StripedDrawable setTilt(float tilt) {
        this.mTilt = tilt;
        return this;
    }

    /**
     * Get state of tilt stripes. If true - tilt to left, false - tilt to right.
     */
    public boolean isStripeRevert() {
        return mStripeRevert;
    }

    /**
     * Get state of tilt stripes.
     *
     * @param stripeRevert If true - tilt to left, false - tilt to right.
     */
    public StripedDrawable setStripeRevert(boolean stripeRevert) {
        this.mStripeRevert = stripeRevert;
        return this;
    }

    /**
     * Get states of showing stripes.
     */
    public boolean isShowStripes() {
        return mShowStripes;
    }

    /**
     * Set states of showing stripes.
     *
     * @param showStripes If true - stripes showing, false - stripes gone.
     */
    public StripedDrawable setShowStripes(boolean showStripes) {
        this.mShowStripes = showStripes;
        return this;
    }

    /**
     * Get states of stripes appearance.
     */
    public boolean isStripeGradient() {
        return mStripeGradient;
    }

    /**
     * Set the state of striped appearance on drawn rectangle for custom button.
     *
     * @param stripeGradient if true stripes has gradient style, false - flat strips
     */
    public StripedDrawable setStripeGradient(boolean stripeGradient) {
        this.mStripeGradient = stripeGradient;
        return this;
    }

    /**
     * Get text which to be displayed when button is in loading state.
     *
     * @return loading text
     */
    public String getLoadingText() {
        return mLoadingText;
    }

    /**
     * Set text which to be displayed when button is in loading state.
     *
     * @param loadingText text when loading started
     */
    public StripedDrawable setLoadingText(String loadingText) {
        this.mLoadingText = loadingText;
        return this;
    }

    /** Set text which to be displayed when button is in stop state.
     *
     * @param buttonText contains ohos text to be displayed on button
     */
    public  StripedDrawable setButtonText(String buttonText) {
        this.mButtonText = buttonText;
        return this;
    }

    /**
     *  Used to get Text set for Button in xml.
     */
    public String getButtonText() {
        return mButtonText;
    }

    /**
     *  Used to get Text color set for Button in xml.
     */
    public int getTextColor() {
        return mTextColor;
    }

    /**
     * Set color the main stripe.
     *
     * @param textColor color of main text
     */
    public StripedDrawable setTextColor(int textColor) {
        this.mTextColor = textColor;
        return this;
    }

    /**
     * Used to get Text size set for Button in xml.
     */
    public int getTextSize() {
        return mTextSize;
    }

    /**
     * Set color the main stripe.
     *
     * @param textSize size of main text
     */
    public StripedDrawable setTextSize(int textSize) {
        this.mTextSize = textSize;
        return this;
    }

    public Font getFont() {
        return mFontName;
    }

    /**
     * Set color the main stripe.
     *
     * @param fontName information about font for button text
     */
    public StripedDrawable setFont(Font fontName) {
        this.mFontName = fontName;
        return this;
    }
}
