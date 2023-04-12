package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.BaseVideoViewController;
/* loaded from: assets/classes2.dex */
public class MraidVideoViewController extends BaseVideoViewController {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final VideoView f1383;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ImageButton f1384;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f1385;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f1386;

    public MraidVideoViewController(Context context, Bundle bundle, Bundle bundle2, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, null, baseVideoViewControllerListener);
        this.f1383 = new VideoView(context);
        this.f1383.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.mopub.mraid.MraidVideoViewController.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                MraidVideoViewController.this.f1384.setVisibility(0);
                MraidVideoViewController.this.m725(true);
            }
        });
        this.f1383.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.mopub.mraid.MraidVideoViewController.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                MraidVideoViewController.this.f1384.setVisibility(0);
                MraidVideoViewController.this.m723(false);
                return false;
            }
        });
        this.f1383.setVideoPath(bundle.getString(BaseVideoPlayerActivity.VIDEO_URL));
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m1231() {
        this.f1384 = new ImageButton(m731());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(m731()));
        stateListDrawable.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(m731()));
        this.f1384.setImageDrawable(stateListDrawable);
        this.f1384.setBackgroundDrawable(null);
        this.f1384.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.mraid.MraidVideoViewController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MraidVideoViewController.this.m730().onFinish();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1386, this.f1386);
        layoutParams.addRule(11);
        layoutParams.setMargins(this.f1385, 0, this.f1385, 0);
        getLayout().addView(this.f1384, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo718() {
        super.mo718();
        this.f1386 = Dips.asIntPixels(50.0f, m731());
        this.f1385 = Dips.asIntPixels(8.0f, m731());
        m1231();
        this.f1384.setVisibility(8);
        this.f1383.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo720(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo721(@NonNull Bundle bundle) {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢢ */
    protected VideoView mo724() {
        return this.f1383;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢣ */
    public void mo726() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢤ */
    public void mo727() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢥ */
    public void mo728() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢦ */
    public void mo729() {
    }
}
