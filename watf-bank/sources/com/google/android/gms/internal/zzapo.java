package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzapn;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: assets/classes2.dex */
public class zzapo {
    private final Collection<zzapn> zzAJ = new ArrayList();
    private final Collection<zzapn.zzd> zzAK = new ArrayList();
    private final Collection<zzapn.zzd> zzAL = new ArrayList();

    public static void initialize(Context context) {
        zzapr.zzCR().initialize(context);
    }

    public void zza(zzapn zzapnVar) {
        this.zzAJ.add(zzapnVar);
    }
}
