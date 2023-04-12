package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zzsd {
    private final Context mContext;
    private final com.google.android.gms.ads.internal.zzv zzanr;
    private final zzux zzanw;
    private final zzakd zzapr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsd(Context context, zzux zzuxVar, zzakd zzakdVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        this.mContext = context;
        this.zzanw = zzuxVar;
        this.zzapr = zzakdVar;
        this.zzanr = zzvVar;
    }

    public final Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public final com.google.android.gms.ads.internal.zzak zzav(String str) {
        return new com.google.android.gms.ads.internal.zzak(this.mContext, new zzjn(), str, this.zzanw, this.zzapr, this.zzanr);
    }

    public final com.google.android.gms.ads.internal.zzak zzaw(String str) {
        return new com.google.android.gms.ads.internal.zzak(this.mContext.getApplicationContext(), new zzjn(), str, this.zzanw, this.zzapr, this.zzanr);
    }

    public final zzsd zzku() {
        return new zzsd(this.mContext.getApplicationContext(), this.zzanw, this.zzapr, this.zzanr);
    }
}
