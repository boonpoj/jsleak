package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbw {
    private static boolean zzyw = false;
    private static MessageDigest zzyx = null;
    private static final Object zzyy = new Object();
    private static final Object zzyz = new Object();
    static CountDownLatch zzza = new CountDownLatch(1);

    public static String zza(zzaz zzazVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] zza;
        byte[] zzc = zzfjs.zzc(zzazVar);
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbnu)).booleanValue()) {
            zza = zza(zzc, str);
        } else if (zzbz.zzzb == null) {
            throw new GeneralSecurityException();
        } else {
            byte[] zzd = zzbz.zzzb.zzd(zzc, str != null ? str.getBytes() : new byte[0]);
            zzbf zzbfVar = new zzbf();
            zzbfVar.zzgq = new byte[][]{zzd};
            zzbfVar.zzgs = 2;
            zza = zzfjs.zzc(zzbfVar);
        }
        return zzbu.zza(zza, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector<byte[]> zza = zza(bArr, 255);
        if (zza == null || zza.size() == 0) {
            return zza(zzfjs.zzc(zzc(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str, true);
        }
        zzbf zzbfVar = new zzbf();
        zzbfVar.zzgq = new byte[zza.size()];
        Iterator<byte[]> it = zza.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzbfVar.zzgq[i] = zza(it.next(), str, false);
            i++;
        }
        zzbfVar.zzgl = zzb(bArr);
        return zzfjs.zzc(zzbfVar);
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ByteBuffer put;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zzfjs.zzc(zzc(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        byte[] array = put.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        new zzca().zza(array, bArr3);
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzfdb(str.getBytes("UTF-8")).zzay(bArr3);
        }
        return bArr3;
    }

    private static MessageDigest zzaa() {
        boolean z;
        MessageDigest messageDigest;
        zzz();
        try {
            z = zzza.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            z = false;
        }
        if (z && (messageDigest = zzyx) != null) {
            return messageDigest;
        }
        return null;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzyy) {
            MessageDigest zzaa = zzaa();
            if (zzaa == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzaa.reset();
            zzaa.update(bArr);
            digest = zzyx.digest();
        }
        return digest;
    }

    private static zzaz zzc(long j) {
        zzaz zzazVar = new zzaz();
        zzazVar.zzdt = Long.valueOf((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return zzazVar;
    }

    public static void zzz() {
        synchronized (zzyz) {
            if (!zzyw) {
                zzyw = true;
                new Thread(new zzby(null)).start();
            }
        }
    }
}
