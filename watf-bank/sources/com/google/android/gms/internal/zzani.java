package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.mopub.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
@zzzv
/* loaded from: classes.dex */
public class zzani extends WebViewClient {
    private static final String[] zzdkm = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzdkn = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object mLock;
    protected zzafb zzaoq;
    private boolean zzavo;
    private zzje zzbdd;
    private com.google.android.gms.ads.internal.gmsg.zzb zzbwv;
    private com.google.android.gms.ads.internal.gmsg.zzx zzbyc;
    private com.google.android.gms.ads.internal.zzw zzbye;
    private zzwr zzbyf;
    private com.google.android.gms.ads.internal.overlay.zzq zzbyi;
    private com.google.android.gms.ads.internal.overlay.zzn zzbyj;
    protected zzanh zzbyk;
    private zzxc zzcgu;
    private final HashMap<String, List<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>>> zzckd;
    private zzanm zzdko;
    private zzann zzdkp;
    private zzano zzdkq;
    private boolean zzdkr;
    private boolean zzdks;
    private ViewTreeObserver.OnGlobalLayoutListener zzdkt;
    private ViewTreeObserver.OnScrollChangedListener zzdku;
    private boolean zzdkv;
    private final zzxa zzdkw;
    private zzanq zzdkx;
    private boolean zzdky;
    private boolean zzdkz;
    private boolean zzdla;
    private int zzdlb;
    private View.OnAttachStateChangeListener zzdlc;

    public zzani(zzanh zzanhVar, boolean z) {
        this(zzanhVar, z, new zzxa(zzanhVar, zzanhVar.zzsu(), new zzmt(zzanhVar.getContext())), null);
    }

    private zzani(zzanh zzanhVar, boolean z, zzxa zzxaVar, zzwr zzwrVar) {
        this.zzckd = new HashMap<>();
        this.mLock = new Object();
        this.zzdkr = false;
        this.zzbyk = zzanhVar;
        this.zzavo = z;
        this.zzdkw = zzxaVar;
        this.zzbyf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzafb zzafbVar, int i) {
        if (!zzafbVar.zzol() || i <= 0) {
            return;
        }
        zzafbVar.zzq(view);
        if (zzafbVar.zzol()) {
            zzahn.zzdaw.postDelayed(new zzanj(this, view, zzafbVar, i), 100L);
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzwr zzwrVar = this.zzbyf;
        boolean zzmr = zzwrVar != null ? zzwrVar.zzmr() : false;
        com.google.android.gms.ads.internal.zzbs.zzeg();
        com.google.android.gms.ads.internal.overlay.zzl.zza(this.zzbyk.getContext(), adOverlayInfoParcel, !zzmr);
        if (this.zzaoq != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzciv != null) {
                str = adOverlayInfoParcel.zzciv.url;
            }
            this.zzaoq.zzbv(str);
        }
    }

