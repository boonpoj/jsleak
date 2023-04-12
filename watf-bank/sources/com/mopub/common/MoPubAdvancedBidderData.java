package com.mopub.common;

import android.support.annotation.NonNull;
import com.mopub.common.logging.MoPubLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MoPubAdvancedBidderData {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    final String f391;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    final String f392;

    public MoPubAdvancedBidderData(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.f391 = str;
        this.f392 = str2;
    }

    @NonNull
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", this.f391);
        } catch (JSONException unused) {
            MoPubLog.e("Invalid token format: " + this.f391);
        }
        return jSONObject;
    }
}
