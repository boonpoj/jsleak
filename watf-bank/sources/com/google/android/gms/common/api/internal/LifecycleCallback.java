package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LifecycleCallback {
    protected final zzcf zzfud;

    protected LifecycleCallback(zzcf zzcfVar) {
        this.zzfud = zzcfVar;
    }

    private static zzcf getChimeraLifecycleFragmentImpl(zzce zzceVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    protected static zzcf zzb(zzce zzceVar) {
        if (zzceVar.zzajj()) {
            return zzdb.zza(zzceVar.zzajm());
        }
        if (zzceVar.zzajk()) {
            return zzcg.zzo(zzceVar.zzajl());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static zzcf zzn(Activity activity) {
        return zzb(new zzce(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Activity getActivity() {
        return this.zzfud.zzajn();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
