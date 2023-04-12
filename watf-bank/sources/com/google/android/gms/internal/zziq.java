package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zznt;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zziq implements zzin {

    /* renamed from: com.google.android.gms.internal.zziq$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends zzel.zza {
        AnonymousClass1() {
        }

        public void onAdClosed() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.1.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzti != null) {
                        zzirVar.zzti.onAdClosed();
                    }
                    com.google.android.gms.ads.internal.zzv.zzcY().zzgj();
                }
            });
        }

        public void onAdFailedToLoad(final int i) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.1.2
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzti != null) {
                        zzirVar.zzti.onAdFailedToLoad(i);
                    }
                }
            });
            zzpe.v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.1.3
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzti != null) {
                        zzirVar.zzti.onAdLeftApplication();
                    }
                }
            });
        }

        public void onAdLoaded() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.1.4
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzti != null) {
                        zzirVar.zzti.onAdLoaded();
                    }
                }
            });
            zzpe.v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.1.5
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzti != null) {
                        zzirVar.zzti.onAdOpened();
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 extends zzer.zza {
        AnonymousClass2() {
        }

        public void onAppEvent(final String str, final String str2) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.2.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIt != null) {
                        zzirVar.zzIt.onAppEvent(str, str2);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 extends zzkz.zza {
        AnonymousClass3() {
        }

        public void zza(final zzky zzkyVar) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.3.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIu != null) {
                        zzirVar.zzIu.zza(zzkyVar);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 extends zzgj.zza {
        AnonymousClass4() {
        }

        public void zza(final zzgi zzgiVar) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.4.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIv != null) {
                        zzirVar.zzIv.zza(zzgiVar);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 extends zzek.zza {
        AnonymousClass5() {
        }

        public void onAdClicked() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.5.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIw != null) {
                        zzirVar.zzIw.onAdClicked();
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 extends zznt.zza {
        AnonymousClass6() {
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.4
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoAdClosed();
                    }
                }
            });
        }

        public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.7
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoAdFailedToLoad(i);
                    }
                }
            });
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.6
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoAdLeftApplication();
                    }
                }
            });
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.1
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoAdLoaded();
                    }
                }
            });
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.2
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoAdOpened();
                    }
                }
            });
        }

        public void onRewardedVideoStarted() throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.3
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.onRewardedVideoStarted();
                    }
                }
            });
        }

        public void zza(final zznq zznqVar) throws RemoteException {
            zziq.zza(zziq.this).add(new zza(this) { // from class: com.google.android.gms.internal.zziq.6.5
                @Override // com.google.android.gms.internal.zziq.zza
                public void zzb(zzir zzirVar) throws RemoteException {
                    if (zzirVar.zzIx != null) {
                        zzirVar.zzIx.zza(zznqVar);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ zza zzIr;
        final /* synthetic */ zzir zzIs;

        AnonymousClass7(zziq zziqVar, zza zzaVar, zzir zzirVar) {
            this.zzIr = zzaVar;
            this.zzIs = zzirVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.zzIr.zzb(this.zzIs);
            } catch (RemoteException e) {
                zzpe.zzc("Could not propagate interstitial ad event.", e);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    interface zza {
        void zzb(zzir zzirVar) throws RemoteException;
    }

    @Override // com.google.android.gms.internal.zzin
    public final JSONObject zze(Context context) {
        return new JSONObject();
    }
}
