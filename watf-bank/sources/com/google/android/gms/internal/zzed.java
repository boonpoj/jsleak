package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzed extends zzet {
    public zzed(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 24);
    }

    private final void zzbb() {
        AdvertisingIdClient zzas = this.zzagr.zzas();
        if (zzas == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzas.getInfo();
            String zzn = zzdr.zzn(info.getId());
            if (zzn != null) {
                synchronized (this.zzako) {
                    this.zzako.zzfd = zzn;
                    this.zzako.zzff = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.zzako.zzfe = 5;
                }
            }
        } catch (IOException e) {
        }
    }

    @Override // com.google.android.gms.internal.zzet, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (this.zzagr.zzak()) {
            zzbb();
            return;
        }
        synchronized (this.zzako) {
            this.zzako.zzfd = (String) this.zzakw.invoke(null, this.zzagr.getContext());
        }
    }

    @Override // com.google.android.gms.internal.zzet
    public final Void zzba() throws Exception {
        if (this.zzagr.isInitialized()) {
            return super.call();
        }
        if (this.zzagr.zzak()) {
            zzbb();
            return null;
        }
        return null;
    }
}
