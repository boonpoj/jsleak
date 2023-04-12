package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: assets/classes2.dex */
public abstract class zzapn<T> {
    private final int zzAG;
    private final String zzAH;
    private final T zzAI;

    /* loaded from: assets/classes2.dex */
    public static class zza extends zzapn<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        @Override // com.google.android.gms.internal.zzapn
        /* renamed from: zzb */
        public Boolean zza(zzapq zzapqVar) {
            try {
                return Boolean.valueOf(zzapqVar.getBooleanFlagValue(getKey(), zzfm().booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return zzfm();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb extends zzapn<Integer> {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        @Override // com.google.android.gms.internal.zzapn
        /* renamed from: zzc */
        public Integer zza(zzapq zzapqVar) {
            try {
                return Integer.valueOf(zzapqVar.getIntFlagValue(getKey(), zzfm().intValue(), getSource()));
            } catch (RemoteException unused) {
                return zzfm();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzc extends zzapn<Long> {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        @Override // com.google.android.gms.internal.zzapn
        /* renamed from: zzd */
        public Long zza(zzapq zzapqVar) {
            try {
                return Long.valueOf(zzapqVar.getLongFlagValue(getKey(), zzfm().longValue(), getSource()));
            } catch (RemoteException unused) {
                return zzfm();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzd extends zzapn<String> {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        @Override // com.google.android.gms.internal.zzapn
        /* renamed from: zze */
        public String zza(zzapq zzapqVar) {
            try {
                return zzapqVar.getStringFlagValue(getKey(), zzfm(), getSource());
            } catch (RemoteException unused) {
                return zzfm();
            }
        }
    }

    private zzapn(int i, String str, T t) {
        this.zzAG = i;
        this.zzAH = str;
        this.zzAI = t;
        zzapr.zzCQ().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return (T) zzapr.zzCR().zzb(this);
    }

    public String getKey() {
        return this.zzAH;
    }

    public int getSource() {
        return this.zzAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(zzapq zzapqVar);

    public T zzfm() {
        return this.zzAI;
    }
}
