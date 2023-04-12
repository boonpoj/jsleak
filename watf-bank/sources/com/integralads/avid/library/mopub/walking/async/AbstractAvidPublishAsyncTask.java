package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public abstract class AbstractAvidPublishAsyncTask extends AvidAsyncTask {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected final AvidAdSessionRegistry f110;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected final HashSet<String> f111;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected final JSONObject f112;

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected final double f113;

    public AbstractAvidPublishAsyncTask(AvidAsyncTask.StateProvider stateProvider, AvidAdSessionRegistry avidAdSessionRegistry, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(stateProvider);
        this.f110 = avidAdSessionRegistry;
        this.f111 = new HashSet<>(hashSet);
        this.f112 = jSONObject;
        this.f113 = d;
    }

    public AvidAdSessionRegistry getAdSessionRegistry() {
        return this.f110;
    }

    public HashSet<String> getSessionIds() {
        return this.f111;
    }

    public JSONObject getState() {
        return this.f112;
    }

    public double getTimestamp() {
        return this.f113;
    }
}
