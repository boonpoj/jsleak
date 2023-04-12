package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.Nullable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzdh implements zzdi {
    private /* synthetic */ Activity val$activity;

    /* loaded from: assets/classes2.dex */
    public static class zza {
        final long value;
        final String zzyj;
        final int zzyk;

        zza(long j, String str, int i) {
            this.value = j;
            this.zzyj = str;
            this.zzyk = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return zzaVar.value == this.value && zzaVar.zzyk == this.zzyk;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(zzda zzdaVar, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzdi
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
    }
}
