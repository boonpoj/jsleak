package com.google.android.gms.internal;

import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzcz extends zzbt<Integer, Long> {
    public long zzaig;
    public long zzaih;

    public zzcz() {
        this.zzaig = -1L;
        this.zzaih = -1L;
    }

    public zzcz(String str) {
        this();
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzaig = ((Long) zzk.get(0)).longValue();
            this.zzaih = ((Long) zzk.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Long> zzy() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzaig));
        hashMap.put(1, Long.valueOf(this.zzaih));
        return hashMap;
    }
}
