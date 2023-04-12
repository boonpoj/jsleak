package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
/* loaded from: classes.dex */
public final class zzdul implements zzdpv {
    private static final byte[] zzltb = new byte[0];
    private final String zzlyu;
    private final byte[] zzlyv;
    private final zzdus zzlyw;
    private final zzduj zzlyx;
    private final zzdun zzlyy;

    public zzdul(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdus zzdusVar, zzduj zzdujVar) throws GeneralSecurityException {
        zzdup.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzlyy = new zzdun(eCPublicKey);
        this.zzlyv = bArr;
        this.zzlyu = str;
        this.zzlyw = zzdusVar;
        this.zzlyx = zzdujVar;
    }

    @Override // com.google.android.gms.internal.zzdpv
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzduo zza = this.zzlyy.zza(this.zzlyu, this.zzlyv, bArr2, this.zzlyx.zzbma(), this.zzlyw);
        byte[] zzd = this.zzlyx.zzae(zza.zzbql()).zzd(bArr, zzltb);
        byte[] zzbqk = zza.zzbqk();
        return ByteBuffer.allocate(zzbqk.length + zzd.length).put(zzbqk).put(zzd).array();
    }
}
