package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafz;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaif;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzzv;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
@zzzv
/* loaded from: classes.dex */
public final class zzbt implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public final Context zzair;
    boolean zzaqo;
    final String zzatv;
    public String zzatw;
    final zzcv zzatx;
    public final zzakd zzaty;
    zzbu zzatz;
    public zzagb zzaua;
    public zzaif zzaub;
    public zzjn zzauc;
    public zzafo zzaud;
    public zzafp zzaue;
    public zzafq zzauf;
    zzke zzaug;
    zzkh zzauh;
    zzkx zzaui;
    zzld zzauj;
    zzqq zzauk;
    zzqt zzaul;
    SimpleArrayMap<String, zzqw> zzaum;
    SimpleArrayMap<String, zzqz> zzaun;
    zzpe zzauo;
    zzmr zzaup;
    zzlr zzauq;
    zzrf zzaur;
    List<Integer> zzaus;
    zzoa zzaut;
    zzadp zzauu;
    public String zzauv;
    List<String> zzauw;
    public zzafz zzaux;
    View zzauy;
    public int zzauz;
    private HashSet<zzafq> zzava;
    private int zzavb;
    private int zzavc;
    private zzaji zzavd;
    private boolean zzave;
    private boolean zzavf;
    private boolean zzavg;

    public zzbt(Context context, zzjn zzjnVar, String str, zzakd zzakdVar) {
        this(context, zzjnVar, str, zzakdVar, null);
    }

    private zzbt(Context context, zzjn zzjnVar, String str, zzakd zzakdVar, zzcv zzcvVar) {
        this.zzaux = null;
        this.zzauy = null;
        this.zzauz = 0;
        this.zzaqo = false;
        this.zzava = null;
        this.zzavb = -1;
        this.zzavc = -1;
        this.zzave = true;
        this.zzavf = true;
        this.zzavg = false;
        zznh.initialize(context);
        if (zzbs.zzem().zzpc() != null) {
            List<String> zzix = zznh.zzix();
            if (zzakdVar.zzdej != 0) {
                zzix.add(Integer.toString(zzakdVar.zzdej));
            }
            zzbs.zzem().zzpc().zzg(zzix);
        }
        this.zzatv = UUID.randomUUID().toString();
        if (zzjnVar.zzbel || zzjnVar.zzben) {
            this.zzatz = null;
        } else {
            this.zzatz = new zzbu(context, str, zzakdVar.zzcv, this, this);
            this.zzatz.setMinimumWidth(zzjnVar.widthPixels);
            this.zzatz.setMinimumHeight(zzjnVar.heightPixels);
            this.zzatz.setVisibility(4);
        }
        this.zzauc = zzjnVar;
        this.zzatw = str;
        this.zzair = context;
        this.zzaty = zzakdVar;
        this.zzatx = new zzcv(new zzaf(this));
        this.zzavd = new zzaji(200L);
        this.zzaun = new SimpleArrayMap<>();
    }

    private final void zze(boolean z) {
        zzafo zzafoVar;
        View findViewById;
        if (this.zzatz == null || (zzafoVar = this.zzaud) == null || zzafoVar.zzciy == null || this.zzaud.zzciy.zzsz() == null) {
            return;
        }
        if (!z || this.zzavd.tryAcquire()) {
            if (this.zzaud.zzciy.zzsz().zzfv()) {
                int[] iArr = new int[2];
                this.zzatz.getLocationOnScreen(iArr);
                zzkb.zzia();
                int zzd = zzajr.zzd(this.zzair, iArr[0]);
                zzkb.zzia();
                int zzd2 = zzajr.zzd(this.zzair, iArr[1]);
                if (zzd != this.zzavb || zzd2 != this.zzavc) {
                    this.zzavb = zzd;
                    this.zzavc = zzd2;
                    this.zzaud.zzciy.zzsz().zza(this.zzavb, this.zzavc, !z);
                }
            }
            zzbu zzbuVar = this.zzatz;
            if (zzbuVar == null || (findViewById = zzbuVar.getRootView().findViewById(16908290)) == null) {
                return;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.zzatz.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.zzave = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.zzavf = false;
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zze(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zze(true);
        this.zzavg = true;
    }

    public final void zza(HashSet<zzafq> hashSet) {
        this.zzava = hashSet;
    }

    public final void zzf(boolean z) {
        zzafo zzafoVar;
        if (this.zzauz == 0 && (zzafoVar = this.zzaud) != null && zzafoVar.zzciy != null) {
            this.zzaud.zzciy.stopLoading();
        }
        zzagb zzagbVar = this.zzaua;
        if (zzagbVar != null) {
            zzagbVar.cancel();
        }
        zzaif zzaifVar = this.zzaub;
        if (zzaifVar != null) {
            zzaifVar.cancel();
        }
        if (z) {
            this.zzaud = null;
        }
    }

    public final HashSet<zzafq> zzfh() {
        return this.zzava;
    }

    public final void zzfi() {
        zzafo zzafoVar = this.zzaud;
        if (zzafoVar == null || zzafoVar.zzciy == null) {
            return;
        }
        this.zzaud.zzciy.destroy();
    }

    public final void zzfj() {
        zzafo zzafoVar = this.zzaud;
        if (zzafoVar == null || zzafoVar.zzcet == null) {
            return;
        }
        try {
            this.zzaud.zzcet.destroy();
        } catch (RemoteException e) {
            zzagf.zzcu("Could not destroy mediation adapter.");
        }
    }

    public final boolean zzfk() {
        return this.zzauz == 0;
    }

    public final boolean zzfl() {
        return this.zzauz == 1;
    }

    public final String zzfm() {
        return (this.zzave && this.zzavf) ? "" : this.zzave ? this.zzavg ? "top-scrollable" : "top-locked" : this.zzavf ? this.zzavg ? "bottom-scrollable" : "bottom-locked" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(View view) {
        zzcr zzaf;
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbnp)).booleanValue() && (zzaf = this.zzatx.zzaf()) != null) {
            zzaf.zzb(view);
        }
    }
}
