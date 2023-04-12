package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaby implements Parcelable.Creator<zzabx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabx createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                str = zzbfn.zzq(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzabx(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabx[] newArray(int i) {
        return new zzabx[i];
    }
}
