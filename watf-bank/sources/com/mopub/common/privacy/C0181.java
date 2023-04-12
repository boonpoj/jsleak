package com.mopub.common.privacy;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
/* renamed from: com.mopub.common.privacy.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0181 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f587;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0181(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.f587 = str;
    }

    @NonNull
    public String getHtml() {
        return this.f587;
    }
}
