package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class zzbr extends zzby {
    private List<Long> zzrd;

    public zzbr(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
        this.zzrd = null;
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbw = -1L;
        this.zzra.zzbx = -1L;
        if (this.zzrd == null) {
            this.zzrd = (List) this.zzrj.invoke(null, this.zzpC.getContext());
        }
        if (this.zzrd == null || this.zzrd.size() != 2) {
            return;
        }
        synchronized (this.zzra) {
            this.zzra.zzbw = Long.valueOf(this.zzrd.get(0).longValue());
            this.zzra.zzbx = Long.valueOf(this.zzrd.get(1).longValue());
        }
    }
}
