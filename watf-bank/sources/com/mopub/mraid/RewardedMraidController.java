package com.mopub.mraid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.IntentActions;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mobileads.RewardedMraidCountdownRunnable;
import com.mopub.mobileads.VastVideoRadialCountdownWidget;
/* loaded from: assets/classes2.dex */
public class RewardedMraidController extends MraidController {
    public static final int DEFAULT_PLAYABLE_DURATION_FOR_CLOSE_BUTTON_SECONDS = 30;
    public static final boolean DEFAULT_PLAYABLE_SHOULD_REWARD_ON_CLICK = false;
    public static final int MILLIS_IN_SECOND = 1000;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private CloseableLayout f1392;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private VastVideoRadialCountdownWidget f1393;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private RewardedMraidCountdownRunnable f1394;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f1395;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final long f1396;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1397;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1398;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f1399;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f1400;

    @VisibleForTesting
    public RewardedMraidController(@NonNull Context context, @Nullable AdReport adReport, @NonNull PlacementType placementType, int i, long j) {
        super(context, adReport, placementType);
        int i2 = i * 1000;
        if (i2 < 0 || i2 > 30000) {
            this.f1395 = 30000;
        } else {
            this.f1395 = i2;
        }
        this.f1396 = j;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1235(@NonNull Context context, int i) {
        this.f1393 = new VastVideoRadialCountdownWidget(context);
        this.f1393.setVisibility(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1393.getLayoutParams();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams.width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
        layoutParams.gravity = 53;
        this.f1392.addView(this.f1393, layoutParams);
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m1236() {
        this.f1394.startRepeating(250L);
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private void m1237() {
        this.f1394.stop();
    }

    public boolean backButtonEnabled() {
        return this.f1398;
    }

    public void create(@NonNull Context context, CloseableLayout closeableLayout) {
        this.f1392 = closeableLayout;
        this.f1392.setCloseAlwaysInteractable(false);
        this.f1392.setCloseVisible(false);
        m1235(context, 4);
        this.f1393.calibrateAndMakeVisible(this.f1395);
        this.f1399 = true;
        this.f1394 = new RewardedMraidCountdownRunnable(this, new Handler(Looper.getMainLooper()));
    }

    @Override // com.mopub.mraid.MraidController
    public void destroy() {
        m1237();
        super.destroy();
    }

    @VisibleForTesting
    @Deprecated
    public RewardedMraidCountdownRunnable getCountdownRunnable() {
        return this.f1394;
    }

    @VisibleForTesting
    @Deprecated
    public VastVideoRadialCountdownWidget getRadialCountdownWidget() {
        return this.f1393;
    }

    @VisibleForTesting
    @Deprecated
    public int getShowCloseButtonDelay() {
        return this.f1395;
    }

    @VisibleForTesting
    @Deprecated
    public boolean isCalibrationDone() {
        return this.f1399;
    }

    public boolean isPlayableCloseable() {
        return !this.f1398 && this.f1397 >= this.f1395;
    }

    @VisibleForTesting
    @Deprecated
    public boolean isRewarded() {
        return this.f1400;
    }

    @VisibleForTesting
    @Deprecated
    public boolean isShowCloseButtonEventFired() {
        return this.f1398;
    }

    public void pause() {
        m1237();
        super.pause(false);
    }

    @Override // com.mopub.mraid.MraidController
    public void resume() {
        super.resume();
        m1236();
    }

    public void showPlayableCloseButton() {
        this.f1398 = true;
        this.f1393.setVisibility(8);
        this.f1392.setCloseVisible(true);
        if (this.f1400) {
            return;
        }
        BaseBroadcastReceiver.broadcastAction(getContext(), this.f1396, IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE);
        this.f1400 = true;
    }

    public void updateCountdown(int i) {
        this.f1397 = i;
        if (this.f1399) {
            this.f1393.updateCountdownProgress(this.f1395, this.f1397);
        }
    }

    @Override // com.mopub.mraid.MraidController
    /* renamed from: ࢠ */
    protected void mo1183(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mraid.MraidController
    /* renamed from: ࢣ */
    public void mo1191() {
        if (this.f1398) {
            super.mo1191();
        }
    }
}
