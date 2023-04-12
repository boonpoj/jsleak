package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzwx {
    private final boolean zzche;
    private final boolean zzchf;
    private final boolean zzchg;
    private final boolean zzchh;
    private final boolean zzchi;

    private zzwx(zzwz zzwzVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzwzVar.zzche;
        this.zzche = z;
        z2 = zzwzVar.zzchf;
        this.zzchf = z2;
        z3 = zzwzVar.zzchg;
        this.zzchg = z3;
        z4 = zzwzVar.zzchh;
        this.zzchh = z4;
        z5 = zzwzVar.zzchi;
        this.zzchi = z5;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzche).put("tel", this.zzchf).put("calendar", this.zzchg).put("storePicture", this.zzchh).put("inlineVideo", this.zzchi);
        } catch (JSONException e) {
            zzagf.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
