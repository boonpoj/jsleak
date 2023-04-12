package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzv
/* loaded from: classes.dex */
public final class zzadv extends zzbfm {
    public static final Parcelable.Creator<zzadv> CREATOR = new zzadw();
    public final String zzatw;
    public final zzjj zzcnd;

    public zzadv(zzjj zzjjVar, String str) {
        this.zzcnd = zzjjVar;
        this.zzatw = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, (Parcelable) this.zzcnd, i, false);
        zzbfp.zza(parcel, 3, this.zzatw, false);
        zzbfp.zzai(parcel, zze);
    }
}
