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
public final class zzaav implements Parcelable.Creator<zzaat> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaat createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        zzjj zzjjVar = null;
        zzjn zzjnVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzakd zzakdVar = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzpe zzpeVar = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzlr zzlrVar = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 3:
                    zzjjVar = (zzjj) zzbfn.zza(parcel, readInt, zzjj.CREATOR);
                    break;
                case 4:
                    zzjnVar = (zzjn) zzbfn.zza(parcel, readInt, zzjn.CREATOR);
                    break;
                case 5:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zzbfn.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zzbfn.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 11:
                    zzakdVar = (zzakd) zzbfn.zza(parcel, readInt, zzakd.CREATOR);
                    break;
                case 12:
                    bundle2 = zzbfn.zzs(parcel, readInt);
                    break;
                case 13:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 14:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 15:
                    bundle3 = zzbfn.zzs(parcel, readInt);
                    break;
                case 16:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
                case 18:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 19:
                    i4 = zzbfn.zzg(parcel, readInt);
                    break;
                case 20:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 21:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 25:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 26:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 27:
                    arrayList2 = zzbfn.zzac(parcel, readInt);
                    break;
                case 28:
                    str7 = zzbfn.zzq(parcel, readInt);
                    break;
                case 29:
                    zzpeVar = (zzpe) zzbfn.zza(parcel, readInt, zzpe.CREATOR);
                    break;
                case 30:
                    arrayList3 = zzbfn.zzac(parcel, readInt);
                    break;
                case 31:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 33:
                    str8 = zzbfn.zzq(parcel, readInt);
                    break;
                case 34:
                    f2 = zzbfn.zzl(parcel, readInt);
                    break;
                case 35:
                    i5 = zzbfn.zzg(parcel, readInt);
                    break;
                case 36:
                    i6 = zzbfn.zzg(parcel, readInt);
                    break;
                case 37:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 38:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                case 39:
                    str9 = zzbfn.zzq(parcel, readInt);
                    break;
                case 40:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 41:
                    str10 = zzbfn.zzq(parcel, readInt);
                    break;
                case 42:
                    z5 = zzbfn.zzc(parcel, readInt);
                    break;
                case 43:
                    i7 = zzbfn.zzg(parcel, readInt);
                    break;
                case 44:
                    bundle4 = zzbfn.zzs(parcel, readInt);
                    break;
                case 45:
                    str11 = zzbfn.zzq(parcel, readInt);
                    break;
                case 46:
                    zzlrVar = (zzlr) zzbfn.zza(parcel, readInt, zzlr.CREATOR);
                    break;
                case 47:
                    z6 = zzbfn.zzc(parcel, readInt);
                    break;
                case 48:
                    bundle5 = zzbfn.zzs(parcel, readInt);
                    break;
                case 49:
                    str12 = zzbfn.zzq(parcel, readInt);
                    break;
                case 50:
                    str13 = zzbfn.zzq(parcel, readInt);
                    break;
                case 51:
                    str14 = zzbfn.zzq(parcel, readInt);
                    break;
                case 52:
                    z7 = zzbfn.zzc(parcel, readInt);
                    break;
                case 53:
                    arrayList4 = zzbfn.zzab(parcel, readInt);
                    break;
                case 54:
                    str15 = zzbfn.zzq(parcel, readInt);
                    break;
                case 55:
                    arrayList5 = zzbfn.zzac(parcel, readInt);
                    break;
                case 56:
                    i8 = zzbfn.zzg(parcel, readInt);
                    break;
                case 57:
                    z8 = zzbfn.zzc(parcel, readInt);
                    break;
                case 58:
                    z9 = zzbfn.zzc(parcel, readInt);
                    break;
                case 59:
                    z10 = zzbfn.zzc(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzaat(i, bundle, zzjjVar, zzjnVar, str, applicationInfo, packageInfo, str2, str3, str4, zzakdVar, bundle2, i2, arrayList, bundle3, z, i3, i4, f, str5, j, str6, arrayList2, str7, zzpeVar, arrayList3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzlrVar, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i8, z8, z9, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaat[] newArray(int i) {
        return new zzaat[i];
    }
}
