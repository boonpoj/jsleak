package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import com.integralads.avid.library.mopub.AvidContext;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class InternalAvidAdSessionContext {
    public static final String AVID_API_LEVEL = "2";
    public static final String AVID_STUB_MODE = "stub";
    public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
    public static final String CONTEXT_AVID_AD_SESSION_TYPE = "avidAdSessionType";
    public static final String CONTEXT_AVID_API_LEVEL = "avidApiLevel";
    public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
    public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
    public static final String CONTEXT_IS_DEFERRED = "isDeferred";
    public static final String CONTEXT_MEDIA_TYPE = "mediaType";
    public static final String CONTEXT_MODE = "mode";
    public static final String CONTEXT_PARTNER = "partner";
    public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f62;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ExternalAvidAdSessionContext f63;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f64;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f65;

    public InternalAvidAdSessionContext(Context context, String str, String str2, String str3, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidContext.getInstance().init(context);
        this.f62 = str;
        this.f63 = externalAvidAdSessionContext;
        this.f64 = str2;
        this.f65 = str3;
    }

    public ExternalAvidAdSessionContext getAvidAdSessionContext() {
        return this.f63;
    }

    public String getAvidAdSessionId() {
        return this.f62;
    }

    public JSONObject getFullContext() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avidAdSessionId", this.f62);
            jSONObject.put("bundleIdentifier", AvidContext.getInstance().getBundleId());
            jSONObject.put("partner", AvidContext.getInstance().getPartnerName());
            jSONObject.put("partnerVersion", this.f63.getPartnerVersion());
            jSONObject.put("avidLibraryVersion", AvidContext.getInstance().getAvidVersion());
            jSONObject.put(CONTEXT_AVID_AD_SESSION_TYPE, this.f64);
            jSONObject.put(CONTEXT_MEDIA_TYPE, this.f65);
            jSONObject.put(CONTEXT_IS_DEFERRED, this.f63.isDeferred());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject getStubContext() {
        JSONObject fullContext = getFullContext();
        try {
            fullContext.put(CONTEXT_AVID_API_LEVEL, AVID_API_LEVEL);
            fullContext.put(CONTEXT_MODE, AVID_STUB_MODE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fullContext;
    }

    public void setAvidAdSessionContext(ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        this.f63 = externalAvidAdSessionContext;
    }
}
