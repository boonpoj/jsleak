package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zze implements zzc {
    private final Context mContext;
    private final zzanh zzbyk;

    public zze(Context context, zzakd zzakdVar, zzcv zzcvVar, com.google.android.gms.ads.internal.zzv zzvVar) throws zzanv {
        this.mContext = context;
        this.zzbyk = zzbs.zzej().zza(context, zzapa.zzuf(), "", false, false, zzcvVar, zzakdVar, null, null, null, zzis.zzhl());
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar == null) {
            throw null;
        }
        ((View) zzanhVar).setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzkb.zzia();
        if (zzajr.zzqz()) {
            runnable.run();
        } else {
            zzahn.zzdaw.post(runnable);
        }
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final void destroy() {
        this.zzbyk.destroy();
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final void zza(zzd zzdVar) {
        this.zzbyk.zzsz().zza(new zzk(this, zzdVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zzaj
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj> zztVar) {
        this.zzbyk.zzsz().zza(str, new zzl(this, zztVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, Map<String, ?> map) {
        this.zzbyk.zza(str, map);
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(String str, JSONObject jSONObject) {
        this.zzbyk.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zzaj
    public final void zzb(String str, final com.google.android.gms.ads.internal.gmsg.zzt<? super zzaj> zztVar) {
        this.zzbyk.zzsz().zza(str, new com.google.android.gms.common.util.zzr(zztVar) { // from class: com.google.android.gms.ads.internal.js.zzf
            private final com.google.android.gms.ads.internal.gmsg.zzt zzcaq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcaq = zztVar;
            }

            @Override // com.google.android.gms.common.util.zzr
            public final boolean apply(Object obj) {
                com.google.android.gms.ads.internal.gmsg.zzt zztVar2;
                com.google.android.gms.ads.internal.gmsg.zzt zztVar3 = this.zzcaq;
                com.google.android.gms.ads.internal.gmsg.zzt zztVar4 = (com.google.android.gms.ads.internal.gmsg.zzt) obj;
                if (zztVar4 instanceof zzl) {
                    zztVar2 = ((zzl) zztVar4).zzcax;
                    return zztVar2.equals(zztVar3);
                }
                return false;
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.js.zzm
    public final void zzb(String str, JSONObject jSONObject) {
        runOnUiThread(new zzg(this, str, jSONObject));
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final void zzbb(String str) {
        runOnUiThread(new zzh(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final void zzbc(String str) {
        runOnUiThread(new zzj(this, str));
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final void zzbd(String str) {
        runOnUiThread(new zzi(this, str));
    }

    @Override // com.google.android.gms.ads.internal.js.zzc
    public final zzak zzln() {
        return new zzal(this);
    }
}
