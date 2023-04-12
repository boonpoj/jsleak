package com.google.android.gms.internal;

import android.view.View;
/* loaded from: classes.dex */
public class zzaia extends zzahz {
    @Override // com.google.android.gms.internal.zzaht
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.zzaht
    public final int zzqh() {
        return 14;
    }
}
