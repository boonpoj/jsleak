package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.IntentActions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.mraid.RewardedMraidController;
/* loaded from: assets/classes2.dex */
public class RewardedMraidActivity extends MraidActivity {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RewardedMraidController f967;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private MraidWebViewDebugListener f968;

    public static void start(@NonNull Context context, @Nullable AdReport adReport, @Nullable String str, long j, int i, boolean z) {
        try {
            Intents.startActivity(context, m865(context, adReport, str, j, i, z));
        } catch (IntentNotResolvableException unused) {
            Log.d("RewardedMraidActivity", "RewardedMraidActivity.class not found. Did you declare RewardedMraidActivity in your manifest?");
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static Intent m865(@NonNull Context context, @Nullable AdReport adReport, @Nullable String str, long j, int i, boolean z) {
        Intent intent = new Intent(context, RewardedMraidActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.REWARDED_AD_DURATION_KEY, i);
        intent.putExtra(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, z);
        return intent;
    }

    @Override // com.mopub.mobileads.MraidActivity, com.mopub.mobileads.AbstractActivityC0235
    public View getAdView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            MoPubLog.w("RewardedMraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        } else if (m1065() == null) {
            MoPubLog.w("RewardedMraidActivity received a null broadcast id. Finishing the activity.");
            finish();
            return new View(this);
        } else {
            int intExtra = intent.getIntExtra(DataKeys.REWARDED_AD_DURATION_KEY, 30);
            final boolean booleanExtra = intent.getBooleanExtra(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, false);
            this.f967 = new RewardedMraidController(this, this.f1245, PlacementType.INTERSTITIAL, intExtra, m1065().longValue());
            this.f967.setDebugListener(this.f968);
            this.f967.setMraidListener(new MraidController.MraidListener() { // from class: com.mopub.mobileads.RewardedMraidActivity.1
                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onClose() {
                    RewardedMraidActivity.this.f967.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
                    RewardedMraidActivity.this.finish();
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onExpand() {
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onFailedToLoad() {
                    MoPubLog.d("RewardedMraidActivity failed to load. Finishing the activity");
                    EventForwardingBroadcastReceiver.broadcastAction(RewardedMraidActivity.this, RewardedMraidActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
                    RewardedMraidActivity.this.finish();
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onLoaded(View view) {
                    RewardedMraidActivity.this.f967.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onOpen() {
                    if (booleanExtra) {
                        RewardedMraidActivity.this.f967.showPlayableCloseButton();
                    }
                    EventForwardingBroadcastReceiver.broadcastAction(RewardedMraidActivity.this, RewardedMraidActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
                }
            });
            this.f967.fillContent(m1065(), stringExtra, null);
            return this.f967.getAdContainer();
        }
    }

    @Nullable
    @VisibleForTesting
    @Deprecated
    public RewardedMraidController getRewardedMraidController() {
        return this.f967;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f967 == null || this.f967.backButtonEnabled()) {
            super.onBackPressed();
        }
    }

    @Override // com.mopub.mobileads.MraidActivity, com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (this.f967 != null) {
            this.f967.create(this, m1064());
        }
    }

    @Override // com.mopub.mobileads.MraidActivity, com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    protected void onDestroy() {
        if (this.f967 != null) {
            this.f967.destroy();
        }
        super.onDestroy();
    }

    @Override // com.mopub.mobileads.MraidActivity, android.app.Activity
    protected void onPause() {
        if (this.f967 != null) {
            this.f967.pause();
        }
        super.onPause();
    }

    @Override // com.mopub.mobileads.MraidActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f967 != null) {
            this.f967.resume();
        }
    }

    @Override // com.mopub.mobileads.MraidActivity
    @VisibleForTesting
    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f968 = mraidWebViewDebugListener;
        if (this.f967 != null) {
            this.f967.setDebugListener(mraidWebViewDebugListener);
        }
    }
}
