package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajj;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzo implements Runnable {
    final /* synthetic */ zzcv zzcbd;
    final /* synthetic */ zzae zzcbe;
    final /* synthetic */ zzn zzcbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzn zznVar, zzcv zzcvVar, zzae zzaeVar) {
        this.zzcbf = zznVar;
        this.zzcbd = zzcvVar;
        this.zzcbe = zzaeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        zzakd zzakdVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            context = this.zzcbf.mContext;
            zzakdVar = this.zzcbf.zzapr;
            zze zzeVar = new zze(context, zzakdVar, this.zzcbd, null);
            zzeVar.zza(new zzp(this, zzeVar));
            zzeVar.zza("/jsLoaded", new zzs(this, zzeVar));
            zzajj zzajjVar = new zzajj();
            zzt zztVar = new zzt(this, zzeVar, zzajjVar);
            zzajjVar.set(zztVar);
            zzeVar.zza("/requestReload", zztVar);
            str = this.zzcbf.zzcay;
            if (str.endsWith(".js")) {
                str5 = this.zzcbf.zzcay;
                zzeVar.zzbb(str5);
            } else {
                str2 = this.zzcbf.zzcay;
                if (str2.startsWith("<html>")) {
                    str4 = this.zzcbf.zzcay;
                    zzeVar.zzbd(str4);
                } else {
                    str3 = this.zzcbf.zzcay;
                    zzeVar.zzbc(str3);
                }
            }
            zzahn.zzdaw.postDelayed(new zzu(this, zzeVar), zzy.zzcbn);
        } catch (Throwable th) {
            zzagf.zzb("Error creating webview.", th);
            zzbs.zzem().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            this.zzcbe.reject();
        }
    }
}
