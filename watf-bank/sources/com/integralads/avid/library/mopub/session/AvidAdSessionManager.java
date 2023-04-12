package com.integralads.avid.library.mopub.session;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidContext;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidDisplayAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedDisplayAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedVideoAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidVideoAdSession;
/* loaded from: assets/classes2.dex */
public class AvidAdSessionManager {
    public static <T extends AbstractAvidAdSession> T findAvidAdSessionById(String str) {
        return (T) AvidManager.getInstance().findAvidAdSessionById(str);
    }

    public static String getReleaseDate() {
        return AvidContext.getInstance().getAvidReleaseDate();
    }

    public static String getVersion() {
        return AvidContext.getInstance().getAvidVersion();
    }

    public static AvidDisplayAdSession startAvidDisplayAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidDisplayAdSession avidDisplayAdSession = new AvidDisplayAdSession();
        InternalAvidDisplayAdSession internalAvidDisplayAdSession = new InternalAvidDisplayAdSession(context, avidDisplayAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidDisplayAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession(avidDisplayAdSession, internalAvidDisplayAdSession);
        return avidDisplayAdSession;
    }

    public static AvidManagedDisplayAdSession startAvidManagedDisplayAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidManagedDisplayAdSession avidManagedDisplayAdSession = new AvidManagedDisplayAdSession();
        InternalAvidManagedDisplayAdSession internalAvidManagedDisplayAdSession = new InternalAvidManagedDisplayAdSession(context, avidManagedDisplayAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidManagedDisplayAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession(avidManagedDisplayAdSession, internalAvidManagedDisplayAdSession);
        return avidManagedDisplayAdSession;
    }

    public static AvidManagedVideoAdSession startAvidManagedVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidManagedVideoAdSession avidManagedVideoAdSession = new AvidManagedVideoAdSession();
        InternalAvidManagedVideoAdSession internalAvidManagedVideoAdSession = new InternalAvidManagedVideoAdSession(context, avidManagedVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidManagedVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession(avidManagedVideoAdSession, internalAvidManagedVideoAdSession);
        return avidManagedVideoAdSession;
    }

    public static AvidVideoAdSession startAvidVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidVideoAdSession avidVideoAdSession = new AvidVideoAdSession();
        InternalAvidVideoAdSession internalAvidVideoAdSession = new InternalAvidVideoAdSession(context, avidVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession(avidVideoAdSession, internalAvidVideoAdSession);
        return avidVideoAdSession;
    }

    public static WebView webViewForSessionId(String str) {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(str);
        if (findInternalAvidAdSessionById != null) {
            return findInternalAvidAdSessionById.getWebView();
        }
        return null;
    }

    public static WebView webViewForView(View view) {
        WebView m46 = m46(view);
        if (m46 != null) {
            return m46;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount() && (m46 = webViewForView(viewGroup.getChildAt(i))) == null; i++) {
            }
            return m46;
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static WebView m46(View view) {
        InternalAvidAdSession findInternalAvidAdSessionByView = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionByView(view);
        if (findInternalAvidAdSessionByView != null) {
            return findInternalAvidAdSessionByView.getWebView();
        }
        return null;
    }
}
