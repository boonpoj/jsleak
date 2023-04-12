package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzfgt implements zzfhd {
    private zzfhd[] zzpii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfgt(zzfhd... zzfhdVarArr) {
        this.zzpii = zzfhdVarArr;
    }

    @Override // com.google.android.gms.internal.zzfhd
    public final boolean zzi(Class<?> cls) {
        for (zzfhd zzfhdVar : this.zzpii) {
            if (zzfhdVar.zzi(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzfhd
    public final zzfhc zzj(Class<?> cls) {
        zzfhd[] zzfhdVarArr;
        for (zzfhd zzfhdVar : this.zzpii) {
            if (zzfhdVar.zzi(cls)) {
                return zzfhdVar.zzj(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
