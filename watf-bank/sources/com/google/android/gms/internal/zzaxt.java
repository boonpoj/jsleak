package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
/* loaded from: assets/classes2.dex */
public class zzaxt implements Parcelable.Creator<zzaxs> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzaxs zzaxsVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzaxsVar.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzaxsVar.zzbCn);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 3, zzaxsVar.zzbCo, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziP */
    public zzaxs createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        boolean z = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, Scope.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaxs(i, z, arrayList);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzmJ */
    public zzaxs[] newArray(int i) {
        return new zzaxs[i];
    }
}
