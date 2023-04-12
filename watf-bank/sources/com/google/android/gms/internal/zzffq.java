package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class zzffq<FieldDescriptorType extends zzffs<FieldDescriptorType>> {
    private static final zzffq zzpgm = new zzffq(true);
    private boolean zzktj;
    private boolean zzpgl = false;
    private final zzfhy<FieldDescriptorType, Object> zzpgk = zzfhy.zzma(16);

    private zzffq() {
    }

    private zzffq(boolean z) {
        if (this.zzktj) {
            return;
        }
        this.zzpgk.zzbiy();
        this.zzktj = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzfiy zzfiyVar, int i, Object obj) {
        int zzlg = zzffg.zzlg(i);
        if (zzfiyVar == zzfiy.zzply) {
            zzffz.zzh((zzfhe) obj);
            zzlg <<= 1;
        }
        return zzlg + zzb(zzfiyVar, obj);
    }

    public static Object zza(zzffb zzffbVar, zzfiy zzfiyVar, boolean z) throws IOException {
        zzfje zzfjeVar = zzfje.STRICT;
        switch (zzfix.zzpgo[zzfiyVar.ordinal()]) {
            case 1:
                return Double.valueOf(zzffbVar.readDouble());
            case 2:
                return Float.valueOf(zzffbVar.readFloat());
            case 3:
                return Long.valueOf(zzffbVar.zzcvv());
            case 4:
                return Long.valueOf(zzffbVar.zzcvu());
            case 5:
                return Integer.valueOf(zzffbVar.zzcvw());
            case 6:
                return Long.valueOf(zzffbVar.zzcvx());
            case 7:
                return Integer.valueOf(zzffbVar.zzcvy());
            case 8:
                return Boolean.valueOf(zzffbVar.zzcvz());
            case 9:
                return zzffbVar.zzcwb();
            case 10:
                return Integer.valueOf(zzffbVar.zzcwc());
            case 11:
                return Integer.valueOf(zzffbVar.zzcwe());
            case 12:
                return Long.valueOf(zzffbVar.zzcwf());
            case 13:
                return Integer.valueOf(zzffbVar.zzcwg());
            case 14:
                return Long.valueOf(zzffbVar.zzcwh());
            case 15:
                return zzfjeVar.zza(zzffbVar);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzffg zzffgVar, zzfiy zzfiyVar, int i, Object obj) throws IOException {
        if (zzfiyVar == zzfiy.zzply) {
            zzfhe zzfheVar = (zzfhe) obj;
            zzffz.zzh(zzfheVar);
            zzffgVar.zze(i, zzfheVar);
            return;
        }
        zzffgVar.zzz(i, zzfiyVar.zzdae());
        switch (zzffr.zzpgo[zzfiyVar.ordinal()]) {
            case 1:
                zzffgVar.zzn(((Double) obj).doubleValue());
                return;
            case 2:
                zzffgVar.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzffgVar.zzct(((Long) obj).longValue());
                return;
            case 4:
                zzffgVar.zzct(((Long) obj).longValue());
                return;
            case 5:
                zzffgVar.zzlc(((Integer) obj).intValue());
                return;
            case 6:
                zzffgVar.zzcv(((Long) obj).longValue());
                return;
            case 7:
                zzffgVar.zzlf(((Integer) obj).intValue());
                return;
            case 8:
                zzffgVar.zzdd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzfhe) obj).zza(zzffgVar);
                return;
            case 10:
                zzffgVar.zze((zzfhe) obj);
                return;
            case 11:
                if (obj instanceof zzfes) {
                    zzffgVar.zzay((zzfes) obj);
                    return;
                } else {
                    zzffgVar.zzts((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfes) {
                    zzffgVar.zzay((zzfes) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzffgVar.zzi(bArr, 0, bArr.length);
                return;
            case 13:
                zzffgVar.zzld(((Integer) obj).intValue());
                return;
            case 14:
                zzffgVar.zzlf(((Integer) obj).intValue());
                return;
            case 15:
                zzffgVar.zzcv(((Long) obj).longValue());
                return;
            case 16:
                zzffgVar.zzle(((Integer) obj).intValue());
                return;
            case 17:
                zzffgVar.zzcu(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfga) {
                    zzffgVar.zzlc(((zzfga) obj).zzhq());
                    return;
                } else {
                    zzffgVar.zzlc(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzcxj()) {
            zza(fielddescriptortype.zzcxh(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzcxh(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfgg) {
            this.zzpgl = true;
        }
        this.zzpgk.zza((zzfhy<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.zzfga) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.zzfgg) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.zzfiy r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.zzffz.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.zzffr.zzpgn
            com.google.android.gms.internal.zzfjd r2 = r2.zzdad()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L43
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.zzfhe
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.zzfgg
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.zzfga
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.zzfes
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L43
            goto L26
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            r1 = r0
        L43:
            if (r1 == 0) goto L46
            return
        L46:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4f
        L4e:
            throw r2
        L4f:
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffq.zza(com.google.android.gms.internal.zzfiy, java.lang.Object):void");
    }

    private static int zzb(zzffs<?> zzffsVar, Object obj) {
        zzfiy zzcxh = zzffsVar.zzcxh();
        int zzhq = zzffsVar.zzhq();
        if (zzffsVar.zzcxj()) {
            int i = 0;
            List<Object> list = (List) obj;
            if (zzffsVar.zzcxk()) {
                for (Object obj2 : list) {
                    i += zzb(zzcxh, obj2);
                }
                return zzffg.zzlg(zzhq) + i + zzffg.zzlp(i);
            }
            for (Object obj3 : list) {
                i += zza(zzcxh, zzhq, obj3);
            }
            return i;
        }
        return zza(zzcxh, zzhq, obj);
    }

    private static int zzb(zzfiy zzfiyVar, Object obj) {
        switch (zzffr.zzpgo[zzfiyVar.ordinal()]) {
            case 1:
                return zzffg.zzo(((Double) obj).doubleValue());
            case 2:
                return zzffg.zzg(((Float) obj).floatValue());
            case 3:
                return zzffg.zzcw(((Long) obj).longValue());
            case 4:
                return zzffg.zzcx(((Long) obj).longValue());
            case 5:
                return zzffg.zzlh(((Integer) obj).intValue());
            case 6:
                return zzffg.zzcz(((Long) obj).longValue());
            case 7:
                return zzffg.zzlk(((Integer) obj).intValue());
            case 8:
                return zzffg.zzde(((Boolean) obj).booleanValue());
            case 9:
                return zzffg.zzg((zzfhe) obj);
            case 10:
                return obj instanceof zzfgg ? zzffg.zza((zzfgg) obj) : zzffg.zzf((zzfhe) obj);
            case 11:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zztt((String) obj);
            case 12:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zzbd((byte[]) obj);
            case 13:
                return zzffg.zzli(((Integer) obj).intValue());
            case 14:
                return zzffg.zzll(((Integer) obj).intValue());
            case 15:
                return zzffg.zzda(((Long) obj).longValue());
            case 16:
                return zzffg.zzlj(((Integer) obj).intValue());
            case 17:
                return zzffg.zzcy(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfga ? zzffg.zzlm(((zzfga) obj).zzhq()) : zzffg.zzlm(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzcxi() != zzfjd.MESSAGE || key.zzcxj() || key.zzcxk()) {
            return zzb((zzffs<?>) key, value);
        }
        boolean z = value instanceof zzfgg;
        int zzhq = entry.getKey().zzhq();
        return z ? zzffg.zzb(zzhq, (zzfgg) value) : zzffg.zzd(zzhq, (zzfhe) value);
    }

    public static <T extends zzffs<T>> zzffq<T> zzcxf() {
        return new zzffq<>();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzffq zzffqVar = new zzffq();
        for (int i = 0; i < this.zzpgk.zzczj(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzmb = this.zzpgk.zzmb(i);
            zzffqVar.zza((zzffq) zzmb.getKey(), zzmb.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzpgk.zzczk()) {
            zzffqVar.zza((zzffq) entry.getKey(), entry.getValue());
        }
        zzffqVar.zzpgl = this.zzpgl;
        return zzffqVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzffq) {
            return this.zzpgk.equals(((zzffq) obj).zzpgk);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzpgk.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzpgl ? new zzfgj(this.zzpgk.entrySet().iterator()) : this.zzpgk.entrySet().iterator();
    }

    public final int zzcxg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzpgk.zzczj(); i2++) {
            i += zzb(this.zzpgk.zzmb(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzpgk.zzczk()) {
            i += zzb(entry);
        }
        return i;
    }
}
