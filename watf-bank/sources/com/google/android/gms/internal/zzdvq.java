package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes.dex */
final class zzdvq extends zzdvm {
    @Override // com.google.android.gms.internal.zzdvm
    public final void zza(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
    }

    @Override // com.google.android.gms.internal.zzdvm
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
