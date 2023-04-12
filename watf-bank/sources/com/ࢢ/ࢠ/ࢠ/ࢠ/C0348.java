package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ރ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0348 extends Exception {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Long f2452;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Long f2451 = 60000L;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static Exception f2453 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0348(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m1972(String str, Exception exc) {
        if (!(exc instanceof C0348)) {
            return str + " failed unexpectedly";
        }
        return str + " failed: " + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1973() {
        if (f2453 != null) {
            m1975(f2453);
            f2453 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1974(Exception exc) {
        if (C0355.m2002().f2487) {
            Log.e("MoatException", Log.getStackTraceString(exc));
        } else {
            m1975(exc);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x00e3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: ࢢ  reason: contains not printable characters */
    private static void m1975(java.lang.Exception r12) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢢ.ࢠ.ࢠ.ࢠ.C0348.m1975(java.lang.Exception):void");
    }
}
