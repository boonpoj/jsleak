package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public abstract boolean onIsPlaying();

    public abstract void onPause();

    public abstract void onSeekTo(long j);

    public abstract void onStart();

    public abstract void onStop();

    public int onGetBufferPercentage() {
        return 100;
    }

    public int onGetTransportControlFlags() {
        return 60;
    }

    public boolean onMediaButtonDown(int keyCode, KeyEvent event) {
        if (keyCode == 79 || keyCode == 85) {
            if (onIsPlaying()) {
                onPause();
            } else {
                onStart();
            }
        } else if (keyCode == 86) {
            onStop();
            return true;
        } else if (keyCode == 126) {
            onStart();
            return true;
        } else if (keyCode == 127) {
            onPause();
            return true;
        }
        return true;
    }

    public boolean onMediaButtonUp(int keyCode, KeyEvent event) {
        return true;
    }

    public void onAudioFocusChange(int focusChange) {
        int keyCode = 0;
        if (focusChange == -1) {
            keyCode = TransportMediator.KEYCODE_MEDIA_PAUSE;
        }
        if (keyCode != 0) {
            long now = SystemClock.uptimeMillis();
            int i = keyCode;
            onMediaButtonDown(keyCode, new KeyEvent(now, now, 0, i, 0));
            onMediaButtonUp(keyCode, new KeyEvent(now, now, 1, i, 0));
        }
    }
}
