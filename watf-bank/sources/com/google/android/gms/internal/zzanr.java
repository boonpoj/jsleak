package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zzanr {
    public static zzakv<zzanh> zza(final Context context, final zzakd zzakdVar, final String str, final zzcv zzcvVar, final com.google.android.gms.ads.internal.zzv zzvVar) {
        return zzakl.zza(zzakl.zzi(null), new zzakg(context, zzcvVar, zzakdVar, zzvVar, str) { // from class: com.google.android.gms.internal.zzans
            private final Context zzdlh;
            private final zzcv zzdli;
            private final zzakd zzdlj;
            private final com.google.android.gms.ads.internal.zzv zzdlk;
            private final String zzdll;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = context;
                this.zzdli = zzcvVar;
                this.zzdlj = zzakdVar;
                this.zzdlk = zzvVar;
                this.zzdll = str;
            }

            @Override // com.google.android.gms.internal.zzakg
            public final zzakv zzc(Object obj) {
                Context context2 = this.zzdlh;
                zzcv zzcvVar2 = this.zzdli;
                zzakd zzakdVar2 = this.zzdlj;
                com.google.android.gms.ads.internal.zzv zzvVar2 = this.zzdlk;
                String str2 = this.zzdll;
                zzanh zza = com.google.android.gms.ads.internal.zzbs.zzej().zza(context2, zzapa.zzuf(), "", false, false, zzcvVar2, zzakdVar2, null, null, zzvVar2, zzis.zzhl());
                final zzale zzj = zzale.zzj(zza);
                zza.zzsz().zza(new zzanm(zzj) { // from class: com.google.android.gms.internal.zzant
                    private final zzale zzdlm;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdlm = zzj;
                    }

                    @Override // com.google.android.gms.internal.zzanm
                    public final void zza(zzanh zzanhVar, boolean z) {
                        this.zzdlm.zzrf();
                    }
                });
                zza.loadUrl(str2);
                return zzj;
            }
        }, zzala.zzdfe);
    }

    public final zzanh zza(Context context, zzapa zzapaVar, String str, boolean z, boolean z2, zzcv zzcvVar, zzakd zzakdVar, zznu zznuVar, com.google.android.gms.ads.internal.zzbl zzblVar, com.google.android.gms.ads.internal.zzv zzvVar, zzis zzisVar) throws zzanv {
        try {
            return (zzanh) zzajk.zzb(context, new zzanu(this, context, zzapaVar, str, z, z2, zzcvVar, zzakdVar, zznuVar, zzblVar, zzvVar, zzisVar));
        } catch (Throwable th) {
            throw new zzanv(this, "Webview initialization failed.", th);
        }
    }
}
