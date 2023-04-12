package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzyq implements zzajb<zzoi> {
    private /* synthetic */ String zzchb;
    private /* synthetic */ zzym zzcko;
    private /* synthetic */ boolean zzcky;
    private /* synthetic */ double zzckz;
    private /* synthetic */ boolean zzcla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyq(zzym zzymVar, boolean z, double d, boolean z2, String str) {
        this.zzcko = zzymVar;
        this.zzcky = z;
        this.zzckz = d;
        this.zzcla = z2;
        this.zzchb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzajb
    /* renamed from: zzd */
    public final zzoi zze(InputStream inputStream) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (this.zzckz * 160.0d);
        if (!this.zzcla) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e) {
            zzagf.zzb("Error grabbing image.", e);
            bitmap = null;
        }
        if (bitmap == null) {
            this.zzcko.zzd(2, this.zzcky);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (com.google.android.gms.common.util.zzq.zzaml() && zzagf.zzpz()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int allocationByteCount = bitmap.getAllocationByteCount();
            long j = uptimeMillis2 - uptimeMillis;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzagf.v(sb.toString());
        }
        return new zzoi(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(this.zzchb), this.zzckz);
    }

    @Override // com.google.android.gms.internal.zzajb
    public final /* synthetic */ zzoi zzni() {
        this.zzcko.zzd(2, this.zzcky);
        return null;
    }
}
