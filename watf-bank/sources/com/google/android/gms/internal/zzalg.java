package com.google.android.gms.internal;

import com.mopub.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
@zzzv
/* loaded from: classes.dex */
public final class zzalg {
    public static HttpURLConnection zzb(String str, int i) throws IOException {
        URL url = new URL(str);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 > 20) {
                throw new IOException("Too many redirects (20)");
            }
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(i);
            openConnection.setReadTimeout(i);
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("Invalid protocol.");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            zzajv zzajvVar = new zzajv();
            zzajvVar.zza(httpURLConnection, (byte[]) null);
            httpURLConnection.setInstanceFollowRedirects(false);
            int responseCode = httpURLConnection.getResponseCode();
            zzajvVar.zza(httpURLConnection, responseCode);
            if (responseCode / 100 != 3) {
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                throw new IOException("Missing Location header in redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (protocol == null) {
                throw new IOException("Protocol is null");
            }
            if (!protocol.equals(Constants.HTTP) && !protocol.equals(Constants.HTTPS)) {
                String valueOf = String.valueOf(protocol);
                throw new IOException(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
            }
            String valueOf2 = String.valueOf(headerField);
            zzagf.zzbx(valueOf2.length() != 0 ? "Redirecting to ".concat(valueOf2) : new String("Redirecting to "));
            httpURLConnection.disconnect();
            url = url2;
        }
    }
}
