package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagq extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzdam;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagq(Context context, String str) {
        super(null);
        this.val$context = context;
        this.zzdam = str;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putString("native_advanced_settings", this.zzdam);
        edit.apply();
    }
}
