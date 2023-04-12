package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzdqd<P> {
    private final P zzlst;
    private final byte[] zzlsu;
    private final zzdtb zzlsv;
    private final zzdtt zzlsw;

    public zzdqd(P p, byte[] bArr, zzdtb zzdtbVar, zzdtt zzdttVar) {
        this.zzlst = p;
        this.zzlsu = Arrays.copyOf(bArr, bArr.length);
        this.zzlsv = zzdtbVar;
        this.zzlsw = zzdttVar;
    }

    public final P zzblw() {
        return this.zzlst;
    }

    public final byte[] zzblx() {
        byte[] bArr = this.zzlsu;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
