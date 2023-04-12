package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzav extends zzfjm<zzav> {
    public String zzcn = null;
    public Long zzco = null;
    private String stackTrace = null;
    private String zzcp = null;
    private String zzcq = null;
    private Long zzcr = null;
    private Long zzcs = null;
    private String zzct = null;
    private Long zzcu = null;
    private String zzcv = null;

    public zzav() {
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            switch (zzcvt) {
                case 0:
                    return this;
                case 10:
                    this.zzcn = zzfjjVar.readString();
                    break;
                case 16:
                    this.zzco = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 26:
                    this.stackTrace = zzfjjVar.readString();
                    break;
                case 34:
                    this.zzcp = zzfjjVar.readString();
                    break;
                case 42:
                    this.zzcq = zzfjjVar.readString();
                    break;
                case 48:
                    this.zzcr = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 56:
                    this.zzcs = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 66:
                    this.zzct = zzfjjVar.readString();
                    break;
                case 72:
                    this.zzcu = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 82:
                    this.zzcv = zzfjjVar.readString();
                    break;
                default:
                    if (super.zza(zzfjjVar, zzcvt)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        String str = this.zzcn;
        if (str != null) {
            zzfjkVar.zzn(1, str);
        }
        Long l = this.zzco;
        if (l != null) {
            zzfjkVar.zzf(2, l.longValue());
        }
        String str2 = this.stackTrace;
        if (str2 != null) {
            zzfjkVar.zzn(3, str2);
        }
        String str3 = this.zzcp;
        if (str3 != null) {
            zzfjkVar.zzn(4, str3);
        }
        String str4 = this.zzcq;
        if (str4 != null) {
            zzfjkVar.zzn(5, str4);
        }
        Long l2 = this.zzcr;
        if (l2 != null) {
            zzfjkVar.zzf(6, l2.longValue());
        }
        Long l3 = this.zzcs;
        if (l3 != null) {
            zzfjkVar.zzf(7, l3.longValue());
        }
        String str5 = this.zzct;
        if (str5 != null) {
            zzfjkVar.zzn(8, str5);
        }
        Long l4 = this.zzcu;
        if (l4 != null) {
            zzfjkVar.zzf(9, l4.longValue());
        }
        String str6 = this.zzcv;
        if (str6 != null) {
            zzfjkVar.zzn(10, str6);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        String str = this.zzcn;
        if (str != null) {
            zzq += zzfjk.zzo(1, str);
        }
        Long l = this.zzco;
        if (l != null) {
            zzq += zzfjk.zzc(2, l.longValue());
        }
        String str2 = this.stackTrace;
        if (str2 != null) {
            zzq += zzfjk.zzo(3, str2);
        }
        String str3 = this.zzcp;
        if (str3 != null) {
            zzq += zzfjk.zzo(4, str3);
        }
        String str4 = this.zzcq;
        if (str4 != null) {
            zzq += zzfjk.zzo(5, str4);
        }
        Long l2 = this.zzcr;
        if (l2 != null) {
            zzq += zzfjk.zzc(6, l2.longValue());
        }
        Long l3 = this.zzcs;
        if (l3 != null) {
            zzq += zzfjk.zzc(7, l3.longValue());
        }
        String str5 = this.zzct;
        if (str5 != null) {
            zzq += zzfjk.zzo(8, str5);
        }
        Long l4 = this.zzcu;
        if (l4 != null) {
            zzq += zzfjk.zzc(9, l4.longValue());
        }
        String str6 = this.zzcv;
        return str6 != null ? zzq + zzfjk.zzo(10, str6) : zzq;
    }
}
