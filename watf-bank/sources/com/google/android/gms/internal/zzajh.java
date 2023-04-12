package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zzajh extends zzagb {
    private final String zzah;
    private final zzakc zzdcz;

    public zzajh(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzbs.zzei().zzp(context, str));
    }

    private zzajh(String str, String str2) {
        this.zzdcz = new zzakc(str2);
        this.zzah = str;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        this.zzdcz.zzck(this.zzah);
    }
}
