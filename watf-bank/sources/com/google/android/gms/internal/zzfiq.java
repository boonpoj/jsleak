package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
final class zzfiq {
    private static final boolean zzpfz;
    private static final boolean zzpkt;
    private static final boolean zzpku;
    private static final boolean zzpkv;
    private static final zzd zzpkw;
    private static final boolean zzpkx;
    private static final long zzpky;
    private static final long zzpkz;
    private static final long zzpla;
    private static final long zzplb;
    private static final long zzplc;
    private static final long zzpld;
    private static final long zzple;
    private static final long zzplf;
    private static final long zzplg;
    private static final long zzplh;
    private static final long zzpli;
    private static final long zzplj;
    private static final long zzplk;
    private static final long zzpll;
    private static final boolean zzplm;
    private static final Logger logger = Logger.getLogger(zzfiq.class.getName());
    private static final Unsafe zzlrs = zzczz();
    private static final Class<?> zzpks = zztx("libcore.io.Memory");

    /* loaded from: classes.dex */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfiq.zzplm) {
                zzfiq.zza(obj, j, b);
            } else {
                zzfiq.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final byte zzf(Object obj, long j) {
            return zzfiq.zzplm ? zzfiq.zzb(obj, j) : zzfiq.zzc(obj, j);
        }
    }

    /* loaded from: classes.dex */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfiq.zzplm) {
                zzfiq.zza(obj, j, b);
            } else {
                zzfiq.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final byte zzf(Object obj, long j) {
            return zzfiq.zzplm ? zzfiq.zzb(obj, j) : zzfiq.zzc(obj, j);
        }
    }

    /* loaded from: classes.dex */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzpln.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.zzfiq.zzd
        public final byte zzf(Object obj, long j) {
            return this.zzpln.getByte(obj, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class zzd {
        Unsafe zzpln;

        zzd(Unsafe unsafe) {
            this.zzpln = unsafe;
        }

        public final int zza(Object obj, long j) {
            return this.zzpln.getInt(obj, j);
        }

        public abstract void zze(Object obj, long j, byte b);

        public abstract byte zzf(Object obj, long j);
    }

    static {
        Field zza2;
        zzd zzdVar;
        zzpkt = zztx("org.robolectric.Robolectric") != null;
        zzpku = zzp(Long.TYPE);
        zzpkv = zzp(Integer.TYPE);
        zzd zzdVar2 = null;
        if (zzlrs != null) {
            if (!zzdac()) {
                zzdVar2 = new zzc(zzlrs);
            } else if (zzpku) {
                zzdVar2 = new zzb(zzlrs);
            } else if (zzpkv) {
                zzdVar2 = new zza(zzlrs);
            }
        }
        zzpkw = zzdVar2;
        zzpkx = zzdab();
        zzpfz = zzdaa();
        zzpky = zzn(byte[].class);
        zzpkz = zzn(boolean[].class);
        zzpla = zzo(boolean[].class);
        zzplb = zzn(int[].class);
        zzplc = zzo(int[].class);
        zzpld = zzn(long[].class);
        zzple = zzo(long[].class);
        zzplf = zzn(float[].class);
        zzplg = zzo(float[].class);
        zzplh = zzn(double[].class);
        zzpli = zzo(double[].class);
        zzplj = zzn(Object[].class);
        zzplk = zzo(Object[].class);
        if (!zzdac() || (zza2 = zza(Buffer.class, "effectiveDirectAddress")) == null) {
            zza2 = zza(Buffer.class, "address");
        }
        zzpll = (zza2 == null || (zzdVar = zzpkw) == null) ? -1L : zzdVar.zzpln.objectFieldOffset(zza2);
        zzplm = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzfiq() {
    }

    static int zza(Object obj, long j) {
        return zzpkw.zza(obj, j);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ (-1))));
    }

    private static void zza(Object obj, long j, int i) {
        zzpkw.zzpln.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b) {
        zzpkw.zze(bArr, zzpky + j, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzb(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) (((j ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zzb(byte[] bArr, long j) {
        return zzpkw.zzf(bArr, zzpky + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzc(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzczx() {
        return zzpfz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzczy() {
        return zzpkx;
    }

    private static Unsafe zzczz() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfir());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzdaa() {
        Unsafe unsafe = zzlrs;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzdac()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzdab() {
        Unsafe unsafe = zzlrs;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzdac()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzdac() {
        return (zzpks == null || zzpkt) ? false : true;
    }

    private static int zzn(Class<?> cls) {
        if (zzpfz) {
            return zzpkw.zzpln.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzo(Class<?> cls) {
        if (zzpfz) {
            return zzpkw.zzpln.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzp(Class<?> cls) {
        if (zzdac()) {
            try {
                Class<?> cls2 = zzpks;
                cls2.getMethod("peekLong", cls, Boolean.TYPE);
                cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
                cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
                cls2.getMethod("peekInt", cls, Boolean.TYPE);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private static <T> Class<T> zztx(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
