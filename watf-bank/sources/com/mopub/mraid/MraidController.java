package com.mopub.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.WebViewCacheService;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge;
import java.lang.ref.WeakReference;
import java.net.URI;
/* loaded from: assets/classes2.dex */
public class MraidController {
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private MraidWebViewDebugListener f1320;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private MraidBridge.MraidWebView f1321;
    @Nullable

    /* renamed from: ހ  reason: contains not printable characters */
    private MraidBridge.MraidWebView f1322;
    @NonNull

    /* renamed from: ށ  reason: contains not printable characters */
    private final MraidBridge f1323;
    @NonNull

    /* renamed from: ނ  reason: contains not printable characters */
    private final MraidBridge f1324;
    @NonNull

    /* renamed from: ރ  reason: contains not printable characters */
    private C0245 f1325;
    @Nullable

    /* renamed from: ބ  reason: contains not printable characters */
    private Integer f1326;

    /* renamed from: ޅ  reason: contains not printable characters */
    private boolean f1327;

    /* renamed from: ކ  reason: contains not printable characters */
    private EnumC0254 f1328;

    /* renamed from: އ  reason: contains not printable characters */
    private final MraidNativeCommandHandler f1329;

    /* renamed from: ވ  reason: contains not printable characters */
    private boolean f1330;

    /* renamed from: މ  reason: contains not printable characters */
    private final MraidBridge.MraidBridgeListener f1331;

    /* renamed from: ފ  reason: contains not printable characters */
    private final MraidBridge.MraidBridgeListener f1332;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AdReport f1333;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WeakReference<Activity> f1334;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Context f1335;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final PlacementType f1336;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final FrameLayout f1337;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final CloseableLayout f1338;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private ViewGroup f1339;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final C0246 f1340;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final C0255 f1341;
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private ViewState f1342;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private MraidListener f1343;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private UseCustomCloseListener f1344;

    /* loaded from: assets/classes2.dex */
    public interface MraidListener {
        void onClose();

        void onExpand();

        void onFailedToLoad();

        void onLoaded(View view);

        void onOpen();
    }

    /* loaded from: assets/classes2.dex */
    public interface MraidWebViewCacheListener {
        void onReady(MraidBridge.MraidWebView mraidWebView, ExternalViewabilitySessionManager externalViewabilitySessionManager);
    }

    /* loaded from: assets/classes2.dex */
    public interface UseCustomCloseListener {
        void useCustomCloseChanged(boolean z);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class C0245 extends BroadcastReceiver {
        @Nullable

        /* renamed from: ࢢ  reason: contains not printable characters */
        private Context f1355;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private int f1356 = -1;

        C0245() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int m1165;
            if (this.f1355 == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (m1165 = MraidController.this.m1165()) == this.f1356) {
                return;
            }
            this.f1356 = m1165;
            MraidController.this.m1179(this.f1356);
        }

