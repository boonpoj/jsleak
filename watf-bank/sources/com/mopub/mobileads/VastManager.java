package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.mobileads.VastXmlManagerAggregator;
import com.mopub.mobileads.VideoDownloader;
/* loaded from: assets/classes2.dex */
public class VastManager implements VastXmlManagerAggregator.InterfaceC0212 {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private VastManagerListener f1005;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private VastXmlManagerAggregator f1006;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1007;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private double f1008;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f1009;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final boolean f1010;

    /* loaded from: assets/classes2.dex */
    public interface VastManagerListener {
        void onVastVideoConfigurationPrepared(@Nullable VastVideoConfig vastVideoConfig);
    }

    public VastManager(@NonNull Context context, boolean z) {
        m890(context);
        this.f1010 = z;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m890(@NonNull Context context) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        float f = context.getResources().getDisplayMetrics().density;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        int max = Math.max(width, height);
        int min = Math.min(width, height);
        double d = max;
        double d2 = min;
        Double.isNaN(d);
        Double.isNaN(d2);
        this.f1008 = d / d2;
        this.f1009 = (int) ((max / f) * (min / f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m892(@NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        String networkMediaFileUrl = vastVideoConfig.getNetworkMediaFileUrl();
        if (CacheService.containsKeyDiskCache(networkMediaFileUrl)) {
            vastVideoConfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(networkMediaFileUrl));
            return true;
        }
        return false;
    }

    public void cancel() {
        if (this.f1006 != null) {
            this.f1006.cancel(true);
            this.f1006 = null;
        }
    }

    @Override // com.mopub.mobileads.VastXmlManagerAggregator.InterfaceC0212
    public void onAggregationComplete(@Nullable final VastVideoConfig vastVideoConfig) {
        if (this.f1005 == null) {
            throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
        }
        if (vastVideoConfig == null) {
            this.f1005.onVastVideoConfigurationPrepared(null);
            return;
        }
        if (!TextUtils.isEmpty(this.f1007)) {
            vastVideoConfig.setDspCreativeId(this.f1007);
        }
        if (!this.f1010 || m892(vastVideoConfig)) {
            this.f1005.onVastVideoConfigurationPrepared(vastVideoConfig);
            return;
        }
        VideoDownloader.cache(vastVideoConfig.getNetworkMediaFileUrl(), new VideoDownloader.InterfaceC0213() { // from class: com.mopub.mobileads.VastManager.1
            @Override // com.mopub.mobileads.VideoDownloader.InterfaceC0213
            public void onComplete(boolean z) {
                VastManagerListener vastManagerListener;
                VastVideoConfig vastVideoConfig2;
                if (z && VastManager.this.m892(vastVideoConfig)) {
                    vastManagerListener = VastManager.this.f1005;
                    vastVideoConfig2 = vastVideoConfig;
                } else {
                    MoPubLog.d("Failed to download VAST video.");
                    vastManagerListener = VastManager.this.f1005;
                    vastVideoConfig2 = null;
                }
                vastManagerListener.onVastVideoConfigurationPrepared(vastVideoConfig2);
            }
        });
    }

    public void prepareVastVideoConfiguration(@Nullable String str, @NonNull VastManagerListener vastManagerListener, @Nullable String str2, @NonNull Context context) {
        Preconditions.checkNotNull(vastManagerListener, "vastManagerListener cannot be null");
        Preconditions.checkNotNull(context, "context cannot be null");
        if (this.f1006 == null) {
            this.f1005 = vastManagerListener;
            this.f1006 = new VastXmlManagerAggregator(this, this.f1008, this.f1009, context.getApplicationContext());
            this.f1007 = str2;
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f1006, str);
            } catch (Exception e) {
                MoPubLog.d("Failed to aggregate vast xml", e);
                this.f1005.onVastVideoConfigurationPrepared(null);
            }
        }
    }
}
