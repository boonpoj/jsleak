package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzago extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzdak;
    private /* synthetic */ long zzdal;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzago(Context context, String str, long j) {
        super(null);
        this.val$context = context;
        this.zzdak = str;
        this.zzdal = j;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putString("app_settings_json", this.zzdak);
        edit.putLong("app_settings_last_update_ms", this.zzdal);
        edit.apply();
    }
}
