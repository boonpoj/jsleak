package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: assets/classes2.dex */
public class Intents {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Map<String, String> f621;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("market", "https://play.google.com/store/apps/details?%s");
        hashMap.put("amzn", "http://www.amazon.com/gp/mas/dl/android?%s");
        f621 = Collections.unmodifiableMap(hashMap);
    }

    private Intents() {
    }

    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri) {
        return false;
    }

    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri, boolean z) {
        return false;
    }

    public static boolean deviceCanHandleIntent(@NonNull Context context, @NonNull Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    @NonNull
    public static Uri getPlayStoreUri(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        return Uri.parse("market://details?id=" + intent.getPackage());
    }

    public static Intent getStartActivityIntent(@NonNull Context context, @NonNull Class cls, @Nullable Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static Intent intentForNativeBrowserScheme(@NonNull Uri uri) throws UrlParseException {
        Preconditions.checkNotNull(uri);
        if (UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(uri)) {
            if ("mopubnativebrowser".equalsIgnoreCase(uri.getScheme())) {
                return new Intent("android.intent.action.VIEW", m585(uri));
            }
            if (MoPub.getBrowserAgent() == MoPub.BrowserAgent.NATIVE) {
                return new Intent("android.intent.action.VIEW", uri);
            }
            throw new UrlParseException("Invalid URI: " + uri.toString());
        }
        String str = "mopubnativebrowser://";
        if (MoPub.getBrowserAgent() == MoPub.BrowserAgent.NATIVE) {
            str = "mopubnativebrowser://, http://, or https://";
        }
        throw new UrlParseException("URI does not have " + str + " scheme.");
    }

    public static Intent intentForShareTweet(@NonNull Uri uri) throws UrlParseException {
        if (UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(uri)) {
            try {
                String queryParameter = uri.getQueryParameter("screen_name");
                String queryParameter2 = uri.getQueryParameter("tweet_id");
                if (TextUtils.isEmpty(queryParameter)) {
                    throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
                }
                if (TextUtils.isEmpty(queryParameter2)) {
                    throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
                }
                String format = String.format("Check out @%s's Tweet: %s", queryParameter, String.format("https://twitter.com/%s/status/%s", queryParameter, queryParameter2));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", format);
                intent.putExtra("android.intent.extra.TEXT", format);
                return intent;
            } catch (UnsupportedOperationException unused) {
                MoPubLog.w("Could not handle url: " + uri);
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        }
        throw new UrlParseException("URL does not have mopubshare://tweet? format.");
    }

    public static void launchActionViewIntent(@NonNull Context context, @NonNull Uri uri, @Nullable String str) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        launchIntentForUserClick(context, intent, str);
    }

    public static void launchApplicationIntent(@NonNull Context context, @NonNull Intent intent) throws IntentNotResolvableException {
        Uri parse;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (deviceCanHandleIntent(context, intent)) {
            String str = "Unable to open intent: " + intent;
            if (!(context instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            launchIntentForUserClick(context, intent, str);
            return;
        }
        String stringExtra = intent.getStringExtra("browser_fallback_url");
        if (!TextUtils.isEmpty(stringExtra)) {
            parse = Uri.parse(stringExtra);
            String scheme = parse.getScheme();
            if (Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) {
                showMoPubBrowserForUrl(context, parse, null);
                return;
            }
        } else if (f621.containsKey(intent.getScheme())) {
            throw new IntentNotResolvableException("Device could not handle neither intent nor market url.\nIntent: " + intent.toString());
        } else {
            parse = getPlayStoreUri(intent);
        }
        launchApplicationUrl(context, parse);
    }

    public static void launchApplicationUrl(@NonNull Context context, @NonNull Uri uri) throws IntentNotResolvableException {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        if (!deviceCanHandleIntent(context, intent)) {
            if (!f621.containsKey(intent.getScheme()) || intent.getData() == null || TextUtils.isEmpty(intent.getData().getQuery())) {
                throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
            }
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(f621.get(intent.getScheme()), intent.getData().getQuery())));
        }
        launchApplicationIntent(context, intent);
    }

    public static void launchIntentForUserClick(@NonNull Context context, @NonNull Intent intent, @Nullable String str) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            startActivity(context, intent);
        } catch (IntentNotResolvableException e) {
            throw new IntentNotResolvableException(str + "\n" + e.getMessage());
        }
    }

    public static void showMoPubBrowserForUrl(@NonNull Context context, @NonNull Uri uri, @Nullable String str) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        MoPubLog.d("Final URI to show in browser: " + uri);
        Bundle bundle = new Bundle();
        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, uri.toString());
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str);
        }
        Intent startActivityIntent = getStartActivityIntent(context, MoPubBrowser.class, bundle);
        launchIntentForUserClick(context, startActivityIntent, "Could not show MoPubBrowser for url: " + uri + "\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.");
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new IntentNotResolvableException(e);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Uri m585(@NonNull Uri uri) throws UrlParseException {
        Preconditions.checkNotNull(uri);
        if ("navigate".equals(uri.getHost())) {
            try {
                String queryParameter = uri.getQueryParameter("url");
                if (queryParameter != null) {
                    return Uri.parse(queryParameter);
                }
                throw new UrlParseException("URL missing 'url' query parameter.");
            } catch (UnsupportedOperationException unused) {
                MoPubLog.w("Could not handle url: " + uri);
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        }
        throw new UrlParseException("URL missing 'navigate' host parameter.");
    }
}
