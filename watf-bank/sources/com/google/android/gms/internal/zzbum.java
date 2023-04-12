package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
/* loaded from: assets/classes2.dex */
public final class zzbum {
    private final ByteBuffer zzcrW;

    /* loaded from: assets/classes2.dex */
    public static class zza extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zza(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 108(0x6c, float:1.51E-43)
                r0.<init>(r1)
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space (pos "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " limit "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = ")."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbum.zza.<init>(int, int):void");
        }
    }

    private zzbum(ByteBuffer byteBuffer) {
        this.zzcrW = byteBuffer;
        this.zzcrW.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzbum(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzH(int i, int i2) {
        return zzqs(i) + zzqp(i2);
    }

    public static int zzI(int i, int i2) {
        return zzqs(i) + zzqq(i2);
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbum.zza(java.lang.CharSequence, byte[], int, int):int");
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

    public static zzbum zzae(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzag(byte[] bArr) {
        return zzqu(bArr.length) + bArr.length;
    }

    public static int zzb(int i, double d) {
        return zzqs(i) + 8;
    }

    public static int zzb(int i, zzbut zzbutVar) {
        return (zzqs(i) * 2) + zzd(zzbutVar);
    }

    private static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += zza(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i2 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
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

    public static int zzba(long j) {
        return zzbe(j);
    }

    public static int zzbb(long j) {
        return zzbe(j);
    }

    public static int zzbc(long j) {
        return zzbe(zzbg(j));
    }

    public static int zzbe(long j) {
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

    public static long zzbg(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzc(int i, zzbut zzbutVar) {
        return zzqs(i) + zze(zzbutVar);
    }

    public static int zzc(int i, byte[] bArr) {
        return zzqs(i) + zzag(bArr);
    }

    public static zzbum zzc(byte[] bArr, int i, int i2) {
        return new zzbum(bArr, i, i2);
    }

    public static int zzd(int i, float f) {
        return zzqs(i) + 4;
    }

    public static int zzd(zzbut zzbutVar) {
        return zzbutVar.zzacZ();
    }

    public static int zze(int i, long j) {
        return zzqs(i) + zzba(j);
    }

    public static int zze(zzbut zzbutVar) {
        int zzacZ = zzbutVar.zzacZ();
        return zzqu(zzacZ) + zzacZ;
    }

    public static int zzf(int i, long j) {
        return zzqs(i) + zzbb(j);
    }

    public static int zzg(int i, long j) {
        return zzqs(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzqs(i) + zzbc(j);
    }

    public static int zzh(int i, boolean z) {
        return zzqs(i) + 1;
    }

    public static int zzkc(String str) {
        int zzb = zzb(str);
        return zzqu(zzb) + zzb;
    }

    public static int zzqp(int i) {
        if (i >= 0) {
            return zzqu(i);
        }
        return 10;
    }

    public static int zzqq(int i) {
        return zzqu(zzqw(i));
    }

    public static int zzqs(int i) {
        return zzqu(zzbuw.zzK(i, 0));
    }

    public static int zzqu(int i) {
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

    public static int zzqw(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzr(int i, String str) {
        return zzqs(i) + zzkc(str);
    }

    public void zzF(int i, int i2) throws IOException {
        zzJ(i, 0);
        zzqn(i2);
    }

    public void zzG(int i, int i2) throws IOException {
        zzJ(i, 0);
        zzqo(i2);
    }

    public void zzJ(int i, int i2) throws IOException {
        zzqt(zzbuw.zzK(i, i2));
    }

    public void zza(int i, double d) throws IOException {
        zzJ(i, 1);
        zzn(d);
    }

    public void zza(int i, long j) throws IOException {
        zzJ(i, 0);
        zzaW(j);
    }

    public void zza(int i, zzbut zzbutVar) throws IOException {
        zzJ(i, 2);
        zzc(zzbutVar);
    }

    public void zzaW(long j) throws IOException {
        zzbd(j);
    }

    public void zzaX(long j) throws IOException {
        zzbd(j);
    }

    public void zzaY(long j) throws IOException {
        zzbf(j);
    }

    public void zzaZ(long j) throws IOException {
        zzbd(zzbg(j));
    }

    public int zzacL() {
        return this.zzcrW.remaining();
    }

    public void zzacM() {
        if (zzacL() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zzaf(byte[] bArr) throws IOException {
        zzqt(bArr.length);
        zzah(bArr);
    }

    public void zzah(byte[] bArr) throws IOException {
        zzd(bArr, 0, bArr.length);
    }

    public void zzb(int i, long j) throws IOException {
        zzJ(i, 0);
        zzaX(j);
    }

    public void zzb(int i, byte[] bArr) throws IOException {
        zzJ(i, 2);
        zzaf(bArr);
    }

    public void zzb(zzbut zzbutVar) throws IOException {
        zzbutVar.zza(this);
    }

    public void zzbd(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzqr((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzqr((int) j);
    }

    public void zzbf(long j) throws IOException {
        if (this.zzcrW.remaining() < 8) {
            throw new zza(this.zzcrW.position(), this.zzcrW.limit());
        }
        this.zzcrW.putLong(j);
    }

    public void zzbl(boolean z) throws IOException {
        zzqr(z ? 1 : 0);
    }

    public void zzc(byte b) throws IOException {
        if (!this.zzcrW.hasRemaining()) {
            throw new zza(this.zzcrW.position(), this.zzcrW.limit());
        }
        this.zzcrW.put(b);
    }

    public void zzc(int i, float f) throws IOException {
        zzJ(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) throws IOException {
        zzJ(i, 1);
        zzaY(j);
    }

    public void zzc(zzbut zzbutVar) throws IOException {
        zzqt(zzbutVar.zzacY());
        zzbutVar.zza(this);
    }

    public void zzd(int i, long j) throws IOException {
        zzJ(i, 0);
        zzaZ(j);
    }

    public void zzd(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzcrW.remaining() < i2) {
            throw new zza(this.zzcrW.position(), this.zzcrW.limit());
        }
        this.zzcrW.put(bArr, i, i2);
    }

    public void zzg(int i, boolean z) throws IOException {
        zzJ(i, 0);
        zzbl(z);
    }

    public void zzk(float f) throws IOException {
        zzqv(Float.floatToIntBits(f));
    }

    public void zzkb(String str) throws IOException {
        try {
            int zzqu = zzqu(str.length());
            if (zzqu != zzqu(str.length() * 3)) {
                zzqt(zzb(str));
                zza(str, this.zzcrW);
                return;
            }
            int position = this.zzcrW.position();
            if (this.zzcrW.remaining() < zzqu) {
                throw new zza(position + zzqu, this.zzcrW.limit());
            }
            this.zzcrW.position(position + zzqu);
            zza(str, this.zzcrW);
            int position2 = this.zzcrW.position();
            this.zzcrW.position(position);
            zzqt((position2 - position) - zzqu);
            this.zzcrW.position(position2);
        } catch (BufferOverflowException e) {
            zza zzaVar = new zza(this.zzcrW.position(), this.zzcrW.limit());
            zzaVar.initCause(e);
            throw zzaVar;
        }
    }

    public void zzn(double d) throws IOException {
        zzbf(Double.doubleToLongBits(d));
    }

    public void zzq(int i, String str) throws IOException {
        zzJ(i, 2);
        zzkb(str);
    }

    public void zzqn(int i) throws IOException {
        if (i >= 0) {
            zzqt(i);
        } else {
            zzbd(i);
        }
    }

    public void zzqo(int i) throws IOException {
        zzqt(zzqw(i));
    }

    public void zzqr(int i) throws IOException {
        zzc((byte) i);
    }

    public void zzqt(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzqr((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzqr(i);
    }

    public void zzqv(int i) throws IOException {
        if (this.zzcrW.remaining() < 4) {
            throw new zza(this.zzcrW.position(), this.zzcrW.limit());
        }
        this.zzcrW.putInt(i);
    }
}
