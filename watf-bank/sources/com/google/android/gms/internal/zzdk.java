package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzda;
import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdk extends zzbt<Integer, Object> {
    public Long zzaim;
    public Boolean zzain;
    public Boolean zzaio;

    /* renamed from: com.google.android.gms.internal.zzdk$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzdk.zza(zzdk.this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzda.zzb {
        AnonymousClass2() {
        }

        @Override // com.google.android.gms.internal.zzda.zzb
        public void zzk(boolean z) {
            if (z) {
                zzdk.zzb(zzdk.this);
            } else {
                zzdk.zza(zzdk.this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzf.zzb {
        AnonymousClass3() {
        }

        public void onConnected(@Nullable Bundle bundle) {
            synchronized (zzdk.zzc(zzdk.this)) {
                try {
                    zzdk.zza(zzdk.this, zzdk.zzd(zzdk.this).zzew());
                } catch (DeadObjectException e) {
                    zzpe.zzb("Unable to obtain a cache service instance.", e);
                    zzdk.zza(zzdk.this);
                }
                zzdk.zzc(zzdk.this).notifyAll();
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (zzdk.zzc(zzdk.this)) {
                zzdk.zza(zzdk.this, null);
                zzdk.zza(zzdk.this, null);
                zzdk.zzc(zzdk.this).notifyAll();
                com.google.android.gms.ads.internal.zzv.zzcZ().zzkD();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements zzf.zzc {
        AnonymousClass4() {
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            synchronized (zzdk.zzc(zzdk.this)) {
                zzdk.zza(zzdk.this, null);
                zzdk.zza(zzdk.this, null);
                zzdk.zzc(zzdk.this).notifyAll();
                com.google.android.gms.ads.internal.zzv.zzcZ().zzkD();
            }
        }
    }

    public zzdk() {
    }

    public zzdk(String str) {
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzaim = (Long) zzk.get(0);
            this.zzain = (Boolean) zzk.get(1);
            this.zzaio = (Boolean) zzk.get(2);
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Object> zzy() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaim);
        hashMap.put(1, this.zzain);
        hashMap.put(2, this.zzaio);
        return hashMap;
    }
}
