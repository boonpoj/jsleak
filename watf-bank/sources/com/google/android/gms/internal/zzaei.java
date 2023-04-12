package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
@zzzv
/* loaded from: classes.dex */
public final class zzaei extends zzagb implements zzaeh {
    private final Context mContext;
    private final Object mLock;
    private final zzafp zzcjk;
    private final long zzcvj;
    private final ArrayList<Future> zzcvu;
    private final ArrayList<String> zzcvv;
    private final HashMap<String, zzady> zzcvw;
    private final List<zzaeb> zzcvx;
    private final HashSet<String> zzcvy;
    private final zzade zzcvz;

    public zzaei(Context context, zzafp zzafpVar, zzade zzadeVar) {
        this(context, zzafpVar, zzadeVar, ((Long) zzkb.zzif().zzd(zznh.zzbld)).longValue());
    }

    private zzaei(Context context, zzafp zzafpVar, zzade zzadeVar, long j) {
        this.zzcvu = new ArrayList<>();
        this.zzcvv = new ArrayList<>();
        this.zzcvw = new HashMap<>();
        this.zzcvx = new ArrayList();
        this.zzcvy = new HashSet<>();
        this.mLock = new Object();
        this.mContext = context;
        this.zzcjk = zzafpVar;
        this.zzcvz = zzadeVar;
        this.zzcvj = j;
    }

    private final zzafo zza(int i, String str, zzuh zzuhVar) {
        return new zzafo(this.zzcjk.zzcqv.zzcnd, null, this.zzcjk.zzcxy.zzcdk, i, this.zzcjk.zzcxy.zzcdl, this.zzcjk.zzcxy.zzcoy, this.zzcjk.zzcxy.orientation, this.zzcjk.zzcxy.zzcdq, this.zzcjk.zzcqv.zzcng, this.zzcjk.zzcxy.zzcow, zzuhVar, null, str, this.zzcjk.zzcxl, null, this.zzcjk.zzcxy.zzcox, this.zzcjk.zzauc, this.zzcjk.zzcxy.zzcov, this.zzcjk.zzcxp, this.zzcjk.zzcxy.zzcpa, this.zzcjk.zzcxy.zzcpb, this.zzcjk.zzcxj, null, this.zzcjk.zzcxy.zzcpl, this.zzcjk.zzcxy.zzcpm, this.zzcjk.zzcxy.zzcpn, this.zzcjk.zzcxy.zzcpo, this.zzcjk.zzcxy.zzcpp, zzoh(), this.zzcjk.zzcxy.zzcdn, this.zzcjk.zzcxy.zzcps, this.zzcjk.zzcxw, this.zzcjk.zzcxy.zzaqv, this.zzcjk.zzcxx);
    }

    private final String zzoh() {
        StringBuilder sb = new StringBuilder("");
        List<zzaeb> list = this.zzcvx;
        if (list == null) {
            return sb.toString();
        }
        Iterator<zzaeb> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return sb.substring(0, Math.max(0, sb.length() - 1));
            }
            zzaeb next = it.next();
            if (next != null && !TextUtils.isEmpty(next.zzcct)) {
                String str = next.zzcct;
                int i = next.errorCode;
                int i2 = i != 3 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? 6 : 3 : 0 : 4 : 2 : 1;
                long j = next.zzcex;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33);
                sb2.append(str);
                sb2.append(".");
                sb2.append(i2);
                sb2.append(".");
                sb2.append(j);
                sb.append(String.valueOf(sb2.toString()).concat("_"));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzaeh
    public final void zza(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzaeh
    public final void zzbr(String str) {
        synchronized (this.mLock) {
            this.zzcvy.add(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0113, code lost:
        r0 = r20.zzcvv.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0121, code lost:
        if (r20.zzcvw.get(r0) == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0123, code lost:
        r2 = r20.zzcvw.get(r0).zzoe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012f, code lost:
        com.google.android.gms.internal.zzajr.zzajw.post(new com.google.android.gms.internal.zzaej(r20, zza(-2, r0, r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013f, code lost:
        return;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:? -> B:32:0x00bd). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.zzagb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzdm() {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaei.zzdm():void");
    }
}
