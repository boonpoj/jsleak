package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface;
import com.mopub.common.ExternalViewabilitySession;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;
import java.util.Set;
/* renamed from: com.mopub.common.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0187 implements ExternalViewabilitySession {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Object f644;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Object f645;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static Boolean f646;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static boolean f647;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Object f648;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Object f649;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m596(@NonNull ExternalViewabilitySession.VideoEvent videoEvent) throws Exception {
        m597(videoEvent, null);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m597(@NonNull ExternalViewabilitySession.VideoEvent videoEvent, @Nullable String str) throws Exception {
        Reflection.MethodBuilder methodBuilder = new Reflection.MethodBuilder(new Reflection.MethodBuilder(this.f649, "getAvidVideoPlaybackListener").execute(), videoEvent.getAvidMethodName());
        if (!TextUtils.isEmpty(str)) {
            methodBuilder.addParam((Class<Class>) String.class, (Class) str);
        }
        methodBuilder.execute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m598() {
        return !f647 && m600();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m599() {
        f647 = true;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m600() {
        if (f646 == null) {
            f646 = Boolean.valueOf(Reflection.classFound("com.integralads.avid.library.mopub.session.AvidAdSessionManager"));
            StringBuilder sb = new StringBuilder();
            sb.append("Avid is ");
            sb.append(f646.booleanValue() ? "" : "un");
            sb.append("available via reflection.");
            MoPubLog.d(sb.toString());
        }
        return f646.booleanValue();
    }

    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    private static Object m601() {
        if (f644 == null) {
            try {
                f644 = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, new Class[]{String.class, Boolean.TYPE}, new Object[]{"5.4.1", true});
            } catch (Exception e) {
                MoPubLog.d("Unable to generate Avid deferred ad session context: " + e.getMessage());
            }
        }
        return f644;
    }

    @Nullable
    /* renamed from: ࢥ  reason: contains not printable characters */
    private static Object m602() {
        if (f645 == null) {
            try {
                f645 = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, new Class[]{String.class}, new Object[]{"5.4.1"});
            } catch (Exception e) {
                MoPubLog.d("Unable to generate Avid ad session context: " + e.getMessage());
            }
        }
        return f645;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean createDisplaySession(@NonNull Context context, @NonNull WebView webView, boolean z) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webView);
        if (m598()) {
            Object m601 = z ? m601() : m602();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            try {
                this.f648 = new Reflection.MethodBuilder(null, "startAvidDisplayAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam((Class<Class>) Context.class, (Class) context).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", m601).execute();
                new Reflection.MethodBuilder(this.f648, "registerAdView").addParam((Class<Class>) View.class, (Class) webView).addParam((Class<Class>) Activity.class, (Class) activity).execute();
                return true;
            } catch (Exception e) {
                MoPubLog.d("Unable to execute Avid start display session: " + e.getMessage());
                return false;
            }
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean createVideoSession(@NonNull Activity activity, @NonNull View view, @NonNull Set<String> set, @NonNull Map<String, String> map) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(map);
        if (m598()) {
            try {
                this.f649 = new Reflection.MethodBuilder(null, "startAvidManagedVideoAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam((Class<Class>) Context.class, (Class) activity).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", m602()).execute();
                new Reflection.MethodBuilder(this.f649, "registerAdView").addParam((Class<Class>) View.class, (Class) view).addParam((Class<Class>) Activity.class, (Class) activity).execute();
                if (!TextUtils.isEmpty(map.get(AvidJavascriptInterface.AVID_OBJECT))) {
                    new Reflection.MethodBuilder(this.f649, "injectJavaScriptResource").addParam((Class<Class>) String.class, (Class) map.get(AvidJavascriptInterface.AVID_OBJECT)).execute();
                }
                for (String str : set) {
                    if (!TextUtils.isEmpty(str)) {
                        new Reflection.MethodBuilder(this.f649, "injectJavaScriptResource").addParam((Class<Class>) String.class, (Class) str).execute();
                    }
                }
                return true;
            } catch (Exception e) {
                MoPubLog.d("Unable to execute Avid start video session: " + e.getMessage());
                return false;
            }
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean endDisplaySession() {
        String str;
        if (m598()) {
            if (this.f648 == null) {
                str = "Avid DisplayAdSession unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f648, "endSession").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Avid end session: " + e.getMessage();
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
        if (m598()) {
            if (this.f649 == null) {
                str = "Avid VideoAdSession unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f649, "endSession").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Avid end video session: " + e.getMessage();
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
        return VastExtensionXmlManager.AVID;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean initialize(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        return !m598() ? null : true;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean invalidate() {
        if (m598()) {
            this.f648 = null;
            this.f649 = null;
            return true;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean onVideoPrepared(@NonNull View view, int i) {
        Preconditions.checkNotNull(view);
        return !m598() ? null : true;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean recordVideoEvent(@NonNull ExternalViewabilitySession.VideoEvent videoEvent, int i) {
        String str;
        Preconditions.checkNotNull(videoEvent);
        if (m598()) {
            if (this.f649 == null) {
                str = "Avid VideoAdSession unexpectedly null.";
            } else {
                try {
                    switch (videoEvent) {
                        case AD_LOADED:
                        case AD_STARTED:
                        case AD_STOPPED:
                        case AD_PAUSED:
                        case AD_PLAYING:
                        case AD_SKIPPED:
                        case AD_IMPRESSED:
                        case AD_CLICK_THRU:
                        case AD_VIDEO_FIRST_QUARTILE:
                        case AD_VIDEO_MIDPOINT:
                        case AD_VIDEO_THIRD_QUARTILE:
                        case AD_COMPLETE:
                            m596(videoEvent);
                            return true;
                        case RECORD_AD_ERROR:
                            m597(videoEvent, "error");
                            return true;
                        default:
                            MoPubLog.d("Unexpected video event type: " + videoEvent);
                            return false;
                    }
                } catch (Exception e) {
                    str = "Unable to execute Avid video event for " + videoEvent.getAvidMethodName() + ": " + e.getMessage();
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
        String str;
        Preconditions.checkNotNull(view);
        if (m598()) {
            if (this.f649 == null) {
                str = "Avid VideoAdSession unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(this.f649, "registerFriendlyObstruction").addParam((Class<Class>) View.class, (Class) view).execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to register Avid video obstructions: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }

    @Override // com.mopub.common.ExternalViewabilitySession
    @Nullable
    public Boolean startDeferredDisplaySession(@NonNull Activity activity) {
        String str;
        if (m598()) {
            if (this.f648 == null) {
                str = "Avid DisplayAdSession unexpectedly null.";
            } else {
                try {
                    new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "getInstance").setStatic("com.integralads.avid.library.mopub.AvidManager").execute(), "registerActivity").addParam((Class<Class>) Activity.class, (Class) activity).execute();
                    Object execute = new Reflection.MethodBuilder(this.f648, "getAvidDeferredAdSessionListener").execute();
                    if (execute == null) {
                        MoPubLog.d("Avid AdSessionListener unexpectedly null.");
                        return false;
                    }
                    new Reflection.MethodBuilder(execute, "recordReadyEvent").execute();
                    return true;
                } catch (Exception e) {
                    str = "Unable to execute Avid record deferred session: " + e.getMessage();
                }
            }
            MoPubLog.d(str);
            return false;
        }
        return null;
    }
}
