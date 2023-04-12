package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzsc implements com.google.android.gms.common.internal.zzg {
    private /* synthetic */ zzrx zzbyu;
    private /* synthetic */ zzalf zzbyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsc(zzrx zzrxVar, zzalf zzalfVar) {
        this.zzbyu = zzrxVar;
        this.zzbyv = zzalfVar;
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        obj = this.zzbyu.mLock;
        synchronized (obj) {
            this.zzbyv.setException(new RuntimeException("Connection failed."));
        }
    }
}
