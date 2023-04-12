package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import android.view.View;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzgy implements zzhc {
    private /* synthetic */ Activity val$activity;

    /* renamed from: com.google.android.gms.internal.zzgy$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzgv zzGO;

        AnonymousClass1(zzgv zzgvVar) {
            this.zzGO = zzgvVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzqp zzfU = this.zzGO.zzfU();
            if (zzfU != null && zzgy.zza(zzgy.this) != null) {
                zzgy.zza(zzgy.this).addView(zzfU.getView());
            }
            if (this.zzGO instanceof zzgt) {
                return;
            }
            zzgy.zza(zzgy.this, this.zzGO);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgy$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzgs {
        final /* synthetic */ View zzGQ;

        AnonymousClass2(View view) {
            this.zzGQ = view;
        }

        public void zzc(MotionEvent motionEvent) {
            zzgy.this.onTouch(null, motionEvent);
        }

        public void zzfR() {
            zzgy.this.onClick(this.zzGQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgy(zzgu zzguVar, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzhc
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
