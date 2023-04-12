package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mraid.RewardedMraidController;
/* loaded from: assets/classes2.dex */
public class RewardedMraidCountdownRunnable extends RepeatingHandlerRunnable {
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final RewardedMraidController f971;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f972;

    public RewardedMraidCountdownRunnable(@NonNull RewardedMraidController rewardedMraidController, @NonNull Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(rewardedMraidController);
        this.f971 = rewardedMraidController;
    }

    @Override // com.mopub.mobileads.RepeatingHandlerRunnable
    public void doWork() {
        this.f972 = (int) (this.f972 + this.f958);
        this.f971.updateCountdown(this.f972);
        if (this.f971.isPlayableCloseable()) {
            this.f971.showPlayableCloseButton();
        }
    }
}
