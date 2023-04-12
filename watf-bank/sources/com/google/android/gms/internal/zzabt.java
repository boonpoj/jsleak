package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzabt implements Runnable {
    private /* synthetic */ zzabo zzcqn;

    /* loaded from: assets/classes2.dex */
    private static final class zza extends Drawable {
        private static final zza zzaDr = new zza();
        private static final C0003zza zzaDs = new C0003zza();

        /* renamed from: com.google.android.gms.internal.zzabt$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static final class C0003zza extends Drawable.ConstantState {
            private C0003zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.zzaDr;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return zzaDs;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* loaded from: assets/classes2.dex */
    static final class zzb extends Drawable.ConstantState {
        int mChangingConfigurations;
        int zzaDt;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.mChangingConfigurations = zzbVar.mChangingConfigurations;
                this.zzaDt = zzbVar.zzaDt;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzabt, android.graphics.drawable.Drawable] */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzabt(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabt(zzabo zzaboVar) {
        this.zzcqn = zzaboVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.js.zzaa zzaaVar;
        com.google.android.gms.ads.internal.js.zzaa zzaaVar2;
        zzaaVar = this.zzcqn.zzcqm;
        if (zzaaVar != null) {
            zzaaVar2 = this.zzcqn.zzcqm;
            zzaaVar2.release();
            this.zzcqn.zzcqm = null;
        }
    }
}
