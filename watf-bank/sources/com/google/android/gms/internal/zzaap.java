package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzabj;
import com.google.android.gms.internal.zzzq;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaap implements zzali {
    private /* synthetic */ zzaan zzcmz;

    /* loaded from: assets/classes2.dex */
    public class zza<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzzz {
        private final Api.zzb zzaAZ;
        private boolean zzaAm;
        private final zzaad zzaBa;
        private final int zzaBd;
        private final zzabj zzaBe;
        private final zzzs<O> zzaxH;
        private final Api.zze zzazq;
        private final Queue<zzzq> zzaAY = new LinkedList();
        private final Set<zzzu> zzaBb = new HashSet();
        private final Map<zzaaz.zzb<?>, zzabf> zzaBc = new HashMap();
        private ConnectionResult zzaBf = null;

        @WorkerThread
        public zza(com.google.android.gms.common.api.zzc<O> zzcVar) {
            this.zzazq = zzcVar.buildApiClient(zzaap.zza(zzaap.this).getLooper(), this);
            this.zzaAZ = this.zzazq instanceof com.google.android.gms.common.internal.zzal ? this.zzazq.zzxG() : this.zzazq;
            this.zzaxH = zzcVar.getApiKey();
            this.zzaBa = new zzaad();
            this.zzaBd = zzcVar.getInstanceId();
            if (this.zzazq.zzqD()) {
                this.zzaBe = zzcVar.createSignInCoordinator(zzaap.zzb(zzaap.this), zzaap.zza(zzaap.this));
            } else {
                this.zzaBe = null;
            }
        }

        @WorkerThread
        private void zzb(zzzq zzzqVar) {
            zzzqVar.zza(this.zzaBa, zzqD());
            try {
                zzzqVar.zza(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zzazq.disconnect();
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzzu zzzuVar : this.zzaBb) {
                zzzuVar.zza(this.zzaxH, connectionResult);
            }
            this.zzaBb.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzvZ() {
            zzwd();
            zzj(ConnectionResult.zzawX);
            zzwf();
            Iterator<zzabf> it = this.zzaBc.values().iterator();
            while (it.hasNext()) {
                it.next();
                try {
                    new TaskCompletionSource();
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(1);
                    this.zzazq.disconnect();
                } catch (RemoteException unused2) {
                }
            }
            zzwb();
            zzwg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzwa() {
            zzwd();
            this.zzaAm = true;
            this.zzaBa.zzvw();
            zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 7, this.zzaxH), zzaap.zzc(zzaap.this));
            zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 9, this.zzaxH), zzaap.zzd(zzaap.this));
            zzaap.zza(zzaap.this, -1);
        }

        @WorkerThread
        private void zzwb() {
            while (this.zzazq.isConnected() && !this.zzaAY.isEmpty()) {
                zzb(this.zzaAY.remove());
            }
        }

        @WorkerThread
        private void zzwf() {
            if (this.zzaAm) {
                zzaap.zza(zzaap.this).removeMessages(9, this.zzaxH);
                zzaap.zza(zzaap.this).removeMessages(7, this.zzaxH);
                this.zzaAm = false;
            }
        }

        private void zzwg() {
            zzaap.zza(zzaap.this).removeMessages(10, this.zzaxH);
            zzaap.zza(zzaap.this).sendMessageDelayed(zzaap.zza(zzaap.this).obtainMessage(10, this.zzaxH), zzaap.zzh(zzaap.this));
        }

        @WorkerThread
        public void connect() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzazq.isConnected() || this.zzazq.isConnecting()) {
                return;
            }
            if (this.zzazq.zzuI() && zzaap.zzi(zzaap.this) != 0) {
                zzaap.zza(zzaap.this, zzaap.zzg(zzaap.this).isGooglePlayServicesAvailable(zzaap.zzb(zzaap.this)));
                if (zzaap.zzi(zzaap.this) != 0) {
                    onConnectionFailed(new ConnectionResult(zzaap.zzi(zzaap.this), null));
                    return;
                }
            }
            zzb zzbVar = new zzb(this.zzazq, this.zzaxH);
            if (this.zzazq.zzqD()) {
                this.zzaBe.zza(zzbVar);
            }
            this.zzazq.zza(zzbVar);
        }

        public int getInstanceId() {
            return this.zzaBd;
        }

        boolean isConnected() {
            return this.zzazq.isConnected();
        }

        public void onConnected(@Nullable Bundle bundle) {
            if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper()) {
                zzvZ();
            } else {
                zzaap.zza(zzaap.this).post(new Runnable() { // from class: com.google.android.gms.internal.zzaap.zza.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zza.this.zzvZ();
                    }
                });
            }
        }

        @WorkerThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzaBe != null) {
                this.zzaBe.zzwr();
            }
            zzwd();
            zzaap.zza(zzaap.this, -1);
            zzj(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zzC(zzaap.zzvX());
            } else if (this.zzaAY.isEmpty()) {
                this.zzaBf = connectionResult;
            } else {
                synchronized (zzaap.zzvY()) {
                    if (zzaap.zze(zzaap.this) != null && zzaap.zzf(zzaap.this).contains(this.zzaxH)) {
                        zzaap.zze(zzaap.this).zzb(connectionResult, this.zzaBd);
                    } else if (zzaap.this.zzc(connectionResult, this.zzaBd)) {
                    } else {
                        if (connectionResult.getErrorCode() == 18) {
                            this.zzaAm = true;
                        }
                        if (this.zzaAm) {
                            zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 7, this.zzaxH), zzaap.zzc(zzaap.this));
                            return;
                        }
                        String valueOf = String.valueOf(this.zzaxH.zzuV());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
                        sb.append("API: ");
                        sb.append(valueOf);
                        sb.append(" is not available on this device.");
                        zzC(new Status(17, sb.toString()));
                    }
                }
            }
        }

        public void onConnectionSuspended(int i) {
            if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper()) {
                zzwa();
            } else {
                zzaap.zza(zzaap.this).post(new Runnable() { // from class: com.google.android.gms.internal.zzaap.zza.2
                    @Override // java.lang.Runnable
                    public void run() {
                        zza.this.zzwa();
                    }
                });
            }
        }

        @WorkerThread
        public void resume() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzaAm) {
                connect();
            }
        }

        @WorkerThread
        public void signOut() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            zzC(zzaap.zzaAO);
            this.zzaBa.zzvv();
            for (zzaaz.zzb<?> zzbVar : this.zzaBc.keySet()) {
                zza(new zzzq.zze(zzbVar, new TaskCompletionSource()));
            }
            this.zzazq.disconnect();
        }

        @WorkerThread
        public void zzC(Status status) {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            for (zzzq zzzqVar : this.zzaAY) {
                zzzqVar.zzy(status);
            }
            this.zzaAY.clear();
        }

        public void zza(final ConnectionResult connectionResult, Api<?> api, int i) {
            if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                zzaap.zza(zzaap.this).post(new Runnable() { // from class: com.google.android.gms.internal.zzaap.zza.3
                    @Override // java.lang.Runnable
                    public void run() {
                        zza.this.onConnectionFailed(connectionResult);
                    }
                });
            }
        }

        @WorkerThread
        public void zza(zzzq zzzqVar) {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzazq.isConnected()) {
                zzb(zzzqVar);
                zzwg();
                return;
            }
            this.zzaAY.add(zzzqVar);
            if (this.zzaBf == null || !this.zzaBf.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.zzaBf);
            }
        }

        @WorkerThread
        public void zzb(zzzu zzzuVar) {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            this.zzaBb.add(zzzuVar);
        }

        @WorkerThread
        public void zzi(@NonNull ConnectionResult connectionResult) {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            this.zzazq.disconnect();
            onConnectionFailed(connectionResult);
        }

        public boolean zzqD() {
            return this.zzazq.zzqD();
        }

        @WorkerThread
        public void zzvJ() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzaAm) {
                zzwf();
                zzC(zzaap.zzg(zzaap.this).isGooglePlayServicesAvailable(zzaap.zzb(zzaap.this)) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.zzazq.disconnect();
            }
        }

        public Api.zze zzvr() {
            return this.zzazq;
        }

        public Map<zzaaz.zzb<?>, zzabf> zzwc() {
            return this.zzaBc;
        }

        @WorkerThread
        public void zzwd() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            this.zzaBf = null;
        }

        @WorkerThread
        public ConnectionResult zzwe() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            return this.zzaBf;
        }

        @WorkerThread
        public void zzwh() {
            com.google.android.gms.common.internal.zzac.zza(zzaap.zza(zzaap.this));
            if (this.zzazq.isConnected() && this.zzaBc.size() == 0) {
                if (this.zzaBa.zzvu()) {
                    zzwg();
                } else {
                    this.zzazq.disconnect();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: assets/classes2.dex */
    public class zzb implements zzf.zzf, zzabj.zza {
        private final zzzs<?> zzaxH;
        private final Api.zze zzazq;
        private com.google.android.gms.common.internal.zzr zzazW = null;
        private Set<Scope> zzajm = null;
        private boolean zzaBj = false;

        public zzb(Api.zze zzeVar, zzzs<?> zzzsVar) {
            this.zzazq = zzeVar;
            this.zzaxH = zzzsVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzwi() {
            if (!this.zzaBj || this.zzazW == null) {
                return;
            }
            this.zzazq.zza(this.zzazW, this.zzajm);
        }

        @Override // com.google.android.gms.internal.zzabj.zza
        @WorkerThread
        public void zzb(com.google.android.gms.common.internal.zzr zzrVar, Set<Scope> set) {
            if (zzrVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zzi(new ConnectionResult(4));
                return;
            }
            this.zzazW = zzrVar;
            this.zzajm = set;
            zzwi();
        }

        public void zzg(@NonNull final ConnectionResult connectionResult) {
            zzaap.zza(zzaap.this).post(new Runnable() { // from class: com.google.android.gms.internal.zzaap.zzb.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!connectionResult.isSuccess()) {
                        ((zza) zzaap.zzj(zzaap.this).get(zzb.this.zzaxH)).onConnectionFailed(connectionResult);
                        return;
                    }
                    zzb.this.zzaBj = true;
                    if (zzb.this.zzazq.zzqD()) {
                        zzb.this.zzwi();
                    } else {
                        zzb.this.zzazq.zza((com.google.android.gms.common.internal.zzr) null, Collections.emptySet());
                    }
                }
            });
        }

        @Override // com.google.android.gms.internal.zzabj.zza
        @WorkerThread
        public void zzi(ConnectionResult connectionResult) {
            ((zza) zzaap.zzj(zzaap.this).get(this.zzaxH)).zzi(connectionResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaap(zzaan zzaanVar) {
        this.zzcmz = zzaanVar;
    }

    @Override // com.google.android.gms.internal.zzali
    public final void run() {
        this.zzcmz.zznk();
    }
}
