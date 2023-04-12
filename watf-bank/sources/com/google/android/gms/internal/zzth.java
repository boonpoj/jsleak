package com.google.android.gms.internal;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzth {
    private final Object[] mParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzth(zzjj zzjjVar, String str, int i) {
        this.mParams = com.google.android.gms.ads.internal.zzp.zza((String) zzkb.zzif().zzd(zznh.zzblw), zzjjVar, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzth) {
            return Arrays.equals(this.mParams, ((zzth) obj).mParams);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.mParams);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 24);
        sb.append("[InterstitialAdPoolKey ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
