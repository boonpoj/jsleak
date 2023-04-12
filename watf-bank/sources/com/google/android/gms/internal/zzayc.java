package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzayc implements Parcelable.Creator<zzayb> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzayb zzaybVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzaybVar.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzaybVar.zzxA(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, zzaybVar.zzOp(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziS */
    public zzayb createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        com.google.android.gms.common.internal.zzaf zzafVar = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, ConnectionResult.CREATOR);
                    break;
                case 3:
                    zzafVar = (com.google.android.gms.common.internal.zzaf) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, com.google.android.gms.common.internal.zzaf.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzayb(i, connectionResult, zzafVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzmN */
    public zzayb[] newArray(int i) {
        return new zzayb[i];
    }
}
