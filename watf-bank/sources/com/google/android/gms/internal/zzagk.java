package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagk extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzdah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagk(Context context, boolean z) {
        super(null);
        this.val$context = context;
        this.zzdah = z;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("auto_collect_location", this.zzdah);
        edit.apply();
    }
}
