package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzei extends zzet {
    public zzei(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 3);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzako) {
            zzcz zzczVar = new zzcz((String) this.zzakw.invoke(null, this.zzagr.getContext()));
            synchronized (this.zzako) {
                this.zzako.zzdc = Long.valueOf(zzczVar.zzaig);
                this.zzako.zzex = Long.valueOf(zzczVar.zzaih);
            }
        }
    }
}
