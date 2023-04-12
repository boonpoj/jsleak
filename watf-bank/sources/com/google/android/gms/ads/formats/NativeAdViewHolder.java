package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzpz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzamp = new WeakHashMap<>();
    private zzpz zzamo;
    private WeakReference<View> zzamq;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        zzbq.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzakb.e("The provided containerView is of type NativeAdView. NativeAdView objects should not be used with NativeAdViewHolder.");
        } else if (zzamp.get(view) != null) {
            zzakb.e("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzamp.put(view, this);
            this.zzamq = new WeakReference<>(view);
            this.zzamo = zzkb.zzib().zza(view, zzd(map), zzd(map2));
        }
    }

    private static HashMap<String, View> zzd(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        WeakReference<View> weakReference = this.zzamq;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzakb.zzcu("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzamp.containsKey(view)) {
            zzamp.put(view, this);
        }
        zzpz zzpzVar = this.zzamo;
        if (zzpzVar != null) {
            try {
                zzpzVar.zza((IObjectWrapper) nativeAd.zzbl());
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzpz zzpzVar = this.zzamo;
        if (zzpzVar != null) {
            try {
                zzpzVar.unregisterNativeAd();
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzamq;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzamp.remove(view);
        }
    }
}
