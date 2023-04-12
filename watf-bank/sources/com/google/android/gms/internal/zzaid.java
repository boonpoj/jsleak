package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.CookieManager;
/* loaded from: classes.dex */
public final class zzaid extends zzaic {
    @Override // com.google.android.gms.internal.zzaht
    public final CookieManager zzay(Context context) {
        if (zzqj()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzagf.zzb("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzahw, com.google.android.gms.internal.zzaht
    public final zzani zzb(zzanh zzanhVar, boolean z) {
        return new zzaot(zzanhVar, z);
    }

    @Override // com.google.android.gms.internal.zzahy, com.google.android.gms.internal.zzaht
    public final int zzqk() {
        return 16974374;
    }
}
