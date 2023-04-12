package com.google.android.gms.internal;

import com.mopub.volley.toolbox.HttpClientStack;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzw<T> {
    public final T result;
    public final zzc zzbh;
    public final zzad zzbi;
    public boolean zzbj;

    /* loaded from: assets/classes2.dex */
    public static final class zza extends HttpEntityEnclosingRequestBase {
        public zza() {
        }

        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return HttpClientStack.HttpPatch.METHOD_NAME;
        }
    }

    private zzw(zzad zzadVar) {
        this.zzbj = false;
        this.result = null;
        this.zzbh = null;
        this.zzbi = zzadVar;
    }

    private zzw(T t, zzc zzcVar) {
        this.zzbj = false;
        this.result = t;
        this.zzbh = zzcVar;
        this.zzbi = null;
    }

    public static <T> zzw<T> zza(T t, zzc zzcVar) {
        return new zzw<>(t, zzcVar);
    }

    public static <T> zzw<T> zzc(zzad zzadVar) {
        return new zzw<>(zzadVar);
    }
}
