package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagu extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ long zzdan;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagu(Context context, long j) {
        super(null);
        this.val$context = context;
        this.zzdan = j;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putLong("app_last_background_time_ms", this.zzdan);
        edit.apply();
    }
}
