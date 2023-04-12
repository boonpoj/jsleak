package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzzc implements zzys<zzoj> {
    private final boolean zzcek;
    private final boolean zzcln;
    private final boolean zzclo;

    public zzzc(boolean z, boolean z2, boolean z3) {
        this.zzcln = z;
        this.zzclo = z2;
        this.zzcek = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
    @Override // com.google.android.gms.internal.zzys
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.android.gms.internal.zzoj zza(com.google.android.gms.internal.zzym r22, org.json.JSONObject r23) throws org.json.JSONException, java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        /*
            r21 = this;
            r0 = r21
            r7 = r22
            r8 = r23
            boolean r5 = r0.zzcln
            boolean r6 = r0.zzclo
            java.lang.String r3 = "images"
            r4 = 0
            r1 = r22
            r2 = r23
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6)
            boolean r2 = r0.zzcln
            java.lang.String r3 = "app_icon"
            r4 = 1
            com.google.android.gms.internal.zzakv r2 = r7.zza(r8, r3, r4, r2)
            java.lang.String r3 = "video"
            com.google.android.gms.internal.zzakv r3 = r7.zzc(r8, r3)
            com.google.android.gms.internal.zzakv r4 = r22.zzh(r23)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r1 = r1.iterator()
        L31:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L47
            java.lang.Object r5 = r1.next()
            com.google.android.gms.internal.zzakv r5 = (com.google.android.gms.internal.zzakv) r5
            java.lang.Object r5 = r5.get()
            com.google.android.gms.internal.zzoi r5 = (com.google.android.gms.internal.zzoi) r5
            r7.add(r5)
            goto L31
        L47:
            com.google.android.gms.internal.zzanh r1 = com.google.android.gms.internal.zzym.zzb(r3)
            com.google.android.gms.internal.zzoj r3 = new com.google.android.gms.internal.zzoj
            java.lang.String r5 = "headline"
            java.lang.String r5 = r8.getString(r5)
            boolean r6 = r0.zzcek
            if (r6 == 0) goto La5
            com.google.android.gms.internal.zzmx<java.lang.Boolean> r6 = com.google.android.gms.internal.zznh.zzbrx
            com.google.android.gms.internal.zznf r9 = com.google.android.gms.internal.zzkb.zzif()
            java.lang.Object r6 = r9.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto La5
            com.google.android.gms.internal.zzaft r6 = com.google.android.gms.ads.internal.zzbs.zzem()
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L7a
            int r9 = com.google.android.gms.R.string.s7
            java.lang.String r6 = r6.getString(r9)
            goto L7c
        L7a:
            java.lang.String r6 = "Test Ad"
        L7c:
            if (r5 == 0) goto La6
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
        La5:
            r6 = r5
        La6:
            java.lang.String r5 = "body"
            java.lang.String r9 = r8.getString(r5)
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.zzpq r2 = (com.google.android.gms.internal.zzpq) r2
            java.lang.String r5 = "call_to_action"
            java.lang.String r10 = r8.getString(r5)
            r11 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r5 = "rating"
            double r11 = r8.optDouble(r5, r11)
            java.lang.String r5 = "store"
            java.lang.String r13 = r8.optString(r5)
            java.lang.String r5 = "price"
            java.lang.String r14 = r8.optString(r5)
            java.lang.Object r4 = r4.get()
            r15 = r4
            com.google.android.gms.internal.zzog r15 = (com.google.android.gms.internal.zzog) r15
            android.os.Bundle r16 = new android.os.Bundle
            r16.<init>()
            r4 = 0
            if (r1 == 0) goto Le2
            com.google.android.gms.internal.zzaoa r5 = r1.zzsg()
            r17 = r5
            goto Le4
        Le2:
            r17 = r4
        Le4:
            if (r1 == 0) goto Lee
            if (r1 == 0) goto Led
            android.view.View r1 = (android.view.View) r1
            r18 = r1
            goto Lf0
        Led:
            throw r4
        Lee:
            r18 = r4
        Lf0:
            r19 = 0
            r20 = 0
            r5 = r3
            r8 = r9
            r9 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzc.zza(com.google.android.gms.internal.zzym, org.json.JSONObject):com.google.android.gms.internal.zzou");
    }
}
