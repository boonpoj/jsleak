package com.google.android.gms.internal;
/* loaded from: classes.dex */
final /* synthetic */ class zzdqw {
    static final /* synthetic */ int[] zzltf;
    static final /* synthetic */ int[] zzltg;
    static final /* synthetic */ int[] zzlth = new int[zzdsa.values().length];

    static {
        try {
            zzlth[zzdsa.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzlth[zzdsa.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        zzltg = new int[zzdso.values().length];
        try {
            zzltg[zzdso.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzltg[zzdso.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzltg[zzdso.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        zzltf = new int[zzdsq.values().length];
        try {
            zzltf[zzdsq.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zzltf[zzdsq.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            zzltf[zzdsq.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}
