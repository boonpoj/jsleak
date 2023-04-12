package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: assets/classes2.dex */
public class zzawc extends com.google.android.gms.common.internal.safeparcel.zza implements Comparable<zzawc> {
    public static final Parcelable.Creator<zzawc> CREATOR = new zzawd();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zza zzbzx = new zza();
    final int mVersionCode;
    public final String name;
    final String zzaFy;
    final boolean zzbgG;
    final double zzbgI;
    final long zzbzt;
    final byte[] zzbzu;
    public final int zzbzv;
    public final int zzbzw;

    /* loaded from: assets/classes2.dex */
    public static class zza implements Comparator<zzawc> {
        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(zzawc zzawcVar, zzawc zzawcVar2) {
            return zzawcVar.zzbzw == zzawcVar2.zzbzw ? zzawcVar.name.compareTo(zzawcVar2.name) : zzawcVar.zzbzw - zzawcVar2.zzbzw;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawc(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.mVersionCode = i;
        this.name = str;
        this.zzbzt = j;
        this.zzbgG = z;
        this.zzbgI = d;
        this.zzaFy = str2;
        this.zzbzu = bArr;
        this.zzbzv = i2;
        this.zzbzw = i3;
    }

    private static int compare(byte b, byte b2) {
        return b - b2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static int compare(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzawc)) {
            return false;
        }
        zzawc zzawcVar = (zzawc) obj;
        if (this.mVersionCode == zzawcVar.mVersionCode && com.google.android.gms.common.internal.zzaa.equal(this.name, zzawcVar.name) && this.zzbzv == zzawcVar.zzbzv && this.zzbzw == zzawcVar.zzbzw) {
            switch (this.zzbzv) {
                case 1:
                    return this.zzbzt == zzawcVar.zzbzt;
                case 2:
                    return this.zzbgG == zzawcVar.zzbgG;
                case 3:
                    return this.zzbgI == zzawcVar.zzbgI;
                case 4:
                    return com.google.android.gms.common.internal.zzaa.equal(this.zzaFy, zzawcVar.zzaFy);
                case 5:
                    return Arrays.equals(this.zzbzu, zzawcVar.zzbzu);
                default:
                    int i = this.zzbzv;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Invalid enum value: ");
                    sb.append(i);
                    throw new AssertionError(sb.toString());
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        zza(sb);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzawd.zza(this, parcel, i);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public int compareTo(zzawc zzawcVar) {
        int compareTo = this.name.compareTo(zzawcVar.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.zzbzv, zzawcVar.zzbzv);
        if (compare != 0) {
            return compare;
        }
        switch (this.zzbzv) {
            case 1:
                return compare(this.zzbzt, zzawcVar.zzbzt);
            case 2:
                return compare(this.zzbgG, zzawcVar.zzbgG);
            case 3:
                return Double.compare(this.zzbgI, zzawcVar.zzbgI);
            case 4:
                return compare(this.zzaFy, zzawcVar.zzaFy);
            case 5:
                if (this.zzbzu == zzawcVar.zzbzu) {
                    return 0;
                }
                if (this.zzbzu == null) {
                    return -1;
                }
                if (zzawcVar.zzbzu == null) {
                    return 1;
                }
                for (int i = 0; i < Math.min(this.zzbzu.length, zzawcVar.zzbzu.length); i++) {
                    int compare2 = compare(this.zzbzu[i], zzawcVar.zzbzu[i]);
                    if (compare2 != 0) {
                        return compare2;
                    }
                }
                return compare(this.zzbzu.length, zzawcVar.zzbzu.length);
            default:
                int i2 = this.zzbzv;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid enum value: ");
                sb.append(i2);
                throw new AssertionError(sb.toString());
        }
    }

    public String zza(StringBuilder sb) {
        String str;
        String str2;
        sb.append("Flag(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        switch (this.zzbzv) {
            case 1:
                sb.append(this.zzbzt);
                break;
            case 2:
                sb.append(this.zzbgG);
                break;
            case 3:
                sb.append(this.zzbgI);
                break;
            case 4:
                sb.append("'");
                str = this.zzaFy;
                sb.append(str);
                str2 = "'";
                sb.append(str2);
                break;
            case 5:
                if (this.zzbzu == null) {
                    str2 = "null";
                    sb.append(str2);
                    break;
                } else {
                    sb.append("'");
                    str = new String(this.zzbzu, UTF_8);
                    sb.append(str);
                    str2 = "'";
                    sb.append(str2);
                }
            default:
                String str3 = this.name;
                int i = this.zzbzv;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 27);
                sb2.append("Invalid type: ");
                sb2.append(str3);
                sb2.append(", ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
        }
        sb.append(", ");
        sb.append(this.zzbzv);
        sb.append(", ");
        sb.append(this.zzbzw);
        sb.append(")");
        return sb.toString();
    }
}
