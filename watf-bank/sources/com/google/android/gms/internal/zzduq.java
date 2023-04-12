package com.google.android.gms.internal;
/* loaded from: classes.dex */
final /* synthetic */ class zzduq {
    static final /* synthetic */ int[] zzlzc;
    static final /* synthetic */ int[] zzlzd = new int[zzdur.values().length];

    static {
        try {
            zzlzd[zzdur.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzlzd[zzdur.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzlzd[zzdur.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        zzlzc = new int[zzdus.values().length];
        try {
            zzlzc[zzdus.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzlzc[zzdus.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
