package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzair {
    private final String[] zzdby;
    private final double[] zzdbz;
    private final double[] zzdca;
    private final int[] zzdcb;
    private int zzdcc;

    private zzair(zzaiu zzaiuVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzaiuVar.zzdch;
        int size = list.size();
        list2 = zzaiuVar.zzdcg;
        this.zzdby = (String[]) list2.toArray(new String[size]);
        list3 = zzaiuVar.zzdch;
        this.zzdbz = zzr(list3);
        list4 = zzaiuVar.zzdci;
        this.zzdca = zzr(list4);
        this.zzdcb = new int[size];
        this.zzdcc = 0;
    }

    private static double[] zzr(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final List<zzait> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzdby.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzdby;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzdca[i];
            double d2 = this.zzdbz[i];
            int[] iArr = this.zzdcb;
            double d3 = iArr[i];
            double d4 = this.zzdcc;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzait(str, d, d2, d3 / d4, iArr[i]));
            i++;
        }
    }

    public final void zza(double d) {
        this.zzdcc++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzdca;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d && d < this.zzdbz[i]) {
                int[] iArr = this.zzdcb;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.zzdca[i]) {
                return;
            }
            i++;
        }
    }
}
