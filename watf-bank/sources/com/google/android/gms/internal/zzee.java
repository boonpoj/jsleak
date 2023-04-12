package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzee implements Callable {
    private final zzdm zzagr;
    private final zzaz zzako;

    public zzee(zzdm zzdmVar, zzaz zzazVar) {
        this.zzagr = zzdmVar;
        this.zzako = zzazVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzba */
    public final Void call() throws Exception {
        if (this.zzagr.zzap() != null) {
            this.zzagr.zzap().get();
        }
        zzaz zzao = this.zzagr.zzao();
        if (zzao != null) {
            try {
                synchronized (this.zzako) {
                    zzfjs.zza(this.zzako, zzfjs.zzc(zzao));
                }
                return null;
            } catch (zzfjr e) {
                return null;
            }
        }
        return null;
    }
}
