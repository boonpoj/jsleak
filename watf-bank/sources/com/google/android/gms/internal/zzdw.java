package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdw extends zzet {
    private final Activity zzaki;
    private final View zzakj;

    public zzdw(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2, View view, Activity activity) {
        super(zzdmVar, str, str2, zzazVar, i, 62);
        this.zzakj = view;
        this.zzaki = activity;
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (this.zzakj == null) {
            return;
        }
        long[] jArr = (long[]) this.zzakw.invoke(null, this.zzakj, this.zzaki);
        synchronized (this.zzako) {
            this.zzako.zzez = Long.valueOf(jArr[0]);
            this.zzako.zzfa = Long.valueOf(jArr[1]);
        }
    }
}
