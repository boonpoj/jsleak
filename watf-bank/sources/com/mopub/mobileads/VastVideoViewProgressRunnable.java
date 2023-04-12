package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.ExternalViewabilitySession;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable {
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final VastVideoViewController f1148;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final VastVideoConfig f1149;

    public VastVideoViewProgressRunnable(@NonNull VastVideoViewController vastVideoViewController, @NonNull VastVideoConfig vastVideoConfig, @NonNull Handler handler) {
        super(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        Preconditions.checkNotNull(vastVideoConfig);
        this.f1148 = vastVideoViewController;
        this.f1149 = vastVideoConfig;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VastFractionalProgressTracker(VastTracker.EnumC0210.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_STARTED.name(), 0.0f));
        arrayList.add(new VastFractionalProgressTracker(VastTracker.EnumC0210.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_IMPRESSED.name(), 0.0f));
        arrayList.add(new VastFractionalProgressTracker(VastTracker.EnumC0210.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_FIRST_QUARTILE.name(), 0.25f));
        arrayList.add(new VastFractionalProgressTracker(VastTracker.EnumC0210.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_MIDPOINT.name(), 0.5f));
        arrayList.add(new VastFractionalProgressTracker(VastTracker.EnumC0210.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_THIRD_QUARTILE.name(), 0.75f));
        this.f1149.addFractionalTrackers(arrayList);
    }

    @Override // com.mopub.mobileads.RepeatingHandlerRunnable
    public void doWork() {
        int m968 = this.f1148.m968();
        int m969 = this.f1148.m969();
        this.f1148.m960();
        if (m968 > 0) {
            List<VastTracker> untriggeredTrackersBefore = this.f1149.getUntriggeredTrackersBefore(m969, m968);
            if (!untriggeredTrackersBefore.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (VastTracker vastTracker : untriggeredTrackersBefore) {
                    if (vastTracker.getMessageType() == VastTracker.EnumC0210.TRACKING_URL) {
                        arrayList.add(vastTracker.getContent());
                    } else if (vastTracker.getMessageType() == VastTracker.EnumC0210.QUARTILE_EVENT) {
                        this.f1148.m967(vastTracker.getContent());
                    }
                    vastTracker.setTracked();
                }
                TrackingRequest.makeTrackingHttpRequest(new VastMacroHelper(arrayList).withAssetUri(this.f1148.m961()).withContentPlayHead(Integer.valueOf(m969)).getUris(), this.f1148.m731());
            }
            this.f1148.m966(m969);
        }
    }
}
