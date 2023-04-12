package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagw extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ int zzdao;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagw(Context context, int i) {
        super(null);
        this.val$context = context;
        this.zzdao = i;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putInt("request_in_session_count", this.zzdao);
        edit.apply();
    }
}
