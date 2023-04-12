package com.google.android.gms.internal;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaih implements DialogInterface.OnClickListener {
    private /* synthetic */ int zzdbl;
    private /* synthetic */ int zzdbm;
    private /* synthetic */ int zzdbn;
    private /* synthetic */ zzaig zzdbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaih(zzaig zzaigVar, int i, int i2, int i3) {
        this.zzdbo = zzaigVar;
        this.zzdbl = i;
        this.zzdbm = i2;
        this.zzdbn = i3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == this.zzdbl) {
            this.zzdbo.zzqm();
            return;
        }
        if (i == this.zzdbm) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbqu)).booleanValue()) {
                this.zzdbo.zzqn();
                return;
            }
        }
        if (i == this.zzdbn) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbqv)).booleanValue()) {
                this.zzdbo.zzqo();
            }
        }
    }
}
