package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzzd implements zzys<zzol> {
    private final boolean zzcek;
    private final boolean zzcln;
    private final boolean zzclo;

    public zzzd(boolean z, boolean z2, boolean z3) {
        this.zzcln = z;
        this.zzclo = z2;
        this.zzcek = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    @Override // com.google.android.gms.internal.zzys
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.android.gms.internal.zzol zza(com.google.android.gms.internal.zzym r19, org.json.JSONObject r20) throws org.json.JSONException, java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        /*
            r18 = this;
            r0 = r18
            r7 = r19
            r8 = r20
            boolean r5 = r0.zzcln
            boolean r6 = r0.zzclo
            java.lang.String r3 = "images"
            r4 = 0
            r1 = r19
            r2 = r20
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6)
            boolean r2 = r0.zzcln
            java.lang.String r3 = "secondary_image"
            com.google.android.gms.internal.zzakv r2 = r7.zza(r8, r3, r4, r2)
            com.google.android.gms.internal.zzakv r3 = r19.zzh(r20)
            java.lang.String r4 = "video"
            com.google.android.gms.internal.zzakv r4 = r7.zzc(r8, r4)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r1 = r1.iterator()
        L30:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L46
            java.lang.Object r5 = r1.next()
            com.google.android.gms.internal.zzakv r5 = (com.google.android.gms.internal.zzakv) r5
            java.lang.Object r5 = r5.get()
            com.google.android.gms.internal.zzoi r5 = (com.google.android.gms.internal.zzoi) r5
            r7.add(r5)
            goto L30
        L46:
            com.google.android.gms.internal.zzanh r1 = com.google.android.gms.internal.zzym.zzb(r4)
            com.google.android.gms.internal.zzol r4 = new com.google.android.gms.internal.zzol
            java.lang.String r5 = "headline"
            java.lang.String r5 = r8.getString(r5)
            boolean r6 = r0.zzcek
            if (r6 == 0) goto La4
            com.google.android.gms.internal.zzmx<java.lang.Boolean> r6 = com.google.android.gms.internal.zznh.zzbrx
            com.google.android.gms.internal.zznf r9 = com.google.android.gms.internal.zzkb.zzif()
            java.lang.Object r6 = r9.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto La4
            com.google.android.gms.internal.zzaft r6 = com.google.android.gms.ads.internal.zzbs.zzem()
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L79
            int r9 = com.google.android.gms.R.string.s7
            java.lang.String r6 = r6.getString(r9)
            goto L7b
        L79:
            java.lang.String r6 = "Test Ad"
        L7b:
            if (r5 == 0) goto La5
            java.lang.String r9 = java.lang.String.valueOf(r6)
            int r9 = r9.length()
            int r9 = r9 + 3
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r10 = r10.length()
            int r9 = r9 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            r10.append(r6)
            java.lang.String r6 = " : "
            r10.append(r6)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
        La4:
            r6 = r5
        La5:
            java.lang.String r5 = "body"
            java.lang.String r9 = r8.getString(r5)
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.zzpq r2 = (com.google.android.gms.internal.zzpq) r2
            java.lang.String r5 = "call_to_action"
            java.lang.String r10 = r8.getString(r5)
            java.lang.String r5 = "advertiser"
            java.lang.String r11 = r8.getString(r5)
            java.lang.Object r3 = r3.get()
            r12 = r3
            com.google.android.gms.internal.zzog r12 = (com.google.android.gms.internal.zzog) r12
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r3 = 0
            if (r1 == 0) goto Ld2
            com.google.android.gms.internal.zzaoa r5 = r1.zzsg()
            r14 = r5
            goto Ld3
        Ld2:
            r14 = r3
        Ld3:
            if (r1 == 0) goto Ldc
            if (r1 == 0) goto Ldb
            android.view.View r1 = (android.view.View) r1
            r15 = r1
            goto Ldd
        Ldb:
            throw r3
        Ldc:
            r15 = r3
        Ldd:
            r16 = 0
            r17 = 0
            r5 = r4
            r8 = r9
            r9 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzd.zza(com.google.android.gms.internal.zzym, org.json.JSONObject):com.google.android.gms.internal.zzou");
    }
}
