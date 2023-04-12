package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzzx {

    /* renamed from: com.google.android.gms.internal.zzzx$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends ThreadLocal<Boolean> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: zzvg */
        public Boolean initialValue() {
            return false;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzzx) message.obj).zzB(Status.zzayk);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzzx<R> zzzxVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzzxVar), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzzx.zzd(r);
                throw e;
            }
        }

        public void zzvh() {
            removeMessages(2);
        }
    }

    /* loaded from: assets/classes2.dex */
    private final class zzb {
        private zzb() {
        }

        /* synthetic */ zzb(zzzx zzzxVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        protected void finalize() throws Throwable {
            zzzx.zzd(zzzx.zza(zzzx.this));
            super.finalize();
        }
    }

    void zza(zzafp zzafpVar);
}
