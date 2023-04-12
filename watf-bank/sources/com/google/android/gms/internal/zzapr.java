package com.google.android.gms.internal;
/* loaded from: assets/classes2.dex */
public final class zzapr {
    private static zzapr zzaWJ;
    private final zzapo zzaWK = new zzapo();
    private final zzapp zzaWL = new zzapp();

    static {
        zza(new zzapr());
    }

    private zzapr() {
    }

    private static zzapr zzCP() {
        zzapr zzaprVar;
        synchronized (zzapr.class) {
            zzaprVar = zzaWJ;
        }
        return zzaprVar;
    }

    public static zzapo zzCQ() {
        return zzCP().zzaWK;
    }

    public static zzapp zzCR() {
        return zzCP().zzaWL;
    }

    protected static void zza(zzapr zzaprVar) {
        synchronized (zzapr.class) {
            zzaWJ = zzaprVar;
        }
    }
}
