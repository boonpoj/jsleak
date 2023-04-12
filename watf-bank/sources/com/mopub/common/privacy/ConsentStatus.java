package com.mopub.common.privacy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.EnvironmentCompat;
/* loaded from: assets/classes2.dex */
public enum ConsentStatus {
    EXPLICIT_YES("explicit_yes"),
    EXPLICIT_NO("explicit_no"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    POTENTIAL_WHITELIST("potential_whitelist"),
    DNT("dnt");
    
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f503;

    ConsentStatus(String str) {
        this.f503 = str;
    }

    @NonNull
    public static ConsentStatus fromString(@Nullable String str) {
        ConsentStatus[] values;
        if (str == null) {
            return UNKNOWN;
        }
        for (ConsentStatus consentStatus : values()) {
            if (str.equals(consentStatus.name())) {
                return consentStatus;
            }
        }
        return UNKNOWN;
    }

    @NonNull
    public String getValue() {
        return this.f503;
    }
}
