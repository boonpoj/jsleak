package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.common.util.Utils;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MoPubRewardedVideoManager {
    public static final int API_VERSION = 1;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static MoPubRewardedVideoManager f910;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static SharedPreferences f911;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private WeakReference<Activity> f913;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Context f914;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private MoPubRewardedVideoListener f916;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Map<String, Set<MediationSettings>> f918;
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final Handler f919;
    @NonNull

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final Map<String, Runnable> f920;
    @NonNull

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final RewardedAdsLoaders f921;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final C0239 f915 = new C0239();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f912 = new Handler(Looper.getMainLooper());
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final Set<MediationSettings> f917 = new HashSet();

    /* loaded from: assets/classes2.dex */
    public static final class RequestParameters {
        @Nullable
        public final String mCustomerId;
        @Nullable
        public final String mKeywords;
        @Nullable
        public final Location mLocation;
        @Nullable
        public final String mUserDataKeywords;

        public RequestParameters(@Nullable String str) {
            this(str, null);
        }

        public RequestParameters(@Nullable String str, @Nullable String str2) {
            this(str, str2, null);
        }

        public RequestParameters(@Nullable String str, @Nullable String str2, @Nullable Location location) {
            this(str, str2, location, null);
        }

        public RequestParameters(@Nullable String str, @Nullable String str2, @Nullable Location location, @Nullable String str3) {
            this.mKeywords = str;
            this.mCustomerId = str3;
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            this.mUserDataKeywords = canCollectPersonalInformation ? str2 : null;
            this.mLocation = canCollectPersonalInformation ? location : null;
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideoManager$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static abstract class AbstractRunnableC0208 implements Runnable {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Class<? extends CustomEventRewardedAd> f939;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f940;

        AbstractRunnableC0208(@NonNull Class<? extends CustomEventRewardedAd> cls, @NonNull String str) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(str);
            this.f939 = cls;
            this.f940 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : MoPubRewardedVideoManager.f910.f915.m1075(this.f939, this.f940)) {
                mo828(str);
            }
        }

        /* renamed from: ࢠ */
        protected abstract void mo828(@NonNull String str);
    }

    private MoPubRewardedVideoManager(@NonNull Activity activity, MediationSettings... mediationSettingsArr) {
        this.f913 = new WeakReference<>(activity);
        this.f914 = activity.getApplicationContext();
        MoPubCollections.addAllNonNull(this.f917, mediationSettingsArr);
        this.f918 = new HashMap();
        this.f919 = new Handler();
        this.f920 = new HashMap();
        this.f921 = new RewardedAdsLoaders(this);
        f911 = SharedPreferencesHelper.getSharedPreferences(this.f914, "mopubCustomEventSettings");
    }

    @NonNull
    public static Set<MoPubReward> getAvailableRewards(@NonNull String str) {
        if (f910 != null) {
            return f910.f915.m1087(str);
        }
        m813();
        return Collections.emptySet();
    }

    @Nullable
    public static <T extends MediationSettings> T getGlobalMediationSettings(@NonNull Class<T> cls) {
        if (f910 == null) {
            m813();
            return null;
        }
        for (MediationSettings mediationSettings : f910.f917) {
            if (cls.equals(mediationSettings.getClass())) {
                return cls.cast(mediationSettings);
            }
        }
        return null;
    }

    @Nullable
    public static <T extends MediationSettings> T getInstanceMediationSettings(@NonNull Class<T> cls, @NonNull String str) {
        if (f910 == null) {
            m813();
            return null;
        }
        Set<MediationSettings> set = f910.f918.get(str);
        if (set == null) {
            return null;
        }
        for (MediationSettings mediationSettings : set) {
            if (cls.equals(mediationSettings.getClass())) {
                return cls.cast(mediationSettings);
            }
        }
        return null;
    }

    public static boolean hasVideo(@NonNull String str) {
        if (f910 != null) {
            return m811(str, f910.f915.m1073(str));
        }
        m813();
        return false;
    }

    public static synchronized void init(@NonNull Activity activity, MediationSettings... mediationSettingsArr) {
        synchronized (MoPubRewardedVideoManager.class) {
            if (f910 == null) {
                f910 = new MoPubRewardedVideoManager(activity, mediationSettingsArr);
            } else {
                MoPubLog.e("Tried to call initializeRewardedVideo more than once. Only the first initialization call has any effect.");
            }
        }
    }

    @NonNull
    public static synchronized List<CustomEventRewardedVideo> initNetworks(@NonNull Activity activity, @NonNull List<Class<? extends CustomEventRewardedVideo>> list) {
        synchronized (MoPubRewardedVideoManager.class) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(list);
            if (f910 == null) {
                m813();
                return Collections.emptyList();
            }
            LinkedList linkedList = new LinkedList();
            Map<String, ?> all = f911.getAll();
            MoPubLog.d(String.format(Locale.US, "fetched init settings for %s networks: %s", Integer.valueOf(all.size()), all.keySet()));
            Iterator it = new LinkedHashSet(list).iterator();
            while (it.hasNext()) {
                String name = ((Class) it.next()).getName();
                if (all.containsKey(name)) {
                    try {
                        Map<String, String> jsonStringToMap = Json.jsonStringToMap((String) all.get(name));
                        CustomEventRewardedVideo customEventRewardedVideo = (CustomEventRewardedVideo) Reflection.instantiateClassWithEmptyConstructor(name, CustomEventRewardedVideo.class);
                        MoPubLog.d(String.format(Locale.US, "Initializing %s with params %s", name, jsonStringToMap));
                        customEventRewardedVideo.checkAndInitializeSdk(activity, Collections.emptyMap(), jsonStringToMap);
                        linkedList.add(customEventRewardedVideo);
                    } catch (Exception unused) {
                        MoPubLog.e("Error fetching init settings for network " + name);
                    }
                } else {
                    MoPubLog.d("Init settings not found for " + name);
                }
            }
            return linkedList;
        }
    }

    public static void loadVideo(@NonNull final String str, @Nullable RequestParameters requestParameters, @Nullable MediationSettings... mediationSettingsArr) {
        Preconditions.checkNotNull(str);
        if (f910 == null) {
            m813();
        } else if (str.equals(f910.f915.m1074())) {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. The ad is already showing.", str));
        } else if (f910.f921.m862(str)) {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. This ad unit already finished loading and is ready to show.", str));
            m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MoPubRewardedVideoManager.f910.f916 != null) {
                        MoPubRewardedVideoManager.f910.f916.onRewardedVideoLoadSuccess(str);
                    }
                }
            });
        } else {
            HashSet hashSet = new HashSet();
            MoPubCollections.addAllNonNull(hashSet, mediationSettingsArr);
            f910.f918.put(str, hashSet);
            String str2 = requestParameters == null ? null : requestParameters.mCustomerId;
            if (!TextUtils.isEmpty(str2)) {
                f910.f915.m1092(str2);
            }
            m810(str, new WebViewAdUrlGenerator(f910.f914, false).withAdUnitId(str).withKeywords(requestParameters == null ? null : requestParameters.mKeywords).withUserDataKeywords((requestParameters == null || !MoPub.canCollectPersonalInformation()) ? null : requestParameters.mUserDataKeywords).withLocation(requestParameters == null ? null : requestParameters.mLocation).generateUrlString(Constants.HOST), (MoPubErrorCode) null);
        }
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoClicked(@NonNull Class<T> cls, String str) {
        final String m1074 = f910.f915.m1074();
        if (TextUtils.isEmpty(m1074)) {
            m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.15
                @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
                /* renamed from: ࢠ */
                protected void mo828(@NonNull String str2) {
                    MoPubRewardedVideoManager.m823(str2);
                }
            });
        } else {
            m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.2
                @Override // java.lang.Runnable
                public void run() {
                    MoPubRewardedVideoManager.m823(m1074);
                }
            });
        }
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoClosed(@NonNull Class<T> cls, String str) {
        final String m1074 = f910.f915.m1074();
        if (TextUtils.isEmpty(m1074)) {
            m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.3
                @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
                /* renamed from: ࢠ */
                protected void mo828(@NonNull String str2) {
                    MoPubRewardedVideoManager.m824(str2);
                }
            });
        } else {
            m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.4
                @Override // java.lang.Runnable
                public void run() {
                    MoPubRewardedVideoManager.m824(m1074);
                }
            });
        }
        f910.f915.m1091(null);
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoCompleted(@NonNull Class<T> cls, String str, @NonNull MoPubReward moPubReward) {
        String m1074 = f910.f915.m1074();
        m805(cls, str, moPubReward, m1074);
        m825(m1074);
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoLoadFailure(@NonNull Class<T> cls, String str, final MoPubErrorCode moPubErrorCode) {
        m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.10
            @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
            /* renamed from: ࢠ  reason: contains not printable characters */
            protected void mo828(@NonNull String str2) {
                MoPubRewardedVideoManager.f910.m821(str2);
                MoPubRewardedVideoManager.f910.m815(str2, moPubErrorCode);
            }
        });
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoLoadSuccess(@NonNull Class<T> cls, @NonNull String str) {
        m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.9
            @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
            /* renamed from: ࢠ */
            protected void mo828(@NonNull String str2) {
                MoPubRewardedVideoManager.f910.m821(str2);
                MoPubRewardedVideoManager.f910.f921.m864(str2);
                if (MoPubRewardedVideoManager.f910.f916 != null) {
                    MoPubRewardedVideoManager.f910.f916.onRewardedVideoLoadSuccess(str2);
                }
            }
        });
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoPlaybackError(@NonNull Class<T> cls, String str, final MoPubErrorCode moPubErrorCode) {
        final String m1074 = f910.f915.m1074();
        if (TextUtils.isEmpty(m1074)) {
            m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.13
                @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
                /* renamed from: ࢠ */
                protected void mo828(@NonNull String str2) {
                    MoPubRewardedVideoManager.m819(str2, moPubErrorCode);
                }
            });
        } else {
            m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.14
                @Override // java.lang.Runnable
                public void run() {
                    MoPubRewardedVideoManager.m819(m1074, moPubErrorCode);
                }
            });
        }
        f910.f915.m1091(null);
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoStarted(@NonNull Class<T> cls, String str) {
        final String m1074 = f910.f915.m1074();
        if (TextUtils.isEmpty(m1074)) {
            m806(new AbstractRunnableC0208(cls, str) { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.11
                @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC0208
                /* renamed from: ࢠ */
                protected void mo828(@NonNull String str2) {
                    MoPubRewardedVideoManager.m822(str2);
                }
            });
        } else {
            m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.12
                @Override // java.lang.Runnable
                public void run() {
                    MoPubRewardedVideoManager.m822(m1074);
                }
            });
        }
    }

    public static void selectReward(@NonNull String str, @NonNull MoPubReward moPubReward) {
        if (f910 != null) {
            f910.f915.m1078(str, moPubReward);
        } else {
            m813();
        }
    }

    public static void setVideoListener(@Nullable MoPubRewardedVideoListener moPubRewardedVideoListener) {
        if (f910 != null) {
            f910.f916 = moPubRewardedVideoListener;
        } else {
            m813();
        }
    }

    public static void showVideo(@NonNull String str) {
        showVideo(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void showVideo(@NonNull String str, @Nullable String str2) {
        if (f910 == null) {
            m813();
            return;
        }
        if (str2 != null && str2.length() > 8192) {
            MoPubLog.w(String.format(Locale.US, "Provided rewarded ad custom data parameter longer than supported(%d bytes, %d maximum)", Integer.valueOf(str2.length()), 8192));
        }
        CustomEventRewardedAd m1073 = f910.f915.m1073(str);
        if (!m811(str, m1073)) {
            MoPubLog.d(f910.f921.m858(str) ? "Rewarded ad is not ready to be shown yet." : "No rewarded ad loading or loaded.");
            f910.m815(str, MoPubErrorCode.VIDEO_NOT_AVAILABLE);
        } else if (!f910.f915.m1087(str).isEmpty() && f910.f915.m1082(str) == null) {
            f910.m815(str, MoPubErrorCode.REWARD_NOT_SELECTED);
        } else {
            f910.f915.m1076((Class<? extends CustomEventRewardedAd>) m1073.getClass(), f910.f915.m1082(str));
            f910.f915.m1084(str, str2);
            f910.f915.m1091(str);
            m1073.mo757();
        }
    }

    @ReflectionTarget
    public static void updateActivity(@Nullable Activity activity) {
        if (f910 == null) {
            m813();
            return;
        }
        f910.f913 = new WeakReference<>(activity);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static MoPubReward m800(@Nullable MoPubReward moPubReward, @NonNull MoPubReward moPubReward2) {
        return (moPubReward2.isSuccessful() && moPubReward != null) ? moPubReward : moPubReward2;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static <T extends CustomEventRewardedAd> void m805(@NonNull final Class<T> cls, @Nullable final String str, @NonNull final MoPubReward moPubReward, @Nullable final String str2) {
        m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.6
            @Override // java.lang.Runnable
            public void run() {
                MoPubReward m800 = MoPubRewardedVideoManager.m800(MoPubRewardedVideoManager.f910.f915.m1072(cls), moPubReward);
                HashSet hashSet = new HashSet();
                if (TextUtils.isEmpty(str2)) {
                    hashSet.addAll(MoPubRewardedVideoManager.f910.f915.m1075(cls, str));
                } else {
                    hashSet.add(str2);
                }
                if (MoPubRewardedVideoManager.f910.f916 != null) {
                    MoPubRewardedVideoManager.f910.f916.onRewardedVideoCompleted(hashSet, m800);
                }
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m806(@NonNull Runnable runnable) {
        if (f910 != null) {
            f910.f912.post(runnable);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m809(@NonNull String str, @NonNull String str2) throws JSONException {
        String[] jsonArrayToStringArray = Json.jsonArrayToStringArray(Json.jsonStringToMap(str2).get("rewards"));
        if (jsonArrayToStringArray.length == 1) {
            Map<String, String> jsonStringToMap = Json.jsonStringToMap(jsonArrayToStringArray[0]);
            this.f915.m1085(str, jsonStringToMap.get("name"), jsonStringToMap.get("amount"));
        }
        for (String str3 : jsonArrayToStringArray) {
            Map<String, String> jsonStringToMap2 = Json.jsonStringToMap(str3);
            this.f915.m1081(str, jsonStringToMap2.get("name"), jsonStringToMap2.get("amount"));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m810(@NonNull String str, @NonNull String str2, @Nullable MoPubErrorCode moPubErrorCode) {
        if (f910 == null) {
            m813();
        } else {
            f910.m816(str, str2, moPubErrorCode);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m811(String str, @Nullable CustomEventRewardedAd customEventRewardedAd) {
        return f910 != null && f910.f921.m862(str) && customEventRewardedAd != null && customEventRewardedAd.mo756();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static void m813() {
        MoPubLog.e("MoPub rewarded ads must be initialized with an Activity Context before calling rewarded ads methods.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m815(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        if (this.f921.m863(str) && !moPubErrorCode.equals(MoPubErrorCode.EXPIRED)) {
            m810(str, "", moPubErrorCode);
        } else if (f910.f916 != null) {
            f910.f916.onRewardedVideoLoadFailure(str, moPubErrorCode);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m816(@NonNull String str, @NonNull String str2, @Nullable MoPubErrorCode moPubErrorCode) {
        if (this.f921.m858(str)) {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. A request is already pending.", str));
        } else if (this.f921.m858(str)) {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. A request is already pending.", str));
        } else {
            MoPubLog.d(String.format(Locale.US, "Loading rewarded ad request for ad unit %s with URL %s", str, str2));
            this.f921.m856(this.f914, str, str2, moPubErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static void m819(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        f910.f921.m859(str);
        if (f910.f916 != null) {
            f910.f916.onRewardedVideoPlaybackError(str, moPubErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m821(@NonNull String str) {
        Runnable remove = this.f920.remove(str);
        if (remove != null) {
            this.f919.removeCallbacks(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public static void m822(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (f910.f916 != null) {
            f910.f916.onRewardedVideoStarted(str);
        }
        f910.f921.m857(str, f910.f914);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public static void m823(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (f910.f916 != null) {
            f910.f916.onRewardedVideoClicked(str);
        }
        f910.f921.m860(str, f910.f914);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public static void m824(@NonNull String str) {
        Preconditions.checkNotNull(str);
        f910.f921.m861(str);
        if (f910.f916 != null) {
            f910.f916.onRewardedVideoClosed(str);
        }
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private static void m825(@Nullable final String str) {
        final String m1090 = f910.f915.m1090(str);
        if (TextUtils.isEmpty(m1090)) {
            return;
        }
        m806(new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.5
            @Override // java.lang.Runnable
            public void run() {
                MoPubReward m1082 = MoPubRewardedVideoManager.f910.f915.m1082(str);
                String label = m1082 == null ? "" : m1082.getLabel();
                String num = Integer.toString(m1082 == null ? 0 : m1082.getAmount());
                CustomEventRewardedAd m1073 = MoPubRewardedVideoManager.f910.f915.m1073(str);
                RewardedVideoCompletionRequestHandler.makeRewardedVideoCompletionRequest(MoPubRewardedVideoManager.f910.f914, m1090, MoPubRewardedVideoManager.f910.f915.m1083(), label, num, (m1073 == null || m1073.getClass() == null) ? null : m1073.getClass().getName(), MoPubRewardedVideoManager.f910.f915.m1086(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m826(AdResponse adResponse) {
        String adUnitId = adResponse.getAdUnitId();
        Integer adTimeoutMillis = adResponse.getAdTimeoutMillis(30000);
        String customEventClassName = adResponse.getCustomEventClassName();
        if (customEventClassName == null) {
            MoPubLog.e("Couldn't create custom event, class name was null.");
            m815(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        CustomEventRewardedAd m1073 = this.f915.m1073(adUnitId);
        if (m1073 != null) {
            m1073.mo654();
        }
        try {
            final CustomEventRewardedAd customEventRewardedAd = (CustomEventRewardedAd) Reflection.instantiateClassWithEmptyConstructor(customEventClassName, CustomEventRewardedAd.class);
            TreeMap treeMap = new TreeMap();
            treeMap.put(DataKeys.AD_UNIT_ID_KEY, adUnitId);
            treeMap.put(DataKeys.REWARDED_AD_CURRENCY_NAME_KEY, adResponse.getRewardedVideoCurrencyName());
            treeMap.put(DataKeys.REWARDED_AD_CURRENCY_AMOUNT_STRING_KEY, adResponse.getRewardedVideoCurrencyAmount());
            treeMap.put(DataKeys.REWARDED_AD_DURATION_KEY, adResponse.getRewardedDuration());
            treeMap.put(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, Boolean.valueOf(adResponse.shouldRewardOnClick()));
            treeMap.put(DataKeys.AD_REPORT_KEY, new AdReport(adUnitId, ClientMetadata.getInstance(this.f914), adResponse));
            treeMap.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(Utils.generateUniqueId()));
            treeMap.put("rewarded-ad-customer-id", this.f915.m1083());
            String rewardedCurrencies = adResponse.getRewardedCurrencies();
            this.f915.m1088(adUnitId);
            this.f915.m1089(adUnitId);
            if (TextUtils.isEmpty(rewardedCurrencies)) {
                this.f915.m1085(adUnitId, adResponse.getRewardedVideoCurrencyName(), adResponse.getRewardedVideoCurrencyAmount());
            } else {
                try {
                    m809(adUnitId, rewardedCurrencies);
                } catch (Exception unused) {
                    MoPubLog.e("Error parsing rewarded currencies JSON header: " + rewardedCurrencies);
                    m815(adUnitId, MoPubErrorCode.REWARDED_CURRENCIES_PARSING_ERROR);
                    return;
                }
            }
            this.f915.m1080(adUnitId, adResponse.getRewardedVideoCompletionUrl());
            Activity activity = this.f913.get();
            if (activity == null) {
                MoPubLog.d("Could not load custom event because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded ads.");
                this.f921.m859(adUnitId);
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedVideoManager.8
                @Override // java.lang.Runnable
                public void run() {
                    MoPubLog.d("Custom Event failed to load rewarded ad in a timely fashion.");
                    MoPubRewardedVideoManager.onRewardedVideoLoadFailure(customEventRewardedAd.getClass(), customEventRewardedAd.getAdNetworkId(), MoPubErrorCode.NETWORK_TIMEOUT);
                    customEventRewardedAd.mo654();
                }
            };
            this.f919.postDelayed(runnable, adTimeoutMillis.intValue());
            this.f920.put(adUnitId, runnable);
            Map<String, String> serverExtras = adResponse.getServerExtras();
            if (customEventRewardedAd instanceof CustomEventRewardedVideo) {
                String jSONObject = new JSONObject(serverExtras).toString();
                MoPubLog.d(String.format(Locale.US, "Updating init settings for custom event %s with params %s", customEventClassName, jSONObject));
                f911.edit().putString(customEventClassName, jSONObject).commit();
            }
            MoPubLog.d(String.format(Locale.US, "Loading custom event with class name %s", customEventClassName));
            customEventRewardedAd.m755(activity, treeMap, serverExtras);
            this.f915.m1079(adUnitId, customEventRewardedAd, customEventRewardedAd.getAdNetworkId());
        } catch (Exception unused2) {
            MoPubLog.e(String.format(Locale.US, "Couldn't create custom event with class name %s", customEventClassName));
            m815(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m827(@NonNull VolleyError volleyError, @NonNull String str) {
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case NO_FILL:
                case WARMING_UP:
                    moPubErrorCode = MoPubErrorCode.NO_FILL;
                    break;
                default:
                    moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                    break;
            }
        }
        if (volleyError instanceof NoConnectionError) {
            moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
        }
        m815(str, moPubErrorCode);
    }
}
