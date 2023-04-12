package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
final class zzanx extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzanh {
    private final Object mLock;
    private String zzalx;
    private final com.google.android.gms.ads.internal.zzv zzanr;
    private final zzakd zzapr;
    private zzajq zzavi;
    private final WindowManager zzavx;
    private final zzcv zzbuv;
    private int zzchl;
    private int zzchm;
    private int zzcho;
    private int zzchp;
    private final zzis zzcmo;
    private String zzcrt;
    private Boolean zzcza;
    private zzns zzdje;
    private final zzaoz zzdly;
    private final com.google.android.gms.ads.internal.zzbl zzdlz;
    private zzani zzdma;
    private com.google.android.gms.ads.internal.overlay.zzd zzdmb;
    private zzapa zzdmc;
    private boolean zzdmd;
    private boolean zzdme;
    private boolean zzdmf;
    private boolean zzdmg;
    private int zzdmh;
    private boolean zzdmi;
    private boolean zzdmj;
    private zzaoa zzdmk;
    private boolean zzdml;
    private boolean zzdmm;
    private zzoq zzdmn;
    private int zzdmo;
    private int zzdmp;
    private zzns zzdmq;
    private zzns zzdmr;
    private zznt zzdms;
    private WeakReference<View.OnClickListener> zzdmt;
    private com.google.android.gms.ads.internal.overlay.zzd zzdmu;
    private boolean zzdmv;
    private Map<String, zzana> zzdmw;

    /* JADX WARN: Type inference failed for: r5v11, types: [com.google.android.gms.internal.zzaof, com.google.android.gms.internal.zzaoe] */
    private zzanx(zzaoz zzaozVar, zzapa zzapaVar, String str, boolean z, boolean z2, zzcv zzcvVar, zzakd zzakdVar, zznu zznuVar, com.google.android.gms.ads.internal.zzbl zzblVar, com.google.android.gms.ads.internal.zzv zzvVar, zzis zzisVar) {
        super(zzaozVar);
        this.mLock = new Object();
        this.zzdmi = true;
        this.zzdmj = false;
        this.zzcrt = "";
        this.zzchm = -1;
        this.zzchl = -1;
        this.zzcho = -1;
        this.zzchp = -1;
        this.zzdly = zzaozVar;
        this.zzdmc = zzapaVar;
        this.zzalx = str;
        this.zzdmf = z;
        this.zzdmh = -1;
        this.zzbuv = zzcvVar;
        this.zzapr = zzakdVar;
        this.zzdlz = zzblVar;
        this.zzanr = zzvVar;
        this.zzavx = (WindowManager) getContext().getSystemService("window");
        this.zzcmo = zzisVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzagf.zzb("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzbs.zzei().zzp(zzaozVar, zzakdVar.zzcv));
        com.google.android.gms.ads.internal.zzbs.zzek().zza(getContext(), settings);
        setDownloadListener(this);
        zzub();
        if (com.google.android.gms.common.util.zzq.zzamj()) {
            addJavascriptInterface(new zzaod(this, new Object(this) { // from class: com.google.android.gms.internal.zzaoe
                private final zzanh zzdnn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdnn = this;
                }
            }), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzavi = new zzajq(this.zzdly.zzsi(), this, this, null);
        zzue();
        this.zzdms = new zznt(new zznu(true, "make_wv", this.zzalx));
        this.zzdms.zzje().zzc(zznuVar);
        this.zzdje = zznn.zzb(this.zzdms.zzje());
        this.zzdms.zza("native:view_create", this.zzdje);
        this.zzdmr = null;
        this.zzdmq = null;
        com.google.android.gms.ads.internal.zzbs.zzek().zzax(zzaozVar);
    }

    private final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzcza = bool;
        }
        com.google.android.gms.ads.internal.zzbs.zzem().zza(bool);
    }

