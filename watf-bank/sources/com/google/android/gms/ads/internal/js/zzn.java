package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaiq;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzn {
    private final Context mContext;
    private final Object mLock;
    private final zzakd zzapr;
    private final String zzcay;
    private zzaiq<zzc> zzcaz;
    private zzaiq<zzc> zzcba;
    private zzae zzcbb;
    private int zzcbc;

    public zzn(Context context, zzakd zzakdVar, String str) {
        this.mLock = new Object();
        this.zzcbc = 1;
        this.zzcay = str;
        this.mContext = context.getApplicationContext();
        this.zzapr = zzakdVar;
        this.zzcaz = new zzz();
        this.zzcba = new zzz();
    }

    public zzn(Context context, zzakd zzakdVar, String str, zzaiq<zzc> zzaiqVar, zzaiq<zzc> zzaiqVar2) {
        this(context, zzakdVar, str);
        this.zzcaz = zzaiqVar;
        this.zzcba = zzaiqVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzae zza(zzcv zzcvVar) {
        zzae zzaeVar = new zzae(this.zzcba);
        zzbs.zzei();
        zzahn.runOnUiThread(new zzo(this, zzcvVar, zzaeVar));
        zzaeVar.zza(new zzw(this, zzaeVar), new zzx(this, zzaeVar));
        return zzaeVar;
    }

    public final zzaa zzb(zzcv zzcvVar) {
        synchronized (this.mLock) {
            if (this.zzcbb != null && this.zzcbb.getStatus() != -1) {
                if (this.zzcbc == 0) {
                    return this.zzcbb.zzlp();
                } else if (this.zzcbc == 1) {
                    this.zzcbc = 2;
                    zza((zzcv) null);
                    return this.zzcbb.zzlp();
                } else if (this.zzcbc == 2) {
                    return this.zzcbb.zzlp();
                } else {
                    return this.zzcbb.zzlp();
                }
            }
            this.zzcbc = 2;
            this.zzcbb = zza((zzcv) null);
            return this.zzcbb.zzlp();
        }
    }
}
