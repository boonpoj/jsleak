package com.google.android.gms.internal;

import java.util.Comparator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public enum zzu {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* renamed from: com.google.android.gms.internal.zzu$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements Comparator<byte[]> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }
}
