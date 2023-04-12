package com.mopub.mobileads;

import android.support.annotation.Nullable;
/* loaded from: assets/classes2.dex */
public abstract class CustomEventRewardedVideo extends CustomEventRewardedAd {

    @Deprecated
    /* loaded from: assets/classes2.dex */
    protected interface CustomEventRewardedVideoListener {
    }

    @Nullable
    @Deprecated
    protected CustomEventRewardedVideoListener getVideoListenerForSdk() {
        return null;
    }

    @Deprecated
    protected abstract boolean hasVideoAvailable();

    @Deprecated
    protected abstract void showVideo();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢣ */
    public boolean mo756() {
        return hasVideoAvailable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢤ */
    public void mo757() {
        showVideo();
    }
}
