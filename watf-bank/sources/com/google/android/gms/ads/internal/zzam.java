package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzam extends zzagb {
    final /* synthetic */ zzak zzaqk;
    private final int zzaql;

    public zzam(zzak zzakVar, int i) {
        this.zzaqk = zzakVar;
        this.zzaql = i;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        boolean z;
        float f;
        boolean z2;
        boolean z3 = this.zzaqk.zzano.zzaqo;
        boolean zzdj = this.zzaqk.zzdj();
        z = this.zzaqk.zzaqe;
        f = this.zzaqk.zzaqf;
        int i = this.zzaqk.zzano.zzaqo ? this.zzaql : -1;
        z2 = this.zzaqk.zzaqg;
        zzao zzaoVar = new zzao(z3, zzdj, z, f, i, z2, this.zzaqk.zzano.zzaud.zzaqv);
        int requestedOrientation = this.zzaqk.zzano.zzaud.zzciy.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzaqk.zzano.zzaud.orientation;
        }
        zzak zzakVar = this.zzaqk;
        zzahn.zzdaw.post(new zzan(this, new AdOverlayInfoParcel(zzakVar, zzakVar, zzakVar, zzakVar.zzano.zzaud.zzciy, requestedOrientation, this.zzaqk.zzano.zzaty, this.zzaqk.zzano.zzaud.zzcpb, zzaoVar)));
    }
}
