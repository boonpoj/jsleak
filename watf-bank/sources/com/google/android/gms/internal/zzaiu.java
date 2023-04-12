package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class zzaiu {
    private final List<String> zzdcg = new ArrayList();
    private final List<Double> zzdch = new ArrayList();
    private final List<Double> zzdci = new ArrayList();

    public final zzaiu zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzdcg.size()) {
            double doubleValue = this.zzdci.get(i).doubleValue();
            double doubleValue2 = this.zzdch.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzdcg.add(i, str);
        this.zzdci.add(i, Double.valueOf(d));
        this.zzdch.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzair zzqr() {
        return new zzair(this);
    }
}
