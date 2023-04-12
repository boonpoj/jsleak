package com.google.android.gms.internal;

import com.google.android.gms.internal.zzzb;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@zzzv
/* loaded from: classes.dex */
public abstract class zzyk<T extends zzzb> implements zzzb<T> {
    private final HashMap<String, List<com.google.android.gms.ads.internal.gmsg.zzt<? super T>>> zzckd = new HashMap<>();

    @Override // com.google.android.gms.internal.zzzb
    public void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super T> zztVar) {
        List<com.google.android.gms.ads.internal.gmsg.zzt<? super T>> list = this.zzckd.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.zzckd.put(str, list);
        }
        list.add(zztVar);
    }

    @Override // com.google.android.gms.internal.zzzb
    public void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super T> zztVar) {
        List<com.google.android.gms.ads.internal.gmsg.zzt<? super T>> list = this.zzckd.get(str);
        if (list == null) {
            return;
        }
        list.remove(zztVar);
    }
}
