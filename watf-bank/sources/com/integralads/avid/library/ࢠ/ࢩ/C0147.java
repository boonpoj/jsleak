package com.integralads.avid.library.ࢠ.ࢩ;

import android.view.View;
import android.view.ViewParent;
import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢧ.C0143;
import com.integralads.avid.library.ࢠ.ࢪ.C0159;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0147 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0101 f229;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final HashMap<View, String> f230 = new HashMap<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final HashMap<View, ArrayList<String>> f231 = new HashMap<>();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final HashSet<View> f232 = new HashSet<>();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final HashSet<String> f233 = new HashSet<>();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final HashSet<String> f234 = new HashSet<>();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f235;

    public C0147(C0101 c0101) {
        this.f229 = c0101;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m294(View view, AbstractC0107 abstractC0107) {
        ArrayList<String> arrayList = this.f231.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f231.put(view, arrayList);
        }
        arrayList.add(abstractC0107.m196());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m295(AbstractC0107 abstractC0107) {
        Iterator<C0159> it = abstractC0107.m203().m241().iterator();
        while (it.hasNext()) {
            C0159 next = it.next();
            if (!next.m324()) {
                m294((View) next.m322(), abstractC0107);
            }
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean m296(View view) {
        if (view.hasWindowFocus()) {
            HashSet hashSet = new HashSet();
            while (view != null) {
                if (!C0143.m279(view)) {
                    return false;
                }
                hashSet.add(view);
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            this.f232.addAll(hashSet);
            return true;
        }
        return false;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m297(View view) {
        if (this.f230.size() == 0) {
            return null;
        }
        String str = this.f230.get(view);
        if (str != null) {
            this.f230.remove(view);
        }
        return str;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public HashSet<String> m298() {
        return this.f233;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public ArrayList<String> m299(View view) {
        if (this.f231.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.f231.get(view);
        if (arrayList != null) {
            this.f231.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public HashSet<String> m300() {
        return this.f234;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public EnumC0157 m301(View view) {
        return this.f232.contains(view) ? EnumC0157.ROOT_VIEW : this.f235 ? EnumC0157.OBSTRUCTION_VIEW : EnumC0157.UNDERLYING_VIEW;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m302() {
        for (AbstractC0107 abstractC0107 : this.f229.m151()) {
            View m197 = abstractC0107.m197();
            if (abstractC0107.m200() && m197 != null) {
                if (m296(m197)) {
                    this.f233.add(abstractC0107.m196());
                    this.f230.put(m197, abstractC0107.m196());
                    m295(abstractC0107);
                } else {
                    this.f234.add(abstractC0107.m196());
                }
            }
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m303() {
        this.f230.clear();
        this.f231.clear();
        this.f232.clear();
        this.f233.clear();
        this.f234.clear();
        this.f235 = false;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m304() {
        this.f235 = true;
    }
}
