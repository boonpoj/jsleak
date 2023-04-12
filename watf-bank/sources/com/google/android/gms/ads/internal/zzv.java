package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzaex;
import com.google.android.gms.internal.zzafc;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzamh;
import com.google.android.gms.internal.zzamu;
import com.google.android.gms.internal.zzanf;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzv {
    public final zzanf zzaol;
    public final zzamc zzaom;
    public final zzafc zzaon;
    public final zzix zzaoo;

    private zzv(zzanf zzanfVar, zzamc zzamcVar, zzafc zzafcVar, zzix zzixVar) {
        this.zzaol = zzanfVar;
        this.zzaom = zzamcVar;
        this.zzaon = zzafcVar;
        this.zzaoo = zzixVar;
    }

    public static zzv zzc(Context context) {
        return new zzv(new zzamu(), new zzamh(), new zzaew(new zzaex()), new zzix(context));
    }
}
