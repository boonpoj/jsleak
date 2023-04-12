package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzdvj {
    public static boolean zzajk() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
