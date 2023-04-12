package com.google.android.gms.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes.dex */
public final class zzj {
    private static long zzgem;
    private static IntentFilter zzgel = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float zzgen = Float.NaN;

    public static int zzcw(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgel);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzq.zzamm() ? powerManager.isInteractive() : powerManager.isScreenOn()) << 1) | i;
    }

    public static synchronized float zzcx(Context context) {
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzgem < 60000 && !Float.isNaN(zzgen)) {
                return zzgen;
            }
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgel);
            if (registerReceiver != null) {
                zzgen = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            }
            zzgem = SystemClock.elapsedRealtime();
            return zzgen;
        }
    }
}
