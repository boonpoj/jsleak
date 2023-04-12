package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzpf implements Parcelable.Creator<zzpe> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpe createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        zzmr zzmrVar = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 6:
                    zzmrVar = (zzmr) zzbfn.zza(parcel, readInt, zzmr.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzpe(i, z, i2, z2, i3, zzmrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpe[] newArray(int i) {
        return new zzpe[i];
    }
}
