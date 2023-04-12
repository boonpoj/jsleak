package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabn implements Parcelable.Creator<zzabm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabm createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        Bundle bundle = null;
        zzakd zzakdVar = null;
        ApplicationInfo applicationInfo = null;
        String str = null;
        ArrayList<String> arrayList = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 2:
                    zzakdVar = (zzakd) zzbfn.zza(parcel, readInt, zzakd.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) zzbfn.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 6:
                    packageInfo = (PackageInfo) zzbfn.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzabm(bundle, zzakdVar, applicationInfo, str, arrayList, packageInfo, str2, z, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabm[] newArray(int i) {
        return new zzabm[i];
    }
}
