package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
final class zzfhu extends InputStream {
    private int mark;
    private zzfht zzpjp;
    private zzfey zzpjq;
    private int zzpjr;
    private int zzpjs;
    private int zzpjt;
    private /* synthetic */ zzfhq zzpju;

    public zzfhu(zzfhq zzfhqVar) {
        this.zzpju = zzfhqVar;
        initialize();
    }

    private final void initialize() {
        this.zzpjp = new zzfht(this.zzpju);
        this.zzpjq = (zzfey) this.zzpjp.next();
        this.zzpjr = this.zzpjq.size();
        this.zzpjs = 0;
        this.zzpjt = 0;
    }

    private final void zzczd() {
        if (this.zzpjq != null) {
            int i = this.zzpjs;
            int i2 = this.zzpjr;
            if (i == i2) {
                this.zzpjt += i2;
                this.zzpjs = 0;
                if (this.zzpjp.hasNext()) {
                    this.zzpjq = (zzfey) this.zzpjp.next();
                    this.zzpjr = this.zzpjq.size();
                    return;
                }
                this.zzpjq = null;
                this.zzpjr = 0;
            }
        }
    }

    private final int zzj(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            zzczd();
            if (this.zzpjq != null) {
                int min = Math.min(this.zzpjr - this.zzpjs, i4);
                if (bArr != null) {
                    this.zzpjq.zza(bArr, this.zzpjs, i3, min);
                    i3 += min;
                }
                this.zzpjs += min;
                i4 -= min;
            } else if (i4 == i2) {
                return -1;
            }
        }
        return i2 - i4;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.zzpju.size() - (this.zzpjt + this.zzpjs);
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.mark = this.zzpjt + this.zzpjs;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        zzczd();
        zzfey zzfeyVar = this.zzpjq;
        if (zzfeyVar == null) {
            return -1;
        }
        int i = this.zzpjs;
        this.zzpjs = i + 1;
        return zzfeyVar.zzkn(i) & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            return zzj(bArr, i, i2);
        }
        throw new NullPointerException();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzj(null, 0, this.mark);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return zzj(null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }
}
