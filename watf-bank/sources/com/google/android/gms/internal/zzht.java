package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzht {
    private ByteArrayOutputStream zzbaf = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzbag = new Base64OutputStream(this.zzbaf, 10);

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    public final String toString() {
        String str;
        try {
            this.zzbag.close();
        } catch (IOException e) {
            zzagf.zzb("HashManager: Unable to convert to Base64.", e);
        }
        try {
            try {
                this.zzbaf.close();
                str = this.zzbaf.toString();
            } catch (IOException e2) {
                zzagf.zzb("HashManager: Unable to convert to Base64.", e2);
                str = "";
            }
            return str;
        } finally {
            this.zzbaf = null;
            this.zzbag = null;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbag.write(bArr);
    }
}
