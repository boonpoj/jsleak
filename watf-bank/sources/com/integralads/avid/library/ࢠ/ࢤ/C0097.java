package com.integralads.avid.library.ࢠ.ࢤ;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢤ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0097 implements InterfaceC0098 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int[] f144 = new int[2];

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m132(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC0098.InterfaceC0099 interfaceC0099) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            interfaceC0099.mo134(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m133(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC0098.InterfaceC0099 interfaceC0099) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0099.mo134((View) it2.next(), this, jSONObject);
            }
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098
    /* renamed from: ࢠ */
    public JSONObject mo130(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f144);
        return C0140.m263(this.f144[0], this.f144[1], width, height);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098
    /* renamed from: ࢠ */
    public void mo131(View view, JSONObject jSONObject, InterfaceC0098.InterfaceC0099 interfaceC0099, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m132(viewGroup, jSONObject, interfaceC0099);
            } else {
                m133(viewGroup, jSONObject, interfaceC0099);
            }
        }
    }
}
