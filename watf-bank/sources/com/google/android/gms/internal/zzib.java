package com.google.android.gms.internal;

import java.util.Comparator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzib implements Comparator<zzhp> {
    public zzib(zzia zziaVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzhp zzhpVar, zzhp zzhpVar2) {
        zzhp zzhpVar3 = zzhpVar;
        zzhp zzhpVar4 = zzhpVar2;
        if (zzhpVar3.zzgz() < zzhpVar4.zzgz()) {
            return -1;
        }
        if (zzhpVar3.zzgz() > zzhpVar4.zzgz()) {
            return 1;
        }
        if (zzhpVar3.zzgy() < zzhpVar4.zzgy()) {
            return -1;
        }
        if (zzhpVar3.zzgy() > zzhpVar4.zzgy()) {
            return 1;
        }
        float zzhb = (zzhpVar3.zzhb() - zzhpVar3.zzgz()) * (zzhpVar3.zzha() - zzhpVar3.zzgy());
        float zzhb2 = (zzhpVar4.zzhb() - zzhpVar4.zzgz()) * (zzhpVar4.zzha() - zzhpVar4.zzgy());
        if (zzhb > zzhb2) {
            return -1;
        }
        return zzhb < zzhb2 ? 1 : 0;
    }
}
