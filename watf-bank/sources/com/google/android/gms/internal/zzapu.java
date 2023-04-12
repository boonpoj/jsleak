package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzapz;
/* loaded from: assets/classes2.dex */
public class zzapu extends com.google.android.gms.common.internal.zzf<zzapz> {
    public zzapu(Context context, Looper looper, zzf.zzb zzbVar, zzf.zzc zzcVar) {
        super(context, looper, 116, zzbVar, zzcVar, null);
    }

    public zzapz zzFX() throws DeadObjectException {
        return (zzapz) super.zzwW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: zzcT */
    public zzapz zzh(IBinder iBinder) {
        return zzapz.zza.zzcU(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.gass.START";
    }

    protected String zzev() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
