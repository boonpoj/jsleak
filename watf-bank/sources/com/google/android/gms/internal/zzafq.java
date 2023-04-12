package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
@zzzv
/* loaded from: classes.dex */
public final class zzafq {
    private final Object mLock;
    private final zzaft zzasx;
    private boolean zzcsi;
    private final LinkedList<zzafr> zzcxz;
    private final String zzcya;
    private final String zzcyb;
    private long zzcyc;
    private long zzcyd;
    private long zzcye;
    private long zzcyf;
    private long zzcyg;
    private long zzcyh;

    private zzafq(zzaft zzaftVar, String str, String str2) {
        this.mLock = new Object();
        this.zzcyc = -1L;
        this.zzcyd = -1L;
        this.zzcsi = false;
        this.zzcye = -1L;
        this.zzcyf = 0L;
        this.zzcyg = -1L;
        this.zzcyh = -1L;
        this.zzasx = zzaftVar;
        this.zzcya = str;
        this.zzcyb = str2;
        this.zzcxz = new LinkedList<>();
    }

    public zzafq(String str, String str2) {
        this(com.google.android.gms.ads.internal.zzbs.zzem(), str, str2);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzcya);
            bundle.putString("slotid", this.zzcyb);
            bundle.putBoolean("ismediation", this.zzcsi);
            bundle.putLong("treq", this.zzcyg);
            bundle.putLong("tresponse", this.zzcyh);
            bundle.putLong("timp", this.zzcyd);
            bundle.putLong("tload", this.zzcye);
            bundle.putLong("pcc", this.zzcyf);
            bundle.putLong("tfetch", this.zzcyc);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzafr> it = this.zzcxz.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzh(long j) {
        synchronized (this.mLock) {
            this.zzcyh = j;
            if (this.zzcyh != -1) {
                this.zzasx.zza(this);
            }
        }
    }

    public final void zzi(long j) {
        synchronized (this.mLock) {
            if (this.zzcyh != -1) {
                this.zzcyc = j;
                this.zzasx.zza(this);
            }
        }
    }

    public final void zzo(zzjj zzjjVar) {
        synchronized (this.mLock) {
            this.zzcyg = SystemClock.elapsedRealtime();
            this.zzasx.zzpb().zzb(zzjjVar, this.zzcyg);
        }
    }

    public final void zzoo() {
        synchronized (this.mLock) {
            if (this.zzcyh != -1 && this.zzcyd == -1) {
                this.zzcyd = SystemClock.elapsedRealtime();
                this.zzasx.zza(this);
            }
            this.zzasx.zzpb().zzoo();
        }
    }

    public final void zzop() {
        synchronized (this.mLock) {
            if (this.zzcyh != -1) {
                zzafr zzafrVar = new zzafr();
                zzafrVar.zzot();
                this.zzcxz.add(zzafrVar);
                this.zzcyf++;
                this.zzasx.zzpb().zzop();
                this.zzasx.zza(this);
            }
        }
    }

    public final void zzoq() {
        synchronized (this.mLock) {
            if (this.zzcyh != -1 && !this.zzcxz.isEmpty()) {
                zzafr last = this.zzcxz.getLast();
                if (last.zzor() == -1) {
                    last.zzos();
                    this.zzasx.zza(this);
                }
            }
        }
    }

    public final void zzv(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcyh != -1) {
                this.zzcye = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzcyd = this.zzcye;
                    this.zzasx.zza(this);
                }
            }
        }
    }

    public final void zzw(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcyh != -1) {
                this.zzcsi = z;
                this.zzasx.zza(this);
            }
        }
    }
}
