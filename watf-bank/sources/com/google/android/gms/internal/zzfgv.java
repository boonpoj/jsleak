package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfgv<K, V> {
    private final V value;
    private final K zzmmo;
    private final zzfgx<K, V> zzpin;

    private zzfgv(zzfiy zzfiyVar, K k, zzfiy zzfiyVar2, V v) {
        this.zzpin = new zzfgx<>(zzfiyVar, k, zzfiyVar2, v);
        this.zzmmo = k;
        this.value = v;
    }

    static <K, V> int zza(zzfgx<K, V> zzfgxVar, K k, V v) {
        return zzffq.zza(zzfgxVar.zzpio, 1, k) + zzffq.zza(zzfgxVar.zzpiq, 2, v);
    }

    public static <K, V> zzfgv<K, V> zza(zzfiy zzfiyVar, K k, zzfiy zzfiyVar2, V v) {
        return new zzfgv<>(zzfiyVar, k, zzfiyVar2, v);
    }

    private static <T> T zza(zzffb zzffbVar, zzffm zzffmVar, zzfiy zzfiyVar, T t) throws IOException {
        int i = zzfgw.zzpgo[zzfiyVar.ordinal()];
        if (i == 1) {
            zzfhf zzcxp = ((zzfhe) t).zzcxp();
            zzffbVar.zza(zzcxp, zzffmVar);
            return (T) zzcxp.zzcxu();
        } else if (i != 2) {
            if (i != 3) {
                return (T) zzffq.zza(zzffbVar, zzfiyVar, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        } else {
            return (T) Integer.valueOf(zzffbVar.zzcwd());
        }
    }

    static <K, V> void zza(zzffg zzffgVar, zzfgx<K, V> zzfgxVar, K k, V v) throws IOException {
        zzffq.zza(zzffgVar, zzfgxVar.zzpio, 1, k);
        zzffq.zza(zzffgVar, zzfgxVar.zzpiq, 2, v);
    }

    public final void zza(zzffg zzffgVar, int i, K k, V v) throws IOException {
        zzffgVar.zzz(i, 2);
        zzffgVar.zzld(zza(this.zzpin, k, v));
        zza(zzffgVar, this.zzpin, k, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzfgy<K, V> zzfgyVar, zzffb zzffbVar, zzffm zzffmVar) throws IOException {
        int zzks = zzffbVar.zzks(zzffbVar.zzcwi());
        Object obj = this.zzpin.zzpip;
        Object obj2 = this.zzpin.zzjxd;
        while (true) {
            int zzcvt = zzffbVar.zzcvt();
            if (zzcvt == 0) {
                break;
            } else if (zzcvt == (this.zzpin.zzpio.zzdae() | 8)) {
                obj = zza(zzffbVar, zzffmVar, this.zzpin.zzpio, obj);
            } else if (zzcvt == (this.zzpin.zzpiq.zzdae() | 16)) {
                obj2 = zza(zzffbVar, zzffmVar, this.zzpin.zzpiq, obj2);
            } else if (!zzffbVar.zzkq(zzcvt)) {
                break;
            }
        }
        zzffbVar.zzkp(0);
        zzffbVar.zzkt(zzks);
        zzfgyVar.put(obj, obj2);
    }

    public final int zzb(int i, K k, V v) {
        return zzffg.zzlg(i) + zzffg.zzln(zza(this.zzpin, k, v));
    }
}
