package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzaez implements Parcelable.Creator<zzaey> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaey createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
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
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 7:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 8:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzaey(str, str2, z, z2, arrayList, z3, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaey[] newArray(int i) {
        return new zzaey[i];
    }
}
