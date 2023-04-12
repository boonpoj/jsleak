package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class zzi<TListener> {
    private TListener zzfuk;
    private /* synthetic */ zzd zzfza;
    private boolean zzfzb = false;

    public zzi(zzd zzdVar, TListener tlistener) {
        this.zzfza = zzdVar;
        this.zzfuk = tlistener;
    }

    public final void removeListener() {
        synchronized (this) {
            this.zzfuk = null;
        }
    }

    public final void unregister() {
        ArrayList arrayList;
        ArrayList arrayList2;
        removeListener();
        arrayList = this.zzfza.zzfyo;
        synchronized (arrayList) {
            arrayList2 = this.zzfza.zzfyo;
            arrayList2.remove(this);
        }
    }

    public final void zzaks() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zzfuk;
            if (this.zzfzb) {
                String valueOf = String.valueOf(this);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Callback proxy ");
                sb.append(valueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                zzw(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzfzb = true;
        }
        unregister();
    }

    protected abstract void zzw(TListener tlistener);
}
