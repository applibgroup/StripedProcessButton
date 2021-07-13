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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ohos.agp.components.AttrSet;
import ohos.agp.utils.Color;
import ohos.app.Context;
import com.github.nikartm.support.AnimatedStripedDrawable;
import com.github.nikartm.support.AttributeController;
import com.github.nikartm.support.StripedDrawable;
import com.github.nikartm.support.StripedProcessButton;
import org.junit.Before;
import org.junit.Test;

public class StripedProcessButtonTest {
    private static final float VALUE = 20;
    private static final int ANIM_DURATION = 800;
    private static final String COLOR = "#4CAF50";
    private static final String TEST_TEXT = "Loading";
    private Context context;
    private AttrSet attrSet;
    private StripedProcessButton stripedProcessButton;
    private AnimatedStripedDrawable animatedDrawable;
    private StripedDrawable stripedDrawable;

    @Before
    public void setUp()
    {
        UtilTest util = new UtilTest();
        context = util.setUpContext();
        attrSet = util.setUpAttrSet();
    }

    @Test
    public void getStartAnimDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getStartAnimDuration()),String.valueOf(-1));// default set to -1
    }

    @Test
    public void setStartAnimDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setStartAnimDuration(ANIM_DURATION);
        assertEquals(String.valueOf(stripedProcessButton.getStartAnimDuration()),String.valueOf(ANIM_DURATION));
    }

    @Test
    public void getStopAnimDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getStopAnimDuration()),String.valueOf(-1));
    }

    @Test
    public void setStopAnimDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setStopAnimDuration(ANIM_DURATION);
        assertEquals(String.valueOf(stripedProcessButton.getStopAnimDuration()),String.valueOf(ANIM_DURATION));
    }

    @Test
    public void getLoadingText() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(TEST_TEXT,stripedProcessButton.getLoadingText());
    }

    @Test
    public void setLoadingText() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setLoadingText(TEST_TEXT);
        assertEquals(TEST_TEXT,stripedProcessButton.getLoadingText());
    }

    @Test
    public void isButtonAnimated() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertTrue(stripedProcessButton.isButtonAnimated()); // default true
    }

    @Test
    public void setButtonAnimated() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setButtonAnimated(false);
        assertFalse(stripedProcessButton.isButtonAnimated());
    }

    @Test
    public void getStripeWidth() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getStripeWidth()),String.valueOf(36f));
    }

    @Test
    public void setStripeWidth() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setStripeWidth(VALUE);
        float density = stripedProcessButton.getStripeWidth()/VALUE;
        float stripeWidth = 80f;
        stripedProcessButton.setStripeWidth(stripeWidth);
        assertEquals(String.valueOf(stripedProcessButton.getStripeWidth()),String.valueOf(stripeWidth * density));
    }

    @Test
    public void getColorBack() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(Color.getIntColor(COLOR),stripedProcessButton.getColorBack());
    }

    @Test
    public void setColorBack() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setColorBack(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedProcessButton.getColorBack());
    }

    @Test
    public void getColorMain() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(Color.getIntColor(COLOR),stripedProcessButton.getColorMain());
    }

    @Test
    public void setColorMain() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setColorMain(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedProcessButton.getColorMain());
    }

    @Test
    public void getColorSub() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(Color.getIntColor("#CFD8DC"),stripedProcessButton.getColorSub());
    }

    @Test
    public void setColorSub() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setColorSub(Color.getIntColor(COLOR));
        assertEquals(Color.getIntColor(COLOR),stripedProcessButton.getColorSub());
    }

    @Test
    public void getStripeAlpha() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getStripeAlpha()),String.valueOf(0.3f));
    }

    @Test
    public void setStripeAlpha() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        float stripeAlpha = 0.5f;
        stripedProcessButton.setStripeAlpha(stripeAlpha);
        assertEquals(String.valueOf(stripedProcessButton.getStripeAlpha()),String.valueOf(stripeAlpha));
    }

    @Test
    public void getCornerRadius() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getCornerRadius()),String.valueOf(0.0));
    }

    @Test
    public void setCornerRadius() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setCornerRadius(VALUE);
        assertEquals(String.valueOf(stripedProcessButton.getCornerRadius()),String.valueOf(VALUE));
    }

    @Test
    public void getStripeDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getStripeDuration()),String.valueOf(250));
    }

    @Test
    public void setStripeDuration() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setStripeDuration(ANIM_DURATION);
        assertEquals(String.valueOf(stripedProcessButton.getStripeDuration()),String.valueOf(ANIM_DURATION));
    }

    @Test
    public void getTilt() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(String.valueOf(stripedProcessButton.getTilt()),String.valueOf(25.0));
    }

    @Test
    public void setTilt() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        float tiltAmount = 250;
        stripedProcessButton.setTilt(tiltAmount);
        assertEquals(String.valueOf(stripedProcessButton.getTilt()),String.valueOf(tiltAmount));
    }

    @Test
    public void isStripeRevert() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertFalse(stripedProcessButton.isStripeRevert()); //default set to false
    }

    @Test
    public void setStripeRevert() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setStripeRevert(true);
        assertTrue(stripedProcessButton.isStripeRevert());
    }

    @Test
    public void isShowStripes() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertFalse(stripedProcessButton.isShowStripes()); //default false
    }

    @Test
    public void setShowStripes() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setShowStripes(true);
        assertTrue(stripedProcessButton.isShowStripes());
    }

    @Test
    public void isStripeGradient() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertTrue(stripedProcessButton.isStripeGradient()); //default true
    }

    @Test
    public void setStripeGradient() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setShowStripes(true);
        stripedProcessButton.setStripeGradient(false);
        assertFalse(stripedProcessButton.isStripeGradient());
    }
}