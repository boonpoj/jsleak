package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzmt {
    private final Context mContext;

    public zzmt(Context context) {
        com.google.android.gms.common.internal.zzbq.checkNotNull(context, "Context can not be null");
        this.mContext = context;
    }

    private final boolean zza(Intent intent) {
        com.google.android.gms.common.internal.zzbq.checkNotNull(intent, "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzir() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzis() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public final boolean zzit() {
        return ((Boolean) zzajk.zza(this.mContext, new zzmu())).booleanValue() && zzbhf.zzdb(this.mContext).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean zziu() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
