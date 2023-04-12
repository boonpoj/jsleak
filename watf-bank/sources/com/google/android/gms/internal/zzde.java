package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.util.Base64OutputStream;
import com.google.android.gms.internal.zzdh;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Comparator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzde implements zzdi {
    private /* synthetic */ Activity val$activity;

    /* renamed from: com.google.android.gms.internal.zzde$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Comparator<zzdh.zza> {
        AnonymousClass1(zzde zzdeVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(zzdh.zza zzaVar, zzdh.zza zzaVar2) {
            int i = zzaVar.zzyk - zzaVar2.zzyk;
            return i != 0 ? i : (int) (zzaVar.value - zzaVar2.value);
        }
    }

    /* loaded from: assets/classes2.dex */
    static class zza {
        ByteArrayOutputStream zzyg = new ByteArrayOutputStream(4096);
        Base64OutputStream zzyh = new Base64OutputStream(this.zzyg, 10);

        /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
        public String toString() {
            String str;
            try {
                this.zzyh.close();
            } catch (IOException e) {
                zzpe.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                try {
                    this.zzyg.close();
                    str = this.zzyg.toString();
                } catch (IOException e2) {
                    zzpe.zzb("HashManager: Unable to convert to Base64.", e2);
                    str = "";
                }
                return str;
            } finally {
                this.zzyg = null;
                this.zzyh = null;
            }
        }

        public void write(byte[] bArr) throws IOException {
            this.zzyh.write(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(zzda zzdaVar, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzdi
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
