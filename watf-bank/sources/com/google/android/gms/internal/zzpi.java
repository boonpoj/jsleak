package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzpx;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzpi implements zzoq {
    private /* synthetic */ zzpg zzbvu;
    private /* synthetic */ View zzbvv;

    /* renamed from: com.google.android.gms.internal.zzpi$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzgl.zza {
        final /* synthetic */ List zzWU;
        final /* synthetic */ zzgl zzWV;
        final /* synthetic */ Context zztd;

        AnonymousClass1(zzpi zzpiVar, List list, zzgl zzglVar, Context context) {
            this.zzWU = list;
            this.zzWV = zzglVar;
            this.zztd = context;
        }

        @Override // com.google.android.gms.internal.zzgl.zza
        public void zzfE() {
            for (String str : this.zzWU) {
                String valueOf = String.valueOf(str);
                zzpe.zzbd(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
                this.zzWV.mayLaunchUrl(Uri.parse(str), null, null);
            }
            this.zzWV.zzd((Activity) this.zztd);
        }

        @Override // com.google.android.gms.internal.zzgl.zza
        public void zzfF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpi$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context zztd;

        AnonymousClass2(Context context) {
            this.zztd = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzpi.zza(zzpi.this)) {
                zzpi.zza(zzpi.this, zzpi.this.zzA(this.zztd));
                zzpi.zza(zzpi.this).notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpi$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzpx.zza {
        final /* synthetic */ String zzWX;
        final /* synthetic */ Context zztd;

        AnonymousClass3(zzpi zzpiVar, Context context, String str) {
            this.zztd = context;
            this.zzWX = str;
        }

        @Override // com.google.android.gms.internal.zzpx.zza
        public void zzu(String str) {
            com.google.android.gms.ads.internal.zzv.zzcJ().zzc(this.zztd, this.zzWX, str);
        }
    }

    /* loaded from: assets/classes2.dex */
    private final class zza extends BroadcastReceiver {
        private zza() {
        }

        /* synthetic */ zza(zzpi zzpiVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zzpi zzpiVar;
            boolean z;
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzpiVar = zzpi.this;
                z = true;
            } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                return;
            } else {
                zzpiVar = zzpi.this;
                z = false;
            }
            zzpi.zza(zzpiVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpi(zzpg zzpgVar, View view) {
        this.zzbvu = zzpgVar;
        this.zzbvv = view;
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzc(MotionEvent motionEvent) {
        this.zzbvu.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzkb() {
        this.zzbvu.onClick(this.zzbvv);
    }
}
