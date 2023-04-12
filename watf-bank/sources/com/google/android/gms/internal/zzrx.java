package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public final class zzrx implements zzm {
    private final Context mContext;
    private final Object mLock = new Object();
    private zzrq zzbys;
    private boolean zzbyt;

    public zzrx(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbys == null) {
                return;
            }
            this.zzbys.disconnect();
            this.zzbys = null;
            Binder.flushPendingCommands();
        }
    }

    private final Future<ParcelFileDescriptor> zzb(zzrr zzrrVar) {
        zzry zzryVar = new zzry(this);
        zzrz zzrzVar = new zzrz(this, zzryVar, zzrrVar);
        zzsc zzscVar = new zzsc(this, zzryVar);
        synchronized (this.mLock) {
            this.zzbys = new zzrq(this.mContext, com.google.android.gms.ads.internal.zzbs.zzew().zzqs(), zzrzVar, zzscVar);
            this.zzbys.zzakj();
        }
        return zzryVar;
    }

    @Override // com.google.android.gms.internal.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzad {
        zzp zzpVar;
        zzrr zzg = zzrr.zzg(zzrVar);
        long intValue = ((Integer) zzkb.zzif().zzd(zznh.zzbqq)).intValue();
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime();
        try {
            zzrt zzrtVar = (zzrt) new zzabj(zzb(zzg).get(intValue, TimeUnit.MILLISECONDS)).zza(zzrt.CREATOR);
            if (zzrtVar.zzbyq) {
                throw new zzad(zzrtVar.zzbyr);
            }
            if (zzrtVar.zzbyo.length != zzrtVar.zzbyp.length) {
                zzpVar = null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzrtVar.zzbyo.length; i++) {
                    hashMap.put(zzrtVar.zzbyo[i], zzrtVar.zzbyp[i]);
                }
                zzpVar = new zzp(zzrtVar.statusCode, zzrtVar.data, hashMap, zzrtVar.zzad, zzrtVar.zzae);
            }
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
            sb.append("ms");
            zzagf.v(sb.toString());
            return zzpVar;
        } catch (InterruptedException e) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzagf.v(sb2.toString());
            return null;
        } catch (ExecutionException e2) {
            StringBuilder sb22 = new StringBuilder(52);
            sb22.append("Http assets remote cache took ");
            sb22.append(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
            sb22.append("ms");
            zzagf.v(sb22.toString());
            return null;
        } catch (TimeoutException e3) {
            StringBuilder sb222 = new StringBuilder(52);
            sb222.append("Http assets remote cache took ");
            sb222.append(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
            sb222.append("ms");
            zzagf.v(sb222.toString());
            return null;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
            sb3.append("ms");
            zzagf.v(sb3.toString());
            throw th;
        }
    }
}
