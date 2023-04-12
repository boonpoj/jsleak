package com.mopub.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.ExternalViewabilitySession;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* renamed from: com.mopub.common.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0191 implements ExternalViewabilitySession {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Boolean f663 = null;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean f664 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean f665 = false;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static final Map<String, String> f666 = new HashMap();
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Object f667;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Object f668;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Map<String, String> f669 = new HashMap();

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f670;

    static {
        f666.put("moatClientLevel1", "level1");
        f666.put("moatClientLevel2", "level2");
        f666.put("moatClientLevel3", "level3");
        f666.put("moatClientLevel4", "level4");
        f666.put("moatClientSlicer1", "slicer1");
        f666.put("moatClientSlicer2", "slicer2");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m608(@Nullable String str, @Nullable Set<String> set) {
        this.f669.clear();
        this.f669.put("partnerCode", "mopubinapphtmvideo468906546585");
        this.f669.put("zMoatVASTIDs", TextUtils.join(";", set));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri parse = Uri.parse(str);
        List<String> pathSegments = parse.getPathSegments();
        if (pathSegments.size() > 0 && !TextUtils.isEmpty(pathSegments.get(0))) {
            this.f669.put("partnerCode", pathSegments.get(0));
        }
        String fragment = parse.getFragment();
        if (TextUtils.isEmpty(fragment)) {
            return;
        }
        for (String str2 : fragment.split("&")) {
            String[] split = str2.split("=");
            if (split.length >= 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && f666.containsKey(str3)) {
                    this.f669.put(f666.get(str3), str4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m609() {
        return !f664 && m612();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m610(@NonNull ExternalViewabilitySession.VideoEvent videoEvent, int i) throws Exception {
        if (videoEvent.getMoatEnumName() == null) {
            return false;
        }
        Class<?> cls = Class.forName("com.moat.analytics.mobile.mpub.MoatAdEventType");
        new Reflection.MethodBuilder(this.f668, "dispatchEvent").addParam("com.moat.analytics.mobile.mpub.MoatAdEvent", Reflection.instantiateClassWithConstructor("com.moat.analytics.mobile.mpub.MoatAdEvent", Object.class, new Class[]{cls, Integer.class}, new Object[]{Enum.valueOf(cls.asSubclass(Enum.class), videoEvent.getMoatEnumName()), Integer.valueOf(i)})).execute();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m611() {
        f664 = true;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m612() {
        if (f663 == null) {
            f663 = Boolean.valueOf(Reflection.classFound("com.moat.analytics.mobile.mpub.MoatFactory"));
            StringBuilder sb = new StringBuilder();
            sb.append("Moat is ");
            sb.append(f663.booleanValue() ? "" : "un");
            sb.append("available via reflection.");
            MoPubLog.d(sb.toString());
        }
        return f663.booleanValue();
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean createDisplaySession(@NonNull Context context, @NonNull WebView webView, boolean z) {
        Preconditions.checkNotNull(context);
        if (m609()) {
            try {
                this.f667 = new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createWebAdTracker").addParam((Class<Class>) WebView.class, (Class) webView).execute();
                if (!z) {
                    new Reflection.MethodBuilder(this.f667, "startTracking").execute();
                }
                return true;
            } catch (Exception e) {
                MoPubLog.d("Unable to execute Moat start display session: " + e.getMessage());
                return false;
            }
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean createVideoSession(@NonNull Activity activity, @NonNull View view, @NonNull Set<String> set, @NonNull Map<String, String> map) {
        String str;
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(map);
        if (m609()) {
            m608(map.get("moat"), set);
            String str2 = this.f669.get("partnerCode");
            if (TextUtils.isEmpty(str2)) {
                str = "partnerCode was empty when starting Moat video session";
            } else {
                try {
                    this.f668 = new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createCustomTracker").addParam("com.moat.analytics.mobile.mpub.MoatPlugin", Reflection.instantiateClassWithConstructor("com.moat.analytics.mobile.mpub.ReactiveVideoTrackerPlugin", Object.class, new Class[]{String.class}, new Object[]{str2})).execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Moat start video session: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean endDisplaySession() {
        String str;
        if (m609()) {
            if (this.f667 == null) {
                str = "Moat WebAdTracker unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f667, "stopTracking").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Moat end session: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean endVideoSession() {
        String str;
        if (m609()) {
            if (this.f668 == null) {
                str = "Moat VideoAdTracker unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f668, "stopTracking").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Moat end video session: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @NonNull
    public String getName() {
        return VastExtensionXmlManager.MOAT;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean initialize(@NonNull Context context) {
        String str;
        Application application;
        Preconditions.checkNotNull(context);
        if (m609()) {
            if (f665) {
                return true;
            }
            if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                try {
                    application = (Application) context.getApplicationContext();
                } catch (ClassCastException unused) {
                    str = "Unable to initialize Moat, error obtaining application context.";
                    MoPubLog.d(str);
                    return false;
                }
            }
            try {
                Object instantiateClassWithEmptyConstructor = Reflection.instantiateClassWithEmptyConstructor("com.moat.analytics.mobile.mpub.MoatOptions", Object.class);
                instantiateClassWithEmptyConstructor.getClass().getField("disableAdIdCollection").setBoolean(instantiateClassWithEmptyConstructor, true);
                instantiateClassWithEmptyConstructor.getClass().getField("disableLocationServices").setBoolean(instantiateClassWithEmptyConstructor, true);
                new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "getInstance").setStatic("com.moat.analytics.mobile.mpub.MoatAnalytics").execute(), "start").addParam("com.moat.analytics.mobile.mpub.MoatOptions", instantiateClassWithEmptyConstructor).addParam((Class<Class>) Application.class, (Class) application).execute();
                f665 = true;
                return true;
            } catch (Exception e) {
                str = "Unable to initialize Moat: " + e.getMessage();
                MoPubLog.d(str);
                return false;
            }
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean invalidate() {
        if (m609()) {
            this.f667 = null;
            this.f668 = null;
            this.f669.clear();
            return true;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean onVideoPrepared(@NonNull View view, int i) {
        String str;
        Preconditions.checkNotNull(view);
        if (m609()) {
            if (this.f668 == null) {
                str = "Moat VideoAdTracker unexpectedly null.";
            } else if (this.f670) {
                return false;
            } else {
                try {
                    new Reflection.MethodBuilder(this.f668, "trackVideoAd").addParam((Class<Class>) Map.class, (Class) this.f669).addParam((Class<Class>) Integer.class, (Class) Integer.valueOf(i)).addParam((Class<Class>) View.class, (Class) view).execute();
                    this.f670 = true;
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Moat onVideoPrepared: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean recordVideoEvent(@NonNull ExternalViewabilitySession.VideoEvent videoEvent, int i) {
        String str;
        Preconditions.checkNotNull(videoEvent);
        if (m609()) {
            if (this.f668 == null) {
                str = "Moat VideoAdTracker unexpectedly null.";
            } else {
                try {
                    switch (videoEvent) {
                        case AD_STARTED:
                        case AD_STOPPED:
                        case AD_PAUSED:
                        case AD_PLAYING:
                        case AD_SKIPPED:
                        case AD_VIDEO_FIRST_QUARTILE:
                        case AD_VIDEO_MIDPOINT:
                        case AD_VIDEO_THIRD_QUARTILE:
                        case AD_COMPLETE:
                            m610(videoEvent, i);
                            return true;
                        case AD_LOADED:
                        case AD_IMPRESSED:
                        case AD_CLICK_THRU:
                        case RECORD_AD_ERROR:
                            return null;
                        default:
                            MoPubLog.d("Unexpected video event: " + videoEvent.getMoatEnumName());
                            return false;
                    }
                } catch (Exception e) {
                    str = "Video event " + videoEvent.getMoatEnumName() + " failed. " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean registerVideoObstruction(@NonNull View view) {
        Preconditions.checkNotNull(view);
        return !m609() ? null : true;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean startDeferredDisplaySession(@NonNull Activity activity) {
        String str;
        if (m609()) {
            if (this.f667 == null) {
                str = "MoatWebAdTracker unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f667, "startTracking").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to record deferred display session for Moat: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }
}
