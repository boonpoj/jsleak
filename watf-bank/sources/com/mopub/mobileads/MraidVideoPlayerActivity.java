package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mraid.MraidVideoViewController;
/* loaded from: assets/classes2.dex */
public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewController.BaseVideoViewControllerListener {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private BaseVideoViewController f955;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private long f956;

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static long m852(Intent intent) {
        return intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private BaseVideoViewController m853(Bundle bundle) throws IllegalStateException {
        String stringExtra = getIntent().getStringExtra(BaseVideoPlayerActivity.VIDEO_CLASS_EXTRAS_KEY);
        if (FullAdType.VAST.equals(stringExtra)) {
            return new VastVideoViewController(this, getIntent().getExtras(), bundle, this.f956, this);
        }
        if (AdType.MRAID.equals(stringExtra)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), bundle, this);
        }
        if (!"native".equals(stringExtra)) {
            throw new IllegalStateException("Unsupported video type: " + stringExtra);
        }
        Class[] clsArr = {Context.class, Bundle.class, Bundle.class, BaseVideoViewController.BaseVideoViewControllerListener.class};
        Object[] objArr = {this, getIntent().getExtras(), bundle, this};
        if (Reflection.classFound("com.mopub.nativeads.NativeVideoViewController")) {
            try {
                return (BaseVideoViewController) Reflection.instantiateClassWithConstructor("com.mopub.nativeads.NativeVideoViewController", BaseVideoViewController.class, clsArr, objArr);
            } catch (Exception unused) {
                throw new IllegalStateException("Missing native video module");
            }
        }
        throw new IllegalStateException("Missing native video module");
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f955 != null) {
            this.f955.mo719(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f955 == null || !this.f955.backButtonEnabled()) {
            return;
        }
        super.onBackPressed();
        this.f955.mo729();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f955 != null) {
            this.f955.mo720(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.f956 = m852(getIntent());
        try {
            this.f955 = m853(bundle);
            this.f955.mo718();
        } catch (IllegalStateException unused) {
            BaseBroadcastReceiver.broadcastAction(this, this.f956, IntentActions.ACTION_INTERSTITIAL_FAIL);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoPlayerActivity, android.app.Activity
    public void onDestroy() {
        if (this.f955 != null) {
            this.f955.mo728();
        }
        super.onDestroy();
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onFinish() {
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.f955 != null) {
            this.f955.mo726();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f955 != null) {
            this.f955.mo727();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f955 != null) {
            this.f955.mo721(bundle);
        }
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onSetRequestedOrientation(int i) {
        setRequestedOrientation(i);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls == null) {
            return;
        }
        try {
            startActivityForResult(Intents.getStartActivityIntent(this, cls, bundle), i);
        } catch (ActivityNotFoundException unused) {
            MoPubLog.d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }
}
