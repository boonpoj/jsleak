package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzaed {
    private int mErrorCode;
    private String zzced;
    private String zzcvq;
    private long zzcvr;

    public final zzaed zzab(int i) {
        this.mErrorCode = i;
        return this;
    }

    public final zzaed zzbs(String str) {
        this.zzced = str;
        return this;
    }

    public final zzaed zzbt(String str) {
        this.zzcvq = str;
        return this;
    }

    public final zzaed zzg(long j) {
        this.zzcvr = j;
        return this;
    }

    public final zzaeb zzog() {
        return new zzaeb(this);
    }
}
