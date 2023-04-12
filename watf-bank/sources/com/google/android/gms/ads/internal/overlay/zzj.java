package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
final class zzj extends zzagb {
    final /* synthetic */ zzd zzciq;

    private zzj(zzd zzdVar) {
        this.zzciq = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzj(zzd zzdVar, zze zzeVar) {
        this(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        Activity activity;
        Bitmap zza = zzbs.zzfa().zza(Integer.valueOf(this.zzciq.zzchy.zzcjg.zzaqt));
        if (zza != null) {
            zzaht zzek = zzbs.zzek();
            activity = this.zzciq.mActivity;
            zzahn.zzdaw.post(new zzk(this, zzek.zza(activity, zza, this.zzciq.zzchy.zzcjg.zzaqr, this.zzciq.zzchy.zzcjg.zzaqs)));
        }
    }
}
