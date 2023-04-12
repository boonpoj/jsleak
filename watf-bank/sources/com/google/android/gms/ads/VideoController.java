package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object mLock = new Object();
    private zzll zzamc;
    private VideoLifecycleCallbacks zzamd;

    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final float getAspectRatio() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return 0.0f;
            }
            try {
                return this.zzamc.getAspectRatio();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final int getPlaybackState() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return 0;
            }
            try {
                return this.zzamc.getPlaybackState();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.mLock) {
            videoLifecycleCallbacks = this.zzamd;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzamc != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return false;
            }
            try {
                return this.zzamc.isClickToExpandEnabled();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return false;
            }
            try {
                return this.zzamc.isCustomControlsEnabled();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return true;
            }
            try {
                return this.zzamc.isMuted();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return;
            }
            try {
                this.zzamc.mute(z);
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call mute on video controller.", e);
            }
        }
    }

    public final void pause() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return;
            }
            try {
                this.zzamc.pause();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call pause on video controller.", e);
            }
        }
    }

    public final void play() {
        synchronized (this.mLock) {
            if (this.zzamc == null) {
                return;
            }
            try {
                this.zzamc.play();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call play on video controller.", e);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzbq.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.mLock) {
            this.zzamd = videoLifecycleCallbacks;
            if (this.zzamc == null) {
                return;
            }
            try {
                this.zzamc.zza(new zzmq(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final void zza(zzll zzllVar) {
        synchronized (this.mLock) {
            this.zzamc = zzllVar;
            if (this.zzamd != null) {
                setVideoLifecycleCallbacks(this.zzamd);
            }
        }
    }

    public final zzll zzbj() {
        zzll zzllVar;
        synchronized (this.mLock) {
            zzllVar = this.zzamc;
        }
        return zzllVar;
    }
}
