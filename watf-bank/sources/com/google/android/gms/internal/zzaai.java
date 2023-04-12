package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaan;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
final class zzaai extends Exception {
    private final int mErrorCode;

    /* renamed from: com.google.android.gms.internal.zzaai$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends zzaan.zza {
        AnonymousClass1(zzaam zzaamVar) {
            super(zzaamVar);
        }

        @Override // com.google.android.gms.internal.zzaan.zza
        public void zzvA() {
            zzaai.this.onConnectionSuspended(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaai$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 extends zzaan.zza {
        AnonymousClass2(zzaam zzaamVar) {
            super(zzaamVar);
        }

        @Override // com.google.android.gms.internal.zzaan.zza
        public void zzvA() {
            zzaai.zza(zzaai.this).zzaAK.zzo(null);
        }
    }

    public zzaai(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
