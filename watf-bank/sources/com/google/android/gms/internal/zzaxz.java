package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: assets/classes2.dex */
public class zzaxz extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaxz> CREATOR = new zzaya();
    final int mVersionCode;
    final com.google.android.gms.common.internal.zzad zzbCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxz(int i, com.google.android.gms.common.internal.zzad zzadVar) {
        this.mVersionCode = i;
        this.zzbCr = zzadVar;
    }

    public zzaxz(com.google.android.gms.common.internal.zzad zzadVar) {
        this(1, zzadVar);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaya.zza(this, parcel, i);
    }

    public com.google.android.gms.common.internal.zzad zzOo() {
        return this.zzbCr;
    }
}
