package com.google.android.gms.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzan extends FilterInputStream {
    private long bytesRead;
    private final long zzcc;

    /* loaded from: assets/classes2.dex */
    private static final class zza implements Runnable {
        private zza() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzan.zza(MessageDigest.getInstance("MD5"));
            } catch (NoSuchAlgorithmException unused) {
            } catch (Throwable th) {
                zzan.zzlM.countDown();
                throw th;
            }
            zzan.zzlM.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcc = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.bytesRead++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.bytesRead += read;
        }
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzn() {
        return this.zzcc - this.bytesRead;
    }
}
