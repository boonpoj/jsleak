package com.google.android.gms.internal;

import com.google.android.gms.internal.zziu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzis {
    private final zzix zzbbf;
    private final zzjc zzbbg;
    private final boolean zzbbh;

    private zzis() {
        this.zzbbh = false;
        this.zzbbf = new zzix();
        this.zzbbg = new zzjc();
        zzhm();
    }

    public zzis(zzix zzixVar, boolean z) {
        this.zzbbf = zzixVar;
        this.zzbbh = z;
        this.zzbbg = new zzjc();
        zzhm();
    }

    public static zzis zzhl() {
        return new zzis();
    }

    private final synchronized void zzhm() {
        this.zzbbg.zzbcz = new zzja();
        this.zzbbg.zzbcy = new zzjb();
    }

    private static long[] zzhn() {
        int i;
        List<String> zzix = zznh.zzix();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = zzix.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = it.next().split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException e) {
                    zzagf.v("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }

    public final synchronized void zza(zzit zzitVar) {
        if (this.zzbbh) {
            zzitVar.zza(this.zzbbg);
        }
    }

    public final synchronized void zza(zziu.zza.zzb zzbVar) {
        if (this.zzbbh) {
            this.zzbbg.zzbcx = zzhn();
            this.zzbbf.zzd(zzfjs.zzc(this.zzbbg)).zzq(zzbVar.zzhq()).zzbk();
            String valueOf = String.valueOf(Integer.toString(zzbVar.zzhq(), 10));
            zzagf.v(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
        }
    }
}
