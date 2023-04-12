package com.google.android.gms.internal;
/* loaded from: classes.dex */
public class zzfgk {
    private static final zzffm zzpfe = zzffm.zzcxb();
    private zzfes zzphy;
    private volatile zzfhe zzphz;
    private volatile zzfes zzpia;

    private zzfhe zzj(zzfhe zzfheVar) {
        if (this.zzphz == null) {
            synchronized (this) {
                if (this.zzphz == null) {
                    try {
                        this.zzphz = zzfheVar;
                        this.zzpia = zzfes.zzpfg;
                    } catch (zzfge e) {
                        this.zzphz = zzfheVar;
                        this.zzpia = zzfes.zzpfg;
                    }
                }
            }
        }
        return this.zzphz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfgk) {
            zzfgk zzfgkVar = (zzfgk) obj;
            zzfhe zzfheVar = this.zzphz;
            zzfhe zzfheVar2 = zzfgkVar.zzphz;
            return (zzfheVar == null && zzfheVar2 == null) ? toByteString().equals(zzfgkVar.toByteString()) : (zzfheVar == null || zzfheVar2 == null) ? zzfheVar != null ? zzfheVar.equals(zzfgkVar.zzj(zzfheVar.zzcxq())) : zzj(zzfheVar2.zzcxq()).equals(zzfheVar2) : zzfheVar.equals(zzfheVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final zzfes toByteString() {
        if (this.zzpia != null) {
            return this.zzpia;
        }
        synchronized (this) {
            if (this.zzpia != null) {
                return this.zzpia;
            }
            this.zzpia = this.zzphz == null ? zzfes.zzpfg : this.zzphz.toByteString();
            return this.zzpia;
        }
    }

    public final int zzho() {
        if (this.zzpia != null) {
            return this.zzpia.size();
        }
        if (this.zzphz != null) {
            return this.zzphz.zzho();
        }
        return 0;
    }

    public final zzfhe zzk(zzfhe zzfheVar) {
        zzfhe zzfheVar2 = this.zzphz;
        this.zzphy = null;
        this.zzpia = null;
        this.zzphz = zzfheVar;
        return zzfheVar2;
    }
}
