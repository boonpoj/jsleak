package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
final class zzaet implements Runnable {
    private /* synthetic */ Bitmap val$bitmap;
    private /* synthetic */ zzaes zzcwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaet(zzaes zzaesVar, Bitmap bitmap) {
        this.zzcwm = zzaesVar;
        this.val$bitmap = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzfjw zzfjwVar;
        zzfjw zzfjwVar2;
        zzfjw zzfjwVar3;
        zzfjw zzfjwVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.val$bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.zzcwm.mLock;
        synchronized (obj) {
            zzfjwVar = this.zzcwm.zzcwe;
            zzfjwVar.zzpod = new zzfkd();
            zzfjwVar2 = this.zzcwm.zzcwe;
            zzfjwVar2.zzpod.zzpoy = byteArrayOutputStream.toByteArray();
            zzfjwVar3 = this.zzcwm.zzcwe;
            zzfjwVar3.zzpod.mimeType = "image/png";
            zzfjwVar4 = this.zzcwm.zzcwe;
            zzfjwVar4.zzpod.zzpnw = 1;
        }
    }
}
