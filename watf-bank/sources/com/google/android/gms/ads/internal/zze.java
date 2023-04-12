package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zze implements Callable<String> {
    private /* synthetic */ zzd zzany;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzd zzdVar) {
        this.zzany = zzdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        CookieManager zzay;
        return (!((Boolean) zzkb.zzif().zzd(zznh.zzbqc)).booleanValue() || (zzay = zzbs.zzek().zzay(this.zzany.zzano.zzair)) == null) ? "" : zzay.getCookie("googleads.g.doubleclick.net");
    }
}
