package com.google.android.gms.internal;

import android.content.Context;
import android.view.TextureView;
@zzzv
/* loaded from: classes.dex */
public abstract class zzamb extends TextureView implements zzamt {
    protected final zzami zzdgp;
    protected final zzams zzdgq;

    public zzamb(Context context) {
        super(context);
        this.zzdgp = new zzami();
        this.zzdgq = new zzams(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzama zzamaVar);

    public abstract String zzri();

    public abstract void zzrm();
}
