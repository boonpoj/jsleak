package com.google.android.gms.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum zzfje {
    LOOSE { // from class: com.google.android.gms.internal.zzfjf
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.zzfje
        public final Object zza(zzffb zzffbVar) throws IOException {
            return zzffbVar.readString();
        }
    },
    STRICT { // from class: com.google.android.gms.internal.zzfjg
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.zzfje
        public final Object zza(zzffb zzffbVar) throws IOException {
            return zzffbVar.zzcwa();
        }
    },
    LAZY { // from class: com.google.android.gms.internal.zzfjh
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.zzfje
        public final Object zza(zzffb zzffbVar) throws IOException {
            return zzffbVar.zzcwb();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* synthetic */ zzfje(zzfix zzfixVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zza(zzffb zzffbVar) throws IOException;
}
