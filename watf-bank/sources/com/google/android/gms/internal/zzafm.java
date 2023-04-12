package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
/* loaded from: classes.dex */
final class zzafm implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzalf zzcxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafm(zzafl zzaflVar, Context context, zzalf zzalfVar) {
        this.val$context = context;
        this.zzcxi = zzalfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzcxi.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzcxi.setException(e);
            zzakb.zzb("Exception while getting advertising Id info", e);
        }
    }
}
