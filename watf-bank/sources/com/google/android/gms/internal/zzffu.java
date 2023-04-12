package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import com.google.android.gms.internal.zzffu.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class zzffu<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfek<MessageType, BuilderType> {
    private static Map<Object, zzffu<?, ?>> zzpgt = new ConcurrentHashMap();
    protected zzfio zzpgr = zzfio.zzczu();
    protected int zzpgs = -1;

    /* loaded from: classes.dex */
    public static abstract class zza<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfel<MessageType, BuilderType> {
        private final MessageType zzpgu;
        protected MessageType zzpgv;
        private boolean zzpgw = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzpgu = messagetype;
            this.zzpgv = (MessageType) messagetype.zza(zzg.zzphi, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzf zzfVar = zzf.zzphb;
            messagetype.zza(zzg.zzphd, zzfVar, messagetype2);
            messagetype.zzpgr = zzfVar.zza(messagetype.zzpgr, messagetype2.zzpgr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.zzfel, com.google.android.gms.internal.zzfhf
        /* renamed from: zzd */
        public final BuilderType zzb(zzffb zzffbVar, zzffm zzffmVar) throws IOException {
            zzcxr();
            try {
                this.zzpgv.zza(zzg.zzphg, zzffbVar, zzffmVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.zzfel
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzpgu.zza(zzg.zzphj, null, null);
            if (!this.zzpgw) {
                MessageType messagetype = this.zzpgv;
                messagetype.zza(zzg.zzphh, null, null);
                messagetype.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            zzaVar.zza((zza) this.zzpgv);
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.zzfhg
        public final boolean isInitialized() {
            return zzffu.zza(this.zzpgv, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.zzfel
        protected final /* synthetic */ zzfel zza(zzfek zzfekVar) {
            return zza((zza<MessageType, BuilderType>) ((zzffu) zzfekVar));
        }

        @Override // com.google.android.gms.internal.zzfel
        public final /* synthetic */ zzfel zza(zzffb zzffbVar, zzffm zzffmVar) throws IOException {
            return (zza) zzb(zzffbVar, zzffmVar);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzcxr();
            zza(this.zzpgv, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.zzfel
        public final /* synthetic */ zzfel zzcvh() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.zzfhg
        public final /* synthetic */ zzfhe zzcxq() {
            return this.zzpgu;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzcxr() {
            if (this.zzpgw) {
                MessageType messagetype = (MessageType) this.zzpgv.zza(zzg.zzphi, null, null);
                zza(messagetype, this.zzpgv);
                this.zzpgv = messagetype;
                this.zzpgw = false;
            }
        }

        public final MessageType zzcxs() {
            if (this.zzpgw) {
                return this.zzpgv;
            }
            MessageType messagetype = this.zzpgv;
            messagetype.zza(zzg.zzphh, null, null);
            messagetype.zzpgr.zzbiy();
            this.zzpgw = true;
            return this.zzpgv;
        }

        public final MessageType zzcxt() {
            if (!this.zzpgw) {
                MessageType messagetype = this.zzpgv;
                messagetype.zza(zzg.zzphh, null, null);
                messagetype.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            MessageType messagetype2 = this.zzpgv;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype2.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue != 1) {
                if (byteValue == 0) {
                    r1 = false;
                } else {
                    r1 = messagetype2.zza(zzg.zzphc, Boolean.FALSE, null) != null;
                    if (booleanValue) {
                        messagetype2.zza(zzg.zzphf, r1 ? messagetype2 : null, null);
                    }
                }
            }
            if (r1) {
                return messagetype2;
            }
            throw new zzfim(messagetype2);
        }

        @Override // com.google.android.gms.internal.zzfhf
        public final /* synthetic */ zzfhe zzcxu() {
            if (this.zzpgw) {
                return this.zzpgv;
            }
            MessageType messagetype = this.zzpgv;
            messagetype.zza(zzg.zzphh, null, null);
            messagetype.zzpgr.zzbiy();
            this.zzpgw = true;
            return this.zzpgv;
        }

        @Override // com.google.android.gms.internal.zzfhf
        public final /* synthetic */ zzfhe zzcxv() {
            if (!this.zzpgw) {
                MessageType messagetype = this.zzpgv;
                messagetype.zza(zzg.zzphh, null, null);
                messagetype.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            MessageType messagetype2 = this.zzpgv;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype2.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue != 1) {
                if (byteValue == 0) {
                    r1 = false;
                } else {
                    r1 = messagetype2.zza(zzg.zzphc, Boolean.FALSE, null) != null;
                    if (booleanValue) {
                        messagetype2.zza(zzg.zzphf, r1 ? messagetype2 : null, null);
                    }
                }
            }
            if (r1) {
                return messagetype2;
            }
            throw new zzfim(messagetype2);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb<T extends zzffu<T, ?>> extends zzfen<T> {
        private T zzpgu;

        public zzb(T t) {
            this.zzpgu = t;
        }

        @Override // com.google.android.gms.internal.zzfhk
        public final /* synthetic */ Object zze(zzffb zzffbVar, zzffm zzffmVar) throws zzfge {
            return zzffu.zza(this.zzpgu, zzffbVar, zzffmVar);
        }
    }

    /* loaded from: classes.dex */
    static class zzc implements zzh {
        static final zzc zzpgx = new zzc();
        private static zzffv zzpgy = new zzffv();

        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final double zza(boolean z, double d, boolean z2, double d2) {
            if (z == z2 && d == d2) {
                return d;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final int zza(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final long zza(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfes zza(boolean z, zzfes zzfesVar, boolean z2, zzfes zzfesVar2) {
            if (z == z2 && zzfesVar.equals(zzfesVar2)) {
                return zzfesVar;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfgc zza(zzfgc zzfgcVar, zzfgc zzfgcVar2) {
            if (zzfgcVar.equals(zzfgcVar2)) {
                return zzfgcVar;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T> zzfgd<T> zza(zzfgd<T> zzfgdVar, zzfgd<T> zzfgdVar2) {
            if (zzfgdVar.equals(zzfgdVar2)) {
                return zzfgdVar;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> zzfgyVar, zzfgy<K, V> zzfgyVar2) {
            if (zzfgyVar.equals(zzfgyVar2)) {
                return zzfgyVar;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T extends zzfhe> T zza(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t == null || t2 == null) {
                throw zzpgy;
            }
            zzffu zzffuVar = (zzffu) t;
            if (zzffuVar != t2 && ((zzffu) zzffuVar.zza(zzg.zzphk, (Object) null, (Object) null)).getClass().isInstance(t2)) {
                zzffu zzffuVar2 = (zzffu) t2;
                zzffuVar.zza(zzg.zzphd, this, zzffuVar2);
                zzffuVar.zzpgr = zza(zzffuVar.zzpgr, zzffuVar2.zzpgr);
            }
            return t;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfio zza(zzfio zzfioVar, zzfio zzfioVar2) {
            if (zzfioVar.equals(zzfioVar2)) {
                return zzfioVar;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zza(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final String zza(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzb(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzc(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzd(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final void zzdf(boolean z) {
            if (z) {
                throw zzpgy;
            }
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zze(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzf(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzg(boolean z, Object obj, Object obj2) {
            if (z) {
                zzffu zzffuVar = (zzffu) obj;
                zzfhe zzfheVar = (zzfhe) obj2;
                boolean z2 = true;
                if (zzffuVar != zzfheVar) {
                    if (((zzffu) zzffuVar.zza(zzg.zzphk, (Object) null, (Object) null)).getClass().isInstance(zzfheVar)) {
                        zzffu zzffuVar2 = (zzffu) zzfheVar;
                        zzffuVar.zza(zzg.zzphd, this, zzffuVar2);
                        zzffuVar.zzpgr = zza(zzffuVar.zzpgr, zzffuVar2.zzpgr);
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    return obj;
                }
            }
            throw zzpgy;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzffu<MessageType, BuilderType> implements zzfhg {
        protected zzffq<Object> zzpgz = zzffq.zzcxf();
    }

    /* loaded from: classes.dex */
    static class zze implements zzh {
        int zzpha = 0;

        zze() {
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final double zza(boolean z, double d, boolean z2, double d2) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzde(Double.doubleToLongBits(d));
            return d;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final int zza(boolean z, int i, boolean z2, int i2) {
            this.zzpha = (this.zzpha * 53) + i;
            return i;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final long zza(boolean z, long j, boolean z2, long j2) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzde(j);
            return j;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfes zza(boolean z, zzfes zzfesVar, boolean z2, zzfes zzfesVar2) {
            this.zzpha = (this.zzpha * 53) + zzfesVar.hashCode();
            return zzfesVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfgc zza(zzfgc zzfgcVar, zzfgc zzfgcVar2) {
            this.zzpha = (this.zzpha * 53) + zzfgcVar.hashCode();
            return zzfgcVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T> zzfgd<T> zza(zzfgd<T> zzfgdVar, zzfgd<T> zzfgdVar2) {
            this.zzpha = (this.zzpha * 53) + zzfgdVar.hashCode();
            return zzfgdVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> zzfgyVar, zzfgy<K, V> zzfgyVar2) {
            this.zzpha = (this.zzpha * 53) + zzfgyVar.hashCode();
            return zzfgyVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T extends zzfhe> T zza(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof zzffu) {
                zzffu zzffuVar = (zzffu) t;
                if (zzffuVar.zzpfa == 0) {
                    int i2 = this.zzpha;
                    this.zzpha = 0;
                    zzffuVar.zza(zzg.zzphd, this, zzffuVar);
                    zzffuVar.zzpgr = zza(zzffuVar.zzpgr, zzffuVar.zzpgr);
                    zzffuVar.zzpfa = this.zzpha;
                    this.zzpha = i2;
                }
                i = zzffuVar.zzpfa;
            } else {
                i = t.hashCode();
            }
            this.zzpha = (this.zzpha * 53) + i;
            return t;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfio zza(zzfio zzfioVar, zzfio zzfioVar2) {
            this.zzpha = (this.zzpha * 53) + zzfioVar.hashCode();
            return zzfioVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zza(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzdg(((Boolean) obj).booleanValue());
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final String zza(boolean z, String str, boolean z2, String str2) {
            this.zzpha = (this.zzpha * 53) + str.hashCode();
            return str;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzdg(z2);
            return z2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzb(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + ((Integer) obj).intValue();
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzc(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzde(Double.doubleToLongBits(((Double) obj).doubleValue()));
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzd(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + zzffz.zzde(((Long) obj).longValue());
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final void zzdf(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zze(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzf(boolean z, Object obj, Object obj2) {
            this.zzpha = (this.zzpha * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzg(boolean z, Object obj, Object obj2) {
            return zza((zzfhe) obj, (zzfhe) obj2);
        }
    }

    /* loaded from: classes.dex */
    public static class zzf implements zzh {
        public static final zzf zzphb = new zzf();

        private zzf() {
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final double zza(boolean z, double d, boolean z2, double d2) {
            return z2 ? d2 : d;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final int zza(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final long zza(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfes zza(boolean z, zzfes zzfesVar, boolean z2, zzfes zzfesVar2) {
            return z2 ? zzfesVar2 : zzfesVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfgc zza(zzfgc zzfgcVar, zzfgc zzfgcVar2) {
            int size = zzfgcVar.size();
            int size2 = zzfgcVar2.size();
            if (size > 0 && size2 > 0) {
                if (!zzfgcVar.zzcvi()) {
                    zzfgcVar = zzfgcVar.zzlu(size2 + size);
                }
                zzfgcVar.addAll(zzfgcVar2);
            }
            return size > 0 ? zzfgcVar : zzfgcVar2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T> zzfgd<T> zza(zzfgd<T> zzfgdVar, zzfgd<T> zzfgdVar2) {
            int size = zzfgdVar.size();
            int size2 = zzfgdVar2.size();
            if (size > 0 && size2 > 0) {
                if (!zzfgdVar.zzcvi()) {
                    zzfgdVar = zzfgdVar.zzly(size2 + size);
                }
                zzfgdVar.addAll(zzfgdVar2);
            }
            return size > 0 ? zzfgdVar : zzfgdVar2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> zzfgyVar, zzfgy<K, V> zzfgyVar2) {
            if (!zzfgyVar2.isEmpty()) {
                if (!zzfgyVar.isMutable()) {
                    zzfgyVar = zzfgyVar.zzcyq();
                }
                zzfgyVar.zza(zzfgyVar2);
            }
            return zzfgyVar;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final <T extends zzfhe> T zza(T t, T t2) {
            return (t == null || t2 == null) ? t != null ? t : t2 : (T) t.zzcxp().zzd(t2).zzcxv();
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final zzfio zza(zzfio zzfioVar, zzfio zzfioVar2) {
            return zzfioVar2 == zzfio.zzczu() ? zzfioVar : zzfio.zzb(zzfioVar, zzfioVar2);
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zza(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final String zza(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzb(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzc(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzd(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final void zzdf(boolean z) {
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zze(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzf(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.android.gms.internal.zzffu.zzh
        public final Object zzg(boolean z, Object obj, Object obj2) {
            return z ? zza((zzfhe) obj, (zzfhe) obj2) : obj2;
        }
    }

    /* loaded from: classes.dex */
    public enum zzg {
        public static final int zzphc = 1;
        public static final int zzphd = 2;
        public static final int zzphe = 3;
        public static final int zzphf = 4;
        public static final int zzphg = 5;
        public static final int zzphh = 6;
        public static final int zzphi = 7;
        public static final int zzphj = 8;
        public static final int zzphk = 9;
        public static final int zzphl = 10;
        private static final /* synthetic */ int[] zzphm = {zzphc, zzphd, zzphe, zzphf, zzphg, zzphh, zzphi, zzphj, zzphk, zzphl};
        public static final int zzphn = 1;
        public static final int zzpho = 2;
        private static final /* synthetic */ int[] zzphp = {zzphn, zzpho};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzphm.clone();
        }
    }

    /* loaded from: classes.dex */
    public interface zzh {
        double zza(boolean z, double d, boolean z2, double d2);

        int zza(boolean z, int i, boolean z2, int i2);

        long zza(boolean z, long j, boolean z2, long j2);

        zzfes zza(boolean z, zzfes zzfesVar, boolean z2, zzfes zzfesVar2);

        zzfgc zza(zzfgc zzfgcVar, zzfgc zzfgcVar2);

        <T> zzfgd<T> zza(zzfgd<T> zzfgdVar, zzfgd<T> zzfgdVar2);

        <K, V> zzfgy<K, V> zza(zzfgy<K, V> zzfgyVar, zzfgy<K, V> zzfgyVar2);

        <T extends zzfhe> T zza(T t, T t2);

        zzfio zza(zzfio zzfioVar, zzfio zzfioVar2);

        Object zza(boolean z, Object obj, Object obj2);

        String zza(boolean z, String str, boolean z2, String str2);

        boolean zza(boolean z, boolean z2, boolean z3, boolean z4);

        Object zzb(boolean z, Object obj, Object obj2);

        Object zzc(boolean z, Object obj, Object obj2);

        Object zzd(boolean z, Object obj, Object obj2);

        void zzdf(boolean z);

        Object zze(boolean z, Object obj, Object obj2);

        Object zzf(boolean z, Object obj, Object obj2);

        Object zzg(boolean z, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzffu<T, ?>> T zza(T t, zzfes zzfesVar) throws zzfge {
        boolean z;
        T t2 = (T) zza(t, zzfesVar, zzffm.zzcxb());
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue == 0) {
                z = false;
            } else {
                z = t2.zza(zzg.zzphc, Boolean.FALSE, null) != null;
                if (booleanValue) {
                    t2.zza(zzg.zzphf, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzfim(t2).zzczt().zzi(t2);
            }
        }
        if (t2 != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) t2.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue2 == 1) {
                r6 = true;
            } else if (byteValue2 != 0) {
                r6 = t2.zza(zzg.zzphc, Boolean.FALSE, null) != null;
                if (booleanValue2) {
                    t2.zza(zzg.zzphf, r6 ? t2 : null, null);
                }
            }
            if (!r6) {
                throw new zzfim(t2).zzczt().zzi(t2);
            }
        }
        return t2;
    }

    private static <T extends zzffu<T, ?>> T zza(T t, zzfes zzfesVar, zzffm zzffmVar) throws zzfge {
        try {
            zzffb zzcvm = zzfesVar.zzcvm();
            T t2 = (T) zza(t, zzcvm, zzffmVar);
            try {
                zzcvm.zzkp(0);
                return t2;
            } catch (zzfge e) {
                throw e.zzi(t2);
            }
        } catch (zzfge e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzffu<T, ?>> T zza(T t, zzffb zzffbVar, zzffm zzffmVar) throws zzfge {
        T t2 = (T) t.zza(zzg.zzphi, null, null);
        try {
            t2.zza(zzg.zzphg, zzffbVar, zzffmVar);
            t2.zza(zzg.zzphh, null, null);
            t2.zzpgr.zzbiy();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof zzfge) {
                throw ((zzfge) e.getCause());
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzffu<T, ?>> T zza(T t, byte[] bArr) throws zzfge {
        T t2 = (T) zza(t, bArr, zzffm.zzcxb());
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue == 1) {
                r2 = true;
            } else if (byteValue != 0) {
                r2 = t2.zza(zzg.zzphc, Boolean.FALSE, null) != null;
                if (booleanValue) {
                    t2.zza(zzg.zzphf, r2 ? t2 : null, null);
                }
            }
            if (!r2) {
                throw new zzfim(t2).zzczt().zzi(t2);
            }
        }
        return t2;
    }

    private static <T extends zzffu<T, ?>> T zza(T t, byte[] bArr, zzffm zzffmVar) throws zzfge {
        try {
            zzffb zzbb = zzffb.zzbb(bArr);
            T t2 = (T) zza(t, zzbb, zzffmVar);
            try {
                zzbb.zzkp(0);
                return t2;
            } catch (zzfge e) {
                throw e.zzi(t2);
            }
        } catch (zzfge e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzffu<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzg.zzphe, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        return (byteValue == 0 || t.zza(zzg.zzphc, Boolean.FALSE, null) == null) ? false : true;
    }

    protected static zzfgc zzcxn() {
        return zzffy.zzcxz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzfgd<E> zzcxo() {
        return zzfho.zzcza();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzffu) zza(zzg.zzphk, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            try {
                zzc zzcVar = zzc.zzpgx;
                zzffu zzffuVar = (zzffu) obj;
                zza(zzg.zzphd, zzcVar, zzffuVar);
                this.zzpgr = zzcVar.zza(this.zzpgr, zzffuVar.zzpgr);
                return true;
            } catch (zzffv e) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzpfa != 0) {
            return this.zzpfa;
        }
        zze zzeVar = new zze();
        zza(zzg.zzphd, zzeVar, this);
        zzfio zzfioVar = this.zzpgr;
        this.zzpgr = zzeVar.zza(zzfioVar, zzfioVar);
        this.zzpfa = zzeVar.zzpha;
        return this.zzpfa;
    }

    @Override // com.google.android.gms.internal.zzfhg
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zzg.zzphe, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean z = zza(zzg.zzphc, Boolean.FALSE, (Object) null) != null;
        if (booleanValue) {
            zza(zzg.zzphf, z ? this : null, (Object) null);
        }
        return z;
    }

    public String toString() {
        return zzfhh.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.zzfhe
    public void zza(zzffg zzffgVar) throws IOException {
        zzfhn.zzcyz().zzl(getClass()).zza(this, zzffi.zzb(zzffgVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(int i, zzffb zzffbVar) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.zzpgr == zzfio.zzczu()) {
            this.zzpgr = zzfio.zzczv();
        }
        return this.zzpgr.zzb(i, zzffbVar);
    }

    @Override // com.google.android.gms.internal.zzfhe
    public final zzfhk<MessageType> zzcxm() {
        return (zzfhk) zza(zzg.zzphl, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.zzfhe
    public final /* synthetic */ zzfhf zzcxp() {
        zza zzaVar = (zza) zza(zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.zzfhg
    public final /* synthetic */ zzfhe zzcxq() {
        return (zzffu) zza(zzg.zzphk, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.zzfhe
    public int zzho() {
        if (this.zzpgs == -1) {
            this.zzpgs = zzfhn.zzcyz().zzl(getClass()).zzcp(this);
        }
        return this.zzpgs;
    }
}
