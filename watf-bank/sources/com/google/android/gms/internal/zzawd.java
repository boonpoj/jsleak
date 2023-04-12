package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzawd implements Parcelable.Creator<zzawc> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzawc zzawcVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzawcVar.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzawcVar.name, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, zzawcVar.zzbzt);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 4, zzawcVar.zzbgG);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 5, zzawcVar.zzbgI);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 6, zzawcVar.zzaFy, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 7, zzawcVar.zzbzu, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 8, zzawcVar.zzbzv);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 9, zzawcVar.zzbzw);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziu */
    public zzawc createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j = 0;
        double d = 0.0d;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
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
                    j = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, zzaT);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    d = com.google.android.gms.common.internal.safeparcel.zzb.zzn(parcel, zzaT);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    bArr = com.google.android.gms.common.internal.safeparcel.zzb.zzt(parcel, zzaT);
                    break;
                case 8:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 9:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzawc(i, str, j, z, d, str2, bArr, i2, i3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzmm */
    public zzawc[] newArray(int i) {
        return new zzawc[i];
    }
}
