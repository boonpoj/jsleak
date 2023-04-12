package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
@zzzv
/* loaded from: classes.dex */
public final class zzyt {
    private final Context mContext;
    private final zznu zzanj;
    private final zzcv zzbuv;
    private final zzafp zzcjk;
    private final com.google.android.gms.ads.internal.zzba zzclf;
    private ViewTreeObserver.OnGlobalLayoutListener zzclg;
    private ViewTreeObserver.OnScrollChangedListener zzclh;
    private final Object mLock = new Object();
    private int zzavb = -1;
    private int zzavc = -1;
    private zzaji zzavd = new zzaji(200);

    public zzyt(Context context, zzcv zzcvVar, zzafp zzafpVar, zznu zznuVar, com.google.android.gms.ads.internal.zzba zzbaVar) {
        this.mContext = context;
        this.zzbuv = zzcvVar;
        this.zzcjk = zzafpVar;
        this.zzanj = zznuVar;
        this.zzclf = zzbaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener zza(WeakReference<zzanh> weakReference) {
        if (this.zzclg == null) {
            this.zzclg = new zzyz(this, weakReference);
        }
        return this.zzclg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(WeakReference<zzanh> weakReference, boolean z) {
        zzanh zzanhVar;
        if (weakReference == null || (zzanhVar = weakReference.get()) == null) {
            return;
        }
        if (zzanhVar == null) {
            throw null;
        }
        View view = (View) zzanhVar;
        if (view == null) {
            return;
        }
        if (!z || this.zzavd.tryAcquire()) {
            if (zzanhVar == null) {
                throw null;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            zzkb.zzia();
            int zzd = zzajr.zzd(this.mContext, iArr[0]);
            zzkb.zzia();
            int zzd2 = zzajr.zzd(this.mContext, iArr[1]);
            synchronized (this.mLock) {
                if (this.zzavb != zzd || this.zzavc != zzd2) {
                    this.zzavb = zzd;
                    this.zzavc = zzd2;
                    zzanhVar.zzsz().zza(this.zzavb, this.zzavc, z ? false : true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnScrollChangedListener zzb(WeakReference<zzanh> weakReference) {
        if (this.zzclh == null) {
            this.zzclh = new zzza(this, weakReference);
        }
        return this.zzclh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(zzanh zzanhVar) {
        zzani zzsz = zzanhVar.zzsz();
        zzsz.zza("/video", com.google.android.gms.ads.internal.gmsg.zzd.zzbxi);
        zzsz.zza("/videoMeta", com.google.android.gms.ads.internal.gmsg.zzd.zzbxj);
        zzsz.zza("/precache", new zzane());
        zzsz.zza("/delayPageLoaded", com.google.android.gms.ads.internal.gmsg.zzd.zzbxm);
        zzsz.zza("/instrument", com.google.android.gms.ads.internal.gmsg.zzd.zzbxk);
        zzsz.zza("/log", com.google.android.gms.ads.internal.gmsg.zzd.zzbxd);
        zzsz.zza("/videoClicked", com.google.android.gms.ads.internal.gmsg.zzd.zzbxe);
        zzsz.zza("/trackActiveViewUnit", new zzyx(this));
        zzsz.zza("/untrackActiveViewUnit", new zzyy(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzanh zznj() throws zzanv {
        return com.google.android.gms.ads.internal.zzbs.zzej().zza(this.mContext, zzapa.zzuf(), "native-video", false, false, this.zzbuv, this.zzcjk.zzcqv.zzaty, this.zzanj, null, this.zzclf.zzbq(), this.zzcjk.zzcxw);
    }
}
