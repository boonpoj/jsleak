package com.google.android.gms.internal;
/* loaded from: classes.dex */
public enum zzfjd {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzfes.zzpfg),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzpmt;

    zzfjd(Object obj) {
        this.zzpmt = obj;
    }
}
