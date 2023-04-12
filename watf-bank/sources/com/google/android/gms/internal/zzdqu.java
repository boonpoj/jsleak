package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqu implements zzdpv {
    private /* synthetic */ zzdqc zzlte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqu(zzdqc zzdqcVar) {
        this.zzlte = zzdqcVar;
    }

    @Override // com.google.android.gms.internal.zzdpv
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzdua.zzc(this.zzlte.zzblv().zzblx(), ((zzdpv) this.zzlte.zzblv().zzblw()).zzd(bArr, bArr2));
    }
}
