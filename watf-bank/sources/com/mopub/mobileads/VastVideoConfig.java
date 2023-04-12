package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Strings;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class VastVideoConfig implements Serializable {
    private static final long serialVersionUID = 2;
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private String f1034;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private String f1035;
    @Nullable

    /* renamed from: ހ  reason: contains not printable characters */
    private VastCompanionAdConfig f1036;
    @Nullable

    /* renamed from: ށ  reason: contains not printable characters */
    private VastCompanionAdConfig f1037;
    @Nullable

    /* renamed from: ރ  reason: contains not printable characters */
    private C0244 f1039;
    @Nullable

    /* renamed from: ޅ  reason: contains not printable characters */
    private String f1041;
    @Nullable

    /* renamed from: ކ  reason: contains not printable characters */
    private String f1042;
    @Nullable

    /* renamed from: އ  reason: contains not printable characters */
    private String f1043;
    @Nullable

    /* renamed from: މ  reason: contains not printable characters */
    private VideoViewabilityTracker f1045;

    /* renamed from: ލ  reason: contains not printable characters */
    private String f1049;

    /* renamed from: ގ  reason: contains not printable characters */
    private String f1050;

    /* renamed from: ޏ  reason: contains not printable characters */
    private String f1051;

    /* renamed from: ސ  reason: contains not printable characters */
    private boolean f1052;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private String f1063;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private String f1064;
    @NonNull

    /* renamed from: ވ  reason: contains not printable characters */
    private DeviceUtils.ForceOrientation f1044 = DeviceUtils.ForceOrientation.FORCE_LANDSCAPE;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1053 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ArrayList<VastFractionalProgressTracker> f1054 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ArrayList<VastAbsoluteProgressTracker> f1055 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1056 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1057 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1058 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1059 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1060 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1061 = new ArrayList<>();
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final ArrayList<VastTracker> f1062 = new ArrayList<>();
    @NonNull

    /* renamed from: ނ  reason: contains not printable characters */
    private Map<String, VastCompanionAdConfig> f1038 = new HashMap();

    /* renamed from: ބ  reason: contains not printable characters */
    private boolean f1040 = false;
    @NonNull

    /* renamed from: ފ  reason: contains not printable characters */
    private final Map<String, String> f1046 = new HashMap();
    @NonNull

    /* renamed from: ދ  reason: contains not printable characters */
    private final Set<String> f1047 = new HashSet();
    @NonNull

    /* renamed from: ތ  reason: contains not printable characters */
    private final Set<String> f1048 = new HashSet();

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<String> m905(@Nullable String str, @NonNull JSONArray jSONArray) {
        Preconditions.checkNotNull(jSONArray);
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (optString != null) {
                arrayList.add(optString.replace(Constants.VIDEO_TRACKING_URL_MACRO, str));
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<VastTracker> m906(@NonNull List<String> list) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new VastTracker(str));
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m907(@NonNull final Context context, int i, @Nullable final Integer num) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1061, null, Integer.valueOf(i), this.f1064, context);
        if (TextUtils.isEmpty(this.f1063)) {
            return;
        }
        new UrlHandler.Builder().withDspCreativeId(this.f1049).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.mobileads.VastVideoConfig.1
            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
            }

            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                StringBuilder sb;
                if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
                    Bundle bundle = new Bundle();
                    bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
                    bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, VastVideoConfig.this.f1049);
                    Intent startActivityIntent = Intents.getStartActivityIntent(context, MoPubBrowser.class, bundle);
                    try {
                        if (context instanceof Activity) {
                            Preconditions.checkNotNull(num);
                            ((Activity) context).startActivityForResult(startActivityIntent, num.intValue());
                        } else {
                            Intents.startActivity(context, startActivityIntent);
                        }
                    } catch (ActivityNotFoundException unused) {
                        sb = new StringBuilder();
                        sb.append("Activity ");
                        sb.append(MoPubBrowser.class.getName());
                        sb.append(" not found. Did you declare it in your AndroidManifest.xml?");
                        MoPubLog.d(sb.toString());
                    } catch (IntentNotResolvableException unused2) {
                        sb = new StringBuilder();
                        sb.append("Activity ");
                        sb.append(MoPubBrowser.class.getName());
                        sb.append(" not found. Did you declare it in your AndroidManifest.xml?");
                        MoPubLog.d(sb.toString());
                    }
                }
            }
        }).withoutMoPubBrowser().build().handleUrl(context, this.f1063);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m908(@NonNull List<String> list, float f) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new VastFractionalProgressTracker(str, f));
        }
        addFractionalTrackers(arrayList);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m909(@NonNull List<String> list) {
        Preconditions.checkNotNull(list);
        addCompleteTrackers(m906(list));
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m910(@NonNull List<String> list) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new VastAbsoluteProgressTracker(str, 0));
        }
        addAbsoluteTrackers(arrayList);
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m911(@NonNull List<String> list) {
        Preconditions.checkNotNull(list);
        if (hasCompanionAd()) {
            List<VastTracker> m906 = m906(list);
            this.f1036.addCreativeViewTrackers(m906);
            this.f1037.addCreativeViewTrackers(m906);
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m912(@NonNull List<String> list) {
        Preconditions.checkNotNull(list);
        if (hasCompanionAd()) {
            List<VastTracker> m906 = m906(list);
            this.f1036.addClickTrackers(m906);
            this.f1037.addClickTrackers(m906);
        }
    }

    public void addAbsoluteTrackers(@NonNull List<VastAbsoluteProgressTracker> list) {
        Preconditions.checkNotNull(list, "absoluteTrackers cannot be null");
        this.f1055.addAll(list);
        Collections.sort(this.f1055);
    }

    public void addAvidJavascriptResources(@Nullable Set<String> set) {
        if (set != null) {
            this.f1047.addAll(set);
        }
    }

    public void addClickTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.f1061.addAll(list);
    }

    public void addCloseTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "closeTrackers cannot be null");
        this.f1059.addAll(list);
    }

    public void addCompleteTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "completeTrackers cannot be null");
        this.f1058.addAll(list);
    }

    public void addErrorTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        this.f1062.addAll(list);
    }

    public void addExternalViewabilityTrackers(@Nullable Map<String, String> map) {
        if (map != null) {
            this.f1046.putAll(map);
        }
    }

    public void addFractionalTrackers(@NonNull List<VastFractionalProgressTracker> list) {
        Preconditions.checkNotNull(list, "fractionalTrackers cannot be null");
        this.f1054.addAll(list);
        Collections.sort(this.f1054);
    }

    public void addImpressionTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "impressionTrackers cannot be null");
        this.f1053.addAll(list);
    }

    public void addMoatImpressionPixels(@Nullable Set<String> set) {
        if (set != null) {
            this.f1048.addAll(set);
        }
    }

    public void addPauseTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "pauseTrackers cannot be null");
        this.f1056.addAll(list);
    }

    public void addResumeTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "resumeTrackers cannot be null");
        this.f1057.addAll(list);
    }

    public void addSkipTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "skipTrackers cannot be null");
        this.f1060.addAll(list);
    }

    public void addVideoTrackers(@Nullable JSONObject jSONObject) {
        float f;
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(Constants.VIDEO_TRACKING_URLS_KEY);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Constants.VIDEO_TRACKING_EVENTS_KEY);
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        for (int i = 0; i < optJSONArray2.length(); i++) {
            String optString = optJSONArray2.optString(i);
            List<String> m905 = m905(optString, optJSONArray);
            EnumC0228 fromString = EnumC0228.fromString(optString);
            if (optString != null && m905 != null) {
                switch (fromString) {
                    case START:
                        m910(m905);
                        break;
                    case FIRST_QUARTILE:
                        f = 0.25f;
                        m908(m905, f);
                        break;
                    case MIDPOINT:
                        f = 0.5f;
                        m908(m905, f);
                        break;
                    case THIRD_QUARTILE:
                        f = 0.75f;
                        m908(m905, f);
                        break;
                    case COMPLETE:
                        m909(m905);
                        break;
                    case COMPANION_AD_VIEW:
                        m911(m905);
                        break;
                    case COMPANION_AD_CLICK:
                        m912(m905);
                        break;
                    default:
                        MoPubLog.d("Encountered unknown video tracking event: " + optString);
                        break;
                }
            }
        }
    }

    @NonNull
    public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers() {
        return this.f1055;
    }

    @NonNull
    public Set<String> getAvidJavascriptResources() {
        return this.f1047;
    }

    @Nullable
    public String getClickThroughUrl() {
        return this.f1063;
    }

    @NonNull
    public List<VastTracker> getClickTrackers() {
        return this.f1061;
    }

    @NonNull
    public List<VastTracker> getCloseTrackers() {
        return this.f1059;
    }

    @NonNull
    public List<VastTracker> getCompleteTrackers() {
        return this.f1058;
    }

    @Nullable
    public String getCustomCloseIconUrl() {
        return this.f1043;
    }

    @Nullable
    public String getCustomCtaText() {
        return this.f1041;
    }

    @NonNull
    public DeviceUtils.ForceOrientation getCustomForceOrientation() {
        return this.f1044;
    }

    @Nullable
    public String getCustomSkipText() {
        return this.f1042;
    }

    @Nullable
    public String getDiskMediaFileUrl() {
        return this.f1034;
    }

    public String getDspCreativeId() {
        return this.f1049;
    }

    @NonNull
    public List<VastTracker> getErrorTrackers() {
        return this.f1062;
    }

    @NonNull
    public Map<String, String> getExternalViewabilityTrackers() {
        return this.f1046;
    }

    @NonNull
    public ArrayList<VastFractionalProgressTracker> getFractionalTrackers() {
        return this.f1054;
    }

    @NonNull
    public List<VastTracker> getImpressionTrackers() {
        return this.f1053;
    }

    @NonNull
    public Set<String> getMoatImpressionPixels() {
        return this.f1048;
    }

    @Nullable
    public String getNetworkMediaFileUrl() {
        return this.f1064;
    }

    @NonNull
    public List<VastTracker> getPauseTrackers() {
        return this.f1056;
    }

    @Nullable
    public String getPrivacyInformationIconClickthroughUrl() {
        return this.f1051;
    }

    @Nullable
    public String getPrivacyInformationIconImageUrl() {
        return this.f1050;
    }

    public int getRemainingProgressTrackerCount() {
        return getUntriggeredTrackersBefore(Integer.MAX_VALUE, Integer.MAX_VALUE).size();
    }

    @NonNull
    public List<VastTracker> getResumeTrackers() {
        return this.f1057;
    }

    @Nullable
    public Integer getSkipOffsetMillis(int i) {
        Integer valueOf;
        if (this.f1035 != null) {
            try {
                if (Strings.isAbsoluteTracker(this.f1035)) {
                    valueOf = Strings.parseAbsoluteOffset(this.f1035);
                } else if (!Strings.isPercentageTracker(this.f1035)) {
                    MoPubLog.d(String.format("Invalid VAST skipoffset format: %s", this.f1035));
                    return null;
                } else {
                    valueOf = Integer.valueOf(Math.round(i * (Float.parseFloat(this.f1035.replace("%", "")) / 100.0f)));
                }
                if (valueOf != null) {
                    return valueOf.intValue() < i ? valueOf : Integer.valueOf(i);
                }
            } catch (NumberFormatException unused) {
                MoPubLog.d(String.format("Failed to parse skipoffset %s", this.f1035));
            }
        }
        return null;
    }

    @Nullable
    public String getSkipOffsetString() {
        return this.f1035;
    }

    @NonNull
    public List<VastTracker> getSkipTrackers() {
        return this.f1060;
    }

    @NonNull
    public Map<String, VastCompanionAdConfig> getSocialActionsCompanionAds() {
        return this.f1038;
    }

    @NonNull
    public List<VastTracker> getUntriggeredTrackersBefore(int i, int i2) {
        if (!Preconditions.NoThrow.checkArgument(i2 > 0) || i < 0) {
            return Collections.emptyList();
        }
        float f = i / i2;
        ArrayList arrayList = new ArrayList();
        VastAbsoluteProgressTracker vastAbsoluteProgressTracker = new VastAbsoluteProgressTracker("", i);
        int size = this.f1055.size();
        for (int i3 = 0; i3 < size; i3++) {
            VastAbsoluteProgressTracker vastAbsoluteProgressTracker2 = this.f1055.get(i3);
            if (vastAbsoluteProgressTracker2.compareTo(vastAbsoluteProgressTracker) > 0) {
                break;
            }
            if (!vastAbsoluteProgressTracker2.isTracked()) {
                arrayList.add(vastAbsoluteProgressTracker2);
            }
        }
        VastFractionalProgressTracker vastFractionalProgressTracker = new VastFractionalProgressTracker("", f);
        int size2 = this.f1054.size();
        for (int i4 = 0; i4 < size2; i4++) {
            VastFractionalProgressTracker vastFractionalProgressTracker2 = this.f1054.get(i4);
            if (vastFractionalProgressTracker2.compareTo(vastFractionalProgressTracker) > 0) {
                break;
            }
            if (!vastFractionalProgressTracker2.isTracked()) {
                arrayList.add(vastFractionalProgressTracker2);
            }
        }
        return arrayList;
    }

    @Nullable
    public VastCompanionAdConfig getVastCompanionAd(int i) {
        switch (i) {
            case 1:
                return this.f1037;
            case 2:
                return this.f1036;
            default:
                return this.f1036;
        }
    }

    @Nullable
    public C0244 getVastIconConfig() {
        return this.f1039;
    }

    @Nullable
    public VideoViewabilityTracker getVideoViewabilityTracker() {
        return this.f1045;
    }

    public void handleClickForResult(@NonNull Activity activity, int i, int i2) {
        m907(activity, i, Integer.valueOf(i2));
    }

    public void handleClickWithoutResult(@NonNull Context context, int i) {
        m907(context.getApplicationContext(), i, null);
    }

    public void handleClose(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1059, null, Integer.valueOf(i), this.f1064, context);
        TrackingRequest.makeVastTrackingHttpRequest(this.f1060, null, Integer.valueOf(i), this.f1064, context);
    }

    public void handleComplete(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1058, null, Integer.valueOf(i), this.f1064, context);
    }

    public void handleError(@NonNull Context context, @Nullable VastErrorCode vastErrorCode, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1062, vastErrorCode, Integer.valueOf(i), this.f1064, context);
    }

    public void handleImpression(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1053, null, Integer.valueOf(i), this.f1064, context);
    }

    public void handlePause(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1056, null, Integer.valueOf(i), this.f1064, context);
    }

    public void handleResume(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f1057, null, Integer.valueOf(i), this.f1064, context);
    }

    public boolean hasCompanionAd() {
        return (this.f1036 == null || this.f1037 == null) ? false : true;
    }

    public boolean isCustomForceOrientationSet() {
        return this.f1052;
    }

    public boolean isRewardedVideo() {
        return this.f1040;
    }

    public void setClickThroughUrl(@Nullable String str) {
        this.f1063 = str;
    }

    public void setCustomCloseIconUrl(@Nullable String str) {
        if (str != null) {
            this.f1043 = str;
        }
    }

    public void setCustomCtaText(@Nullable String str) {
        if (str != null) {
            this.f1041 = str;
        }
    }

    public void setCustomForceOrientation(@Nullable DeviceUtils.ForceOrientation forceOrientation) {
        if (forceOrientation == null || forceOrientation == DeviceUtils.ForceOrientation.UNDEFINED) {
            return;
        }
        this.f1044 = forceOrientation;
        this.f1052 = true;
    }

    public void setCustomSkipText(@Nullable String str) {
        if (str != null) {
            this.f1042 = str;
        }
    }

    public void setDiskMediaFileUrl(@Nullable String str) {
        this.f1034 = str;
    }

    public void setDspCreativeId(@NonNull String str) {
        this.f1049 = str;
    }

    public void setIsRewardedVideo(boolean z) {
        this.f1040 = z;
    }

    public void setNetworkMediaFileUrl(@Nullable String str) {
        this.f1064 = str;
    }

    public void setPrivacyInformationIconClickthroughUrl(@Nullable String str) {
        this.f1051 = str;
    }

    public void setPrivacyInformationIconImageUrl(@Nullable String str) {
        this.f1050 = str;
    }

    public void setSkipOffset(@Nullable String str) {
        if (str != null) {
            this.f1035 = str;
        }
    }

    public void setSocialActionsCompanionAds(@NonNull Map<String, VastCompanionAdConfig> map) {
        this.f1038 = map;
    }

    public void setVastCompanionAd(@Nullable VastCompanionAdConfig vastCompanionAdConfig, @Nullable VastCompanionAdConfig vastCompanionAdConfig2) {
        this.f1036 = vastCompanionAdConfig;
        this.f1037 = vastCompanionAdConfig2;
    }

    public void setVastIconConfig(@Nullable C0244 c0244) {
        this.f1039 = c0244;
    }

    public void setVideoViewabilityTracker(@Nullable VideoViewabilityTracker videoViewabilityTracker) {
        if (videoViewabilityTracker != null) {
            this.f1045 = videoViewabilityTracker;
        }
    }
}
