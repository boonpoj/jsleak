package com.integralads.avid.library.mopub.session.internal;

import android.view.View;
import com.integralads.avid.library.mopub.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: assets/classes2.dex */
public class ObstructionsWhiteList {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final ArrayList<AvidView> f71 = new ArrayList<>();

    public void add(View view) {
        this.f71.add(new AvidView(view));
    }

    public boolean contains(View view) {
        Iterator<AvidView> it = this.f71.iterator();
        while (it.hasNext()) {
            if (it.next().contains(view)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<AvidView> getWhiteList() {
        return this.f71;
    }
}
