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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorValue;
import ohos.agp.components.AttrSet;
import com.github.nikartm.support.AttributeController;
import com.github.nikartm.support.StripedDrawable;
import org.junit.Before;
import org.junit.Test;

public class AnimatedStripedDrawableTest {
    private StripedDrawable drawable;
    private AnimatorValue animator;
    private AttrSet attrSet;

    @Before
    public void setUp()
    {
        UtilTest util = new UtilTest();
        attrSet = util.setUpAttrSet();
    }

    @Test
    public void isRunningInitially() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        assertFalse(animator.isRunning());
    }

    @Test
    public void isRunningOnStart() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        animator.start();
        assertTrue(animator.isRunning());
    }

    @Test
    public void isRunningOnStop() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        animator.start();
        animator.stop();
        assertFalse(animator.isRunning());
    }
}