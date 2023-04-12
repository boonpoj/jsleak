package com.google.android.gms.internal;

import java.lang.Thread;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzzr implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ zzzp zzcmi;
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcmj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzr(zzzp zzzpVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzcmi = zzzpVar;
        this.zzcmj = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzcmi.zza(thread, th);
        } catch (Throwable th2) {
            try {
                zzakb.e("AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzcmj;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzcmj;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
