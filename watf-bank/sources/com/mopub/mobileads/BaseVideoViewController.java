package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
/* loaded from: assets/classes2.dex */
public abstract class BaseVideoViewController {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f794;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final RelativeLayout f795;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final BaseVideoViewControllerListener f796;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Long f797;

    /* loaded from: assets/classes2.dex */
    public interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseVideoViewController(Context context, @Nullable Long l, @NonNull BaseVideoViewControllerListener baseVideoViewControllerListener) {
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        this.f794 = context;
        this.f797 = l;
        this.f796 = baseVideoViewControllerListener;
        this.f795 = new RelativeLayout(this.f794);
    }

    public boolean backButtonEnabled() {
        return true;
    }

    public ViewGroup getLayout() {
        return this.f795;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo718() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f795.addView(mo724(), 0, layoutParams);
        this.f796.onSetContentView(this.f795);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo719(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public abstract void mo720(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public abstract void mo721(@NonNull Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m722(String str) {
        if (this.f797 != null) {
            BaseBroadcastReceiver.broadcastAction(this.f794, this.f797.longValue(), str);
        } else {
            MoPubLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m723(boolean z) {
        MoPubLog.e("Video cannot be played.");
        m722(IntentActions.ACTION_INTERSTITIAL_FAIL);
        if (z) {
            this.f796.onFinish();
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected abstract VideoView mo724();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m725(boolean z) {
        if (z) {
            this.f796.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public abstract void mo726();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public abstract void mo727();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public abstract void mo728();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public abstract void mo729();

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    /* renamed from: ࢧ  reason: contains not printable characters */
    public BaseVideoViewControllerListener m730() {
        return this.f796;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public Context m731() {
        return this.f794;
    }
}
