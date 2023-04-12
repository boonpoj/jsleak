package com.mopub.nativeads;

import android.view.View;
/* loaded from: assets/classes2.dex */
public interface ImpressionInterface {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
