package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbj extends zzby {
    public zzbj(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbd = -1L;
        this.zzra.zzbe = -1L;
        int[] iArr = (int[]) this.zzrj.invoke(null, this.zzpC.getContext());
        synchronized (this.zzra) {
            this.zzra.zzbd = Long.valueOf(iArr[0]);
            this.zzra.zzbe = Long.valueOf(iArr[1]);
        }
    }
}
