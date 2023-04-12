package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
@zzzv
/* loaded from: classes.dex */
public final class zzagf extends zzakb {
    public static void v(String str) {
        if (zzpz()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzpz() {
        if (zzae(2)) {
            return ((Boolean) zzkb.zzif().zzd(zznh.zzbmn)).booleanValue();
        }
        return false;
    }
}
