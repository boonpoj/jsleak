package com.mopub.mobileads.factories;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;
/* loaded from: assets/classes2.dex */
public class MraidControllerFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static MraidControllerFactory f1181 = new MraidControllerFactory();

    public static MraidController create(@NonNull Context context, @NonNull AdReport adReport, @NonNull PlacementType placementType) {
        return f1181.m1006(context, adReport, placementType);
    }

    @VisibleForTesting
    public static void setInstance(MraidControllerFactory mraidControllerFactory) {
        f1181 = mraidControllerFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected MraidController m1006(@NonNull Context context, @NonNull AdReport adReport, @NonNull PlacementType placementType) {
        return new MraidController(context, adReport, placementType);
    }
}
