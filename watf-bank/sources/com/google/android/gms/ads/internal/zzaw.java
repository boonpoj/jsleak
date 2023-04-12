package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzaw extends zzlh {
    private static final Object sLock = new Object();
    private static zzaw zzard;
    private final Context mContext;
    private final Object mLock = new Object();
    private boolean zzare = false;
    private zzakd zzarf;

    private zzaw(Context context, zzakd zzakdVar) {
        this.mContext = context;
        this.zzarf = zzakdVar;
    }

    public static zzaw zza(Context context, zzakd zzakdVar) {
        zzaw zzawVar;
        synchronized (sLock) {
            if (zzard == null) {
                zzard = new zzaw(context.getApplicationContext(), zzakdVar);
            }
            zzawVar = zzard;
        }
        return zzawVar;
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void initialize() {
        synchronized (sLock) {
            if (this.zzare) {
                zzagf.zzcu("Mobile ads is initialized already.");
                return;
            }
            this.zzare = true;
            zznh.initialize(this.mContext);
            zzbs.zzem().zzc(this.mContext, this.zzarf);
            zzbs.zzen().initialize(this.mContext);
        }
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void setAppMuted(boolean z) {
        zzbs.zzff().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void setAppVolume(float f) {
        zzbs.zzff().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zznh.initialize(this.mContext);
        boolean booleanValue = ((Boolean) zzkb.zzif().zzd(zznh.zzbpl)).booleanValue() | ((Boolean) zzkb.zzif().zzd(zznh.zzblc)).booleanValue();
        zzax zzaxVar = null;
        if (((Boolean) zzkb.zzif().zzd(zznh.zzblc)).booleanValue()) {
            booleanValue = true;
            zzaxVar = new zzax(this, (Runnable) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
        }
        if (booleanValue) {
            zzbs.zzep().zza(this.mContext, this.zzarf, str, zzaxVar);
        }
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzagf.e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        if (context == null) {
            zzagf.e("Context is null. Failed to open debug menu.");
            return;
        }
        zzaig zzaigVar = new zzaig(context);
        zzaigVar.setAdUnitId(str);
        zzaigVar.zzcl(this.zzarf.zzcv);
        zzaigVar.showDialog();
    }

    @Override // com.google.android.gms.internal.zzlg
    public final float zzdn() {
        return zzbs.zzff().zzdn();
    }

    @Override // com.google.android.gms.internal.zzlg
    public final boolean zzdo() {
        return zzbs.zzff().zzdo();
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zzu(String str) {
        zznh.initialize(this.mContext);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbpl)).booleanValue()) {
            zzbs.zzep().zza(this.mContext, this.zzarf, str, null);
        }
    }
}
