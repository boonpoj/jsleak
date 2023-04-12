package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzqq extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzqq$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzqq.this.zzYO != null) {
                zzop zzopVar = zzqq.this.zzYO;
                zzqp zzqpVar = zzqq.this.zzGt;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqq$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzqq.this.zzGt.zzli();
            com.google.android.gms.ads.internal.overlay.zze zzkT = zzqq.this.zzGt.zzkT();
            if (zzkT != null) {
                zzkT.zzhl();
            }
            if (zzqq.zza(zzqq.this) != null) {
                zzqq.zza(zzqq.this).zzcd();
                zzqq.zza(zzqq.this, null);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zza(zzqp zzqpVar, boolean z);
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb {
        void zzk(zzqp zzqpVar);
    }

    /* loaded from: assets/classes2.dex */
    public interface zzc {
        void zzcd();
    }

    /* loaded from: assets/classes2.dex */
    private static class zzd implements com.google.android.gms.ads.internal.overlay.zzh {
        private com.google.android.gms.ads.internal.overlay.zzh zzYD;
        private zzqp zzYU;

        public zzd(zzqp zzqpVar, com.google.android.gms.ads.internal.overlay.zzh zzhVar) {
            this.zzYU = zzqpVar;
            this.zzYD = zzhVar;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzbN() {
            this.zzYD.zzbN();
            this.zzYU.zzkP();
        }

        public void zzbO() {
            this.zzYD.zzbO();
            this.zzYU.zzhp();
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zze {
        void zzcc();
    }

    void zza(zzqe zzqeVar) throws RemoteException;
}
