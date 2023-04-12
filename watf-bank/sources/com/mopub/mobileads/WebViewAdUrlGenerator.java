package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.ExternalViewabilitySessionManager;
/* loaded from: assets/classes2.dex */
public class WebViewAdUrlGenerator extends AdUrlGenerator {

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final boolean f1166;

    public WebViewAdUrlGenerator(Context context, boolean z) {
        super(context);
        this.f1166 = z;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(String str) {
        m363(str, Constants.AD_HANDLER);
        m359("6");
        m335(ClientMetadata.getInstance(this.f261));
        m337(true);
        m366(this.f1166);
        m353(ExternalViewabilitySessionManager.ViewabilityVendor.getEnabledVendorKey());
        return m367();
    }
}
