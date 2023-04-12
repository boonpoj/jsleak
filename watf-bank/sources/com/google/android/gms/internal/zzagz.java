package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagz extends zzahf {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzahg zzdai;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagz(Context context, zzahg zzahgVar) {
        super(null);
        this.val$context = context;
        this.zzdai = zzahgVar;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        SharedPreferences sharedPreferences = this.val$context.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putLong("first_ad_req_time_ms", sharedPreferences.getLong("first_ad_req_time_ms", 0L));
        zzahg zzahgVar = this.zzdai;
        if (zzahgVar != null) {
            zzahgVar.zzb(bundle);
        }
    }
}
