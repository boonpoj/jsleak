package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
final class zzau implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private /* synthetic */ CountDownLatch zzans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(CountDownLatch countDownLatch) {
        this.zzans = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzagf.zzcu("Adapter returned an ad, but assets substitution failed");
        this.zzans.countDown();
        zzanhVar.destroy();
    }
}
