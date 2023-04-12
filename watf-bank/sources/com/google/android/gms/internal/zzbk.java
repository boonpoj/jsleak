package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbk extends zzby {
    private static volatile Long zzbH;
    private static final Object zzqW = new Object();

    public zzbk(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzbH == null) {
            synchronized (zzqW) {
                if (zzbH == null) {
                    zzbH = (Long) this.zzrj.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzbH = zzbH;
        }
    }
}
