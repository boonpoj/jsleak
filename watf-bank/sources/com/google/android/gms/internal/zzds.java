package com.google.android.gms.internal;

import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzds extends zzbt<Integer, Long> {
    public Long zzajv;
    public Long zzge;
    public Long zzgf;

    public zzds() {
    }

    public zzds(String str) {
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzajv = (Long) zzk.get(0);
            this.zzge = (Long) zzk.get(1);
            this.zzgf = (Long) zzk.get(2);
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Long> zzy() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzajv);
        hashMap.put(1, this.zzge);
        hashMap.put(2, this.zzgf);
        return hashMap;
    }
}
