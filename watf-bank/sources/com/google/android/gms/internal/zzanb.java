package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
/* loaded from: classes.dex */
final class zzanb implements Runnable {
    private /* synthetic */ String zzcml;
    private /* synthetic */ String zzdkb;
    private /* synthetic */ int zzdkc;
    private /* synthetic */ int zzdkd;
    private /* synthetic */ boolean zzdke = false;
    private /* synthetic */ zzana zzdkf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanb(zzana zzanaVar, String str, String str2, int i, int i2, boolean z) {
        this.zzdkf = zzanaVar;
        this.zzcml = str;
        this.zzdkb = str2;
        this.zzdkc = i;
        this.zzdkd = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzcml);
        hashMap.put("cachedSrc", this.zzdkb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzdkc));
        hashMap.put("totalBytes", Integer.toString(this.zzdkd));
        hashMap.put("cacheReady", this.zzdke ? "1" : "0");
        this.zzdkf.zza("onPrecacheEvent", hashMap);
    }
}
