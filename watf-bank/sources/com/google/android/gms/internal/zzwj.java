package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
@zzzv
/* loaded from: classes.dex */
public final class zzwj {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = zzwk.zzcga[errorCode.ordinal()];
        if (i != 2) {
            if (i != 3) {
                return i != 4 ? 0 : 3;
            }
            return 2;
        }
        return 1;
    }

    public static MediationAdRequest zza(zzjj zzjjVar, boolean z) {
        HashSet hashSet = zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null;
        Date date = new Date(zzjjVar.zzbdf);
        int i = zzjjVar.zzbdg;
        return new MediationAdRequest(date, i != 1 ? i != 2 ? AdRequest.Gender.UNKNOWN : AdRequest.Gender.FEMALE : AdRequest.Gender.MALE, hashSet, z, zzjjVar.zzbdn);
    }

    public static AdSize zzb(zzjn zzjnVar) {
        AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        for (int i = 0; i < 6; i++) {
            if (adSizeArr[i].getWidth() == zzjnVar.width && adSizeArr[i].getHeight() == zzjnVar.height) {
                return adSizeArr[i];
            }
        }
        return new AdSize(com.google.android.gms.ads.zzb.zza(zzjnVar.width, zzjnVar.height, zzjnVar.zzbek));
    }
}
