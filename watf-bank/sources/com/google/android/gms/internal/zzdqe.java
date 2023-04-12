package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import com.google.android.gms.internal.zzdth;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class zzdqe {
    private static final Logger logger = Logger.getLogger(zzdqe.class.getName());
    private static final ConcurrentMap<String, zzdpw> zzlsx = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzlsy = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdpq> zzlsz = new ConcurrentHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdqc<P> zza(zzdpx zzdpxVar, zzdpw<P> zzdpwVar) throws GeneralSecurityException {
        zzdth zzblu = zzdpxVar.zzblu();
        if (zzblu.zzbpe() != 0) {
            int zzbpc = zzblu.zzbpc();
            boolean z = false;
            boolean z2 = true;
            for (zzdth.zzb zzbVar : zzblu.zzbpd()) {
                if (!zzbVar.zzbpg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzbpj())));
                }
                if (zzbVar.zzbpk() == zzdtt.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzbpj())));
                }
                if (zzbVar.zzbpi() == zzdtb.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzbpj())));
                }
                if (zzbVar.zzbpi() == zzdtb.ENABLED && zzbVar.zzbpj() == zzbpc) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzbVar.zzbph().zzbop() != zzdsy.zzb.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
            }
            if (z || z2) {
                zzdqc<P> zzdqcVar = (zzdqc<P>) new zzdqc();
                for (zzdth.zzb zzbVar2 : zzdpxVar.zzblu().zzbpd()) {
                    if (zzbVar2.zzbpi() == zzdtb.ENABLED) {
                        zzdqd zza = zzdqcVar.zza(zza(zzbVar2.zzbph().zzbon(), zzbVar2.zzbph().zzboo()), zzbVar2);
                        if (zzbVar2.zzbpj() == zzdpxVar.zzblu().zzbpc()) {
                            zzdqcVar.zza(zza);
                        }
                    }
                }
                return zzdqcVar;
            }
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static <P> zzdsy zza(zzdtd zzdtdVar) throws GeneralSecurityException {
        zzdpw zzoh = zzoh(zzdtdVar.zzbon());
        if (zzlsy.get(zzdtdVar.zzbon()).booleanValue()) {
            return zzoh.zzc(zzdtdVar.zzboo());
        }
        String valueOf = String.valueOf(zzdtdVar.zzbon());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
    }

    public static <P> zzfhe zza(String str, zzfhe zzfheVar) throws GeneralSecurityException {
        zzdpw zzoh = zzoh(str);
        if (zzlsy.get(str).booleanValue()) {
            return zzoh.zzb(zzfheVar);
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
    }

    private static <P> P zza(String str, zzfes zzfesVar) throws GeneralSecurityException {
        return (P) zzoh(str).zza(zzfesVar);
    }

    public static synchronized void zza(String str, zzdpq zzdpqVar) throws GeneralSecurityException {
        synchronized (zzdqe.class) {
            if (zzlsz.containsKey(str.toLowerCase()) && !zzdpqVar.getClass().equals(zzlsz.get(str.toLowerCase()).getClass())) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                String valueOf = String.valueOf(str);
                logger2.logp(level, "com.google.crypto.tink.Registry", "addCatalogue", valueOf.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(valueOf) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                sb.append("catalogue for name ");
                sb.append(str);
                sb.append(" has been already registered");
                throw new GeneralSecurityException(sb.toString());
            }
            zzlsz.put(str.toLowerCase(), zzdpqVar);
        }
    }

    public static <P> void zza(String str, zzdpw<P> zzdpwVar) throws GeneralSecurityException {
        zza(str, zzdpwVar, true);
    }

    public static synchronized <P> void zza(String str, zzdpw<P> zzdpwVar, boolean z) throws GeneralSecurityException {
        synchronized (zzdqe.class) {
            if (zzdpwVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            if (zzlsx.containsKey(str)) {
                zzdpw zzoh = zzoh(str);
                boolean booleanValue = zzlsy.get(str).booleanValue();
                if (!zzdpwVar.getClass().equals(zzoh.getClass()) || (!booleanValue && z)) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger2.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzoh.getClass().getName(), zzdpwVar.getClass().getName()));
                }
            }
            zzlsx.put(str, zzdpwVar);
            zzlsy.put(str, Boolean.valueOf(z));
        }
    }

    public static <P> zzfhe zzb(zzdtd zzdtdVar) throws GeneralSecurityException {
        zzdpw zzoh = zzoh(zzdtdVar.zzbon());
        if (zzlsy.get(zzdtdVar.zzbon()).booleanValue()) {
            return zzoh.zzb(zzdtdVar.zzboo());
        }
        String valueOf = String.valueOf(zzdtdVar.zzbon());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
    }

    public static <P> P zzb(String str, zzfhe zzfheVar) throws GeneralSecurityException {
        return (P) zzoh(str).zza(zzfheVar);
    }

    public static <P> P zzf(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) zza(str, zzfes.zzaz(bArr));
    }

    public static zzdpq zzog(String str) throws GeneralSecurityException {
        String valueOf;
        String str2;
        if (str != null) {
            zzdpq zzdpqVar = zzlsz.get(str.toLowerCase());
            if (zzdpqVar == null) {
                String format = String.format("no catalogue found for %s. ", str);
                if (str.toLowerCase().startsWith("tinkaead")) {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call AeadConfig.init().";
                } else if (str.toLowerCase().startsWith("tinkhybrid")) {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call HybridConfig.init().";
                } else if (str.toLowerCase().startsWith("tinkmac")) {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call MacConfig.init().";
                } else if (!str.toLowerCase().startsWith("tinksignature")) {
                    if (str.toLowerCase().startsWith("tink")) {
                        valueOf = String.valueOf(format);
                        str2 = "Maybe call TinkConfig.init().";
                    }
                    throw new GeneralSecurityException(format);
                } else {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call SignatureConfig.init().";
                }
                format = valueOf.concat(str2);
                throw new GeneralSecurityException(format);
            }
            return zzdpqVar;
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <P> zzdpw<P> zzoh(String str) throws GeneralSecurityException {
        zzdpw<P> zzdpwVar = zzlsx.get(str);
        if (zzdpwVar != null) {
            return zzdpwVar;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("No key manager found for key type: ");
        sb.append(str);
        sb.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(sb.toString());
    }
}
