package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzil extends zzbfm {
    public static final Parcelable.Creator<zzil> CREATOR = new zzim();
    public final String url;
    private long zzbay;
    private String zzbaz;
    private String zzbba;
    private String zzbbb;
    private Bundle zzbbc;
    private boolean zzbbd;
    private long zzbbe;

    /* renamed from: com.google.android.gms.internal.zzil$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ int zzIb;
        final /* synthetic */ int zzIc;
        final /* synthetic */ boolean zzId;
        final /* synthetic */ String zzsk;

        AnonymousClass1(String str, String str2, int i, int i2, boolean z) {
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIb = i;
            this.zzIc = i2;
            this.zzId = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
            hashMap.put("src", this.zzsk);
            hashMap.put("cachedSrc", this.zzIa);
            hashMap.put("bytesLoaded", Integer.toString(this.zzIb));
            hashMap.put("totalBytes", Integer.toString(this.zzIc));
            hashMap.put("cacheReady", this.zzId ? "1" : "0");
            zzil.zza(zzil.this, "onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzil$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ int zzIc;
        final /* synthetic */ String zzsk;

        AnonymousClass2(String str, String str2, int i) {
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
            hashMap.put("src", this.zzsk);
            hashMap.put("cachedSrc", this.zzIa);
            hashMap.put("totalBytes", Integer.toString(this.zzIc));
            zzil.zza(zzil.this, "onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzil$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ String zzIf;
        final /* synthetic */ String zzIg;
        final /* synthetic */ String zzsk;

        AnonymousClass3(String str, String str2, String str3, String str4) {
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIf = str3;
            this.zzIg = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
            hashMap.put("src", this.zzsk);
            if (!TextUtils.isEmpty(this.zzIa)) {
                hashMap.put("cachedSrc", this.zzIa);
            }
            hashMap.put(VastExtensionXmlManager.TYPE, zzil.zza(zzil.this, this.zzIf));
            hashMap.put("reason", this.zzIf);
            if (!TextUtils.isEmpty(this.zzIg)) {
                hashMap.put(AvidVideoPlaybackListenerImpl.MESSAGE, this.zzIg);
            }
            zzil.zza(zzil.this, "onPrecacheEvent", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzil(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.url = str;
        this.zzbay = j;
        this.zzbaz = str2 == null ? "" : str2;
        this.zzbba = str3 == null ? "" : str3;
        this.zzbbb = str4 != null ? str4 : "";
        this.zzbbc = bundle == null ? new Bundle() : bundle;
        this.zzbbd = z;
        this.zzbbe = j2;
    }

    public static zzil zzab(String str) {
        return zzd(Uri.parse(str));
    }

    public static zzil zzd(Uri uri) {
        try {
            if ("gcache".equals(uri.getScheme())) {
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() != 2) {
                    int size = pathSegments.size();
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Expected 2 path parts for namespace and id, found :");
                    sb.append(size);
                    zzagf.zzcu(sb.toString());
                    return null;
                }
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                String host = uri.getHost();
                String queryParameter = uri.getQueryParameter("url");
                boolean equals = "1".equals(uri.getQueryParameter("read_only"));
                String queryParameter2 = uri.getQueryParameter("expiration");
                long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
                Bundle bundle = new Bundle();
                for (String str3 : com.google.android.gms.ads.internal.zzbs.zzek().zzg(uri)) {
                    if (str3.startsWith("tag.")) {
                        bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                    }
                }
                return new zzil(queryParameter, parseLong, host, str, str2, bundle, equals, 0L);
            }
            return null;
        } catch (NullPointerException | NumberFormatException e) {
            zzagf.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.url, false);
        zzbfp.zza(parcel, 3, this.zzbay);
        zzbfp.zza(parcel, 4, this.zzbaz, false);
        zzbfp.zza(parcel, 5, this.zzbba, false);
        zzbfp.zza(parcel, 6, this.zzbbb, false);
        zzbfp.zza(parcel, 7, this.zzbbc, false);
        zzbfp.zza(parcel, 8, this.zzbbd);
        zzbfp.zza(parcel, 9, this.zzbbe);
        zzbfp.zzai(parcel, zze);
    }
}
