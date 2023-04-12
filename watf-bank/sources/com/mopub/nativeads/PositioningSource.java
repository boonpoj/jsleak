package com.mopub.nativeads;

import android.support.annotation.NonNull;
import com.mopub.nativeads.MoPubNativeAdPositioning;
/* loaded from: assets/classes2.dex */
interface PositioningSource {

    /* loaded from: assets/classes2.dex */
    public interface PositioningListener {
        void onFailed();

        void onLoad(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning);
    }

    void loadPositions(@NonNull String str, @NonNull PositioningListener positioningListener);
}
