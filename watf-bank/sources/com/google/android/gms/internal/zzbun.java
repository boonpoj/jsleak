package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbun;
import java.io.IOException;
/* loaded from: assets/classes2.dex */
public abstract class zzbun<M extends zzbun<M>> extends zzbut {
    protected zzbup zzcrX;

    public final <T> T zza(zzbuo<M, T> zzbuoVar) {
        zzbuq zzqx;
        if (this.zzcrX == null || (zzqx = this.zzcrX.zzqx(zzbuw.zzqB(zzbuoVar.tag))) == null) {
            return null;
        }
        return (T) zzqx.zzb(zzbuoVar);
    }

    @Override // com.google.android.gms.internal.zzbut
    public void zza(zzbum zzbumVar) throws IOException {
        if (this.zzcrX == null) {
            return;
        }
        for (int i = 0; i < this.zzcrX.size(); i++) {
            this.zzcrX.zzqy(i).zza(zzbumVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(zzbul zzbulVar, int i) throws IOException {
        int position = zzbulVar.getPosition();
        if (zzbulVar.zzqh(i)) {
            int zzqB = zzbuw.zzqB(i);
            zzbuv zzbuvVar = new zzbuv(i, zzbulVar.zzE(position, zzbulVar.getPosition() - position));
            zzbuq zzbuqVar = null;
            if (this.zzcrX == null) {
                this.zzcrX = new zzbup();
            } else {
                zzbuqVar = this.zzcrX.zzqx(zzqB);
            }
            if (zzbuqVar == null) {
                zzbuqVar = new zzbuq();
                this.zzcrX.zza(zzqB, zzbuqVar);
            }
            zzbuqVar.zza(zzbuvVar);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzbut
    /* renamed from: zzacN */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzbur.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzbut
    public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
        return (zzbun) clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbut
    public int zzv() {
        if (this.zzcrX != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzcrX.size(); i2++) {
                i += this.zzcrX.zzqy(i2).zzv();
            }
            return i;
        }
        return 0;
    }
}
