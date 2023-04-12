package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.mopub.common.ExternalViewabilitySession;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastVideoConfig;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: assets/classes2.dex */
public class ExternalViewabilitySessionManager {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Set<ExternalViewabilitySession> f362;

    /* loaded from: assets/classes2.dex */
    public enum ViewabilityVendor {
        AVID,
        MOAT,
        ALL;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Nullable
        public static ViewabilityVendor fromKey(@NonNull String str) {
            char c;
            Preconditions.checkNotNull(str);
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (str.equals(InternalAvidAdSessionContext.AVID_API_LEVEL)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return AVID;
                case 1:
                    return MOAT;
                case 2:
                    return ALL;
                default:
                    return null;
            }
        }

        @NonNull
        public static String getEnabledVendorKey() {
            boolean m598 = C0187.m598();
            boolean m609 = C0191.m609();
            return (m598 && m609) ? "3" : m598 ? "1" : m609 ? InternalAvidAdSessionContext.AVID_API_LEVEL : "0";
        }

        public void disable() {
            StringBuilder sb;
            String str;
            switch (this) {
                case AVID:
                    C0187.m599();
                    sb = new StringBuilder();
                    str = "Disabled viewability for ";
                    break;
                case ALL:
                    C0187.m599();
                case MOAT:
                    C0191.m611();
                    sb = new StringBuilder();
                    str = "Disabled viewability for ";
                    break;
                default:
                    sb = new StringBuilder();
                    str = "Attempted to disable an invalid viewability vendor: ";
                    break;
            }
            sb.append(str);
            sb.append(this);
            MoPubLog.d(sb.toString());
        }
    }

    public ExternalViewabilitySessionManager(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        this.f362 = new HashSet();
        this.f362.add(new C0187());
        this.f362.add(new C0191());
        m423(context);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m423(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "initialize", externalViewabilitySession.initialize(context), false);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m424(@NonNull ExternalViewabilitySession externalViewabilitySession, @NonNull String str, @Nullable Boolean bool, boolean z) {
        Preconditions.checkNotNull(externalViewabilitySession);
        Preconditions.checkNotNull(str);
        if (bool == null) {
            return;
        }
        String format = String.format(Locale.US, "%s viewability event: %s%s.", externalViewabilitySession.getName(), bool.booleanValue() ? "" : "failed to ", str);
        if (z) {
            MoPubLog.v(format);
        } else {
            MoPubLog.d(format);
        }
    }

    public void createDisplaySession(@NonNull Context context, @NonNull WebView webView) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webView);
        createDisplaySession(context, webView, false);
    }

    public void createDisplaySession(@NonNull Context context, @NonNull WebView webView, boolean z) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webView);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "start display session", externalViewabilitySession.createDisplaySession(context, webView, z), true);
        }
    }

    public void createVideoSession(@NonNull Activity activity, @NonNull View view, @NonNull VastVideoConfig vastVideoConfig) {
        Set<String> moatImpressionPixels;
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(vastVideoConfig);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            HashSet hashSet = new HashSet();
            if (externalViewabilitySession instanceof C0187) {
                moatImpressionPixels = vastVideoConfig.getAvidJavascriptResources();
            } else if (externalViewabilitySession instanceof C0191) {
                moatImpressionPixels = vastVideoConfig.getMoatImpressionPixels();
            } else {
                m424(externalViewabilitySession, "start video session", externalViewabilitySession.createVideoSession(activity, view, hashSet, vastVideoConfig.getExternalViewabilityTrackers()), true);
            }
            hashSet.addAll(moatImpressionPixels);
            m424(externalViewabilitySession, "start video session", externalViewabilitySession.createVideoSession(activity, view, hashSet, vastVideoConfig.getExternalViewabilityTrackers()), true);
        }
    }

    public void endDisplaySession() {
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "end display session", externalViewabilitySession.endDisplaySession(), true);
        }
    }

    public void endVideoSession() {
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "end video session", externalViewabilitySession.endVideoSession(), true);
        }
    }

    public void invalidate() {
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "invalidate", externalViewabilitySession.invalidate(), false);
        }
    }

    public void onVideoPrepared(@NonNull View view, int i) {
        Preconditions.checkNotNull(view);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "on video prepared", externalViewabilitySession.onVideoPrepared(view, i), true);
        }
    }

    public void recordVideoEvent(@NonNull ExternalViewabilitySession.VideoEvent videoEvent, int i) {
        Preconditions.checkNotNull(videoEvent);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            Boolean recordVideoEvent = externalViewabilitySession.recordVideoEvent(videoEvent, i);
            m424(externalViewabilitySession, "record video event (" + videoEvent.name() + ")", recordVideoEvent, true);
        }
    }

    public void registerVideoObstruction(@NonNull View view) {
        Preconditions.checkNotNull(view);
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "register friendly obstruction", externalViewabilitySession.registerVideoObstruction(view), true);
        }
    }

    public void startDeferredDisplaySession(@NonNull Activity activity) {
        for (ExternalViewabilitySession externalViewabilitySession : this.f362) {
            m424(externalViewabilitySession, "record deferred session", externalViewabilitySession.startDeferredDisplaySession(activity), true);
        }
    }
}
