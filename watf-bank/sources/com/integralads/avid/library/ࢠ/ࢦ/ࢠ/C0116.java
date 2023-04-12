package com.integralads.avid.library.ࢠ.ࢦ.ࢠ;

import android.content.Context;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.ࢠ.C0086;
import com.integralads.avid.library.ࢠ.ࢦ.C0136;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0116 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f200;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0136 f201;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f202;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f203;

    public C0116(Context context, String str, String str2, String str3, C0136 c0136) {
        C0086.m91().m92(context);
        this.f200 = str;
        this.f201 = c0136;
        this.f202 = str2;
        this.f203 = str3;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m231() {
        return this.f200;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public JSONObject m232() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avidAdSessionId", this.f200);
            jSONObject.put("bundleIdentifier", C0086.m91().m93());
            jSONObject.put("partner", C0086.m91().m95());
            jSONObject.put("partnerVersion", this.f201.m248());
            jSONObject.put("avidLibraryVersion", C0086.m91().m94());
            jSONObject.put(InternalAvidAdSessionContext.CONTEXT_AVID_AD_SESSION_TYPE, this.f202);
            jSONObject.put(InternalAvidAdSessionContext.CONTEXT_MEDIA_TYPE, this.f203);
            jSONObject.put(InternalAvidAdSessionContext.CONTEXT_IS_DEFERRED, this.f201.m249());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public JSONObject m233() {
        JSONObject m232 = m232();
        try {
            m232.put(InternalAvidAdSessionContext.CONTEXT_AVID_API_LEVEL, InternalAvidAdSessionContext.AVID_API_LEVEL);
            m232.put(InternalAvidAdSessionContext.CONTEXT_MODE, InternalAvidAdSessionContext.AVID_STUB_MODE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return m232;
    }
}
