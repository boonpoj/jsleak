package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
/* loaded from: classes.dex */
public final class zzduk implements zzdpu {
    private static final byte[] zzltb = new byte[0];
    private final ECPrivateKey zzlys;
    private final zzdum zzlyt;
    private final String zzlyu;
    private final byte[] zzlyv;
    private final zzdus zzlyw;
    private final zzduj zzlyx;

    public zzduk(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdus zzdusVar, zzduj zzdujVar) throws GeneralSecurityException {
        this.zzlys = eCPrivateKey;
        this.zzlyt = new zzdum(eCPrivateKey);
        this.zzlyv = bArr;
        this.zzlyu = str;
        this.zzlyw = zzdusVar;
        this.zzlyx = zzdujVar;
    }
}
