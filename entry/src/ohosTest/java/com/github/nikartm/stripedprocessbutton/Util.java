package com.github.nikartm.stripedprocessbutton;

import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import java.util.Optional;

public class Util {
    private Util() {
        // private constructor added to hide the implicit public one
    }
    public static AttrSet setUpAttrSet() {
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
}
