package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
/* loaded from: classes.dex */
public final class zzcbo extends com.google.android.gms.common.internal.zzd<zzcbt> {
    public zzcbo(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar) {
        super(context, looper, 116, zzfVar, zzgVar, null);
    }

    public final zzcbt zzauq() throws DeadObjectException {
        return (zzcbt) super.zzakn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzcbt zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof zzcbt ? (zzcbt) queryLocalInterface : new zzcbu(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhi() {
        return "com.google.android.gms.gass.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhj() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
