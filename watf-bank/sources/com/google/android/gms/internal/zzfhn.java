package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
final class zzfhn {
    private static final zzfhn zzpjb = new zzfhn();
    private final zzfhw zzpjc;
    private final ConcurrentMap<Class<?>, zzfhv<?>> zzpjd = new ConcurrentHashMap();

    private zzfhn() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzfhw zzfhwVar = null;
        for (int i = 0; i <= 0; i++) {
            zzfhwVar = zztw(strArr[0]);
            if (zzfhwVar != null) {
                break;
            }
        }
        this.zzpjc = zzfhwVar == null ? new zzfgq() : zzfhwVar;
    }

    public static zzfhn zzcyz() {
        return zzpjb;
    }

    private static zzfhw zztw(String str) {
        try {
            return (zzfhw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> zzfhv<T> zzl(Class<T> cls) {
        zzffz.zzc(cls, "messageType");
        zzfhv<T> zzfhvVar = (zzfhv<T>) this.zzpjd.get(cls);
        if (zzfhvVar == null) {
            zzfhv<T> zzk = this.zzpjc.zzk(cls);
            zzffz.zzc(cls, "messageType");
            zzffz.zzc(zzk, "schema");
            zzfhv<T> zzfhvVar2 = (zzfhv<T>) this.zzpjd.putIfAbsent(cls, zzk);
            return zzfhvVar2 != null ? zzfhvVar2 : zzk;
        }
        return zzfhvVar;
    }
}
