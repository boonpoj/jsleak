package com.integralads.avid.library.mopub.session.internal;
/* loaded from: assets/classes2.dex */
public enum SessionType {
    DISPLAY("display"),
    VIDEO("video"),
    MANAGED_DISPLAY("managedDisplay"),
    MANAGED_VIDEO("managedVideo");
    

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f73;

    SessionType(String str) {
        this.f73 = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f73;
    }
}
