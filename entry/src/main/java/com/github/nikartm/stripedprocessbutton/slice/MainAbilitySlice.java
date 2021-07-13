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

package com.github.nikartm.stripedprocessbutton.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import com.github.nikartm.stripedprocessbutton.ResourceTable;
import com.github.nikartm.support.StripedProcessButton;

/**
 * MainAbilitySlice.
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        StripedProcessButton stripedButton = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_start);
        StripedProcessButton button2 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_2);
        stripedButton.setClickedListener(v -> stripedButton.start());
        button2.setClickedListener(v -> button2.start());
        StripedProcessButton button3 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_3);
        StripedProcessButton button4 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_4);
        Button btnStop = (Button) findComponentById(ResourceTable.Id_btn_stop);
        btnStop.setClickedListener(component -> {
            stripedButton.stop();
            button2.stop();
        });
        button3.start();
        button4.start();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
