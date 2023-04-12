package com.google.android.gms.internal;

import android.content.Context;
import java.lang.Thread;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzlz implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzly zzbgq;

    /* renamed from: com.google.android.gms.internal.zzlz$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler zzQN;

        AnonymousClass1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.zzQN = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                try {
                    zzlz.this.zza(thread, th);
                } catch (Throwable unused) {
                    zzpe.e("AdMob exception reporter failed reporting the exception.");
                    if (this.zzQN == null) {
                    }
                }
            } finally {
                if (this.zzQN != null) {
                    this.zzQN.uncaughtException(thread, th);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlz$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler zzQP;

        AnonymousClass2(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.zzQP = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                try {
                    zzlz.this.zza(thread, th);
                } catch (Throwable unused) {
                    zzpe.e("AdMob exception reporter failed reporting the exception.");
                    if (this.zzQP == null) {
                    }
                }
            } finally {
                if (this.zzQP != null) {
                    this.zzQP.uncaughtException(thread, th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(zzly zzlyVar, Context context) {
        this.zzbgq = zzlyVar;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbgq.getRewardedVideoAdInstance(this.val$context);
    }
}
