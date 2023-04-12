package com.google.android.gms.internal;
/* loaded from: classes.dex */
public class zzbey<T> {
    private String zzbhb;
    private T zzbhc;
    private T zzfvq = null;
    private static final Object sLock = new Object();
    private static zzbfe zzfvo = null;
    private static int zzfvp = 0;
    private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbey(String str, T t) {
        this.zzbhb = str;
        this.zzbhc = t;
    }

    public static zzbey<Float> zza(String str, Float f) {
        return new zzbfc(str, f);
    }

    public static zzbey<Integer> zza(String str, Integer num) {
        return new zzbfb(str, num);
    }

    public static zzbey<Long> zza(String str, Long l) {
        return new zzbfa(str, l);
    }

    public static zzbey<Boolean> zze(String str, boolean z) {
        return new zzbez(str, Boolean.valueOf(z));
    }

    public static zzbey<String> zzs(String str, String str2) {
        return new zzbfd(str, str2);
    }
}
