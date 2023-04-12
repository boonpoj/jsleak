package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
final class zzffi implements zzfji {
    private final zzffg zzpfl;

    private zzffi(zzffg zzffgVar) {
        this.zzpfl = (zzffg) zzffz.zzc(zzffgVar, "output");
        this.zzpfl.zzpga = this;
    }

    public static zzffi zzb(zzffg zzffgVar) {
        return zzffgVar.zzpga != null ? zzffgVar.zzpga : new zzffi(zzffgVar);
    }

    @Override // com.google.android.gms.internal.zzfji
    public final void zzb(int i, Object obj) {
        try {
            if (obj instanceof zzfes) {
                this.zzpfl.zzb(i, (zzfes) obj);
            } else {
                this.zzpfl.zzb(i, (zzfhe) obj);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.zzfji
    public final int zzcwv() {
        return zzffu.zzg.zzphn;
    }
}