    private final void zzah(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzanx zzb(Context context, zzapa zzapaVar, String str, boolean z, boolean z2, zzcv zzcvVar, zzakd zzakdVar, zznu zznuVar, com.google.android.gms.ads.internal.zzbl zzblVar, com.google.android.gms.ads.internal.zzv zzvVar, zzis zzisVar) {
        return new zzanx(new zzaoz(context), zzapaVar, str, z, z2, zzcvVar, zzakdVar, zznuVar, zzblVar, zzvVar, zzisVar);
    }

    private final void zzdc(String str) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzagf.zzcu("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    private final void zzdd(String str) {
        if (!com.google.android.gms.common.util.zzq.zzaml()) {
            String valueOf = String.valueOf(str);
            zzdc(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        if (zzpg() == null) {
            synchronized (this.mLock) {
                this.zzcza = com.google.android.gms.ads.internal.zzbs.zzem().zzpg();
                if (this.zzcza == null) {
                    try {
                        evaluateJavascript("(function(){})()", null);
                        zza((Boolean) true);
                    } catch (IllegalStateException e) {
                        zza((Boolean) false);
                    }
                }
            }
        }
        if (!zzpg().booleanValue()) {
            String valueOf2 = String.valueOf(str);
            zzdc(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
            return;
        }
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzagf.zzcu("The webview is destroyed. Ignoring action.");
            } else {
                evaluateJavascript(str, null);
            }
        }
    }

    private final Boolean zzpg() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzcza;
        }
        return bool;
    }

    private final void zzpu() {
        synchronized (this.mLock) {
            if (!this.zzdmv) {
                this.zzdmv = true;
                com.google.android.gms.ads.internal.zzbs.zzem().zzpu();
            }
        }
    }

    private final boolean zztz() {
        int i;
        int i2;
        boolean z = false;
        if (this.zzdma.zzfv() || this.zzdma.zztn()) {
            com.google.android.gms.ads.internal.zzbs.zzei();
            DisplayMetrics zza = zzahn.zza(this.zzavx);
            zzkb.zzia();
            int zzb = zzajr.zzb(zza, zza.widthPixels);
            zzkb.zzia();
            int zzb2 = zzajr.zzb(zza, zza.heightPixels);
            Activity zzsi = this.zzdly.zzsi();
            if (zzsi == null || zzsi.getWindow() == null) {
                i = zzb;
                i2 = zzb2;
            } else {
                com.google.android.gms.ads.internal.zzbs.zzei();
                int[] zzf = zzahn.zzf(zzsi);
                zzkb.zzia();
                i = zzajr.zzb(zza, zzf[0]);
                zzkb.zzia();
                i2 = zzajr.zzb(zza, zzf[1]);
            }
            if (this.zzchl == zzb && this.zzchm == zzb2 && this.zzcho == i && this.zzchp == i2) {
                return false;
            }
            z = (this.zzchl == zzb && this.zzchm == zzb2) ? true : true;
            this.zzchl = zzb;
            this.zzchm = zzb2;
            this.zzcho = i;
            this.zzchp = i2;
            new zzxb(this).zza(zzb, zzb2, i, i2, zza.density, this.zzavx.getDefaultDisplay().getRotation());
            return z;
        }
        return false;
    }

    private final void zzua() {
        zznn.zza(this.zzdms.zzje(), this.zzdje, "aeh2");
    }

