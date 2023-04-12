package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public abstract class zzagb implements zzaif<zzakv> {
    private volatile Thread zzdac;
    private final Runnable zzz = new zzagc(this);
    private boolean zzdad = false;

    public zzagb() {
    }

    public zzagb(boolean z) {
    }

    @Override // com.google.android.gms.internal.zzaif
    public final void cancel() {
        onStop();
        if (this.zzdac != null) {
            this.zzdac.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzdm();

    @Override // com.google.android.gms.internal.zzaif
    public final /* synthetic */ zzakv zznd() {
        return this.zzdad ? zzahh.zza(1, this.zzz) : zzahh.zza(this.zzz);
    }

    public final zzakv zzpy() {
        return this.zzdad ? zzahh.zza(1, this.zzz) : zzahh.zza(this.zzz);
    }
}
