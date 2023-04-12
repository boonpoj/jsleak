package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzqi;
import java.util.concurrent.Callable;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmz extends zzmx<Integer> {

    /* renamed from: com.google.android.gms.internal.zzmz$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements Callable<Void> {
        final /* synthetic */ zzmy zzSW;
        final /* synthetic */ zzmh zzSX;
        final /* synthetic */ Bundle zzSY;
        final /* synthetic */ Context zztd;

        AnonymousClass1(zzmy zzmyVar, Context context, zzmh zzmhVar, Bundle bundle) {
            this.zzSW = zzmyVar;
            this.zztd = context;
            this.zzSX = zzmhVar;
            this.zzSY = bundle;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: zzbl */
        public Void call() throws Exception {
            String str = this.zzSX.zzRe.packageName;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.internal.zzmz$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public final class AnonymousClass2 implements Runnable {
        final /* synthetic */ zznb zzSZ;
        final /* synthetic */ zzgd zzTa;
        final /* synthetic */ String zzTb;
        final /* synthetic */ zzgf zzsK;
        final /* synthetic */ zzja zzsZ;

        AnonymousClass2(zzja zzjaVar, zznb zznbVar, zzgf zzgfVar, zzgd zzgdVar, String str) {
            this.zzsZ = zzjaVar;
            this.zzSZ = zznbVar;
            this.zzsK = zzgfVar;
            this.zzTa = zzgdVar;
            this.zzTb = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzja.zzc zzgv = this.zzsZ.zzgv();
            this.zzSZ.zzb(zzgv);
            this.zzsK.zza(this.zzTa, new String[]{"rwc"});
            final zzgd zzfw = this.zzsK.zzfw();
            zzgv.zza(new zzqi.zzc<zzjb>() { // from class: com.google.android.gms.internal.zzmz.2.1
                @Override // com.google.android.gms.internal.zzqi.zzc
                /* renamed from: zzb */
                public void zzd(zzjb zzjbVar) {
                    AnonymousClass2.this.zzsK.zza(zzfw, new String[]{"jsf"});
                    AnonymousClass2.this.zzsK.zzfx();
                    zzjbVar.zza("/invalidRequest", AnonymousClass2.this.zzSZ.zzTk);
                    zzjbVar.zza("/loadAdURL", AnonymousClass2.this.zzSZ.zzTl);
                    zzjbVar.zza("/loadAd", AnonymousClass2.this.zzSZ.zzTm);
                    try {
                        zzjbVar.zzi("AFMA_getAd", AnonymousClass2.this.zzTb);
                    } catch (Exception e) {
                        zzpe.zzb("Error requesting an ad url", e);
                    }
                }
            }, new zzqi.zza(this) { // from class: com.google.android.gms.internal.zzmz.2.2
                @Override // com.google.android.gms.internal.zzqi.zza
                public void run() {
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ zzmy zzSW;
        final /* synthetic */ zzmh zzSX;
        final /* synthetic */ zznb zzSZ;
        final /* synthetic */ Context zztd;

        AnonymousClass3(zzmy zzmyVar, Context context, zznb zznbVar, zzmh zzmhVar) {
            this.zzSW = zzmyVar;
            this.zztd = context;
            this.zzSZ = zznbVar;
            this.zzSX = zzmhVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zzSW.zzSM.zza(this.zztd, this.zzSZ, this.zzSX.zzvf);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements zzpn<zzix> {
        AnonymousClass4(zzmz zzmzVar) {
        }

        /* renamed from: zza */
        public void zzd(zzix zzixVar) {
            zzixVar.zza("/log", zzhw.zzHl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ zzmh zzSX;
        final /* synthetic */ zzmr zzTe;

        AnonymousClass5(zzmh zzmhVar, zzmr zzmrVar) {
            this.zzSX = zzmhVar;
            this.zzTe = zzmrVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzmk zzmkVar;
            try {
                zzmkVar = zzmz.this.zzd(this.zzSX);
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzv.zzcN().zza(e, "AdRequestServiceImpl.loadAdAsync");
                zzpe.zzc("Could not fetch ad response due to an Exception.", e);
                zzmkVar = null;
            }
            if (zzmkVar == null) {
                zzmkVar = new zzmk(0);
            }
            try {
                this.zzTe.zzb(zzmkVar);
            } catch (RemoteException e2) {
                zzpe.zzc("Fail to forward ad response.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmz(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Integer zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zziv().intValue()));
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(getKey(), num.intValue());
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Integer zzc(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), zziv().intValue()));
    }
}
