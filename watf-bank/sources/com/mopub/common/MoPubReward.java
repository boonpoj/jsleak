package com.mopub.common;

import android.support.annotation.NonNull;
/* loaded from: assets/classes2.dex */
public final class MoPubReward {
    public static final int DEFAULT_REWARD_AMOUNT = 0;
    public static final int NO_REWARD_AMOUNT = -123;
    public static final String NO_REWARD_LABEL = "";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final boolean f407;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f408;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final int f409;

    private MoPubReward(boolean z, @NonNull String str, int i) {
        this.f407 = z;
        this.f408 = str;
        this.f409 = i;
    }

    @NonNull
    public static MoPubReward failure() {
        return new MoPubReward(false, "", 0);
    }

    @NonNull
    public static MoPubReward success(@NonNull String str, int i) {
        return new MoPubReward(true, str, i);
    }

    public final int getAmount() {
        return this.f409;
    }

    @NonNull
    public final String getLabel() {
        return this.f408;
    }

    public final boolean isSuccessful() {
        return this.f407;
    }
}
