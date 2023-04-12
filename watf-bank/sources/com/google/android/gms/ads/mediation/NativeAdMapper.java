package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public class NativeAdMapper {
    protected View mAdChoicesContent;
    protected Bundle mExtras = new Bundle();
    protected boolean mOverrideClickHandling;
    protected boolean mOverrideImpressionRecording;
    private VideoController zzbgd;
    private View zzdnu;
    private boolean zzdnv;

    public View getAdChoicesContent() {
        return this.mAdChoicesContent;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public final boolean getOverrideClickHandling() {
        return this.mOverrideClickHandling;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.mOverrideImpressionRecording;
    }

    public final VideoController getVideoController() {
        return this.zzbgd;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzdnv;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.mAdChoicesContent = view;
    }

    public final void setExtras(Bundle bundle) {
        this.mExtras = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzdnv = z;
    }

    public void setMediaView(View view) {
        this.zzdnu = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.mOverrideClickHandling = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.mOverrideImpressionRecording = z;
    }

    public void trackView(View view) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzbgd = videoController;
    }

    public final View zzul() {
        return this.zzdnu;
    }
}
