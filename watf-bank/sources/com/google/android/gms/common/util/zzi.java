package com.google.android.gms.common.util;

import android.content.Context;
/* loaded from: classes.dex */
public final class zzi {
    private static Boolean zzgeg;
    private static Boolean zzgeh;
    private static Boolean zzgei;
    private static Boolean zzgej;
    private static Boolean zzgek;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (com.google.android.gms.common.util.zzi.zzgeh.booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = com.google.android.gms.common.util.zzi.zzgeg
            if (r1 != 0) goto L45
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            if (r1 != 0) goto L3e
            java.lang.Boolean r1 = com.google.android.gms.common.util.zzi.zzgeh
            if (r1 != 0) goto L36
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L2f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.common.util.zzi.zzgeh = r4
        L36:
            java.lang.Boolean r4 = com.google.android.gms.common.util.zzi.zzgeh
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3f
        L3e:
            r0 = 1
        L3f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.zzi.zzgeg = r4
        L45:
            java.lang.Boolean r4 = com.google.android.gms.common.util.zzi.zzgeg
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzi.zza(android.content.res.Resources):boolean");
    }

    public static boolean zzcs(Context context) {
        if (zzgei == null) {
            zzgei = Boolean.valueOf(zzq.zzamm() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzgei.booleanValue();
    }

    public static boolean zzct(Context context) {
        return (!zzq.isAtLeastN() || zzcu(context)) && zzcs(context);
    }

    public static boolean zzcu(Context context) {
        if (zzgej == null) {
            zzgej = Boolean.valueOf(zzq.zzamn() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzgej.booleanValue();
    }

    public static boolean zzcv(Context context) {
        if (zzgek == null) {
            zzgek = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzgek.booleanValue();
    }
}
