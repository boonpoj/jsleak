package com.integralads.avid.library.mopub.processing;

import android.view.View;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public interface IAvidNodeProcessor {

    /* loaded from: assets/classes2.dex */
    public interface IAvidViewWalker {
        void walkView(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject);
    }

    JSONObject getState(View view);

    void iterateChildren(View view, JSONObject jSONObject, IAvidViewWalker iAvidViewWalker, boolean z);
}