        public void register(@NonNull Context context) {
            Preconditions.checkNotNull(context);
            this.f1355 = context.getApplicationContext();
            if (this.f1355 != null) {
                this.f1355.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public void unregister() {
            if (this.f1355 != null) {
                this.f1355.unregisterReceiver(this);
                this.f1355 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0246 {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Handler f1357 = new Handler();
        @Nullable

        /* renamed from: ࢢ  reason: contains not printable characters */
        private C0247 f1358;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.mraid.MraidController$ࢢ$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public static class C0247 {

            /* renamed from: ࢠ  reason: contains not printable characters */
            int f1359;
            @NonNull

            /* renamed from: ࢢ  reason: contains not printable characters */
            private final View[] f1360;
            @NonNull

            /* renamed from: ࢣ  reason: contains not printable characters */
            private final Handler f1361;
            @Nullable

            /* renamed from: ࢤ  reason: contains not printable characters */
            private Runnable f1362;

            /* renamed from: ࢥ  reason: contains not printable characters */
            private final Runnable f1363;

            private C0247(@NonNull Handler handler, @NonNull View[] viewArr) {
                this.f1363 = new Runnable() { // from class: com.mopub.mraid.MraidController.ࢢ.ࢠ.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View[] viewArr2;
                        for (final View view : C0247.this.f1360) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                C0247.this.m1198();
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.mopub.mraid.MraidController.ࢢ.ࢠ.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        C0247.this.m1198();
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.f1361 = handler;
                this.f1360 = viewArr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: ࢢ  reason: contains not printable characters */
            public void m1198() {
                this.f1359--;
                if (this.f1359 != 0 || this.f1362 == null) {
                    return;
                }
                this.f1362.run();
                this.f1362 = null;
            }

            /* renamed from: ࢠ  reason: contains not printable characters */
            void m1200() {
                this.f1361.removeCallbacks(this.f1363);
                this.f1362 = null;
            }

            /* renamed from: ࢠ  reason: contains not printable characters */
            void m1201(@NonNull Runnable runnable) {
                this.f1362 = runnable;
                this.f1359 = this.f1360.length;
                this.f1361.post(this.f1363);
            }
        }

        C0246() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        C0247 m1195(@NonNull View... viewArr) {
            this.f1358 = new C0247(this.f1357, viewArr);
            return this.f1358;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1196() {
            if (this.f1358 != null) {
                this.f1358.m1200();
                this.f1358 = null;
            }
        }
    }

    public MraidController(@NonNull Context context, @Nullable AdReport adReport, @NonNull PlacementType placementType) {
        this(context, adReport, placementType, new MraidBridge(adReport, placementType), new MraidBridge(adReport, PlacementType.INTERSTITIAL), new C0246());
    }

    @VisibleForTesting
    MraidController(@NonNull Context context, @Nullable AdReport adReport, @NonNull PlacementType placementType, @NonNull MraidBridge mraidBridge, @NonNull MraidBridge mraidBridge2, @NonNull C0246 c0246) {
        this.f1342 = ViewState.LOADING;
        this.f1325 = new C0245();
        this.f1327 = true;
        this.f1328 = EnumC0254.NONE;
        this.f1331 = new MraidBridge.MraidBridgeListener() { // from class: com.mopub.mraid.MraidController.3
            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onClose() {
                MraidController.this.mo1191();
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidController.this.m1185(consoleMessage);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onExpand(@Nullable URI uri, boolean z) throws C0253 {
                MraidController.this.m1182(uri, z);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult) {
                return MraidController.this.m1187(str, jsResult);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onOpen(@NonNull URI uri) {
                MraidController.this.m1190(uri.toString());
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPageFailedToLoad() {
                if (MraidController.this.f1343 != null) {
                    MraidController.this.f1343.onFailedToLoad();
                }
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPageLoaded() {
                MraidController.this.m1178();
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPlayVideo(@NonNull URI uri) {
                MraidController.this.m1181(uri.toString());
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onResize(int i, int i2, int i3, int i4, @NonNull CloseableLayout.ClosePosition closePosition, boolean z) throws C0253 {
                MraidController.this.m1180(i, i2, i3, i4, closePosition, z);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onSetOrientationProperties(boolean z, EnumC0254 enumC0254) throws C0253 {
                MraidController.this.m1184(z, enumC0254);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onUseCustomClose(boolean z) {
                MraidController.this.mo1183(z);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onVisibilityChanged(boolean z) {
                if (MraidController.this.f1324.m1152()) {
                    return;
                }
                MraidController.this.f1323.m1147(z);
            }
        };
        this.f1332 = new MraidBridge.MraidBridgeListener() { // from class: com.mopub.mraid.MraidController.4
            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onClose() {
                MraidController.this.mo1191();
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidController.this.m1185(consoleMessage);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onExpand(@Nullable URI uri, boolean z) {
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult) {
                return MraidController.this.m1187(str, jsResult);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onOpen(URI uri) {
                MraidController.this.m1190(uri.toString());
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPageFailedToLoad() {
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPageLoaded() {
                MraidController.this.m1188();
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onPlayVideo(@NonNull URI uri) {
                MraidController.this.m1181(uri.toString());
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onResize(int i, int i2, int i3, int i4, @NonNull CloseableLayout.ClosePosition closePosition, boolean z) throws C0253 {
                throw new C0253("Not allowed to resize from an expanded state");
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onSetOrientationProperties(boolean z, EnumC0254 enumC0254) throws C0253 {
                MraidController.this.m1184(z, enumC0254);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onUseCustomClose(boolean z) {
                MraidController.this.mo1183(z);
            }

            @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
            public void onVisibilityChanged(boolean z) {
                MraidController.this.f1323.m1147(z);
                MraidController.this.f1324.m1147(z);
            }
        };
        this.f1335 = context.getApplicationContext();
        Preconditions.checkNotNull(this.f1335);
        this.f1333 = adReport;
        if (context instanceof Activity) {
            this.f1334 = new WeakReference<>((Activity) context);
        } else {
            this.f1334 = new WeakReference<>(null);
        }
        this.f1336 = placementType;
        this.f1323 = mraidBridge;
        this.f1324 = mraidBridge2;
        this.f1340 = c0246;
        this.f1342 = ViewState.LOADING;
        this.f1341 = new C0255(this.f1335, this.f1335.getResources().getDisplayMetrics().density);
        this.f1337 = new FrameLayout(this.f1335);
        this.f1338 = new CloseableLayout(this.f1335);
        this.f1338.setOnCloseListener(new CloseableLayout.OnCloseListener() { // from class: com.mopub.mraid.MraidController.1
            @Override // com.mopub.common.CloseableLayout.OnCloseListener
            public void onClose() {
                MraidController.this.mo1191();
            }
        });
        View view = new View(this.f1335);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.mopub.mraid.MraidController.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f1338.addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.f1325.register(this.f1335);
        this.f1323.m1141(this.f1331);
        this.f1324.m1141(this.f1332);
        this.f1329 = new MraidNativeCommandHandler();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1156(@NonNull ViewState viewState) {
        m1157(viewState, (Runnable) null);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1157(@NonNull ViewState viewState, @Nullable Runnable runnable) {
        MoPubLog.d("MRAID state set to " + viewState);
        ViewState viewState2 = this.f1342;
        this.f1342 = viewState;
        this.f1323.m1145(viewState);
        if (this.f1324.m1153()) {
            this.f1324.m1145(viewState);
        }
        if (this.f1343 != null) {
            if (viewState == ViewState.EXPANDED) {
                this.f1343.onExpand();
            } else if ((viewState2 == ViewState.EXPANDED && viewState == ViewState.DEFAULT) || viewState == ViewState.HIDDEN) {
                this.f1343.onClose();
            }
        }
        m1158(runnable);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1158(@Nullable final Runnable runnable) {
        this.f1340.m1196();
        final MraidBridge.MraidWebView currentWebView = getCurrentWebView();
        if (currentWebView == null) {
            return;
        }
        this.f1340.m1195(this.f1337, currentWebView).m1201(new Runnable() { // from class: com.mopub.mraid.MraidController.7
            @Override // java.lang.Runnable
            public void run() {
                DisplayMetrics displayMetrics = MraidController.this.f1335.getResources().getDisplayMetrics();
                MraidController.this.f1341.m1241(displayMetrics.widthPixels, displayMetrics.heightPixels);
                int[] iArr = new int[2];
                ViewGroup m1173 = MraidController.this.m1173();
                m1173.getLocationOnScreen(iArr);
                MraidController.this.f1341.m1242(iArr[0], iArr[1], m1173.getWidth(), m1173.getHeight());
                MraidController.this.f1337.getLocationOnScreen(iArr);
                MraidController.this.f1341.m1246(iArr[0], iArr[1], MraidController.this.f1337.getWidth(), MraidController.this.f1337.getHeight());
                currentWebView.getLocationOnScreen(iArr);
                MraidController.this.f1341.m1244(iArr[0], iArr[1], currentWebView.getWidth(), currentWebView.getHeight());
                MraidController.this.f1323.notifyScreenMetrics(MraidController.this.f1341);
                if (MraidController.this.f1324.m1152()) {
                    MraidController.this.f1324.notifyScreenMetrics(MraidController.this.f1341);
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1159(@Nullable Long l, @Nullable MraidWebViewCacheListener mraidWebViewCacheListener) {
        WebViewCacheService.Config popWebViewConfig;
        if (l != null && (popWebViewConfig = WebViewCacheService.popWebViewConfig(l)) != null && (popWebViewConfig.getWebView() instanceof MraidBridge.MraidWebView)) {
            this.f1321 = (MraidBridge.MraidWebView) popWebViewConfig.getWebView();
            this.f1321.enablePlugins(true);
            if (mraidWebViewCacheListener != null) {
                mraidWebViewCacheListener.onReady(this.f1321, popWebViewConfig.getViewabilityManager());
            }
            return true;
        }
        MoPubLog.d("WebView cache miss. Creating a new MraidWebView.");
        this.f1321 = new MraidBridge.MraidWebView(this.f1335);
        if (mraidWebViewCacheListener != null) {
            mraidWebViewCacheListener.onReady(this.f1321, null);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public int m1165() {
        return ((WindowManager) this.f1335.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public boolean m1168() {
        Activity activity = this.f1334.get();
        if (activity == null || getCurrentWebView() == null) {
            return false;
        }
        return this.f1329.m1216(activity, getCurrentWebView());
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m1170() {
        this.f1323.m1140();
        this.f1321 = null;
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m1172() {
        this.f1324.m1140();
        this.f1322 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: ࢫ  reason: contains not printable characters */
    public ViewGroup m1173() {
        if (this.f1339 != null) {
            return this.f1339;
        }
        View topmostView = Views.getTopmostView(this.f1334.get(), this.f1337);
        return topmostView instanceof ViewGroup ? (ViewGroup) topmostView : this.f1337;
    }

    @NonNull
    /* renamed from: ࢬ  reason: contains not printable characters */
    private ViewGroup m1176() {
        if (this.f1339 == null) {
            this.f1339 = m1173();
        }
        return this.f1339;
    }

    public void destroy() {
        this.f1340.m1196();
        try {
            this.f1325.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.f1330) {
            pause(true);
        }
        Views.removeFromParent(this.f1338);
        m1170();
        m1172();
    }

    public void fillContent(@Nullable Long l, @NonNull String str, @Nullable MraidWebViewCacheListener mraidWebViewCacheListener) {
        Preconditions.checkNotNull(str, "htmlData cannot be null");
        boolean m1159 = m1159(l, mraidWebViewCacheListener);
        Preconditions.NoThrow.checkNotNull(this.f1321, "mMraidWebView cannot be null");
        this.f1323.m1142(this.f1321);
        this.f1337.addView(this.f1321, new FrameLayout.LayoutParams(-1, -1));
        if (m1159) {
            m1178();
        } else {
            this.f1323.setContentHtml(str);
        }
    }

    @NonNull
    public FrameLayout getAdContainer() {
        return this.f1337;
    }

    @NonNull
    public Context getContext() {
        return this.f1335;
    }

    @Nullable
    public MraidBridge.MraidWebView getCurrentWebView() {
        return this.f1324.m1152() ? this.f1322 : this.f1321;
    }

    public void loadJavascript(@NonNull String str) {
        this.f1323.m1146(str);
    }

    public void pause(boolean z) {
        this.f1330 = true;
        if (this.f1321 != null) {
            WebViews.onPause(this.f1321, z);
        }
        if (this.f1322 != null) {
            WebViews.onPause(this.f1322, z);
        }
    }

    public void resume() {
        this.f1330 = false;
        if (this.f1321 != null) {
            this.f1321.onResume();
        }
        if (this.f1322 != null) {
            this.f1322.onResume();
        }
    }

    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f1320 = mraidWebViewDebugListener;
    }

    public void setMraidListener(@Nullable MraidListener mraidListener) {
        this.f1343 = mraidListener;
    }

    public void setUseCustomCloseListener(@Nullable UseCustomCloseListener useCustomCloseListener) {
        this.f1344 = useCustomCloseListener;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    int m1177(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1178() {
        m1157(ViewState.DEFAULT, new Runnable() { // from class: com.mopub.mraid.MraidController.5
            @Override // java.lang.Runnable
            public void run() {
                MraidController.this.f1323.m1148(MraidController.this.f1329.m1219(MraidController.this.f1335), MraidController.this.f1329.m1217(MraidController.this.f1335), MraidNativeCommandHandler.m1213(MraidController.this.f1335), MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.f1335), MraidController.this.m1168());
                MraidController.this.f1323.m1144(MraidController.this.f1336);
                MraidController.this.f1323.m1147(MraidController.this.f1323.m1151());
                MraidController.this.f1323.m1149();
            }
        });
        if (this.f1343 != null) {
            this.f1343.onLoaded(this.f1337);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1179(int i) {
        m1158((Runnable) null);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1180(int i, int i2, int i3, int i4, @NonNull CloseableLayout.ClosePosition closePosition, boolean z) throws C0253 {
        if (this.f1321 == null) {
            throw new C0253("Unable to resize after the WebView is destroyed");
        }
        if (this.f1342 == ViewState.LOADING || this.f1342 == ViewState.HIDDEN) {
            return;
        }
        if (this.f1342 == ViewState.EXPANDED) {
            throw new C0253("Not allowed to resize from an already expanded ad");
        }
        if (this.f1336 == PlacementType.INTERSTITIAL) {
            throw new C0253("Not allowed to resize from an interstitial ad");
        }
        int dipsToIntPixels = Dips.dipsToIntPixels(i, this.f1335);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(i2, this.f1335);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(i3, this.f1335);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(i4, this.f1335);
        int i5 = this.f1341.m1248().left + dipsToIntPixels3;
        int i6 = this.f1341.m1248().top + dipsToIntPixels4;
        Rect rect = new Rect(i5, i6, dipsToIntPixels + i5, i6 + dipsToIntPixels2);
        if (!z) {
            Rect m1243 = this.f1341.m1243();
            if (rect.width() > m1243.width() || rect.height() > m1243.height()) {
                throw new C0253("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the ad to appear within the max allowed size (" + this.f1341.m1245().width() + ", " + this.f1341.m1245().height() + ")");
            }
            rect.offsetTo(m1177(m1243.left, rect.left, m1243.right - rect.width()), m1177(m1243.top, rect.top, m1243.bottom - rect.height()));
        }
        Rect rect2 = new Rect();
        this.f1338.applyCloseRegionBounds(closePosition, rect, rect2);
        if (!this.f1341.m1243().contains(rect2)) {
            throw new C0253("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the close region to appear within the max allowed size (" + this.f1341.m1245().width() + ", " + this.f1341.m1245().height() + ")");
        } else if (!rect.contains(rect2)) {
            throw new C0253("resizeProperties specified a size (" + i + ", " + dipsToIntPixels2 + ") and offset (" + i3 + ", " + i4 + ") that don't allow the close region to appear within the resized ad.");
        } else {
            this.f1338.setCloseVisible(false);
            this.f1338.setClosePosition(closePosition);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
            layoutParams.leftMargin = rect.left - this.f1341.m1243().left;
            layoutParams.topMargin = rect.top - this.f1341.m1243().top;
            if (this.f1342 == ViewState.DEFAULT) {
                this.f1337.removeView(this.f1321);
                this.f1337.setVisibility(4);
                this.f1338.addView(this.f1321, new FrameLayout.LayoutParams(-1, -1));
                m1176().addView(this.f1338, layoutParams);
            } else if (this.f1342 == ViewState.RESIZED) {
                this.f1338.setLayoutParams(layoutParams);
            }
            this.f1338.setClosePosition(closePosition);
            m1156(ViewState.RESIZED);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1181(@NonNull String str) {
        MraidVideoPlayerActivity.startMraid(this.f1335, str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1182(@Nullable URI uri, boolean z) throws C0253 {
        CloseableLayout closeableLayout;
        MraidBridge.MraidWebView mraidWebView;
        if (this.f1321 == null) {
            throw new C0253("Unable to expand after the WebView is destroyed");
        }
        if (this.f1336 == PlacementType.INTERSTITIAL) {
            return;
        }
        if (this.f1342 == ViewState.DEFAULT || this.f1342 == ViewState.RESIZED) {
            m1192();
            boolean z2 = uri != null;
            if (z2) {
                this.f1322 = new MraidBridge.MraidWebView(this.f1335);
                this.f1324.m1142(this.f1322);
                this.f1324.setContentUrl(uri.toString());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (this.f1342 == ViewState.DEFAULT) {
                if (z2) {
                    closeableLayout = this.f1338;
                    mraidWebView = this.f1322;
                } else {
                    this.f1337.removeView(this.f1321);
                    this.f1337.setVisibility(4);
                    closeableLayout = this.f1338;
                    mraidWebView = this.f1321;
                }
                closeableLayout.addView(mraidWebView, layoutParams);
                m1176().addView(this.f1338, new FrameLayout.LayoutParams(-1, -1));
            } else if (this.f1342 == ViewState.RESIZED && z2) {
                this.f1338.removeView(this.f1321);
                this.f1337.addView(this.f1321, layoutParams);
                this.f1337.setVisibility(4);
                this.f1338.addView(this.f1322, layoutParams);
            }
            this.f1338.setLayoutParams(layoutParams);
            mo1183(z);
            m1156(ViewState.EXPANDED);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void mo1183(boolean z) {
        if (z == (!this.f1338.isCloseVisible())) {
            return;
        }
        this.f1338.setCloseVisible(!z);
        if (this.f1344 != null) {
            this.f1344.useCustomCloseChanged(z);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1184(boolean z, EnumC0254 enumC0254) throws C0253 {
        if (!m1186(enumC0254)) {
            throw new C0253("Unable to force orientation to " + enumC0254);
        }
        this.f1327 = z;
        this.f1328 = enumC0254;
        if (this.f1342 == ViewState.EXPANDED || this.f1336 == PlacementType.INTERSTITIAL) {
            m1192();
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m1185(@NonNull ConsoleMessage consoleMessage) {
        if (this.f1320 != null) {
            return this.f1320.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m1186(EnumC0254 enumC0254) {
        if (enumC0254 == EnumC0254.NONE) {
            return true;
        }
        Activity activity = this.f1334.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int i = activityInfo.screenOrientation;
            return i != -1 ? i == enumC0254.m1238() : Utils.bitMaskContainsFlag(activityInfo.configChanges, 128) && Utils.bitMaskContainsFlag(activityInfo.configChanges, 1024);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m1187(@NonNull String str, @NonNull JsResult jsResult) {
        if (this.f1320 != null) {
            return this.f1320.onJsAlert(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1188() {
        m1158(new Runnable() { // from class: com.mopub.mraid.MraidController.6
            @Override // java.lang.Runnable
            public void run() {
                MraidBridge mraidBridge = MraidController.this.f1324;
                boolean m1219 = MraidController.this.f1329.m1219(MraidController.this.f1335);
                boolean m1217 = MraidController.this.f1329.m1217(MraidController.this.f1335);
                MraidNativeCommandHandler unused = MraidController.this.f1329;
                boolean m1213 = MraidNativeCommandHandler.m1213(MraidController.this.f1335);
                MraidNativeCommandHandler unused2 = MraidController.this.f1329;
                mraidBridge.m1148(m1219, m1217, m1213, MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.f1335), MraidController.this.m1168());
                MraidController.this.f1324.m1145(MraidController.this.f1342);
                MraidController.this.f1324.m1144(MraidController.this.f1336);
                MraidController.this.f1324.m1147(MraidController.this.f1324.m1151());
                MraidController.this.f1324.m1149();
            }
        });
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1189(int i) throws C0253 {
        Activity activity = this.f1334.get();
        if (activity == null || !m1186(this.f1328)) {
            throw new C0253("Attempted to lock orientation to unsupported value: " + this.f1328.name());
        }
        if (this.f1326 == null) {
            this.f1326 = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i);
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1190(@NonNull String str) {
        if (this.f1343 != null) {
            this.f1343.onOpen();
        }
        UrlHandler.Builder builder = new UrlHandler.Builder();
        if (this.f1333 != null) {
            builder.withDspCreativeId(this.f1333.getDspCreativeId());
        }
        builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.f1335, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void mo1191() {
        ViewState viewState;
        if (this.f1321 == null || this.f1342 == ViewState.LOADING || this.f1342 == ViewState.HIDDEN) {
            return;
        }
        if (this.f1342 == ViewState.EXPANDED || this.f1336 == PlacementType.INTERSTITIAL) {
            m1193();
        }
        if (this.f1342 == ViewState.RESIZED || this.f1342 == ViewState.EXPANDED) {
            if (!this.f1324.m1152() || this.f1322 == null) {
                this.f1338.removeView(this.f1321);
                this.f1337.addView(this.f1321, new FrameLayout.LayoutParams(-1, -1));
                this.f1337.setVisibility(0);
            } else {
                MraidBridge.MraidWebView mraidWebView = this.f1322;
                m1172();
                this.f1338.removeView(mraidWebView);
            }
            Views.removeFromParent(this.f1338);
            viewState = ViewState.DEFAULT;
        } else if (this.f1342 != ViewState.DEFAULT) {
            return;
        } else {
            this.f1337.setVisibility(4);
            viewState = ViewState.HIDDEN;
        }
        m1156(viewState);
    }

    @VisibleForTesting
    /* renamed from: ࢤ  reason: contains not printable characters */
    void m1192() throws C0253 {
        int m1238;
        if (this.f1328 != EnumC0254.NONE) {
            m1238 = this.f1328.m1238();
        } else if (this.f1327) {
            m1193();
            return;
        } else {
            Activity activity = this.f1334.get();
            if (activity == null) {
                throw new C0253("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            m1238 = DeviceUtils.getScreenOrientation(activity);
        }
        m1189(m1238);
    }

    @VisibleForTesting
    /* renamed from: ࢥ  reason: contains not printable characters */
    void m1193() {
        Activity activity = this.f1334.get();
        if (activity != null && this.f1326 != null) {
            activity.setRequestedOrientation(this.f1326.intValue());
        }
        this.f1326 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public WeakReference<Activity> m1194() {
        return this.f1334;
    }
}
