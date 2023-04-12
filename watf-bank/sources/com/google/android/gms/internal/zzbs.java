package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbs extends zzby {
    private final StackTraceElement[] zzre;

    public zzbs(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
        this.zzre = stackTraceElementArr;
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (this.zzre != null) {
            zzba zzbaVar = new zzba((String) this.zzrj.invoke(null, this.zzre));
            synchronized (this.zzra) {
                this.zzra.zzbI = zzbaVar.zzqm;
                if (zzbaVar.zzqn.booleanValue()) {
                    this.zzra.zzbQ = Integer.valueOf(!zzbaVar.zzqo.booleanValue());
                }
            }
        }
    }
}
