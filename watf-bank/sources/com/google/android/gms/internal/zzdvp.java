package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
/* loaded from: classes.dex */
final class zzdvp extends zzdvm {
    private final zzdvn zzmam = new zzdvn();

    @Override // com.google.android.gms.internal.zzdvm
    public final void zza(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> zza = this.zzmam.zza(th, false);
        if (zza == null) {
            return;
        }
        synchronized (zza) {
            for (Throwable th2 : zza) {
                printStream.print("Suppressed: ");
                th2.printStackTrace(printStream);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdvm
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> zza = this.zzmam.zza(th, false);
        if (zza == null) {
            return;
        }
        synchronized (zza) {
            for (Throwable th2 : zza) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}
