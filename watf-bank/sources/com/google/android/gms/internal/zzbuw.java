package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: assets/classes2.dex */
public final class zzbuw {
    public static final int[] zzcsi = new int[0];
    public static final long[] zzcsj = new long[0];
    public static final float[] zzcsk = new float[0];
    public static final double[] zzcsl = new double[0];
    public static final boolean[] zzcsm = new boolean[0];
    public static final String[] zzcsn = new String[0];
    public static final byte[][] zzcso = new byte[0];
    public static final byte[] zzcsp = new byte[0];

    public static int zzK(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzbul zzbulVar, int i) throws IOException {
        return zzbulVar.zzqh(i);
    }

    public static final int zzc(zzbul zzbulVar, int i) throws IOException {
        int position = zzbulVar.getPosition();
        zzbulVar.zzqh(i);
        int i2 = 1;
        while (zzbulVar.zzacu() == i) {
            zzbulVar.zzqh(i);
            i2++;
        }
        zzbulVar.zzql(position);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzqA(int i) {
        return i & 7;
    }

    public static int zzqB(int i) {
        return i >>> 3;
    }
}
