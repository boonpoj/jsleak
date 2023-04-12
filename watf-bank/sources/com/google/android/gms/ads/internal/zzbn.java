package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zznh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbn extends WebViewClient {
    private /* synthetic */ zzbm zzasj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbm zzbmVar) {
        this.zzasj = zzbmVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzkh zzkhVar;
        zzkh zzkhVar2;
        zzkhVar = this.zzasj.zzape;
        if (zzkhVar != null) {
            try {
                zzkhVar2 = this.zzasj.zzape;
                zzkhVar2.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzkh zzkhVar;
        zzkh zzkhVar2;
        String zzw;
        zzkh zzkhVar3;
        zzkh zzkhVar4;
        zzkh zzkhVar5;
        zzkh zzkhVar6;
        zzkh zzkhVar7;
        zzkh zzkhVar8;
        if (str.startsWith(this.zzasj.zzdz())) {
            return false;
        }
        if (str.startsWith((String) zzkb.zzif().zzd(zznh.zzbpp))) {
            zzkhVar7 = this.zzasj.zzape;
            if (zzkhVar7 != null) {
                try {
                    zzkhVar8 = this.zzasj.zzape;
                    zzkhVar8.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzagf.zzc("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
            this.zzasj.zzk(0);
            return true;
        }
        if (str.startsWith((String) zzkb.zzif().zzd(zznh.zzbpq))) {
            zzkhVar5 = this.zzasj.zzape;
            if (zzkhVar5 != null) {
                try {
                    zzkhVar6 = this.zzasj.zzape;
                    zzkhVar6.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzagf.zzc("Could not call AdListener.onAdFailedToLoad().", e2);
                }
            }
            this.zzasj.zzk(0);
            return true;
        }
        if (str.startsWith((String) zzkb.zzif().zzd(zznh.zzbpr))) {
            zzkhVar3 = this.zzasj.zzape;
            if (zzkhVar3 != null) {
                try {
                    zzkhVar4 = this.zzasj.zzape;
                    zzkhVar4.onAdLoaded();
                } catch (RemoteException e3) {
                    zzagf.zzc("Could not call AdListener.onAdLoaded().", e3);
                }
            }
            this.zzasj.zzk(this.zzasj.zzv(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzkhVar = this.zzasj.zzape;
            if (zzkhVar != null) {
                try {
                    zzkhVar2 = this.zzasj.zzape;
                    zzkhVar2.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzagf.zzc("Could not call AdListener.onAdLeftApplication().", e4);
                }
            }
            zzw = this.zzasj.zzw(str);
            this.zzasj.zzx(zzw);
            return true;
        }
    }
}
