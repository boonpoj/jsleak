package com.google.android.gms.internal;

import android.content.Context;
import android.media.AudioManager;
@zzzv
/* loaded from: classes.dex */
public final class zzams implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager mAudioManager;
    private boolean zzdgx;
    private final zzamt zzdjr;
    private boolean zzdjs;
    private boolean zzdjt;
    private float zzdju = 1.0f;

    public zzams(Context context, zzamt zzamtVar) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.zzdjr = zzamtVar;
    }

    private final void zzsq() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzdgx && !this.zzdjt && this.zzdju > 0.0f;
        if (z3 && !(z2 = this.zzdjs)) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null && !z2) {
                this.zzdjs = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzdjr.zzrm();
        } else if (z3 || !(z = this.zzdjs)) {
        } else {
            AudioManager audioManager2 = this.mAudioManager;
            if (audioManager2 != null && z) {
                this.zzdjs = audioManager2.abandonAudioFocus(this) == 0;
            }
            this.zzdjr.zzrm();
        }
    }

    public final float getVolume() {
        float f = this.zzdjt ? 0.0f : this.zzdju;
        if (this.zzdjs) {
            return f;
        }
        return 0.0f;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzdjs = i > 0;
        this.zzdjr.zzrm();
    }

    public final void setMuted(boolean z) {
        this.zzdjt = z;
        zzsq();
    }

    public final void zzb(float f) {
        this.zzdju = f;
        zzsq();
    }

    public final void zzsn() {
        this.zzdgx = true;
        zzsq();
    }

    public final void zzso() {
        this.zzdgx = false;
        zzsq();
    }
}
