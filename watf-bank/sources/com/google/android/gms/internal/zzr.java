package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.zzae;
import java.util.Collections;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzr<T> implements Comparable<zzr<T>> {
    private final Object mLock;
    private final zzae.zza zzaf;
    private final int zzag;
    private final String zzah;
    private final int zzai;
    private final zzx zzaj;
    private Integer zzak;
    private zzv zzal;
    private boolean zzam;
    private boolean zzan;
    private boolean zzao;
    private boolean zzap;
    private zzaa zzaq;
    private zzc zzar;
    private zzt zzas;

    public zzr(int i, String str, zzx zzxVar) {
        Uri parse;
        String host;
        this.zzaf = zzae.zza.zzbl ? new zzae.zza() : null;
        this.zzam = true;
        int i2 = 0;
        this.zzan = false;
        this.zzao = false;
        this.zzap = false;
        this.zzar = null;
        this.mLock = new Object();
        this.zzag = i;
        this.zzah = str;
        this.zzaj = zzxVar;
        this.zzaq = new zzh();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.zzai = i2;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzr zzrVar = (zzr) obj;
        zzu zzuVar = zzu.NORMAL;
        zzu zzuVar2 = zzu.NORMAL;
        return zzuVar == zzuVar2 ? this.zzak.intValue() - zzrVar.zzak.intValue() : zzuVar2.ordinal() - zzuVar.ordinal();
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzag;
    }

    public final String getUrl() {
        return this.zzah;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzai));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        String str = this.zzah;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.zzak);
        StringBuilder sb = new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zza(int i) {
        this.zzak = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zza(zzc zzcVar) {
        this.zzar = zzcVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zza(zzv zzvVar) {
        this.zzal = zzvVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzw<T> zza(zzp zzpVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzt zztVar) {
        synchronized (this.mLock) {
            this.zzas = zztVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzw<?> zzwVar) {
        synchronized (this.mLock) {
            if (this.zzas != null) {
                this.zzas.zza(this, zzwVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(T t);

    public final void zzb(zzad zzadVar) {
        zzx zzxVar = this.zzaj;
        if (zzxVar != null) {
            zzxVar.zzd(zzadVar);
        }
    }

    public final void zzb(String str) {
        if (zzae.zza.zzbl) {
            this.zzaf.zza(str, Thread.currentThread().getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzv zzvVar = this.zzal;
        if (zzvVar != null) {
            zzvVar.zzf(this);
        }
        if (zzae.zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzs(this, str, id));
                return;
            }
            this.zzaf.zza(str, id);
            this.zzaf.zzc(toString());
        }
    }

    public final int zzd() {
        return this.zzai;
    }

    public final zzc zze() {
        return this.zzar;
    }

    public byte[] zzf() throws zza {
        return null;
    }

    public final boolean zzg() {
        return this.zzam;
    }

    public final int zzh() {
        return this.zzaq.zzb();
    }

    public final zzaa zzi() {
        return this.zzaq;
    }

    public final void zzj() {
        this.zzao = true;
    }

    public final boolean zzk() {
        return this.zzao;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzl() {
        synchronized (this.mLock) {
            if (this.zzas != null) {
                this.zzas.zza(this);
            }
        }
    }
}
