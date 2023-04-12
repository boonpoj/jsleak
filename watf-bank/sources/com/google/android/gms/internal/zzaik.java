package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaik implements Runnable {
    private /* synthetic */ zzaig zzdbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaik(zzaig zzaigVar) {
        this.zzdbo = zzaigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        String str2;
        zzaim zzer = com.google.android.gms.ads.internal.zzbs.zzer();
        context = this.zzdbo.mContext;
        str = this.zzdbo.zzapq;
        str2 = this.zzdbo.zzavn;
        zzer.zzg(context, str, str2);
    }
}
