package com.google.android.gms.internal;

import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzbv extends zzbt<Integer, Object> {
    public String zzcw;
    public String zzcy;
    public String zzcz;
    public String zzda;
    public long zzyv;

    public zzbv() {
        this.zzcw = "E";
        this.zzyv = -1L;
        this.zzcy = "E";
        this.zzcz = "E";
        this.zzda = "E";
    }

    public zzbv(String str) {
        this();
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzcw = zzk.get(0) == null ? "E" : (String) zzk.get(0);
            this.zzyv = zzk.get(1) == null ? -1L : ((Long) zzk.get(1)).longValue();
            this.zzcy = zzk.get(2) == null ? "E" : (String) zzk.get(2);
            this.zzcz = zzk.get(3) == null ? "E" : (String) zzk.get(3);
            this.zzda = zzk.get(4) != null ? (String) zzk.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Object> zzy() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzcw);
        hashMap.put(4, this.zzda);
        hashMap.put(3, this.zzcz);
        hashMap.put(2, this.zzcy);
        hashMap.put(1, Long.valueOf(this.zzyv));
        return hashMap;
    }
}
