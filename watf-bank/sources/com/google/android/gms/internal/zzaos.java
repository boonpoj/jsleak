package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public class zzaos extends zzani {
    public zzaos(zzanh zzanhVar, boolean z) {
        super(zzanhVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        if (!(webView instanceof zzanh)) {
            zzagf.zzcu("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzanh zzanhVar = (zzanh) webView;
        if (this.zzaoq != null) {
            this.zzaoq.zza(str, map, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (zzanhVar.zzsz() != null) {
                zzanhVar.zzsz().zzmv();
            }
            String str2 = (String) zzkb.zzif().zzd(zzanhVar.zzsx().zzuh() ? zznh.zzbjk : zzanhVar.zztc() ? zznh.zzbjj : zznh.zzbji);
            try {
                Context context = zzanhVar.getContext();
                String str3 = zzanhVar.zzsk().zzcv;
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzbs.zzei().zzp(context, str3));
                hashMap.put("Cache-Control", "max-stale=3600");
                String str4 = new zzaiv(context).zzb(str2, hashMap).get(60L, TimeUnit.SECONDS);
                if (str4 == null) {
                    return null;
                }
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str4.getBytes("UTF-8")));
            } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzagf.zzcu(valueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(valueOf) : new String("Could not fetch MRAID JS. "));
                return null;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
