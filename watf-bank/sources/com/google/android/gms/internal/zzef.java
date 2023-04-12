package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzef extends zzet {
    private static volatile Long zzakp = null;
    private static final Object zzakl = new Object();

    public zzef(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 22);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (zzakp == null) {
            synchronized (zzakl) {
                if (zzakp == null) {
                    zzakp = (Long) this.zzakw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzako) {
            this.zzako.zzdu = zzakp;
        }
    }
}
