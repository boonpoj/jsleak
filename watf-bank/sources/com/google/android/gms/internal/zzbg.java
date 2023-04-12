package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbg extends zzby {
    public zzbg(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzra) {
            this.zzra.zzbb = -1L;
            this.zzra.zzbb = (Long) this.zzrj.invoke(null, this.zzpC.getContext());
        }
    }
}
