package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzix {
    zzfl zzbcn;
    boolean zzbco;

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzgu();
    }

    public zzix() {
    }

    public zzix(Context context) {
        zznh.initialize(context);
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbrf)).booleanValue()) {
            try {
                this.zzbcn = zzfm.zzb(DynamiteModule.zza(context, DynamiteModule.zzgww, ModuleDescriptor.MODULE_ID).zzhb("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
                com.google.android.gms.dynamic.zzn.zzz(context);
                this.zzbcn.zza(com.google.android.gms.dynamic.zzn.zzz(context), "GMA_SDK");
                this.zzbco = true;
            } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
                zzakb.zzbx("Cannot dynamite load clearcut");
            }
        }
    }

    public zzix(Context context, String str, String str2) {
        zznh.initialize(context);
        try {
            this.zzbcn = zzfm.zzb(DynamiteModule.zza(context, DynamiteModule.zzgww, ModuleDescriptor.MODULE_ID).zzhb("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
            com.google.android.gms.dynamic.zzn.zzz(context);
            this.zzbcn.zza(com.google.android.gms.dynamic.zzn.zzz(context), str, null);
            this.zzbco = true;
        } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
            zzakb.zzbx("Cannot dynamite load clearcut");
        }
    }

    public final zziz zzd(byte[] bArr) {
        return new zziz(this, bArr, null);
    }
}
