package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
/* loaded from: classes.dex */
public final class zzz extends zzbfm {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    private int version;
    private int zzfzr;
    private int zzfzs;
    String zzfzt;
    IBinder zzfzu;
    Scope[] zzfzv;
    Bundle zzfzw;
    Account zzfzx;
    com.google.android.gms.common.zzc[] zzfzy;

    public zzz(int i) {
        this.version = 3;
        this.zzfzs = com.google.android.gms.common.zzf.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzfzr = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, com.google.android.gms.common.zzc[] zzcVarArr) {
        this.version = i;
        this.zzfzr = i2;
        this.zzfzs = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzfzt = "com.google.android.gms";
        } else {
            this.zzfzt = str;
        }
        if (i < 2) {
            Account account2 = null;
            zzan zzanVar = null;
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    zzanVar = queryLocalInterface instanceof zzan ? (zzan) queryLocalInterface : new zzap(iBinder);
                }
                account2 = zza.zza(zzanVar);
            }
            this.zzfzx = account2;
        } else {
            this.zzfzu = iBinder;
            this.zzfzx = account;
        }
        this.zzfzv = scopeArr;
        this.zzfzw = bundle;
        this.zzfzy = zzcVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.version);
        zzbfp.zzc(parcel, 2, this.zzfzr);
        zzbfp.zzc(parcel, 3, this.zzfzs);
        zzbfp.zza(parcel, 4, this.zzfzt, false);
        zzbfp.zza(parcel, 5, this.zzfzu, false);
        zzbfp.zza(parcel, 6, (Parcelable[]) this.zzfzv, i, false);
        zzbfp.zza(parcel, 7, this.zzfzw, false);
        zzbfp.zza(parcel, 8, (Parcelable) this.zzfzx, i, false);
        zzbfp.zza(parcel, 10, (Parcelable[]) this.zzfzy, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
