package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastTracker;
import java.io.Serializable;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class VastFractionalProgressTracker extends VastTracker implements Serializable, Comparable<VastFractionalProgressTracker> {
    private static final long serialVersionUID = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final float f1000;

    public VastFractionalProgressTracker(@NonNull VastTracker.EnumC0210 enumC0210, @NonNull String str, float f) {
        super(enumC0210, str);
        Preconditions.checkArgument(f >= 0.0f);
        this.f1000 = f;
    }

    public VastFractionalProgressTracker(@NonNull String str, float f) {
        this(VastTracker.EnumC0210.TRACKING_URL, str, f);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull VastFractionalProgressTracker vastFractionalProgressTracker) {
        return Double.compare(trackingFraction(), vastFractionalProgressTracker.trackingFraction());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.f1000), getContent());
    }

    public float trackingFraction() {
        return this.f1000;
    }
}
