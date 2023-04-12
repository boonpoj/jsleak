package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzry extends zzalf<ParcelFileDescriptor> {
    private /* synthetic */ zzrx zzbyu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzry(zzrx zzrxVar) {
        this.zzbyu = zzrxVar;
    }

    @Override // com.google.android.gms.internal.zzalf, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbyu.disconnect();
        return super.cancel(z);
    }
}
