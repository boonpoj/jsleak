package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
/* loaded from: classes.dex */
public final class zzc extends zzbfm {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    private String name;
    private int version;

    public zzc(String str, int i) {
        this.name = str;
        this.version = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.name, false);
        zzbfp.zzc(parcel, 2, this.version);
        zzbfp.zzai(parcel, zze);
    }
}
