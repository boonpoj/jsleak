package com.google.android.gms.ads.internal.js;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaiq;
import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;
/* loaded from: classes.dex */
public final class zzae extends zzall<zzc> {
    private zzaiq<zzc> zzcba;
    private final Object mLock = new Object();
    private boolean zzcbs = false;
    private int zzcbt = 0;

    public zzae(zzaiq<zzc> zzaiqVar) {
        this.zzcba = zzaiqVar;
    }

    private final void zzls() {
        synchronized (this.mLock) {
            zzbq.checkState(this.zzcbt >= 0);
            if (this.zzcbs && this.zzcbt == 0) {
                zzagf.v("No reference is left (including root). Cleaning up engine.");
                zza(new zzah(this), new zzalj());
            } else {
                zzagf.v("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzaa zzlp() {
        zzaa zzaaVar = new zzaa(this);
        synchronized (this.mLock) {
            zza(new zzaf(this, zzaaVar), new zzag(this, zzaaVar));
            zzbq.checkState(this.zzcbt >= 0);
            this.zzcbt++;
        }
        return zzaaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzlq() {
        synchronized (this.mLock) {
            zzbq.checkState(this.zzcbt > 0);
            zzagf.v("Releasing 1 reference for JS Engine");
            this.zzcbt--;
            zzls();
        }
    }

    public final void zzlr() {
        synchronized (this.mLock) {
            zzbq.checkState(this.zzcbt >= 0);
            zzagf.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzcbs = true;
            zzls();
        }
    }
}
