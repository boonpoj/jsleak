package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzail implements Runnable {
    private /* synthetic */ zzaig zzdbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzail(zzaig zzaigVar) {
        this.zzdbo = zzaigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        String str2;
        String str3;
        zzaim zzer = com.google.android.gms.ads.internal.zzbs.zzer();
        context = this.zzdbo.mContext;
        str = this.zzdbo.zzapq;
        str2 = this.zzdbo.zzavn;
        str3 = this.zzdbo.zzcsd;
        zzer.zza(context, str, str2, str3);
    }
}
