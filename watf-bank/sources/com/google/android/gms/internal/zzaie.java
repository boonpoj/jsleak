package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzaie {
    private boolean zzcob = false;
    private float zzcnv = 1.0f;

    private final synchronized boolean zzql() {
        return this.zzcnv >= 0.0f;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzcob = z;
    }

    public final synchronized void setAppVolume(float f) {
        this.zzcnv = f;
    }

    public final synchronized float zzdn() {
        if (zzql()) {
            return this.zzcnv;
        }
        return 1.0f;
    }

    public final synchronized boolean zzdo() {
        return this.zzcob;
    }
}
