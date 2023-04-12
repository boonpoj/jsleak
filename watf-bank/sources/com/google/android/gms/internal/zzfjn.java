package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfjm;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class zzfjn<M extends zzfjm<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zznfk;
    private zzffu<?, ?> zzpgu;
    protected final boolean zzpnd;

    private zzfjn(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, i2, false);
    }

    private zzfjn(int i, Class<T> cls, zzffu<?, ?> zzffuVar, int i2, boolean z) {
        this.type = i;
        this.zznfk = cls;
        this.tag = i2;
        this.zzpnd = false;
        this.zzpgu = null;
    }

    public static <M extends zzfjm<M>, T extends zzfjs> zzfjn<M, T> zza(int i, Class<T> cls, long j) {
        return new zzfjn<>(11, cls, (int) j, false);
    }

    private final Object zzan(zzfjj zzfjjVar) {
        Class componentType = this.zzpnd ? this.zznfk.getComponentType() : this.zznfk;
        try {
            int i = this.type;
            if (i == 10) {
                zzfjs zzfjsVar = (zzfjs) componentType.newInstance();
                zzfjjVar.zza(zzfjsVar, this.tag >>> 3);
                return zzfjsVar;
            } else if (i == 11) {
                zzfjs zzfjsVar2 = (zzfjs) componentType.newInstance();
                zzfjjVar.zza(zzfjsVar2);
                return zzfjsVar2;
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfjn) {
            zzfjn zzfjnVar = (zzfjn) obj;
            return this.type == zzfjnVar.type && this.zznfk == zzfjnVar.zznfk && this.tag == zzfjnVar.tag && this.zzpnd == zzfjnVar.zzpnd;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zznfk.hashCode()) * 31) + this.tag) * 31) + (this.zzpnd ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(Object obj, zzfjk zzfjkVar) {
        try {
            zzfjkVar.zzmi(this.tag);
            int i = this.type;
            if (i == 10) {
                ((zzfjs) obj).zza(zzfjkVar);
                zzfjkVar.zzz(this.tag >>> 3, 4);
            } else if (i == 11) {
                zzfjkVar.zzb((zzfjs) obj);
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzbq(List<zzfju> list) {
        if (list == null) {
            return null;
        }
        if (!this.zzpnd) {
            if (list.isEmpty()) {
                return null;
            }
            return this.zznfk.cast(zzan(zzfjj.zzbe(list.get(list.size() - 1).zzjng)));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzfju zzfjuVar = list.get(i);
            if (zzfjuVar.zzjng.length != 0) {
                arrayList.add(zzan(zzfjj.zzbe(zzfjuVar.zzjng)));
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.zznfk;
        T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzcs(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.type;
        if (i2 != 10) {
            if (i2 == 11) {
                return zzfjk.zzb(i, (zzfjs) obj);
            }
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return (zzfjk.zzlg(i) << 1) + ((zzfjs) obj).zzho();
    }
}
