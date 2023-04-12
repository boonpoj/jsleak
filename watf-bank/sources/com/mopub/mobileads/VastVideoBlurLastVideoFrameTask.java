package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;
/* loaded from: assets/classes2.dex */
public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final MediaMetadataRetriever f1019;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ImageView f1020;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f1021;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Bitmap f1022;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Bitmap f1023;

    public VastVideoBlurLastVideoFrameTask(@NonNull MediaMetadataRetriever mediaMetadataRetriever, @NonNull ImageView imageView, int i) {
        this.f1019 = mediaMetadataRetriever;
        this.f1020 = imageView;
        this.f1021 = i;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        MoPubLog.d("VastVideoBlurLastVideoFrameTask was cancelled.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Boolean doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return false;
        }
        try {
            this.f1019.setDataSource(strArr[0]);
            this.f1022 = this.f1019.getFrameAtTime((this.f1021 * 1000) - 200000, 3);
            if (this.f1022 == null) {
                return false;
            }
            this.f1023 = ImageUtils.applyFastGaussianBlurToBitmap(this.f1022, 4);
            return true;
        } catch (Exception e) {
            MoPubLog.d("Failed to blur last video frame", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(Boolean bool) {
        if (isCancelled()) {
            onCancelled();
        } else if (bool == null || !bool.booleanValue()) {
        } else {
            this.f1020.setImageBitmap(this.f1023);
            this.f1020.setImageAlpha(100);
        }
    }
}
