/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.nikartm.stripedprocessbutton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ohos.agp.text.Font;
import ohos.agp.utils.Color;
import com.github.nikartm.support.StripedDrawable;
import org.junit.Test;

public class StripedDrawableTest {
    private static final float VALUE = 20;
    private static final String COLOR = "#4CAF50";
    private static final String TEST_TEXT = "Loading";

    @Test
    public void setStripeWidth() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeWidth(VALUE);
        assertEquals(String.valueOf(stripedDrawable.getStripeWidth()),String.valueOf(VALUE));
    }

    @Test
    public void setColorBack() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorBack(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedDrawable.getColorBack());
    }

    @Test
    public void setColorMain() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorMain(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedDrawable.getColorMain());
    }

    @Test
    public void setColorSub() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorSub(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedDrawable.getColorSub());
    }

    @Test
    public void setStripeAlpha() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeAlpha(VALUE);
        assertEquals(String.valueOf(stripedDrawable.getStripeAlpha()),String.valueOf(VALUE));
    }

    @Test
    public void setCornerRadius() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setCornerRadius(VALUE);
        assertEquals(String.valueOf(stripedDrawable.getCornerRadius()),String.valueOf(VALUE));
    }

    @Test
    public void setStripeDuration() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        int stripeDuration = 200;
        stripedDrawable.setStripeDuration(stripeDuration);
        assertEquals(String.valueOf(stripedDrawable.getStripeDuration()),String.valueOf(stripeDuration));
    }

    @Test
    public void setTilt() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setTilt(VALUE);
        assertEquals(String.valueOf(stripedDrawable.getTilt()),String.valueOf(VALUE));
    }

    @Test
    public void setStripeRevert() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeRevert(true);
        assertTrue(stripedDrawable.isStripeRevert());
    }

    @Test
    public void setShowStripes() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setShowStripes(true);
        assertTrue(stripedDrawable.isShowStripes());
    }

    @Test
    public void setStripeGradient() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeGradient(true);
        assertTrue(stripedDrawable.isStripeGradient());
    }

    @Test
    public void setLoadingText() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setLoadingText(TEST_TEXT);
        assertEquals(TEST_TEXT,stripedDrawable.getLoadingText());
    }

    @Test
    public void setButtonText() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setButtonText(TEST_TEXT);
        assertEquals(TEST_TEXT,stripedDrawable.getButtonText());
    }

    @Test
    public void setTextColor() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setTextColor(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedDrawable.getTextColor());
    }

    @Test
    public void setTextSize() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        int textSize = 20;
        stripedDrawable.setTextSize(textSize);
        assertEquals(String.valueOf(stripedDrawable.getTextSize()),String.valueOf(textSize));
    }

    @Test
    public void setFont() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setFont(Font.SANS_SERIF);
        assertEquals(Font.SANS_SERIF,stripedDrawable.getFont());
    }
}