package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzv
/* loaded from: classes.dex */
public final class zzrt extends zzbfm {
    public static final Parcelable.Creator<zzrt> CREATOR = new zzru();
    public final byte[] data;
    public final int statusCode;
    public final boolean zzad;
    public final long zzae;
    public final String[] zzbyo;
    public final String[] zzbyp;
    public final boolean zzbyq;
    public final String zzbyr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrt(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zzbyq = z;
        this.zzbyr = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzbyo = strArr;
        this.zzbyp = strArr2;
        this.zzad = z2;
        this.zzae = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzbyq);
        zzbfp.zza(parcel, 2, this.zzbyr, false);
        zzbfp.zzc(parcel, 3, this.statusCode);
        zzbfp.zza(parcel, 4, this.data, false);
        zzbfp.zza(parcel, 5, this.zzbyo, false);
        zzbfp.zza(parcel, 6, this.zzbyp, false);
        zzbfp.zza(parcel, 7, this.zzad);
        zzbfp.zza(parcel, 8, this.zzae);
        zzbfp.zzai(parcel, zze);
    }
}
