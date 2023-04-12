package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.DataKeys;
/* renamed from: com.mopub.mobileads.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
abstract class AbstractActivityC0235 extends Activity {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected AdReport f1245;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private CloseableLayout f1246;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private Long f1247;

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static Long m1062(Intent intent) {
        if (intent.hasExtra(DataKeys.BROADCAST_IDENTIFIER_KEY)) {
            return Long.valueOf(intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L));
        }
        return null;
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    protected static AdReport m1063(Intent intent) {
        try {
            return (AdReport) intent.getSerializableExtra(DataKeys.AD_REPORT_KEY);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public abstract View getAdView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f1247 = m1062(intent);
        this.f1245 = m1063(intent);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        View adView = getAdView();
        this.f1246 = new CloseableLayout(this);
        this.f1246.setOnCloseListener(new CloseableLayout.OnCloseListener() { // from class: com.mopub.mobileads.ࢤ.1
            @Override // com.mopub.common.CloseableLayout.OnCloseListener
            public void onClose() {
                AbstractActivityC0235.this.finish();
            }
        });
        this.f1246.addView(adView, new FrameLayout.LayoutParams(-1, -1));
        setContentView(this.f1246);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        if (this.f1246 != null) {
            this.f1246.removeAllViews();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public CloseableLayout m1064() {
        return this.f1246;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Long m1065() {
        return this.f1247;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1066() {
        if (this.f1246 != null) {
            this.f1246.setCloseVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m1067() {
        if (this.f1246 != null) {
            this.f1246.setCloseVisible(false);
        }
    }
}
