package com.mopub.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.FullAdType;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MultiAdResponse implements Iterator<AdResponse> {
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static ServerOverrideListener f2069;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Iterator<AdResponse> f2070;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f2071;

    /* loaded from: assets/classes2.dex */
    public interface ServerOverrideListener {
        void onForceExplicitNo(@Nullable String str);

        void onForceGdprApplies();

        void onInvalidateConsent(@Nullable String str);

        void onReacquireConsent(@Nullable String str);
    }

    public MultiAdResponse(@NonNull Context context, @NonNull NetworkResponse networkResponse, @NonNull AdFormat adFormat, @Nullable String str) throws JSONException, MoPubNetworkError {
        StringBuilder sb;
        String str2;
        JSONObject jSONObject;
        AdResponse m1606;
        String m1608 = m1608(networkResponse);
        JSONObject jSONObject2 = new JSONObject(m1608);
        this.f2071 = jSONObject2.optString(ResponseHeader.FAIL_URL.getKey());
        String optString = jSONObject2.optString(ResponseHeader.REQUEST_ID.getKey());
        boolean extractBooleanHeader = HeaderUtils.extractBooleanHeader(jSONObject2, ResponseHeader.INVALIDATE_CONSENT, false);
        boolean extractBooleanHeader2 = HeaderUtils.extractBooleanHeader(jSONObject2, ResponseHeader.FORCE_EXPLICIT_NO, false);
        boolean extractBooleanHeader3 = HeaderUtils.extractBooleanHeader(jSONObject2, ResponseHeader.REACQUIRE_CONSENT, false);
        String extractHeader = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.CONSENT_CHANGE_REASON);
        boolean extractBooleanHeader4 = HeaderUtils.extractBooleanHeader(jSONObject2, ResponseHeader.FORCE_GDPR_APPLIES, false);
        if (f2069 != null) {
            if (extractBooleanHeader4) {
                f2069.onForceGdprApplies();
            }
            if (extractBooleanHeader2) {
                f2069.onForceExplicitNo(extractHeader);
            } else if (extractBooleanHeader) {
                f2069.onInvalidateConsent(extractHeader);
            } else if (extractBooleanHeader3) {
                f2069.onReacquireConsent(extractHeader);
            }
        }
        JSONArray jSONArray = jSONObject2.getJSONArray(ResponseHeader.AD_RESPONSES.getKey());
        ArrayList arrayList = new ArrayList(3);
        AdResponse adResponse = null;
        int i = 0;
        while (true) {
            if (i >= jSONArray.length()) {
                break;
            }
            try {
                jSONObject = jSONArray.getJSONObject(i);
                m1606 = m1606(context, networkResponse, jSONObject, str, adFormat, optString);
            } catch (MoPubNetworkError e) {
                e = e;
            } catch (JSONException unused) {
            } catch (Exception e2) {
                e = e2;
            }
            if (AdType.CLEAR.equals(m1606.getAdType())) {
                this.f2071 = "";
                try {
                    if (!m1610(jSONObject)) {
                        adResponse = m1606;
                        break;
                    } else {
                        throw new MoPubNetworkError("Server is preparing this Ad Unit.", MoPubNetworkError.Reason.WARMING_UP, m1606.getRefreshTimeMillis());
                        break;
                    }
                } catch (MoPubNetworkError e3) {
                    e = e3;
                    adResponse = m1606;
                    if (e.getReason() == MoPubNetworkError.Reason.WARMING_UP) {
                        throw e;
                    }
                    sb = new StringBuilder();
                    sb.append("Invalid response item. Error: ");
                    sb.append(e.getReason());
                    str2 = sb.toString();
                    MoPubLog.w(str2);
                    i++;
                } catch (JSONException unused2) {
                    adResponse = m1606;
                    str2 = "Invalid response item. Body: " + m1608;
                    MoPubLog.w(str2);
                    i++;
                } catch (Exception e4) {
                    e = e4;
                    adResponse = m1606;
                    sb = new StringBuilder();
                    sb.append("Unexpected error parsing response item. ");
                    sb.append(e.getMessage());
                    str2 = sb.toString();
                    MoPubLog.w(str2);
                    i++;
                }
            } else {
                arrayList.add(m1606);
                i++;
            }
        }
        this.f2070 = arrayList.iterator();
        if (this.f2070.hasNext()) {
            return;
        }
        throw new MoPubNetworkError("No ads found for ad unit.", MoPubNetworkError.Reason.NO_FILL, adResponse != null ? adResponse.getRefreshTimeMillis() : 30000);
    }

    public static void setServerOverrideListener(@NonNull ServerOverrideListener serverOverrideListener) {
        f2069 = serverOverrideListener;
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static AdResponse m1606(@NonNull Context context, @NonNull NetworkResponse networkResponse, @NonNull JSONObject jSONObject, @Nullable String str, @NonNull AdFormat adFormat, @Nullable String str2) throws JSONException, MoPubNetworkError {
        ExternalViewabilitySessionManager.ViewabilityVendor fromKey;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(networkResponse);
        Preconditions.checkNotNull(jSONObject);
        Preconditions.checkNotNull(adFormat);
        AdResponse.Builder builder = new AdResponse.Builder();
        String optString = jSONObject.optString(ResponseHeader.CONTENT.getKey());
        JSONObject jSONObject2 = jSONObject.getJSONObject(ResponseHeader.METADATA.getKey());
        builder.setAdUnitId(str);
        builder.setResponseBody(optString);
        String extractHeader = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.AD_TYPE);
        String extractHeader2 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.FULL_AD_TYPE);
        builder.setAdType(extractHeader);
        builder.setFullAdType(extractHeader2);
        builder.setRefreshTimeMilliseconds(m1607(jSONObject));
        if (AdType.CLEAR.equals(extractHeader)) {
            return builder.build();
        }
        builder.setDspCreativeId(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.DSP_CREATIVE_ID));
        builder.setNetworkType(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.NETWORK_TYPE));
        String extractHeader3 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.CLICK_TRACKING_URL);
        builder.setClickTrackingUrl(extractHeader3);
        List<String> m1595 = HeaderUtils.m1595(jSONObject2, ResponseHeader.IMPRESSION_URLS);
        if (m1595.isEmpty()) {
            m1595.add(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.IMPRESSION_URL));
        }
        builder.setImpressionTrackingUrls(m1595);
        builder.setBeforeLoadUrl(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.BEFORE_LOAD_URL));
        List<String> m15952 = HeaderUtils.m1595(jSONObject2, ResponseHeader.AFTER_LOAD_URL);
        if (m15952.isEmpty()) {
            m15952.add(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.AFTER_LOAD_URL));
        }
        builder.setAfterLoadUrls(m15952);
        List<String> m15953 = HeaderUtils.m1595(jSONObject2, ResponseHeader.AFTER_LOAD_SUCCESS_URL);
        if (m15953.isEmpty()) {
            m15953.add(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.AFTER_LOAD_SUCCESS_URL));
        }
        builder.setAfterLoadSuccessUrls(m15953);
        List<String> m15954 = HeaderUtils.m1595(jSONObject2, ResponseHeader.AFTER_LOAD_FAIL_URL);
        if (m15954.isEmpty()) {
            m15954.add(HeaderUtils.extractHeader(jSONObject2, ResponseHeader.AFTER_LOAD_FAIL_URL));
        }
        builder.setAfterLoadFailUrls(m15954);
        builder.setRequestId(str2);
        builder.setDimensions(HeaderUtils.extractIntegerHeader(jSONObject2, ResponseHeader.WIDTH), HeaderUtils.extractIntegerHeader(jSONObject2, ResponseHeader.HEIGHT));
        builder.setAdTimeoutDelayMilliseconds(HeaderUtils.extractIntegerHeader(jSONObject2, ResponseHeader.AD_TIMEOUT));
        if (AdType.STATIC_NATIVE.equals(extractHeader) || AdType.VIDEO_NATIVE.equals(extractHeader)) {
            try {
                builder.setJsonBody(new JSONObject(optString));
            } catch (JSONException e) {
                throw new MoPubNetworkError("Failed to decode body JSON for native ad format", e, MoPubNetworkError.Reason.BAD_BODY);
            }
        }
        builder.setCustomEventClassName(AdTypeTranslator.getCustomEventName(adFormat, extractHeader, extractHeader2, jSONObject2));
        MoPub.BrowserAgent fromHeader = MoPub.BrowserAgent.fromHeader(HeaderUtils.extractIntegerHeader(jSONObject2, ResponseHeader.BROWSER_AGENT));
        MoPub.setBrowserAgentFromAdServer(fromHeader);
        builder.setBrowserAgent(fromHeader);
        String extractHeader4 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.CUSTOM_EVENT_DATA);
        if (TextUtils.isEmpty(extractHeader4)) {
            extractHeader4 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.NATIVE_PARAMS);
        }
        try {
            Map<String, String> jsonStringToMap = Json.jsonStringToMap(extractHeader4);
            try {
                if (!jSONObject2.optString(DataKeys.ADM_KEY).isEmpty()) {
                    jsonStringToMap.put(DataKeys.ADM_KEY, jSONObject2.getString(DataKeys.ADM_KEY));
                }
                if (!TextUtils.isEmpty(extractHeader3)) {
                    jsonStringToMap.put(DataKeys.CLICKTHROUGH_URL_KEY, extractHeader3);
                }
                if (m1609(extractHeader, extractHeader2)) {
                    jsonStringToMap.put(DataKeys.HTML_RESPONSE_BODY_KEY, optString);
                    jsonStringToMap.put(DataKeys.CREATIVE_ORIENTATION_KEY, HeaderUtils.extractHeader(jSONObject2, ResponseHeader.ORIENTATION));
                }
                if (AdType.STATIC_NATIVE.equals(extractHeader) || AdType.VIDEO_NATIVE.equals(extractHeader)) {
                    String m1598 = HeaderUtils.m1598(jSONObject2, ResponseHeader.IMPRESSION_MIN_VISIBLE_PERCENT);
                    String extractHeader5 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.IMPRESSION_VISIBLE_MS);
                    String extractHeader6 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.IMPRESSION_MIN_VISIBLE_PX);
                    if (!TextUtils.isEmpty(m1598)) {
                        jsonStringToMap.put(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT, m1598);
                    }
                    if (!TextUtils.isEmpty(extractHeader5)) {
                        jsonStringToMap.put(DataKeys.IMPRESSION_VISIBLE_MS, extractHeader5);
                    }
                    if (!TextUtils.isEmpty(extractHeader6)) {
                        jsonStringToMap.put(DataKeys.IMPRESSION_MIN_VISIBLE_PX, extractHeader6);
                    }
                }
                if (AdType.VIDEO_NATIVE.equals(extractHeader)) {
                    jsonStringToMap.put(DataKeys.PLAY_VISIBLE_PERCENT, HeaderUtils.m1598(jSONObject2, ResponseHeader.PLAY_VISIBLE_PERCENT));
                    jsonStringToMap.put(DataKeys.PAUSE_VISIBLE_PERCENT, HeaderUtils.m1598(jSONObject2, ResponseHeader.PAUSE_VISIBLE_PERCENT));
                    jsonStringToMap.put(DataKeys.MAX_BUFFER_MS, HeaderUtils.extractHeader(jSONObject2, ResponseHeader.MAX_BUFFER_MS));
                }
                String extractHeader7 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.VIDEO_TRACKERS);
                if (!TextUtils.isEmpty(extractHeader7)) {
                    jsonStringToMap.put(DataKeys.VIDEO_TRACKERS_KEY, extractHeader7);
                }
                if (AdType.REWARDED_VIDEO.equals(extractHeader) || (AdType.INTERSTITIAL.equals(extractHeader) && FullAdType.VAST.equals(extractHeader2))) {
                    jsonStringToMap.put(DataKeys.EXTERNAL_VIDEO_VIEWABILITY_TRACKERS_KEY, HeaderUtils.extractHeader(jSONObject2, ResponseHeader.VIDEO_VIEWABILITY_TRACKERS));
                }
                if (AdFormat.BANNER.equals(adFormat)) {
                    jsonStringToMap.put(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_MS, HeaderUtils.extractHeader(jSONObject2, ResponseHeader.BANNER_IMPRESSION_MIN_VISIBLE_MS));
                    jsonStringToMap.put(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_DIPS, HeaderUtils.extractHeader(jSONObject2, ResponseHeader.BANNER_IMPRESSION_MIN_VISIBLE_DIPS));
                }
                String extractHeader8 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.DISABLE_VIEWABILITY);
                if (!TextUtils.isEmpty(extractHeader8) && (fromKey = ExternalViewabilitySessionManager.ViewabilityVendor.fromKey(extractHeader8)) != null) {
                    fromKey.disable();
                }
                builder.setServerExtras(jsonStringToMap);
                if (AdType.REWARDED_VIDEO.equals(extractHeader) || AdType.CUSTOM.equals(extractHeader) || AdType.REWARDED_PLAYABLE.equals(extractHeader)) {
                    String extractHeader9 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.REWARDED_VIDEO_CURRENCY_NAME);
                    String extractHeader10 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.REWARDED_VIDEO_CURRENCY_AMOUNT);
                    String extractHeader11 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.REWARDED_CURRENCIES);
                    String extractHeader12 = HeaderUtils.extractHeader(jSONObject2, ResponseHeader.REWARDED_VIDEO_COMPLETION_URL);
                    Integer extractIntegerHeader = HeaderUtils.extractIntegerHeader(jSONObject2, ResponseHeader.REWARDED_DURATION);
                    boolean extractBooleanHeader = HeaderUtils.extractBooleanHeader(jSONObject2, ResponseHeader.SHOULD_REWARD_ON_CLICK, false);
                    builder.setRewardedVideoCurrencyName(extractHeader9);
                    builder.setRewardedVideoCurrencyAmount(extractHeader10);
                    builder.setRewardedCurrencies(extractHeader11);
                    builder.setRewardedVideoCompletionUrl(extractHeader12);
                    builder.setRewardedDuration(extractIntegerHeader);
                    builder.setShouldRewardOnClick(extractBooleanHeader);
                }
                return builder.build();
            } catch (JSONException e2) {
                throw new MoPubNetworkError("Failed to parse ADM for advanced bidding", e2, MoPubNetworkError.Reason.BAD_BODY);
            }
        } catch (JSONException e3) {
            throw new MoPubNetworkError("Failed to decode server extras for custom event data.", e3, MoPubNetworkError.Reason.BAD_HEADER_DATA);
        }
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Integer m1607(@NonNull JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject);
        Integer extractIntegerHeader = HeaderUtils.extractIntegerHeader(jSONObject.getJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.REFRESH_TIME);
        if (extractIntegerHeader == null) {
            return null;
        }
        return Integer.valueOf(extractIntegerHeader.intValue() * 1000);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1608(@NonNull NetworkResponse networkResponse) {
        Preconditions.checkNotNull(networkResponse);
        try {
            return new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            return new String(networkResponse.data);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m1609(@Nullable String str, @Nullable String str2) {
        return AdType.MRAID.equals(str) || AdType.HTML.equals(str) || (AdType.INTERSTITIAL.equals(str) && FullAdType.VAST.equals(str2)) || ((AdType.REWARDED_VIDEO.equals(str) && FullAdType.VAST.equals(str2)) || AdType.REWARDED_PLAYABLE.equals(str));
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean m1610(@NonNull JSONObject jSONObject) {
        Preconditions.checkNotNull(jSONObject);
        return HeaderUtils.extractBooleanHeader(jSONObject.optJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.WARMUP, false);
    }

    @NonNull
    public String getFailURL() {
        return this.f2071;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2070.hasNext();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NonNull
    public AdResponse next() {
        return this.f2070.next();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1611() {
        return TextUtils.isEmpty(this.f2071);
    }
}
