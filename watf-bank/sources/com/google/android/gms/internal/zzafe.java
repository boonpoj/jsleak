package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
@zzzv
/* loaded from: classes.dex */
public final class zzafe implements zzgt {
    private final Object mLock;
    private String zzapq;
    private final Context zzbhi;
    private boolean zzcww;

    public zzafe(Context context, String str) {
        this.zzbhi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzapq = str;
        this.zzcww = false;
        this.mLock = new Object();
    }

    public final void setAdUnitId(String str) {
        this.zzapq = str;
    }

    @Override // com.google.android.gms.internal.zzgt
    public final void zza(zzgs zzgsVar) {
        zzu(zzgsVar.zzake);
    }

    public final void zzu(boolean z) {
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzq(this.zzbhi)) {
            synchronized (this.mLock) {
                if (this.zzcww == z) {
                    return;
                }
                this.zzcww = z;
                if (TextUtils.isEmpty(this.zzapq)) {
                    return;
                }
                if (this.zzcww) {
                    com.google.android.gms.ads.internal.zzbs.zzfd().zzb(this.zzbhi, this.zzapq);
                } else {
                    com.google.android.gms.ads.internal.zzbs.zzfd().zzc(this.zzbhi, this.zzapq);
                }
            }
        }
    }
}
