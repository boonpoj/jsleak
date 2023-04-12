package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
@zzzv
/* loaded from: classes.dex */
public final class zzajq {
    private final View mView;
    private boolean zzbbh;
    private Activity zzddm;
    private boolean zzddn;
    private boolean zzddo;
    private ViewTreeObserver.OnGlobalLayoutListener zzddp;
    private ViewTreeObserver.OnScrollChangedListener zzddq;

    public zzajq(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzddm = activity;
        this.mView = view;
        this.zzddp = onGlobalLayoutListener;
        this.zzddq = onScrollChangedListener;
    }

    private final void zzqw() {
        if (this.zzddn) {
            return;
        }
        if (this.zzddp != null) {
            if (this.zzddm != null) {
                com.google.android.gms.ads.internal.zzbs.zzei();
                zzahn.zza(this.zzddm, this.zzddp);
            }
            com.google.android.gms.ads.internal.zzbs.zzfc();
            zzaln.zza(this.mView, this.zzddp);
        }
        if (this.zzddq != null) {
            if (this.zzddm != null) {
                com.google.android.gms.ads.internal.zzbs.zzei();
                zzahn.zza(this.zzddm, this.zzddq);
            }
            com.google.android.gms.ads.internal.zzbs.zzfc();
            zzaln.zza(this.mView, this.zzddq);
        }
        this.zzddn = true;
    }

    private final void zzqx() {
        Activity activity = this.zzddm;
        if (activity != null && this.zzddn) {
            if (this.zzddp != null && activity != null) {
                com.google.android.gms.ads.internal.zzbs.zzek().zzb(this.zzddm, this.zzddp);
            }
            if (this.zzddq != null && this.zzddm != null) {
                com.google.android.gms.ads.internal.zzbs.zzei();
                zzahn.zzb(this.zzddm, this.zzddq);
            }
            this.zzddn = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzddo = true;
        if (this.zzbbh) {
            zzqw();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzddo = false;
        zzqx();
    }

    public final void zzi(Activity activity) {
        this.zzddm = activity;
    }

    public final void zzqu() {
        this.zzbbh = true;
        if (this.zzddo) {
            zzqw();
        }
    }

    public final void zzqv() {
        this.zzbbh = false;
        zzqx();
    }
}
