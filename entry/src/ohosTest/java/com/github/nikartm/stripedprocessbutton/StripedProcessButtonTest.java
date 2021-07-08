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

import static org.junit.Assert.*;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.agp.utils.Color;
import ohos.app.Context;
import com.github.nikartm.support.AnimatedStripedDrawable;
import com.github.nikartm.support.AttributeController;
import com.github.nikartm.support.StripedDrawable;
import com.github.nikartm.support.StripedProcessButton;
import org.junit.Before;
import org.junit.Test;
import java.util.Optional;

public class StripedProcessButtonTest {
    private Context context;
    private AttrSet attrSet;
    private StripedProcessButton stripedProcessButton;
    private AnimatedStripedDrawable animatedDrawable;
    private StripedDrawable stripedDrawable;

    @Before
    public void setUp() throws Exception {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        attrSet = new AttrSet() {
            @Override
            public Optional<String> getStyle() {
                return Optional.empty();
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public Optional<Attr> getAttr(int i) {
                return Optional.empty();
            }

            @Override
            public Optional<Attr> getAttr(String s) {
                return Optional.empty();
            }
        };
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
        stripedProcessButton.setStartAnimDuration(800);
        assertEquals(String.valueOf(stripedProcessButton.getStartAnimDuration()),String.valueOf(800));
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
        stripedProcessButton.setStopAnimDuration(500);
        assertEquals(String.valueOf(stripedProcessButton.getStopAnimDuration()),String.valueOf(500));
    }

    @Test
    public void getLoadingText() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals("Loading",stripedProcessButton.getLoadingText());
    }

    @Test
    public void setLoadingText() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setLoadingText("test_text");
        assertEquals("test_text",stripedProcessButton.getLoadingText());
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
        stripedProcessButton.setStripeWidth(20f);
        float density = stripedProcessButton.getStripeWidth()/20f;
        stripedProcessButton.setStripeWidth(80f);
        assertEquals(String.valueOf(stripedProcessButton.getStripeWidth()),String.valueOf(80f * density));
    }

    @Test
    public void getColorBack() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(Color.getIntColor("#4CAF50"),stripedProcessButton.getColorBack());
    }

    @Test
    public void setColorBack() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setColorBack(0xCFD8DC);
        assertEquals(0xCFD8DC,stripedProcessButton.getColorBack());
    }

    @Test
    public void getColorMain() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        assertEquals(Color.getIntColor("#4CAF50"),stripedProcessButton.getColorMain());
    }

    @Test
    public void setColorMain() {
        AttributeController attrController = new AttributeController(attrSet);
        stripedDrawable = attrController.getStripedDrawable();
        stripedProcessButton = new StripedProcessButton(context,attrSet);
        animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
        animatedDrawable.setComponent(stripedProcessButton);
        stripedProcessButton.setColorMain(0xCF00DC);
        assertEquals(0xCF00DC,stripedProcessButton.getColorMain());
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
        stripedProcessButton.setColorSub(0xCF00DC);
        assertEquals(0xCF00DC,stripedProcessButton.getColorSub());
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
        stripedProcessButton.setStripeAlpha(0.5f);
        assertEquals(String.valueOf(stripedProcessButton.getStripeAlpha()),String.valueOf(0.5f));
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
        stripedProcessButton.setCornerRadius(20);
        assertEquals(String.valueOf(stripedProcessButton.getCornerRadius()),String.valueOf(20.0f));
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
        stripedProcessButton.setStripeDuration(300);
        assertEquals(String.valueOf(stripedProcessButton.getStripeDuration()),String.valueOf(300));
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
        stripedProcessButton.setTilt(250);
        assertEquals(String.valueOf(stripedProcessButton.getTilt()),String.valueOf(250.0));
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