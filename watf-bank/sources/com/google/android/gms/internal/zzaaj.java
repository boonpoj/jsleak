package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzaan;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaaj {

    /* renamed from: com.google.android.gms.internal.zzaaj$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzaaj.zzb(zzaaj.this).zzan(zzaaj.zza(zzaaj.this));
        }
    }

    /* loaded from: assets/classes2.dex */
    private static class zza implements zzf.zzf {
        private final WeakReference<zzaaj> zzaAb;
        private final Api<?> zzawb;
        private final int zzazb;

        public zza(zzaaj zzaajVar, Api<?> api, int i) {
            this.zzaAb = new WeakReference<>(zzaajVar);
            this.zzawb = api;
            this.zzazb = i;
        }

        public void zzg(@NonNull ConnectionResult connectionResult) {
            zzaaj zzaajVar = this.zzaAb.get();
            if (zzaajVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzac.zza(Looper.myLooper() == zzaaj.zzd(zzaajVar).zzazd.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzaaj.zzc(zzaajVar).lock();
            try {
                if (zzaaj.zza(zzaajVar, 0)) {
                    if (!connectionResult.isSuccess()) {
                        zzaaj.zza(zzaajVar, connectionResult, this.zzawb, this.zzazb);
                    }
                    if (zzaaj.zzk(zzaajVar)) {
                        zzaaj.zzj(zzaajVar);
                    }
                }
            } finally {
                zzaaj.zzc(zzaajVar).unlock();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    private class zzb extends zzf {
        private final Map<Api.zze, zza> zzaAc;

        public zzb(Map<Api.zze, zza> map) {
            super(zzaaj.this, null);
            this.zzaAc = map;
        }

        /* JADX WARN: Type inference failed for: r3v5, types: [com.google.android.gms.internal.zzaaj, com.google.android.gms.internal.zzaam] */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.zzaaj, com.google.android.gms.internal.zzaam] */
        @Override // com.google.android.gms.internal.zzaaj.zzf
        @WorkerThread
        public void zzvA() {
            boolean z;
            Iterator<Api.zze> it = this.zzaAc.keySet().iterator();
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = true;
            while (true) {
                if (!it.hasNext()) {
                    z2 = z3;
                    z = false;
                    break;
                }
                Api.zze next = it.next();
                if (!next.zzuI()) {
                    z4 = false;
                } else if (this.zzaAc.get(next).zzazb == 0) {
                    z = true;
                    break;
                } else {
                    z3 = true;
                }
            }
            int isGooglePlayServicesAvailable = z2 ? zzaaj.zzb(zzaaj.this).isGooglePlayServicesAvailable(zzaaj.zza(zzaaj.this)) : 0;
            if (isGooglePlayServicesAvailable != 0 && (z || z4)) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                zzaaj.zzd(zzaaj.this).zza(new zzaan.zza(zzaaj.this) { // from class: com.google.android.gms.internal.zzaaj.zzb.1
                    @Override // com.google.android.gms.internal.zzaan.zza
                    public void zzvA() {
                        zzaaj.zza(zzaaj.this, connectionResult);
                    }
                });
                return;
            }
            if (zzaaj.zze(zzaaj.this)) {
                zzaaj.zzf(zzaaj.this).connect();
            }
            for (Api.zze zzeVar : this.zzaAc.keySet()) {
                final zza zzaVar = this.zzaAc.get(zzeVar);
                if (!zzeVar.zzuI() || isGooglePlayServicesAvailable == 0) {
                    zzeVar.zza(zzaVar);
                } else {
                    zzaaj.zzd(zzaaj.this).zza(new zzaan.zza(this, zzaaj.this) { // from class: com.google.android.gms.internal.zzaaj.zzb.2
                        @Override // com.google.android.gms.internal.zzaan.zza
                        public void zzvA() {
                            zzaVar.zzg(new ConnectionResult(16, null));
                        }
                    });
                }
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    private class zzc extends zzf {
        private final ArrayList<Api.zze> zzaAg;

        public zzc(ArrayList<Api.zze> arrayList) {
            super(zzaaj.this, null);
            this.zzaAg = arrayList;
        }

        @Override // com.google.android.gms.internal.zzaaj.zzf
        @WorkerThread
        public void zzvA() {
            zzaaj.zzd(zzaaj.this).zzazd.zzaAs = zzaaj.zzg(zzaaj.this);
            Iterator<Api.zze> it = this.zzaAg.iterator();
            while (it.hasNext()) {
                it.next().zza(zzaaj.zzh(zzaaj.this), zzaaj.zzd(zzaaj.this).zzazd.zzaAs);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    private static class zzd extends zzaxr {
        private final WeakReference<zzaaj> zzaAb;

        zzd(zzaaj zzaajVar) {
            this.zzaAb = new WeakReference<>(zzaajVar);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.zzaaj, com.google.android.gms.internal.zzaam] */
        @Override // com.google.android.gms.internal.zzaxr, com.google.android.gms.internal.zzaxu
        @BinderThread
        public void zzb(final zzayb zzaybVar) {
            final zzaaj zzaajVar = this.zzaAb.get();
            if (zzaajVar == 0) {
                return;
            }
            zzaaj.zzd(zzaajVar).zza(new zzaan.zza(this, zzaajVar) { // from class: com.google.android.gms.internal.zzaaj.zzd.1
                @Override // com.google.android.gms.internal.zzaan.zza
                public void zzvA() {
                    zzaaj.zza(zzaajVar, zzaybVar);
                }
            });
        }
    }

    /* loaded from: assets/classes2.dex */
    private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        /* synthetic */ zze(zzaaj zzaajVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onConnected(Bundle bundle) {
            zzaaj.zzf(zzaaj.this).zza(new zzd(zzaaj.this));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzaaj.zzc(zzaaj.this).lock();
            try {
                if (zzaaj.zzb(zzaaj.this, connectionResult)) {
                    zzaaj.zzi(zzaaj.this);
                    zzaaj.zzj(zzaaj.this);
                } else {
                    zzaaj.zza(zzaaj.this, connectionResult);
                }
            } finally {
                zzaaj.zzc(zzaaj.this).unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* loaded from: assets/classes2.dex */
    private abstract class zzf implements Runnable {
        private zzf() {
        }

        /* synthetic */ zzf(zzaaj zzaajVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            zzaaj.zzc(zzaaj.this).lock();
            try {
                try {
                } catch (RuntimeException e) {
                    zzaaj.zzd(zzaaj.this).zza(e);
                }
                if (Thread.interrupted()) {
                    return;
                }
                zzvA();
            } finally {
                zzaaj.zzc(zzaaj.this).unlock();
            }
        }

        @WorkerThread
        protected abstract void zzvA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzd(Context context, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.zzbs.zzei();
            int zzav = zzahn.zzav(context);
            if (zzav == 0) {
                return false;
            }
            com.google.android.gms.ads.internal.zzbs.zzei();
            return zzav <= zzahn.zzaw(context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zze(Context context, boolean z) {
        return zzd(context, z);
    }
}
