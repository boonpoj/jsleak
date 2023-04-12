package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@zzzv
/* loaded from: classes.dex */
public final class zzajg {
    private Map<Integer, Bitmap> zzdcx = new ConcurrentHashMap();
    private AtomicInteger zzdcy = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdcx.get(num);
    }

    public final int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzagf.zzbx("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        int andIncrement = this.zzdcy.getAndIncrement();
        this.zzdcx.put(Integer.valueOf(andIncrement), bitmap);
        return andIncrement;
    }

    public final void zzb(Integer num) {
        this.zzdcx.remove(num);
    }
}
