package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzv
/* loaded from: classes.dex */
public final class zzakd extends zzbfm {
    public static final Parcelable.Creator<zzakd> CREATOR = new zzake();
    public String zzcv;
    public int zzdej;
    public int zzdek;
    public boolean zzdel;
    public boolean zzdem;

    public zzakd(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzakd(int i, int i2, boolean z, boolean z2) {
        this(11910000, i2, true, false, z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzakd(int r10, int r11, boolean r12, boolean r13, boolean r14) {
        /*
            r9 = this;
            if (r12 == 0) goto L5
            java.lang.String r13 = "0"
            goto L7
        L5:
            java.lang.String r13 = "1"
        L7:
            java.lang.String r0 = "afma-sdk-a-v"
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 24
            java.lang.String r2 = java.lang.String.valueOf(r13)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = "."
            r2.append(r0)
            r2.append(r11)
            r2.append(r0)
            r2.append(r13)
            java.lang.String r4 = r2.toString()
            r3 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r14
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzakd.<init>(int, int, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakd(String str, int i, int i2, boolean z, boolean z2) {
        this.zzcv = str;
        this.zzdej = i;
        this.zzdek = i2;
        this.zzdel = z;
        this.zzdem = z2;
    }

    public static zzakd zzrd() {
        return new zzakd(11910208, 11910208, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzcv, false);
        zzbfp.zzc(parcel, 3, this.zzdej);
        zzbfp.zzc(parcel, 4, this.zzdek);
        zzbfp.zza(parcel, 5, this.zzdel);
        zzbfp.zza(parcel, 6, this.zzdem);
        zzbfp.zzai(parcel, zze);
    }
}
