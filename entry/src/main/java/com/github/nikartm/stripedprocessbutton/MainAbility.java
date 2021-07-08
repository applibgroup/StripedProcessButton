package com.github.nikartm.stripedprocessbutton;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import com.github.nikartm.stripedprocessbutton.slice.MainAbilitySlice;

/**
 * MainAbility Class.
 */
public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
