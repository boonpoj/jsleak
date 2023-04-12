package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzrs implements Parcelable.Creator<zzrr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzrr createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String[] strArr = null;
        String[] strArr2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = zzbfn.zzq(parcel, readInt);
            } else if (i == 2) {
                strArr = zzbfn.zzaa(parcel, readInt);
            } else if (i != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                strArr2 = zzbfn.zzaa(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzrr(str, strArr, strArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzrr[] newArray(int i) {
        return new zzrr[i];
    }
}
