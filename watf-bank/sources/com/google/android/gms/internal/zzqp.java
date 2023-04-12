package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;
import java.util.WeakHashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzqp implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzqp> zzbwk = new WeakHashMap<>();
    private final VideoController zzbgd = new VideoController();
    private final zzqm zzbwl;
    private final MediaView zzbwm;

    private zzqp(zzqm zzqmVar) {
        Context context;
        this.zzbwl = zzqmVar;
        MediaView mediaView = null;
        try {
            context = (Context) com.google.android.gms.dynamic.zzn.zzx(zzqmVar.zzka());
        } catch (RemoteException | NullPointerException e) {
            zzakb.zzb("Unable to inflate MediaView.", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzbwl.zzf(com.google.android.gms.dynamic.zzn.zzz(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzakb.zzb("Unable to render video in MediaView.", e2);
            }
        }
        this.zzbwm = mediaView;
    }

    public static zzqp zza(zzqm zzqmVar) {
        synchronized (zzbwk) {
            zzqp zzqpVar = zzbwk.get(zzqmVar.asBinder());
            if (zzqpVar != null) {
                return zzqpVar;
            }
            zzqp zzqpVar2 = new zzqp(zzqmVar);
            zzbwk.put(zzqmVar.asBinder(), zzqpVar2);
            return zzqpVar2;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.zzbwl.destroy();
        } catch (RemoteException e) {
            zzakb.zzb("Failed to destroy ad.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzbwl.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzakb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzbwl.getCustomTemplateId();
        } catch (RemoteException e) {
            zzakb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzpq zzaq = this.zzbwl.zzaq(str);
            if (zzaq != null) {
                return new zzpt(zzaq);
            }
            return null;
        } catch (RemoteException e) {
            zzakb.zzb("Failed to get image.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.zzbwl.zzap(str);
        } catch (RemoteException e) {
            zzakb.zzb("Failed to get string.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzll videoController = this.zzbwl.getVideoController();
            if (videoController != null) {
                this.zzbgd.zza(videoController);
            }
        } catch (RemoteException e) {
            zzakb.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbgd;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.zzbwm;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.zzbwl.performClick(str);
        } catch (RemoteException e) {
            zzakb.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.zzbwl.recordImpression();
        } catch (RemoteException e) {
            zzakb.zzb("Failed to record impression.", e);
        }
    }

    public final zzqm zzkm() {
        return this.zzbwl;
    }
}
