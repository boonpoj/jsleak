package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzs {
    private static String zzget = null;
    private static final int zzgeu = Process.myPid();

    public static String zzamo() {
        if (zzget == null) {
            zzget = zzcj(zzgeu);
        }
        return zzget;
    }

    private static String zzcj(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = new BufferedReader(new FileReader(sb.toString()));
            try {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                str = bufferedReader.readLine().trim();
            } catch (IOException e) {
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                zzn.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        zzn.closeQuietly(bufferedReader);
        return str;
    }
}
