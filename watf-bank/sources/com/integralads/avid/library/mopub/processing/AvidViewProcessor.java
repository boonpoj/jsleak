package com.integralads.avid.library.mopub.processing;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidViewProcessor implements IAvidNodeProcessor {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int[] f41 = new int[2];

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m44(ViewGroup viewGroup, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            iAvidViewWalker.walkView(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m45(ViewGroup viewGroup, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker) {
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
                iAvidViewWalker.walkView((View) it2.next(), this, jSONObject);
            }
        }
    }

    @Override // com.integralads.avid.library.mopub.processing.IAvidNodeProcessor
    public JSONObject getState(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f41);
        return AvidJSONUtil.getViewState(this.f41[0], this.f41[1], width, height);
    }

    @Override // com.integralads.avid.library.mopub.processing.IAvidNodeProcessor
    public void iterateChildren(View view, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m44(viewGroup, jSONObject, iAvidViewWalker);
            } else {
                m45(viewGroup, jSONObject, iAvidViewWalker);
            }
        }
    }
}
