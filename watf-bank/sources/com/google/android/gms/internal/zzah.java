package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzah implements zzaq {
    public abstract zzap zza(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza;

    @Override // com.google.android.gms.internal.zzaq
    @Deprecated
    public final HttpResponse zzb(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        zzap zza = zza(zzrVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), zza.getStatusCode(), ""));
        ArrayList arrayList = new ArrayList();
        for (zzl zzlVar : zza.zzp()) {
            arrayList.add(new BasicHeader(zzlVar.getName(), zzlVar.getValue()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream content = zza.getContent();
        if (content != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(content);
            basicHttpEntity.setContentLength(zza.getContentLength());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
