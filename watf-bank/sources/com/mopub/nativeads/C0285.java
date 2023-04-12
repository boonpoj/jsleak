package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
/* renamed from: com.mopub.nativeads.ࢨ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0285 extends BaseUrlGenerator {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f1942;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f1943;

    public C0285(@NonNull Context context) {
        this.f1942 = context;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1541(@NonNull String str) {
        m365("id", str);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1542(@NonNull String str) {
        m365("nv", str);
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(@NonNull String str) {
        m363(str, Constants.POSITIONING_HANDLER);
        m1541(this.f1943);
        m359("1");
        ClientMetadata clientMetadata = ClientMetadata.getInstance(this.f1942);
        m1542(clientMetadata.getSdkVersion());
        m364(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        m360(clientMetadata.getAppVersion());
        m368();
        return m367();
    }

    @NonNull
    public C0285 withAdUnitId(@NonNull String str) {
        this.f1943 = str;
        return this;
    }
}
