package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzec extends zzet {
    private long startTime;

    public zzec(zzdm zzdmVar, String str, String str2, zzaz zzazVar, long j, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzakw.invoke(null, new Object[0])).longValue();
        synchronized (this.zzako) {
            this.zzako.zzfh = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzako.zzdq = Long.valueOf(longValue - this.startTime);
                this.zzako.zzdv = Long.valueOf(this.startTime);
            }
        }
    }
}
