package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
final class zzfju {
    final int tag;
    final byte[] zzjng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfju(int i, byte[] bArr) {
        this.tag = i;
        this.zzjng = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfju) {
            zzfju zzfjuVar = (zzfju) obj;
            return this.tag == zzfjuVar.tag && Arrays.equals(this.zzjng, zzfjuVar.zzjng);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzjng);
    }
}
