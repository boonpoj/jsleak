package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;
/* loaded from: assets/classes2.dex */
public class BaseWebView extends WebView {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean f798 = false;

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected boolean f799;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        enablePlugins(false);
        m732();
        WebViews.setDisableJSChromeClient(this);
        if (f798) {
            return;
        }
        m733(getContext());
        f798 = true;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m732() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m733(@NonNull Context context) {
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = 2005;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            ((WindowManager) context.getSystemService("window")).addView(webView, layoutParams);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.f799) {
            return;
        }
        this.f799 = true;
        Views.removeFromParent(this);
        removeAllViews();
        super.destroy();
    }

    public void enablePlugins(boolean z) {
        WebSettings settings;
        WebSettings.PluginState pluginState;
        if (Build.VERSION.SDK_INT >= 18) {
            return;
        }
        if (z) {
            settings = getSettings();
            pluginState = WebSettings.PluginState.ON;
        } else {
            settings = getSettings();
            pluginState = WebSettings.PluginState.OFF;
        }
        settings.setPluginState(pluginState);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebViews.manageThirdPartyCookies(this);
    }

    @VisibleForTesting
    @Deprecated
    void setIsDestroyed(boolean z) {
        this.f799 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m734() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        getSettings().setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    }
}
