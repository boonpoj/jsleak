package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
final class zzsn extends zzky {
    private /* synthetic */ zzse zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsn(zzse zzseVar) {
        this.zzbzd = zzseVar;
    }

    @Override // com.google.android.gms.internal.zzkx
    public final void onAppEvent(String str, String str2) throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzso(this, str, str2));
    }
}
