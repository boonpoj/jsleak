package com.google.android.gms.internal;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;
@zzzv
/* loaded from: classes.dex */
public final class zzaip extends zzai {
    private final Context mContext;

    private zzaip(Context context, zzaq zzaqVar) {
        super(zzaqVar);
        this.mContext = context;
    }

    public static zzv zzba(Context context) {
        zzv zzvVar = new zzv(new zzal(new File(context.getCacheDir(), "admob_volley")), new zzaip(context, new zzar()));
        zzvVar.start();
        return zzvVar;
    }

    @Override // com.google.android.gms.internal.zzai, com.google.android.gms.internal.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzad {
        if (zzrVar.zzg() && zzrVar.getMethod() == 0) {
            if (Pattern.matches((String) zzkb.zzif().zzd(zznh.zzbqp), zzrVar.getUrl())) {
                zzkb.zzia();
                if (zzajr.zzbe(this.mContext)) {
                    zzp zzc = new zzrx(this.mContext).zzc(zzrVar);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzrVar.getUrl());
                        zzagf.v(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzrVar.getUrl());
                    zzagf.v(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzrVar);
    }
}
