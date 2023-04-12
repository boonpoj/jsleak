package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastTracker;
import java.io.Serializable;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class VastAbsoluteProgressTracker extends VastTracker implements Serializable, Comparable<VastAbsoluteProgressTracker> {
    private static final long serialVersionUID = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f985;

    public VastAbsoluteProgressTracker(@NonNull VastTracker.EnumC0210 enumC0210, @NonNull String str, int i) {
        super(enumC0210, str);
        Preconditions.checkArgument(i >= 0);
        this.f985 = i;
    }

    public VastAbsoluteProgressTracker(@NonNull String str, int i) {
        this(VastTracker.EnumC0210.TRACKING_URL, str, i);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull VastAbsoluteProgressTracker vastAbsoluteProgressTracker) {
        return getTrackingMilliseconds() - vastAbsoluteProgressTracker.getTrackingMilliseconds();
    }

    public int getTrackingMilliseconds() {
        return this.f985;
    }

    public String toString() {
        return String.format(Locale.US, "%dms: %s", Integer.valueOf(this.f985), getContent());
    }
}
