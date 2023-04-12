package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzajt extends Thread {
    private /* synthetic */ String zzcml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajt(zzajs zzajsVar, String str) {
        this.zzcml = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzakc().zzck(this.zzcml);
    }
}
