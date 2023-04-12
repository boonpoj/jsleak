package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfhz extends zzfhy<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfhz(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.zzfhy
    public final void zzbiy() {
        if (!isImmutable()) {
            for (int i = 0; i < zzczj(); i++) {
                Map.Entry<FieldDescriptorType, Object> zzmb = zzmb(i);
                if (((zzffs) zzmb.getKey()).zzcxj()) {
                    zzmb.setValue(Collections.unmodifiableList((List) zzmb.getValue()));
                }
            }
            Iterator it = zzczk().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzffs) entry.getKey()).zzcxj()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbiy();
    }
}
