package com.mopub.common;

import android.support.annotation.NonNull;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: assets/classes2.dex */
public abstract class MoPubHttpUrlConnection extends HttpURLConnection {
    public static HttpURLConnection getHttpUrlConnection(@NonNull String str) throws IOException {
        Preconditions.checkNotNull(str);
        if (m450(str)) {
            throw new IllegalArgumentException("URL is improperly encoded: " + str);
        }
        try {
            str = urlEncode(str);
        } catch (Exception unused) {
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("user-agent", Networking.getCachedUserAgent());
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        return httpURLConnection;
    }

    @NonNull
    public static String urlEncode(@NonNull String str) throws Exception {
        Preconditions.checkNotNull(str);
        if (!m450(str)) {
            return (m451(str) ? m452(str) : new URI(str)).toURL().toString();
        }
        throw new UnsupportedEncodingException("URL is improperly encoded: " + str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static boolean m450(@NonNull String str) {
        try {
            URLDecoder.decode(str, "UTF-8");
            return false;
        } catch (UnsupportedEncodingException unused) {
            MoPubLog.w("Url is improperly encoded: " + str);
            return true;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    static boolean m451(@NonNull String str) {
        try {
            new URI(str);
            return false;
        } catch (URISyntaxException unused) {
            return true;
        }
    }

    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    static URI m452(@NonNull String str) throws Exception {
        try {
            URL url = new URL(str);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        } catch (Exception e) {
            MoPubLog.w("Failed to encode url: " + str);
            throw e;
        }
    }
}
