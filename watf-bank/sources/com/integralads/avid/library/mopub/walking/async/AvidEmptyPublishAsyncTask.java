package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidCommand;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidEmptyPublishAsyncTask extends AbstractAvidPublishAsyncTask {
    public AvidEmptyPublishAsyncTask(AvidAsyncTask.StateProvider stateProvider, AvidAdSessionRegistry avidAdSessionRegistry, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(stateProvider, avidAdSessionRegistry, hashSet, jSONObject, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String doInBackground(Object... objArr) {
        return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(this.f112, this.f113).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.integralads.avid.library.mopub.walking.async.AvidAsyncTask, android.os.AsyncTask
    /* renamed from: ࢠ */
    public void onPostExecute(String str) {
        for (InternalAvidAdSession internalAvidAdSession : this.f110.getInternalAvidAdSessions()) {
            if (this.f111.contains(internalAvidAdSession.getAvidAdSessionId())) {
                internalAvidAdSession.publishEmptyNativeViewStateCommand(str, this.f113);
            }
        }
        super.onPostExecute(str);
    }
}
