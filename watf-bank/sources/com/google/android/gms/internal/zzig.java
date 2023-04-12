package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzig implements com.google.android.gms.common.internal.zzf {
    private /* synthetic */ zzid zzbaw;

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzb(zzok zzokVar);

        void zzcl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(zzid zzidVar) {
        this.zzbaw = zzidVar;
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        Object obj;
        Object obj2;
        zzik zzikVar;
        zzik zzikVar2;
        obj = this.zzbaw.mLock;
        synchronized (obj) {
            try {
                zzikVar = this.zzbaw.zzbau;
                if (zzikVar != null) {
                    zzid zzidVar = this.zzbaw;
                    zzikVar2 = this.zzbaw.zzbau;
                    zzidVar.zzbav = zzikVar2.zzhk();
                }
            } catch (DeadObjectException e) {
                zzagf.zzb("Unable to obtain a cache service instance.", e);
                this.zzbaw.disconnect();
            }
            obj2 = this.zzbaw.mLock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.zzbaw.mLock;
        synchronized (obj) {
            this.zzbaw.zzbav = null;
            obj2 = this.zzbaw.mLock;
            obj2.notifyAll();
        }
    }
}
