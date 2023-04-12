package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class zzdb extends Fragment implements zzcf {
    private static WeakHashMap<FragmentActivity, WeakReference<zzdb>> zzfue = new WeakHashMap<>();
    private Bundle zzfug;
    private Map<String, LifecycleCallback> zzfuf = new ArrayMap();
    private int zzcbc = 0;

    public static zzdb zza(FragmentActivity fragmentActivity) {
        zzdb zzdbVar;
        WeakReference<zzdb> weakReference = zzfue.get(fragmentActivity);
        if (weakReference == null || (zzdbVar = weakReference.get()) == null) {
            try {
                zzdb zzdbVar2 = (zzdb) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzdbVar2 == null || zzdbVar2.isRemoving()) {
                    zzdbVar2 = new zzdb();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzdbVar2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zzfue.put(fragmentActivity, new WeakReference<>(zzdbVar2));
                return zzdbVar2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzdbVar;
    }

    @Override // android.support.v4.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzcbc = 1;
        this.zzfug = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfuf.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.zzcbc = 5;
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zzcbc = 3;
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfuf.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.zzcbc = 2;
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.zzcbc = 4;
        for (LifecycleCallback lifecycleCallback : this.zzfuf.values()) {
            lifecycleCallback.onStop();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    public final <T extends LifecycleCallback> T zza(String str, Class<T> cls) {
        return cls.cast(this.zzfuf.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    public final void zza(String str, LifecycleCallback lifecycleCallback) {
        if (this.zzfuf.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.zzfuf.put(str, lifecycleCallback);
        if (this.zzcbc > 0) {
            new Handler(Looper.getMainLooper()).post(new zzdc(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    public final /* synthetic */ Activity zzajn() {
        return getActivity();
    }
}
