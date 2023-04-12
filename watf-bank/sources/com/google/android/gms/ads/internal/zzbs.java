package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.internal.zzacq;
import com.google.android.gms.internal.zzaff;
import com.google.android.gms.internal.zzaft;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzahy;
import com.google.android.gms.internal.zzahz;
import com.google.android.gms.internal.zzaia;
import com.google.android.gms.internal.zzaib;
import com.google.android.gms.internal.zzaic;
import com.google.android.gms.internal.zzaid;
import com.google.android.gms.internal.zzaie;
import com.google.android.gms.internal.zzaim;
import com.google.android.gms.internal.zzajf;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzajn;
import com.google.android.gms.internal.zzalg;
import com.google.android.gms.internal.zzaln;
import com.google.android.gms.internal.zzamz;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzhg;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zztg;
import com.google.android.gms.internal.zztq;
import com.google.android.gms.internal.zzuq;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzw;
@zzzv
/* loaded from: classes.dex */
public final class zzbs {
    private static final Object sLock = new Object();
    private static zzbs zzaso;
    private final com.google.android.gms.ads.internal.overlay.zza zzasp = new com.google.android.gms.ads.internal.overlay.zza();
    private final zzzw zzasq = new zzzw();
    private final com.google.android.gms.ads.internal.overlay.zzl zzasr = new com.google.android.gms.ads.internal.overlay.zzl();
    private final zzya zzass = new zzya();
    private final zzahn zzast = new zzahn();
    private final zzanr zzasu = new zzanr();
    private final zzaht zzasv;
    private final zzhg zzasw;
    private final zzaft zzasx;
    private final zzic zzasy;
    private final zzid zzasz;
    private final com.google.android.gms.common.util.zzd zzata;
    private final zzac zzatb;
    private final zznm zzatc;
    private final zzaim zzatd;
    private final zzacq zzate;
    private final zzalg zzatf;
    private final zztg zzatg;
    private final zztq zzath;
    private final zzajf zzati;
    private final com.google.android.gms.ads.internal.overlay.zzr zzatj;
    private final com.google.android.gms.ads.internal.overlay.zzs zzatk;
    private final zzuq zzatl;
    private final zzajg zzatm;
    private final zzaz zzatn;
    private final zzir zzato;
    private final zzaff zzatp;
    private final zzamz zzatq;
    private final zzaln zzatr;
    private final com.google.android.gms.ads.internal.js.zzb zzats;
    private final zzaie zzatt;
    private final zzajn zzatu;

    static {
        zzbs zzbsVar = new zzbs();
        synchronized (sLock) {
            zzaso = zzbsVar;
        }
    }

    protected zzbs() {
        int i = Build.VERSION.SDK_INT;
        this.zzasv = i >= 21 ? new zzaid() : i >= 19 ? new zzaic() : i >= 18 ? new zzaia() : i >= 17 ? new zzahz() : i >= 16 ? new zzaib() : new zzahy();
        this.zzasw = new zzhg();
        this.zzasx = new zzaft(this.zzast);
        this.zzasy = new zzic();
        this.zzasz = new zzid();
        this.zzata = com.google.android.gms.common.util.zzh.zzamg();
        this.zzatb = new zzac();
        this.zzatc = new zznm();
        this.zzatd = new zzaim();
        this.zzate = new zzacq();
        this.zzats = new com.google.android.gms.ads.internal.js.zzb();
        this.zzatf = new zzalg();
        this.zzatg = new zztg();
        this.zzath = new zztq();
        this.zzati = new zzajf();
        this.zzatj = new com.google.android.gms.ads.internal.overlay.zzr();
        this.zzatk = new com.google.android.gms.ads.internal.overlay.zzs();
        this.zzatl = new zzuq();
        this.zzatm = new zzajg();
        this.zzatn = new zzaz();
        this.zzato = new zzir();
        this.zzatp = new zzaff();
        this.zzatq = new zzamz();
        this.zzatr = new zzaln();
        this.zzatt = new zzaie();
        this.zzatu = new zzajn();
    }

    private static zzbs zzed() {
        zzbs zzbsVar;
        synchronized (sLock) {
            zzbsVar = zzaso;
        }
        return zzbsVar;
    }

    public static zzzw zzee() {
        return zzed().zzasq;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzef() {
        return zzed().zzasp;
    }

    public static com.google.android.gms.ads.internal.overlay.zzl zzeg() {
        return zzed().zzasr;
    }

    public static zzya zzeh() {
        return zzed().zzass;
    }

    public static zzahn zzei() {
        return zzed().zzast;
    }

    public static zzanr zzej() {
        return zzed().zzasu;
    }

    public static zzaht zzek() {
        return zzed().zzasv;
    }

    public static zzhg zzel() {
        return zzed().zzasw;
    }

    public static zzaft zzem() {
        return zzed().zzasx;
    }

    public static zzid zzen() {
        return zzed().zzasz;
    }

    public static com.google.android.gms.common.util.zzd zzeo() {
        return zzed().zzata;
    }

    public static zzac zzep() {
        return zzed().zzatb;
    }

    public static zznm zzeq() {
        return zzed().zzatc;
    }

    public static zzaim zzer() {
        return zzed().zzatd;
    }

    public static zzacq zzes() {
        return zzed().zzate;
    }

    public static zzalg zzet() {
        return zzed().zzatf;
    }

    public static zztg zzeu() {
        return zzed().zzatg;
    }

    public static zztq zzev() {
        return zzed().zzath;
    }

    public static zzajf zzew() {
        return zzed().zzati;
    }

    public static com.google.android.gms.ads.internal.overlay.zzr zzex() {
        return zzed().zzatj;
    }

    public static com.google.android.gms.ads.internal.overlay.zzs zzey() {
        return zzed().zzatk;
    }

    public static zzuq zzez() {
        return zzed().zzatl;
    }

    public static zzajg zzfa() {
        return zzed().zzatm;
    }

    public static zzamz zzfb() {
        return zzed().zzatq;
    }

    public static zzaln zzfc() {
        return zzed().zzatr;
    }

    public static zzaff zzfd() {
        return zzed().zzatp;
    }

    public static com.google.android.gms.ads.internal.js.zzb zzfe() {
        return zzed().zzats;
    }

    public static zzaie zzff() {
        return zzed().zzatt;
    }

    public static zzajn zzfg() {
        return zzed().zzatu;
    }
}
