package com.mopub.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;
/* loaded from: assets/classes2.dex */
public class MoPubBrowser extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    public static final String DSP_CREATIVE_ID = "mopub-dsp-creative-id";
    public static final int MOPUB_BROWSER_REQUEST_CODE = 1;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WebView f393;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ImageButton f394;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ImageButton f395;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ImageButton f396;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ImageButton f397;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f398;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private ImageButton m444(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m445() {
        WebSettings settings = this.f393.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        this.f393.loadUrl(getIntent().getStringExtra(DESTINATION_URL_KEY));
        this.f393.setWebViewClient(new C0188(this));
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m446() {
        this.f394.setBackgroundColor(0);
        this.f394.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.common.MoPubBrowser.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoPubBrowser.this.f393.canGoBack()) {
                    MoPubBrowser.this.f393.goBack();
                }
            }
        });
        this.f395.setBackgroundColor(0);
        this.f395.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.common.MoPubBrowser.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoPubBrowser.this.f393.canGoForward()) {
                    MoPubBrowser.this.f393.goForward();
                }
            }
        });
        this.f396.setBackgroundColor(0);
        this.f396.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.common.MoPubBrowser.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MoPubBrowser.this.f393.reload();
            }
        });
        this.f397.setBackgroundColor(0);
        this.f397.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.common.MoPubBrowser.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MoPubBrowser.this.finish();
            }
        });
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m448() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private View m449() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
        relativeLayout.addView(linearLayout2);
        this.f394 = m444(Drawables.UNLEFT_ARROW.createDrawable(this));
        this.f395 = m444(Drawables.UNRIGHT_ARROW.createDrawable(this));
        this.f396 = m444(Drawables.REFRESH.createDrawable(this));
        this.f397 = m444(Drawables.CLOSE.createDrawable(this));
        linearLayout2.addView(this.f394);
        linearLayout2.addView(this.f395);
        linearLayout2.addView(this.f396);
        linearLayout2.addView(this.f397);
        this.f393 = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 1);
        this.f393.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f393);
        return linearLayout;
    }

    @Override // android.app.Activity
    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    @NonNull
    public ImageButton getBackButton() {
        return this.f394;
    }

    @NonNull
    public ImageButton getCloseButton() {
        return this.f397;
    }

    @NonNull
    public ImageButton getForwardButton() {
        return this.f395;
    }

    @NonNull
    public ImageButton getRefreshButton() {
        return this.f396;
    }

    @NonNull
    public WebView getWebView() {
        return this.f393;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        this.f398 = getWindow().requestFeature(2);
        if (this.f398) {
            getWindow().setFeatureInt(2, -1);
        }
        setContentView(m449());
        m445();
        m446();
        m448();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f393.destroy();
        this.f393 = null;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        this.f393.setWebChromeClient(null);
        WebViews.onPause(this.f393, isFinishing());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        this.f393.setWebChromeClient(new WebChromeClient() { // from class: com.mopub.common.MoPubBrowser.5
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    MoPubBrowser.this.setTitle(webView.getUrl());
                } else {
                    MoPubBrowser.this.setTitle("Loading...");
                }
                if (!MoPubBrowser.this.f398 || Build.VERSION.SDK_INT >= 24) {
                    return;
                }
                MoPubBrowser.this.setProgress(i * 100);
            }
        });
        this.f393.onResume();
    }
}
