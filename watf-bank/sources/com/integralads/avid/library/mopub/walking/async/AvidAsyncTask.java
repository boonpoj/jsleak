package com.integralads.avid.library.mopub.walking.async;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public abstract class AvidAsyncTask extends AsyncTask<Object, Void, String> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AvidAsyncTaskListener f114;

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected final StateProvider f115;

    /* loaded from: assets/classes2.dex */
    public interface AvidAsyncTaskListener {
        void onTaskCompleted(AvidAsyncTask avidAsyncTask);
    }

    /* loaded from: assets/classes2.dex */
    public interface StateProvider {
        JSONObject getPreviousState();

        void setPreviousState(JSONObject jSONObject);
    }

    public AvidAsyncTask(StateProvider stateProvider) {
        this.f115 = stateProvider;
    }

    public AvidAsyncTaskListener getListener() {
        return this.f114;
    }

    public StateProvider getStateProvider() {
        return this.f115;
    }

    public void setListener(AvidAsyncTaskListener avidAsyncTaskListener) {
        this.f114 = avidAsyncTaskListener;
    }

    public void start(ThreadPoolExecutor threadPoolExecutor) {
        if (Build.VERSION.SDK_INT > 11) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(String str) {
        if (this.f114 != null) {
            this.f114.onTaskCompleted(this);
        }
    }
}
