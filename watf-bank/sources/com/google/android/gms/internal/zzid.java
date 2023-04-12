package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzid {
    private Context mContext;
    private zzik zzbau;
    private zzio zzbav;
    private final Runnable zzbat = new zzie(this);
    private final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.mLock) {
            if (this.mContext != null && this.zzbau == null) {
                this.zzbau = new zzik(this.mContext, com.google.android.gms.ads.internal.zzbs.zzew().zzqs(), new zzig(this), new zzih(this));
                this.zzbau.zzakj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbau == null) {
                return;
            }
            if (this.zzbau.isConnected() || this.zzbau.isConnecting()) {
                this.zzbau.disconnect();
            }
            this.zzbau = null;
            this.zzbav = null;
            Binder.flushPendingCommands();
        }
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mContext != null) {
                return;
            }
            this.mContext = context.getApplicationContext();
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbqh)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbqg)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzbs.zzel().zza(new zzif(this));
                }
            }
        }
    }

    public final zzii zza(zzil zzilVar) {
        synchronized (this.mLock) {
            if (this.zzbav == null) {
                return new zzii();
            }
            try {
                return this.zzbav.zza(zzilVar);
            } catch (RemoteException e) {
                zzagf.zzb("Unable to call into cache service.", e);
                return new zzii();
            }
        }
    }

    public final void zzhe() {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbqi)).booleanValue()) {
            synchronized (this.mLock) {
                connect();
                com.google.android.gms.ads.internal.zzbs.zzei();
                zzahn.zzdaw.removeCallbacks(this.zzbat);
                com.google.android.gms.ads.internal.zzbs.zzei();
                zzahn.zzdaw.postDelayed(this.zzbat, ((Long) zzkb.zzif().zzd(zznh.zzbqj)).longValue());
            }
        }
    }
}
