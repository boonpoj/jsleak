package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzea extends zzet {
    public zzea(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 5);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        this.zzako.zzde = -1L;
        this.zzako.zzdf = -1L;
        int[] iArr = (int[]) this.zzakw.invoke(null, this.zzagr.getContext());
        synchronized (this.zzako) {
            this.zzako.zzde = Long.valueOf(iArr[0]);
            this.zzako.zzdf = Long.valueOf(iArr[1]);
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbnm)).booleanValue() && iArr[2] != Integer.MIN_VALUE) {
                this.zzako.zzew = Long.valueOf(iArr[2]);
            }
        }
    }
}
