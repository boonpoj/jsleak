package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public final class zzur implements zzug {
    private final Context mContext;
    private final long mStartTime;
    private final zzux zzanw;
    private final boolean zzavp;
    private final zzui zzcef;
    private final boolean zzcej;
    private final boolean zzcek;
    private final zzaat zzcey;
    private final long zzcez;
    private final String zzcfd;
    private final Object mLock = new Object();
    private boolean zzcfb = false;
    private final Map<zzakv<zzuo>, zzul> zzcfc = new HashMap();
    private List<zzuo> zzcfe = new ArrayList();
    private final int zzcfa = 2;

    public zzur(Context context, zzaat zzaatVar, zzux zzuxVar, zzui zzuiVar, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.mContext = context;
        this.zzcey = zzaatVar;
        this.zzanw = zzuxVar;
        this.zzcef = zzuiVar;
        this.zzavp = z;
        this.zzcej = z2;
        this.zzcfd = str;
        this.mStartTime = j;
        this.zzcez = j2;
        this.zzcek = z3;
    }

    private final void zza(zzakv<zzuo> zzakvVar) {
        zzahn.zzdaw.post(new zzut(this, zzakvVar));
    }

    private final zzuo zzi(List<zzakv<zzuo>> list) {
        synchronized (this.mLock) {
            if (this.zzcfb) {
                return new zzuo(-1);
            }
            for (zzakv<zzuo> zzakvVar : list) {
                try {
                    zzuo zzuoVar = zzakvVar.get();
                    this.zzcfe.add(zzuoVar);
                    if (zzuoVar != null && zzuoVar.zzcer == 0) {
                        zza(zzakvVar);
                        return zzuoVar;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzagf.zzc("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza((zzakv<zzuo>) null);
            return new zzuo(1);
        }
    }

    private final zzuo zzj(List<zzakv<zzuo>> list) {
        zzuo zzuoVar;
        zzuo zzuoVar2;
        zzvg zzvgVar;
        synchronized (this.mLock) {
            if (this.zzcfb) {
                return new zzuo(-1);
            }
            long j = this.zzcef.zzcdu != -1 ? this.zzcef.zzcdu : 10000L;
            zzakv<zzuo> zzakvVar = null;
            long j2 = j;
            zzuo zzuoVar3 = null;
            int i = -1;
            for (zzakv<zzuo> zzakvVar2 : list) {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
                if (j2 == 0) {
                    try {
                        try {
                        } finally {
                            Math.max(j2 - (com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis() - currentTimeMillis), 0L);
                        }
                    } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e) {
                        zzagf.zzc("Exception while processing an adapter; continuing with other adapters", e);
                    }
                    if (zzakvVar2.isDone()) {
                        zzuoVar = zzakvVar2.get();
                        zzuoVar2 = zzuoVar;
                        this.zzcfe.add(zzuoVar2);
                        if (zzuoVar2 != null && zzuoVar2.zzcer == 0 && (zzvgVar = zzuoVar2.zzcew) != null && zzvgVar.zzmc() > i) {
                            i = zzvgVar.zzmc();
                            zzakvVar = zzakvVar2;
                            zzuoVar3 = zzuoVar2;
                        }
                    }
                }
                zzuoVar = zzakvVar2.get(j2, TimeUnit.MILLISECONDS);
                zzuoVar2 = zzuoVar;
                this.zzcfe.add(zzuoVar2);
                if (zzuoVar2 != null) {
                    i = zzvgVar.zzmc();
                    zzakvVar = zzakvVar2;
                    zzuoVar3 = zzuoVar2;
                }
            }
            zza(zzakvVar);
            return zzuoVar3 == null ? new zzuo(1) : zzuoVar3;
        }
    }

    @Override // com.google.android.gms.internal.zzug
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzcfb = true;
            for (zzul zzulVar : this.zzcfc.values()) {
                zzulVar.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzug
    public final zzuo zzh(List<zzuh> list) {
        zzagf.zzbx("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        zzjn zzjnVar = this.zzcey.zzauc;
        int[] iArr = new int[2];
        if (zzjnVar.zzbem != null) {
            com.google.android.gms.ads.internal.zzbs.zzez();
            if (zzuq.zza(this.zzcfd, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                zzjn[] zzjnVarArr = zzjnVar.zzbem;
                int length = zzjnVarArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    zzjn zzjnVar2 = zzjnVarArr[i];
                    if (i2 == zzjnVar2.width && i3 == zzjnVar2.height) {
                        zzjnVar = zzjnVar2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<zzuh> it = list.iterator();
        while (it.hasNext()) {
            zzuh next = it.next();
            String valueOf = String.valueOf(next.zzccr);
            zzagf.zzct(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            for (Iterator<String> it2 = next.zzccs.iterator(); it2.hasNext(); it2 = it2) {
                ArrayList arrayList2 = arrayList;
                zzul zzulVar = new zzul(this.mContext, it2.next(), this.zzanw, this.zzcef, next, this.zzcey.zzcnd, zzjnVar, this.zzcey.zzaty, this.zzavp, this.zzcej, this.zzcey.zzauo, this.zzcey.zzauw, this.zzcey.zzcns, this.zzcey.zzcon, this.zzcek);
                zzakv<zzuo> zza = zzahh.zza(newCachedThreadPool, new zzus(this, zzulVar));
                this.zzcfc.put(zza, zzulVar);
                arrayList2.add(zza);
                it = it;
                arrayList = arrayList2;
            }
        }
        ArrayList arrayList3 = arrayList;
        return this.zzcfa != 2 ? zzi(arrayList3) : zzj(arrayList3);
    }

    @Override // com.google.android.gms.internal.zzug
    public final List<zzuo> zzlu() {
        return this.zzcfe;
    }
}
