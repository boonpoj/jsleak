package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
final class zzdui extends zzdug {
    private zzdui(zzdub zzdubVar) {
        super(zzdubVar);
    }

    @Override // com.google.android.gms.internal.zzdug
    final byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        int zzgg = zzdug.zzgg(bArr.length);
        int remaining = byteBuffer.remaining();
        int zzgg2 = zzdug.zzgg(remaining) + zzgg;
        ByteBuffer order = ByteBuffer.allocate(zzgg2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(zzgg);
        order.put(byteBuffer);
        order.position(zzgg2);
        order.putLong(bArr.length);
        order.putLong(remaining);
        return order.array();
    }
}
