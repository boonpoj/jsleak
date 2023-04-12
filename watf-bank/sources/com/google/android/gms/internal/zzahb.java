package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzahb extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzdaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzahb(Context context, boolean z) {
        super(null);
        this.val$context = context;
        this.zzdaq = z;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("content_url_opted_out", this.zzdaq);
        edit.apply();
    }
}
