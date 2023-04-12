package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagm extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ int zzdaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagm(Context context, int i) {
        super(null);
        this.val$context = context;
        this.zzdaj = i;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putInt("version_code", this.zzdaj);
        edit.apply();
    }
}
