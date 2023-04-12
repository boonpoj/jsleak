package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfjp implements Cloneable {
    private Object value;
    private zzfjn<?, ?> zzpni;
    private List<zzfju> zzpnj = new ArrayList();

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzq()];
        zza(zzfjk.zzbf(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzdah */
    public zzfjp clone() {
        Object clone;
        zzfjp zzfjpVar = new zzfjp();
        try {
            zzfjpVar.zzpni = this.zzpni;
            if (this.zzpnj == null) {
                zzfjpVar.zzpnj = null;
            } else {
                zzfjpVar.zzpnj.addAll(this.zzpnj);
            }
            if (this.value != null) {
                if (this.value instanceof zzfjs) {
                    clone = (zzfjs) ((zzfjs) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length];
                        zzfjpVar.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzfjs[]) {
                        zzfjs[] zzfjsVarArr = (zzfjs[]) this.value;
                        zzfjs[] zzfjsVarArr2 = new zzfjs[zzfjsVarArr.length];
                        zzfjpVar.value = zzfjsVarArr2;
                        while (i < zzfjsVarArr.length) {
                            zzfjsVarArr2[i] = (zzfjs) zzfjsVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzfjpVar.value = clone;
            }
            return zzfjpVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        List<zzfju> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfjp) {
            zzfjp zzfjpVar = (zzfjp) obj;
            if (this.value == null || zzfjpVar.value == null) {
                List<zzfju> list2 = this.zzpnj;
                if (list2 == null || (list = zzfjpVar.zzpnj) == null) {
                    try {
                        return Arrays.equals(toByteArray(), zzfjpVar.toByteArray());
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
                return list2.equals(list);
            }
            zzfjn<?, ?> zzfjnVar = this.zzpni;
            if (zzfjnVar != zzfjpVar.zzpni) {
                return false;
            }
            if (zzfjnVar.zznfk.isArray()) {
                Object obj2 = this.value;
                return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzfjpVar.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzfjpVar.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzfjpVar.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzfjpVar.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzfjpVar.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzfjpVar.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzfjpVar.value);
            }
            return this.value.equals(zzfjpVar.value);
        }
        return false;
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Object obj = this.value;
        if (obj == null) {
            for (zzfju zzfjuVar : this.zzpnj) {
                zzfjkVar.zzmi(zzfjuVar.tag);
                zzfjkVar.zzbh(zzfjuVar.zzjng);
            }
            return;
        }
        zzfjn<?, ?> zzfjnVar = this.zzpni;
        if (!zzfjnVar.zzpnd) {
            zzfjnVar.zza(obj, zzfjkVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzfjnVar.zza(obj2, zzfjkVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzfju zzfjuVar) {
        this.zzpnj.add(zzfjuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T zzb(zzfjn<?, T> zzfjnVar) {
        if (this.value == null) {
            this.zzpni = zzfjnVar;
            this.value = zzfjnVar.zzbq(this.zzpnj);
            this.zzpnj = null;
        } else if (!this.zzpni.equals(zzfjnVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzq() {
        Object obj = this.value;
        if (obj == null) {
            int i = 0;
            for (zzfju zzfjuVar : this.zzpnj) {
                i += zzfjk.zzlp(zzfjuVar.tag) + 0 + zzfjuVar.zzjng.length;
            }
            return i;
        }
        zzfjn<?, ?> zzfjnVar = this.zzpni;
        if (zzfjnVar.zzpnd) {
            int length = Array.getLength(obj);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Array.get(obj, i3) != null) {
                    i2 += zzfjnVar.zzcs(Array.get(obj, i3));
                }
            }
            return i2;
        }
        return zzfjnVar.zzcs(obj);
    }
}
