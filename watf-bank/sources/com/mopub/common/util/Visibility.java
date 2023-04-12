package com.mopub.common.util;
/* loaded from: assets/classes2.dex */
public class Visibility {
    private Visibility() {
    }

    public static boolean hasScreenVisibilityChanged(int i, int i2) {
        return isScreenVisible(i) != isScreenVisible(i2);
    }

    public static boolean isScreenVisible(int i) {
        return i == 0;
    }
}
