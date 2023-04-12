package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
@zzzv
/* loaded from: classes.dex */
public final class zzyf extends zzyc {
    private Object zzcjt;
    private PopupWindow zzcju;
    private boolean zzcjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyf(Context context, zzafp zzafpVar, zzanh zzanhVar, zzyb zzybVar) {
        super(context, zzafpVar, zzanhVar, zzybVar);
        this.zzcjt = new Object();
        this.zzcjv = false;
    }

    private final void zznf() {
        synchronized (this.zzcjt) {
            this.zzcjv = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzcju = null;
            }
            if (this.zzcju != null) {
                if (this.zzcju.isShowing()) {
                    this.zzcju.dismiss();
                }
                this.zzcju = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxu, com.google.android.gms.internal.zzaif
    public final void cancel() {
        zznf();
        super.cancel();
    }

    @Override // com.google.android.gms.internal.zzyc
    protected final void zzne() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar == null) {
            throw null;
        }
        frameLayout.addView((View) zzanhVar, -1, -1);
        synchronized (this.zzcjt) {
            if (this.zzcjv) {
                return;
            }
            this.zzcju = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzcju.setOutsideTouchable(true);
            this.zzcju.setClippingEnabled(false);
            zzagf.zzbx("Displaying the 1x1 popup off the screen.");
            try {
                this.zzcju.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception e) {
                this.zzcju = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzxu
    public final void zzx(int i) {
        zznf();
        super.zzx(i);
    }
}
