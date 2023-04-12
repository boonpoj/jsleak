package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzim implements Parcelable.Creator<zzil> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzil createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzil(str, j, str2, str3, str4, bundle, z, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzil[] newArray(int i) {
        return new zzil[i];
    }
}
