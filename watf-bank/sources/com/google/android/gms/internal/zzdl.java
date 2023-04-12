package com.google.android.gms.internal;

import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdl extends zzbt<Integer, Long> {
    public Long zzaip;
    public Long zzaiq;

    public zzdl() {
    }

    public zzdl(String str) {
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzaip = (Long) zzk.get(0);
            this.zzaiq = (Long) zzk.get(1);
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Long> zzy() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaip);
        hashMap.put(1, this.zzaiq);
        return hashMap;
    }
}
