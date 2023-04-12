package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzawf implements Parcelable.Creator<zzawe> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzawe zzaweVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzaweVar.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzaweVar.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 3, zzaweVar.zzbzy);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 4, zzaweVar.zzbzz);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 5, zzaweVar.zzbzA, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 6, zzaweVar.zzbzB, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 7, zzaweVar.zzbzC);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 8, zzaweVar.zzbzD, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 9, zzaweVar.zzbzE);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 10, zzaweVar.zzbzF);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziv */
    public zzawe createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 9:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case 10:
                    i4 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzawe(i, str, i2, i3, str2, str3, z, str4, z2, i4);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzmn */
    public zzawe[] newArray(int i) {
        return new zzawe[i];
    }
}
