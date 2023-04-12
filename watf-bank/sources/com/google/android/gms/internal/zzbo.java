package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbo extends zzby {
    private static final Object zzqW = new Object();
    private static volatile Long zzrb;

    public zzbo(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzrb == null) {
            synchronized (zzqW) {
                if (zzrb == null) {
                    zzrb = (Long) this.zzrj.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzbt = zzrb;
        }
    }
}
