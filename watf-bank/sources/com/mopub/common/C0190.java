package com.mopub.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* renamed from: com.mopub.common.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0190 implements Closeable {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InputStream f657;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Charset f658;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private byte[] f659;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f660;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f661;

    public C0190(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(DiskLruCacheUtil.f352)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f657 = inputStream;
        this.f658 = charset;
        this.f659 = new byte[i];
    }

    public C0190(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m607() throws IOException {
        int read = this.f657.read(this.f659, 0, this.f659.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f660 = 0;
        this.f661 = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f657) {
            if (this.f659 != null) {
                this.f659 = null;
                this.f657.close();
            }
        }
    }

    public String readLine() throws IOException {
        int i;
        int i2;
        synchronized (this.f657) {
            if (this.f659 != null) {
                if (this.f660 >= this.f661) {
                    m607();
                }
                for (int i3 = this.f660; i3 != this.f661; i3++) {
                    if (this.f659[i3] == 10) {
                        if (i3 != this.f660) {
                            i2 = i3 - 1;
                            if (this.f659[i2] == 13) {
                                String str = new String(this.f659, this.f660, i2 - this.f660, this.f658.name());
                                this.f660 = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f659, this.f660, i2 - this.f660, this.f658.name());
                        this.f660 = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f661 - this.f660) + 80) { // from class: com.mopub.common.ࢥ.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, C0190.this.f658.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f659, this.f660, this.f661 - this.f660);
                    this.f661 = -1;
                    m607();
                    i = this.f660;
                    while (i != this.f661) {
                        if (this.f659[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f660) {
                    byteArrayOutputStream.write(this.f659, this.f660, i - this.f660);
                }
                this.f660 = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
