package com.mopub.common.privacy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentDialogLayout;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
/* loaded from: assets/classes2.dex */
public class ConsentDialogActivity extends Activity {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    ConsentDialogLayout f471;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    Handler f472;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    ConsentStatus f473;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Runnable f474;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m487(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            MoPubLog.e("ConsentDialogActivity htmlData can't be empty string.");
            return;
        }
        try {
            Intents.startActivity(context, m490(context, str));
        } catch (ActivityNotFoundException | IntentNotResolvableException unused) {
            MoPubLog.e("ConsentDialogActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m489(@NonNull ConsentStatus consentStatus) {
        Preconditions.checkNotNull(consentStatus);
        this.f473 = consentStatus;
    }

    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    static Intent m490(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Bundle bundle = new Bundle();
        bundle.putString("html-page-content", str);
        return Intents.getStartActivityIntent(context, ConsentDialogActivity.class, bundle);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("html-page-content");
        if (TextUtils.isEmpty(stringExtra)) {
            MoPubLog.e("Web page for ConsentDialogActivity is empty");
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.f471 = new ConsentDialogLayout(this);
        this.f471.m500(new ConsentDialogLayout.InterfaceC0176() { // from class: com.mopub.common.privacy.ConsentDialogActivity.1
            @Override // com.mopub.common.privacy.ConsentDialogLayout.InterfaceC0176
            public void onCloseClick() {
                ConsentDialogActivity.this.finish();
            }

            @Override // com.mopub.common.privacy.ConsentDialogLayout.InterfaceC0176
            public void onConsentClick(ConsentStatus consentStatus) {
                ConsentDialogActivity.this.m489(consentStatus);
                ConsentDialogActivity.this.m491(false);
            }
        });
        this.f474 = new Runnable() { // from class: com.mopub.common.privacy.ConsentDialogActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ConsentDialogActivity.this.m491(true);
            }
        };
        setContentView(this.f471);
        this.f471.m501(stringExtra, new ConsentDialogLayout.InterfaceC0177() { // from class: com.mopub.common.privacy.ConsentDialogActivity.3
            @Override // com.mopub.common.privacy.ConsentDialogLayout.InterfaceC0177
            public void onLoadProgress(int i) {
                int i2 = ConsentDialogLayout.f487;
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (personalInformationManager != null && this.f473 != null) {
            personalInformationManager.m543(this.f473);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f472 = new Handler();
        this.f472.postDelayed(this.f474, 10000L);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        m491(true);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m491(boolean z) {
        if (this.f472 != null) {
            this.f472.removeCallbacks(this.f474);
        }
        if (this.f471 != null) {
            this.f471.setCloseVisible(z);
        }
    }
}
