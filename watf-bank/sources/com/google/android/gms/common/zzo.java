package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
/* loaded from: classes.dex */
public final class zzo implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = zzbfn.zzq(parcel, readInt);
            } else if (i == 2) {
                iBinder = zzbfn.zzr(parcel, readInt);
            } else if (i != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                z = zzbfn.zzc(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzn(str, iBinder, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
