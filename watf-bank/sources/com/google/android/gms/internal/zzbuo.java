package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbun;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class zzbuo<M extends zzbun<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzciF;
    protected final boolean zzcrY;

    private zzbuo(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzciF = cls;
        this.tag = i2;
        this.zzcrY = z;
    }

    public static <M extends zzbun<M>, T extends zzbut> zzbuo<M, T> zza(int i, Class<T> cls, long j) {
        return new zzbuo<>(i, cls, (int) j, false);
    }

    private T zzaa(List<zzbuv> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzbuv zzbuvVar = list.get(i);
            if (zzbuvVar.zzcsh.length != 0) {
                zza(zzbuvVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzciF.cast(Array.newInstance(this.zzciF.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzab(List<zzbuv> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzciF.cast(zzaM(zzbul.zzad(list.get(list.size() - 1).zzcsh)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbuo) {
            zzbuo zzbuoVar = (zzbuo) obj;
            return this.type == zzbuoVar.type && this.zzciF == zzbuoVar.zzciF && this.tag == zzbuoVar.tag && this.zzcrY == zzbuoVar.zzcrY;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzciF.hashCode()) * 31) + this.tag) * 31) + (this.zzcrY ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzZ(List<zzbuv> list) {
        if (list == null) {
            return null;
        }
        return this.zzcrY ? zzaa(list) : zzab(list);
    }

    protected void zza(zzbuv zzbuvVar, List<Object> list) {
        list.add(zzaM(zzbul.zzad(zzbuvVar.zzcsh)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Object obj, zzbum zzbumVar) throws IOException {
        if (this.zzcrY) {
            zzc(obj, zzbumVar);
        } else {
            zzb(obj, zzbumVar);
        }
    }

    protected Object zzaM(zzbul zzbulVar) {
        Class componentType = this.zzcrY ? this.zzciF.getComponentType() : this.zzciF;
        try {
            switch (this.type) {
                case 10:
                    zzbut zzbutVar = (zzbut) componentType.newInstance();
                    zzbulVar.zza(zzbutVar, zzbuw.zzqB(this.tag));
                    return zzbutVar;
                case 11:
                    zzbut zzbutVar2 = (zzbut) componentType.newInstance();
                    zzbulVar.zza(zzbutVar2);
                    return zzbutVar2;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzaR(Object obj) {
        return this.zzcrY ? zzaS(obj) : zzaT(obj);
    }

    protected int zzaS(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzaT(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzaT(Object obj) {
        int zzqB = zzbuw.zzqB(this.tag);
        switch (this.type) {
            case 10:
                return zzbum.zzb(zzqB, (zzbut) obj);
            case 11:
                return zzbum.zzc(zzqB, (zzbut) obj);
            default:
                int i = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    protected void zzb(Object obj, zzbum zzbumVar) {
        try {
            zzbumVar.zzqt(this.tag);
            switch (this.type) {
                case 10:
                    int zzqB = zzbuw.zzqB(this.tag);
                    zzbumVar.zzb((zzbut) obj);
                    zzbumVar.zzJ(zzqB, 4);
                    return;
                case 11:
                    zzbumVar.zzc((zzbut) obj);
                    return;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected void zzc(Object obj, zzbum zzbumVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzbumVar);
            }
        }
    }
}
