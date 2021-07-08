package com.github.nikartm.support;

/**
 * Used for calculating alpha value required to set StripeAlpha.
 */
public class Util {
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Used for calculation of alpha value.
     *
     * @param value is compared with MAX_ALPHA and MIN_ALPHA
     */
    public static int computeAlpha(float value) {
        int result;
        if (valueAlpha(value) >= MAX_ALPHA) {
            result = MAX_ALPHA;
        } else if (Float.floatToIntBits(value) < MIN_ALPHA) {
            result = MIN_ALPHA;
        } else {
            result = (int) valueAlpha(value);
        }
        return result;
    }

    private static float valueAlpha(float value) {
        return MAX_ALPHA * (value * 100f) / 100f;
    }
}
