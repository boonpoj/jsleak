package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: assets/classes2.dex */
public class zzaxw extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaxw> CREATOR = new zzaxx();
    final int mVersionCode;
    private final Account zzagg;
    private final String zzajk;
    private final Scope[] zzbCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxw(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.zzagg = account;
        this.zzbCp = scopeArr;
        this.zzajk = str;
    }

    public Account getAccount() {
        return this.zzagg;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaxx.zza(this, parcel, i);
    }

    public Scope[] zzOm() {
        return this.zzbCp;
    }

    public String zzqN() {
        return this.zzajk;
    }
}
