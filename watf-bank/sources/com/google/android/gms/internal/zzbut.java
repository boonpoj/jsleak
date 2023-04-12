package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: assets/classes2.dex */
public abstract class zzbut {
    protected volatile int zzcsg = -1;

    public static final <T extends zzbut> T zza(T t, byte[] bArr) throws zzbus {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzbut zzbutVar, byte[] bArr, int i, int i2) {
        try {
            zzbum zzc = zzbum.zzc(bArr, i, i2);
            zzbutVar.zza(zzc);
            zzc.zzacM();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzbut> T zzb(T t, byte[] bArr, int i, int i2) throws zzbus {
        try {
            zzbul zzb = zzbul.zzb(bArr, i, i2);
            t.zzb(zzb);
            zzb.zzqg(0);
            return t;
        } catch (zzbus e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzbut zzbutVar) {
        byte[] bArr = new byte[zzbutVar.zzacZ()];
        zza(zzbutVar, bArr, 0, bArr.length);
        return bArr;
    }

    public String toString() {
        return zzbuu.zzg(this);
    }

    public void zza(zzbum zzbumVar) throws IOException {
    }

    @Override // 
    /* renamed from: zzacO */
    public zzbut clone() throws CloneNotSupportedException {
        return (zzbut) super.clone();
    }

    public int zzacY() {
        if (this.zzcsg < 0) {
            zzacZ();
        }
        return this.zzcsg;
    }

    public int zzacZ() {
        int zzv = zzv();
        this.zzcsg = zzv;
        return zzv;
    }

    public abstract zzbut zzb(zzbul zzbulVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzv() {
        return 0;
    }
}
