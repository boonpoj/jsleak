package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzeh extends zzet {
    private static volatile String zzdb = null;
    private static final Object zzakl = new Object();

    public zzeh(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 1);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        this.zzako.zzdb = "E";
        if (zzdb == null) {
            synchronized (zzakl) {
                if (zzdb == null) {
                    zzdb = (String) this.zzakw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzako) {
            this.zzako.zzdb = zzdb;
        }
    }
}
