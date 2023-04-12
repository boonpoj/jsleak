package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzor extends zzow {
    private Object mLock;
    private zzvj zzbuo;
    private zzvm zzbup;
    private final zzot zzbuq;
    private zzos zzbur;
    private boolean zzbus;

    private zzor(Context context, zzot zzotVar, zzcv zzcvVar, zzou zzouVar) {
        super(context, zzotVar, null, zzcvVar, null, zzouVar, null, null);
        this.zzbus = false;
        this.mLock = new Object();
        this.zzbuq = zzotVar;
    }

    public zzor(Context context, zzot zzotVar, zzcv zzcvVar, zzvj zzvjVar, zzou zzouVar) {
        this(context, zzotVar, zzcvVar, zzouVar);
        this.zzbuo = zzvjVar;
    }

    public zzor(Context context, zzot zzotVar, zzcv zzcvVar, zzvm zzvmVar, zzou zzouVar) {
        this(context, zzotVar, zzcvVar, zzouVar);
        this.zzbup = zzvmVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x002c -> B:20:0x002d). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final View zza(View.OnClickListener onClickListener, boolean z) {
        IObjectWrapper iObjectWrapper;
        synchronized (this.mLock) {
            if (this.zzbur != null) {
                return this.zzbur.zza(onClickListener, z);
            }
            try {
            } catch (RemoteException e) {
                zzagf.zzc("Failed to call getAdChoicesContent", e);
            }
            if (this.zzbuo != null) {
                iObjectWrapper = this.zzbuo.zzmk();
            } else {
                if (this.zzbup != null) {
                    iObjectWrapper = this.zzbup.zzmk();
                }
                iObjectWrapper = null;
            }
            if (iObjectWrapper != null) {
                return (View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        zzot zzotVar;
        com.google.android.gms.common.internal.zzbq.zzge("recordImpression must be called on the main UI thread.");
        synchronized (this.mLock) {
            this.zzbuw = true;
            if (this.zzbur != null) {
                this.zzbur.zza(view, map);
                this.zzbuq.recordImpression();
            } else {
                try {
                    if (this.zzbuo != null && !this.zzbuo.getOverrideImpressionRecording()) {
                        this.zzbuo.recordImpression();
                        zzotVar = this.zzbuq;
                    } else if (this.zzbup != null && !this.zzbup.getOverrideImpressionRecording()) {
                        this.zzbup.recordImpression();
                        zzotVar = this.zzbuq;
                    }
                    zzotVar.recordImpression();
                } catch (RemoteException e) {
                    zzagf.zzc("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        com.google.android.gms.common.internal.zzbq.zzge("performClick must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzbur != null) {
                this.zzbur.zza(view, map, bundle, view2);
                this.zzbuq.onAdClicked();
            } else {
                try {
                    if (this.zzbuo != null && !this.zzbuo.getOverrideClickHandling()) {
                        this.zzbuo.zzh(com.google.android.gms.dynamic.zzn.zzz(view));
                        this.zzbuq.onAdClicked();
                    }
                    if (this.zzbup != null && !this.zzbup.getOverrideClickHandling()) {
                        this.zzbup.zzh(com.google.android.gms.dynamic.zzn.zzz(view));
                        this.zzbuq.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzagf.zzc("Failed to call performClick", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzow
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.mLock) {
            this.zzbus = true;
            try {
                if (this.zzbuo != null) {
                    this.zzbuo.zzi(com.google.android.gms.dynamic.zzn.zzz(view));
                } else if (this.zzbup != null) {
                    this.zzbup.zzi(com.google.android.gms.dynamic.zzn.zzz(view));
                }
            } catch (RemoteException e) {
                zzagf.zzc("Failed to call prepareAd", e);
            }
            this.zzbus = false;
        }
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            try {
                if (this.zzbuo != null) {
                    this.zzbuo.zzj(com.google.android.gms.dynamic.zzn.zzz(view));
                } else if (this.zzbup != null) {
                    this.zzbup.zzj(com.google.android.gms.dynamic.zzn.zzz(view));
                }
            } catch (RemoteException e) {
                zzagf.zzc("Failed to call untrackView", e);
            }
        }
    }

    public final void zzc(zzos zzosVar) {
        synchronized (this.mLock) {
            this.zzbur = zzosVar;
        }
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final boolean zzkc() {
        synchronized (this.mLock) {
            if (this.zzbur != null) {
                return this.zzbur.zzkc();
            }
            return this.zzbuq.zzcw();
        }
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final boolean zzkd() {
        synchronized (this.mLock) {
            if (this.zzbur != null) {
                return this.zzbur.zzkd();
            }
            return this.zzbuq.zzcx();
        }
    }

    public final boolean zzke() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbus;
        }
        return z;
    }

    public final zzos zzkf() {
        zzos zzosVar;
        synchronized (this.mLock) {
            zzosVar = this.zzbur;
        }
        return zzosVar;
    }

    @Override // com.google.android.gms.internal.zzow
    public final zzanh zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final void zzkh() {
    }

    @Override // com.google.android.gms.internal.zzow, com.google.android.gms.internal.zzos
    public final void zzki() {
    }
}
