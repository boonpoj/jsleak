package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzapy implements Parcelable.Creator<zzapx> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzapx zzapxVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzapxVar.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzapxVar.zzFY(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgg */
    public zzapx createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    bArr = com.google.android.gms.common.internal.safeparcel.zzb.zzt(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzapx(i, bArr);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjq */
    public zzapx[] newArray(int i) {
        return new zzapx[i];
    }
}
