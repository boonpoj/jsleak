package com.google.android.gms.internal;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzfhy<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzktj;
    private final int zzpjz;
    private List<zzfid> zzpka;
    private Map<K, V> zzpkb;
    private volatile zzfif zzpkc;
    private Map<K, V> zzpkd;

    private zzfhy(int i) {
        this.zzpjz = i;
        this.zzpka = Collections.emptyList();
        this.zzpkb = Collections.emptyMap();
        this.zzpkd = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfhy(int i, zzfhz zzfhzVar) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzpka.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzpka.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzpka.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzczl() {
        if (this.zzktj) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzczm() {
        zzczl();
        if (this.zzpkb.isEmpty() && !(this.zzpkb instanceof TreeMap)) {
            this.zzpkb = new TreeMap();
            this.zzpkd = ((TreeMap) this.zzpkb).descendingMap();
        }
        return (SortedMap) this.zzpkb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzffs<FieldDescriptorType>> zzfhy<FieldDescriptorType, Object> zzma(int i) {
        return new zzfhz(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzmc(int i) {
        zzczl();
        V v = (V) this.zzpka.remove(i).getValue();
        if (!this.zzpkb.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzczm().entrySet().iterator();
            this.zzpka.add(new zzfid(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzczl();
        if (!this.zzpka.isEmpty()) {
            this.zzpka.clear();
        }
        if (this.zzpkb.isEmpty()) {
            return;
        }
        this.zzpkb.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzfhy<K, V>) comparable) >= 0 || this.zzpkb.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzpkc == null) {
            this.zzpkc = new zzfif(this, null);
        }
        return this.zzpkc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfhy) {
            zzfhy zzfhyVar = (zzfhy) obj;
            int size = size();
            if (size != zzfhyVar.size()) {
                return false;
            }
            int zzczj = zzczj();
            if (zzczj != zzfhyVar.zzczj()) {
                return entrySet().equals(zzfhyVar.entrySet());
            }
            for (int i = 0; i < zzczj; i++) {
                if (!zzmb(i).equals(zzfhyVar.zzmb(i))) {
                    return false;
                }
            }
            if (zzczj != size) {
                return this.zzpkb.equals(zzfhyVar.zzpkb);
            }
            return true;
        }
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzfhy<K, V>) comparable);
        return zza >= 0 ? (V) this.zzpka.get(zza).getValue() : this.zzpkb.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzczj = zzczj();
        int i = 0;
        for (int i2 = 0; i2 < zzczj; i2++) {
            i += this.zzpka.get(i2).hashCode();
        }
        return this.zzpkb.size() > 0 ? i + this.zzpkb.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzktj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzfhy<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzczl();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzfhy<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzmc(zza);
        }
        if (this.zzpkb.isEmpty()) {
            return null;
        }
        return this.zzpkb.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzpka.size() + this.zzpkb.size();
    }

    public final V zza(K k, V v) {
        zzczl();
        int zza = zza((zzfhy<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzpka.get(zza).setValue(v);
        }
        zzczl();
        if (this.zzpka.isEmpty() && !(this.zzpka instanceof ArrayList)) {
            this.zzpka = new ArrayList(this.zzpjz);
        }
        int i = -(zza + 1);
        if (i >= this.zzpjz) {
            return zzczm().put(k, v);
        }
        int size = this.zzpka.size();
        int i2 = this.zzpjz;
        if (size == i2) {
            zzfid remove = this.zzpka.remove(i2 - 1);
            zzczm().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zzpka.add(i, new zzfid(this, k, v));
        return null;
    }

    public void zzbiy() {
        if (this.zzktj) {
            return;
        }
        this.zzpkb = this.zzpkb.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpkb);
        this.zzpkd = this.zzpkd.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpkd);
        this.zzktj = true;
    }

    public final int zzczj() {
        return this.zzpka.size();
    }

    public final Iterable<Map.Entry<K, V>> zzczk() {
        return this.zzpkb.isEmpty() ? zzfia.zzczn() : this.zzpkb.entrySet();
    }

    public final Map.Entry<K, V> zzmb(int i) {
        return this.zzpka.get(i);
    }
}
