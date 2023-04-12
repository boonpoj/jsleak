package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzanc implements Runnable {
    private /* synthetic */ String zzcml;
    private /* synthetic */ String zzdkb;
    private /* synthetic */ int zzdkd;
    private /* synthetic */ zzana zzdkf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanc(zzana zzanaVar, String str, String str2, int i) {
        this.zzdkf = zzanaVar;
        this.zzcml = str;
        this.zzdkb = str2;
        this.zzdkd = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzcml);
        hashMap.put("cachedSrc", this.zzdkb);
        hashMap.put("totalBytes", Integer.toString(this.zzdkd));
        this.zzdkf.zza("onPrecacheEvent", hashMap);
    }
}
