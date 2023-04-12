package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class zzfie implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private /* synthetic */ zzfhy zzpkh;
    private boolean zzpki;
    private Iterator<Map.Entry<K, V>> zzpkj;

    private zzfie(zzfhy zzfhyVar) {
        this.zzpkh = zzfhyVar;
        this.pos = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfie(zzfhy zzfhyVar, zzfhz zzfhzVar) {
        this(zzfhyVar);
    }

    private final Iterator<Map.Entry<K, V>> zzczp() {
        Map map;
        if (this.zzpkj == null) {
            map = this.zzpkh.zzpkb;
            this.zzpkj = map.entrySet().iterator();
        }
        return this.zzpkj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.pos + 1;
        list = this.zzpkh.zzpka;
        if (i >= list.size()) {
            map = this.zzpkh.zzpkb;
            if (map.isEmpty() || !zzczp().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Object next;
        List list2;
        this.zzpki = true;
        int i = this.pos + 1;
        this.pos = i;
        list = this.zzpkh.zzpka;
        if (i < list.size()) {
            list2 = this.zzpkh.zzpka;
            next = list2.get(this.pos);
        } else {
            next = zzczp().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzpki) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzpki = false;
        this.zzpkh.zzczl();
        int i = this.pos;
        list = this.zzpkh.zzpka;
        if (i >= list.size()) {
            zzczp().remove();
            return;
        }
        zzfhy zzfhyVar = this.zzpkh;
        int i2 = this.pos;
        this.pos = i2 - 1;
        zzfhyVar.zzmc(i2);
    }
}
