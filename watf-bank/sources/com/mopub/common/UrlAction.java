package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.MoPub;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.network.TrackingRequest;
import java.net.URISyntaxException;
import java.util.List;
/* loaded from: assets/classes2.dex */
public enum UrlAction {
    HANDLE_MOPUB_SCHEME(false) { // from class: com.mopub.common.UrlAction.1
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            return BuildConfig.SDK_NAME.equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            String host = uri.getHost();
            UrlHandler.MoPubSchemeListener m468 = urlHandler.m468();
            if ("finishLoad".equalsIgnoreCase(host)) {
                m468.onFinishLoad();
            } else if ("close".equalsIgnoreCase(host)) {
                m468.onClose();
            } else if ("failLoad".equalsIgnoreCase(host)) {
                m468.onFailLoad();
            } else {
                throw new IntentNotResolvableException("Could not handle MoPub Scheme url: " + uri);
            }
        }
    },
    IGNORE_ABOUT_SCHEME(false) { // from class: com.mopub.common.UrlAction.3
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            MoPubLog.d("Link to about page ignored.");
        }
    },
    HANDLE_PHONE_SCHEME(true) { // from class: com.mopub.common.UrlAction.4
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            String scheme = uri.getScheme();
            return "tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme);
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            Intents.launchActionViewIntent(context, uri, "Could not handle intent with URI: " + uri + "\n\tIs this intent supported on your phone?");
        }
    },
    OPEN_NATIVE_BROWSER(true) { // from class: com.mopub.common.UrlAction.5
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            String scheme = uri.getScheme();
            return (Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) ? MoPub.getBrowserAgent() == MoPub.BrowserAgent.NATIVE : "mopubnativebrowser".equalsIgnoreCase(scheme);
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            String str2 = "Unable to load mopub native browser url: " + uri;
            try {
                Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), str2);
            } catch (UrlParseException e) {
                throw new IntentNotResolvableException(str2 + "\n\t" + e.getMessage());
            }
        }
    },
    OPEN_APP_MARKET(true) { // from class: com.mopub.common.UrlAction.6
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return "play.google.com".equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host) || "market".equalsIgnoreCase(scheme) || uri.toString().toLowerCase().startsWith("play.google.com/") || uri.toString().toLowerCase().startsWith("market.android.com/");
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            Intents.launchApplicationUrl(context, uri);
        }
    },
    OPEN_IN_APP_BROWSER(true) { // from class: com.mopub.common.UrlAction.7
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            String scheme = uri.getScheme();
            return Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme);
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            if (urlHandler.m469()) {
                return;
            }
            Intents.showMoPubBrowserForUrl(context, uri, str);
        }
    },
    HANDLE_SHARE_TWEET(true) { // from class: com.mopub.common.UrlAction.8
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            Preconditions.checkNotNull(uri);
            return "mopubshare".equalsIgnoreCase(uri.getScheme()) && "tweet".equalsIgnoreCase(uri.getHost());
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(uri);
            String str2 = "Could not handle share tweet intent with URI " + uri;
            try {
                Intents.launchIntentForUserClick(context, Intent.createChooser(Intents.intentForShareTweet(uri), "Share via"), str2);
            } catch (UrlParseException e) {
                throw new IntentNotResolvableException(str2 + "\n\t" + e.getMessage());
            }
        }
    },
    FOLLOW_DEEP_LINK_WITH_FALLBACK(true) { // from class: com.mopub.common.UrlAction.9
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            return "deeplink+".equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            if (!"navigate".equalsIgnoreCase(uri.getHost())) {
                throw new IntentNotResolvableException("Deeplink+ URL did not have 'navigate' as the host.");
            }
            try {
                String queryParameter = uri.getQueryParameter("primaryUrl");
                List<String> queryParameters = uri.getQueryParameters("primaryTrackingUrl");
                String queryParameter2 = uri.getQueryParameter("fallbackUrl");
                List<String> queryParameters2 = uri.getQueryParameters("fallbackTrackingUrl");
                if (queryParameter == null) {
                    throw new IntentNotResolvableException("Deeplink+ did not have 'primaryUrl' query param.");
                }
                Uri parse = Uri.parse(queryParameter);
                if (shouldTryHandlingUrl(parse)) {
                    throw new IntentNotResolvableException("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                }
                try {
                    Intents.launchApplicationUrl(context, parse);
                    TrackingRequest.makeTrackingHttpRequest(queryParameters, context);
                } catch (IntentNotResolvableException unused) {
                    if (queryParameter2 == null) {
                        throw new IntentNotResolvableException("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                    }
                    if (shouldTryHandlingUrl(Uri.parse(queryParameter2))) {
                        throw new IntentNotResolvableException("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                    }
                    urlHandler.handleUrl(context, queryParameter2, true, queryParameters2);
                }
            } catch (UnsupportedOperationException unused2) {
                throw new IntentNotResolvableException("Deeplink+ URL was not a hierarchical URI.");
            }
        }
    },
    FOLLOW_DEEP_LINK(true) { // from class: com.mopub.common.UrlAction.10
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            return !TextUtils.isEmpty(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
            if (!Constants.INTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                Intents.launchApplicationUrl(context, uri);
                return;
            }
            try {
                Intents.launchApplicationIntent(context, Intent.parseUri(uri.toString(), 1));
            } catch (URISyntaxException unused) {
                throw new IntentNotResolvableException("Intent uri had invalid syntax: " + uri.toString());
            }
        }
    },
    NOOP(false) { // from class: com.mopub.common.UrlAction.2
        @Override // com.mopub.common.UrlAction
        public boolean shouldTryHandlingUrl(@NonNull Uri uri) {
            return false;
        }

        @Override // com.mopub.common.UrlAction
        /* renamed from: ࢠ */
        protected void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException {
        }
    };
    

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final boolean f420;

    UrlAction(boolean z) {
        this.f420 = z;
    }

    public void handleUrl(UrlHandler urlHandler, @NonNull Context context, @NonNull Uri uri, boolean z, @Nullable String str) throws IntentNotResolvableException {
        MoPubLog.d("Ad event URL: " + uri);
        if (this.f420 && !z) {
            throw new IntentNotResolvableException("Attempted to handle action without user interaction.");
        }
        mo462(context, uri, urlHandler, str);
    }

    public abstract boolean shouldTryHandlingUrl(@NonNull Uri uri);

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected abstract void mo462(@NonNull Context context, @NonNull Uri uri, @NonNull UrlHandler urlHandler, @Nullable String str) throws IntentNotResolvableException;
}
