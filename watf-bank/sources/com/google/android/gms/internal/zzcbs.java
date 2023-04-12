package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzcbs implements Parcelable.Creator<zzcbr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbr createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = zzbfn.zzg(parcel, readInt);
            } else if (i2 != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                bArr = zzbfn.zzt(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcbr(i, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbr[] newArray(int i) {
        return new zzcbr[i];
    }
}
