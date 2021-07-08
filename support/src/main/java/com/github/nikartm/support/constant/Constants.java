package com.github.nikartm.support.constant;

import ohos.agp.utils.Color;

/**
 * Constants of stripped process button.
 */
public class Constants {
    public static final float STRIPE_WIDTH = 36f;
    public static final float STRIPE_ALPHA = 0.3f;
    public static final int CORNER = 0;
    public static final int STRIPE_TILT = 25;
    public static final int DURATION = 250;
    public static final boolean REVERT = false;
    public static final boolean SHOW_STRIPES = false;
    public static final boolean GRADIENT = true;
    public static final int NO_INIT = -1;
    public static final boolean DEF_BUTTON_ANIM = true;
    public static final int DEF_BACKGROUND = Color.getIntColor("#4CAF50");
    public static final int DEF_MAIN_STRIPE = Color.getIntColor("#4CAF50");
    public static final int DEF_SUB_STRIPE = Color.getIntColor("#CFD8DC");

    private Constants() {
        throw new IllegalStateException("Constant class");
    }
}
