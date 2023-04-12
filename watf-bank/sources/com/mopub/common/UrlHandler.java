package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.UrlResolutionTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;
/* loaded from: assets/classes2.dex */
public class UrlHandler {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final ResultActions f421 = new ResultActions() { // from class: com.mopub.common.UrlHandler.1
        @Override // com.mopub.common.UrlHandler.ResultActions
        public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
        }

        @Override // com.mopub.common.UrlHandler.ResultActions
        public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
        }
    };

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final MoPubSchemeListener f422 = new MoPubSchemeListener() { // from class: com.mopub.common.UrlHandler.2
        @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
        public void onClose() {
        }

        @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
        public void onFailLoad() {
        }

        @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
        public void onFinishLoad() {
        }
    };
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private EnumSet<UrlAction> f423;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ResultActions f424;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private MoPubSchemeListener f425;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f426;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f427;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f428;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f429;

    /* loaded from: assets/classes2.dex */
    public static class Builder {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private EnumSet<UrlAction> f435 = EnumSet.of(UrlAction.NOOP);
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private ResultActions f436 = UrlHandler.f421;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private MoPubSchemeListener f437 = UrlHandler.f422;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f438 = false;
        @Nullable

        /* renamed from: ࢥ  reason: contains not printable characters */
        private String f439;

        public UrlHandler build() {
            return new UrlHandler(this.f435, this.f436, this.f437, this.f438, this.f439);
        }

        public Builder withDspCreativeId(@Nullable String str) {
            this.f439 = str;
            return this;
        }

        public Builder withMoPubSchemeListener(@NonNull MoPubSchemeListener moPubSchemeListener) {
            this.f437 = moPubSchemeListener;
            return this;
        }

        public Builder withResultActions(@NonNull ResultActions resultActions) {
            this.f436 = resultActions;
            return this;
        }

        public Builder withSupportedUrlActions(@NonNull UrlAction urlAction, @Nullable UrlAction... urlActionArr) {
            this.f435 = EnumSet.of(urlAction, urlActionArr);
            return this;
        }

        public Builder withSupportedUrlActions(@NonNull EnumSet<UrlAction> enumSet) {
            this.f435 = EnumSet.copyOf((EnumSet) enumSet);
            return this;
        }

        public Builder withoutMoPubBrowser() {
            this.f438 = true;
            return this;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface MoPubSchemeListener {
        void onClose();

        void onFailLoad();

        void onFinishLoad();
    }

    /* loaded from: assets/classes2.dex */
    public interface ResultActions {
        void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction);

        void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction);
    }

    private UrlHandler(@NonNull EnumSet<UrlAction> enumSet, @NonNull ResultActions resultActions, @NonNull MoPubSchemeListener moPubSchemeListener, boolean z, @Nullable String str) {
        this.f423 = EnumSet.copyOf((EnumSet) enumSet);
        this.f424 = resultActions;
        this.f425 = moPubSchemeListener;
        this.f427 = z;
        this.f426 = str;
        this.f428 = false;
        this.f429 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m464(@Nullable String str, @Nullable UrlAction urlAction, @NonNull String str2, @Nullable Throwable th) {
        Preconditions.checkNotNull(str2);
        if (urlAction == null) {
            urlAction = UrlAction.NOOP;
        }
        MoPubLog.d(str2, th);
        this.f424.urlHandlingFailed(str, urlAction);
    }

    public boolean handleResolvedUrl(@NonNull Context context, @NonNull String str, boolean z, @Nullable Iterable<String> iterable) {
        if (TextUtils.isEmpty(str)) {
            m464(str, null, "Attempted to handle empty url.", null);
            return false;
        }
        UrlAction urlAction = UrlAction.NOOP;
        Uri parse = Uri.parse(str);
        Iterator it = this.f423.iterator();
        while (it.hasNext()) {
            UrlAction urlAction2 = (UrlAction) it.next();
            if (urlAction2.shouldTryHandlingUrl(parse)) {
                try {
                    urlAction2.handleUrl(this, context, parse, z, this.f426);
                    if (!this.f428 && !this.f429 && !UrlAction.IGNORE_ABOUT_SCHEME.equals(urlAction2)) {
                        if (!UrlAction.HANDLE_MOPUB_SCHEME.equals(urlAction2)) {
                            try {
                                TrackingRequest.makeTrackingHttpRequest(iterable, context);
                                this.f424.urlHandlingSucceeded(parse.toString(), urlAction2);
                                this.f428 = true;
                            } catch (IntentNotResolvableException e) {
                                e = e;
                                MoPubLog.d(e.getMessage(), e);
                                urlAction = urlAction2;
                            }
                        }
                    }
                    return true;
                } catch (IntentNotResolvableException e2) {
                    e = e2;
                }
            }
        }
        m464(str, urlAction, "Link ignored. Unable to handle url: " + str, null);
        return false;
    }

    public void handleUrl(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, true);
    }

    public void handleUrl(@NonNull Context context, @NonNull String str, boolean z) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, z, null);
    }

    public void handleUrl(@NonNull final Context context, @NonNull final String str, final boolean z, @Nullable final Iterable<String> iterable) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            m464(str, null, "Attempted to handle empty url.", null);
            return;
        }
        UrlResolutionTask.getResolvedUrl(str, new UrlResolutionTask.InterfaceC0172() { // from class: com.mopub.common.UrlHandler.3
            @Override // com.mopub.common.UrlResolutionTask.InterfaceC0172
            public void onFailure(@NonNull String str2, @Nullable Throwable th) {
                UrlHandler.this.f429 = false;
                UrlHandler.this.m464(str, null, str2, th);
            }

            @Override // com.mopub.common.UrlResolutionTask.InterfaceC0172
            public void onSuccess(@NonNull String str2) {
                UrlHandler.this.f429 = false;
                UrlHandler.this.handleResolvedUrl(context, str2, z, iterable);
            }
        });
        this.f429 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public MoPubSchemeListener m468() {
        return this.f425;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m469() {
        return this.f427;
    }
}