    private final void zzub() {
        synchronized (this.mLock) {
            if (!this.zzdmf && !this.zzdmc.zzuh()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzagf.zzbx("Disabling hardware acceleration on an AdView.");
                    synchronized (this.mLock) {
                        if (!this.zzdmg) {
                            com.google.android.gms.ads.internal.zzbs.zzek().zzy(this);
                        }
                        this.zzdmg = true;
                    }
                } else {
                    zzagf.zzbx("Enabling hardware acceleration on an AdView.");
                    zzuc();
                }
            }
            zzagf.zzbx("Enabling hardware acceleration on an overlay.");
            zzuc();
        }
    }

    private final void zzuc() {
        synchronized (this.mLock) {
            if (this.zzdmg) {
                com.google.android.gms.ads.internal.zzbs.zzek().zzx(this);
            }
            this.zzdmg = false;
        }
    }

    private final void zzud() {
        synchronized (this.mLock) {
            this.zzdmw = null;
        }
    }

    private final void zzue() {
        zznu zzje;
        zznt zzntVar = this.zzdms;
        if (zzntVar == null || (zzje = zzntVar.zzje()) == null || com.google.android.gms.ads.internal.zzbs.zzem().zzpc() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbs.zzem().zzpc().zza(zzje);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void destroy() {
        synchronized (this.mLock) {
            zzue();
            this.zzavi.zzqv();
            if (this.zzdmb != null) {
                this.zzdmb.close();
                this.zzdmb.onDestroy();
                this.zzdmb = null;
            }
            this.zzdma.reset();
            if (this.zzdme) {
                return;
            }
            com.google.android.gms.ads.internal.zzbs.zzfb();
            zzamz.zzb(this);
            zzud();
            this.zzdme = true;
            zzagf.v("Initiating WebView self destruct sequence in 3...");
            this.zzdma.zztr();
        }
    }

    @Override // android.webkit.WebView
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                super.evaluateJavascript(str, valueCallback);
                return;
            }
            zzagf.zzcu("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.mLock != null) {
                synchronized (this.mLock) {
                    if (!this.zzdme) {
                        this.zzdma.reset();
                        com.google.android.gms.ads.internal.zzbs.zzfb();
                        zzamz.zzb(this);
                        zzud();
                        zzpu();
                    }
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final View.OnClickListener getOnClickListener() {
        return this.zzdmt.get();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final String getRequestId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcrt;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final int getRequestedOrientation() {
        int i;
        synchronized (this.mLock) {
            i = this.zzdmh;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdme;
        }
        return z;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void loadData(String str, String str2, String str3) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzagf.zzcu("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzagf.zzcu("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void loadUrl(String str) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzagf.zzcu("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                    com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdWebViewImpl.loadUrl");
                    zzagf.zzc("Could not call loadUrl. ", e);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        synchronized (this.mLock) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzavi.onAttachedToWindow();
            }
            boolean z = this.zzdml;
            if (this.zzdma != null && this.zzdma.zztn()) {
                if (!this.zzdmm) {
                    ViewTreeObserver.OnGlobalLayoutListener zzto = this.zzdma.zzto();
                    if (zzto != null) {
                        com.google.android.gms.ads.internal.zzbs.zzfc();
                        zzaln.zza(this, zzto);
                    }
                    ViewTreeObserver.OnScrollChangedListener zztp = this.zzdma.zztp();
                    if (zztp != null) {
                        com.google.android.gms.ads.internal.zzbs.zzfc();
                        zzaln.zza(this, zztp);
                    }
                    this.zzdmm = true;
                }
                zztz();
                z = true;
            }
            zzah(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                this.zzavi.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzdmm && this.zzdma != null && this.zzdma.zztn() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzto = this.zzdma.zzto();
                if (zzto != null) {
                    com.google.android.gms.ads.internal.zzbs.zzek().zza(getViewTreeObserver(), zzto);
                }
                ViewTreeObserver.OnScrollChangedListener zztp = this.zzdma.zztp();
                if (zztp != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zztp);
                }
                this.zzdmm = false;
            }
        }
        zzah(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzahn.zza(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzagf.zzbx(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        zzani zzaniVar = this.zzdma;
        if (zzaniVar == null || zzaniVar.zzty() == null) {
            return;
        }
        this.zzdma.zzty().zzdb();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbla)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8) {
                if (axisValue > 0.0f && !canScrollVertically(-1)) {
                    return false;
                }
                if (axisValue < 0.0f && !canScrollVertically(1)) {
                    return false;
                }
                if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                    return false;
                }
                if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                    return false;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zztz = zztz();
        com.google.android.gms.ads.internal.overlay.zzd zzsv = zzsv();
        if (zzsv == null || !zztz) {
            return;
        }
        zzsv.zzmy();
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0123 A[Catch: all -> 0x0199, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x000d, B:9:0x000f, B:11:0x0015, B:13:0x0019, B:16:0x0023, B:18:0x002b, B:20:0x0032, B:24:0x003c, B:25:0x003f, B:27:0x0041, B:30:0x0054, B:34:0x0062, B:35:0x006d, B:33:0x005e, B:37:0x006f, B:39:0x0077, B:41:0x0089, B:44:0x0090, B:46:0x00b4, B:48:0x00bf, B:49:0x00c2, B:47:0x00bb, B:51:0x00c4, B:52:0x00c7, B:54:0x00c9, B:56:0x00d1, B:57:0x00e6, B:59:0x00e8, B:68:0x010e, B:70:0x0116, B:73:0x011d, B:75:0x0123, B:76:0x0126, B:81:0x0192, B:77:0x0132, B:79:0x018b, B:80:0x018f, B:83:0x0194, B:84:0x0197), top: B:89:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018b A[Catch: all -> 0x0199, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x000d, B:9:0x000f, B:11:0x0015, B:13:0x0019, B:16:0x0023, B:18:0x002b, B:20:0x0032, B:24:0x003c, B:25:0x003f, B:27:0x0041, B:30:0x0054, B:34:0x0062, B:35:0x006d, B:33:0x005e, B:37:0x006f, B:39:0x0077, B:41:0x0089, B:44:0x0090, B:46:0x00b4, B:48:0x00bf, B:49:0x00c2, B:47:0x00bb, B:51:0x00c4, B:52:0x00c7, B:54:0x00c9, B:56:0x00d1, B:57:0x00e6, B:59:0x00e8, B:68:0x010e, B:70:0x0116, B:73:0x011d, B:75:0x0123, B:76:0x0126, B:81:0x0192, B:77:0x0132, B:79:0x018b, B:80:0x018f, B:83:0x0194, B:84:0x0197), top: B:89:0x0003 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzagf.zzb("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzagf.zzb("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzdma.zztn()) {
            synchronized (this.mLock) {
                if (this.zzdmn != null) {
                    this.zzdmn.zzc(motionEvent);
                }
            }
        } else {
            zzcv zzcvVar = this.zzbuv;
            if (zzcvVar != null) {
                zzcvVar.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setContext(Context context) {
        this.zzdly.setBaseContext(context);
        this.zzavi.zzi(this.zzdly.zzsi());
    }

    @Override // android.view.View, com.google.android.gms.internal.zzanh
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdmt = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setRequestedOrientation(int i) {
        synchronized (this.mLock) {
            this.zzdmh = i;
            if (this.zzdmb != null) {
                this.zzdmb.setRequestedOrientation(this.zzdmh);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzani) {
            this.zzdma = (zzani) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzanh
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzagf.zzb("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzdma.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final void zza(zzaoa zzaoaVar) {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                zzagf.e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.zzdmk = zzaoaVar;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zza(zzapa zzapaVar) {
        synchronized (this.mLock) {
            this.zzdmc = zzapaVar;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.zzgt
    public final void zza(zzgs zzgsVar) {
        synchronized (this.mLock) {
            this.zzdml = zzgsVar.zzake;
        }
        zzah(zzgsVar.zzake);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        zzani zzaniVar = this.zzdma;
        if (zzaniVar != null) {
            zzaniVar.zza(str, zztVar);
        }
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, com.google.android.gms.ads.internal.zzbs.zzei().zzq(map));
        } catch (JSONException e) {
            zzagf.zzcu("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzagf.zzbx(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzdd(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i) {
        this.zzdma.zza(z, i);
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i, String str) {
        this.zzdma.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzdma.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.zzamp
    public final void zzac(boolean z) {
        this.zzdma.zzac(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzad(boolean z) {
        synchronized (this.mLock) {
            boolean z2 = z != this.zzdmf;
            this.zzdmf = z;
            zzub();
            if (z2) {
                new zzxb(this).zzbo(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzae(boolean z) {
        synchronized (this.mLock) {
            if (this.zzdmb != null) {
                this.zzdmb.zza(this.zzdma.zzfv(), z);
            } else {
                this.zzdmd = z;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzaf(boolean z) {
        synchronized (this.mLock) {
            this.zzdmi = z;
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzag(int i) {
        if (i == 0) {
            zznn.zza(this.zzdms.zzje(), this.zzdje, "aebb2");
        }
        zzua();
        if (this.zzdms.zzje() != null) {
            this.zzdms.zzje().zzf("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzapr.zzcv);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzag(boolean z) {
        synchronized (this.mLock) {
            this.zzdmo += z ? 1 : -1;
            if (this.zzdmo <= 0 && this.zzdmb != null) {
                this.zzdmb.zznb();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.mLock) {
            this.zzdmb = zzdVar;
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(zzoq zzoqVar) {
        synchronized (this.mLock) {
            this.zzdmn = zzoqVar;
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        zzani zzaniVar = this.zzdma;
        if (zzaniVar != null) {
            zzaniVar.zzb(str, zztVar);
        }
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zzm
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzdd(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final com.google.android.gms.ads.internal.zzv zzbq() {
        return this.zzanr;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.mLock) {
            this.zzdmu = zzdVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcq() {
        synchronized (this.mLock) {
            this.zzdmj = true;
            if (this.zzdlz != null) {
                this.zzdlz.zzcq();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcr() {
        synchronized (this.mLock) {
            this.zzdmj = false;
            if (this.zzdlz != null) {
                this.zzdlz.zzcr();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzcz(String str) {
        synchronized (this.mLock) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzagf.zzc("Could not call loadUrl. ", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzda(String str) {
        synchronized (this.mLock) {
            if (str == null) {
                str = "";
            }
            try {
                this.zzcrt = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzmz() {
        if (this.zzdmq == null) {
            zznn.zza(this.zzdms.zzje(), this.zzdje, "aes2");
            this.zzdmq = zznn.zzb(this.zzdms.zzje());
            this.zzdms.zza("native:view_show", this.zzdmq);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzapr.zzcv);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.zzamp
    public final void zzna() {
        com.google.android.gms.ads.internal.overlay.zzd zzsv = zzsv();
        if (zzsv != null) {
            zzsv.zzna();
        }
    }

    @Override // com.google.android.gms.internal.zzamp
    public final zzamg zzsf() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zzaoa zzsg() {
        zzaoa zzaoaVar;
        synchronized (this.mLock) {
            zzaoaVar = this.zzdmk;
        }
        return zzaoaVar;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zzns zzsh() {
        return this.zzdje;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaog
    public final Activity zzsi() {
        return this.zzdly.zzsi();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zznt zzsj() {
        return this.zzdms;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaox
    public final zzakd zzsk() {
        return this.zzapr;
    }

    @Override // com.google.android.gms.internal.zzamp
    public final int zzsl() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.zzamp
    public final int zzsm() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzss() {
        zzua();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzapr.zzcv);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzst() {
        HashMap hashMap = new HashMap(3);
        com.google.android.gms.ads.internal.zzbs.zzei();
        hashMap.put("app_muted", String.valueOf(zzahn.zzdo()));
        com.google.android.gms.ads.internal.zzbs.zzei();
        hashMap.put("app_volume", String.valueOf(zzahn.zzdn()));
        com.google.android.gms.ads.internal.zzbs.zzei();
        hashMap.put("device_volume", String.valueOf(zzahn.zzaq(getContext())));
        zza(AvidVideoPlaybackListenerImpl.VOLUME, hashMap);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final Context zzsu() {
        return this.zzdly.zzsu();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final com.google.android.gms.ads.internal.overlay.zzd zzsv() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.mLock) {
            zzdVar = this.zzdmb;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final com.google.android.gms.ads.internal.overlay.zzd zzsw() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.mLock) {
            zzdVar = this.zzdmu;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaov
    public final zzapa zzsx() {
        zzapa zzapaVar;
        synchronized (this.mLock) {
            zzapaVar = this.zzdmc;
        }
        return zzapaVar;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final String zzsy() {
        String str;
        synchronized (this.mLock) {
            str = this.zzalx;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final zzani zzsz() {
        return this.zzdma;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zzta() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdmd;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaow
    public final zzcv zztb() {
        return this.zzbuv;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaoh
    public final boolean zztc() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdmf;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztd() {
        synchronized (this.mLock) {
            zzagf.v("Destroying WebView!");
            zzpu();
            zzahn.zzdaw.post(new zzanz(this));
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zzte() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdmi;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zztf() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdmj;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zztg() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdmo > 0;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzth() {
        this.zzavi.zzqu();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzti() {
        if (this.zzdmr == null) {
            this.zzdmr = zznn.zzb(this.zzdms.zzje());
            this.zzdms.zza("native:view_load", this.zzdmr);
        }
    }

    @Override // com.google.android.gms.internal.zzanh
    public final zzoq zztj() {
        zzoq zzoqVar;
        synchronized (this.mLock) {
            zzoqVar = this.zzdmn;
        }
        return zzoqVar;
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztk() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztl() {
        zzagf.v("Cannot add text view to inner AdWebView");
    }
}
