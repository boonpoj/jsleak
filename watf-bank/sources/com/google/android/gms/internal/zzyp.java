package com.google.android.gms.internal;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzyp implements zzakh<List<zzoi>, zzog> {
    private /* synthetic */ String zzckq;
    private /* synthetic */ Integer zzckr;
    private /* synthetic */ Integer zzcks;
    private /* synthetic */ int zzckt;
    private /* synthetic */ int zzcku;
    private /* synthetic */ int zzckv;
    private /* synthetic */ int zzckw;
    private /* synthetic */ boolean zzckx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyp(zzym zzymVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.zzckq = str;
        this.zzckr = num;
        this.zzcks = num2;
        this.zzckt = i;
        this.zzcku = i2;
        this.zzckv = i3;
        this.zzckw = i4;
        this.zzckx = z;
    }

    @Override // com.google.android.gms.internal.zzakh
    public final /* synthetic */ zzog apply(List<zzoi> list) {
        List<zzoi> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        String str = this.zzckq;
        Integer num = this.zzckr;
        Integer num2 = this.zzcks;
        int i = this.zzckt;
        return new zzog(str, list2, num, num2, i > 0 ? Integer.valueOf(i) : null, this.zzcku + this.zzckv, this.zzckw, this.zzckx);
    }
}
