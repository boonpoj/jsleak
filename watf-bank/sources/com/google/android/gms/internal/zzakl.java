package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public final class zzakl {
    public static <V> zzakv<V> zza(zzakv<V> zzakvVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final zzalf zzalfVar = new zzalf();
        zza((zzakv) zzalfVar, (Future) zzakvVar);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(zzalfVar) { // from class: com.google.android.gms.internal.zzakp
            private final zzalf zzbzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbzb = zzalfVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzbzb.setException(new TimeoutException());
            }
        }, j, timeUnit);
        zza((zzakv) zzakvVar, zzalfVar);
        zzalfVar.zza(new Runnable(schedule) { // from class: com.google.android.gms.internal.zzakq
            private final Future zzdet;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdet = schedule;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Future future = this.zzdet;
                if (future.isDone()) {
                    return;
                }
                future.cancel(true);
            }
        }, zzala.zzdff);
        return zzalfVar;
    }

    public static <A, B> zzakv<B> zza(final zzakv<A> zzakvVar, final zzakg<? super A, ? extends B> zzakgVar, Executor executor) {
        final zzalf zzalfVar = new zzalf();
        zzakvVar.zza(new Runnable(zzalfVar, zzakgVar, zzakvVar) { // from class: com.google.android.gms.internal.zzako
            private final zzalf zzbzb;
            private final zzakv zzder;
            private final zzakg zzdes;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbzb = zzalfVar;
                this.zzdes = zzakgVar;
                this.zzder = zzakvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzakl.zza(this.zzbzb, this.zzdes, this.zzder);
            }
        }, executor);
        zza((zzakv) zzalfVar, (Future) zzakvVar);
        return zzalfVar;
    }

    public static <A, B> zzakv<B> zza(final zzakv<A> zzakvVar, final zzakh<A, B> zzakhVar, Executor executor) {
        final zzalf zzalfVar = new zzalf();
        zzakvVar.zza(new Runnable(zzalfVar, zzakhVar, zzakvVar) { // from class: com.google.android.gms.internal.zzakn
            private final zzalf zzbzb;
            private final zzakh zzdeq;
            private final zzakv zzder;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbzb = zzalfVar;
                this.zzdeq = zzakhVar;
                this.zzder = zzakvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzalf zzalfVar2 = this.zzbzb;
                try {
                    zzalfVar2.set(this.zzdeq.apply(this.zzder.get()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    zzalfVar2.setException(e);
                } catch (CancellationException e2) {
                    zzalfVar2.cancel(true);
                } catch (ExecutionException e3) {
                    e = e3;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzalfVar2.setException(e);
                } catch (Exception e4) {
                    zzalfVar2.setException(e4);
                }
            }
        }, executor);
        zza((zzakv) zzalfVar, (Future) zzakvVar);
        return zzalfVar;
    }

    public static <V, X extends Throwable> zzakv<V> zza(final zzakv<? extends V> zzakvVar, final Class<X> cls, final zzakg<? super X, ? extends V> zzakgVar, final Executor executor) {
        final zzalf zzalfVar = new zzalf();
        zza((zzakv) zzalfVar, (Future) zzakvVar);
        zzakvVar.zza(new Runnable(zzalfVar, zzakvVar, cls, zzakgVar, executor) { // from class: com.google.android.gms.internal.zzakr
            private final zzalf zzbzb;
            private final zzakv zzdep;
            private final Class zzdeu;
            private final zzakg zzdev;
            private final Executor zzdew;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbzb = zzalfVar;
                this.zzdep = zzakvVar;
                this.zzdeu = cls;
                this.zzdev = zzakgVar;
                this.zzdew = executor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzakl.zza(this.zzbzb, this.zzdep, this.zzdeu, this.zzdev, this.zzdew);
            }
        }, zzala.zzdff);
        return zzalfVar;
    }

    public static <T> T zza(Future<T> future, T t) {
        try {
            return future.get(((Long) zzkb.zzif().zzd(zznh.zzbnh)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            future.cancel(true);
            zzagf.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            e = e2;
            future.cancel(true);
            zzagf.zzb("Error waiting for future.", e);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T zza(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            future.cancel(true);
            zzagf.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            e = e2;
            future.cancel(true);
            zzagf.zzb("Error waiting for future.", e);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "Futures.resolveFuture");
            return t;
        }
    }

    public static <V> void zza(final zzakv<V> zzakvVar, final zzaki<V> zzakiVar, Executor executor) {
        zzakvVar.zza(new Runnable(zzakiVar, zzakvVar) { // from class: com.google.android.gms.internal.zzakm
            private final zzaki zzdeo;
            private final zzakv zzdep;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdeo = zzakiVar;
                this.zzdep = zzakvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaki zzakiVar2 = this.zzdeo;
                try {
                    zzakiVar2.onSuccess(this.zzdep.get());
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    zzakiVar2.zzb(e);
                } catch (ExecutionException e2) {
                    e = e2.getCause();
                    zzakiVar2.zzb(e);
                } catch (Exception e3) {
                    e = e3;
                    zzakiVar2.zzb(e);
                }
            }
        }, executor);
    }

    private static <V> void zza(final zzakv<? extends V> zzakvVar, final zzalf<V> zzalfVar) {
        zza((zzakv) zzalfVar, (Future) zzakvVar);
        zzakvVar.zza(new Runnable(zzalfVar, zzakvVar) { // from class: com.google.android.gms.internal.zzaks
            private final zzalf zzbzb;
            private final zzakv zzdep;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbzb = zzalfVar;
                this.zzdep = zzakvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Throwable e;
                zzalf zzalfVar2 = this.zzbzb;
                try {
                    zzalfVar2.set(this.zzdep.get());
                } catch (InterruptedException e2) {
                    e = e2;
                    Thread.currentThread().interrupt();
                    zzalfVar2.setException(e);
                } catch (ExecutionException e3) {
                    e = e3.getCause();
                    zzalfVar2.setException(e);
                } catch (Exception e4) {
                    zzalfVar2.setException(e4);
                }
            }
        }, zzala.zzdff);
    }

    private static <A, B> void zza(final zzakv<A> zzakvVar, final Future<B> future) {
        zzakvVar.zza(new Runnable(zzakvVar, future) { // from class: com.google.android.gms.internal.zzakt
            private final Future zzbzc;
            private final zzakv zzdex;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdex = zzakvVar;
                this.zzbzc = future;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzakv zzakvVar2 = this.zzdex;
                Future future2 = this.zzbzc;
                if (zzakvVar2.isCancelled()) {
                    future2.cancel(true);
                }
            }
        }, zzala.zzdff);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzalf zzalfVar, zzakg zzakgVar, zzakv zzakvVar) {
        if (zzalfVar.isCancelled()) {
            return;
        }
        try {
            zza(zzakgVar.zzc(zzakvVar.get()), zzalfVar);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzalfVar.setException(e);
        } catch (CancellationException e2) {
            zzalfVar.cancel(true);
        } catch (ExecutionException e3) {
            zzalfVar.setException(e3.getCause());
        } catch (Exception e4) {
            zzalfVar.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void zza(com.google.android.gms.internal.zzalf r1, com.google.android.gms.internal.zzakv r2, java.lang.Class r3, com.google.android.gms.internal.zzakg r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            r1.set(r2)     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            return
        L8:
            r2 = move-exception
            goto L18
        La:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L18
        L13:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L18:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L2a
            com.google.android.gms.internal.zzaku r2 = zzi(r2)
            com.google.android.gms.internal.zzakv r2 = zza(r2, r4, r5)
            zza(r2, r1)
            return
        L2a:
            r1.setException(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzakl.zza(com.google.android.gms.internal.zzalf, com.google.android.gms.internal.zzakv, java.lang.Class, com.google.android.gms.internal.zzakg, java.util.concurrent.Executor):void");
    }

    public static <T> zzaku<T> zzi(T t) {
        return new zzaku<>(t);
    }
}
