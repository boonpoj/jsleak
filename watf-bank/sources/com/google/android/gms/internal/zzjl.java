package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzjl implements Parcelable.Creator<zzjj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjj createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzmn zzmnVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 6:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 7:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 8:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    zzmnVar = (zzmn) zzbfn.zza(parcel, readInt, zzmn.CREATOR);
                    break;
                case 11:
                    location = (Location) zzbfn.zza(parcel, readInt, Location.CREATOR);
                    break;
                case 12:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 13:
                    bundle2 = zzbfn.zzs(parcel, readInt);
                    break;
                case 14:
                    bundle3 = zzbfn.zzs(parcel, readInt);
                    break;
                case 15:
                    arrayList2 = zzbfn.zzac(parcel, readInt);
                    break;
                case 16:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 17:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 18:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzjj(i, j, bundle, i2, arrayList, z, i3, z2, str, zzmnVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjj[] newArray(int i) {
        return new zzjj[i];
    }
}
