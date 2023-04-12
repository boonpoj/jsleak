package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zzffy extends zzfeo<Integer> implements zzfgc, zzfhl, RandomAccess {
    private static final zzffy zzphs;
    private int size;
    private int[] zzpht;

    static {
        zzffy zzffyVar = new zzffy();
        zzphs = zzffyVar;
        zzffyVar.zzbiy();
    }

    zzffy() {
        this(new int[10], 0);
    }

    private zzffy(int[] iArr, int i) {
        this.zzpht = iArr;
        this.size = i;
    }

    private final void zzai(int i, int i2) {
        int i3;
        zzcvj();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzlx(i));
        }
        int[] iArr = this.zzpht;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzpht, i, iArr2, i + 1, this.size - i);
            this.zzpht = iArr2;
        }
        this.zzpht[i] = i2;
        this.size++;
        this.modCount++;
    }

    public static zzffy zzcxz() {
        return zzphs;
    }

    private final void zzlw(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzlx(i));
        }
    }

    private final String zzlx(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzai(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzcvj();
        zzffz.checkNotNull(collection);
        if (collection instanceof zzffy) {
            zzffy zzffyVar = (zzffy) collection;
            int i = zzffyVar.size;
            if (i == 0) {
                return false;
            }
            int i2 = this.size;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                int[] iArr = this.zzpht;
                if (i3 > iArr.length) {
                    this.zzpht = Arrays.copyOf(iArr, i3);
                }
                System.arraycopy(zzffyVar.zzpht, 0, this.zzpht, this.size, zzffyVar.size);
                this.size = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzffy) {
            zzffy zzffyVar = (zzffy) obj;
            if (this.size != zzffyVar.size) {
                return false;
            }
            int[] iArr = zzffyVar.zzpht;
            for (int i = 0; i < this.size; i++) {
                if (this.zzpht[i] != iArr[i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.android.gms.internal.zzfgc
    public final int getInt(int i) {
        zzlw(i);
        return this.zzpht[i];
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzpht[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzcvj();
        zzlw(i);
        int[] iArr = this.zzpht;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, this.size - i);
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzcvj();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzpht[i]))) {
                int[] iArr = this.zzpht;
                System.arraycopy(iArr, i + 1, iArr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzfeo, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzcvj();
        zzlw(i);
        int[] iArr = this.zzpht;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.zzfgd
    /* renamed from: zzlu */
    public final zzfgc zzly(int i) {
        if (i >= this.size) {
            return new zzffy(Arrays.copyOf(this.zzpht, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.zzfgc
    public final void zzlv(int i) {
        zzai(this.size, i);
    }
}
