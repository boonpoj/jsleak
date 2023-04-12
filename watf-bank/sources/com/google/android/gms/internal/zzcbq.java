package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzcbq implements Parcelable.Creator<zzcbp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbp createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = zzbfn.zzg(parcel, readInt);
            } else if (i2 == 2) {
                str = zzbfn.zzq(parcel, readInt);
            } else if (i2 != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                str2 = zzbfn.zzq(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcbp(i, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbp[] newArray(int i) {
        return new zzcbp[i];
    }
}
