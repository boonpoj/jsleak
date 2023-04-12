package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzxz extends Exception {
    private final int mErrorCode;

    public zzxz(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
