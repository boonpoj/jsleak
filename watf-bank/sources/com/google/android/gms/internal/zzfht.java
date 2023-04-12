package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/* loaded from: classes.dex */
final class zzfht implements Iterator<zzfey> {
    private final Stack<zzfhq> zzpjn;
    private zzfey zzpjo;

    private zzfht(zzfes zzfesVar) {
        this.zzpjn = new Stack<>();
        this.zzpjo = zzbb(zzfesVar);
    }

    private final zzfey zzbb(zzfes zzfesVar) {
        while (zzfesVar instanceof zzfhq) {
            zzfhq zzfhqVar = (zzfhq) zzfesVar;
            this.zzpjn.push(zzfhqVar);
            zzfesVar = zzfhqVar.zzpji;
        }
        return (zzfey) zzfesVar;
    }

    private final zzfey zzczc() {
        zzfes zzfesVar;
        while (!this.zzpjn.isEmpty()) {
            zzfesVar = this.zzpjn.pop().zzpjj;
            zzfey zzbb = zzbb(zzfesVar);
            if (!zzbb.isEmpty()) {
                return zzbb;
            }
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzpjo != null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzfey next() {
        zzfey zzfeyVar = this.zzpjo;
        if (zzfeyVar != null) {
            this.zzpjo = zzczc();
            return zzfeyVar;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
