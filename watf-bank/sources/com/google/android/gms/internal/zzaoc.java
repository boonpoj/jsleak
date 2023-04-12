package com.google.android.gms.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaoc implements Runnable {
    private /* synthetic */ zzaoa zzdng;
    private /* synthetic */ int zzdnh;
    private /* synthetic */ int zzdni;
    private /* synthetic */ boolean zzdnj;
    private /* synthetic */ boolean zzdnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoc(zzaoa zzaoaVar, int i, int i2, boolean z, boolean z2) {
        this.zzdng = zzaoaVar;
        this.zzdnh = i;
        this.zzdni = i2;
        this.zzdnj = z;
        this.zzdnk = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        zzlo zzloVar;
        zzlo zzloVar2;
        zzlo zzloVar3;
        zzlo zzloVar4;
        zzlo zzloVar5;
        zzlo zzloVar6;
        obj = this.zzdng.lock;
        synchronized (obj) {
            boolean z3 = false;
            boolean z4 = this.zzdnh != this.zzdni;
            z = this.zzdng.zzdnc;
            boolean z5 = !z && this.zzdni == 1;
            boolean z6 = z4 && this.zzdni == 1;
            boolean z7 = z4 && this.zzdni == 2;
            boolean z8 = z4 && this.zzdni == 3;
            boolean z9 = this.zzdnj != this.zzdnk;
            zzaoa zzaoaVar = this.zzdng;
            z2 = this.zzdng.zzdnc;
            zzaoaVar.zzdnc = (z2 || z5) ? true : true;
            zzloVar = this.zzdng.zzcfl;
            if (zzloVar == null) {
                return;
            }
            if (z5) {
                try {
                    zzloVar2 = this.zzdng.zzcfl;
                    zzloVar2.onVideoStart();
                } catch (RemoteException e) {
                    zzagf.zzc("Unable to call onVideoStart()", e);
                }
            }
            if (z6) {
                try {
                    zzloVar3 = this.zzdng.zzcfl;
                    zzloVar3.onVideoPlay();
                } catch (RemoteException e2) {
                    zzagf.zzc("Unable to call onVideoPlay()", e2);
                }
            }
            if (z7) {
                try {
                    zzloVar4 = this.zzdng.zzcfl;
                    zzloVar4.onVideoPause();
                } catch (RemoteException e3) {
                    zzagf.zzc("Unable to call onVideoPause()", e3);
                }
            }
            if (z8) {
                try {
                    zzloVar5 = this.zzdng.zzcfl;
                    zzloVar5.onVideoEnd();
                } catch (RemoteException e4) {
                    zzagf.zzc("Unable to call onVideoEnd()", e4);
                }
            }
            if (z9) {
                try {
                    zzloVar6 = this.zzdng.zzcfl;
                    zzloVar6.onVideoMute(this.zzdnk);
                } catch (RemoteException e5) {
                    zzagf.zzc("Unable to call onVideoMute()", e5);
                }
            }
        }
    }
}
