package com.integralads.avid.library.mopub.walking;

import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTaskQueue;
import com.integralads.avid.library.mopub.walking.async.AvidCleanupAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidEmptyPublishAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidPublishAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidStatePublisher implements AvidAsyncTask.StateProvider {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AvidAdSessionRegistry f106;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private JSONObject f107;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final AvidAsyncTaskQueue f108;

    public AvidStatePublisher(AvidAdSessionRegistry avidAdSessionRegistry, AvidAsyncTaskQueue avidAsyncTaskQueue) {
        this.f106 = avidAdSessionRegistry;
        this.f108 = avidAsyncTaskQueue;
    }

    public void cleanupCache() {
        this.f108.submitTask(new AvidCleanupAsyncTask(this));
    }

    @Override // com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.StateProvider
    @VisibleForTesting
    public JSONObject getPreviousState() {
        return this.f107;
    }

    public void publishEmptyState(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f108.submitTask(new AvidEmptyPublishAsyncTask(this, this.f106, hashSet, jSONObject, d));
    }

    public void publishState(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f108.submitTask(new AvidPublishAsyncTask(this, this.f106, hashSet, jSONObject, d));
    }

    @Override // com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.StateProvider
    @VisibleForTesting
    public void setPreviousState(JSONObject jSONObject) {
        this.f107 = jSONObject;
    }
}
