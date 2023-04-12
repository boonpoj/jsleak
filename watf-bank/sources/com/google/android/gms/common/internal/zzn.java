package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzn extends zze {
    private /* synthetic */ zzd zzfza;
    private IBinder zzfze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzd zzdVar, int i, IBinder iBinder, Bundle bundle) {
        super(zzdVar, i, bundle);
        this.zzfza = zzdVar;
        this.zzfze = iBinder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
        if (r0 != false) goto L15;
     */
    @Override // com.google.android.gms.common.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final boolean zzakr() {
        /*
            r6 = this;
            java.lang.String r0 = "GmsClient"
            r1 = 0
            android.os.IBinder r2 = r6.zzfze     // Catch: android.os.RemoteException -> L88
            java.lang.String r2 = r2.getInterfaceDescriptor()     // Catch: android.os.RemoteException -> L88
            com.google.android.gms.common.internal.zzd r3 = r6.zzfza
            java.lang.String r3 = r3.zzhj()
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L4b
            com.google.android.gms.common.internal.zzd r3 = r6.zzfza
            java.lang.String r3 = r3.zzhj()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 34
            java.lang.String r5 = java.lang.String.valueOf(r2)
            int r5 = r5.length()
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "service descriptor mismatch: "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = " vs. "
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.e(r0, r2)
            return r1
        L4b:
            com.google.android.gms.common.internal.zzd r0 = r6.zzfza
            android.os.IBinder r2 = r6.zzfze
            android.os.IInterface r0 = r0.zzd(r2)
            if (r0 == 0) goto L87
            com.google.android.gms.common.internal.zzd r2 = r6.zzfza
            r3 = 2
            r4 = 4
            boolean r2 = com.google.android.gms.common.internal.zzd.zza(r2, r3, r4, r0)
            if (r2 != 0) goto L68
            com.google.android.gms.common.internal.zzd r2 = r6.zzfza
            r3 = 3
            boolean r0 = com.google.android.gms.common.internal.zzd.zza(r2, r3, r4, r0)
            if (r0 == 0) goto L87
        L68:
            com.google.android.gms.common.internal.zzd r0 = r6.zzfza
            r1 = 0
            com.google.android.gms.common.internal.zzd.zza(r0, r1)
            com.google.android.gms.common.internal.zzd r0 = r6.zzfza
            android.os.Bundle r0 = r0.zzafi()
            com.google.android.gms.common.internal.zzd r1 = r6.zzfza
            com.google.android.gms.common.internal.zzf r1 = com.google.android.gms.common.internal.zzd.zze(r1)
            if (r1 == 0) goto L85
            com.google.android.gms.common.internal.zzd r1 = r6.zzfza
            com.google.android.gms.common.internal.zzf r1 = com.google.android.gms.common.internal.zzd.zze(r1)
            r1.onConnected(r0)
        L85:
            r0 = 1
            return r0
        L87:
            return r1
        L88:
            r2 = move-exception
            java.lang.String r2 = "service probably died"
            android.util.Log.w(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzn.zzakr():boolean");
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final void zzj(ConnectionResult connectionResult) {
        zzg zzgVar;
        zzg zzgVar2;
        zzgVar = this.zzfza.zzfys;
        if (zzgVar != null) {
            zzgVar2 = this.zzfza.zzfys;
            zzgVar2.onConnectionFailed(connectionResult);
        }
        this.zzfza.onConnectionFailed(connectionResult);
    }
}
