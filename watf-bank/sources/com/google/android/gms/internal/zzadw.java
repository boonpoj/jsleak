package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzadw implements Parcelable.Creator<zzadv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadv createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        zzjj zzjjVar = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                zzjjVar = (zzjj) zzbfn.zza(parcel, readInt, zzjj.CREATOR);
            } else if (i != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                str = zzbfn.zzq(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzadv(zzjjVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadv[] newArray(int i) {
        return new zzadv[i];
    }
}
