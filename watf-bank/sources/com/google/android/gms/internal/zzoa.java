package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzoa extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzoa$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzjt zzUS;
        final /* synthetic */ zzdy zztt;

        AnonymousClass1(zzdy zzdyVar, zzjt zzjtVar) {
            this.zztt = zzdyVar;
            this.zzUS = zzjtVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzoa.zza(zzoa.this, this.zztt, this.zzUS);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzoa$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzjt zzUS;
        final /* synthetic */ zzoe zzUU;
        final /* synthetic */ zzdy zztt;

        AnonymousClass2(zzjt zzjtVar, zzdy zzdyVar, zzoe zzoeVar) {
            this.zzUS = zzjtVar;
            this.zztt = zzdyVar;
            this.zzUU = zzoeVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.zzoe, com.google.android.gms.internal.zzoi] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.zzUS.zza(com.google.android.gms.dynamic.zze.zzA(zzoa.zza(zzoa.this)), this.zztt, null, this.zzUU, zzoa.zzb(zzoa.this));
            } catch (RemoteException e) {
                String valueOf = String.valueOf(zzoa.zzc(zzoa.this));
                zzpe.zzc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), e);
                zzoa.this.zza(zzoa.zzc(zzoa.this), 0);
            }
        }
    }

    void zza(zznx zznxVar) throws RemoteException;
}
