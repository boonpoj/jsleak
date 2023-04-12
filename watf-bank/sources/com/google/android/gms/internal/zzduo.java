package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzduo {
    private final zzdve zzlza;
    private final zzdve zzlzb;

    public zzduo(byte[] bArr, byte[] bArr2) {
        this.zzlza = zzdve.zzal(bArr);
        this.zzlzb = zzdve.zzal(bArr2);
    }

    public final byte[] zzbqk() {
        zzdve zzdveVar = this.zzlza;
        if (zzdveVar == null) {
            return null;
        }
        return zzdveVar.getBytes();
    }

    public final byte[] zzbql() {
        zzdve zzdveVar = this.zzlzb;
        if (zzdveVar == null) {
            return null;
        }
        return zzdveVar.getBytes();
    }
}
