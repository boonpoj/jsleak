package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* renamed from: com.mopub.mobileads.ކ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
enum EnumC0228 {
    START("start"),
    FIRST_QUARTILE("firstQuartile"),
    MIDPOINT("midpoint"),
    THIRD_QUARTILE("thirdQuartile"),
    COMPLETE("complete"),
    COMPANION_AD_VIEW("companionAdView"),
    COMPANION_AD_CLICK("companionAdClick"),
    UNKNOWN("");
    

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f1225;

    EnumC0228(String str) {
        this.f1225 = str;
    }

    @NonNull
    public static EnumC0228 fromString(@Nullable String str) {
        EnumC0228[] values;
        if (str == null) {
            return UNKNOWN;
        }
        for (EnumC0228 enumC0228 : values()) {
            if (str.equals(enumC0228.getName())) {
                return enumC0228;
            }
        }
        return UNKNOWN;
    }

    @NonNull
    public String getName() {
        return this.f1225;
    }
}
