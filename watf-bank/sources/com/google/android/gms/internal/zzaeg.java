package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
@zzzv
/* loaded from: classes.dex */
public final class zzaeg extends zzaen {
    private volatile zzaeh zzcvg;
    private volatile zzaee zzcvs;
    private volatile zzaef zzcvt;

    public zzaeg(zzaef zzaefVar) {
        this.zzcvt = zzaefVar;
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zza(IObjectWrapper iObjectWrapper, zzaeq zzaeqVar) {
        if (this.zzcvt != null) {
            this.zzcvt.zzc(zzaeqVar);
        }
    }

    public final void zza(zzaee zzaeeVar) {
        this.zzcvs = zzaeeVar;
    }

    public final void zza(zzaeh zzaehVar) {
        this.zzcvg = zzaehVar;
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzcvs != null) {
            this.zzcvs.zzaa(i);
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzcvg != null) {
            this.zzcvg.zza(com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzm(IObjectWrapper iObjectWrapper) {
        if (this.zzcvs != null) {
            this.zzcvs.zzof();
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (this.zzcvg != null) {
            this.zzcvg.zzbr(com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper).getClass().getName());
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (this.zzcvt != null) {
            this.zzcvt.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzp(IObjectWrapper iObjectWrapper) {
        if (this.zzcvt != null) {
            this.zzcvt.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (this.zzcvt != null) {
            this.zzcvt.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzr(IObjectWrapper iObjectWrapper) {
        if (this.zzcvt != null) {
            this.zzcvt.zzoc();
        }
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzs(IObjectWrapper iObjectWrapper) {
        if (this.zzcvt != null) {
            this.zzcvt.onRewardedVideoAdLeftApplication();
        }
    }
}
