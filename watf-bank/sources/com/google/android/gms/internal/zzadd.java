package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzv
/* loaded from: classes.dex */
public final class zzadd extends zzadl {
    private final Context mContext;
    private final Object mLock;
    private final zzakd zzapr;
    private final zzade zzcux;

    public zzadd(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzux zzuxVar, zzakd zzakdVar) {
        this(context, zzakdVar, new zzade(context, zzvVar, zzjn.zzhs(), zzuxVar, zzakdVar));
    }

    private zzadd(Context context, zzakd zzakdVar, zzade zzadeVar) {
        this.mLock = new Object();
        this.mContext = context;
        this.zzapr = zzakdVar;
        this.zzcux = zzadeVar;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void destroy() {
        zzd(null);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final String getMediationAdapterClassName() {
        String mediationAdapterClassName;
        synchronized (this.mLock) {
            mediationAdapterClassName = this.zzcux.getMediationAdapterClassName();
        }
        return mediationAdapterClassName;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.mLock) {
            isLoaded = this.zzcux.isLoaded();
        }
        return isLoaded;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void pause() {
        zzb(null);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void resume() {
        zzc(null);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            this.zzcux.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzcux.setUserId(str);
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void show() {
        synchronized (this.mLock) {
            this.zzcux.zzob();
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadp zzadpVar) {
        synchronized (this.mLock) {
            this.zzcux.zza(zzadpVar);
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadv zzadvVar) {
        synchronized (this.mLock) {
            this.zzcux.zza(zzadvVar);
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzb(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcux.pause();
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzc(IObjectWrapper iObjectWrapper) {
        Context context;
        synchronized (this.mLock) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                try {
                    context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
                } catch (Exception e) {
                    zzagf.zzc("Unable to extract updated context.", e);
                }
            }
            if (context != null) {
                this.zzcux.onContextChanged(context);
            }
            this.zzcux.resume();
        }
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzd(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcux.destroy();
        }
    }
}
