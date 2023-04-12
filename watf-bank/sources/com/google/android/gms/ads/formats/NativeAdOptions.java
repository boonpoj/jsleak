package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzamh;
    private final int zzami;
    private final boolean zzamj;
    private final int zzamk;
    private final VideoOptions zzaml;

    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzamh = false;
        private int zzami = -1;
        private boolean zzamj = false;
        private int zzamk = 1;
        private VideoOptions zzaml;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(int i) {
            this.zzamk = i;
            return this;
        }

        public final Builder setImageOrientation(int i) {
            this.zzami = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzamj = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzamh = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzaml = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzamh = builder.zzamh;
        this.zzami = builder.zzami;
        this.zzamj = builder.zzamj;
        this.zzamk = builder.zzamk;
        this.zzaml = builder.zzaml;
    }

    public final int getAdChoicesPlacement() {
        return this.zzamk;
    }

    public final int getImageOrientation() {
        return this.zzami;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzaml;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzamj;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzamh;
    }
}
