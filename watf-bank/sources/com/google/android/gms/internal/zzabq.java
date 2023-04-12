package com.google.android.gms.internal;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabq implements Runnable {
    private /* synthetic */ zzabo zzcqn;
    final /* synthetic */ JSONObject zzcqo;
    final /* synthetic */ String zzcqp;

    /* renamed from: com.google.android.gms.internal.zzabq$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzb {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.internal.zzabq.zzb
        public void zzc(zzzx<?> zzzxVar) {
            zzabq.this.zzaBX.remove(zzzxVar);
            if (zzzxVar.zzuR() != null) {
                zzabq.zza(zzabq.this);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    private static class zza implements IBinder.DeathRecipient, zzb {
        private final WeakReference<zzzx<?>> zzaCa;
        private final WeakReference<com.google.android.gms.common.api.zzf> zzaCb;
        private final WeakReference<IBinder> zzaCc;

        private zza(zzzx<?> zzzxVar, com.google.android.gms.common.api.zzf zzfVar, IBinder iBinder) {
            this.zzaCb = new WeakReference<>(zzfVar);
            this.zzaCa = new WeakReference<>(zzzxVar);
            this.zzaCc = new WeakReference<>(iBinder);
        }

        /* synthetic */ zza(zzzx zzzxVar, com.google.android.gms.common.api.zzf zzfVar, IBinder iBinder, AnonymousClass1 anonymousClass1) {
            this(zzzxVar, zzfVar, iBinder);
        }

        private void zzwx() {
            zzzx<?> zzzxVar = this.zzaCa.get();
            com.google.android.gms.common.api.zzf zzfVar = this.zzaCb.get();
            if (zzfVar != null && zzzxVar != null) {
                zzfVar.remove(zzzxVar.zzuR().intValue());
            }
            IBinder iBinder = this.zzaCc.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzwx();
        }

        @Override // com.google.android.gms.internal.zzabq.zzb
        public void zzc(zzzx<?> zzzxVar) {
            zzwx();
        }
    }

    /* loaded from: assets/classes2.dex */
    interface zzb {
        void zzc(zzzx<?> zzzxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabq(zzabo zzaboVar, JSONObject jSONObject, String str) {
        this.zzcqn = zzaboVar;
        this.zzcqo = jSONObject;
        this.zzcqp = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.js.zzn zznVar;
        com.google.android.gms.ads.internal.js.zzaa zzaaVar;
        zzabo zzaboVar = this.zzcqn;
        zznVar = zzabo.zzclt;
        zzaboVar.zzcqm = zznVar.zzb((zzcv) null);
        zzaaVar = this.zzcqn.zzcqm;
        zzaaVar.zza(new zzabr(this), new zzabs(this));
    }
}
