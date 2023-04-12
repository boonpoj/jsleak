package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.internal.zzaar;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzaal {

    /* renamed from: com.google.android.gms.internal.zzaal$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzm.zza {
        AnonymousClass1() {
        }

        public boolean isConnected() {
            return zzaal.this.isConnected();
        }

        public Bundle zzud() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaal$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements GoogleApiClient.ConnectionCallbacks {
        final /* synthetic */ AtomicReference zzaAA;
        final /* synthetic */ zzabl zzaAB;

        AnonymousClass2(AtomicReference atomicReference, zzabl zzablVar) {
            this.zzaAA = atomicReference;
            this.zzaAB = zzablVar;
        }

        public void onConnected(Bundle bundle) {
            zzaal.zza(zzaal.this, (GoogleApiClient) this.zzaAA.get(), this.zzaAB, true);
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaal$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements GoogleApiClient.OnConnectionFailedListener {
        final /* synthetic */ zzabl zzaAB;

        AnonymousClass3(zzaal zzaalVar, zzabl zzablVar) {
            this.zzaAB = zzablVar;
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            this.zzaAB.zzb(new Status(8));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaal$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements ResultCallback<Status> {
        final /* synthetic */ zzabl zzaAB;
        final /* synthetic */ boolean zzaAC;
        final /* synthetic */ GoogleApiClient zzaob;

        AnonymousClass4(zzabl zzablVar, boolean z, GoogleApiClient googleApiClient) {
            this.zzaAB = zzablVar;
            this.zzaAC = z;
            this.zzaob = googleApiClient;
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        /* renamed from: zzp */
        public void onResult(@NonNull Status status) {
            com.google.android.gms.auth.api.signin.internal.zzl.zzaa(zzaal.zzc(zzaal.this)).zzre();
            if (status.isSuccess() && zzaal.this.isConnected()) {
                zzaal.this.reconnect();
            }
            this.zzaAB.zzb(status);
            if (this.zzaAC) {
                this.zzaob.disconnect();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzaal.zzb(zzaal.this);
                    return;
                case 2:
                    zzaal.zza(zzaal.this);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Unknown message id: ");
                    sb.append(i);
                    Log.w("GoogleApiClientImpl", sb.toString());
                    return;
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    static class zzb extends zzaar.zza {
        private WeakReference<zzaal> zzaAD;

        zzb(zzaal zzaalVar) {
            this.zzaAD = new WeakReference<>(zzaalVar);
        }

        @Override // com.google.android.gms.internal.zzaar.zza
        public void zzvb() {
            zzaal zzaalVar = this.zzaAD.get();
            if (zzaalVar == null) {
                return;
            }
            zzaal.zza(zzaalVar);
        }
    }

    void zza(zzaax zzaaxVar);
}
