package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzamx extends zzagb {
    final zzamp zzdhj;
    final zzana zzdjw;
    private final String zzdjx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamx(zzamp zzampVar, zzana zzanaVar, String str) {
        this.zzdhj = zzampVar;
        this.zzdjw = zzanaVar;
        this.zzdjx = str;
        com.google.android.gms.ads.internal.zzbs.zzfb().zza(this);
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
        this.zzdjw.abort();
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        try {
            this.zzdjw.zzcx(this.zzdjx);
        } finally {
            zzahn.zzdaw.post(new zzamy(this));
        }
    }
}
