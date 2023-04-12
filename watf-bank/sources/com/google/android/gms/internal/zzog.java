package com.google.android.gms.internal;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzog extends zzpn {
    private static final int zzbtc = Color.rgb(12, 174, 206);
    private static final int zzbtd;
    private static int zzbte;
    private static int zzbtf;
    private final int mTextColor;
    private final String zzbtg;
    private final List<zzoi> zzbth = new ArrayList();
    private final List<zzpq> zzbti = new ArrayList();
    private final int zzbtj;
    private final int zzbtk;
    private final int zzbtl;
    private final int zzbtm;
    private final boolean zzbtn;

    /* renamed from: com.google.android.gms.internal.zzog$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzov zzsW;

        AnonymousClass1(zzov zzovVar) {
            this.zzsW = zzovVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzog.zza(zzog.this).zzb(this.zzsW);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzog$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzov zzsW;

        AnonymousClass2(zzov zzovVar) {
            this.zzsW = zzovVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzog.zza(zzog.this).zzb(this.zzsW);
        }
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzbtd = rgb;
        zzbte = rgb;
        zzbtf = zzbtc;
    }

    public zzog(String str, List<zzoi> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzbtg = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzoi zzoiVar = list.get(i3);
                this.zzbth.add(zzoiVar);
                this.zzbti.add(zzoiVar);
            }
        }
        this.zzbtj = num != null ? num.intValue() : zzbte;
        this.mTextColor = num2 != null ? num2.intValue() : zzbtf;
        this.zzbtk = num3 != null ? num3.intValue() : 12;
        this.zzbtl = i;
        this.zzbtm = i2;
        this.zzbtn = z;
    }

    public final int getBackgroundColor() {
        return this.zzbtj;
    }

    @Override // com.google.android.gms.internal.zzpm
    public final String getText() {
        return this.zzbtg;
    }

    public final int getTextColor() {
        return this.mTextColor;
    }

    public final int getTextSize() {
        return this.zzbtk;
    }

    @Override // com.google.android.gms.internal.zzpm
    public final List<zzpq> zzjm() {
        return this.zzbti;
    }

    public final List<zzoi> zzjn() {
        return this.zzbth;
    }

    public final int zzjo() {
        return this.zzbtl;
    }

    public final int zzjp() {
        return this.zzbtm;
    }

    public final boolean zzjq() {
        return this.zzbtn;
    }
}
