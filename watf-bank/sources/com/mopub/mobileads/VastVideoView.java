package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
/* loaded from: assets/classes2.dex */
public class VastVideoView extends VideoView {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private VastVideoBlurLastVideoFrameTask f1091;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private MediaMetadataRetriever f1092;

    public VastVideoView(@NonNull Context context) {
        super(context);
        Preconditions.checkNotNull(context, "context cannot be null");
        this.f1092 = new MediaMetadataRetriever();
    }

    @Nullable
    @VisibleForTesting
    @Deprecated
    VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask() {
        return this.f1091;
    }

    public void onDestroy() {
        if (this.f1091 == null || this.f1091.getStatus() == AsyncTask.Status.FINISHED) {
            return;
        }
        this.f1091.cancel(true);
    }

    public void prepareBlurredLastVideoFrame(@NonNull ImageView imageView, @NonNull String str) {
        if (this.f1092 != null) {
            this.f1091 = new VastVideoBlurLastVideoFrameTask(this.f1092, imageView, getDuration());
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f1091, str);
            } catch (Exception e) {
                MoPubLog.d("Failed to blur last video frame", e);
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    void setBlurLastVideoFrameTask(@NonNull VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask) {
        this.f1091 = vastVideoBlurLastVideoFrameTask;
    }

    @VisibleForTesting
    @Deprecated
    void setMediaMetadataRetriever(@NonNull MediaMetadataRetriever mediaMetadataRetriever) {
        this.f1092 = mediaMetadataRetriever;
    }
}
