package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public interface zzanh extends com.google.android.gms.ads.internal.js.zza, com.google.android.gms.ads.internal.js.zzm, com.google.android.gms.ads.internal.zzbl, zzamp, zzaog, zzaoh, zzaou, zzaow, zzaox, zzaoy, zzgt {
    void destroy();

    @Override // com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaog
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    View.OnClickListener getOnClickListener();

    ViewParent getParent();

    @Override // com.google.android.gms.internal.zzamp
    String getRequestId();

    int getRequestedOrientation();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.zzamp
    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    @Override // com.google.android.gms.internal.zzamp
    void zza(zzaoa zzaoaVar);

    void zza(zzapa zzapaVar);

    void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar);

    @Override // com.google.android.gms.ads.internal.js.zza
    void zza(String str, Map<String, ?> map);

    @Override // com.google.android.gms.ads.internal.js.zza
    void zza(String str, JSONObject jSONObject);

    void zzad(boolean z);

    void zzae(boolean z);

    void zzaf(boolean z);

    void zzag(int i);

    void zzag(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzb(zzoq zzoqVar);

    void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar);

    @Override // com.google.android.gms.ads.internal.js.zzm
    void zzb(String str, JSONObject jSONObject);

    @Override // com.google.android.gms.internal.zzamp
    com.google.android.gms.ads.internal.zzv zzbq();

    void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzcz(String str);

    void zzda(String str);

    void zzmz();

    @Override // com.google.android.gms.internal.zzamp
    zzaoa zzsg();

    @Override // com.google.android.gms.internal.zzamp
    zzns zzsh();

    @Override // com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaog
    Activity zzsi();

    @Override // com.google.android.gms.internal.zzamp
    zznt zzsj();

    @Override // com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaox
    zzakd zzsk();

    void zzss();

    void zzst();

    Context zzsu();

    com.google.android.gms.ads.internal.overlay.zzd zzsv();

    com.google.android.gms.ads.internal.overlay.zzd zzsw();

    @Override // com.google.android.gms.internal.zzaov
    zzapa zzsx();

    String zzsy();

    zzani zzsz();

    boolean zzta();

    @Override // com.google.android.gms.internal.zzaow
    zzcv zztb();

    @Override // com.google.android.gms.internal.zzaoh
    boolean zztc();

    void zztd();

    boolean zzte();

    boolean zztf();

    boolean zztg();

    void zzth();

    void zzti();

    zzoq zztj();

    void zztk();

    void zztl();
}
