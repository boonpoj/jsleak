package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhg {
    private final Object zzayr = new Object();
    private zzhh zzays = null;
    private boolean zzayt = false;

    public final Activity getActivity() {
        synchronized (this.zzayr) {
            if (this.zzays != null) {
                return this.zzays.getActivity();
            }
            return null;
        }
    }

    public final Context getContext() {
        synchronized (this.zzayr) {
            if (this.zzays != null) {
                return this.zzays.getContext();
            }
            return null;
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzayr) {
            if (!this.zzayt) {
                if (!((Boolean) zzkb.zzif().zzd(zznh.zzble)).booleanValue()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzagf.zzcu("Can not cast Context to Application");
                    return;
                }
                if (this.zzays == null) {
                    this.zzays = new zzhh();
                }
                this.zzays.zza(application, context);
                this.zzayt = true;
            }
        }
    }

    public final void zza(zzhj zzhjVar) {
        synchronized (this.zzayr) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzble)).booleanValue()) {
                if (this.zzays == null) {
                    this.zzays = new zzhh();
                }
                this.zzays.zza(zzhjVar);
            }
        }
    }
}
