package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.io.Serializable;
/* loaded from: assets/classes2.dex */
public class VastTracker implements Serializable {
    private static final long serialVersionUID = 1;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final EnumC0210 f1014;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f1015;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f1016;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f1017;

    /* renamed from: com.mopub.mobileads.VastTracker$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    enum EnumC0210 {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    public VastTracker(@NonNull EnumC0210 enumC0210, @NonNull String str) {
        Preconditions.checkNotNull(enumC0210);
        Preconditions.checkNotNull(str);
        this.f1014 = enumC0210;
        this.f1015 = str;
    }

    public VastTracker(@NonNull String str) {
        this(EnumC0210.TRACKING_URL, str);
    }

    public VastTracker(@NonNull String str, boolean z) {
        this(str);
        this.f1017 = z;
    }

    @NonNull
    public String getContent() {
        return this.f1015;
    }

    @NonNull
    public EnumC0210 getMessageType() {
        return this.f1014;
    }

    public boolean isRepeatable() {
        return this.f1017;
    }

    public boolean isTracked() {
        return this.f1016;
    }

    public void setTracked() {
        this.f1016 = true;
    }
}
