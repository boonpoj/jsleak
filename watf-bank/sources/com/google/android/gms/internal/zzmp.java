package com.google.android.gms.internal;

import android.os.Parcel;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzmp extends zzjn {
    public zzmp(zzjn zzjnVar) {
        super(zzjnVar.zzbek, zzjnVar.height, zzjnVar.heightPixels, zzjnVar.zzbel, zzjnVar.width, zzjnVar.widthPixels, zzjnVar.zzbem, zzjnVar.zzben, zzjnVar.zzbeo, zzjnVar.zzbep);
    }

    @Override // com.google.android.gms.internal.zzjn, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzbek, false);
        zzbfp.zzc(parcel, 3, this.height);
        zzbfp.zzc(parcel, 6, this.width);
        zzbfp.zzai(parcel, zze);
    }
}
