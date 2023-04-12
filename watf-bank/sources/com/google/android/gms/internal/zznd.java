package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznd {
    private final Collection<zzmx<?>> zzbhd = new ArrayList();
    private final Collection<zzmx<String>> zzbhe = new ArrayList();
    private final Collection<zzmx<String>> zzbhf = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzmx<?> zzmxVar : this.zzbhd) {
            if (zzmxVar.getSource() == 1) {
                zzmxVar.zza(editor, (SharedPreferences.Editor) zzmxVar.zzc(jSONObject));
            }
        }
    }

    public final void zza(zzmx zzmxVar) {
        this.zzbhd.add(zzmxVar);
    }

    public final void zzb(zzmx<String> zzmxVar) {
        this.zzbhe.add(zzmxVar);
    }

    public final void zzc(zzmx<String> zzmxVar) {
        this.zzbhf.add(zzmxVar);
    }

    public final List<String> zziw() {
        ArrayList arrayList = new ArrayList();
        for (zzmx<String> zzmxVar : this.zzbhe) {
            String str = (String) zzkb.zzif().zzd(zzmxVar);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzix() {
        List<String> zziw = zziw();
        for (zzmx<String> zzmxVar : this.zzbhf) {
            String str = (String) zzkb.zzif().zzd(zzmxVar);
            if (str != null) {
                zziw.add(str);
            }
        }
        return zziw;
    }
}
