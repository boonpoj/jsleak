package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznv extends zzny {
    private final com.google.android.gms.ads.internal.zzae zzbsu;
    private final String zzbsv;
    private final String zzbsw;

    public zznv(com.google.android.gms.ads.internal.zzae zzaeVar, String str, String str2) {
        this.zzbsu = zzaeVar;
        this.zzbsv = str;
        this.zzbsw = str2;
    }

    @Override // com.google.android.gms.internal.zznx
    public final String getContent() {
        return this.zzbsw;
    }

    @Override // com.google.android.gms.internal.zznx
    public final void recordClick() {
        this.zzbsu.zzcs();
    }

    @Override // com.google.android.gms.internal.zznx
    public final void recordImpression() {
        this.zzbsu.zzct();
    }

    @Override // com.google.android.gms.internal.zznx
    public final void zze(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzbsu.zzh((View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zznx
    public final String zzjj() {
        return this.zzbsv;
    }
}
