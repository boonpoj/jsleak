package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@zzzv
/* loaded from: classes.dex */
public final class zzaf implements zzcr, Runnable {
    private Context zzair;
    private final List<Object[]> zzapa;
    private final AtomicReference<zzcr> zzapb;
    private zzakd zzapc;
    private CountDownLatch zzapd;

    private zzaf(Context context, zzakd zzakdVar) {
        this.zzapa = new Vector();
        this.zzapb = new AtomicReference<>();
        this.zzapd = new CountDownLatch(1);
        this.zzair = context;
        this.zzapc = zzakdVar;
        zzkb.zzia();
        if (zzajr.zzqz()) {
            zzahh.zza(this);
        } else {
            run();
        }
    }

    public zzaf(zzbt zzbtVar) {
        this(zzbtVar.zzair, zzbtVar.zzaty);
    }

    private static Context zzd(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzdd() {
        try {
            this.zzapd.await();
            return true;
        } catch (InterruptedException e) {
            zzagf.zzc("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzde() {
        if (this.zzapa.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.zzapa) {
            if (objArr.length == 1) {
                this.zzapb.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.zzapb.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzapa.clear();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.google.android.gms.internal.zzakd] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzapc.zzdel;
            if (!((Boolean) zzkb.zzif().zzd(zznh.zzblj)).booleanValue() && z2) {
                z = true;
            }
            this.zzapb.set(zzcu.zza(this.zzapc.zzcv, zzd(this.zzair), z));
        } finally {
            this.zzapd.countDown();
            this.zzair = null;
            this.zzapc = null;
        }
    }

    @Override // com.google.android.gms.internal.zzcr
    public final String zza(Context context) {
        zzcr zzcrVar;
        if (!zzdd() || (zzcrVar = this.zzapb.get()) == null) {
            return "";
        }
        zzde();
        return zzcrVar.zza(zzd(context));
    }

    @Override // com.google.android.gms.internal.zzcr
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.zzcr
    public final String zza(Context context, String str, View view, Activity activity) {
        zzcr zzcrVar;
        if (!zzdd() || (zzcrVar = this.zzapb.get()) == null) {
            return "";
        }
        zzde();
        return zzcrVar.zza(zzd(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.zzcr
    public final void zza(int i, int i2, int i3) {
        zzcr zzcrVar = this.zzapb.get();
        if (zzcrVar == null) {
            this.zzapa.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        zzde();
        zzcrVar.zza(i, i2, i3);
    }

    @Override // com.google.android.gms.internal.zzcr
    public final void zza(MotionEvent motionEvent) {
        zzcr zzcrVar = this.zzapb.get();
        if (zzcrVar == null) {
            this.zzapa.add(new Object[]{motionEvent});
            return;
        }
        zzde();
        zzcrVar.zza(motionEvent);
    }

    @Override // com.google.android.gms.internal.zzcr
    public final void zzb(View view) {
        zzcr zzcrVar = this.zzapb.get();
        if (zzcrVar != null) {
            zzcrVar.zzb(view);
        }
    }
}
