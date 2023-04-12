package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaca {
    public final zzin zzcra;
    public final zzafj zzcrb;
    public final zzmw zzcrc;
    public final zzacv zzcrd;
    public final zzue zzcre;
    private zzacw zzcrf;
    public final zzacx zzcrg;
    public final zzxk zzcrh;
    public final zzafn zzcri;
    public final zzacf zzcrj;
    public final zzacm zzcqz = null;
    public final boolean zzcqy = true;

    /* loaded from: assets/classes2.dex */
    static abstract class zza extends zzaca<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private zzaca(zzacm zzacmVar, zzin zzinVar, zzafj zzafjVar, zzmw zzmwVar, zzacv zzacvVar, zzue zzueVar, zzacw zzacwVar, zzacx zzacxVar, zzxk zzxkVar, zzafn zzafnVar, boolean z, zzacf zzacfVar) {
        this.zzcra = zzinVar;
        this.zzcrb = zzafjVar;
        this.zzcrc = zzmwVar;
        this.zzcrd = zzacvVar;
        this.zzcre = zzueVar;
        this.zzcrf = zzacwVar;
        this.zzcrg = zzacxVar;
        this.zzcrh = zzxkVar;
        this.zzcri = zzafnVar;
        this.zzcrj = zzacfVar;
    }

    public static zzaca zzk(Context context) {
        com.google.android.gms.ads.internal.zzbs.zzfe().initialize(context);
        zzadb zzadbVar = new zzadb(context);
        return new zzaca(null, new zziq(), new zzafk(), new zzmv(), new zzact(context, zzadbVar.zznr()), new zzuf(), new zzacz(), new zzada(), new zzxj(), new zzafl(), true, zzadbVar);
    }
}
