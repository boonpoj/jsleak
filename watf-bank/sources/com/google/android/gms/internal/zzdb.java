package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdb implements zzdi {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Bundle zzail;

    /* renamed from: com.google.android.gms.internal.zzdb$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View zzxN;

        AnonymousClass1(View view) {
            this.zzxN = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzdb.this.zzi(this.zzxN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.internal.zzdb$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public class AnonymousClass2 implements Runnable {
        ValueCallback<String> zzxP = new ValueCallback<String>() { // from class: com.google.android.gms.internal.zzdb.2.1
            @Override // android.webkit.ValueCallback
            /* renamed from: zzE */
            public void onReceiveValue(String str) {
                zzdb.this.zza(AnonymousClass2.this.zzxQ, AnonymousClass2.this.zzxR, str, AnonymousClass2.this.zzxS);
            }
        };
        final /* synthetic */ zzcy zzxQ;
        final /* synthetic */ WebView zzxR;
        final /* synthetic */ boolean zzxS;

        AnonymousClass2(zzcy zzcyVar, WebView webView, boolean z) {
            this.zzxQ = zzcyVar;
            this.zzxR = webView;
            this.zzxS = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzxR.getSettings().getJavaScriptEnabled()) {
                try {
                    this.zzxR.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzxP);
                } catch (Throwable unused) {
                    this.zzxP.onReceiveValue("");
                }
            }
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    class zza {
        final int zzxU;
        final int zzxV;

        zza(zzdb zzdbVar, int i, int i2) {
            this.zzxU = i;
            this.zzxV = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdb(zzda zzdaVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzail = bundle;
    }

    @Override // com.google.android.gms.internal.zzdi
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzail);
    }
}
