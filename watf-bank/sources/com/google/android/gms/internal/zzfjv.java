package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfjv {
    private static int zzpnl = 11;
    private static int zzpnm = 12;
    private static int zzpnn = 16;
    private static int zzpno = 26;
    public static final int[] zzpnp = new int[0];
    public static final long[] zzpnq = new long[0];
    public static final float[] zzpnr = new float[0];
    public static final double[] zzpns = new double[0];
    public static final boolean[] zzpnt = new boolean[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final byte[][] zzpnu = new byte[0];
    public static final byte[] zzpnv = new byte[0];

    public static final int zzb(zzfjj zzfjjVar, int i) throws IOException {
        int position = zzfjjVar.getPosition();
        zzfjjVar.zzkq(i);
        int i2 = 1;
        while (zzfjjVar.zzcvt() == i) {
            zzfjjVar.zzkq(i);
            i2++;
        }
        zzfjjVar.zzam(position, i);
        return i2;
    }
}
