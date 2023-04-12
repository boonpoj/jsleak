package com.google.android.gms.internal;

import android.os.Process;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzph implements Runnable {
    private /* synthetic */ zzow zzbvt;
    private /* synthetic */ zzpg zzbvu;

    /* renamed from: com.google.android.gms.internal.zzph$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        AnonymousClass1(Runnable runnable) {
            this.zzWL = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: zzbl */
        public Void call() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        AnonymousClass2(Runnable runnable) {
            this.zzWL = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: zzbl */
        public Void call() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Callable zzWN;

        AnonymousClass3(zzqc zzqcVar, Callable callable) {
            this.zzWM = zzqcVar;
            this.zzWN = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(10);
                this.zzWM.zzh(this.zzWN.call());
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzv.zzcN().zza(e, "AdThreadPool.submit");
                this.zzWM.zze(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Future zzWO;

        AnonymousClass4(zzqc zzqcVar, Future future) {
            this.zzWM = zzqcVar;
            this.zzWO = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzWM.isCancelled()) {
                this.zzWO.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass5 implements ThreadFactory {
        private final AtomicInteger zzWP = new AtomicInteger(1);
        final /* synthetic */ String zzWQ;

        AnonymousClass5(String str) {
            this.zzWQ = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = this.zzWQ;
            int andIncrement = this.zzWP.getAndIncrement();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
            sb.append("AdWorker(");
            sb.append(str);
            sb.append(") #");
            sb.append(andIncrement);
            return new Thread(runnable, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzph(zzpg zzpgVar, zzow zzowVar) {
        this.zzbvu = zzpgVar;
        this.zzbvt = zzowVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzanh zzanhVar;
        View view;
        FrameLayout frameLayout;
        View view2;
        FrameLayout frameLayout2;
        View view3;
        FrameLayout frameLayout3;
        View view4;
        z = this.zzbvu.zzbvm;
        if (z) {
            view = this.zzbvu.zzbvl;
            if (view == null) {
                zzpg zzpgVar = this.zzbvu;
                frameLayout3 = zzpgVar.zzbvk;
                zzpgVar.zzbvl = new View(frameLayout3.getContext());
                view4 = this.zzbvu.zzbvl;
                view4.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            }
            frameLayout = this.zzbvu.zzbvk;
            view2 = this.zzbvu.zzbvl;
            if (frameLayout != view2.getParent()) {
                frameLayout2 = this.zzbvu.zzbvk;
                view3 = this.zzbvu.zzbvl;
                frameLayout2.addView(view3);
            }
        }
        try {
            zzanhVar = this.zzbvt.zzkg();
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbs.zzek();
            if (zzaht.zzqj()) {
                zzagf.zzcu("Privileged processes cannot create HTML overlays.");
            } else {
                zzagf.zzb("Error obtaining overlay.", e);
            }
            zzanhVar = null;
        }
        if (zzanhVar != null && this.zzbvu.zzamm != null) {
            FrameLayout frameLayout4 = this.zzbvu.zzamm;
            if (zzanhVar == null) {
                throw null;
            }
            frameLayout4.addView((View) zzanhVar);
        }
        this.zzbvu.zza(this.zzbvt);
    }
}
