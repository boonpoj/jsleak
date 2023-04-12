package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class CustomEventNative {

    /* loaded from: assets/classes2.dex */
    public interface CustomEventNativeListener {
        void onNativeAdFailed(NativeErrorCode nativeErrorCode);

        void onNativeAdLoaded(BaseNativeAd baseNativeAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo1302() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public abstract void mo1268(@NonNull Context context, @NonNull CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);
}
