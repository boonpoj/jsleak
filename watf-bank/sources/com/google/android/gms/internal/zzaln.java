package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
@zzzv
/* loaded from: classes.dex */
public final class zzaln {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzalo(view, onGlobalLayoutListener).zzrh();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzalp(view, onScrollChangedListener).zzrh();
    }
}
