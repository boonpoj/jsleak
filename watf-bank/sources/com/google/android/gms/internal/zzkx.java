package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzkx extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzkx$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zzOH;
        final /* synthetic */ String zzOI;

        AnonymousClass1(String str, String str2) {
            this.zzOH = str;
            this.zzOI = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            final WebView zzij = zzkx.this.zzij();
            zzij.setWebViewClient(new WebViewClient() { // from class: com.google.android.gms.internal.zzkx.1.1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    zzpe.zzbc("Loading assets have finished");
                    zzkx.this.zzOG.remove(zzij);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    zzpe.zzbe("Loading assets have failed.");
                    zzkx.this.zzOG.remove(zzij);
                }
            });
            zzkx.this.zzOG.add(zzij);
            zzij.loadDataWithBaseURL(this.zzOH, this.zzOI, "text/html", "UTF-8", null);
            zzpe.zzbc("Fetching assets finished.");
        }
    }

    void onAppEvent(String str, String str2) throws RemoteException;
}
