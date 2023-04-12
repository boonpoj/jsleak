package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class CustomEventBanner {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean f812 = true;

    /* loaded from: assets/classes2.dex */
    public interface CustomEventBannerListener {
        void onBannerClicked();

        void onBannerCollapsed();

        void onBannerExpanded();

        void onBannerFailed(MoPubErrorCode moPubErrorCode);

        void onBannerImpression();

        void onBannerLoaded(View view);

        void onLeaveApplication();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public abstract void mo698();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public abstract void mo699(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo737() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m738() {
        return this.f812;
    }
}
