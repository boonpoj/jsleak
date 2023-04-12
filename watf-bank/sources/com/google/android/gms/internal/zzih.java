package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzih implements com.google.android.gms.common.internal.zzg {
    private /* synthetic */ zzid zzbaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzih(zzid zzidVar) {
        this.zzbaw = zzidVar;
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        zzik zzikVar;
        Object obj2;
        obj = this.zzbaw.mLock;
        synchronized (obj) {
            this.zzbaw.zzbav = null;
            zzikVar = this.zzbaw.zzbau;
            if (zzikVar != null) {
                this.zzbaw.zzbau = null;
            }
            obj2 = this.zzbaw.mLock;
            obj2.notifyAll();
        }
    }
}
