package com.google.android.gms.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.MainThread;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzaar;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzzw {

    /* loaded from: assets/classes2.dex */
    private class zza implements Runnable {
        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [android.content.DialogInterface$OnCancelListener, com.google.android.gms.internal.zzzw] */
        /* JADX WARN: Type inference failed for: r6v0, types: [android.content.DialogInterface$OnCancelListener, com.google.android.gms.internal.zzzw] */
        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            if (zzzw.this.mStarted) {
                if (zzzw.zza(zzzw.this).hasResolution()) {
                    zzzw.this.zzaBs.startActivityForResult(GoogleApiActivity.zzb(zzzw.this.getActivity(), zzzw.zza(zzzw.this).getResolution(), zzzw.zzb(zzzw.this), false), 1);
                } else if (zzzw.this.zzaxX.isUserResolvableError(zzzw.zza(zzzw.this).getErrorCode())) {
                    zzzw.this.zzaxX.zza(zzzw.this.getActivity(), zzzw.this.zzaBs, zzzw.zza(zzzw.this).getErrorCode(), 2, (DialogInterface.OnCancelListener) zzzw.this);
                } else if (zzzw.zza(zzzw.this).getErrorCode() != 18) {
                    zzzw.this.zza(zzzw.zza(zzzw.this), zzzw.zzb(zzzw.this));
                } else {
                    final Dialog zza = zzzw.this.zzaxX.zza(zzzw.this.getActivity(), (DialogInterface.OnCancelListener) zzzw.this);
                    zzzw.this.zzaxX.zza(zzzw.this.getActivity().getApplicationContext(), new zzaar.zza() { // from class: com.google.android.gms.internal.zzzw.zza.1
                        @Override // com.google.android.gms.internal.zzaar.zza
                        public void zzvb() {
                            zzzw.this.zzva();
                            if (zza.isShowing()) {
                                zza.dismiss();
                            }
                        }
                    });
                }
            }
        }
    }
}
