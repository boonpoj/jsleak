package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzfx implements zzhd {
    private zzos zzawp;

    /* renamed from: com.google.android.gms.internal.zzfx$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements Callable<Void> {
        final /* synthetic */ Context zztd;

        AnonymousClass1(Context context) {
            this.zztd = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: zzbl */
        public Void call() {
            com.google.android.gms.ads.internal.zzv.zzcV().initialize(this.zztd);
            return null;
        }
    }

    public zzfx(zzos zzosVar) {
        this.zzawp = zzosVar;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final View zzgd() {
        zzos zzosVar = this.zzawp;
        if (zzosVar != null) {
            return zzosVar.zzkj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final boolean zzge() {
        return this.zzawp == null;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final zzhd zzgf() {
        return this;
    }
}
