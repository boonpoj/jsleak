package com.google.android.gms.internal;

import java.util.PriorityQueue;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhx {
    private static long zza(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i == 1) {
            return j;
        }
        return (i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) : j * (zza((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    private static String zza(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzagf.e("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i4 = i3 - 1;
            if (i >= i4) {
                stringBuffer.append(strArr[i4]);
                return stringBuffer.toString();
            }
            stringBuffer.append(strArr[i]);
            stringBuffer.append(' ');
            i++;
        }
    }

    private static void zza(int i, long j, String str, int i2, PriorityQueue<zzhy> priorityQueue) {
        zzhy zzhyVar = new zzhy(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzbaj <= zzhyVar.zzbaj && priorityQueue.peek().value <= zzhyVar.value)) && !priorityQueue.contains(zzhyVar)) {
            priorityQueue.add(zzhyVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzhy> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, priorityQueue);
        long zza = zza(16785407L, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            long j = zzb + 1073807359;
            zzb = (((((j - ((((zzhu.zzaa(strArr[i3 - 1]) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzhu.zzaa(strArr[(i3 + i2) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            zza(i, zzb, zza(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzaa = (zzhu.zzaa(strArr[0]) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzaa = (((zzaa * 16785407) % 1073807359) + ((zzhu.zzaa(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzaa;
    }
}
