package com.google.android.gms.internal;

import android.webkit.ValueCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzhn implements ValueCallback<String> {
    private /* synthetic */ zzhm zzazs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhn(zzhm zzhmVar) {
        this.zzazs = zzhmVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.zzazs.zzazn.zza(this.zzazs.zzazp, this.zzazs.zzazq, str, this.zzazs.zzazr);
    }
}
