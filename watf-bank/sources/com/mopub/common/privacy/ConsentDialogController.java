package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentDialogRequest;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
/* loaded from: assets/classes2.dex */
public class ConsentDialogController implements ConsentDialogRequest.Listener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    volatile boolean f478;

    /* renamed from: ࢢ  reason: contains not printable characters */
    volatile boolean f479;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Context f480;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f481;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ConsentDialogListener f482;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Handler f483;

    /* renamed from: com.mopub.common.privacy.ConsentDialogController$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        static final /* synthetic */ int[] f486 = new int[MoPubNetworkError.Reason.values().length];

        static {
            try {
                f486[MoPubNetworkError.Reason.BAD_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConsentDialogController(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        this.f480 = context.getApplicationContext();
        this.f483 = new Handler();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m492() {
        this.f479 = false;
        this.f478 = false;
        this.f482 = null;
        this.f481 = null;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        ConsentDialogListener consentDialogListener = this.f482;
        m492();
        if (consentDialogListener == null) {
            return;
        }
        consentDialogListener.onConsentDialogLoadFailed(((volleyError instanceof MoPubNetworkError) && AnonymousClass2.f486[((MoPubNetworkError) volleyError).getReason().ordinal()] == 1) ? MoPubErrorCode.INTERNAL_ERROR : MoPubErrorCode.UNSPECIFIED);
    }

    @Override // com.mopub.common.privacy.ConsentDialogRequest.Listener
    public void onSuccess(C0181 c0181) {
        this.f479 = false;
        this.f481 = c0181.getHtml();
        if (TextUtils.isEmpty(this.f481)) {
            this.f478 = false;
            if (this.f482 != null) {
                this.f482.onConsentDialogLoadFailed(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
            return;
        }
        this.f478 = true;
        if (this.f482 != null) {
            this.f482.onConsentDialogLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public synchronized void m493(@Nullable final ConsentDialogListener consentDialogListener, @Nullable Boolean bool, @NonNull C0182 c0182) {
        Preconditions.checkNotNull(c0182);
        if (this.f478) {
            if (consentDialogListener != null) {
                this.f483.post(new Runnable() { // from class: com.mopub.common.privacy.ConsentDialogController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        consentDialogListener.onConsentDialogLoaded();
                    }
                });
            }
        } else if (this.f479) {
            MoPubLog.d("Already making a consent dialog load request.");
        } else {
            this.f482 = consentDialogListener;
            this.f479 = true;
            Networking.getRequestQueue(this.f480).add(new ConsentDialogRequest(this.f480, new ConsentDialogUrlGenerator(this.f480, c0182.m555(), c0182.m559().getValue()).m504(bool).m507(c0182.getConsentedPrivacyPolicyVersion()).m505(c0182.getConsentedVendorListVersion()).m506(c0182.isForceGdprApplies()).generateUrlString(Constants.HOST), this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m494() {
        if (!this.f478 || TextUtils.isEmpty(this.f481)) {
            return false;
        }
        ConsentDialogActivity.m487(this.f480, this.f481);
        m492();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m495() {
        return this.f478;
    }
}
