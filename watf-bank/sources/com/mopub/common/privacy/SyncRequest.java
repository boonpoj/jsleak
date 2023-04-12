package com.mopub.common.privacy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.privacy.SyncResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class SyncRequest extends MoPubRequest<SyncResponse> {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Listener f542;

    /* loaded from: assets/classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onSuccess(SyncResponse syncResponse);
    }

    public SyncRequest(@NonNull Context context, @NonNull String str, @Nullable Listener listener) {
        super(context, str, listener);
        this.f542 = listener;
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1.0f));
        setShouldCache(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<SyncResponse> mo502(NetworkResponse networkResponse) {
        SyncResponse.Builder builder = new SyncResponse.Builder();
        try {
            JSONObject jSONObject = new JSONObject(m1599(networkResponse));
            builder.setIsGdprRegion(jSONObject.getString(PrivacyKey.IS_GDPR_REGION.getKey())).setForceExplicitNo(jSONObject.optString(PrivacyKey.FORCE_EXPLICIT_NO.getKey())).setInvalidateConsent(jSONObject.optString(PrivacyKey.INVALIDATE_CONSENT.getKey())).setReacquireConsent(jSONObject.optString(PrivacyKey.REACQUIRE_CONSENT.getKey())).setIsWhitelisted(jSONObject.getString(PrivacyKey.IS_WHITELISTED.getKey())).setForceGdprApplies(jSONObject.optString(PrivacyKey.FORCE_GDPR_APPLIES.getKey())).setCurrentVendorListVersion(jSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_VERSION.getKey())).setCurrentVendorListLink(jSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_LINK.getKey())).setCurrentPrivacyPolicyLink(jSONObject.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_LINK.getKey())).setCurrentPrivacyPolicyVersion(jSONObject.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_VERSION.getKey())).setCurrentVendorListIabFormat(jSONObject.optString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_FORMAT.getKey())).setCurrentVendorListIabHash(jSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_HASH.getKey())).setCallAgainAfterSecs(jSONObject.optString(PrivacyKey.CALL_AGAIN_AFTER_SECS.getKey())).setExtras(jSONObject.optString(PrivacyKey.EXTRAS.getKey())).setConsentChangeReason(jSONObject.optString(PrivacyKey.CONSENT_CHANGE_REASON.getKey()));
            return Response.success(builder.build(), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException unused) {
            return Response.error(new MoPubNetworkError("Unable to parse sync request network response.", MoPubNetworkError.Reason.BAD_BODY, (Integer) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(SyncResponse syncResponse) {
        if (this.f542 != null) {
            this.f542.onSuccess(syncResponse);
        }
    }
}
