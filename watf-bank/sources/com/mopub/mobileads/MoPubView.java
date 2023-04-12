package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public class MoPubView extends FrameLayout {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Context f941;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected AdViewController f942;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected Object f943;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f944;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private BroadcastReceiver f945;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private BannerAdListener f946;

    /* loaded from: assets/classes2.dex */
    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.f941 = context;
        this.f944 = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.f942 = AdViewControllerFactory.create(context, this);
        m832();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdVisibility(int i) {
        if (this.f942 == null) {
            return;
        }
        if (Visibility.isScreenVisible(i)) {
            this.f942.m683();
        } else {
            this.f942.m682();
        }
    }

    /* renamed from: ֏  reason: contains not printable characters */
    private void m829() {
        try {
            this.f941.unregisterReceiver(this.f945);
        } catch (Exception unused) {
            MoPubLog.d("Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    /* renamed from: ؠ  reason: contains not printable characters */
    private void m830() {
        if (this.f943 != null) {
            try {
                new Reflection.MethodBuilder(this.f943, "invalidate").setAccessible().execute();
            } catch (Exception e) {
                MoPubLog.e("Error invalidating adapter", e);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m832() {
        this.f945 = new BroadcastReceiver() { // from class: com.mopub.mobileads.MoPubView.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                MoPubView moPubView;
                int i;
                if (!Visibility.isScreenVisible(MoPubView.this.f944) || intent == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    moPubView = MoPubView.this;
                    i = 0;
                } else if (!"android.intent.action.SCREEN_OFF".equals(action)) {
                    return;
                } else {
                    moPubView = MoPubView.this;
                    i = 8;
                }
                moPubView.setAdVisibility(i);
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f941.registerReceiver(this.f945, intentFilter);
    }

    public void destroy() {
        m829();
        removeAllViews();
        if (this.f942 != null) {
            this.f942.m686();
            this.f942 = null;
        }
        if (this.f943 != null) {
            m830();
            this.f943 = null;
        }
    }

    public void forceRefresh() {
        if (this.f943 != null) {
            m830();
            this.f943 = null;
        }
        if (this.f942 != null) {
            this.f942.m689();
        }
    }

    public Activity getActivity() {
        return (Activity) this.f941;
    }

    public AdFormat getAdFormat() {
        return AdFormat.BANNER;
    }

    public int getAdHeight() {
        if (this.f942 != null) {
            return this.f942.getAdHeight();
        }
        return 0;
    }

    public String getAdUnitId() {
        if (this.f942 != null) {
            return this.f942.getAdUnitId();
        }
        return null;
    }

    AdViewController getAdViewController() {
        return this.f942;
    }

    public int getAdWidth() {
        if (this.f942 != null) {
            return this.f942.getAdWidth();
        }
        return 0;
    }

    public boolean getAutorefreshEnabled() {
        if (this.f942 != null) {
            return this.f942.getCurrentAutoRefreshStatus();
        }
        MoPubLog.d("Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public BannerAdListener getBannerAdListener() {
        return this.f946;
    }

    @Deprecated
    public String getClickTrackingUrl() {
        return null;
    }

    public String getKeywords() {
        if (this.f942 != null) {
            return this.f942.getKeywords();
        }
        return null;
    }

    public Map<String, Object> getLocalExtras() {
        return this.f942 != null ? this.f942.m668() : new TreeMap();
    }

    public Location getLocation() {
        if (this.f942 == null || !MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f942.getLocation();
    }

    @Deprecated
    public String getResponseString() {
        return null;
    }

    public boolean getTesting() {
        if (this.f942 != null) {
            return this.f942.getTesting();
        }
        MoPubLog.d("Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    public String getUserDataKeywords() {
        if (this.f942 == null || !MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f942.getUserDataKeywords();
    }

    public void loadAd() {
        if (this.f942 != null) {
            this.f942.loadAd();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (Visibility.hasScreenVisibilityChanged(this.f944, i)) {
            this.f944 = i;
            setAdVisibility(this.f944);
        }
    }

    public void setAdContentView(View view) {
        if (this.f942 != null) {
            this.f942.m671(view);
        }
    }

    public void setAdUnitId(String str) {
        if (this.f942 != null) {
            this.f942.setAdUnitId(str);
        }
    }

    public void setAutorefreshEnabled(boolean z) {
        if (this.f942 != null) {
            this.f942.m677(z);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.f946 = bannerAdListener;
    }

    public void setKeywords(String str) {
        if (this.f942 != null) {
            this.f942.setKeywords(str);
        }
    }

    public void setLocalExtras(Map<String, Object> map) {
        if (this.f942 != null) {
            this.f942.m676(map);
        }
    }

    public void setLocation(Location location) {
        if (this.f942 == null || !MoPub.canCollectPersonalInformation()) {
            return;
        }
        this.f942.setLocation(location);
    }

    public void setTesting(boolean z) {
        if (this.f942 != null) {
            this.f942.setTesting(z);
        }
    }

    @Deprecated
    public void setTimeout(int i) {
    }

    public void setUserDataKeywords(String str) {
        if (this.f942 == null || !MoPub.canCollectPersonalInformation()) {
            return;
        }
        this.f942.setUserDataKeywords(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m834(int i) {
        return this.f942 == null ? Integer.valueOf(i) : this.f942.m669(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public void mo795(MoPubErrorCode moPubErrorCode) {
        if (this.f946 != null) {
            this.f946.onBannerFailed(this, moPubErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public void mo796(String str, Map<String, String> map) {
        if (this.f942 == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
            m836(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (this.f943 != null) {
            m830();
        }
        MoPubLog.d("Loading custom event adapter.");
        if (!Reflection.classFound("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")) {
            MoPubLog.e("Could not load custom event -- missing banner module");
            return;
        }
        try {
            this.f943 = new Reflection.MethodBuilder(null, "create").setStatic(Class.forName("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")).addParam((Class<Class>) MoPubView.class, (Class) this).addParam((Class<Class>) String.class, (Class) str).addParam((Class<Class>) Map.class, (Class) map).addParam((Class<Class>) Long.TYPE, (Class) Long.valueOf(this.f942.getBroadcastIdentifier())).addParam((Class<Class>) AdReport.class, (Class) this.f942.getAdReport()).execute();
            new Reflection.MethodBuilder(this.f943, "loadAd").setAccessible().execute();
        } catch (Exception e) {
            MoPubLog.e("Error loading custom event", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m835() {
        if (this.f942 != null) {
            this.f942.m688();
            m841();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m836(@NonNull MoPubErrorCode moPubErrorCode) {
        if (this.f942 == null) {
            return false;
        }
        return this.f942.m678(moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m837() {
        MoPubLog.d("Tracking impression for native adapter.");
        if (this.f942 != null) {
            this.f942.m687();
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected void m838() {
        MoPubLog.d("adLoaded");
        if (this.f946 != null) {
            this.f946.onBannerLoaded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m839() {
        if (this.f946 != null) {
            this.f946.onBannerExpanded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m840() {
        if (this.f946 != null) {
            this.f946.onBannerCollapsed(this);
        }
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    protected void m841() {
        if (this.f946 != null) {
            this.f946.onBannerClicked(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m842() {
        if (this.f942 != null) {
            this.f942.m679();
        }
        m838();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m843() {
        if (this.f942 != null) {
            this.f942.m682();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢪ  reason: contains not printable characters */
    public void m844() {
        if (this.f942 != null) {
            this.f942.m683();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢫ  reason: contains not printable characters */
    public void m845() {
        if (this.f942 != null) {
            this.f942.m684();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢬ  reason: contains not printable characters */
    public void m846() {
        if (this.f942 != null) {
            this.f942.m685();
        }
    }
}
