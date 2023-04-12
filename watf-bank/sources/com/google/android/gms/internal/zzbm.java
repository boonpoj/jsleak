package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.zzaf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: assets/classes2.dex */
public class zzbm extends zzby {
    public zzbm(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
    }

    private void zzbj() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzra) {
            this.zzra.zzbV = (String) this.zzrj.invoke(null, this.zzpC.getApplicationContext());
        }
    }

    private void zzbk() {
        AdvertisingIdClient zzaZ = this.zzpC.zzaZ();
        if (zzaZ == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzaZ.getInfo();
            String zzr = zzbe.zzr(info.getId());
            if (zzr != null) {
                synchronized (this.zzra) {
                    this.zzra.zzbV = zzr;
                    this.zzra.zzbX = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.zzra.zzbW = 5;
                }
            }
        } catch (IOException unused) {
        }
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (this.zzpC.zzaO()) {
            zzbk();
        } else {
            zzbj();
        }
    }
}
