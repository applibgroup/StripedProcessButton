package com.github.nikartm.stripedprocessbutton.slice;

import com.github.nikartm.stripedprocessbutton.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import com.github.nikartm.support.StripedProcessButton;

public class MainAbilitySlice extends AbilitySlice {
    private StripedProcessButton stripedButton;
    private Button btnStop;
    private StripedProcessButton btn2;
    private StripedProcessButton btn3;
    private StripedProcessButton btn4;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        stripedButton = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_start);
        btnStop = (Button) findComponentById(ResourceTable.Id_btn_stop);
        btn2 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_2);
        btn3 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_3);
        btn4 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_4);
        btn3.start();
        btn4.start();
        stripedButton.setClickedListener(v -> stripedButton.start());
        btn2.setClickedListener(v -> btn2.start());
        btnStop.setClickedListener(component -> {
            stripedButton.stop();
            btn2.stop();
        });
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
