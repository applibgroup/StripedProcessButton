package com.github.nikartm.support;

import ohos.agp.components.AttrSet;
import com.github.nikartm.support.constant.Constants;

/**
 * AttributeController class to get Attributes from XML and set them to {@link StripedDrawable}.
 */
public class AttributeController {
    private StripedDrawable mStripedDrawable;
    private static final String STRIPE_WIDTH = "spb_stripeWidth";
    private static final String STRIPE_ALPHA = "spb_stripeAlpha";
    private static final String CORNER = "spb_cornerRadius";
    private static final String STRIPE_TILT = "spb_stripeTilt";
    private static final String DURATION = "spb_stripeDuration";
    private static final String REVERT = "spb_stripeRevert";
    private static final String SHOW_STRIPES = "spb_showStripes";
    private static final String GRADIENT = "spb_stripeGradient";
    private static final String DEF_BACKGROUND = "spb_background";
    private static final String DEF_MAIN_STRIPE = "spb_mainStripColor";
    private static final String DEF_SUB_STRIPE = "spb_subStripeColor";
    private static final String LOADING_TEXT  = "spb_loadingText";

    public AttributeController(AttrSet attrs) {
        mStripedDrawable = new StripedDrawable();
        initAttrs(attrs);
    }

    private void initAttrs(AttrSet attrs) {
        if (attrs != null) {
            String loadingText = attrs.getAttr(LOADING_TEXT).isPresent() ? attrs.getAttr(
                    LOADING_TEXT).get().getStringValue() : "Loading";
            mStripedDrawable.setLoadingText(loadingText);
            setAttrsInt(attrs);
            setAttrsFloat(attrs);
            setAttrsBool(attrs);
        }
    }

    private void setAttrsInt(AttrSet attrs) {
        int stripeTilt =  attrs.getAttr(STRIPE_TILT).isPresent() ? attrs.getAttr(
                STRIPE_TILT).get().getIntegerValue() : Constants.STRIPE_TILT;
        int stripeDuration =  attrs.getAttr(DURATION).isPresent() ? attrs.getAttr(
                DURATION).get().getIntegerValue() : Constants.DURATION;
        int background =  attrs.getAttr(DEF_BACKGROUND).isPresent() ? attrs.getAttr(
                DEF_BACKGROUND).get().getColorValue().getValue() : Constants.DEF_BACKGROUND;
        int mainStripeColor =  attrs.getAttr(DEF_MAIN_STRIPE).isPresent() ? attrs.getAttr(
                DEF_MAIN_STRIPE).get().getColorValue().getValue() : Constants.DEF_MAIN_STRIPE;
        int subStripeColor =  attrs.getAttr(DEF_SUB_STRIPE).isPresent() ? attrs.getAttr(
                DEF_SUB_STRIPE).get().getColorValue().getValue() : Constants.DEF_SUB_STRIPE;

        mStripedDrawable.setTilt(stripeTilt)
                .setStripeDuration(stripeDuration)
                .setColorBack(background)
                .setColorMain(mainStripeColor)
                .setColorSub(subStripeColor);
    }

    private void setAttrsFloat(AttrSet attrs) {
        float stripeWidth =  attrs.getAttr(STRIPE_WIDTH).isPresent() ? attrs.getAttr(
                STRIPE_WIDTH).get().getDimensionValue() : Constants.STRIPE_WIDTH;
        float stripeAlpha =  attrs.getAttr(STRIPE_ALPHA).isPresent() ? attrs.getAttr(
                STRIPE_ALPHA).get().getFloatValue() : Constants.STRIPE_ALPHA;
        float cornerRadius =  attrs.getAttr(CORNER).isPresent() ? attrs.getAttr(
                CORNER).get().getFloatValue() : Constants.CORNER;

        mStripedDrawable.setStripeWidth(stripeWidth)
                .setStripeAlpha(stripeAlpha)
                .setCornerRadius(cornerRadius);
    }

    private void setAttrsBool(AttrSet attrs) {
        boolean stripeRevert =  attrs.getAttr(REVERT).isPresent() ? attrs.getAttr(
                REVERT).get().getBoolValue() : Constants.REVERT;
        boolean showStripes =  attrs.getAttr(SHOW_STRIPES).isPresent() ? attrs.getAttr(
                SHOW_STRIPES).get().getBoolValue() : Constants.SHOW_STRIPES;
        boolean stripeGradient =  attrs.getAttr(GRADIENT).isPresent() ? attrs.getAttr(
                GRADIENT).get().getBoolValue() : Constants.GRADIENT;

        mStripedDrawable.setStripeRevert(stripeRevert)
                .setShowStripes(showStripes)
                .setStripeGradient(stripeGradient);
    }

    /**
     * Get {@link StripedDrawable} when attrs initialized.
     *
     * @return initialized {@link StripedDrawable}
     */
    public StripedDrawable getStripedDrawable() {
        return mStripedDrawable;
    }
}
