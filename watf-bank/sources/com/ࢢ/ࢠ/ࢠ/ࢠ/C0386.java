package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.os.Build;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0355;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢬ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0386 {

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static int f2572 = 565428102;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private static int f2573 = 117;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private static int f2574 = -1138247343;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private static byte[] f2575 = {-73, 79, -77, Byte.MAX_VALUE, -123, -125, -126, 73, 125, -81, 81, -77, 81, Byte.MAX_VALUE, -83, -121, 73, -78, Byte.MAX_VALUE, 85, -82, Byte.MIN_VALUE, 77, -79, 77, -80, -126, 123, -124, 77, -125, -87, -123, 117, -123, 120, -122, 82, -83, Byte.MIN_VALUE, -69, -66, 65, -78, 65, -66, 119, -120, -72, 70, 117, -116, 77, -66, -65, 112, -108, 105, -66, 69, 71, -118, 110, -118, 66, -78, 65, 71, -65, 68, 104, -120, 107, -109, -78, 118, -119, 113, -108, -91, -81, -5, 80, -25, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static int f2576 = 0;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private static int f2577 = 1;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean f2578 = false;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f2579 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f2580 = false;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2581 = 200;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f2582 = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0386(String str) {
        m2077(str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m2076(int i, int i2, byte b, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i + f2573;
        boolean z = !(i4 != -1);
        short[] sArr = null;
        if (z) {
            if (f2575 == null) {
                i4 = (short) (sArr[f2572 + i3] + f2573);
            } else {
                int i5 = f2577 + 87;
                f2576 = i5 % 128;
                i4 = (byte) ((!(i5 % 2 == 0) ? f2575[f2572 + i3] : f2575[f2572 + i3]) + f2573);
            }
        }
        if ((i4 > 0 ? '=' : (char) 24) != 24) {
            int i6 = ((i3 + i4) - 2) + f2572 + ((z ? 'Q' : 'V') == 'Q' ? 1 : 0);
            char c = (char) (i2 + f2574);
            sb.append(c);
            char c2 = c;
            int i7 = 1;
            while (true) {
                if ((i7 < i4 ? 'U' : ',') == ',') {
                    break;
                }
                int i8 = f2576 + 1;
                f2577 = i8 % 128;
                int i9 = i8 % 2;
                if ((f2575 != null ? 'B' : 'E') != 'B') {
                    c2 = (char) (c2 + (sArr[i6] ^ b));
                    i6--;
                } else {
                    c2 = (char) (c2 + (f2575[i6] ^ b));
                    i6--;
                }
                sb.append(c2);
                i7++;
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        if ((!r3) != true) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013b, code lost:
        if ((r10 >= 100 ? 'M' : 19) != 19) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cf  */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m2077(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢢ.ࢠ.ࢠ.ࢠ.C0386.m2077(java.lang.String):void");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m2078(JSONObject jSONObject) {
        try {
            if ((16 > Build.VERSION.SDK_INT ? ':' : '$') != '$') {
                int i = f2577 + 43;
                f2576 = i % 128;
                int i2 = i % 2;
                return true;
            }
            if (!(!jSONObject.has(m2076(-115, 1138247454, (byte) -93, -565428020).intern()))) {
                int i3 = f2576 + 71;
                f2577 = i3 % 128;
                JSONArray jSONArray = (i3 % 2 == 0 ? '`' : '8') != '`' ? jSONObject.getJSONArray(m2076(-115, 1138247454, (byte) -93, -565428020).intern()) : jSONObject.getJSONArray(m2076(-115, 1138247454, (byte) -93, -565428020).intern());
                int length = jSONArray.length();
                JSONArray jSONArray2 = jSONArray;
                int i4 = 0;
                while (true) {
                    if ((i4 < length ? ')' : (char) 24) == 24) {
                        break;
                    }
                    if (!(jSONArray2.getInt(i4) != Build.VERSION.SDK_INT)) {
                        int i5 = f2576 + 65;
                        f2577 = i5 % 128;
                        int i6 = i5 % 2;
                        return true;
                    }
                    i4++;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean m2079(JSONObject jSONObject) {
        String m1998;
        JSONArray jSONArray;
        try {
            if ((jSONObject.has(m2076(-115, 1138247440, (byte) -24, -565428019).intern()) ? (char) 14 : (char) 18) != 18) {
                int i = f2576 + 113;
                f2577 = i % 128;
                if (i % 2 == 0) {
                    m1998 = C0352.m1991().m1998();
                    jSONArray = jSONObject.getJSONArray(m2076(-115, 1138247440, (byte) -24, -565428019).intern());
                } else {
                    m1998 = C0352.m1991().m1998();
                    jSONArray = jSONObject.getJSONArray(m2076(-115, 1138247440, (byte) -24, -565428019).intern());
                }
                int length = jSONArray.length();
                JSONArray jSONArray2 = jSONArray;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if ((jSONArray2.getString(i2).contentEquals(m1998) ? (char) 23 : 'X') == 23) {
                        int i3 = f2577 + 71;
                        f2576 = i3 % 128;
                        if ((i3 % 2 != 0 ? (char) 4 : 'O') != 'O') {
                        }
                        return true;
                    }
                    i2++;
                }
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
        return false;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m2080(JSONObject jSONObject) {
        try {
            if ((jSONObject.has(m2076(-115, 1138247440, (byte) 1, -565428018).intern()) ? '8' : (char) 19) == '8') {
                int i = f2576 + 99;
                f2577 = i % 128;
                int i2 = i % 2;
                String m1998 = C0352.m1991().m1998();
                JSONArray jSONArray = jSONObject.getJSONArray(m2076(-115, 1138247440, (byte) 1, -565428018).intern());
                int length = jSONArray.length();
                int i3 = 0;
                while (true) {
                    if (!(i3 >= length)) {
                        int i4 = f2576 + 49;
                        f2577 = i4 % 128;
                        if ((i4 % 2 == 0 ? (char) 0 : 'X') == 0) {
                            if ((jSONArray.getString(i3).contentEquals(m1998) ? '>' : 'I') == '>') {
                                break;
                            }
                            i3++;
                        } else {
                            if ((jSONArray.getString(i3).contentEquals(m1998) ? (char) 11 : 'K') != 'K') {
                                break;
                            }
                            i3++;
                        }
                    } else {
                        break;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final boolean m2081() {
        return this.f2579;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final boolean m2082() {
        return this.f2580;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public final int m2083() {
        return this.f2581;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public final int m2084() {
        return this.f2582;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public final int m2085() {
        return this.f2578 ? C0355.EnumC0357.f2501 : C0355.EnumC0357.f2500;
    }
}
