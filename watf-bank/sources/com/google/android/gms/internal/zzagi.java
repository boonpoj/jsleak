package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagi extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzdaf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagi(Context context, boolean z) {
        super(null);
        this.val$context = context;
        this.zzdaf = z;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("use_https", this.zzdaf);
        edit.apply();
    }
}
