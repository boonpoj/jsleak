package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzw {
    private final Context mContext;
    private boolean zzaop;
    private zzafb zzaoq;
    private zzaaz zzaor;

    public zzw(Context context, zzafb zzafbVar, zzaaz zzaazVar) {
        this.mContext = context;
        this.zzaoq = zzafbVar;
        this.zzaor = zzaazVar;
        if (this.zzaor == null) {
            this.zzaor = new zzaaz();
        }
    }

    private final boolean zzcz() {
        zzafb zzafbVar = this.zzaoq;
        return (zzafbVar != null && zzafbVar.zzok().zzcwu) || this.zzaor.zzcpw;
    }

    public final void recordClick() {
        this.zzaop = true;
    }

    public final boolean zzda() {
        return !zzcz() || this.zzaop;
    }

    public final void zzt(String str) {
        if (zzcz()) {
            if (str == null) {
                str = "";
            }
            zzafb zzafbVar = this.zzaoq;
            if (zzafbVar != null) {
                zzafbVar.zza(str, null, 3);
            } else if (this.zzaor.zzcpw && this.zzaor.zzcpx != null) {
                for (String str2 : this.zzaor.zzcpx) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzbs.zzei();
                        zzahn.zze(this.mContext, "", replace);
                    }
                }
            }
        }
    }
}
