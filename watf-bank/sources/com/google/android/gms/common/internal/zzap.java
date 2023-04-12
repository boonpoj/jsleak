package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public final class zzap extends zzeu implements zzan {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.zzan
    public final Account getAccount() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        Account account = (Account) zzew.zza(zza, Account.CREATOR);
        zza.recycle();
        return account;
    }
}
