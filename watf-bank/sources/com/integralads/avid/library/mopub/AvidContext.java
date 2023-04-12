package com.integralads.avid.library.mopub;

import android.content.Context;
/* loaded from: assets/classes2.dex */
public class AvidContext {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final AvidContext f1 = new AvidContext();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f2;

    public static AvidContext getInstance() {
        return f1;
    }

    public String getAvidReleaseDate() {
        return BuildConfig.RELEASE_DATE;
    }

    public String getAvidVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getBundleId() {
        return this.f2;
    }

    public String getPartnerName() {
        return BuildConfig.SDK_NAME;
    }

    public void init(Context context) {
        if (this.f2 == null) {
            this.f2 = context.getApplicationContext().getPackageName();
        }
    }
}
