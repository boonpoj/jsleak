package com.mopub.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class ByteArrayPool {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static final Comparator<byte[]> f2165 = new Comparator<byte[]>() { // from class: com.mopub.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final List<byte[]> f2166 = new LinkedList();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final List<byte[]> f2167 = new ArrayList(64);

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2168 = 0;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final int f2169;

    public ByteArrayPool(int i) {
        this.f2169 = i;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private synchronized void m1654() {
        while (this.f2168 > this.f2169) {
            byte[] remove = this.f2166.remove(0);
            this.f2167.remove(remove);
            this.f2168 -= remove.length;
        }
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.f2167.size(); i2++) {
            byte[] bArr = this.f2167.get(i2);
            if (bArr.length >= i) {
                this.f2168 -= bArr.length;
                this.f2167.remove(i2);
                this.f2166.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2169) {
                this.f2166.add(bArr);
                int binarySearch = Collections.binarySearch(this.f2167, bArr, f2165);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f2167.add(binarySearch, bArr);
                this.f2168 += bArr.length;
                m1654();
            }
        }
    }
}
