package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzake implements Parcelable.Creator<zzakd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzakd createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                str = zzbfn.zzq(parcel, readInt);
            } else if (i3 == 3) {
                i = zzbfn.zzg(parcel, readInt);
            } else if (i3 == 4) {
                i2 = zzbfn.zzg(parcel, readInt);
            } else if (i3 == 5) {
                z = zzbfn.zzc(parcel, readInt);
            } else if (i3 != 6) {
                zzbfn.zzb(parcel, readInt);
            } else {
                z2 = zzbfn.zzc(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzakd(str, i, i2, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzakd[] newArray(int i) {
        return new zzakd[i];
    }
}
