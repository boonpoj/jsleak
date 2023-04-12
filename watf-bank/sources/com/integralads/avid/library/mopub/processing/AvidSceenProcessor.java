package com.integralads.avid.library.mopub.processing;

import android.view.View;
import com.integralads.avid.library.mopub.activity.AvidActivityStack;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidSceenProcessor implements IAvidNodeProcessor {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final IAvidNodeProcessor f40;

    public AvidSceenProcessor(IAvidNodeProcessor iAvidNodeProcessor) {
        this.f40 = iAvidNodeProcessor;
    }

    @Override // com.integralads.avid.library.mopub.processing.IAvidNodeProcessor
    public JSONObject getState(View view) {
        return AvidJSONUtil.getViewState(0, 0, 0, 0);
    }

    @Override // com.integralads.avid.library.mopub.processing.IAvidNodeProcessor
    public void iterateChildren(View view, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker, boolean z) {
        for (View view2 : AvidActivityStack.getInstance().getRootViews()) {
            iAvidViewWalker.walkView(view2, this.f40, jSONObject);
        }
    }
}
