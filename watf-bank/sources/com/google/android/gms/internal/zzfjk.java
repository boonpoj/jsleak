package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
/* loaded from: classes.dex */
public final class zzfjk {
    private final ByteBuffer buffer;

    private zzfjk(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzfjk(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int zza(java.lang.CharSequence r6, byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjk.zza(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            zzb(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int zzad(int i, int i2) {
        return zzlg(i) + zzlh(i2);
    }

    public static int zzb(int i, zzfjs zzfjsVar) {
        int zzlg = zzlg(i);
        int zzho = zzfjsVar.zzho();
        return zzlg + zzlp(zzho) + zzho;
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            char c = charAt;
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else if (charAt >= 55296 && 57343 >= charAt) {
                    int i3 = i2 + 1;
                    if (i3 != charSequence.length()) {
                        char charAt2 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i2 = i3;
                            i2++;
                        } else {
                            i2 = i3;
                        }
                    }
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Unpaired surrogate at index ");
                    sb.append(i2 - 1);
                    throw new IllegalArgumentException(sb.toString());
                } else {
                    byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                    i = ((charAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i);
                c = (charAt & '?') | 128;
            }
            byteBuffer.put((byte) c);
            i2++;
        }
    }

    public static zzfjk zzbf(byte[] bArr) {
        return zzo(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzlp(bArr.length) + bArr.length;
    }

    public static int zzc(int i, long j) {
        return zzlg(i) + zzdi(j);
    }

    public static int zzd(int i, byte[] bArr) {
        return zzlg(i) + zzbg(bArr);
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static long zzdb(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private final void zzdh(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzmh((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzmh((int) j);
    }

    public static int zzdi(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private final void zzdj(long j) throws IOException {
        if (this.buffer.remaining() < 8) {
            throw new zzfjl(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putLong(j);
    }

    public static int zzh(int i, long j) {
        return zzlg(i) + zzdi(zzdb(j));
    }

    public static int zzlg(int i) {
        return zzlp(i << 3);
    }

    public static int zzlh(int i) {
        if (i >= 0) {
            return zzlp(i);
        }
        return 10;
    }

    public static int zzlo(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzlp(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    private final void zzmh(int i) throws IOException {
        byte b = (byte) i;
        if (!this.buffer.hasRemaining()) {
            throw new zzfjl(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(b);
    }

    public static int zzo(int i, String str) {
        return zzlg(i) + zztt(str);
    }

    public static zzfjk zzo(byte[] bArr, int i, int i2) {
        return new zzfjk(bArr, 0, i2);
    }

    public static int zztt(String str) {
        int zzd = zzd(str);
        return zzlp(zzd) + zzd;
    }

    public final void zza(int i, double d) throws IOException {
        zzz(i, 1);
        zzdj(Double.doubleToLongBits(d));
    }

    public final void zza(int i, long j) throws IOException {
        zzz(i, 0);
        zzdh(j);
    }

    public final void zza(int i, zzfjs zzfjsVar) throws IOException {
        zzz(i, 2);
        zzb(zzfjsVar);
    }

    public final void zzaa(int i, int i2) throws IOException {
        zzz(i, 0);
        if (i2 >= 0) {
            zzmi(i2);
        } else {
            zzdh(i2);
        }
    }

    public final void zzb(int i, long j) throws IOException {
        zzz(i, 1);
        zzdj(j);
    }

    public final void zzb(zzfjs zzfjsVar) throws IOException {
        zzmi(zzfjsVar.zzdam());
        zzfjsVar.zza(this);
    }

    public final void zzbh(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.buffer.remaining() < length) {
            throw new zzfjl(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(bArr, 0, length);
    }

    public final void zzc(int i, float f) throws IOException {
        zzz(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.buffer.remaining() < 4) {
            throw new zzfjl(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putInt(floatToIntBits);
    }

    public final void zzc(int i, byte[] bArr) throws IOException {
        zzz(i, 2);
        zzmi(bArr.length);
        zzbh(bArr);
    }

    public final void zzcwt() {
        if (this.buffer.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.buffer.remaining())));
        }
    }

    public final void zzf(int i, long j) throws IOException {
        zzz(i, 0);
        zzdh(j);
    }

    public final void zzg(int i, long j) throws IOException {
        zzz(i, 0);
        zzdh(zzdb(j));
    }

    public final void zzl(int i, boolean z) throws IOException {
        zzz(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        if (!this.buffer.hasRemaining()) {
            throw new zzfjl(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(b);
    }

    public final void zzmi(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzmh((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzmh(i);
    }

    public final void zzn(int i, String str) throws IOException {
        zzz(i, 2);
        try {
            int zzlp = zzlp(str.length());
            if (zzlp != zzlp(str.length() * 3)) {
                zzmi(zzd(str));
                zza(str, this.buffer);
                return;
            }
            int position = this.buffer.position();
            if (this.buffer.remaining() < zzlp) {
                throw new zzfjl(position + zzlp, this.buffer.limit());
            }
            this.buffer.position(position + zzlp);
            zza(str, this.buffer);
            int position2 = this.buffer.position();
            this.buffer.position(position);
            zzmi((position2 - position) - zzlp);
            this.buffer.position(position2);
        } catch (BufferOverflowException e) {
            zzfjl zzfjlVar = new zzfjl(this.buffer.position(), this.buffer.limit());
            zzfjlVar.initCause(e);
            throw zzfjlVar;
        }
    }

    public final void zzz(int i, int i2) throws IOException {
        zzmi((i << 3) | i2);
    }
}
