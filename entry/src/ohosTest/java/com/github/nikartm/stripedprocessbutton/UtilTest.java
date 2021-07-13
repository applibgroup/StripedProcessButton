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
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.app.Context;
import com.github.nikartm.support.Util;
import org.junit.Test;
import java.util.Optional;

public class UtilTest {
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;

    public Context setUpContext() {
        return AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
    }

    public AttrSet setUpAttrSet() {
        return new AttrSet() {
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
    public void computeAlpha() {
        assertEquals(MAX_ALPHA,Util.computeAlpha(1));
        assertEquals(MIN_ALPHA,Util.computeAlpha(0));
        assertEquals(Util.computeAlpha(0.5f),(int)(MAX_ALPHA/2));
    }
}