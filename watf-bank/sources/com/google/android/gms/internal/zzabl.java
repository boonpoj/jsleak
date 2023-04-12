package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabl implements Parcelable.Creator<zzabj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabj createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) zzbfn.zza(parcel, readInt, ParcelFileDescriptor.CREATOR);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzabj(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabj[] newArray(int i) {
        return new zzabj[i];
    }
}
