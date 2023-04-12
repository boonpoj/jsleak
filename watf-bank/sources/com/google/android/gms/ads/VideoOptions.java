package com.google.android.gms.ads;

import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class VideoOptions {
    private final boolean zzame;
    private final boolean zzamf;
    private final boolean zzamg;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzame = true;
        private boolean zzamf = false;
        private boolean zzamg = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzamg = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzamf = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzame = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzame = builder.zzame;
        this.zzamf = builder.zzamf;
        this.zzamg = builder.zzamg;
    }

    public VideoOptions(zzmr zzmrVar) {
        this.zzame = zzmrVar.zzbgx;
        this.zzamf = zzmrVar.zzbgy;
        this.zzamg = zzmrVar.zzbgz;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzamg;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzamf;
    }

    public final boolean getStartMuted() {
        return this.zzame;
    }
}
