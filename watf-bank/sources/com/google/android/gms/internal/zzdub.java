package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class zzdub implements zzdvf {
    private static final byte[] zzlyj = new byte[16];
    static final int[] zzlyk = zza(ByteBuffer.wrap(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107}));
    final zzdve zzlyl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdub(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        this.zzlyl = zzdve.zzal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private static void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, zzduf zzdufVar) {
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer2.hasRemaining()) {
            int remaining = byteBuffer2.remaining() < 64 ? byteBuffer2.remaining() : 64;
            order.asIntBuffer().put(zzdufVar.zzbqj());
            for (int i = 0; i < remaining; i++) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ order.get(i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] zza(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdub zzai(byte[] bArr) {
        return new zzdud(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > 2147483635) {
            throw new GeneralSecurityException("plaintext too long");
        }
        if (byteBuffer.remaining() < bArr.length + 12) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] zzgh = zzdvi.zzgh(12);
        byteBuffer.put(zzgh);
        zza(byteBuffer, ByteBuffer.wrap(bArr), zzaj(zzgh));
    }

    @Override // com.google.android.gms.internal.zzdvf
    public final byte[] zzag(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12);
        zza(allocate, bArr);
        return allocate.array();
    }

    abstract zzduf zzaj(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzbqi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int[] zzd(byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] zze(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        zzf(copyOf);
        for (int i = 0; i < iArr.length; i++) {
            copyOf[i] = copyOf[i] + iArr[i];
        }
        return copyOf;
    }

    abstract void zzf(int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzg(int[] iArr);
}
