package com.integralads.avid.library.mopub.session;
/* loaded from: assets/classes2.dex */
public class ExternalAvidAdSessionContext {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f48;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f49;

    public ExternalAvidAdSessionContext(String str) {
        this(str, false);
    }

    public ExternalAvidAdSessionContext(String str, boolean z) {
        this.f48 = str;
        this.f49 = z;
    }

    public String getPartnerVersion() {
        return this.f48;
    }

    public boolean isDeferred() {
        return this.f49;
    }
}
