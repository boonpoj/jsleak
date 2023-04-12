package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzfw extends ContentObserver {
    private /* synthetic */ zzft zzawn;

    /* renamed from: com.google.android.gms.internal.zzfw$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Callable<T> {
        final /* synthetic */ zzft zzAO;

        AnonymousClass1(zzft zzftVar) {
            this.zzAO = zzftVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public T call() {
            return this.zzAO.zza(zzfw.zza(zzfw.this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfw(zzft zzftVar, Handler handler) {
        super(handler);
        this.zzawn = zzftVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.zzawn.zzfx();
    }
}
