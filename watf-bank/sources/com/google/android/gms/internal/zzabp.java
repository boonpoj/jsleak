package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzabp implements Runnable {
    private /* synthetic */ zzafp zzanv;
    private /* synthetic */ zzabo zzcqn;

    /* renamed from: com.google.android.gms.internal.zzabp$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Result zzaBT;

        AnonymousClass1(Result result) {
            this.zzaBT = result;
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            GoogleApiClient googleApiClient;
            try {
                try {
                    zzzx.zzayN.set(true);
                    zzabp.zzd(zzabp.this).sendMessage(zzabp.zzd(zzabp.this).obtainMessage(0, zzabp.zzc(zzabp.this).onSuccess(this.zzaBT)));
                    zzzx.zzayN.set(false);
                    zzabp.zza(zzabp.this, this.zzaBT);
                    googleApiClient = (GoogleApiClient) zzabp.zze(zzabp.this).get();
                    if (googleApiClient == null) {
                        return;
                    }
                } catch (RuntimeException e) {
                    zzabp.zzd(zzabp.this).sendMessage(zzabp.zzd(zzabp.this).obtainMessage(1, e));
                    zzzx.zzayN.set(false);
                    zzabp.zza(zzabp.this, this.zzaBT);
                    googleApiClient = (GoogleApiClient) zzabp.zze(zzabp.this).get();
                    if (googleApiClient == null) {
                        return;
                    }
                }
                googleApiClient.zzb(zzabp.this);
            } catch (Throwable th) {
                zzzx.zzayN.set(false);
                zzabp.zza(zzabp.this, this.zzaBT);
                GoogleApiClient googleApiClient2 = (GoogleApiClient) zzabp.zze(zzabp.this).get();
                if (googleApiClient2 != null) {
                    googleApiClient2.zzb(zzabp.this);
                }
                throw th;
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    zzabh zzabhVar = (PendingResult) message.obj;
                    synchronized (zzabp.zzf(zzabp.this)) {
                        try {
                            if (zzabhVar == null) {
                                zzabp.zza(zzabp.zzg(zzabp.this), new Status(13, "Transform returned null"));
                            } else if (zzabhVar instanceof zzabh) {
                                zzabp.zza(zzabp.zzg(zzabp.this), zzabhVar.getStatus());
                            } else {
                                zzabp.zzg(zzabp.this).zza(zzabhVar);
                            }
                        } finally {
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                    throw runtimeException;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(70);
                    sb.append("TransformationResultHandler received unknown message type: ");
                    sb.append(i);
                    Log.e("TransformedResultImpl", sb.toString());
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabp(zzabo zzaboVar, zzafp zzafpVar) {
        this.zzcqn = zzaboVar;
        this.zzanv = zzafpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzzx zzzxVar;
        com.google.android.gms.ads.internal.js.zzaa zzaaVar;
        com.google.android.gms.ads.internal.js.zzaa zzaaVar2;
        zzzxVar = this.zzcqn.zzcmm;
        zzzxVar.zza(this.zzanv);
        zzaaVar = this.zzcqn.zzcqm;
        if (zzaaVar != null) {
            zzaaVar2 = this.zzcqn.zzcqm;
            zzaaVar2.release();
            this.zzcqn.zzcqm = null;
        }
    }
}
