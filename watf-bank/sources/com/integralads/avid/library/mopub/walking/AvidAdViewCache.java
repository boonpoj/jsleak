package com.integralads.avid.library.mopub.walking;

import android.view.View;
import android.view.ViewParent;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidViewUtil;
import com.integralads.avid.library.mopub.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: assets/classes2.dex */
public class AvidAdViewCache {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AvidAdSessionRegistry f99;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final HashMap<View, String> f100 = new HashMap<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final HashMap<View, ArrayList<String>> f101 = new HashMap<>();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final HashSet<View> f102 = new HashSet<>();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final HashSet<String> f103 = new HashSet<>();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final HashSet<String> f104 = new HashSet<>();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f105;

    public AvidAdViewCache(AvidAdSessionRegistry avidAdSessionRegistry) {
        this.f99 = avidAdSessionRegistry;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m72(View view, InternalAvidAdSession internalAvidAdSession) {
        ArrayList<String> arrayList = this.f101.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f101.put(view, arrayList);
        }
        arrayList.add(internalAvidAdSession.getAvidAdSessionId());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m73(InternalAvidAdSession internalAvidAdSession) {
        Iterator<AvidView> it = internalAvidAdSession.getObstructionsWhiteList().getWhiteList().iterator();
        while (it.hasNext()) {
            AvidView next = it.next();
            if (!next.isEmpty()) {
                m72((View) next.get(), internalAvidAdSession);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m74(View view) {
        if (view.hasWindowFocus()) {
            HashSet hashSet = new HashSet();
            while (view != null) {
                if (!AvidViewUtil.isViewVisible(view)) {
                    return false;
                }
                hashSet.add(view);
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            this.f102.addAll(hashSet);
            return true;
        }
        return false;
    }

    public void cleanup() {
        this.f100.clear();
        this.f101.clear();
        this.f102.clear();
        this.f103.clear();
        this.f104.clear();
        this.f105 = false;
    }

    public ArrayList<String> getFriendlySessionIds(View view) {
        if (this.f101.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.f101.get(view);
        if (arrayList != null) {
            this.f101.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public HashSet<String> getHiddenSessionIds() {
        return this.f104;
    }

    public String getSessionId(View view) {
        if (this.f100.size() == 0) {
            return null;
        }
        String str = this.f100.get(view);
        if (str != null) {
            this.f100.remove(view);
        }
        return str;
    }

    public ViewType getViewType(View view) {
        return this.f102.contains(view) ? ViewType.ROOT_VIEW : this.f105 ? ViewType.OBSTRUCTION_VIEW : ViewType.UNDERLYING_VIEW;
    }

    public HashSet<String> getVisibleSessionIds() {
        return this.f103;
    }

    public void onAdViewProcessed() {
        this.f105 = true;
    }

    public void prepare() {
        for (InternalAvidAdSession internalAvidAdSession : this.f99.getInternalAvidAdSessions()) {
            View view = internalAvidAdSession.getView();
            if (internalAvidAdSession.isActive() && view != null) {
                if (m74(view)) {
                    this.f103.add(internalAvidAdSession.getAvidAdSessionId());
                    this.f100.put(view, internalAvidAdSession.getAvidAdSessionId());
                    m73(internalAvidAdSession);
                } else {
                    this.f104.add(internalAvidAdSession.getAvidAdSessionId());
                }
            }
        }
    }
}
