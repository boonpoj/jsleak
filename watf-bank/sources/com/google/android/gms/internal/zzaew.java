package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zzaew implements zzafc {
    private zzafd zzcwo;

    public zzaew(zzafd zzafdVar) {
        this.zzcwo = zzafdVar;
    }

    @Override // com.google.android.gms.internal.zzafc
    public final zzafb zza(Context context, zzakd zzakdVar, zzaax zzaaxVar) {
        if (zzaaxVar.zzcpr == null) {
            return null;
        }
        return new zzaes(context, zzakdVar, zzaaxVar.zzcpr, zzaaxVar.zzcja, this.zzcwo);
    }
}
