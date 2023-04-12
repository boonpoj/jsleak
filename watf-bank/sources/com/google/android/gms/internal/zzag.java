package com.google.android.gms.internal;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzag extends zzah {
    private final zzaq zzbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzaq zzaqVar) {
        this.zzbp = zzaqVar;
    }

    @Override // com.google.android.gms.internal.zzah
    public final zzap zza(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse zzb = this.zzbp.zzb(zzrVar, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzap(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new zzap(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Response too large: ");
            sb.append(contentLength);
            throw new IOException(sb.toString());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
