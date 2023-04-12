package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.List;
/* renamed from: com.mopub.nativeads.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0284 {
    public static final int NOT_FOUND = -1;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f1937;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int[] f1935 = new int[200];
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int[] f1936 = new int[200];
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int[] f1938 = new int[200];
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final int[] f1939 = new int[200];
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final NativeAd[] f1940 = new NativeAd[200];

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f1941 = 0;

    private C0284(@NonNull int[] iArr) {
        this.f1937 = 0;
        this.f1937 = Math.min(iArr.length, 200);
        System.arraycopy(iArr, 0, this.f1936, 0, this.f1937);
        System.arraycopy(iArr, 0, this.f1935, 0, this.f1937);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int m1521(int[] iArr, int i, int i2) {
        int m1522 = m1522(iArr, 0, i, i2);
        if (m1522 < 0) {
            return m1522 ^ (-1);
        }
        int i3 = iArr[m1522];
        while (m1522 >= 0 && iArr[m1522] == i3) {
            m1522--;
        }
        return m1522 + 1;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int m1522(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i3) {
                i = i5 + 1;
            } else if (i6 <= i3) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0284 m1523() {
        return new C0284(new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0284 m1524(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        List<Integer> m1409 = moPubClientPositioning.m1409();
        int m1410 = moPubClientPositioning.m1410();
        int size = m1410 == Integer.MAX_VALUE ? m1409.size() : 200;
        int[] iArr = new int[size];
        int i = 0;
        int i2 = 0;
        for (Integer num : m1409) {
            i2 = num.intValue() - i;
            iArr[i] = i2;
            i++;
        }
        while (i < size) {
            i2 = (i2 + m1410) - 1;
            iArr[i] = i2;
            i++;
        }
        return new C0284(iArr);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static int m1525(int[] iArr, int i, int i2) {
        int m1522 = m1522(iArr, 0, i, i2);
        if (m1522 < 0) {
            return m1522 ^ (-1);
        }
        int i3 = iArr[m1522];
        while (m1522 < i && iArr[m1522] == i3) {
            m1522++;
        }
        return m1522;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public int m1526(int i, int i2) {
        int[] iArr = new int[this.f1941];
        int[] iArr2 = new int[this.f1941];
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1941; i4++) {
            int i5 = this.f1938[i4];
            int i6 = this.f1939[i4];
            if (i <= i6 && i6 < i2) {
                iArr[i3] = i5;
                iArr2[i3] = i6 - i3;
                this.f1940[i4].destroy();
                this.f1940[i4] = null;
                i3++;
            } else if (i3 > 0) {
                int i7 = i4 - i3;
                this.f1938[i7] = i5;
                this.f1939[i7] = i6 - i3;
                this.f1940[i7] = this.f1940[i4];
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int m1521 = m1521(this.f1936, this.f1937, iArr2[0]);
        for (int i8 = this.f1937 - 1; i8 >= m1521; i8--) {
            int i9 = i8 + i3;
            this.f1935[i9] = this.f1935[i8];
            this.f1936[i9] = this.f1936[i8] - i3;
        }
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = m1521 + i10;
            this.f1935[i11] = iArr[i10];
            this.f1936[i11] = iArr2[i10];
        }
        this.f1937 += i3;
        this.f1941 -= i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1527(int i, NativeAd nativeAd) {
        int m1521 = m1521(this.f1936, this.f1937, i);
        if (m1521 == this.f1937 || this.f1936[m1521] != i) {
            MoPubLog.w("Attempted to insert an ad at an invalid position");
            return;
        }
        int i2 = this.f1935[m1521];
        int m1525 = m1525(this.f1938, this.f1941, i2);
        if (m1525 < this.f1941) {
            int i3 = this.f1941 - m1525;
            int i4 = m1525 + 1;
            System.arraycopy(this.f1938, m1525, this.f1938, i4, i3);
            System.arraycopy(this.f1939, m1525, this.f1939, i4, i3);
            System.arraycopy(this.f1940, m1525, this.f1940, i4, i3);
        }
        this.f1938[m1525] = i2;
        this.f1939[m1525] = i;
        this.f1940[m1525] = nativeAd;
        this.f1941++;
        int i5 = (this.f1937 - m1521) - 1;
        int i6 = m1521 + 1;
        System.arraycopy(this.f1936, i6, this.f1936, m1521, i5);
        System.arraycopy(this.f1935, i6, this.f1935, m1521, i5);
        this.f1937--;
        while (m1521 < this.f1937) {
            int[] iArr = this.f1936;
            iArr[m1521] = iArr[m1521] + 1;
            m1521++;
        }
        while (true) {
            m1525++;
            if (m1525 >= this.f1941) {
                return;
            }
            int[] iArr2 = this.f1939;
            iArr2[m1525] = iArr2[m1525] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1528(int i) {
        return m1522(this.f1936, 0, this.f1937, i) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public int m1529(int i) {
        int m1525 = m1525(this.f1936, this.f1937, i);
        if (m1525 == this.f1937) {
            return -1;
        }
        return this.f1936[m1525];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1530(int i, int i2) {
        m1540(i);
        m1539(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public int[] m1531() {
        int[] iArr = new int[this.f1941];
        System.arraycopy(this.f1939, 0, iArr, 0, this.f1941);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1532() {
        if (this.f1941 == 0) {
            return;
        }
        m1526(0, this.f1939[this.f1941 - 1] + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m1533(int i) {
        return m1522(this.f1939, 0, this.f1941, i) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public NativeAd m1534(int i) {
        int m1522 = m1522(this.f1939, 0, this.f1941, i);
        if (m1522 < 0) {
            return null;
        }
        return this.f1940[m1522];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public int m1535(int i) {
        int m1522 = m1522(this.f1939, 0, this.f1941, i);
        if (m1522 < 0) {
            return i - (m1522 ^ (-1));
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public int m1536(int i) {
        return i + m1525(this.f1938, this.f1941, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public int m1537(int i) {
        if (i == 0) {
            return 0;
        }
        int m1535 = m1535(i - 1);
        if (m1535 == -1) {
            return -1;
        }
        return m1535 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public int m1538(int i) {
        if (i == 0) {
            return 0;
        }
        return m1536(i - 1) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m1539(int i) {
        for (int m1521 = m1521(this.f1935, this.f1937, i); m1521 < this.f1937; m1521++) {
            int[] iArr = this.f1935;
            iArr[m1521] = iArr[m1521] + 1;
            int[] iArr2 = this.f1936;
            iArr2[m1521] = iArr2[m1521] + 1;
        }
        for (int m15212 = m1521(this.f1938, this.f1941, i); m15212 < this.f1941; m15212++) {
            int[] iArr3 = this.f1938;
            iArr3[m15212] = iArr3[m15212] + 1;
            int[] iArr4 = this.f1939;
            iArr4[m15212] = iArr4[m15212] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢪ  reason: contains not printable characters */
    public void m1540(int i) {
        for (int m1525 = m1525(this.f1935, this.f1937, i); m1525 < this.f1937; m1525++) {
            int[] iArr = this.f1935;
            iArr[m1525] = iArr[m1525] - 1;
            int[] iArr2 = this.f1936;
            iArr2[m1525] = iArr2[m1525] - 1;
        }
        for (int m15252 = m1525(this.f1938, this.f1941, i); m15252 < this.f1941; m15252++) {
            int[] iArr3 = this.f1938;
            iArr3[m15252] = iArr3[m15252] - 1;
            int[] iArr4 = this.f1939;
            iArr4[m15252] = iArr4[m15252] - 1;
        }
    }
}
