package com.google.android.gms.internal;

import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfgq implements zzfhw {
    private static final zzfhd zzpig = new zzfgr();
    private final zzfhd zzpie;
    private final zzfgu zzpif;

    public zzfgq() {
        this(zzfgu.DYNAMIC);
    }

    private zzfgq(zzfgu zzfguVar) {
        this(new zzfgt(zzfft.zzcxl(), zzcyo()), zzfguVar);
    }

    private zzfgq(zzfhd zzfhdVar, zzfgu zzfguVar) {
        this.zzpie = (zzfhd) zzffz.zzc(zzfhdVar, "messageInfoFactory");
        this.zzpif = (zzfgu) zzffz.zzc(zzfguVar, InternalAvidAdSessionContext.CONTEXT_MODE);
    }

    private static <T> zzfhv<T> zza(Class<T> cls, zzfhc zzfhcVar) {
        return zzffu.class.isAssignableFrom(cls) ? zza(zzfhcVar) ? zzfhi.zza(cls, zzfhcVar, zzfgm.zzcyn(), zzfhx.zzczg(), zzffp.zzcxd(), zzfhb.zzcyt()) : zzfhi.zza(cls, zzfhcVar, zzfgm.zzcyn(), zzfhx.zzczg(), null, zzfhb.zzcyt()) : zza(zzfhcVar) ? zzfhi.zza(cls, zzfhcVar, zzfgm.zzcym(), zzfhx.zzcze(), zzffp.zzcxe(), zzfhb.zzcys()) : zzfhi.zza(cls, zzfhcVar, zzfgm.zzcym(), zzfhx.zzczf(), null, zzfhb.zzcys());
    }

    private static boolean zza(zzfhc zzfhcVar) {
        return zzfhcVar.zzcyv() == zzfhm.zzpiy;
    }

    private static <T> zzfhv<T> zzb(Class<T> cls, zzfhc zzfhcVar) {
        return zzffu.class.isAssignableFrom(cls) ? zza(zzfhcVar) ? zzfhi.zzb(cls, zzfhcVar, zzfgm.zzcyn(), zzfhx.zzczg(), zzffp.zzcxd(), zzfhb.zzcyt()) : zzfhi.zzb(cls, zzfhcVar, zzfgm.zzcyn(), zzfhx.zzczg(), null, zzfhb.zzcyt()) : zza(zzfhcVar) ? zzfhi.zzb(cls, zzfhcVar, zzfgm.zzcym(), zzfhx.zzcze(), zzffp.zzcxe(), zzfhb.zzcys()) : zzfhi.zzb(cls, zzfhcVar, zzfgm.zzcym(), zzfhx.zzczf(), null, zzfhb.zzcys());
    }

    private static zzfhd zzcyo() {
        try {
            return (zzfhd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return zzpig;
        }
    }

    @Override // com.google.android.gms.internal.zzfhw
    public final <T> zzfhv<T> zzk(Class<T> cls) {
        zzfin<?, ?> zzcze;
        zzffn<?> zzcxe;
        zzfhx.zzm(cls);
        zzfhc zzj = this.zzpie.zzj(cls);
        if (zzj.zzcyw()) {
            if (zzffu.class.isAssignableFrom(cls)) {
                zzcze = zzfhx.zzczg();
                zzcxe = zzffp.zzcxd();
            } else {
                zzcze = zzfhx.zzcze();
                zzcxe = zzffp.zzcxe();
            }
            return zzfhj.zza(cls, zzcze, zzcxe, zzj.zzcyx());
        }
        int i = zzfgs.zzpih[this.zzpif.ordinal()];
        if (i != 1) {
            if (i != 2 && zzj.zzcyy()) {
                return zza(cls, zzj);
            }
            return zzb(cls, zzj);
        }
        return zza(cls, zzj);
    }
}
