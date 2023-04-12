package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public class zzyc extends zzxu implements zzanm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyc(Context context, zzafp zzafpVar, zzanh zzanhVar, zzyb zzybVar) {
        super(context, zzafpVar, zzanhVar, zzybVar);
    }

    @Override // com.google.android.gms.internal.zzxu
    protected final void zznc() {
        if (this.zzcjl.errorCode != -2) {
            return;
        }
        this.zzbyk.zzsz().zza(this);
        zzne();
        zzagf.zzbx("Loading HTML in WebView.");
        this.zzbyk.loadDataWithBaseURL(this.zzcjl.zzcja, this.zzcjl.body, "text/html", "UTF-8", null);
    }

    protected void zzne() {
    }
}
