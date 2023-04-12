package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes.dex */
final class zzfgi<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfgg> zzphx;

    private zzfgi(Map.Entry<K, zzfgg> entry) {
        this.zzphx = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzphx.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzphx.getValue() == null) {
            return null;
        }
        return zzfgg.zzcyj();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzfhe) {
            return this.zzphx.getValue().zzk((zzfhe) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzfgg zzcyk() {
        return this.zzphx.getValue();
    }
}
