package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzz implements zzt<Object> {
    private final Context zzair;

    public zzz(Context context) {
        this.zzair = context;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        if (zzbs.zzfd().zzq(this.zzair)) {
            zzbs.zzfd().zza(this.zzair, map.get("eventName"), map.get("eventId"));
        }
    }
}
