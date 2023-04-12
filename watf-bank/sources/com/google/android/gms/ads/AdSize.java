package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzalv;
    private final int zzalw;
    private final String zzalx;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, SQLiteDatabase.MAX_SQL_CACHE_SIZE, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize zzalu = new AdSize(50, 50, "50x50_mb");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        La:
            r1 = -2
            if (r7 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r7)
        L14:
            java.lang.String r2 = "_as"
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 1
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r0)
            java.lang.String r0 = "x"
            r4.append(r0)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r5.<init>(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.zzalv = i;
            this.zzalw = i2;
            this.zzalx = str;
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdSize) {
            AdSize adSize = (AdSize) obj;
            return this.zzalv == adSize.zzalv && this.zzalw == adSize.zzalw && this.zzalx.equals(adSize.zzalx);
        }
        return false;
    }

    public final int getHeight() {
        return this.zzalw;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.zzalw;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i != -2) {
            zzkb.zzia();
            return zzajr.zzc(context, this.zzalw);
        }
        return zzjn.zzc(context.getResources().getDisplayMetrics());
    }

    public final int getWidth() {
        return this.zzalv;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.zzalv;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i != -1) {
            zzkb.zzia();
            return zzajr.zzc(context, this.zzalv);
        }
        return zzjn.zzb(context.getResources().getDisplayMetrics());
    }

    public final int hashCode() {
        return this.zzalx.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.zzalw == -2;
    }

    public final boolean isFluid() {
        return this.zzalv == -3 && this.zzalw == -4;
    }

    public final boolean isFullWidth() {
        return this.zzalv == -1;
    }

    public final String toString() {
        return this.zzalx;
    }
}
