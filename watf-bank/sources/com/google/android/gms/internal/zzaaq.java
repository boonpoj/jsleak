package com.google.android.gms.internal;

import android.content.Context;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaaq extends zzaan {
    private final Context mContext;

    public zzaaq(Context context, zzalh<zzaat> zzalhVar, zzaal zzaalVar) {
        super(zzalhVar, zzaalVar);
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzaan
    public final void zznk() {
    }

    @Override // com.google.android.gms.internal.zzaan
    public final zzabb zznl() {
        Context context = this.mContext;
        return zzacb.zza(context, zzaca.zzk(context));
    }
}
