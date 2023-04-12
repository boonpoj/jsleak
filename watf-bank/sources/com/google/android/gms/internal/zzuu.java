package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzuu implements zzug {
    private final Context mContext;
    private final long mStartTime;
    private final zznu zzanj;
    private final zzux zzanw;
    private final boolean zzavp;
    private final zzui zzcef;
    private final boolean zzcej;
    private final boolean zzcek;
    private final zzaat zzcey;
    private final long zzcez;
    private final String zzcfd;
    private zzul zzcfi;
    private final Object mLock = new Object();
    private boolean zzcfb = false;
    private List<zzuo> zzcfe = new ArrayList();

    public zzuu(Context context, zzaat zzaatVar, zzux zzuxVar, zzui zzuiVar, boolean z, boolean z2, String str, long j, long j2, zznu zznuVar, boolean z3) {
        this.mContext = context;
        this.zzcey = zzaatVar;
        this.zzanw = zzuxVar;
        this.zzcef = zzuiVar;
        this.zzavp = z;
        this.zzcej = z2;
        this.zzcfd = str;
        this.mStartTime = j;
        this.zzcez = j2;
        this.zzanj = zznuVar;
        this.zzcek = z3;
    }

    @Override // com.google.android.gms.internal.zzug
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzcfb = true;
            if (this.zzcfi != null) {
                this.zzcfi.cancel();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0171 -> B:48:0x016f). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.zzug
    public final zzuo zzh(List<zzuh> list) {
        Object obj;
        zzuo zzuoVar;
        zzagf.zzbx("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzns zzjf = this.zzanj.zzjf();
        zzjn zzjnVar = this.zzcey.zzauc;
        int[] iArr = new int[2];
        if (zzjnVar.zzbem != null) {
            com.google.android.gms.ads.internal.zzbs.zzez();
            if (zzuq.zza(this.zzcfd, iArr)) {
                int i = iArr[0];
                int i2 = iArr[1];
                zzjn[] zzjnVarArr = zzjnVar.zzbem;
                int length = zzjnVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    zzjn zzjnVar2 = zzjnVarArr[i3];
                    if (i == zzjnVar2.width && i2 == zzjnVar2.height) {
                        zzjnVar = zzjnVar2;
                        break;
                    }
                    i3++;
                }
            }
        }
        Iterator<zzuh> it = list.iterator();
        while (it.hasNext()) {
            zzuh next = it.next();
            String valueOf = String.valueOf(next.zzccr);
            zzagf.zzct(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            Iterator<String> it2 = next.zzccs.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                zzns zzjf2 = this.zzanj.zzjf();
                Object obj2 = this.mLock;
                synchronized (obj2) {
                    try {
                        if (this.zzcfb) {
                            zzuoVar = new zzuo(-1);
                        } else {
                            Iterator<zzuh> it3 = it;
                            Iterator<String> it4 = it2;
                            zzns zznsVar = zzjf;
                            obj = obj2;
                            try {
                                this.zzcfi = new zzul(this.mContext, next2, this.zzanw, this.zzcef, next, this.zzcey.zzcnd, zzjnVar, this.zzcey.zzaty, this.zzavp, this.zzcej, this.zzcey.zzauo, this.zzcey.zzauw, this.zzcey.zzcns, this.zzcey.zzcon, this.zzcek);
                                zzuo zza = this.zzcfi.zza(this.mStartTime, this.zzcez);
                                this.zzcfe.add(zza);
                                if (zza.zzcer == 0) {
                                    zzagf.zzbx("Adapter succeeded.");
                                    this.zzanj.zzf("mediation_network_succeed", next2);
                                    if (!arrayList.isEmpty()) {
                                        this.zzanj.zzf("mediation_networks_fail", TextUtils.join(",", arrayList));
                                    }
                                    this.zzanj.zza(zzjf2, "mls");
                                    this.zzanj.zza(zznsVar, "ttm");
                                    return zza;
                                }
                                arrayList.add(next2);
                                this.zzanj.zza(zzjf2, "mlf");
                                if (zza.zzcet != null) {
                                    zzahn.zzdaw.post(new zzuv(this, zza));
                                }
                                it = it3;
                                zzjf = zznsVar;
                                it2 = it4;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                        throw th;
                    }
                }
                return zzuoVar;
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzanj.zzf("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzuo(1);
    }

    @Override // com.google.android.gms.internal.zzug
    public final List<zzuo> zzlu() {
        return this.zzcfe;
    }
}
