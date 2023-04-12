package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
final class zzbq extends AsyncTask<Void, Void, String> {
    private /* synthetic */ zzbm zzasj;

    private zzbq(zzbm zzbmVar) {
        this.zzasj = zzbmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbq(zzbm zzbmVar, zzbn zzbnVar) {
        this(zzbmVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzbm zzbmVar = this.zzasj;
            future = this.zzasj.zzase;
            zzbmVar.zzash = (zzcv) future.get(((Long) zzkb.zzif().zzd(zznh.zzbpu)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            zzagf.zzc("Failed to load ad data", e);
        } catch (ExecutionException e2) {
            e = e2;
            zzagf.zzc("Failed to load ad data", e);
        } catch (TimeoutException e3) {
            zzagf.zzcu("Timed out waiting for ad data");
        }
        return this.zzasj.zzdy();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.zzasj.zzasg;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.zzasj.zzasg;
        webView2.loadUrl(str2);
    }
}
