package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzru implements Parcelable.Creator<zzrt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzrt createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j = 0;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    bArr = zzbfn.zzt(parcel, readInt);
                    break;
                case 5:
                    strArr = zzbfn.zzaa(parcel, readInt);
                    break;
                case 6:
                    strArr2 = zzbfn.zzaa(parcel, readInt);
                    break;
                case 7:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 8:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzrt(z, str, i, bArr, strArr, strArr2, z2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzrt[] newArray(int i) {
        return new zzrt[i];
    }
}
