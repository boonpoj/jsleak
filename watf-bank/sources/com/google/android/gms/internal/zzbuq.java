package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: assets/classes2.dex */
public class zzbuq implements Cloneable {
    private Object value;
    private zzbuo<?, ?> zzcsd;
    private List<zzbuv> zzcse = new ArrayList();

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzv()];
        zza(zzbum.zzae(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbuq) {
            zzbuq zzbuqVar = (zzbuq) obj;
            if (this.value != null && zzbuqVar.value != null) {
                if (this.zzcsd != zzbuqVar.zzcsd) {
                    return false;
                }
                return !this.zzcsd.zzciF.isArray() ? this.value.equals(zzbuqVar.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzbuqVar.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzbuqVar.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzbuqVar.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzbuqVar.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzbuqVar.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzbuqVar.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzbuqVar.value);
            } else if (this.zzcse == null || zzbuqVar.zzcse == null) {
                try {
                    return Arrays.equals(toByteArray(), zzbuqVar.toByteArray());
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                return this.zzcse.equals(zzbuqVar.zzcse);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzbum zzbumVar) throws IOException {
        if (this.value != null) {
            this.zzcsd.zza(this.value, zzbumVar);
            return;
        }
        for (zzbuv zzbuvVar : this.zzcse) {
            zzbuvVar.zza(zzbumVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzbuv zzbuvVar) {
        this.zzcse.add(zzbuvVar);
    }

    /* renamed from: zzacQ */
    public final zzbuq clone() {
        Object clone;
        zzbuq zzbuqVar = new zzbuq();
        try {
            zzbuqVar.zzcsd = this.zzcsd;
            if (this.zzcse == null) {
                zzbuqVar.zzcse = null;
            } else {
                zzbuqVar.zzcse.addAll(this.zzcse);
            }
            if (this.value != null) {
                if (this.value instanceof zzbut) {
                    clone = (zzbut) ((zzbut) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length];
                        zzbuqVar.value = bArr2;
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
                    } else if (this.value instanceof zzbut[]) {
                        zzbut[] zzbutVarArr = (zzbut[]) this.value;
                        zzbut[] zzbutVarArr2 = new zzbut[zzbutVarArr.length];
                        zzbuqVar.value = zzbutVarArr2;
                        while (i < zzbutVarArr.length) {
                            zzbutVarArr2[i] = (zzbut) zzbutVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzbuqVar.value = clone;
            }
            return zzbuqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T zzb(zzbuo<?, T> zzbuoVar) {
        if (this.value == null) {
            this.zzcsd = zzbuoVar;
            this.value = zzbuoVar.zzZ(this.zzcse);
            this.zzcse = null;
        } else if (!this.zzcsd.equals(zzbuoVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzv() {
        if (this.value != null) {
            return this.zzcsd.zzaR(this.value);
        }
        int i = 0;
        for (zzbuv zzbuvVar : this.zzcse) {
            i += zzbuvVar.zzv();
        }
        return i;
    }
}
