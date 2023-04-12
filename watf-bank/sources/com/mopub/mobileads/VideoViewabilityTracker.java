package com.mopub.mobileads;

import android.support.annotation.NonNull;
/* loaded from: assets/classes2.dex */
public class VideoViewabilityTracker extends VastTracker {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f1160;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int f1161;

    public VideoViewabilityTracker(int i, int i2, @NonNull String str) {
        super(str);
        this.f1160 = i;
        this.f1161 = i2;
    }

    public int getPercentViewable() {
        return this.f1161;
    }

    public int getViewablePlaytimeMS() {
        return this.f1160;
    }
}
