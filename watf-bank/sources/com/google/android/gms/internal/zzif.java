package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzif implements zzhj {
    private /* synthetic */ zzid zzbaw;

    /* loaded from: assets/classes2.dex */
    public interface zza {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(zzid zzidVar) {
        this.zzbaw = zzidVar;
    }

    @Override // com.google.android.gms.internal.zzhj
    public final void zzg(boolean z) {
        if (z) {
            this.zzbaw.connect();
        } else {
            this.zzbaw.disconnect();
        }
    }
}
