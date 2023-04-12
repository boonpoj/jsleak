package com.google.android.gms.internal;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzaf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
/* loaded from: assets/classes2.dex */
public class zzbi extends zzby {
    private static final Object zzqW = new Object();
    private static volatile zzam zzqX;
    private boolean zzqY;
    private zzad.zza zzqZ;

    public zzbi(zzbc zzbcVar, String str, String str2, zzaf.zza zzaVar, int i, int i2, boolean z, zzad.zza zzaVar2) {
        super(zzbcVar, str, str2, zzaVar, i, i2);
        this.zzqY = false;
        this.zzqZ = null;
        this.zzqY = z;
        this.zzqZ = zzaVar2;
    }

    public static Boolean zza(zzad.zza zzaVar) {
        boolean z = false;
        if (zzbe.zzs(zzb(zzaVar))) {
            if (zzaVar != null && zzaVar.zzaJ != null && zzaVar.zzaJ.zzaL.intValue() == 3) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return false;
    }

    public static String zzb(zzad.zza zzaVar) {
        if (zzaVar == null || zzaVar.zzaK == null || zzbe.zzs(zzaVar.zzaK.zzaM)) {
            return null;
        }
        return zzaVar.zzaK.zzaM;
    }

    private boolean zzbf() {
        return zzqX == null || zzbe.zzs(zzqX.zzaM) || zzqX.zzaM.equals("E");
    }

    private int zzbg() {
        if (zzbe.zzs(zzb(this.zzqZ))) {
            return (zza(this.zzqZ).booleanValue() && zzbh()) ? 3 : 2;
        }
        return 4;
    }

    private boolean zzbh() {
        return this.zzpC.zzaR() && ((Boolean) zzfx.zzDF.get()).booleanValue() && ((Boolean) zzfx.zzDG.get()).booleanValue() && ((Boolean) zzfx.zzDD.get()).booleanValue();
    }

    private String zzbi() {
        try {
            if (this.zzpC.zzaT() != null) {
                this.zzpC.zzaT().get();
            }
            zzaf.zza zzaS = this.zzpC.zzaS();
            if (zzaS == null || zzaS.zzaM == null) {
                return null;
            }
            return zzaS.zzaM;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private void zze(int i) throws IllegalAccessException, InvocationTargetException {
        Method method = this.zzrj;
        Object[] objArr = new Object[3];
        objArr[0] = this.zzpC.getContext();
        objArr[1] = Boolean.valueOf(this.zzqY);
        objArr[2] = Boolean.valueOf(i == 2);
        zzqX = new zzam((String) method.invoke(null, objArr));
        if (zzbe.zzs(zzqX.zzaM) || zzqX.zzaM.equals("E")) {
            switch (i) {
                case 3:
                    String zzbi = zzbi();
                    if (zzbe.zzs(zzbi)) {
                        return;
                    }
                    zzqX.zzaM = zzbi;
                    return;
                case 4:
                    zzqX.zzaM = this.zzqZ.zzaK.zzaM;
                    return;
                default:
                    return;
            }
        }
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzbf()) {
            synchronized (zzqW) {
                int zzbg = zzbg();
                if (zzbg == 3) {
                    this.zzpC.zzaW();
                }
                zze(zzbg);
            }
        }
        synchronized (this.zzra) {
            if (zzqX != null) {
                this.zzra.zzaM = zzqX.zzaM;
                this.zzra.zzbz = Long.valueOf(zzqX.zzlH);
                this.zzra.zzaO = zzqX.zzaO;
                if (this.zzqY) {
                    this.zzra.zzaP = zzqX.zzaP;
                    this.zzra.zzaQ = zzqX.zzaQ;
                }
            }
        }
    }
}
