package com.mopub.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: assets/classes2.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final ByteArrayPool f2238;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 256);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f2238 = byteArrayPool;
        this.buf = this.f2238.getBuf(Math.max(i, 256));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1714(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] buf = this.f2238.getBuf((this.count + i) * 2);
        System.arraycopy(this.buf, 0, buf, 0, this.count);
        this.f2238.returnBuf(this.buf);
        this.buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2238.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f2238.returnBuf(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        m1714(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m1714(i2);
        super.write(bArr, i, i2);
    }
}
