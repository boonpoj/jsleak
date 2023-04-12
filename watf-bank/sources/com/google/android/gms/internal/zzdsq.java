package com.google.android.gms.internal;
/* loaded from: classes.dex */
public enum zzdsq implements zzfga {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdsq> zzbcl = new zzfgb<zzdsq>() { // from class: com.google.android.gms.internal.zzdsr
    };
    private final int value;

    zzdsq(int i) {
        this.value = i;
    }

    public static zzdsq zzfr(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return SHA512;
                    }
                    return SHA256;
                }
                return SHA224;
            }
            return SHA1;
        }
        return UNKNOWN_HASH;
    }

    @Override // com.google.android.gms.internal.zzfga
    public final int zzhq() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
