package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzadc extends zzadi {
    private final String zzcuv;
    private final int zzcuw;

    public zzadc(String str, int i) {
        this.zzcuv = str;
        this.zzcuw = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzadc)) {
            zzadc zzadcVar = (zzadc) obj;
            if (com.google.android.gms.common.internal.zzbg.equal(this.zzcuv, zzadcVar.zzcuv) && com.google.android.gms.common.internal.zzbg.equal(Integer.valueOf(this.zzcuw), Integer.valueOf(zzadcVar.zzcuw))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzadh
    public final int getAmount() {
        return this.zzcuw;
    }

    @Override // com.google.android.gms.internal.zzadh
    public final String getType() {
        return this.zzcuv;
    }
}
