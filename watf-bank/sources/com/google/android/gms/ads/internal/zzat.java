package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.internal.zzanh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
final class zzat implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private /* synthetic */ CountDownLatch zzans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(CountDownLatch countDownLatch) {
        this.zzans = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        this.zzans.countDown();
        if (zzanhVar2 == null) {
            throw null;
        }
        ((View) zzanhVar2).setVisibility(0);
    }
}
