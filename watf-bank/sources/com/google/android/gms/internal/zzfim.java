package com.google.android.gms.internal;

import java.util.List;
/* loaded from: classes.dex */
public final class zzfim extends RuntimeException {
    private final List<String> zzpko;

    public zzfim(zzfhe zzfheVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzpko = null;
    }

    public final zzfge zzczt() {
        return new zzfge(getMessage());
    }
}
