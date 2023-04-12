package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzcu extends zzct {
    private zzcu(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzcu zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzcu(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzct
    public final List<Callable<Void>> zza(zzdm zzdmVar, zzaz zzazVar, zzaw zzawVar) {
        if (zzdmVar.zzag() == null || !this.zzahr) {
            return super.zza(zzdmVar, zzazVar, zzawVar);
        }
        int zzac = zzdmVar.zzac();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzdmVar, zzazVar, zzawVar));
        arrayList.add(new zzed(zzdmVar, "VywbbfxE2QuRqZ5xcIwapO7AdSzfVaSWnmJxmUg+0adJ3QBAH5P7EgXr1uzyY+u6", "JgKAyQW0PWqOrZHk4ZNT0IJH02FdSWTXOOjBnF9RRok=", zzazVar, zzac, 24));
        return arrayList;
    }
}
