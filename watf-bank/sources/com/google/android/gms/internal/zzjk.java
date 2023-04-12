package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzjk {
    private Bundle mExtras;
    private boolean zzamr;
    private long zzbdv;
    private int zzbdw;
    private List<String> zzbdx;
    private boolean zzbdy;
    private int zzbdz;
    private String zzbea;
    private zzmn zzbeb;
    private String zzbec;
    private Bundle zzbed;
    private Bundle zzbee;
    private List<String> zzbef;
    private String zzbeg;
    private String zzbeh;
    private boolean zzbei;
    private Location zzhl;

    public zzjk() {
        this.zzbdv = -1L;
        this.mExtras = new Bundle();
        this.zzbdw = -1;
        this.zzbdx = new ArrayList();
        this.zzbdy = false;
        this.zzbdz = -1;
        this.zzamr = false;
        this.zzbea = null;
        this.zzbeb = null;
        this.zzhl = null;
        this.zzbec = null;
        this.zzbed = new Bundle();
        this.zzbee = new Bundle();
        this.zzbef = new ArrayList();
        this.zzbeg = null;
        this.zzbeh = null;
        this.zzbei = false;
    }

    public zzjk(zzjj zzjjVar) {
        this.zzbdv = zzjjVar.zzbdf;
        this.mExtras = zzjjVar.extras;
        this.zzbdw = zzjjVar.zzbdg;
        this.zzbdx = zzjjVar.zzbdh;
        this.zzbdy = zzjjVar.zzbdi;
        this.zzbdz = zzjjVar.zzbdj;
        this.zzamr = zzjjVar.zzbdk;
        this.zzbea = zzjjVar.zzbdl;
        this.zzbeb = zzjjVar.zzbdm;
        this.zzhl = zzjjVar.zzbdn;
        this.zzbec = zzjjVar.zzbdo;
        this.zzbed = zzjjVar.zzbdp;
        this.zzbee = zzjjVar.zzbdq;
        this.zzbef = zzjjVar.zzbdr;
        this.zzbeg = zzjjVar.zzbds;
        this.zzbeh = zzjjVar.zzbdt;
    }

    public final zzjk zza(Location location) {
        this.zzhl = null;
        return this;
    }

    public final zzjj zzhr() {
        return new zzjj(7, this.zzbdv, this.mExtras, this.zzbdw, this.zzbdx, this.zzbdy, this.zzbdz, this.zzamr, this.zzbea, this.zzbeb, this.zzhl, this.zzbec, this.zzbed, this.zzbee, this.zzbef, this.zzbeg, this.zzbeh, false);
    }
}
