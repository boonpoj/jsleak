package com.integralads.avid.library.mopub.walking.async;

import android.text.TextUtils;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidCommand;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidPublishAsyncTask extends AbstractAvidPublishAsyncTask {
    public AvidPublishAsyncTask(AvidAsyncTask.StateProvider stateProvider, AvidAdSessionRegistry avidAdSessionRegistry, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(stateProvider, avidAdSessionRegistry, hashSet, jSONObject, d);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m79(String str) {
        for (InternalAvidAdSession internalAvidAdSession : this.f110.getInternalAvidAdSessions()) {
            if (this.f111.contains(internalAvidAdSession.getAvidAdSessionId())) {
                internalAvidAdSession.publishNativeViewStateCommand(str, this.f113);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String doInBackground(Object... objArr) {
        if (AvidJSONUtil.equalStates(this.f112, this.f115.getPreviousState())) {
            return null;
        }
        this.f115.setPreviousState(this.f112);
        return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(this.f112, this.f113).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.integralads.avid.library.mopub.walking.async.AvidAsyncTask, android.os.AsyncTask
    /* renamed from: ࢠ */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m79(str);
        }
        super.onPostExecute(str);
    }
}
