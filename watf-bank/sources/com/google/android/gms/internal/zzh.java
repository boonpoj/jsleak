package com.google.android.gms.internal;

import com.mopub.volley.DefaultRetryPolicy;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzh implements zzaa {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzh() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    private zzh(int i, int i2, float f) {
        this.zzr = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        this.zzt = 1;
        this.zzu = 1.0f;
    }

    @Override // com.google.android.gms.internal.zzaa
    public final void zza(zzad zzadVar) throws zzad {
        this.zzs++;
        int i = this.zzr;
        this.zzr = (int) (i + (i * this.zzu));
        if (!(this.zzs <= this.zzt)) {
            throw zzadVar;
        }
    }

    @Override // com.google.android.gms.internal.zzaa
    public final int zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.zzaa
    public final int zzc() {
        return this.zzs;
    }
}
