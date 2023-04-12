package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/classes2.dex */
final class zzbuv {
    final int tag;
    final byte[] zzcsh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbuv(int i, byte[] bArr) {
        this.tag = i;
        this.zzcsh = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbuv) {
            zzbuv zzbuvVar = (zzbuv) obj;
            return this.tag == zzbuvVar.tag && Arrays.equals(this.zzcsh, zzbuvVar.zzcsh);
        }
        return false;
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzcsh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzbum zzbumVar) throws IOException {
        zzbumVar.zzqt(this.tag);
        zzbumVar.zzah(this.zzcsh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzv() {
        return zzbum.zzqu(this.tag) + 0 + this.zzcsh.length;
    }
}
