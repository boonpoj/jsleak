package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzal implements zzak {
    private final zzaj zzcby;
    private final HashSet<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj>>> zzcbz = new HashSet<>();

    public zzal(zzaj zzajVar) {
        this.zzcby = zzajVar;
    }

    @Override // com.google.android.gms.ads.internal.js.zzaj
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj> zztVar) {
        this.zzcby.zza(str, zztVar);
        this.zzcbz.add(new AbstractMap.SimpleEntry<>(str, zztVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, Map<String, ?> map) {
        this.zzcby.zza(str, map);
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, JSONObject jSONObject) {
        this.zzcby.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zzaj
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj> zztVar) {
        this.zzcby.zzb(str, zztVar);
        this.zzcbz.remove(new AbstractMap.SimpleEntry(str, zztVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zzm
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzcby.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zzak
    public final void zzlt() {
        Iterator<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj>>> it = this.zzcbz.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzagf.v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzcby.zzb(next.getKey(), next.getValue());
        }
        this.zzcbz.clear();
    }
}
