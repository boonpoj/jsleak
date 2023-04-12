package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzamz implements Iterable<zzamx> {
    private final List<zzamx> zzdjz = new LinkedList();

    public static boolean zzb(zzamp zzampVar) {
        zzamx zzc = zzc(zzampVar);
        if (zzc != null) {
            zzc.zzdjw.abort();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzamx zzc(zzamp zzampVar) {
        Iterator<zzamx> it = com.google.android.gms.ads.internal.zzbs.zzfb().iterator();
        while (it.hasNext()) {
            zzamx next = it.next();
            if (next.zzdhj == zzampVar) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzamx> iterator() {
        return this.zzdjz.iterator();
    }

    public final void zza(zzamx zzamxVar) {
        this.zzdjz.add(zzamxVar);
    }

    public final void zzb(zzamx zzamxVar) {
        this.zzdjz.remove(zzamxVar);
    }

    public final int zzsr() {
        return this.zzdjz.size();
    }
}
