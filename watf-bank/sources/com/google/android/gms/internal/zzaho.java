package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaho implements zzof {
    private /* synthetic */ Context val$context;
    private /* synthetic */ List zzdbc;
    private /* synthetic */ zzoe zzdbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaho(zzahn zzahnVar, List list, zzoe zzoeVar, Context context) {
        this.zzdbc = list;
        this.zzdbd = zzoeVar;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zzjl() {
        for (String str : this.zzdbc) {
            String valueOf = String.valueOf(str);
            zzagf.zzct(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.zzdbd.mayLaunchUrl(Uri.parse(str), null, null);
        }
        this.zzdbd.zzc((Activity) this.val$context);
    }
}
