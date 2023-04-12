package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzack implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzach zzcrz;

    /* loaded from: assets/classes2.dex */
    public static class zza<I, O> extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final zzacm CREATOR = new zzacm();
        private final int mVersionCode;
        protected final int zzaFA;
        protected final boolean zzaFB;
        protected final int zzaFC;
        protected final boolean zzaFD;
        protected final String zzaFE;
        protected final int zzaFF;
        protected final Class<? extends zzack> zzaFG;
        protected final String zzaFH;
        private zzaco zzaFI;
        private zzb<I, O> zzaFJ;

        zza(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zzacf zzacfVar) {
            this.mVersionCode = i;
            this.zzaFA = i2;
            this.zzaFB = z;
            this.zzaFC = i3;
            this.zzaFD = z2;
            this.zzaFE = str;
            this.zzaFF = i4;
            if (str2 == null) {
                this.zzaFG = null;
                this.zzaFH = null;
            } else {
                this.zzaFG = zzacr.class;
                this.zzaFH = str2;
            }
            this.zzaFJ = zzacfVar != null ? zzacfVar.zzxI() : null;
        }

        protected zza(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends zzack> cls, zzb<I, O> zzbVar) {
            this.mVersionCode = 1;
            this.zzaFA = i;
            this.zzaFB = z;
            this.zzaFC = i2;
            this.zzaFD = z2;
            this.zzaFE = str;
            this.zzaFF = i3;
            this.zzaFG = cls;
            this.zzaFH = cls == null ? null : cls.getCanonicalName();
            this.zzaFJ = zzbVar;
        }

        public static zza zza(String str, int i, zzb<?, ?> zzbVar, boolean z) {
            return new zza(7, z, 0, false, str, i, null, zzbVar);
        }

        public static <T extends zzack> zza<T, T> zza(String str, int i, Class<T> cls) {
            return new zza<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends zzack> zza<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new zza<>(11, true, 11, true, str, i, cls, null);
        }

        public static zza<Integer, Integer> zzk(String str, int i) {
            return new zza<>(0, false, 0, false, str, i, null, null);
        }

        public static zza<Boolean, Boolean> zzl(String str, int i) {
            return new zza<>(6, false, 6, false, str, i, null, null);
        }

        public static zza<String, String> zzm(String str, int i) {
            return new zza<>(7, false, 7, false, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.zzaFJ.convertBack(o);
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            zzaa.zza zzg = com.google.android.gms.common.internal.zzaa.zzv(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("typeIn", Integer.valueOf(this.zzaFA)).zzg("typeInArray", Boolean.valueOf(this.zzaFB)).zzg("typeOut", Integer.valueOf(this.zzaFC)).zzg("typeOutArray", Boolean.valueOf(this.zzaFD)).zzg("outputFieldName", this.zzaFE).zzg("safeParcelFieldId", Integer.valueOf(this.zzaFF)).zzg("concreteTypeName", zzxS());
            Class<? extends zzack> zzxR = zzxR();
            if (zzxR != null) {
                zzg.zzg("concreteType.class", zzxR.getCanonicalName());
            }
            if (this.zzaFJ != null) {
                zzg.zzg("converterName", this.zzaFJ.getClass().getCanonicalName());
            }
            return zzg.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzacm.zza(this, parcel, i);
        }

        public void zza(zzaco zzacoVar) {
            this.zzaFI = zzacoVar;
        }

        public int zzxL() {
            return this.zzaFA;
        }

        public boolean zzxM() {
            return this.zzaFB;
        }

        public int zzxN() {
            return this.zzaFC;
        }

        public boolean zzxO() {
            return this.zzaFD;
        }

        public String zzxP() {
            return this.zzaFE;
        }

        public int zzxQ() {
            return this.zzaFF;
        }

        public Class<? extends zzack> zzxR() {
            return this.zzaFG;
        }

        String zzxS() {
            if (this.zzaFH == null) {
                return null;
            }
            return this.zzaFH;
        }

        public boolean zzxT() {
            return this.zzaFJ != null;
        }

        zzacf zzxU() {
            if (this.zzaFJ == null) {
                return null;
            }
            return zzacf.zza(this.zzaFJ);
        }

        public Map<String, zza<?, ?>> zzxV() {
            com.google.android.gms.common.internal.zzac.zzw(this.zzaFH);
            com.google.android.gms.common.internal.zzac.zzw(this.zzaFI);
            return this.zzaFI.zzdA(this.zzaFH);
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb<I, O> {
        I convertBack(O o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzack(zzach zzachVar) {
        this.zzcrz = zzachVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        Object obj2;
        zzalf zzalfVar;
        String str;
        zzalf zzalfVar2;
        obj2 = this.zzcrz.mLock;
        synchronized (obj2) {
            zzalfVar = this.zzcrz.zzcrv;
            if (zzalfVar.isDone()) {
                return;
            }
            zzacn zzacnVar = new zzacn(-2, map);
            str = this.zzcrz.zzcrt;
            if (str.equals(zzacnVar.getRequestId())) {
                zzalfVar2 = this.zzcrz.zzcrv;
                zzalfVar2.set(zzacnVar);
            }
        }
    }
}
