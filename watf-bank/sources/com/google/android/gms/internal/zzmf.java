package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqi;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmf implements Runnable {
    private /* synthetic */ zzme zzbgs;

    /* renamed from: com.google.android.gms.internal.zzmf$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzqi.zzc<zzmh> {
        final /* synthetic */ zzmq zzQX;

        AnonymousClass1(zzmq zzmqVar) {
            this.zzQX = zzmqVar;
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zzc */
        public void zzd(zzmh zzmhVar) {
            if (zzmf.this.zza(this.zzQX, zzmhVar)) {
                return;
            }
            zzmf.this.zziY();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmf$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzqi.zza {
        AnonymousClass2() {
        }

        @Override // com.google.android.gms.internal.zzqi.zza
        public void run() {
            zzmf.this.zziY();
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    public static final class zza extends zzmf {
        private final Context mContext;

        public zza(Context context, zzqi<zzmh> zzqiVar, zzme.zza zzaVar) {
            super(zzqiVar, zzaVar);
            this.mContext = context;
        }

        public void zziY() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.zzmq, com.google.android.gms.internal.zzmz] */
        public zzmq zziZ() {
            return zzmz.zza(this.mContext, new zzfq((String) zzfx.zzAR.get()), zzmy.zzjf());
        }

        public /* synthetic */ Object zziw() {
            return super.zzit();
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    public static class zzb extends zzmf implements zzf.zzb, zzf.zzc {
        private Context mContext;
        private zzqi<zzmh> zzQV;
        private final zzme.zza zzQW;
        protected zzmg zzQZ;
        private boolean zzRa;
        private final Object zzrN;
        private zzqa zztr;

        public zzb(Context context, zzqa zzqaVar, zzqi<zzmh> zzqiVar, zzme.zza zzaVar) {
            super(zzqiVar, zzaVar);
            Looper mainLooper;
            this.zzrN = new Object();
            this.mContext = context;
            this.zztr = zzqaVar;
            this.zzQV = zzqiVar;
            this.zzQW = zzaVar;
            if (((Boolean) zzfx.zzBE.get()).booleanValue()) {
                this.zzRa = true;
                mainLooper = com.google.android.gms.ads.internal.zzv.zzcZ().zzkC();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzQZ = new zzmg(context, mainLooper, this, this, this.zztr.zzYc);
            connect();
        }

        protected void connect() {
            this.zzQZ.zzwT();
        }

        public void onConnected(Bundle bundle) {
            zziw();
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzpe.zzbc("Cannot connect to remote service, fallback to local instance.");
            zzja().zziw();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            com.google.android.gms.ads.internal.zzv.zzcJ().zzb(this.mContext, this.zztr.zzaZ, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int i) {
            zzpe.zzbc("Disconnected from remote ad request service.");
        }

        public void zziY() {
            synchronized (this.zzrN) {
                if (this.zzQZ.isConnected() || this.zzQZ.isConnecting()) {
                    this.zzQZ.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzRa) {
                    com.google.android.gms.ads.internal.zzv.zzcZ().zzkD();
                    this.zzRa = false;
                }
            }
        }

        public zzmq zziZ() {
            zzmq zzjb;
            synchronized (this.zzrN) {
                try {
                    try {
                        zzjb = this.zzQZ.zzjb();
                    } catch (DeadObjectException | IllegalStateException unused) {
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzjb;
        }

        public /* synthetic */ Object zziw() {
            return super.zzit();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzmf$zza, com.google.android.gms.internal.zzpk] */
        zzpk zzja() {
            return new zza(this.mContext, this.zzQV, this.zzQW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmf(zzme zzmeVar) {
        this.zzbgs = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkh zzkhVar;
        zzkh zzkhVar2;
        zzkhVar = this.zzbgs.zzbgr.zzape;
        if (zzkhVar != null) {
            try {
                zzkhVar2 = this.zzbgs.zzbgr.zzape;
                zzkhVar2.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzakb.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
