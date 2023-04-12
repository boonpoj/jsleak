package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzpo extends zzeu implements zzpm {

    /* loaded from: assets/classes2.dex */
    public static class zza {
        public final int count;
        public final String name;
        public final double zzXq;
        public final double zzXr;
        public final double zzXs;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzXr = d;
            this.zzXq = d2;
            this.zzXs = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                return com.google.android.gms.common.internal.zzaa.equal(this.name, zzaVar.name) && this.zzXq == zzaVar.zzXq && this.zzXr == zzaVar.zzXr && this.count == zzaVar.count && Double.compare(this.zzXs, zzaVar.zzXs) == 0;
            }
            return false;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzaa.hashCode(new Object[]{this.name, Double.valueOf(this.zzXq), Double.valueOf(this.zzXr), Double.valueOf(this.zzXs), Integer.valueOf(this.count)});
        }

        public String toString() {
            return com.google.android.gms.common.internal.zzaa.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzXr)).zzg("maxBound", Double.valueOf(this.zzXq)).zzg("percent", Double.valueOf(this.zzXs)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb {
        private final List<String> zzXt = new ArrayList();
        private final List<Double> zzXu = new ArrayList();
        private final List<Double> zzXv = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i = 0;
            while (i < this.zzXt.size()) {
                double doubleValue = this.zzXv.get(i).doubleValue();
                double doubleValue2 = this.zzXu.get(i).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.zzXt.add(i, str);
            this.zzXv.add(i, Double.valueOf(d));
            this.zzXu.add(i, Double.valueOf(d2));
            return this;
        }

        public zzpo zzkB() {
            return new zzpo(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.zzpm
    public final String getText() throws RemoteException {
        Parcel zza2 = zza(2, zzbe());
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpm
    public final List<zzpq> zzjm() throws RemoteException {
        Parcel zza2 = zza(3, zzbe());
        ArrayList zzb2 = zzew.zzb(zza2);
        zza2.recycle();
        return zzb2;
    }
}
