package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzfv implements zzhd {
    private WeakReference<zzos> zzawo;

    public zzfv(zzos zzosVar) {
        this.zzawo = new WeakReference<>(zzosVar);
    }

    @Override // com.google.android.gms.internal.zzhd
    public final View zzgd() {
        zzos zzosVar = this.zzawo.get();
        if (zzosVar != null) {
            return zzosVar.zzkj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final boolean zzge() {
        return this.zzawo.get() == null;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final zzhd zzgf() {
        return new zzfx(this.zzawo.get());
    }
}
