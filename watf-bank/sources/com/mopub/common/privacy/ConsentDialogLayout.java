package com.mopub.common.privacy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
/* loaded from: assets/classes2.dex */
class ConsentDialogLayout extends CloseableLayout {

    /* renamed from: ࢠ  reason: contains not printable characters */
    static int f487 = 101;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WebView f488;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private InterfaceC0177 f489;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private InterfaceC0176 f490;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final WebViewClient f491;

    /* renamed from: com.mopub.common.privacy.ConsentDialogLayout$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0176 {
        void onCloseClick();

        void onConsentClick(ConsentStatus consentStatus);
    }

    /* renamed from: com.mopub.common.privacy.ConsentDialogLayout$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0177 {
        void onLoadProgress(int i);
    }

    public ConsentDialogLayout(@NonNull Context context) {
        super(context);
        this.f491 = new WebViewClient() { // from class: com.mopub.common.privacy.ConsentDialogLayout.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(ConsentDialogLayout.f487);
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if ("mopub://consent?yes".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_YES);
                    }
                    return true;
                } else if ("mopub://consent?no".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_NO);
                    }
                    return true;
                } else if ("mopub://close".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onCloseClick();
                    }
                    return true;
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            Context context2 = ConsentDialogLayout.this.getContext();
                            Uri parse = Uri.parse(str);
                            Intents.launchActionViewIntent(context2, parse, "Cannot open native browser for " + str);
                            return true;
                        } catch (IntentNotResolvableException e) {
                            MoPubLog.e(e.getMessage());
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
        };
        this.f488 = m499();
    }

    public ConsentDialogLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f491 = new WebViewClient() { // from class: com.mopub.common.privacy.ConsentDialogLayout.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(ConsentDialogLayout.f487);
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if ("mopub://consent?yes".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_YES);
                    }
                    return true;
                } else if ("mopub://consent?no".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_NO);
                    }
                    return true;
                } else if ("mopub://close".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onCloseClick();
                    }
                    return true;
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            Context context2 = ConsentDialogLayout.this.getContext();
                            Uri parse = Uri.parse(str);
                            Intents.launchActionViewIntent(context2, parse, "Cannot open native browser for " + str);
                            return true;
                        } catch (IntentNotResolvableException e) {
                            MoPubLog.e(e.getMessage());
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
        };
        this.f488 = m499();
    }

    public ConsentDialogLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f491 = new WebViewClient() { // from class: com.mopub.common.privacy.ConsentDialogLayout.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(ConsentDialogLayout.f487);
                }
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (ConsentDialogLayout.this.f489 != null) {
                    ConsentDialogLayout.this.f489.onLoadProgress(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if ("mopub://consent?yes".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_YES);
                    }
                    return true;
                } else if ("mopub://consent?no".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onConsentClick(ConsentStatus.EXPLICIT_NO);
                    }
                    return true;
                } else if ("mopub://close".equals(str)) {
                    if (ConsentDialogLayout.this.f490 != null) {
                        ConsentDialogLayout.this.f490.onCloseClick();
                    }
                    return true;
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            Context context2 = ConsentDialogLayout.this.getContext();
                            Uri parse = Uri.parse(str);
                            Intents.launchActionViewIntent(context2, parse, "Cannot open native browser for " + str);
                            return true;
                        } catch (IntentNotResolvableException e) {
                            MoPubLog.e(e.getMessage());
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
        };
        this.f488 = m499();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m497(@NonNull WebView webView) {
        webView.setWebViewClient(this.f491);
        setOnCloseListener(new CloseableLayout.OnCloseListener() { // from class: com.mopub.common.privacy.ConsentDialogLayout.1
            @Override // com.mopub.common.CloseableLayout.OnCloseListener
            public void onClose() {
                if (ConsentDialogLayout.this.f490 != null) {
                    ConsentDialogLayout.this.f490.onCloseClick();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: ࢣ  reason: contains not printable characters */
    private WebView m499() {
        WebView webView = new WebView(getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            webView.setId(View.generateViewId());
        }
        setCloseVisible(false);
        addView(webView, new FrameLayout.LayoutParams(-1, -1));
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m500(@NonNull InterfaceC0176 interfaceC0176) {
        Preconditions.checkNotNull(interfaceC0176);
        this.f490 = interfaceC0176;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m501(@NonNull String str, @Nullable InterfaceC0177 interfaceC0177) {
        Preconditions.checkNotNull(str);
        this.f489 = interfaceC0177;
        m497(this.f488);
        this.f488.loadDataWithBaseURL("https://ads.mopub.com/", str, "text/html", "UTF-8", null);
    }
}
