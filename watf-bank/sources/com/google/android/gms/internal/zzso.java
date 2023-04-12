package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzso implements zztc {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zzbzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzso(zzsn zzsnVar, String str, String str2) {
        this.val$name = str;
        this.zzbzf = str2;
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzk != null) {
            zztdVar.zzbzk.onAppEvent(this.val$name, this.zzbzf);
        }
    }
}
