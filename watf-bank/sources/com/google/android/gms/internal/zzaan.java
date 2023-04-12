package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public abstract class zzaan implements zzaal, zzaif<Void> {
    private final Object mLock = new Object();
    private final zzalh<zzaat> zzcmw;
    private final zzaal zzcmx;

    /* loaded from: assets/classes2.dex */
    static abstract class zza {
        private final zzaam zzaAL;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(zzaam zzaamVar) {
            this.zzaAL = zzaamVar;
        }

        public final void zzc(zzaan zzaanVar) {
            zzaan.zza(zzaanVar).lock();
            try {
                if (zzaan.zzb(zzaanVar) != this.zzaAL) {
                    return;
                }
                zzvA();
            } finally {
                zzaan.zza(zzaanVar).unlock();
            }
        }

        protected abstract void zzvA();
    }

    /* loaded from: assets/classes2.dex */
    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzc(zzaan.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Unknown message id: ");
                    sb.append(i);
                    Log.w("GACStateManager", sb.toString());
                    return;
            }
        }
    }

    public zzaan(zzalh<zzaat> zzalhVar, zzaal zzaalVar) {
        this.zzcmw = zzalhVar;
        this.zzcmx = zzaalVar;
    }

    @Override // com.google.android.gms.internal.zzaif
    public final void cancel() {
        zznk();
    }

    @Override // com.google.android.gms.internal.zzaal
    public final void zza(zzaax zzaaxVar) {
        synchronized (this.mLock) {
            this.zzcmx.zza(zzaaxVar);
            zznk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(zzabb zzabbVar, zzaat zzaatVar) {
        try {
            zzabbVar.zza(zzaatVar, new zzaaw(this));
            return true;
        } catch (Throwable th) {
            zzagf.zzc("Could not fetch ad response from ad request service due to an Exception.", th);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "AdRequestClientTask.getAdResponseFromService");
            this.zzcmx.zza(new zzaax(0));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzaif
    public final /* synthetic */ Void zznd() {
        zzabb zznl = zznl();
        if (zznl != null) {
            this.zzcmw.zza(new zzaao(this, zznl), new zzaap(this));
            return null;
        }
        this.zzcmx.zza(new zzaax(0));
        zznk();
        return null;
    }

    public abstract void zznk();

    public abstract zzabb zznl();
}
