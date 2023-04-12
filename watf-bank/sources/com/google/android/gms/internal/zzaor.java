package com.google.android.gms.internal;

import android.view.View;
import android.webkit.WebChromeClient;
@zzzv
/* loaded from: classes.dex */
public final class zzaor extends zzaoi {
    public zzaor(zzanh zzanhVar) {
        super(zzanhVar);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
