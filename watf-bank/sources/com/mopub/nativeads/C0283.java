package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
/* renamed from: com.mopub.nativeads.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0283 extends AdUrlGenerator {
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f1933;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f1934;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0283(Context context) {
        super(context);
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m1517() {
        if (TextUtils.isEmpty(this.f1934)) {
            return;
        }
        m365("MAGIC_NO", this.f1934);
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m1518() {
        if (TextUtils.isEmpty(this.f1933)) {
            return;
        }
        m365("assets", this.f1933);
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(String str) {
        m363(str, Constants.AD_HANDLER);
        m335(ClientMetadata.getInstance(this.f261));
        m1518();
        m1517();
        return m367();
    }

    @Override // com.mopub.common.AdUrlGenerator
    @NonNull
    public C0283 withAdUnitId(String str) {
        this.f262 = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public C0283 m1519(int i) {
        this.f1934 = String.valueOf(i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public C0283 m1520(@Nullable RequestParameters requestParameters) {
        if (requestParameters != null) {
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            this.f264 = canCollectPersonalInformation ? requestParameters.getUserDataKeywords() : null;
            this.f265 = canCollectPersonalInformation ? requestParameters.getLocation() : null;
            this.f263 = requestParameters.getKeywords();
            this.f1933 = requestParameters.getDesiredAssets();
        }
        return this;
    }
}
