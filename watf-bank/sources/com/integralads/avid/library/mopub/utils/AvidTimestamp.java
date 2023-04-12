package com.integralads.avid.library.mopub.utils;
/* loaded from: assets/classes2.dex */
public class AvidTimestamp {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static double f98 = 1000000.0d;

    public static double getCurrentTime() {
        double nanoTime = System.nanoTime();
        double d = f98;
        Double.isNaN(nanoTime);
        return nanoTime / d;
    }
}
