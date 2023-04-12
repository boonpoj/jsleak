package com.google.android.gms.internal;

import android.os.Bundle;
@zzzv
/* loaded from: classes.dex */
public final class zztk {
    private static zztk zzcae = new zztk();
    private int zzcaf;
    private int zzcag;
    private int zzcah;
    private int zzcai;
    private int zzcaj;

    public static zztk zzlc() {
        return zzcae;
    }

    public final Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.zzcaf);
        bundle.putInt("ipds", this.zzcag);
        bundle.putInt("ipde", this.zzcah);
        bundle.putInt("iph", this.zzcai);
        bundle.putInt("ipm", this.zzcaj);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzld() {
        this.zzcag++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzle() {
        this.zzcah++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzlf() {
        this.zzcai++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzlg() {
        this.zzcaj++;
    }

    public final int zzlh() {
        return this.zzcag;
    }

    public final int zzli() {
        return this.zzcah;
    }

    public final int zzlj() {
        return this.zzcai;
    }

    public final int zzlk() {
        return this.zzcaj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(int i) {
        this.zzcaf += i;
    }
}
