package com.google.android.gms.internal;

import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzhi implements Runnable {
    private /* synthetic */ zzhh zzaza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhi(zzhh zzhhVar) {
        this.zzaza = zzhhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List<zzhj> list;
        obj = this.zzaza.mLock;
        synchronized (obj) {
            z = this.zzaza.zzayu;
            if (z) {
                z2 = this.zzaza.zzayv;
                if (z2) {
                    this.zzaza.zzayu = false;
                    zzagf.zzbx("App went background");
                    list = this.zzaza.zzayw;
                    for (zzhj zzhjVar : list) {
                        try {
                            zzhjVar.zzg(false);
                        } catch (Exception e) {
                            zzagf.zzb("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                }
            }
            zzagf.zzbx("App is still foreground");
        }
    }
}
