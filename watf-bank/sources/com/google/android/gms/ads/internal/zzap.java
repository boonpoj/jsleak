package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
/* loaded from: classes.dex */
public final class zzap implements Parcelable.Creator<zzao> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzao createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f = 0.0f;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 7:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 8:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    z5 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzao(z, z2, str, z3, f, i, z4, z5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzao[] newArray(int i) {
        return new zzao[i];
    }
}
