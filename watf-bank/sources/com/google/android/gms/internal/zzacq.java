package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzacq {
    private WeakHashMap<Context, zzacs> zzcuk = new WeakHashMap<>();

    public final Future<zzaco> zzo(Context context) {
        return zzahh.zza(zzahh.zzdar, new zzacr(this, context));
    }
}
