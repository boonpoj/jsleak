package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzjp extends zzky {
    private final AppEventListener zzamt;

    /* renamed from: com.google.android.gms.internal.zzjp$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Callable<zzjn> {
        final /* synthetic */ zzjm zzKN;

        AnonymousClass1(zzjm zzjmVar) {
            this.zzKN = zzjmVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: zzgI */
        public zzjn call() throws Exception {
            synchronized (zzjp.zza(zzjp.this)) {
                if (zzjp.zzb(zzjp.this)) {
                    return null;
                }
                return this.zzKN.zza(zzjp.zzc(zzjp.this), zzjp.zzd(zzjp.this));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjp$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzqf zzKP;

        AnonymousClass2(zzqf zzqfVar) {
            this.zzKP = zzqfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (zzqf zzqfVar : zzjp.zze(zzjp.this).keySet()) {
                if (zzqfVar != this.zzKP) {
                    ((zzjm) zzjp.zze(zzjp.this).get(zzqfVar)).cancel();
                }
            }
        }
    }

    public zzjp(AppEventListener appEventListener) {
        this.zzamt = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzamt;
    }

    @Override // com.google.android.gms.internal.zzkx
    public final void onAppEvent(String str, String str2) {
        this.zzamt.onAppEvent(str, str2);
    }
}
