package com.mopub.common.privacy;

import android.support.annotation.NonNull;
import com.mopub.mobileads.MoPubErrorCode;
/* loaded from: assets/classes2.dex */
public interface ConsentDialogListener {
    void onConsentDialogLoadFailed(@NonNull MoPubErrorCode moPubErrorCode);

    void onConsentDialogLoaded();
}
