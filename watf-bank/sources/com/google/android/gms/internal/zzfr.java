package com.google.android.gms.internal;

import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzfr {
    private final String zzavk;
    private final JSONObject zzavl;
    private final String zzavm;
    private final String zzavn;
    private final boolean zzavo;
    private final boolean zzavp;

    public zzfr(String str, zzakd zzakdVar, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzavn = zzakdVar.zzcv;
        this.zzavl = jSONObject;
        this.zzavm = str;
        this.zzavk = str2;
        this.zzavo = z;
        this.zzavp = z2;
    }

    public final String zzfr() {
        return this.zzavk;
    }

    public final String zzfs() {
        return this.zzavn;
    }

    public final JSONObject zzft() {
        return this.zzavl;
    }

    public final String zzfu() {
        return this.zzavm;
    }

    public final boolean zzfv() {
        return this.zzavo;
    }

    public final boolean zzfw() {
        return this.zzavp;
    }
}
