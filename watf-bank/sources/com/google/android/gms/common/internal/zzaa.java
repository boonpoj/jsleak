package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
/* loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        com.google.android.gms.common.zzc[] zzcVarArr = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) zzbfn.zzb(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 8:
                    account = (Account) zzbfn.zza(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
                case 10:
                    zzcVarArr = (com.google.android.gms.common.zzc[]) zzbfn.zzb(parcel, readInt, com.google.android.gms.common.zzc.CREATOR);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzz(i, i2, i3, str, iBinder, scopeArr, bundle, account, zzcVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
