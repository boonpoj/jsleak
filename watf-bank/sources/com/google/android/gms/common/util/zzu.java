package com.google.android.gms.common.util;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class zzu {
    private static final Pattern zzgev = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzgs(String str) {
        return str == null || str.trim().isEmpty();
    }
}
