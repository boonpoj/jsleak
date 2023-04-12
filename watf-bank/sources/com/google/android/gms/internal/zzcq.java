package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzcq implements Runnable {
    private /* synthetic */ zzcp zzagw;

    /* renamed from: com.google.android.gms.internal.zzcq$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zzcq.this.zzk(3);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zza implements zzcx {
        private WeakReference<zzgu> zzws;

        public zza(zzgu zzguVar) {
            this.zzws = new WeakReference<>(zzguVar);
        }

        @Nullable
        public View zzdO() {
            zzgu zzguVar = this.zzws.get();
            if (zzguVar != null) {
                return zzguVar.zzfV();
            }
            return null;
        }

        public boolean zzdP() {
            return this.zzws.get() == null;
        }

        public zzcx zzdQ() {
            return new zzb(this.zzws.get());
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb implements zzcx {
        private zzgu zzwt;

        public zzb(zzgu zzguVar) {
            this.zzwt = zzguVar;
        }

        public View zzdO() {
            if (this.zzwt != null) {
                return this.zzwt.zzfV();
            }
            return null;
        }

        public boolean zzdP() {
            return this.zzwt == null;
        }

        public zzcx zzdQ() {
            return this;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzc implements zzcx {
        @Nullable
        private final View mView;
        @Nullable
        private final zzov zzwu;

        public zzc(View view, zzov zzovVar) {
            this.mView = view;
            this.zzwu = zzovVar;
        }

        public View zzdO() {
            return this.mView;
        }

        public boolean zzdP() {
            return this.zzwu == null || this.mView == null;
        }

        public zzcx zzdQ() {
            return this;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzd implements zzcx {
        private final WeakReference<View> zzwv;
        private final WeakReference<zzov> zzww;

        public zzd(View view, zzov zzovVar) {
            this.zzwv = new WeakReference<>(view);
            this.zzww = new WeakReference<>(zzovVar);
        }

        public View zzdO() {
            return this.zzwv.get();
        }

        public boolean zzdP() {
            return this.zzwv.get() == null || this.zzww.get() == null;
        }

        public zzcx zzdQ() {
            return new zzc(this.zzwv.get(), this.zzww.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcq(zzcp zzcpVar) {
        this.zzagw = zzcpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        zzdm zzdmVar;
        ConditionVariable conditionVariable2;
        if (this.zzagw.zzagu != null) {
            return;
        }
        conditionVariable = zzcp.zzags;
        synchronized (conditionVariable) {
            if (this.zzagw.zzagu != null) {
                return;
            }
            boolean booleanValue = ((Boolean) zzkb.zzif().zzd(zznh.zzbnk)).booleanValue();
            if (booleanValue) {
                try {
                    zzdmVar = this.zzagw.zzagr;
                    zzcp.zzagt = new zzix(zzdmVar.zzair, "ADSHIELD", null);
                } catch (Throwable th) {
                    booleanValue = false;
                }
            }
            this.zzagw.zzagu = Boolean.valueOf(booleanValue);
            conditionVariable2 = zzcp.zzags;
            conditionVariable2.open();
        }
    }
}
