package com.google.android.gms.internal;

import java.util.Comparator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdj extends Exception {

    /* loaded from: assets/classes2.dex */
    public class zza implements Comparator<zzdc> {
        public zza(zzdj zzdjVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(zzdc zzdcVar, zzdc zzdcVar2) {
            if (zzdcVar.zzek() < zzdcVar2.zzek()) {
                return -1;
            }
            if (zzdcVar.zzek() > zzdcVar2.zzek()) {
                return 1;
            }
            if (zzdcVar.zzej() < zzdcVar2.zzej()) {
                return -1;
            }
            if (zzdcVar.zzej() > zzdcVar2.zzej()) {
                return 1;
            }
            float zzem = (zzdcVar.zzem() - zzdcVar.zzek()) * (zzdcVar.zzel() - zzdcVar.zzej());
            float zzem2 = (zzdcVar2.zzem() - zzdcVar2.zzek()) * (zzdcVar2.zzel() - zzdcVar2.zzej());
            if (zzem > zzem2) {
                return -1;
            }
            return zzem < zzem2 ? 1 : 0;
        }
    }

    public zzdj() {
    }

    public zzdj(Throwable th) {
        super(th);
    }
}
