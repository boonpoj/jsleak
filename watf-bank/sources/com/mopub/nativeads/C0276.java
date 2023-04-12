package com.mopub.nativeads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;
/* renamed from: com.mopub.nativeads.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0276 implements PositioningSource {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Handler f1897 = new Handler();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final MoPubNativeAdPositioning.MoPubClientPositioning f1898;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0276(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this.f1898 = MoPubNativeAdPositioning.m1405(moPubClientPositioning);
    }

    @Override // com.mopub.nativeads.PositioningSource
    public void loadPositions(@NonNull String str, @NonNull final PositioningSource.PositioningListener positioningListener) {
        this.f1897.post(new Runnable() { // from class: com.mopub.nativeads.ࢠ.1
            @Override // java.lang.Runnable
            public void run() {
                positioningListener.onLoad(C0276.this.f1898);
            }
        });
    }
}
