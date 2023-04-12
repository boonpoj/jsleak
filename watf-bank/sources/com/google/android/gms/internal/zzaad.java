package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzaad implements zzit {
    static final zzit zzcmt = new zzaad();

    /* renamed from: com.google.android.gms.internal.zzaad$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements PendingResult.zza {
        final /* synthetic */ zzzx zzazE;

        AnonymousClass1(zzzx zzzxVar) {
            this.zzazE = zzzxVar;
        }

        public void zzx(Status status) {
            zzaad.zza(zzaad.this).remove(this.zzazE);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaad$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements OnCompleteListener<TResult> {
        final /* synthetic */ TaskCompletionSource zzazG;

        AnonymousClass2(TaskCompletionSource taskCompletionSource) {
            this.zzazG = taskCompletionSource;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<TResult> task) {
            zzaad.zzb(zzaad.this).remove(this.zzazG);
        }
    }

    @Override // com.google.android.gms.internal.zzit
    public final void zza(zzjc zzjcVar) {
        zzjcVar.zzbcz.zzbct = 7;
    }
}
