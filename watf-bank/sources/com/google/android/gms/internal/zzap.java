package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzap {
    private final int zzcd;
    private final List<zzl> zzce;
    private final int zzcf;
    private final InputStream zzcg;

    /* renamed from: com.google.android.gms.internal.zzap$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzap.this.zzpF != null) {
                return;
            }
            synchronized (zzap.zzV()) {
                if (zzap.this.zzpF != null) {
                    return;
                }
                boolean booleanValue = ((Boolean) zzfx.zzDf.get()).booleanValue();
                if (booleanValue) {
                    zzap.zzpE = new zzzf(zzap.zza(zzap.this).getContext(), "ADSHIELD", null);
                }
                zzap.this.zzpF = Boolean.valueOf(booleanValue);
                zzap.zzV().open();
            }
        }
    }

    public zzap(int i, List<zzl> list) {
        this(i, list, -1, null);
    }

    public zzap(int i, List<zzl> list, int i2, InputStream inputStream) {
        this.zzcd = i;
        this.zzce = list;
        this.zzcf = i2;
        this.zzcg = inputStream;
    }

    public final InputStream getContent() {
        return this.zzcg;
    }

    public final int getContentLength() {
        return this.zzcf;
    }

    public final int getStatusCode() {
        return this.zzcd;
    }

    public final List<zzl> zzp() {
        return Collections.unmodifiableList(this.zzce);
    }
}
