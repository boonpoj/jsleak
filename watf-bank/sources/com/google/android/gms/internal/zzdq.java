package com.google.android.gms.internal;

import java.util.HashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdq extends zzbt<Integer, Long> {
    public Long zzajl;
    public Long zzajm;
    public Long zzajn;
    public Long zzajo;
    public Long zzajp;
    public Long zzajq;
    public Long zzajr;
    public Long zzajs;
    public Long zzajt;
    public Long zzfk;
    public Long zzfm;
    public Long zzfq;
    public Long zzfr;

    public zzdq() {
    }

    public zzdq(String str) {
        zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbt
    public final void zzj(String str) {
        HashMap zzk = zzk(str);
        if (zzk != null) {
            this.zzajl = (Long) zzk.get(0);
            this.zzajm = (Long) zzk.get(1);
            this.zzajn = (Long) zzk.get(2);
            this.zzfm = (Long) zzk.get(3);
            this.zzfk = (Long) zzk.get(4);
            this.zzajo = (Long) zzk.get(5);
            this.zzajp = (Long) zzk.get(6);
            this.zzajq = (Long) zzk.get(7);
            this.zzfr = (Long) zzk.get(8);
            this.zzfq = (Long) zzk.get(9);
            this.zzajr = (Long) zzk.get(10);
            this.zzajs = (Long) zzk.get(11);
            this.zzajt = (Long) zzk.get(12);
        }
    }

    @Override // com.google.android.gms.internal.zzbt
    protected final HashMap<Integer, Long> zzy() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzajl);
        hashMap.put(1, this.zzajm);
        hashMap.put(2, this.zzajn);
        hashMap.put(3, this.zzfm);
        hashMap.put(4, this.zzfk);
        hashMap.put(5, this.zzajo);
        hashMap.put(6, this.zzajp);
        hashMap.put(7, this.zzajq);
        hashMap.put(8, this.zzfr);
        hashMap.put(9, this.zzfq);
        hashMap.put(10, this.zzajr);
        hashMap.put(11, this.zzajs);
        hashMap.put(12, this.zzajt);
        return hashMap;
    }
}
