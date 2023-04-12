package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzat extends ByteArrayOutputStream {
    private final zzaj zzbr;

    public zzat(zzaj zzajVar, int i) {
        this.zzbr = zzajVar;
        this.buf = this.zzbr.zzb(Math.max(i, 256));
    }

    private final void zzc(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] zzb = this.zzbr.zzb((this.count + i) << 1);
        System.arraycopy(this.buf, 0, zzb, 0, this.count);
        this.zzbr.zza(this.buf);
        this.buf = zzb;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzbr.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbr.zza(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zzc(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzc(i2);
        super.write(bArr, i, i2);
    }
}
