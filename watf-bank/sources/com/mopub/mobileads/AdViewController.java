package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class AdViewController {

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static final FrameLayout.LayoutParams f726 = new FrameLayout.LayoutParams(-2, -2, 17);

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static final WeakHashMap<View, Boolean> f727 = new WeakHashMap<>();

    /* renamed from: ؠ  reason: contains not printable characters */
    private boolean f729;

    /* renamed from: ށ  reason: contains not printable characters */
    private boolean f731;

    /* renamed from: ޅ  reason: contains not printable characters */
    private String f735;

    /* renamed from: ކ  reason: contains not printable characters */
    private String f736;

    /* renamed from: އ  reason: contains not printable characters */
    private Location f737;

    /* renamed from: ވ  reason: contains not printable characters */
    private boolean f738;

    /* renamed from: މ  reason: contains not printable characters */
    private boolean f739;
    @Nullable

    /* renamed from: ފ  reason: contains not printable characters */
    private String f740;
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    AdLoader f742;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Context f745;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private MoPubView f746;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private WebViewAdUrlGenerator f747;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private Request f748;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private AdResponse f750;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private String f751;
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    int f743 = 1;

    /* renamed from: ނ  reason: contains not printable characters */
    private Map<String, Object> f732 = new HashMap();

    /* renamed from: ރ  reason: contains not printable characters */
    private boolean f733 = true;

    /* renamed from: ބ  reason: contains not printable characters */
    private boolean f734 = true;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final long f744 = Utils.generateUniqueId();
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final AdLoader.Listener f749 = new AdLoader.Listener() { // from class: com.mopub.mobileads.AdViewController.1
        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            AdViewController.this.m674(volleyError);
        }

        @Override // com.mopub.network.AdLoader.Listener
        public void onSuccess(AdResponse adResponse) {
            AdViewController.this.m673(adResponse);
        }
    };

    /* renamed from: ֏  reason: contains not printable characters */
    private final Runnable f728 = new Runnable() { // from class: com.mopub.mobileads.AdViewController.2
        @Override // java.lang.Runnable
        public void run() {
            AdViewController.this.m659();
        }
    };
    @Nullable

    /* renamed from: ދ  reason: contains not printable characters */
    private Integer f741 = 60000;

    /* renamed from: ހ  reason: contains not printable characters */
    private Handler f730 = new Handler();

    public AdViewController(@NonNull Context context, @NonNull MoPubView moPubView) {
        this.f745 = context;
        this.f746 = moPubView;
        this.f747 = new WebViewAdUrlGenerator(this.f745.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(this.f745));
    }

    public static void setShouldHonorServerDimensions(View view) {
        f727.put(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ؠ  reason: contains not printable characters */
    public void m659() {
        this.f739 = true;
        if (TextUtils.isEmpty(this.f740)) {
            MoPubLog.d("Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
        } else if (m661()) {
            m675(m690(), (MoPubError) null);
        } else {
            MoPubLog.d("Can't load an ad because there is no network connectivity.");
            m691();
        }
    }

    /* renamed from: ހ  reason: contains not printable characters */
    private void m660() {
        this.f730.removeCallbacks(this.f728);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: ށ  reason: contains not printable characters */
    private boolean m661() {
        if (this.f745 == null) {
            return false;
        }
        if (DeviceUtils.isPermissionGranted(this.f745, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f745.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return true;
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static MoPubErrorCode m663(@NonNull VolleyError volleyError, @Nullable Context context) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (!(volleyError instanceof MoPubNetworkError)) {
            return networkResponse == null ? !DeviceUtils.isNetworkAvailable(context) ? MoPubErrorCode.NO_CONNECTION : MoPubErrorCode.UNSPECIFIED : volleyError.networkResponse.statusCode >= 400 ? MoPubErrorCode.SERVER_ERROR : MoPubErrorCode.UNSPECIFIED;
        }
        switch (((MoPubNetworkError) volleyError).getReason()) {
            case WARMING_UP:
                return MoPubErrorCode.WARMUP;
            case NO_FILL:
                return MoPubErrorCode.NO_FILL;
            default:
                return MoPubErrorCode.UNSPECIFIED;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m665(boolean z) {
        if (this.f739 && this.f733 != z) {
            String str = z ? "enabled" : "disabled";
            MoPubLog.d("Refresh " + str + " for ad unit (" + this.f740 + ").");
        }
        this.f733 = z;
        if (this.f739 && this.f733) {
            m691();
        } else if (this.f733) {
        } else {
            m660();
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean m666(View view) {
        return f727.get(view) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public FrameLayout.LayoutParams m667(View view) {
        Integer num;
        Integer num2 = null;
        if (this.f750 != null) {
            num2 = this.f750.getWidth();
            num = this.f750.getHeight();
        } else {
            num = null;
        }
        return (num2 == null || num == null || !m666(view) || num2.intValue() <= 0 || num.intValue() <= 0) ? f726 : new FrameLayout.LayoutParams(Dips.asIntPixels(num2.intValue(), this.f745), Dips.asIntPixels(num.intValue(), this.f745), 17);
    }

    public int getAdHeight() {
        if (this.f750 == null || this.f750.getHeight() == null) {
            return 0;
        }
        return this.f750.getHeight().intValue();
    }

    @Nullable
    public AdReport getAdReport() {
        if (this.f740 == null || this.f750 == null) {
            return null;
        }
        return new AdReport(this.f740, ClientMetadata.getInstance(this.f745), this.f750);
    }

    public String getAdUnitId() {
        return this.f740;
    }

    public int getAdWidth() {
        if (this.f750 == null || this.f750.getWidth() == null) {
            return 0;
        }
        return this.f750.getWidth().intValue();
    }

    @Deprecated
    public boolean getAutorefreshEnabled() {
        return getCurrentAutoRefreshStatus();
    }

    public long getBroadcastIdentifier() {
        return this.f744;
    }

    public boolean getCurrentAutoRefreshStatus() {
        return this.f733;
    }

    @Nullable
    public String getCustomEventClassName() {
        return this.f751;
    }

    public String getKeywords() {
        return this.f735;
    }

    public Location getLocation() {
        if (MoPub.canCollectPersonalInformation()) {
            return this.f737;
        }
        return null;
    }

    @Nullable
    public MoPubView getMoPubView() {
        return this.f746;
    }

    public boolean getTesting() {
        return this.f738;
    }

    public String getUserDataKeywords() {
        if (MoPub.canCollectPersonalInformation()) {
            return this.f736;
        }
        return null;
    }

    public void loadAd() {
        this.f743 = 1;
        m659();
    }

    @Deprecated
    public void reload() {
        loadAd();
    }

    public void setAdUnitId(@NonNull String str) {
        this.f740 = str;
    }

    public void setKeywords(String str) {
        this.f735 = str;
    }

    public void setLocation(Location location) {
        if (MoPub.canCollectPersonalInformation()) {
            this.f737 = location;
        } else {
            this.f737 = null;
        }
    }

    public void setTesting(boolean z) {
        this.f738 = z;
    }

    public void setUserDataKeywords(String str) {
        if (MoPub.canCollectPersonalInformation()) {
            this.f736 = str;
        } else {
            this.f736 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ֏  reason: contains not printable characters */
    public Map<String, Object> m668() {
        return this.f732 != null ? new TreeMap(this.f732) : new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m669(int i) {
        return this.f750 == null ? Integer.valueOf(i) : this.f750.getAdTimeoutMillis(i);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m670() {
        if (this.f748 != null) {
            if (!this.f748.isCanceled()) {
                this.f748.cancel();
            }
            this.f748 = null;
        }
        this.f742 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m671(final View view) {
        this.f730.post(new Runnable() { // from class: com.mopub.mobileads.AdViewController.3
            @Override // java.lang.Runnable
            public void run() {
                MoPubView moPubView = AdViewController.this.getMoPubView();
                if (moPubView == null) {
                    return;
                }
                moPubView.removeAllViews();
                moPubView.addView(view, AdViewController.this.m667(view));
            }
        });
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m672(@Nullable MoPubView moPubView, @Nullable String str, @NonNull Map<String, String> map) {
        Preconditions.checkNotNull(map);
        if (moPubView == null) {
            MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
        } else {
            moPubView.mo796(str, map);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m673(@NonNull AdResponse adResponse) {
        this.f743 = 1;
        this.f750 = adResponse;
        this.f751 = adResponse.getCustomEventClassName();
        this.f741 = this.f750.getRefreshTimeMillis();
        this.f748 = null;
        m672(this.f746, adResponse.getCustomEventClassName(), adResponse.getServerExtras());
        m691();
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m674(VolleyError volleyError) {
        if (volleyError instanceof MoPubNetworkError) {
            MoPubNetworkError moPubNetworkError = (MoPubNetworkError) volleyError;
            if (moPubNetworkError.getRefreshTimeMillis() != null) {
                this.f741 = moPubNetworkError.getRefreshTimeMillis();
            }
        }
        MoPubErrorCode m663 = m663(volleyError, this.f745);
        if (m663 == MoPubErrorCode.SERVER_ERROR) {
            this.f743++;
        }
        m680(m663);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m675(@Nullable String str, @Nullable MoPubError moPubError) {
        if (str == null) {
            m680(MoPubErrorCode.NO_FILL);
            return;
        }
        if (!str.startsWith("javascript:")) {
            MoPubLog.d("Loading url: " + str);
        }
        if (this.f748 == null) {
            m681(str, moPubError);
        } else if (TextUtils.isEmpty(this.f740)) {
        } else {
            MoPubLog.i("Already loading an ad for " + this.f740 + ", wait to finish.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m676(Map<String, Object> map) {
        this.f732 = map != null ? new TreeMap(map) : new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m677(boolean z) {
        this.f734 = z;
        m665(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m678(MoPubErrorCode moPubErrorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("MoPubErrorCode: ");
        sb.append(moPubErrorCode == null ? "" : moPubErrorCode.toString());
        Log.v("MoPub", sb.toString());
        if (this.f742 == null || !this.f742.hasMoreAds()) {
            m680(MoPubErrorCode.NO_FILL);
            return false;
        }
        m675("", moPubErrorCode);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m679() {
        m691();
        if (this.f742 == null) {
            MoPubLog.w("mAdLoader is not supposed to be null");
            return;
        }
        this.f742.creativeDownloadSuccess();
        this.f742 = null;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    void m680(MoPubErrorCode moPubErrorCode) {
        MoPubLog.i("Ad failed to load.");
        m670();
        MoPubView moPubView = getMoPubView();
        if (moPubView == null) {
            return;
        }
        m691();
        moPubView.mo795(moPubErrorCode);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    void m681(@NonNull String str, @Nullable MoPubError moPubError) {
        MoPubView moPubView = getMoPubView();
        if (moPubView == null || this.f745 == null) {
            MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
            m670();
            return;
        }
        synchronized (this) {
            if (this.f742 == null || !this.f742.hasMoreAds()) {
                this.f742 = new AdLoader(str, moPubView.getAdFormat(), this.f740, this.f745, this.f749);
            }
        }
        this.f748 = this.f742.loadNextAd(moPubError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m682() {
        m665(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m683() {
        if (!this.f734 || this.f731) {
            return;
        }
        m665(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m684() {
        this.f731 = true;
        m682();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m685() {
        this.f731 = false;
        m683();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public void m686() {
        if (this.f729) {
            return;
        }
        m670();
        m665(false);
        m660();
        this.f746 = null;
        this.f745 = null;
        this.f747 = null;
        this.f729 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m687() {
        if (this.f750 != null) {
            TrackingRequest.makeTrackingHttpRequest(this.f750.getImpressionTrackingUrls(), this.f745);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m688() {
        if (this.f750 != null) {
            TrackingRequest.makeTrackingHttpRequest(this.f750.getClickTrackingUrl(), this.f745);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢪ  reason: contains not printable characters */
    public void m689() {
        m670();
        loadAd();
    }

    @Nullable
    /* renamed from: ࢫ  reason: contains not printable characters */
    String m690() {
        if (this.f747 == null) {
            return null;
        }
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        this.f747.withAdUnitId(this.f740).withKeywords(this.f735).withUserDataKeywords(canCollectPersonalInformation ? this.f736 : null).withLocation(canCollectPersonalInformation ? this.f737 : null);
        return this.f747.generateUrlString(Constants.HOST);
    }

    /* renamed from: ࢬ  reason: contains not printable characters */
    void m691() {
        m660();
        if (!this.f733 || this.f741 == null || this.f741.intValue() <= 0) {
            return;
        }
        this.f730.postDelayed(this.f728, Math.min(600000L, this.f741.intValue() * ((long) Math.pow(1.5d, this.f743))));
    }
}