    private final void zzd(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbmu)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    com.google.android.gms.ads.internal.zzbs.zzei().zza(context, this.zzbyk.zzsk().zzcv, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            com.google.android.gms.ads.internal.zzbs.zzei().zza(context, this.zzbyk.zzsk().zzcv, "gmob-apps", bundle, true);
        }
    }

    private final WebResourceResponse zzdb(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        String zzci;
        String zzcj;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i > 20) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setReadTimeout(10000);
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("Invalid protocol.");
            }
            httpURLConnection = (HttpURLConnection) openConnection;
            com.google.android.gms.ads.internal.zzbs.zzei().zza(this.zzbyk.getContext(), this.zzbyk.zzsk().zzcv, false, httpURLConnection);
            zzajv zzajvVar = new zzajv();
            zzajvVar.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzci = zzahn.zzci(httpURLConnection.getContentType());
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzcj = zzahn.zzcj(httpURLConnection.getContentType());
            zzajvVar.zza(httpURLConnection, responseCode);
            if (responseCode < 300 || responseCode >= 400) {
                break;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                throw new IOException("Missing Location header in redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (protocol == null) {
                zzagf.zzcu("Protocol is null");
                return null;
            } else if (!protocol.equals(Constants.HTTP) && !protocol.equals(Constants.HTTPS)) {
                String valueOf = String.valueOf(protocol);
                zzagf.zzcu(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
                return null;
            } else {
                String valueOf2 = String.valueOf(headerField);
                zzagf.zzbx(valueOf2.length() != 0 ? "Redirecting to ".concat(valueOf2) : new String("Redirecting to "));
                httpURLConnection.disconnect();
                url = url2;
            }
        }
        return new WebResourceResponse(zzci, zzcj, httpURLConnection.getInputStream());
    }

    private final void zzh(Uri uri) {
        String path = uri.getPath();
        List<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>> list = this.zzckd.get(path);
        if (list == null) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(valueOf);
            zzagf.v(sb.toString());
            return;
        }
        com.google.android.gms.ads.internal.zzbs.zzei();
        Map<String, String> zzf = zzahn.zzf(uri);
        if (zzagf.zzae(2)) {
            String valueOf2 = String.valueOf(path);
            zzagf.v(valueOf2.length() != 0 ? "Received GMSG: ".concat(valueOf2) : new String("Received GMSG: "));
            for (String str : zzf.keySet()) {
                String str2 = zzf.get(str);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                sb2.append("  ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                zzagf.v(sb2.toString());
            }
        }
        for (com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar : list) {
            zztVar.zza(this.zzbyk, zzf);
        }
    }

    private final void zzts() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzdlc;
        if (onAttachStateChangeListener == null) {
            return;
        }
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar == null) {
            throw null;
        }
        ((View) zzanhVar).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private final void zztx() {
        if (this.zzdko != null && ((this.zzdkz && this.zzdlb <= 0) || this.zzdla)) {
            this.zzdko.zza(this.zzbyk, !this.zzdla);
            this.zzdko = null;
        }
        this.zzbyk.zzti();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzagf.v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.mLock) {
            if (this.zzdky) {
                zzagf.v("Blank page loaded, 1...");
                this.zzbyk.zztd();
                return;
            }
            this.zzdkz = true;
            zzann zzannVar = this.zzdkp;
            if (zzannVar != null) {
                zzannVar.zzg(this.zzbyk);
                this.zzdkp = null;
            }
            zztx();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf;
        if (i < 0) {
            int i2 = (-i) - 1;
            String[] strArr = zzdkm;
            if (i2 < strArr.length) {
                valueOf = strArr[i2];
                zzd(this.zzbyk.getContext(), "http_err", valueOf, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        valueOf = String.valueOf(i);
        zzd(this.zzbyk.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String valueOf;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = zzdkn;
                if (primaryError < strArr.length) {
                    valueOf = strArr[primaryError];
                    zzd(this.zzbyk.getContext(), "ssl_err", valueOf, com.google.android.gms.ads.internal.zzbs.zzek().zza(sslError));
                }
            }
            valueOf = String.valueOf(primaryError);
            zzd(this.zzbyk.getContext(), "ssl_err", valueOf, com.google.android.gms.ads.internal.zzbs.zzek().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        zzafb zzafbVar = this.zzaoq;
        if (zzafbVar != null) {
            zzafbVar.zzon();
            this.zzaoq = null;
        }
        zzts();
        synchronized (this.mLock) {
            this.zzckd.clear();
            this.zzbdd = null;
            this.zzbyj = null;
            this.zzdko = null;
            this.zzdkp = null;
            this.zzbwv = null;
            this.zzdkr = false;
            this.zzavo = false;
            this.zzdks = false;
            this.zzdkv = false;
            this.zzbyi = null;
            this.zzdkq = null;
            if (this.zzbyf != null) {
                this.zzbyf.zzl(true);
                this.zzbyf = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        zzii zza;
        try {
            String zzb = zzafi.zzb(str, this.zzbyk.getContext());
            if (zzb.equals(str)) {
                zzil zzab = zzil.zzab(str);
                if (zzab == null || (zza = com.google.android.gms.ads.internal.zzbs.zzen().zza(zzab)) == null || !zza.zzhf()) {
                    if (zzajv.isEnabled()) {
                        if (((Boolean) zzkb.zzif().zzd(zznh.zzbmj)).booleanValue()) {
                            return zzdb(str);
                        }
                    }
                    return null;
                }
                return new WebResourceResponse("", "", zza.zzhg());
            }
            return zzdb(zzb);
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
                    case TransportMediator.KEYCODE_MEDIA_PAUSE /* 127 */:
                    case 128:
                    case 129:
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzagf.v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else {
            if (this.zzdkr && webView == this.zzbyk.getWebView()) {
                String scheme = parse.getScheme();
                if (Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) {
                    if (this.zzbdd != null) {
                        if (((Boolean) zzkb.zzif().zzd(zznh.zzbkj)).booleanValue()) {
                            this.zzbdd.onAdClicked();
                            zzafb zzafbVar = this.zzaoq;
                            if (zzafbVar != null) {
                                zzafbVar.zzbv(str);
                            }
                            this.zzbdd = null;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzbyk.getWebView().willNotDraw()) {
                String valueOf2 = String.valueOf(str);
                zzagf.zzcu(valueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzcv zztb = this.zzbyk.zztb();
                    if (zztb != null && zztb.zzb(parse)) {
                        Context context = this.zzbyk.getContext();
                        zzanh zzanhVar = this.zzbyk;
                        if (zzanhVar == null) {
                            throw null;
                        }
                        parse = zztb.zza(parse, context, (View) zzanhVar, this.zzbyk.zzsi());
                    }
                } catch (zzcw e) {
                    String valueOf3 = String.valueOf(str);
                    zzagf.zzcu(valueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf3) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zzw zzwVar = this.zzbye;
                if (zzwVar == null || zzwVar.zzda()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.zzbye.zzt(str);
                }
            }
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzdkw.zzc(i, i2);
        zzwr zzwrVar = this.zzbyf;
        if (zzwrVar != null) {
            zzwrVar.zza(i, i2, z);
        }
    }

    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzdks = true;
            this.zzbyk.zzth();
            this.zzdkt = onGlobalLayoutListener;
            this.zzdku = onScrollChangedListener;
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zztc = this.zzbyk.zztc();
        zza(new AdOverlayInfoParcel(zzcVar, (!zztc || this.zzbyk.zzsx().zzuh()) ? this.zzbdd : null, zztc ? null : this.zzbyj, this.zzbyi, this.zzbyk.zzsk()));
    }

    public final void zza(zzanm zzanmVar) {
        this.zzdko = zzanmVar;
    }

    public final void zza(zzann zzannVar) {
        this.zzdkp = zzannVar;
    }

    public final void zza(zzano zzanoVar) {
        this.zzdkq = zzanoVar;
    }

    public final void zza(zzanq zzanqVar) {
        this.zzdkx = zzanqVar;
    }

    public final void zza(zzje zzjeVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, com.google.android.gms.ads.internal.overlay.zzq zzqVar, boolean z, com.google.android.gms.ads.internal.gmsg.zzx zzxVar, com.google.android.gms.ads.internal.zzw zzwVar, zzxc zzxcVar, zzafb zzafbVar) {
        com.google.android.gms.ads.internal.zzw zzwVar2 = zzwVar == null ? new com.google.android.gms.ads.internal.zzw(this.zzbyk.getContext(), zzafbVar, null) : zzwVar;
        this.zzbyf = new zzwr(this.zzbyk, zzxcVar);
        this.zzaoq = zzafbVar;
        zza("/appEvent", new com.google.android.gms.ads.internal.gmsg.zza(zzbVar));
        zza("/backButton", com.google.android.gms.ads.internal.gmsg.zzd.zzbxg);
        zza("/refresh", com.google.android.gms.ads.internal.gmsg.zzd.zzbxh);
        zza("/canOpenURLs", com.google.android.gms.ads.internal.gmsg.zzd.zzbwx);
        zza("/canOpenIntents", com.google.android.gms.ads.internal.gmsg.zzd.zzbwy);
        zza("/click", com.google.android.gms.ads.internal.gmsg.zzd.zzbwz);
        zza("/close", com.google.android.gms.ads.internal.gmsg.zzd.zzbxa);
        zza("/customClose", com.google.android.gms.ads.internal.gmsg.zzd.zzbxb);
        zza("/instrument", com.google.android.gms.ads.internal.gmsg.zzd.zzbxk);
        zza("/delayPageLoaded", com.google.android.gms.ads.internal.gmsg.zzd.zzbxm);
        zza("/delayPageClosed", com.google.android.gms.ads.internal.gmsg.zzd.zzbxn);
        zza("/getLocationInfo", com.google.android.gms.ads.internal.gmsg.zzd.zzbxo);
        zza("/httpTrack", com.google.android.gms.ads.internal.gmsg.zzd.zzbxc);
        zza("/log", com.google.android.gms.ads.internal.gmsg.zzd.zzbxd);
        zza("/mraid", new com.google.android.gms.ads.internal.gmsg.zzaa(zzwVar2, this.zzbyf));
        zza("/mraidLoaded", this.zzdkw);
        zza("/open", new com.google.android.gms.ads.internal.gmsg.zzab(this.zzbyk.getContext(), this.zzbyk.zzsk(), this.zzbyk.zztb(), zzqVar, zzjeVar, zzbVar, zznVar, zzwVar2, this.zzbyf));
        zza("/precache", new zzane());
        zza("/touch", com.google.android.gms.ads.internal.gmsg.zzd.zzbxf);
        zza("/video", com.google.android.gms.ads.internal.gmsg.zzd.zzbxi);
        zza("/videoMeta", com.google.android.gms.ads.internal.gmsg.zzd.zzbxj);
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzq(this.zzbyk.getContext())) {
            zza("/logScionEvent", new com.google.android.gms.ads.internal.gmsg.zzz(this.zzbyk.getContext()));
        }
        if (zzxVar != null) {
            zza("/setInterstitialProperties", new com.google.android.gms.ads.internal.gmsg.zzw(zzxVar));
        }
        this.zzbdd = zzjeVar;
        this.zzbyj = zznVar;
        this.zzbwv = zzbVar;
        this.zzbyi = zzqVar;
        this.zzbye = zzwVar2;
        this.zzcgu = zzxcVar;
        this.zzbyc = zzxVar;
        this.zzdkr = z;
    }

    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>> list = this.zzckd.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzckd.put(str, list);
            }
            list.add(zztVar);
        }
    }

    public final void zza(String str, com.google.android.gms.common.util.zzr<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>> zzrVar) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>> list = this.zzckd.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar : list) {
                if (zzrVar.apply(zztVar)) {
                    arrayList.add(zztVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void zza(boolean z, int i) {
        zzje zzjeVar = (!this.zzbyk.zztc() || this.zzbyk.zzsx().zzuh()) ? this.zzbdd : null;
        com.google.android.gms.ads.internal.overlay.zzn zznVar = this.zzbyj;
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzbyi;
        zzanh zzanhVar = this.zzbyk;
        zza(new AdOverlayInfoParcel(zzjeVar, zznVar, zzqVar, zzanhVar, z, i, zzanhVar.zzsk()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zztc = this.zzbyk.zztc();
        zzje zzjeVar = (!zztc || this.zzbyk.zzsx().zzuh()) ? this.zzbdd : null;
        zzanp zzanpVar = zztc ? null : new zzanp(this.zzbyk, this.zzbyj);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzbwv;
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzbyi;
        zzanh zzanhVar = this.zzbyk;
        zza(new AdOverlayInfoParcel(zzjeVar, zzanpVar, zzbVar, zzqVar, zzanhVar, z, i, str, zzanhVar.zzsk()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zztc = this.zzbyk.zztc();
        zzje zzjeVar = (!zztc || this.zzbyk.zzsx().zzuh()) ? this.zzbdd : null;
        zzanp zzanpVar = zztc ? null : new zzanp(this.zzbyk, this.zzbyj);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzbwv;
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzbyi;
        zzanh zzanhVar = this.zzbyk;
        zza(new AdOverlayInfoParcel(zzjeVar, zzanpVar, zzbVar, zzqVar, zzanhVar, z, i, str, str2, zzanhVar.zzsk()));
    }

    public final void zzac(boolean z) {
        this.zzdkr = z;
    }

    public final void zzb(int i, int i2) {
        zzwr zzwrVar = this.zzbyf;
        if (zzwrVar != null) {
            zzwrVar.zzb(i, i2);
        }
    }

    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh>> list = this.zzckd.get(str);
            if (list == null) {
                return;
            }
            list.remove(zztVar);
        }
    }

    public final boolean zzfv() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzavo;
        }
        return z;
    }

    public final void zzmv() {
        synchronized (this.mLock) {
            this.zzdkr = false;
            this.zzavo = true;
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzahn.runOnUiThread(new zzanl(this));
        }
    }

    public final com.google.android.gms.ads.internal.zzw zztm() {
        return this.zzbye;
    }

    public final boolean zztn() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdks;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzto() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzdkt;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zztp() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzdku;
        }
        return onScrollChangedListener;
    }

    public final boolean zztq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdkv;
        }
        return z;
    }

    public final void zztr() {
        synchronized (this.mLock) {
            zzagf.v("Loading blank page in WebView, 2...");
            this.zzdky = true;
            this.zzbyk.zzcz("about:blank");
        }
    }

    public final void zztt() {
        zzafb zzafbVar = this.zzaoq;
        if (zzafbVar != null) {
            WebView webView = this.zzbyk.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzafbVar, 10);
                return;
            }
            zzts();
            this.zzdlc = new zzank(this, zzafbVar);
            zzanh zzanhVar = this.zzbyk;
            if (zzanhVar == null) {
                throw null;
            }
            ((View) zzanhVar).addOnAttachStateChangeListener(this.zzdlc);
        }
    }

    public final void zztu() {
        synchronized (this.mLock) {
            this.zzdkv = true;
        }
        this.zzdlb++;
        zztx();
    }

    public final void zztv() {
        this.zzdlb--;
        zztx();
    }

    public final void zztw() {
        this.zzdla = true;
        zztx();
    }

    public final zzanq zzty() {
        return this.zzdkx;
    }
}
