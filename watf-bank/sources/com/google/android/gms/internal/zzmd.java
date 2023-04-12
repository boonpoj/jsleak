package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final /* synthetic */ class zzmd {

    /* renamed from: com.google.android.gms.internal.zzmd$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzmd.zza(zzmd.this)) {
                if (zzmd.this.zzQS == null) {
                    return;
                }
                zzmd.this.onStop();
                zzmd.zza(zzmd.this, 2, "Timed out waiting for ad response.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmd$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzqi zzQU;

        AnonymousClass2(zzqi zzqiVar) {
            this.zzQU = zzqiVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzmd.zza(zzmd.this)) {
                zzmd.this.zzQS = zzmd.this.zza(zzmd.zzb(zzmd.this).zzvf, this.zzQU);
                if (zzmd.this.zzQS == null) {
                    zzmd.zza(zzmd.this, 0, "Could not start the ad request service.");
                    zzpi.zzWR.removeCallbacks(zzmd.zzc(zzmd.this));
                }
            }
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    static final class zza extends Exception {
        private final int zzPF;

        public zza(String str, int i) {
            super(str);
            this.zzPF = i;
        }

        public int getErrorCode() {
            return this.zzPF;
        }
    }
}
