package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.network.Networking;
/* loaded from: assets/classes2.dex */
public class BaseHtmlWebView extends BaseWebView implements ViewGestureDetector.UserClickListener {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ViewGestureDetector f791;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f792;

    public BaseHtmlWebView(Context context, AdReport adReport) {
        super(context);
        m712();
        getSettings().setJavaScriptEnabled(true);
        this.f791 = new ViewGestureDetector(context, this, adReport);
        this.f791.setUserClickListener(this);
        enablePlugins(true);
        setBackgroundColor(0);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m712() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    public void init() {
        m713();
    }

    @Override // android.webkit.WebView
    public void loadUrl(@Nullable String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith("javascript:")) {
            super.loadUrl(str);
            return;
        }
        MoPubLog.d("Loading url: " + str);
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public void onResetUserClick() {
        this.f792 = false;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public void onUserClick() {
        this.f792 = true;
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.f799) {
            MoPubLog.w(BaseHtmlWebView.class.getSimpleName() + "#stopLoading() called after destroy()");
            return;
        }
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            super.stopLoading();
            settings.setJavaScriptEnabled(true);
            return;
        }
        MoPubLog.w(BaseHtmlWebView.class.getSimpleName() + "#getSettings() returned null");
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public boolean wasClicked() {
        return this.f792;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m713() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.mopub.mobileads.BaseHtmlWebView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BaseHtmlWebView.this.f791.sendTouchEvent(motionEvent);
                return motionEvent.getAction() == 2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m714(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "utf-8", null);
    }
}
