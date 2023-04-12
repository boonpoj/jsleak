package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzcw extends Exception {

    /* renamed from: com.google.android.gms.internal.zzcw$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zza {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Bundle zzxd;

        AnonymousClass1(zzcw zzcwVar, Activity activity, Bundle bundle) {
            this.val$activity = activity;
            this.zzxd = bundle;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzxd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zza {
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(zzcw zzcwVar, Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStarted(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zza {
        final /* synthetic */ Activity val$activity;

        AnonymousClass3(zzcw zzcwVar, Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityResumed(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements zza {
        final /* synthetic */ Activity val$activity;

        AnonymousClass4(zzcw zzcwVar, Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityPaused(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements zza {
        final /* synthetic */ Activity val$activity;

        AnonymousClass5(zzcw zzcwVar, Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStopped(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 implements zza {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Bundle zzxd;

        AnonymousClass6(zzcw zzcwVar, Activity activity, Bundle bundle) {
            this.val$activity = activity;
            this.zzxd = bundle;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzxd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass7 implements zza {
        final /* synthetic */ Activity val$activity;

        AnonymousClass7(zzcw zzcwVar, Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzcw.zza
        public void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);
    }

    public zzcw() {
    }

    public zzcw(String str) {
        super(str);
    }
}
