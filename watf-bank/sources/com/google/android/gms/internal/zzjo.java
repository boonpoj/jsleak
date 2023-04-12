package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzjo implements Parcelable.Creator<zzjn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        zzjn[] zzjnVarArr = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 7:
                    i4 = zzbfn.zzg(parcel, readInt);
                    break;
                case 8:
                    zzjnVarArr = (zzjn[]) zzbfn.zzb(parcel, readInt, zzjn.CREATOR);
                    break;
                case 9:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 10:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 11:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzjn(str, i, i2, z, i3, i4, zzjnVarArr, z2, z3, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn[] newArray(int i) {
        return new zzjn[i];
    }
}
