package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzuc implements zzali {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzaa zzcck;
    private /* synthetic */ zzalf zzccm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuc(zzua zzuaVar, zzalf zzalfVar, com.google.android.gms.ads.internal.js.zzaa zzaaVar) {
        this.zzccm = zzalfVar;
        this.zzcck = zzaaVar;
    }

    @Override // com.google.android.gms.internal.zzali
    public final void run() {
        this.zzccm.setException(new zzto("Unable to obtain a JavascriptEngine."));
        this.zzcck.release();
    }
}
