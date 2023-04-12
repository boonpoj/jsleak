package com.google.android.gms.internal;

import java.util.Comparator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzhs implements Comparator<zzhy> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhs(zzhr zzhrVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzhy zzhyVar, zzhy zzhyVar2) {
        zzhy zzhyVar3 = zzhyVar;
        zzhy zzhyVar4 = zzhyVar2;
        int i = zzhyVar3.zzbaj - zzhyVar4.zzbaj;
        return i != 0 ? i : (int) (zzhyVar3.value - zzhyVar4.value);
    }
}
