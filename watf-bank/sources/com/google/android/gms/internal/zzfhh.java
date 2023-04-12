package com.google.android.gms.internal;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfhh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzfhe zzfheVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzfheVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x018d, code lost:
        if (((java.lang.Boolean) r9).booleanValue() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018f, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019f, code lost:
        if (((java.lang.Integer) r9).intValue() == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b0, code lost:
        if (((java.lang.Float) r9).floatValue() == 0.0f) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c2, code lost:
        if (((java.lang.Double) r9).doubleValue() == 0.0d) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.zzfhe r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhh.zza(com.google.android.gms.internal.zzfhe, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzfih.zzbc(zzfes.zztr((String) obj)));
            sb.append('\"');
        } else if (obj instanceof zzfes) {
            sb.append(": \"");
            sb.append(zzfih.zzbc((zzfes) obj));
            sb.append('\"');
        } else if (!(obj instanceof zzffu)) {
            sb.append(": ");
            sb.append(obj.toString());
        } else {
            sb.append(" {");
            zza((zzffu) obj, sb, i + 2);
            sb.append("\n");
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        }
    }

    private static final String zztv(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
