package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzanh;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class zzk implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        zzbs.zzei();
        DisplayMetrics zza = zzahn.zza((WindowManager) zzanhVar2.getContext().getSystemService("window"));
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzanhVar2).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzanhVar2.zza("locationReady", hashMap);
        zzagf.zzcu("GET LOCATION COMPILED");
    }
}
