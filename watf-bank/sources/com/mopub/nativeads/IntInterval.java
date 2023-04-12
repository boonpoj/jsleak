package com.mopub.nativeads;

import android.support.annotation.Nullable;
/* loaded from: assets/classes2.dex */
public class IntInterval implements Comparable<IntInterval> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f1565;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f1566;

    public IntInterval(int i, int i2) {
        this.f1565 = i;
        this.f1566 = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@Nullable IntInterval intInterval) {
        int i;
        int i2;
        if (this.f1565 == intInterval.f1565) {
            i = this.f1566;
            i2 = intInterval.f1566;
        } else {
            i = this.f1565;
            i2 = intInterval.f1565;
        }
        return i - i2;
    }

    public boolean equals(int i, int i2) {
        return this.f1565 == i && this.f1566 == i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntInterval) {
            IntInterval intInterval = (IntInterval) obj;
            return this.f1565 == intInterval.f1565 && this.f1566 == intInterval.f1566;
        }
        return false;
    }

    public int getLength() {
        return this.f1566;
    }

    public int getStart() {
        return this.f1565;
    }

    public int hashCode() {
        return ((899 + this.f1565) * 31) + this.f1566;
    }

    public void setLength(int i) {
        this.f1566 = i;
    }

    public void setStart(int i) {
        this.f1565 = i;
    }

    public String toString() {
        return "{start : " + this.f1565 + ", length : " + this.f1566 + "}";
    }
}
