package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public final class zzdqc<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<zzdqd<P>>> zzlsr = new ConcurrentHashMap();
    private zzdqd<P> zzlss;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzdqd<P> zza(P r6, com.google.android.gms.internal.zzdth.zzb r7) throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            com.google.android.gms.internal.zzdqd r0 = new com.google.android.gms.internal.zzdqd
            int[] r1 = com.google.android.gms.internal.zzdpt.zzlso
            com.google.android.gms.internal.zzdtt r2 = r7.zzbpk()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 5
            r3 = 1
            if (r1 == r3) goto L2f
            r4 = 2
            if (r1 == r4) goto L2f
            r4 = 3
            if (r1 == r4) goto L26
            r2 = 4
            if (r1 != r2) goto L1e
            byte[] r1 = com.google.android.gms.internal.zzdps.zzlsn
            goto L44
        L1e:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "unknown output prefix type"
            r6.<init>(r7)
            throw r6
        L26:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteBuffer r1 = r1.put(r3)
            goto L38
        L2f:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            r2 = 0
            java.nio.ByteBuffer r1 = r1.put(r2)
        L38:
            int r2 = r7.zzbpj()
            java.nio.ByteBuffer r1 = r1.putInt(r2)
            byte[] r1 = r1.array()
        L44:
            com.google.android.gms.internal.zzdtb r2 = r7.zzbpi()
            com.google.android.gms.internal.zzdtt r7 = r7.zzbpk()
            r0.<init>(r6, r1, r2, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r0)
            java.lang.String r7 = new java.lang.String
            byte[] r1 = r0.zzblx()
            java.nio.charset.Charset r2 = com.google.android.gms.internal.zzdqc.UTF_8
            r7.<init>(r1, r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.zzdqd<P>>> r1 = r5.zzlsr
            java.util.List r6 = java.util.Collections.unmodifiableList(r6)
            java.lang.Object r6 = r1.put(r7, r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L84
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.addAll(r6)
            r1.add(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.zzdqd<P>>> r6 = r5.zzlsr
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r6.put(r7, r1)
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdqc.zza(java.lang.Object, com.google.android.gms.internal.zzdth$zzb):com.google.android.gms.internal.zzdqd");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzdqd<P> zzdqdVar) {
        this.zzlss = zzdqdVar;
    }

    public final zzdqd<P> zzblv() {
        return this.zzlss;
    }
}
