package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzawb implements Parcelable.Creator<zzawa> {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.os.Parcelable[], com.google.android.gms.internal.zzawc[]] */
    public static void zza(zzawa zzawaVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzawaVar.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 2, zzawaVar.zzbzp);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, (Parcelable[]) zzawaVar.zzbzq, i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 4, zzawaVar.zzbzr, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzit */
    public zzawa createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        zzawc[] zzawcVarArr = null;
        String[] strArr = null;
        int i2 = 0;
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
                    zzawcVarArr = (zzawc[]) com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT, zzawc.CREATOR);
                    break;
                case 4:
                    strArr = com.google.android.gms.common.internal.safeparcel.zzb.zzC(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzawa(i, i2, zzawcVarArr, strArr);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzml */
    public zzawa[] newArray(int i) {
        return new zzawa[i];
    }
}
