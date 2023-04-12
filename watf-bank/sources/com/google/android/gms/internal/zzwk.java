package com.google.android.gms.internal;

import com.google.ads.AdRequest;
/* loaded from: classes.dex */
final /* synthetic */ class zzwk {
    private static /* synthetic */ int[] zzcfz;
    static final /* synthetic */ int[] zzcga = new int[AdRequest.ErrorCode.values().length];

    static {
        try {
            zzcga[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzcga[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzcga[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzcga[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        zzcfz = new int[AdRequest.Gender.values().length];
        try {
            zzcfz[AdRequest.Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zzcfz[AdRequest.Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zzcfz[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
