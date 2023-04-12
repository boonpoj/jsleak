package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubRequestUtils;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class PositioningRequest extends JsonRequest<MoPubNativeAdPositioning.MoPubClientPositioning> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f1844;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f1845;

    public PositioningRequest(@NonNull Context context, String str, Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> listener, Response.ErrorListener errorListener) {
        super(MoPubRequestUtils.chooseMethod(str), MoPubRequestUtils.truncateQueryParamsIfPost(str), null, listener, errorListener);
        this.f1844 = str;
        this.f1845 = context.getApplicationContext();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1472(@NonNull JSONArray jSONArray, @NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int optInt = jSONObject.optInt("section", 0);
            if (optInt < 0) {
                throw new JSONException("Invalid section " + optInt + " in JSON response");
            }
            if (optInt <= 0) {
                int i2 = jSONObject.getInt("position");
                if (i2 < 0 || i2 > 65536) {
                    throw new JSONException("Invalid position " + i2 + " in JSON response");
                }
                moPubClientPositioning.addFixedPosition(i2);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1473(@NonNull JSONObject jSONObject, @NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) throws JSONException {
        int i = jSONObject.getInt("interval");
        if (i >= 2 && i <= 65536) {
            moPubClientPositioning.enableRepeatingPositions(i);
            return;
        }
        throw new JSONException("Invalid interval " + i + " in JSON response");
    }

    @Override // com.mopub.volley.toolbox.JsonRequest, com.mopub.volley.Request
    public byte[] getBody() {
        String generateBodyFromParams = MoPubRequestUtils.generateBodyFromParams(mo1475(), getUrl());
        if (generateBodyFromParams == null) {
            return null;
        }
        return generateBodyFromParams.getBytes();
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    MoPubNativeAdPositioning.MoPubClientPositioning m1474(@NonNull String str) throws JSONException, MoPubNetworkError {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("error", null);
        if (optString != null) {
            if (optString.equalsIgnoreCase("WARMING_UP")) {
                throw new MoPubNetworkError(MoPubNetworkError.Reason.WARMING_UP);
            }
            throw new JSONException(optString);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("fixed");
        JSONObject optJSONObject = jSONObject.optJSONObject("repeating");
        if (optJSONArray == null && optJSONObject == null) {
            throw new JSONException("Must contain fixed or repeating positions");
        }
        MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning = new MoPubNativeAdPositioning.MoPubClientPositioning();
        if (optJSONArray != null) {
            m1472(optJSONArray, moPubClientPositioning);
        }
        if (optJSONObject != null) {
            m1473(optJSONObject, moPubClientPositioning);
        }
        return moPubClientPositioning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.toolbox.JsonRequest, com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<MoPubNativeAdPositioning.MoPubClientPositioning> mo502(NetworkResponse networkResponse) {
        if (networkResponse.statusCode != 200) {
            return Response.error(new VolleyError(networkResponse));
        }
        if (networkResponse.data.length == 0) {
            return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
        }
        try {
            return Response.success(m1474(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (MoPubNetworkError e) {
            return Response.error(e);
        } catch (UnsupportedEncodingException e2) {
            return Response.error(new VolleyError("Couldn't parse JSON from Charset", e2));
        } catch (JSONException e3) {
            return Response.error(new VolleyError("JSON Parsing Error", e3));
        }
    }

    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Map<String, String> mo1475() {
        if (MoPubRequestUtils.isMoPubRequest(getUrl())) {
            return MoPubRequestUtils.convertQueryToMap(this.f1845, this.f1844);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.toolbox.JsonRequest, com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        super.deliverResponse(moPubClientPositioning);
    }
}
