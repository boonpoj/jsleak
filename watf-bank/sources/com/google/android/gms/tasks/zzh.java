package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaaw;
import com.google.android.gms.internal.zzaax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: assets/classes2.dex */
public final class zzh<TResult> extends Task<TResult> {
    private boolean zzbLI;
    private TResult zzbLJ;
    private Exception zzbLK;
    private final Object zzrN = new Object();
    private final zzg<TResult> zzbLH = new zzg<>();

    /* loaded from: assets/classes2.dex */
    private static class zza extends zzaaw {
        private final List<WeakReference<zzf<?>>> mListeners;

        private zza(zzaax zzaaxVar) {
            super(zzaaxVar);
            this.mListeners = new ArrayList();
            this.zzaBs.zza("TaskOnStopCallback", this);
        }

        public static zza zzw(Activity activity) {
            zzaax zzs = zzs(activity);
            zza zzaVar = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zzaVar == null ? new zza(zzs) : zzaVar;
        }

        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference<zzf<?>> weakReference : this.mListeners) {
                    zzf<?> zzfVar = weakReference.get();
                    if (zzfVar != null) {
                        zzfVar.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzfVar) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference<>(zzfVar));
            }
        }
    }

    private void zzSe() {
        zzac.zza(this.zzbLI, "Task is not yet complete");
    }

    private void zzSf() {
        zzac.zza(!this.zzbLI, "Task is already complete");
    }

    private void zzSg() {
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                this.zzbLH.zza(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzcVar = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzbLH.zza(zzcVar);
        zza.zzw(activity).zzb(zzcVar);
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzbLH.zza(new zzc(executor, onCompleteListener));
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzdVar = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzbLH.zza(zzdVar);
        zza.zzw(activity).zzb(zzdVar);
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzbLH.zza(new zzd(executor, onFailureListener));
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zzeVar = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzbLH.zza(zzeVar);
        zza.zzw(activity).zzb(zzeVar);
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbLH.zza(new zze(executor, onSuccessListener));
        zzSg();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzhVar = new zzh();
        this.zzbLH.zza(new com.google.android.gms.tasks.zza(executor, continuation, zzhVar));
        zzSg();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzhVar = new zzh();
        this.zzbLH.zza(new zzb(executor, continuation, zzhVar));
        zzSg();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzrN) {
            exc = this.zzbLK;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzrN) {
            zzSe();
            if (this.zzbLK != null) {
                throw new RuntimeExecutionException(this.zzbLK);
            }
            tresult = this.zzbLJ;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzrN) {
            zzSe();
            if (cls.isInstance(this.zzbLK)) {
                throw cls.cast(this.zzbLK);
            }
            if (this.zzbLK != null) {
                throw new RuntimeExecutionException(this.zzbLK);
            }
            tresult = this.zzbLJ;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzbLI;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzbLI && this.zzbLK == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzac.zzb(exc, "Exception must not be null");
        synchronized (this.zzrN) {
            zzSf();
            this.zzbLI = true;
            this.zzbLK = exc;
        }
        this.zzbLH.zza(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzrN) {
            zzSf();
            this.zzbLI = true;
            this.zzbLJ = tresult;
        }
        this.zzbLH.zza(this);
    }

    public boolean trySetException(@NonNull Exception exc) {
        zzac.zzb(exc, "Exception must not be null");
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                return false;
            }
            this.zzbLI = true;
            this.zzbLK = exc;
            this.zzbLH.zza(this);
            return true;
        }
    }

    public boolean trySetResult(TResult tresult) {
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                return false;
            }
            this.zzbLI = true;
            this.zzbLJ = tresult;
            this.zzbLH.zza(this);
            return true;
        }
    }
}
