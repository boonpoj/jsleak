package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.R;
import java.util.Map;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
final class zzanw extends FrameLayout implements zzanh {
    private static final int zzchx = Color.argb(0, 0, 0, 0);
    private final zzanh zzdlw;
    private final zzamg zzdlx;

    public zzanw(zzanh zzanhVar) {
        super(zzanhVar.getContext());
        this.zzdlw = zzanhVar;
        this.zzdlx = new zzamg(zzanhVar.zzsu(), this, this);
        zzani zzsz = this.zzdlw.zzsz();
        if (zzsz != null) {
            zzsz.zzbyk = this;
        }
        zzanh zzanhVar2 = this.zzdlw;
        if (zzanhVar2 == null) {
            throw null;
        }
        addView((View) zzanhVar2);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void destroy() {
        this.zzdlw.destroy();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final View.OnClickListener getOnClickListener() {
        return this.zzdlw.getOnClickListener();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final String getRequestId() {
        return this.zzdlw.getRequestId();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final int getRequestedOrientation() {
        return this.zzdlw.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final WebView getWebView() {
        return this.zzdlw.getWebView();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean isDestroyed() {
        return this.zzdlw.isDestroyed();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void loadData(String str, String str2, String str3) {
        this.zzdlw.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzdlw.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void loadUrl(String str) {
        this.zzdlw.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void onPause() {
        this.zzdlx.onPause();
        this.zzdlw.onPause();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void onResume() {
        this.zzdlw.onResume();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setContext(Context context) {
        this.zzdlw.setContext(context);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzanh
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdlw.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzanh
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzdlw.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setRequestedOrientation(int i) {
        this.zzdlw.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzdlw.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzdlw.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void stopLoading() {
        this.zzdlw.stopLoading();
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzdlw.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final void zza(zzaoa zzaoaVar) {
        this.zzdlw.zza(zzaoaVar);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zza(zzapa zzapaVar) {
        this.zzdlw.zza(zzapaVar);
    }

    @Override // com.google.android.gms.internal.zzgt
    public final void zza(zzgs zzgsVar) {
        this.zzdlw.zza(zzgsVar);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        this.zzdlw.zza(str, zztVar);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, Map<String, ?> map) {
        this.zzdlw.zza(str, map);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, JSONObject jSONObject) {
        this.zzdlw.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i) {
        this.zzdlw.zza(z, i);
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i, String str) {
        this.zzdlw.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.zzaou
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzdlw.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.zzamp
    public final void zzac(boolean z) {
        this.zzdlw.zzac(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzad(boolean z) {
        this.zzdlw.zzad(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzae(boolean z) {
        this.zzdlw.zzae(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzaf(boolean z) {
        this.zzdlw.zzaf(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzag(int i) {
        this.zzdlw.zzag(i);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzag(boolean z) {
        this.zzdlw.zzag(z);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzdlw.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(zzoq zzoqVar) {
        this.zzdlw.zzb(zzoqVar);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar) {
        this.zzdlw.zzb(str, zztVar);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.ads.internal.js.zzm
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzdlw.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final com.google.android.gms.ads.internal.zzv zzbq() {
        return this.zzdlw.zzbq();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzdlw.zzc(zzdVar);
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcq() {
        this.zzdlw.zzcq();
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcr() {
        this.zzdlw.zzcr();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzcz(String str) {
        this.zzdlw.zzcz(str);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzda(String str) {
        this.zzdlw.zzda(str);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzmz() {
        this.zzdlw.zzmz();
    }

    @Override // com.google.android.gms.internal.zzamp
    public final void zzna() {
        this.zzdlw.zzna();
    }

    @Override // com.google.android.gms.internal.zzamp
    public final zzamg zzsf() {
        return this.zzdlx;
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zzaoa zzsg() {
        return this.zzdlw.zzsg();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zzns zzsh() {
        return this.zzdlw.zzsh();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaog
    public final Activity zzsi() {
        return this.zzdlw.zzsi();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp
    public final zznt zzsj() {
        return this.zzdlw.zzsj();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzamp, com.google.android.gms.internal.zzaox
    public final zzakd zzsk() {
        return this.zzdlw.zzsk();
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
        this.zzdlw.zzss();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzst() {
        this.zzdlw.zzst();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final Context zzsu() {
        return this.zzdlw.zzsu();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final com.google.android.gms.ads.internal.overlay.zzd zzsv() {
        return this.zzdlw.zzsv();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final com.google.android.gms.ads.internal.overlay.zzd zzsw() {
        return this.zzdlw.zzsw();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaov
    public final zzapa zzsx() {
        return this.zzdlw.zzsx();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final String zzsy() {
        return this.zzdlw.zzsy();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final zzani zzsz() {
        return this.zzdlw.zzsz();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zzta() {
        return this.zzdlw.zzta();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaow
    public final zzcv zztb() {
        return this.zzdlw.zztb();
    }

    @Override // com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzaoh
    public final boolean zztc() {
        return this.zzdlw.zztc();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztd() {
        this.zzdlx.onDestroy();
        this.zzdlw.zztd();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zzte() {
        return this.zzdlw.zzte();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zztf() {
        return this.zzdlw.zztf();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final boolean zztg() {
        return this.zzdlw.zztg();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzth() {
        this.zzdlw.zzth();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zzti() {
        this.zzdlw.zzti();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final zzoq zztj() {
        return this.zzdlw.zztj();
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztk() {
        setBackgroundColor(zzchx);
        this.zzdlw.setBackgroundColor(zzchx);
    }

    @Override // com.google.android.gms.internal.zzanh
    public final void zztl() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzbs.zzem().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }
}
