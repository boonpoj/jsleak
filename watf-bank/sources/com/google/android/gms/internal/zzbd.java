package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzbd extends zzfjm<zzbd> {
    public byte[] data = null;
    public byte[] zzgl = null;
    public byte[] zzgm = null;
    public byte[] zzgn = null;

    public zzbd() {
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 10) {
                this.data = zzfjjVar.readBytes();
            } else if (zzcvt == 18) {
                this.zzgl = zzfjjVar.readBytes();
            } else if (zzcvt == 26) {
                this.zzgm = zzfjjVar.readBytes();
            } else if (zzcvt == 34) {
                this.zzgn = zzfjjVar.readBytes();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        byte[] bArr = this.data;
        if (bArr != null) {
            zzfjkVar.zzc(1, bArr);
        }
        byte[] bArr2 = this.zzgl;
        if (bArr2 != null) {
            zzfjkVar.zzc(2, bArr2);
        }
        byte[] bArr3 = this.zzgm;
        if (bArr3 != null) {
            zzfjkVar.zzc(3, bArr3);
        }
        byte[] bArr4 = this.zzgn;
        if (bArr4 != null) {
            zzfjkVar.zzc(4, bArr4);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        byte[] bArr = this.data;
        if (bArr != null) {
            zzq += zzfjk.zzd(1, bArr);
        }
        byte[] bArr2 = this.zzgl;
        if (bArr2 != null) {
            zzq += zzfjk.zzd(2, bArr2);
        }
        byte[] bArr3 = this.zzgm;
        if (bArr3 != null) {
            zzq += zzfjk.zzd(3, bArr3);
        }
        byte[] bArr4 = this.zzgn;
        return bArr4 != null ? zzq + zzfjk.zzd(4, bArr4) : zzq;
    }
}
