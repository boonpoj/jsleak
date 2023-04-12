package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class zzfet implements Iterator {
    private final int limit;
    private int position = 0;
    private /* synthetic */ zzfes zzpfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfet(zzfes zzfesVar) {
        this.zzpfi = zzfesVar;
        this.limit = this.zzpfi.size();
    }

    private final byte nextByte() {
        try {
            zzfes zzfesVar = this.zzpfi;
            int i = this.position;
            this.position = i + 1;
            return zzfesVar.zzkn(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
