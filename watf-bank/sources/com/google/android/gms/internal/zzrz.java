package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzrz implements com.google.android.gms.common.internal.zzf {
    final /* synthetic */ zzrx zzbyu;
    private /* synthetic */ zzalf zzbyv;
    private /* synthetic */ zzrr zzbyw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrz(zzrx zzrxVar, zzalf zzalfVar, zzrr zzrrVar) {
        this.zzbyu = zzrxVar;
        this.zzbyv = zzalfVar;
        this.zzbyw = zzrrVar;
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        final zzrq zzrqVar;
        obj = this.zzbyu.mLock;
        synchronized (obj) {
            z = this.zzbyu.zzbyt;
            if (z) {
                return;
            }
            this.zzbyu.zzbyt = true;
            zzrqVar = this.zzbyu.zzbys;
            if (zzrqVar == null) {
                return;
            }
            final zzalf zzalfVar = this.zzbyv;
            final zzrr zzrrVar = this.zzbyw;
            final zzakv<Void> zza = zzahh.zza(new Runnable(this, zzrqVar, zzalfVar, zzrrVar) { // from class: com.google.android.gms.internal.zzsa
                private final zzrz zzbyx;
                private final zzrq zzbyy;
                private final zzalf zzbyz;
                private final zzrr zzbza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbyx = this;
                    this.zzbyy = zzrqVar;
                    this.zzbyz = zzalfVar;
                    this.zzbza = zzrrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzrz zzrzVar = this.zzbyx;
                    zzrq zzrqVar2 = this.zzbyy;
                    zzalf zzalfVar2 = this.zzbyz;
                    try {
                        zzalfVar2.set(zzrqVar2.zzkt().zza(this.zzbza));
                    } catch (RemoteException e) {
                        zzagf.zzb("Unable to obtain a cache service instance.", e);
                        zzalfVar2.setException(e);
                        zzrzVar.zzbyu.disconnect();
                    }
                }
            });
            zzalf zzalfVar2 = this.zzbyv;
            final zzalf zzalfVar3 = this.zzbyv;
            zzalfVar2.zza(new Runnable(zzalfVar3, zza) { // from class: com.google.android.gms.internal.zzsb
                private final zzalf zzbzb;
                private final Future zzbzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbzb = zzalfVar3;
                    this.zzbzc = zza;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzalf zzalfVar4 = this.zzbzb;
                    Future future = this.zzbzc;
                    if (zzalfVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzala.zzdff);
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
    }
}
