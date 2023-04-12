package com.google.android.gms.internal;

import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzgb implements zzgo {
    private final zzft zzawt;
    private final zzanh zzawu;
    private final com.google.android.gms.ads.internal.gmsg.zzt<zzanh> zzawv = new zzgc(this);
    private final com.google.android.gms.ads.internal.gmsg.zzt<zzanh> zzaww = new zzgd(this);
    private final com.google.android.gms.ads.internal.gmsg.zzt<zzanh> zzawx = new zzge(this);

    public zzgb(zzft zzftVar, zzanh zzanhVar) {
        this.zzawt = zzftVar;
        this.zzawu = zzanhVar;
        zzanh zzanhVar2 = this.zzawu;
        zzanhVar2.zza("/updateActiveView", this.zzawv);
        zzanhVar2.zza("/untrackActiveViewUnit", this.zzaww);
        zzanhVar2.zza("/visibilityChanged", this.zzawx);
        String valueOf = String.valueOf(this.zzawt.zzavw.zzfu());
        zzagf.zzbx(valueOf.length() != 0 ? "Custom JS tracking ad unit: ".concat(valueOf) : new String("Custom JS tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.zzgo
    public final void zzb(JSONObject jSONObject, boolean z) {
        if (z) {
            this.zzawt.zzb(this);
        } else {
            this.zzawu.zzb("AFMA_updateActiveView", jSONObject);
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public final boolean zzgg() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzgo
    public final void zzgh() {
        zzanh zzanhVar = this.zzawu;
        zzanhVar.zzb("/visibilityChanged", this.zzawx);
        zzanhVar.zzb("/untrackActiveViewUnit", this.zzaww);
        zzanhVar.zzb("/updateActiveView", this.zzawv);
    }
}
