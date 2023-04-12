package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
/* loaded from: assets/classes2.dex */
public enum VastErrorCode {
    XML_PARSING_ERROR("100"),
    WRAPPER_TIMEOUT("301"),
    NO_ADS_VAST_RESPONSE("303"),
    GENERAL_LINEAR_AD_ERROR("400"),
    GENERAL_COMPANION_AD_ERROR("600"),
    UNDEFINED_ERROR("900");
    
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f997;

    VastErrorCode(String str) {
        Preconditions.checkNotNull(str, "errorCode cannot be null");
        this.f997 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m873() {
        return this.f997;
    }
}
