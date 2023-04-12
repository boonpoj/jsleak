package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzcbp extends zzbfm {
    public static final Parcelable.Creator<zzcbp> CREATOR = new zzcbq();
    private String packageName;
    private int versionCode;
    private String zzibq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbp(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzibq = str2;
    }

    public zzcbp(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.packageName, false);
        zzbfp.zza(parcel, 3, this.zzibq, false);
        zzbfp.zzai(parcel, zze);
    }
}
