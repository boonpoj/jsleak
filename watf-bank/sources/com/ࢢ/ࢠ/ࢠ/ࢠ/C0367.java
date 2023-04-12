package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.C0370;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.މ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0367 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final LinkedHashSet<String> f2530 = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0370<WebView> m2028(ViewGroup viewGroup, boolean z) {
        try {
            if (viewGroup == null) {
                return C0370.m2033();
            }
            if (viewGroup instanceof WebView) {
                return C0370.m2034((WebView) viewGroup);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(viewGroup);
            WebView webView = null;
            int i = 0;
            while (!linkedList.isEmpty() && i < 100) {
                i++;
                ViewGroup viewGroup2 = (ViewGroup) linkedList.poll();
                int childCount = viewGroup2.getChildCount();
                WebView webView2 = webView;
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        webView = webView2;
                        break;
                    }
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt instanceof WebView) {
                        C0379.m2046(3, "WebViewHound", childAt, "Found WebView");
                        if (z || m2029(String.valueOf(childAt.hashCode()))) {
                            if (webView2 != null) {
                                C0379.m2046(3, "WebViewHound", childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C0379.m2049("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                                webView = null;
                                break;
                            }
                            webView2 = (WebView) childAt;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        linkedList.add((ViewGroup) childAt);
                    }
                    i2++;
                }
            }
            return C0370.m2035(webView);
        } catch (Exception unused) {
            return C0370.m2033();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m2029(String str) {
        try {
            boolean add = f2530.add(str);
            if (f2530.size() > 50) {
                Iterator<String> it = f2530.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C0379.m2046(3, "WebViewHound", (Object) null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C0348.m1974(e);
            return false;
        }
    }
}
