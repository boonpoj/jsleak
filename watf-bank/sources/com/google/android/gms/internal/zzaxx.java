package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: assets/classes2.dex */
public class zzaxx implements Parcelable.Creator<zzaxw> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzaxw zzaxwVar, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, zzaxwVar.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, zzaxwVar.getAccount(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, zzaxwVar.zzOm(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 4, zzaxwVar.zzqN(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziQ */
    public zzaxw createFromParcel(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        Account account = null;
        int i = 0;
        Scope[] scopeArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, Account.CREATOR);
                    break;
                case 3:
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT, Scope.CREATOR);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaxw(i, account, scopeArr, str);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaU);
        throw new zzb.zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzmL */
    public zzaxw[] newArray(int i) {
        return new zzaxw[i];
    }
}
