package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbh extends zzby {
    private static volatile String zzqV;
    private static final Object zzqW = new Object();

    public zzbh(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbv = "E";
        if (zzqV == null) {
            synchronized (zzqW) {
                if (zzqV == null) {
                    zzqV = (String) this.zzrj.invoke(null, this.zzpC.getContext());
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzbv = zzal.zza(zzqV.getBytes(), true);
        }
    }
}
