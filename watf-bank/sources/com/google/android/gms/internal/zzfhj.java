package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
final class zzfhj<T> implements zzfhv<T> {
    private final zzfhe zzpiu;
    private final zzfin<?, ?> zzpiv;
    private final boolean zzpiw;
    private final zzffn<?> zzpix;

    private zzfhj(Class<T> cls, zzfin<?, ?> zzfinVar, zzffn<?> zzffnVar, zzfhe zzfheVar) {
        this.zzpiv = zzfinVar;
        this.zzpiw = zzffnVar.zzh(cls);
        this.zzpix = zzffnVar;
        this.zzpiu = zzfheVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzfhj<T> zza(Class<T> cls, zzfin<?, ?> zzfinVar, zzffn<?> zzffnVar, zzfhe zzfheVar) {
        return new zzfhj<>(cls, zzfinVar, zzffnVar, zzfheVar);
    }

    @Override // com.google.android.gms.internal.zzfhv
    public final void zza(T t, zzfji zzfjiVar) {
        Iterator<Map.Entry<?, Object>> it = this.zzpix.zzcn(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzffs zzffsVar = (zzffs) next.getKey();
            if (zzffsVar.zzcxi() != zzfjd.MESSAGE || zzffsVar.zzcxj() || zzffsVar.zzcxk()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzfjiVar.zzb(zzffsVar.zzhq(), next instanceof zzfgi ? ((zzfgi) next).zzcyk().toByteString() : next.getValue());
        }
        zzfin<?, ?> zzfinVar = this.zzpiv;
        zzfinVar.zzb(zzfinVar.zzcq(t), zzfjiVar);
    }

    @Override // com.google.android.gms.internal.zzfhv
    public final int zzcp(T t) {
        zzfin<?, ?> zzfinVar = this.zzpiv;
        int zzcr = zzfinVar.zzcr(zzfinVar.zzcq(t)) + 0;
        return this.zzpiw ? zzcr + this.zzpix.zzcn(t).zzcxg() : zzcr;
    }
}
