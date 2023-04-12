package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzfk implements Parcelable.Creator<zzfj> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzfj zzfjVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzfjVar.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 2, zzfjVar.zzAr);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 3, zzfjVar.backgroundColor);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 4, zzfjVar.zzAs);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 5, zzfjVar.zzAt);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 6, zzfjVar.zzAu);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 7, zzfjVar.zzAv);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 8, zzfjVar.zzAw);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 9, zzfjVar.zzAx);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 10, zzfjVar.zzAy, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 11, zzfjVar.zzAz);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 12, zzfjVar.zzAA, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 13, zzfjVar.zzAB);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 14, zzfjVar.zzAC);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 15, zzfjVar.zzAD, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzg */
    public zzfj createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    i4 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    i5 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    i6 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 7:
                    i7 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 8:
                    i8 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 9:
                    i9 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 10:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 11:
                    i10 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 13:
                    i11 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 14:
                    i12 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 15:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzfj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzz */
    public zzfj[] newArray(int i) {
        return new zzfj[i];
    }
}
