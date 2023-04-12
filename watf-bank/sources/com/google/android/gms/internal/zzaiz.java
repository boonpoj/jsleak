package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaiz implements zzx {
    private /* synthetic */ String zzcml;
    private /* synthetic */ zzajc zzdcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiz(zzaiv zzaivVar, String str, zzajc zzajcVar) {
        this.zzcml = str;
        this.zzdcn = zzajcVar;
    }

    @Override // com.google.android.gms.internal.zzx
    public final void zzd(zzad zzadVar) {
        String str = this.zzcml;
        String zzadVar2 = zzadVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzadVar2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzadVar2);
        zzagf.zzcu(sb.toString());
        this.zzdcn.zzb(null);
    }
}
