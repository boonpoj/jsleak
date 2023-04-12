package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.util.concurrent.Callable;
/* loaded from: assets/classes2.dex */
public class zzbn implements Callable {
    private final zzbc zzpC;
    private final zzaf.zza zzra;

    public zzbn(zzbc zzbcVar, zzaf.zza zzaVar) {
        this.zzpC = zzbcVar;
        this.zzra = zzaVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: zzbl */
    public Void call() throws Exception {
        if (this.zzpC.zzaT() != null) {
            this.zzpC.zzaT().get();
        }
        zzaf.zza zzaS = this.zzpC.zzaS();
        if (zzaS != null) {
            try {
                synchronized (this.zzra) {
                    zzbut.zza(this.zzra, zzbut.zzf(zzaS));
                }
                return null;
            } catch (zzbus unused) {
                return null;
            }
        }
        return null;
    }
}
