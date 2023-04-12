package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdy extends zzet {
    private static volatile String zzakk = null;
    private static final Object zzakl = new Object();

    public zzdy(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 29);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        this.zzako.zzdw = "E";
        if (zzakk == null) {
            synchronized (zzakl) {
                if (zzakk == null) {
                    zzakk = (String) this.zzakw.invoke(null, this.zzagr.getContext());
                }
            }
        }
        synchronized (this.zzako) {
            this.zzako.zzdw = zzbu.zza(zzakk.getBytes(), true);
        }
    }
}
