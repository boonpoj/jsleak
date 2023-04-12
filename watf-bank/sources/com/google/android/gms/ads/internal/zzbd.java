package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzou;
import java.util.List;
/* loaded from: classes.dex */
final class zzbd implements Runnable {
    private /* synthetic */ zzba zzarp;
    private /* synthetic */ int zzarq;
    private /* synthetic */ zzou zzart;
    private /* synthetic */ List zzaru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(zzba zzbaVar, zzou zzouVar, int i, List list) {
        this.zzarp = zzbaVar;
        this.zzart = zzouVar;
        this.zzarq = i;
        this.zzaru = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if ((this.zzart instanceof zzol) && this.zzarp.zzano.zzaul != null) {
                this.zzarp.zzanm = this.zzarq != this.zzaru.size() - 1;
                this.zzarp.zzano.zzaul.zza((zzol) this.zzart);
            } else if (!(this.zzart instanceof zzoj) || this.zzarp.zzano.zzauk == null) {
                this.zzarp.zzc(3, this.zzarq != this.zzaru.size() - 1);
            } else {
                this.zzarp.zzanm = this.zzarq != this.zzaru.size() - 1;
                this.zzarp.zzano.zzauk.zza((zzoj) this.zzart);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Could not call onAppInstallAdLoaded or onContentAdLoaded method", e);
        }
    }
}
