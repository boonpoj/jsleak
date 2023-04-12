package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public abstract class zzmx<T> {
    private final int zzbha;
    private final String zzbhb;
    private final T zzbhc;

    private zzmx(int i, String str, T t) {
        this.zzbha = i;
        this.zzbhb = str;
        this.zzbhc = t;
        zzkb.zzie().zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmx(int i, String str, Object obj, zzmy zzmyVar) {
        this(i, str, obj);
    }

    public static zzmx<String> zza(int i, String str) {
        zzmx<String> zza = zza(i, str, (String) null);
        zzkb.zzie().zzb(zza);
        return zza;
    }

    public static zzmx<Float> zza(int i, String str, float f) {
        return new zznb(i, str, Float.valueOf(0.0f));
    }

    public static zzmx<Integer> zza(int i, String str, int i2) {
        return new zzmz(i, str, Integer.valueOf(i2));
    }

    public static zzmx<Long> zza(int i, String str, long j) {
        return new zzna(i, str, Long.valueOf(j));
    }

    public static zzmx<Boolean> zza(int i, String str, Boolean bool) {
        return new zzmy(i, str, bool);
    }

    public static zzmx<String> zza(int i, String str, String str2) {
        return new zznc(i, str, str2);
    }

    public static zzmx<String> zzb(int i, String str) {
        zzmx<String> zza = zza(i, str, (String) null);
        zzkb.zzie().zzc(zza);
        return zza;
    }

    public final String getKey() {
        return this.zzbhb;
    }

    public final int getSource() {
        return this.zzbha;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zzc(JSONObject jSONObject);

    public final T zziv() {
        return this.zzbhc;
    }
}
