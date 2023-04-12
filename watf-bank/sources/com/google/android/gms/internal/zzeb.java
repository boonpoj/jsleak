package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzeb extends zzet {
    private static volatile Long zzei = null;
    private static final Object zzakl = new Object();

    public zzeb(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 44);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (zzei == null) {
            synchronized (zzakl) {
                if (zzei == null) {
                    zzei = (Long) this.zzakw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzako) {
            this.zzako.zzei = zzei;
        }
    }
}
