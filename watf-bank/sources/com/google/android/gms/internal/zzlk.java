package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzlk extends zzeu implements zzlj {

    /* loaded from: assets/classes2.dex */
    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzPA;
        private Bitmap zzPB;

        public zza(WebView webView) {
            this.zzPA = webView;
        }

        @Override // android.os.AsyncTask
        protected synchronized void onPreExecute() {
            this.zzPB = Bitmap.createBitmap(zzlk.zza(zzlk.this), zzlk.zzb(zzlk.this), Bitmap.Config.ARGB_8888);
            this.zzPA.setVisibility(0);
            this.zzPA.measure(View.MeasureSpec.makeMeasureSpec(zzlk.zza(zzlk.this), 0), View.MeasureSpec.makeMeasureSpec(zzlk.zzb(zzlk.this), 0));
            this.zzPA.layout(0, 0, zzlk.zza(zzlk.this), zzlk.zzb(zzlk.this));
            this.zzPA.draw(new Canvas(this.zzPB));
            this.zzPA.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [com.google.android.gms.internal.zzlk, java.lang.Runnable] */
        @Override // android.os.AsyncTask
        /* renamed from: zza */
        public void onPostExecute(Boolean bool) {
            zzlk.zzc(zzlk.this);
            if (bool.booleanValue() || zzlk.this.zziz() || zzlk.zzd(zzlk.this) <= 0) {
                zzlk.this.zzPz = bool.booleanValue();
                zzlk.zze(zzlk.this).zza(zzlk.this.zzGt, true);
            } else if (zzlk.zzd(zzlk.this) > 0) {
                if (zzpe.zzai(2)) {
                    zzpe.zzbc("Ad not detected, scheduling another run.");
                }
                zzlk.zzg(zzlk.this).postDelayed(zzlk.this, zzlk.zzf(zzlk.this));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zzb */
        public synchronized Boolean doInBackground(Void... voidArr) {
            int width = this.zzPB.getWidth();
            int height = this.zzPB.getHeight();
            if (width != 0 && height != 0) {
                int i = 0;
                int i2 = 0;
                while (i < width) {
                    int i3 = i2;
                    for (int i4 = 0; i4 < height; i4 += 10) {
                        if (this.zzPB.getPixel(i, i4) != 0) {
                            i3++;
                        }
                    }
                    i += 10;
                    i2 = i3;
                }
                double d = i2;
                double d2 = width * height;
                Double.isNaN(d2);
                Double.isNaN(d);
                return Boolean.valueOf(d / (d2 / 100.0d) > 0.1d);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.zzlj
    public final IBinder zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeInt(11910000);
        Parcel zza2 = zza(1, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        zza2.recycle();
        return readStrongBinder;
    }
}
