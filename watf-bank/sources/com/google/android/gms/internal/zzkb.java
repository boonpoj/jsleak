package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzkb {
    private static final Object sLock = new Object();
    private static zzkb zzbfi;
    private final zzajr zzbfj = new zzajr();
    private final zzjr zzbfk = new zzjr(new zzji(), new zzjh(), new zzmb(), new zzri(), new zzadt(), new zzxd(), new zzrj());
    private final String mSessionId = zzajr.zzra();
    private final zznd zzbfl = new zznd();
    private final zzne zzbfm = new zzne();
    private final zznf zzbfn = new zznf();

    static {
        zzkb zzkbVar = new zzkb();
        synchronized (sLock) {
            zzbfi = zzkbVar;
        }
    }

    protected zzkb() {
    }

    private static zzkb zzhz() {
        zzkb zzkbVar;
        synchronized (sLock) {
            zzkbVar = zzbfi;
        }
        return zzkbVar;
    }

    public static zzajr zzia() {
        return zzhz().zzbfj;
    }

    public static zzjr zzib() {
        return zzhz().zzbfk;
    }

    public static String zzic() {
        return zzhz().mSessionId;
    }

    public static zzne zzid() {
        return zzhz().zzbfm;
    }

    public static zznd zzie() {
        return zzhz().zzbfl;
    }

    public static zznf zzif() {
        return zzhz().zzbfn;
    }
}
