package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbq extends zzby {
    private static volatile String zzba;
    private static final Object zzqW = new Object();

    public zzbq(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzba = "E";
        if (zzba == null) {
            synchronized (zzqW) {
                if (zzba == null) {
                    zzba = (String) this.zzrj.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzba = zzba;
        }
    }
}
