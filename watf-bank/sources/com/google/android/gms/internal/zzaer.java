package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzaer implements Parcelable.Creator<zzaeq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaeq createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = zzbfn.zzq(parcel, readInt);
            } else if (i2 != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                i = zzbfn.zzg(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzaeq(str, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaeq[] newArray(int i) {
        return new zzaeq[i];
    }
}
