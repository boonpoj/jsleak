package com.google.android.gms.internal;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;
@zzzv
/* loaded from: classes.dex */
public final class zzami {
    private long zzdhn;
    private final long zzdhm = TimeUnit.MILLISECONDS.toNanos(((Long) zzkb.zzif().zzd(zznh.zzbio)).longValue());
    private boolean zzdho = true;

    public final void zza(SurfaceTexture surfaceTexture, zzama zzamaVar) {
        if (zzamaVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzdho || Math.abs(timestamp - this.zzdhn) >= this.zzdhm) {
            this.zzdho = false;
            this.zzdhn = timestamp;
            zzahn.zzdaw.post(new zzamj(this, zzamaVar));
        }
    }

    public final void zzrp() {
        this.zzdho = true;
    }
}
