package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzgf implements zzgo {
    private final Context mContext;
    private final zzft zzawt;
    private final com.google.android.gms.ads.internal.gmsg.zzz zzawz;
    private com.google.android.gms.ads.internal.js.zzaa zzaxa;
    private boolean zzaxb;
    private final com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> zzawv = new zzgk(this);
    private final com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> zzaww = new zzgl(this);
    private final com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> zzawx = new zzgm(this);
    private final com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> zzaxc = new zzgn(this);

    public zzgf(zzft zzftVar, com.google.android.gms.ads.internal.js.zzn zznVar, Context context) {
        this.zzawt = zzftVar;
        this.mContext = context;
        this.zzawz = new com.google.android.gms.ads.internal.gmsg.zzz(this.mContext);
        this.zzaxa = zznVar.zzb((zzcv) null);
        this.zzaxa.zza(new zzgg(this), new zzgh(this));
        String valueOf = String.valueOf(this.zzawt.zzavw.zzfu());
        zzagf.zzbx(valueOf.length() != 0 ? "Core JS tracking ad unit: ".concat(valueOf) : new String("Core JS tracking ad unit: "));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzft zza(zzgf zzgfVar) {
        return zzgfVar.zzawt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(com.google.android.gms.ads.internal.js.zzaj zzajVar) {
        zzajVar.zza("/updateActiveView", this.zzawv);
        zzajVar.zza("/untrackActiveViewUnit", this.zzaww);
        zzajVar.zza("/visibilityChanged", this.zzawx);
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzq(this.mContext)) {
            zzajVar.zza("/logScionEvent", this.zzaxc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(com.google.android.gms.ads.internal.js.zzaj zzajVar) {
        zzajVar.zzb("/visibilityChanged", this.zzawx);
        zzajVar.zzb("/untrackActiveViewUnit", this.zzaww);
        zzajVar.zzb("/updateActiveView", this.zzawv);
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzq(this.mContext)) {
            zzajVar.zzb("/logScionEvent", this.zzaxc);
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public final void zzb(JSONObject jSONObject, boolean z) {
        this.zzaxa.zza(new zzgi(this, jSONObject), new zzalj());
    }

    @Override // com.google.android.gms.internal.zzgo
    public final boolean zzgg() {
        return this.zzaxb;
    }

    @Override // com.google.android.gms.internal.zzgo
    public final void zzgh() {
        this.zzaxa.zza(new zzgj(this), new zzalj());
        this.zzaxa.release();
    }
}
