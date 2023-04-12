package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaap;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.Thread;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzzq implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcmh;
    private /* synthetic */ zzzp zzcmi;

    /* loaded from: assets/classes2.dex */
    private static abstract class zza extends zzzq {
        protected final TaskCompletionSource<Void> zzayo;

        public zza(int i, TaskCompletionSource<Void> taskCompletionSource) {
            super(i);
            this.zzayo = taskCompletionSource;
        }

        public void zza(@NonNull zzaad zzaadVar, boolean z) {
        }

        public final void zza(zzaap.zza<?> zzaVar) throws DeadObjectException {
            try {
                zzb(zzaVar);
            } catch (DeadObjectException e) {
                zzy(zzzq.zzb(e));
                throw e;
            } catch (RemoteException e2) {
                zzy(zzzq.zzb(e2));
            }
        }

        protected abstract void zzb(zzaap.zza<?> zzaVar) throws RemoteException;

        public void zzy(@NonNull Status status) {
            this.zzayo.trySetException(new com.google.android.gms.common.api.zza(status));
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb<A extends zzzv.zza<? extends Result, Api.zzb>> extends zzzq {
        protected final A zzayp;

        public zzb(int i, A a) {
            super(i);
            this.zzayp = a;
        }

        public void zza(@NonNull zzaad zzaadVar, boolean z) {
            zzaadVar.zza(this.zzayp, z);
        }

        public void zza(zzaap.zza<?> zzaVar) throws DeadObjectException {
            this.zzayp.zzb(zzaVar.zzvr());
        }

        public void zzy(@NonNull Status status) {
            this.zzayp.zzA(status);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzc extends zza {
        public final zzabe<Api.zzb, ?> zzayq;
        public final zzabr<Api.zzb, ?> zzayr;

        public zzc(zzabf zzabfVar, TaskCompletionSource<Void> taskCompletionSource) {
            super(3, taskCompletionSource);
            this.zzayq = zzabfVar.zzayq;
            this.zzayr = zzabfVar.zzayr;
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public /* bridge */ /* synthetic */ void zza(@NonNull zzaad zzaadVar, boolean z) {
            super.zza(zzaadVar, z);
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public void zzb(zzaap.zza<?> zzaVar) throws RemoteException {
            if (this.zzayq.zzwp() != null) {
                zzaVar.zzwc().put(this.zzayq.zzwp(), new zzabf(this.zzayq, this.zzayr));
            }
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public /* bridge */ /* synthetic */ void zzy(@NonNull Status status) {
            super.zzy(status);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzd<TResult> extends zzzq {
        private final TaskCompletionSource<TResult> zzayo;
        private final zzabn<Api.zzb, TResult> zzays;
        private final zzabk zzayt;

        public zzd(int i, zzabn<Api.zzb, TResult> zzabnVar, TaskCompletionSource<TResult> taskCompletionSource, zzabk zzabkVar) {
            super(i);
            this.zzayo = taskCompletionSource;
            this.zzays = zzabnVar;
            this.zzayt = zzabkVar;
        }

        public void zza(@NonNull zzaad zzaadVar, boolean z) {
            zzaadVar.zza(this.zzayo, z);
        }

        public void zza(zzaap.zza<?> zzaVar) throws DeadObjectException {
            try {
                this.zzays.zza(zzaVar.zzvr(), this.zzayo);
            } catch (DeadObjectException e) {
                throw e;
            } catch (RemoteException e2) {
                zzy(zzzq.zzb(e2));
            }
        }

        public void zzy(@NonNull Status status) {
            this.zzayo.trySetException(this.zzayt.zzz(status));
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zze extends zza {
        public final zzaaz.zzb<?> zzayu;

        public zze(zzaaz.zzb<?> zzbVar, TaskCompletionSource<Void> taskCompletionSource) {
            super(4, taskCompletionSource);
            this.zzayu = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public /* bridge */ /* synthetic */ void zza(@NonNull zzaad zzaadVar, boolean z) {
            super.zza(zzaadVar, z);
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public void zzb(zzaap.zza<?> zzaVar) throws RemoteException {
            zzabf remove = zzaVar.zzwc().remove(this.zzayu);
            if (remove != null) {
                remove.zzayq.zzwq();
                return;
            }
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.zzayo.trySetException(new com.google.android.gms.common.api.zza(Status.zzayj));
        }

        @Override // com.google.android.gms.internal.zzzq.zza
        public /* bridge */ /* synthetic */ void zzy(@NonNull Status status) {
            super.zzy(status);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzq(zzzp zzzpVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzcmi = zzzpVar;
        this.zzcmh = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzcmi.zza(thread, th);
        } catch (Throwable th2) {
            try {
                zzakb.e("AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzcmh;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzcmh;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
