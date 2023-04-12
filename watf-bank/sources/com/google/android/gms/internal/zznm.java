package com.google.android.gms.internal;

import android.text.TextUtils;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznm {
    public static zznk zza(zznj zznjVar) {
        if (!zznjVar.zziy()) {
            zzagf.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zznjVar.getContext() != null) {
            if (TextUtils.isEmpty(zznjVar.zzfs())) {
                throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
            }
            return new zznk(zznjVar.getContext(), zznjVar.zzfs(), zznjVar.zziz(), zznjVar.zzja());
        } else {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
    }
}
