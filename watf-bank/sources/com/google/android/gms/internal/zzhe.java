package com.google.android.gms.internal;

import java.util.ArrayList;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhe {
    private final int zzaya;
    private final int zzayb;
    private final int zzayc;
    private final zzhr zzayd;
    private final zzia zzaye;
    private int zzayl;
    private final Object mLock = new Object();
    private ArrayList<String> zzayf = new ArrayList<>();
    private ArrayList<String> zzayg = new ArrayList<>();
    private ArrayList<zzhp> zzayh = new ArrayList<>();
    private int zzayi = 0;
    private int zzayj = 0;
    private int zzayk = 0;
    private String zzaym = "";
    private String zzayn = "";
    private String zzayo = "";

    public zzhe(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zzaya = i;
        this.zzayb = i2;
        this.zzayc = i3;
        this.zzayd = new zzhr(i4);
        this.zzaye = new zzia(i5, i6, i7);
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            stringBuffer.append(str);
            stringBuffer.append(' ');
            if (stringBuffer.length() > 100) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() < 100 ? stringBuffer2 : stringBuffer2.substring(0, 100);
    }

    private final void zzc(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.zzayc) {
            return;
        }
        synchronized (this.mLock) {
            this.zzayf.add(str);
            this.zzayi += str.length();
            if (z) {
                this.zzayg.add(str);
                this.zzayh.add(new zzhp(f, f2, f3, f4, this.zzayg.size() - 1));
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhe) {
            if (obj == this) {
                return true;
            }
            String str = ((zzhe) obj).zzaym;
            return str != null && str.equals(this.zzaym);
        }
        return false;
    }

    public final int getScore() {
        return this.zzayl;
    }

    public final int hashCode() {
        return this.zzaym.hashCode();
    }

    public final String toString() {
        int i = this.zzayj;
        int i2 = this.zzayl;
        int i3 = this.zzayi;
        String zza = zza(this.zzayf, 100);
        String zza2 = zza(this.zzayg, 100);
        String str = this.zzaym;
        String str2 = this.zzayn;
        String str3 = this.zzayo;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.mLock) {
            if (this.zzayk < 0) {
                zzagf.zzbx("ActivityContent: negative number of WebViews.");
            }
            zzgq();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final boolean zzgj() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzayk == 0;
        }
        return z;
    }

    public final String zzgk() {
        return this.zzaym;
    }

    public final String zzgl() {
        return this.zzayn;
    }

    public final String zzgm() {
        return this.zzayo;
    }

    public final void zzgn() {
        synchronized (this.mLock) {
            this.zzayl -= 100;
        }
    }

    public final void zzgo() {
        synchronized (this.mLock) {
            this.zzayk--;
        }
    }

    public final void zzgp() {
        synchronized (this.mLock) {
            this.zzayk++;
        }
    }

    public final void zzgq() {
        synchronized (this.mLock) {
            int i = (this.zzayi * this.zzaya) + (this.zzayj * this.zzayb);
            if (i > this.zzayl) {
                this.zzayl = i;
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbju)).booleanValue() && !com.google.android.gms.ads.internal.zzbs.zzem().zzoy()) {
                    this.zzaym = this.zzayd.zza(this.zzayf);
                    this.zzayn = this.zzayd.zza(this.zzayg);
                }
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbjw)).booleanValue() && !com.google.android.gms.ads.internal.zzbs.zzem().zzoz()) {
                    this.zzayo = this.zzaye.zza(this.zzayg, this.zzayh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzgr() {
        return this.zzayi;
    }

    public final void zzo(int i) {
        this.zzayj = i;
    }
}
