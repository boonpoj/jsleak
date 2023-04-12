package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Stack;
/* loaded from: classes.dex */
public final class zzfhs {
    private final Stack<zzfes> zzpjm;

    /* JADX INFO: Access modifiers changed from: private */
    public zzfhs() {
        this.zzpjm = new Stack<>();
    }

    public static /* synthetic */ zzfes zza(zzfhs zzfhsVar, zzfes zzfesVar, zzfes zzfesVar2) {
        return zzfhsVar.zzc(zzfesVar, zzfesVar2);
    }

    private final void zzba(zzfes zzfesVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        zzfes zzfesVar2;
        while (!zzfesVar.zzcvo()) {
            if (!(zzfesVar instanceof zzfhq)) {
                String valueOf = String.valueOf(zzfesVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            zzfhq zzfhqVar = (zzfhq) zzfesVar;
            zzfesVar2 = zzfhqVar.zzpji;
            zzba(zzfesVar2);
            zzfesVar = zzfhqVar.zzpjj;
        }
        int zzlz = zzlz(zzfesVar.size());
        iArr = zzfhq.zzpjg;
        int i = iArr[zzlz + 1];
        if (this.zzpjm.isEmpty() || this.zzpjm.peek().size() >= i) {
            this.zzpjm.push(zzfesVar);
            return;
        }
        iArr2 = zzfhq.zzpjg;
        int i2 = iArr2[zzlz];
        zzfes pop = this.zzpjm.pop();
        while (!this.zzpjm.isEmpty() && this.zzpjm.peek().size() < i2) {
            pop = new zzfhq(this.zzpjm.pop(), pop);
        }
        zzfhq zzfhqVar2 = new zzfhq(pop, zzfesVar);
        while (!this.zzpjm.isEmpty()) {
            int zzlz2 = zzlz(zzfhqVar2.size());
            iArr3 = zzfhq.zzpjg;
            if (this.zzpjm.peek().size() >= iArr3[zzlz2 + 1]) {
                break;
            }
            zzfhqVar2 = new zzfhq(this.zzpjm.pop(), zzfhqVar2);
        }
        this.zzpjm.push(zzfhqVar2);
    }

    public final zzfes zzc(zzfes zzfesVar, zzfes zzfesVar2) {
        zzba(zzfesVar);
        zzba(zzfesVar2);
        zzfes pop = this.zzpjm.pop();
        while (!this.zzpjm.isEmpty()) {
            pop = new zzfhq(this.zzpjm.pop(), pop);
        }
        return pop;
    }

    private static int zzlz(int i) {
        int[] iArr;
        iArr = zzfhq.zzpjg;
        int binarySearch = Arrays.binarySearch(iArr, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
