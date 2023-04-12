package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmo implements Parcelable.Creator<zzmn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 15) {
                zzbfn.zzb(parcel, readInt);
            } else {
                str = zzbfn.zzq(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzmn(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn[] newArray(int i) {
        return new zzmn[i];
    }
}
