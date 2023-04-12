package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class zzdvg implements zzdqa {
    private Mac zzlzz;
    private final int zzmaa;
    private final String zzmab;
    private final Key zzmac;

    public zzdvg(String str, Key key, int i) throws GeneralSecurityException {
        this.zzmab = str;
        this.zzmaa = i;
        this.zzmac = key;
        this.zzlzz = zzduu.zzlzq.zzos(str);
        this.zzlzz.init(key);
    }

    @Override // com.google.android.gms.internal.zzdqa
    public final byte[] zzac(byte[] bArr) throws GeneralSecurityException {
        Mac zzos;
        try {
            zzos = (Mac) this.zzlzz.clone();
        } catch (CloneNotSupportedException e) {
            zzos = zzduu.zzlzq.zzos(this.zzmab);
            zzos.init(this.zzmac);
        }
        zzos.update(bArr);
        byte[] bArr2 = new byte[this.zzmaa];
        System.arraycopy(zzos.doFinal(), 0, bArr2, 0, this.zzmaa);
        return bArr2;
    }
}
