package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzaog;
import com.google.android.gms.internal.zzaoh;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaow;
import com.google.android.gms.internal.zzaoy;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzab<T extends zzaog & zzaoh & zzaou & zzaow & zzaoy> implements zzt<T> {
    private final Context mContext;
    private zzakd zzarf;
    private zzje zzbdd;
    private zzb zzbwv;
    private com.google.android.gms.ads.internal.zzw zzbye;
    private zzwr zzbyf;
    private final zzcv zzbyh;
    private com.google.android.gms.ads.internal.overlay.zzq zzbyi;
    private com.google.android.gms.ads.internal.overlay.zzn zzbyj;
    private zzanh zzbyk = null;

    public zzab(Context context, zzakd zzakdVar, zzcv zzcvVar, com.google.android.gms.ads.internal.overlay.zzq zzqVar, zzje zzjeVar, zzb zzbVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, com.google.android.gms.ads.internal.zzw zzwVar, zzwr zzwrVar) {
        this.mContext = context;
        this.zzarf = zzakdVar;
        this.zzbyh = zzcvVar;
        this.zzbyi = zzqVar;
        this.zzbdd = zzjeVar;
        this.zzbwv = zzbVar;
        this.zzbye = zzwVar;
        this.zzbyf = zzwrVar;
        this.zzbyj = zznVar;
    }

    private final void zzk(boolean z) {
        zzwr zzwrVar = this.zzbyf;
        if (zzwrVar != null) {
            zzwrVar.zzl(z);
        }
    }

    private static boolean zzk(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzl(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzbs.zzek().zzqg();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzbs.zzek().zzqf();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzbs.zzek().zzqh();
            }
            return -1;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void zza(java.lang.Object r11, java.util.Map r12) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzab.zza(java.lang.Object, java.util.Map):void");
    }
}
