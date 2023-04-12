package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbp extends zzby {
    private long zzrc;

    public zzbp(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
        this.zzrc = -1L;
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbk = -1L;
        if (this.zzrc == -1) {
            this.zzrc = ((Integer) this.zzrj.invoke(null, this.zzpC.getContext())).intValue();
        }
        synchronized (this.zzra) {
            this.zzra.zzbk = Long.valueOf(this.zzrc);
        }
    }
}
