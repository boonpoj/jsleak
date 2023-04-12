package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class DynamiteModule {
    private static Boolean zzgwq;
    private static zzk zzgwr;
    private static zzm zzgws;
    private static String zzgwt;
    private static final ThreadLocal<zza> zzgwu = new ThreadLocal<>();
    private static final zzi zzgwv = new com.google.android.gms.dynamite.zza();
    public static final zzd zzgww = new com.google.android.gms.dynamite.zzb();
    private static zzd zzgwx = new com.google.android.gms.dynamite.zzc();
    public static final zzd zzgwy = new com.google.android.gms.dynamite.zzd();
    public static final zzd zzgwz = new zze();
    public static final zzd zzgxa = new zzf();
    public static final zzd zzgxb = new zzg();
    private final Context zzgxc;

    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza {
        public Cursor zzgxd;

        private zza() {
        }

        /* synthetic */ zza(com.google.android.gms.dynamite.zza zzaVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zzb implements zzi {
        private final int zzgxe;
        private final int zzgxf = 0;

        public zzb(int i, int i2) {
            this.zzgxe = i;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzab(Context context, String str) {
            return this.zzgxe;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzc(Context context, String str, boolean z) {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        /* synthetic */ zzc(String str, com.google.android.gms.dynamite.zza zzaVar) {
            this(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, com.google.android.gms.dynamite.zza zzaVar) {
            this(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface zzd {
        zzj zza(Context context, String str, zzi zziVar) throws zzc;
    }

    private DynamiteModule(Context context) {
        this.zzgxc = (Context) zzbq.checkNotNull(context);
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzmVar) {
        try {
            return (Context) com.google.android.gms.dynamic.zzn.zzx(zzmVar.zza(com.google.android.gms.dynamic.zzn.zzz(context), str, i, com.google.android.gms.dynamic.zzn.zzz(cursor)));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(valueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0088, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r3.zzgxd != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d1, code lost:
        if (r3.zzgxd != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.dynamite.DynamiteModule zza(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.zzd r11, java.lang.String r12) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$zzd, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    private static DynamiteModule zza(Context context, String str, int i) throws zzc {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzgwq;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        }
        throw new zzc("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zza) null);
    }

    private static void zza(ClassLoader classLoader) throws zzc {
        zzm zznVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zznVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zznVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            zzgws = zznVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new zzc("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static int zzab(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf("com.google.android.gms.dynamite.descriptors.").length() + 1 + String.valueOf(str).length() + String.valueOf("ModuleDescriptor").length());
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException e) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzac(Context context, String str) {
        return zzc(context, str, false);
    }

    private static DynamiteModule zzad(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws zzc {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        zzk zzdf = zzdf(context);
        if (zzdf != null) {
            try {
                IObjectWrapper zza2 = zzdf.zza(com.google.android.gms.dynamic.zzn.zzz(context), str, i);
                if (com.google.android.gms.dynamic.zzn.zzx(zza2) != null) {
                    return new DynamiteModule((Context) com.google.android.gms.dynamic.zzn.zzx(zza2));
                }
                throw new zzc("Failed to load remote module.", (com.google.android.gms.dynamite.zza) null);
            } catch (RemoteException e) {
                throw new zzc("Failed to load remote module.", e, null);
            }
        }
        throw new zzc("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zza) null);
    }

    public static int zzc(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        synchronized (DynamiteModule.class) {
            Boolean bool2 = zzgwq;
            if (bool2 == null) {
                try {
                    loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                    declaredField = loadClass.getDeclaredField("sClassLoader");
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                    sb.append("Failed to load module via V2: ");
                    sb.append(valueOf);
                    Log.w("DynamiteModule", sb.toString());
                    bool2 = Boolean.FALSE;
                }
                synchronized (loadClass) {
                    ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                    if (classLoader != null) {
                        if (classLoader != ClassLoader.getSystemClassLoader()) {
                            try {
                                zza(classLoader);
                            } catch (zzc e2) {
                            }
                            bool = Boolean.TRUE;
                            bool2 = bool;
                            zzgwq = bool2;
                        }
                    } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                    } else {
                        try {
                            int zze = zze(context, str, z);
                            if (zzgwt != null && !zzgwt.isEmpty()) {
                                zzh zzhVar = new zzh(zzgwt, ClassLoader.getSystemClassLoader());
                                zza(zzhVar);
                                declaredField.set(null, zzhVar);
                                zzgwq = Boolean.TRUE;
                                return zze;
                            }
                            return zze;
                        } catch (zzc e3) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                        }
                    }
                    bool = Boolean.FALSE;
                    bool2 = bool;
                    zzgwq = bool2;
                }
            }
            if (bool2.booleanValue()) {
                try {
                    return zze(context, str, z);
                } catch (zzc e4) {
                    String valueOf2 = String.valueOf(e4.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                    return 0;
                }
            }
            return zzd(context, str, z);
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws zzc {
        zzm zzmVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzmVar = zzgws;
        }
        if (zzmVar != null) {
            zza zzaVar = zzgwu.get();
            if (zzaVar == null || zzaVar.zzgxd == null) {
                throw new zzc("No result cursor", (com.google.android.gms.dynamite.zza) null);
            }
            Context zza2 = zza(context.getApplicationContext(), str, i, zzaVar.zzgxd, zzmVar);
            if (zza2 != null) {
                return new DynamiteModule(zza2);
            }
            throw new zzc("Failed to get module context", (com.google.android.gms.dynamite.zza) null);
        }
        throw new zzc("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zza) null);
    }

    private static int zzd(Context context, String str, boolean z) {
        zzk zzdf = zzdf(context);
        if (zzdf == null) {
            return 0;
        }
        try {
            return zzdf.zza(com.google.android.gms.dynamic.zzn.zzz(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static zzk zzdf(Context context) {
        zzk zzlVar;
        synchronized (DynamiteModule.class) {
            if (zzgwr != null) {
                return zzgwr;
            } else if (com.google.android.gms.common.zzf.zzafy().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzlVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzlVar = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (zzlVar != null) {
                        zzgwr = zzlVar;
                        return zzlVar;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int zze(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r2 = r2 + 1
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r8 = "/"
            r3.append(r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r9)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r8 == 0) goto L82
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            if (r9 == 0) goto L82
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            if (r9 <= 0) goto L7c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.zzgwt = r1     // Catch: java.lang.Throwable -> L79
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = com.google.android.gms.dynamite.DynamiteModule.zzgwu     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            if (r10 == 0) goto L7c
            android.database.Cursor r1 = r10.zzgxd     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            if (r1 != 0) goto L7c
            r10.zzgxd = r8     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            r8 = r0
            goto L7c
        L79:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
        L7c:
            if (r8 == 0) goto L81
            r8.close()
        L81:
            return r9
        L82:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            com.google.android.gms.dynamite.DynamiteModule$zzc r9 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
            throw r9     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L95
        L91:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lad
        L95:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9e
        L9a:
            r8 = move-exception
            goto Lad
        L9c:
            r8 = move-exception
            r9 = r0
        L9e:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.zzc     // Catch: java.lang.Throwable -> Lab
            if (r10 == 0) goto La3
            throw r8     // Catch: java.lang.Throwable -> Lab
        La3:
            com.google.android.gms.dynamite.DynamiteModule$zzc r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch: java.lang.Throwable -> Lab
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lab
            throw r10     // Catch: java.lang.Throwable -> Lab
        Lab:
            r8 = move-exception
            r0 = r9
        Lad:
            if (r0 == 0) goto Lb2
            r0.close()
        Lb2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zze(android.content.Context, java.lang.String, boolean):int");
    }

    public final Context zzaqb() {
        return this.zzgxc;
    }

    public final IBinder zzhb(String str) throws zzc {
        try {
            return (IBinder) this.zzgxc.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
