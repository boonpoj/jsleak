package com.mopub.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.AdReport;
import com.mopub.common.AdType;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.Networking;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MraidBridge {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AdReport f1299;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final PlacementType f1300;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MraidNativeCommandHandler f1301;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private MraidBridgeListener f1302;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private MraidWebView f1303;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f1304;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1305;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final WebViewClient f1306;

    /* loaded from: assets/classes2.dex */
    public interface MraidBridgeListener {
        void onClose();

        boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage);

        void onExpand(URI uri, boolean z) throws C0253;

        boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult);

        void onOpen(URI uri);

        void onPageFailedToLoad();

        void onPageLoaded();

        void onPlayVideo(URI uri);

        void onResize(int i, int i2, int i3, int i4, @NonNull CloseableLayout.ClosePosition closePosition, boolean z) throws C0253;

        void onSetOrientationProperties(boolean z, EnumC0254 enumC0254) throws C0253;

        void onUseCustomClose(boolean z);

        void onVisibilityChanged(boolean z);
    }

    /* loaded from: assets/classes2.dex */
    public static class MraidWebView extends BaseWebView {
        @Nullable

        /* renamed from: ࢢ  reason: contains not printable characters */
        private OnVisibilityChangedListener f1316;
        @Nullable

        /* renamed from: ࢣ  reason: contains not printable characters */
        private VisibilityTracker f1317;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f1318;

        /* loaded from: assets/classes2.dex */
        public interface OnVisibilityChangedListener {
            void onVisibilityChanged(boolean z);
        }

        public MraidWebView(Context context) {
            super(context);
            if (Build.VERSION.SDK_INT <= 22) {
                this.f1318 = getVisibility() == 0;
                return;
            }
            this.f1317 = new VisibilityTracker(context);
            this.f1317.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() { // from class: com.mopub.mraid.MraidBridge.MraidWebView.1
                @Override // com.mopub.common.VisibilityTracker.VisibilityTrackerListener
                public void onVisibilityChanged(@NonNull List<View> list, @NonNull List<View> list2) {
                    Preconditions.checkNotNull(list);
                    Preconditions.checkNotNull(list2);
                    MraidWebView.this.setMraidViewable(list.contains(MraidWebView.this));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMraidViewable(boolean z) {
            if (this.f1318 == z) {
                return;
            }
            this.f1318 = z;
            if (this.f1316 != null) {
                this.f1316.onVisibilityChanged(z);
            }
        }

        @Override // com.mopub.mobileads.BaseWebView, android.webkit.WebView
        public void destroy() {
            super.destroy();
            this.f1317 = null;
            this.f1316 = null;
        }

        public boolean isMraidViewable() {
            return this.f1318;
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onVisibilityChanged(@NonNull View view, int i) {
            super.onVisibilityChanged(view, i);
            if (this.f1317 == null) {
                setMraidViewable(i == 0);
            } else if (i == 0) {
                this.f1317.clear();
                this.f1317.addView(view, this, 0, 0, 1);
            } else {
                this.f1317.removeView(this);
                setMraidViewable(false);
            }
        }

        void setVisibilityChangedListener(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
            this.f1316 = onVisibilityChangedListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MraidBridge(@Nullable AdReport adReport, @NonNull PlacementType placementType) {
        this(adReport, placementType, new MraidNativeCommandHandler());
    }

    @VisibleForTesting
    MraidBridge(@Nullable AdReport adReport, @NonNull PlacementType placementType, @NonNull MraidNativeCommandHandler mraidNativeCommandHandler) {
        this.f1306 = new MraidWebViewClient() { // from class: com.mopub.mraid.MraidBridge.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
                MraidBridge.this.m1139();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(@NonNull WebView webView, int i, @NonNull String str, @NonNull String str2) {
                MoPubLog.d("Error: " + str);
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
                return MraidBridge.this.m1150(str);
            }
        };
        this.f1299 = adReport;
        this.f1300 = placementType;
        this.f1301 = mraidNativeCommandHandler;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int m1122(int i, int i2, int i3) throws C0253 {
        if (i < i2 || i > i3) {
            throw new C0253("Integer parameter out of range: " + i);
        }
        return i;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private CloseableLayout.ClosePosition m1123(@NonNull String str, @NonNull CloseableLayout.ClosePosition closePosition) throws C0253 {
        if (TextUtils.isEmpty(str)) {
            return closePosition;
        }
        if (str.equals("top-left")) {
            return CloseableLayout.ClosePosition.TOP_LEFT;
        }
        if (str.equals("top-right")) {
            return CloseableLayout.ClosePosition.TOP_RIGHT;
        }
        if (str.equals("center")) {
            return CloseableLayout.ClosePosition.CENTER;
        }
        if (str.equals("bottom-left")) {
            return CloseableLayout.ClosePosition.BOTTOM_LEFT;
        }
        if (str.equals("bottom-right")) {
            return CloseableLayout.ClosePosition.BOTTOM_RIGHT;
        }
        if (str.equals("top-center")) {
            return CloseableLayout.ClosePosition.TOP_CENTER;
        }
        if (str.equals("bottom-center")) {
            return CloseableLayout.ClosePosition.BOTTOM_CENTER;
        }
        throw new C0253("Invalid close position: " + str);
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m1125(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private URI m1126(@Nullable String str, URI uri) throws C0253 {
        return str == null ? uri : m1138(str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1128(@NonNull MraidJavascriptCommand mraidJavascriptCommand) {
        m1146("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(mraidJavascriptCommand.m1203()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1129(@NonNull MraidJavascriptCommand mraidJavascriptCommand, @NonNull String str) {
        m1146("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(mraidJavascriptCommand.m1203()) + ", " + JSONObject.quote(str) + ")");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1131(@Nullable String str, boolean z) throws C0253 {
        return str == null ? z : m1137(str);
    }

    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m1132(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int m1134(@NonNull String str) throws C0253 {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new C0253("Invalid numeric parameter: " + str);
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private EnumC0254 m1136(String str) throws C0253 {
        if ("portrait".equals(str)) {
            return EnumC0254.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return EnumC0254.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return EnumC0254.NONE;
        }
        throw new C0253("Invalid orientation: " + str);
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean m1137(String str) throws C0253 {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new C0253("Invalid boolean parameter: " + str);
    }

    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    private URI m1138(@Nullable String str) throws C0253 {
        if (str != null) {
            try {
                return new URI(str);
            } catch (URISyntaxException unused) {
                throw new C0253("Invalid URL parameter: " + str);
            }
        }
        throw new C0253("Parameter cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m1139() {
        if (this.f1305) {
            return;
        }
        this.f1305 = true;
        if (this.f1302 != null) {
            this.f1302.onPageLoaded();
        }
    }

    public void notifyScreenMetrics(@NonNull C0255 c0255) {
        m1146("mraidbridge.setScreenSize(" + m1132(c0255.m1240()) + ");mraidbridge.setMaxSize(" + m1132(c0255.m1245()) + ");mraidbridge.setCurrentPosition(" + m1125(c0255.m1247()) + ");mraidbridge.setDefaultPosition(" + m1125(c0255.m1249()) + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.notifySizeChangeEvent(");
        sb.append(m1132(c0255.m1247()));
        sb.append(")");
        m1146(sb.toString());
    }

    public void setContentHtml(@NonNull String str) {
        if (this.f1303 == null) {
            MoPubLog.d("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.f1305 = false;
        MraidWebView mraidWebView = this.f1303;
        mraidWebView.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "UTF-8", null);
    }

    public void setContentUrl(String str) {
        if (this.f1303 == null) {
            MoPubLog.d("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.f1305 = false;
        this.f1303.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1140() {
        if (this.f1303 != null) {
            this.f1303.destroy();
            this.f1303 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1141(@Nullable MraidBridgeListener mraidBridgeListener) {
        this.f1302 = mraidBridgeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1142(@NonNull MraidWebView mraidWebView) {
        this.f1303 = mraidWebView;
        this.f1303.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17 && this.f1300 == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f1303.setScrollContainer(false);
        this.f1303.setVerticalScrollBarEnabled(false);
        this.f1303.setHorizontalScrollBarEnabled(false);
        this.f1303.setBackgroundColor(-16777216);
        this.f1303.setWebViewClient(this.f1306);
        this.f1303.setWebChromeClient(new WebChromeClient() { // from class: com.mopub.mraid.MraidBridge.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidBridge.this.f1302 != null ? MraidBridge.this.f1302.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return MraidBridge.this.f1302 != null ? MraidBridge.this.f1302.onJsAlert(str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        final ViewGestureDetector viewGestureDetector = new ViewGestureDetector(this.f1303.getContext(), this.f1303, this.f1299);
        viewGestureDetector.setUserClickListener(new ViewGestureDetector.UserClickListener() { // from class: com.mopub.mraid.MraidBridge.2
            @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
            public void onResetUserClick() {
                MraidBridge.this.f1304 = false;
            }

            @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
            public void onUserClick() {
                MraidBridge.this.f1304 = true;
            }

            @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
            public boolean wasClicked() {
                return MraidBridge.this.f1304;
            }
        });
        this.f1303.setOnTouchListener(new View.OnTouchListener() { // from class: com.mopub.mraid.MraidBridge.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                viewGestureDetector.sendTouchEvent(motionEvent);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (view.hasFocus()) {
                            return false;
                        }
                        view.requestFocus();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.f1303.setVisibilityChangedListener(new MraidWebView.OnVisibilityChangedListener() { // from class: com.mopub.mraid.MraidBridge.4
            @Override // com.mopub.mraid.MraidBridge.MraidWebView.OnVisibilityChangedListener
            public void onVisibilityChanged(boolean z) {
                if (MraidBridge.this.f1302 != null) {
                    MraidBridge.this.f1302.onVisibilityChanged(z);
                }
            }
        });
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1143(@NonNull final MraidJavascriptCommand mraidJavascriptCommand, @NonNull Map<String, String> map) throws C0253 {
        if (mraidJavascriptCommand.mo1204(this.f1300) && !this.f1304) {
            throw new C0253("Cannot execute this command unless the user clicks");
        }
        if (this.f1302 == null) {
            throw new C0253("Invalid state to execute this command");
        }
        if (this.f1303 == null) {
            throw new C0253("The current WebView is being destroyed");
        }
        switch (mraidJavascriptCommand) {
            case CLOSE:
                this.f1302.onClose();
                return;
            case RESIZE:
                this.f1302.onResize(m1122(m1134(map.get("width")), 0, 100000), m1122(m1134(map.get("height")), 0, 100000), m1122(m1134(map.get("offsetX")), -100000, 100000), m1122(m1134(map.get("offsetY")), -100000, 100000), m1123(map.get("customClosePosition"), CloseableLayout.ClosePosition.TOP_RIGHT), m1131(map.get("allowOffscreen"), true));
                return;
            case EXPAND:
                this.f1302.onExpand(m1126(map.get("url"), (URI) null), m1131(map.get("shouldUseCustomClose"), false));
                return;
            case USE_CUSTOM_CLOSE:
                this.f1302.onUseCustomClose(m1131(map.get("shouldUseCustomClose"), false));
                return;
            case OPEN:
                this.f1302.onOpen(m1138(map.get("url")));
                return;
            case SET_ORIENTATION_PROPERTIES:
                this.f1302.onSetOrientationProperties(m1137(map.get("allowOrientationChange")), m1136(map.get("forceOrientation")));
                return;
            case PLAY_VIDEO:
                this.f1302.onPlayVideo(m1138(map.get("uri")));
                return;
            case STORE_PICTURE:
                this.f1301.m1214(this.f1303.getContext(), m1138(map.get("uri")).toString(), new MraidNativeCommandHandler.InterfaceC0252() { // from class: com.mopub.mraid.MraidBridge.6
                    @Override // com.mopub.mraid.MraidNativeCommandHandler.InterfaceC0252
                    public void onFailure(C0253 c0253) {
                        MraidBridge.this.m1129(mraidJavascriptCommand, c0253.getMessage());
                    }
                });
                return;
            case CREATE_CALENDAR_EVENT:
                this.f1301.m1215(this.f1303.getContext(), map);
                return;
            case UNSPECIFIED:
                throw new C0253("Unspecified MRAID Javascript command");
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1144(PlacementType placementType) {
        m1146("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.m1234()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1145(ViewState viewState) {
        m1146("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1146(@NonNull String str) {
        if (this.f1303 == null) {
            MoPubLog.d("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        MoPubLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        MraidWebView mraidWebView = this.f1303;
        mraidWebView.loadUrl("javascript:" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1147(boolean z) {
        m1146("mraidbridge.setIsViewable(" + z + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1148(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        m1146("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1149() {
        m1146("mraidbridge.notifyReadyEvent();");
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    boolean m1150(@NonNull String str) {
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (BuildConfig.SDK_NAME.equals(scheme)) {
                if ("failLoad".equals(host) && this.f1300 == PlacementType.INLINE && this.f1302 != null) {
                    this.f1302.onPageFailedToLoad();
                }
                return true;
            } else if (AdType.MRAID.equals(scheme)) {
                HashMap hashMap = new HashMap();
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(uri, "UTF-8")) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
                MraidJavascriptCommand m1202 = MraidJavascriptCommand.m1202(host);
                try {
                    m1143(m1202, hashMap);
                } catch (C0253 e) {
                    m1129(m1202, e.getMessage());
                }
                m1128(m1202);
                return true;
            } else {
                if (this.f1304) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    try {
                        if (this.f1303 == null) {
                            MoPubLog.d("WebView was detached. Unable to load a URL");
                            return true;
                        }
                        this.f1303.getContext().startActivity(intent);
                        return true;
                    } catch (ActivityNotFoundException unused) {
                        MoPubLog.d("No activity found to handle this URL " + str);
                    }
                }
                return false;
            }
        } catch (URISyntaxException unused2) {
            MoPubLog.d("Invalid MRAID URL: " + str);
            m1129(MraidJavascriptCommand.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m1151() {
        MraidWebView mraidWebView = this.f1303;
        return mraidWebView != null && mraidWebView.isMraidViewable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m1152() {
        return this.f1303 != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m1153() {
        return this.f1305;
    }
}
