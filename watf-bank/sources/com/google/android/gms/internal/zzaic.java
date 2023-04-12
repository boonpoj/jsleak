package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class zzaic extends zzaia {
    @Override // com.google.android.gms.internal.zzaia, com.google.android.gms.internal.zzaht
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.zzaht
    public final ViewGroup.LayoutParams zzqi() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
