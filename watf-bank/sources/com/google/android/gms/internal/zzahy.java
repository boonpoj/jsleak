package com.google.android.gms.internal;

import android.net.http.SslError;
import android.webkit.WebChromeClient;
/* loaded from: classes.dex */
public class zzahy extends zzahw {
    @Override // com.google.android.gms.internal.zzaht
    public final String zza(SslError sslError) {
        return sslError.getUrl();
    }

    @Override // com.google.android.gms.internal.zzahw, com.google.android.gms.internal.zzaht
    public final WebChromeClient zzk(zzanh zzanhVar) {
        return new zzaor(zzanhVar);
    }

    @Override // com.google.android.gms.internal.zzaht
    public int zzqk() {
        return 1;
    }
}
