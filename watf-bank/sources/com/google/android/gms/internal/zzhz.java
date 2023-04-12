package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhz extends zzhq {
    private MessageDigest zzbah;
    private final int zzbak;
    private final int zzbal;

    public zzhz(int i) {
        int i2 = i / 8;
        this.zzbak = i % 8 > 0 ? i2 + 1 : i2;
        this.zzbal = i;
    }

    @Override // com.google.android.gms.internal.zzhq
    public final byte[] zzy(String str) {
        synchronized (this.mLock) {
            this.zzbah = zzhd();
            if (this.zzbah == null) {
                return new byte[0];
            }
            this.zzbah.reset();
            this.zzbah.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.zzbah.digest();
            byte[] bArr = new byte[digest.length > this.zzbak ? this.zzbak : digest.length];
            System.arraycopy(digest, 0, bArr, 0, bArr.length);
            if (this.zzbal % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & 255;
                }
                long j2 = j >>> (8 - (this.zzbal % 8));
                for (int i2 = this.zzbak - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
