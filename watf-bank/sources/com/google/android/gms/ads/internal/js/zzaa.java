package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;
/* loaded from: classes.dex */
public final class zzaa extends zzall<zzaj> {
    private final Object mLock = new Object();
    private final zzae zzcbp;
    private boolean zzcbq;

    public zzaa(zzae zzaeVar) {
        this.zzcbp = zzaeVar;
    }

    public final void release() {
        synchronized (this.mLock) {
            if (this.zzcbq) {
                return;
            }
            this.zzcbq = true;
            zza(new zzab(this), new zzalj());
            zza(new zzac(this), new zzad(this));
        }
    }
}
