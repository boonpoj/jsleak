package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.graphics.Rect;
import android.location.Location;
import android.support.annotation.VisibleForTesting;
import android.util.DisplayMetrics;
import android.view.View;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.އ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0362 {

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static int f2511 = 0;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private static int f2512 = 1;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private JSONObject f2515;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Rect f2516;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Rect f2517;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private JSONObject f2518;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private JSONObject f2519;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private Location f2520;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private Map<String, Object> f2521 = new HashMap();

    /* renamed from: ࢠ  reason: contains not printable characters */
    String f2513 = "{}";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0365 f2514 = new C0365();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0363 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        final View f2522;

        /* renamed from: ࢢ  reason: contains not printable characters */
        final Rect f2523;

        C0363(View view, C0363 c0363) {
            this.f2522 = view;
            if (c0363 == null) {
                this.f2523 = C0362.m2025(view);
                return;
            }
            int i = c0363.f2523.left;
            int i2 = c0363.f2523.top;
            int left = i + view.getLeft();
            int top = i2 + view.getTop();
            this.f2523 = new Rect(left, top, view.getWidth() + left, view.getHeight() + top);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0364 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        int f2524 = 0;

        /* renamed from: ࢢ  reason: contains not printable characters */
        final Set<Rect> f2525 = new HashSet();

        /* renamed from: ࢣ  reason: contains not printable characters */
        boolean f2526 = false;

        C0364() {
        }
    }

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0365 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        Rect f2527 = new Rect(0, 0, 0, 0);

        /* renamed from: ࢢ  reason: contains not printable characters */
        double f2528 = 0.0d;

        /* renamed from: ࢣ  reason: contains not printable characters */
        double f2529 = 0.0d;

        C0365() {
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int m2017(Rect rect, Set<Rect> set) {
        if (set.isEmpty()) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.އ.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Rect rect2, Rect rect3) {
                return Integer.valueOf(rect2.top).compareTo(Integer.valueOf(rect3.top));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!(it.hasNext())) {
                break;
            }
            int i = f2511 + 59;
            f2512 = i % 128;
            if (i % 2 == 0) {
            }
            Rect rect2 = (Rect) it.next();
            arrayList2.add(Integer.valueOf(rect2.left));
            arrayList2.add(Integer.valueOf(rect2.right));
        }
        Collections.sort(arrayList2);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if ((i2 < arrayList2.size() - 1 ? '&' : 'U') == 'U') {
                return i3;
            }
            int i4 = i2 + 1;
            if (!(((Integer) arrayList2.get(i2)).equals(arrayList2.get(i4)))) {
                Rect rect3 = new Rect(((Integer) arrayList2.get(i2)).intValue(), rect.top, ((Integer) arrayList2.get(i4)).intValue(), rect.bottom);
                int i5 = rect.top;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if ((it2.hasNext() ? (char) 25 : '\t') != '\t') {
                        int i6 = f2512 + 23;
                        f2511 = i6 % 128;
                        int i7 = i6 % 2;
                        Rect rect4 = (Rect) it2.next();
                        if (Rect.intersects(rect4, rect3)) {
                            if ((rect4.bottom > i5 ? (char) 16 : 'A') == 16) {
                                i3 += rect3.width() * (rect4.bottom - Math.max(i5, rect4.top));
                                i5 = rect4.bottom;
                            }
                            if (rect4.bottom != rect3.bottom) {
                            }
                        }
                    }
                }
            }
            i2 = i4;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Rect m2018(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (!(f != 0.0f)) {
            return rect;
        }
        return new Rect(Math.round(rect.left / f), Math.round(rect.top / f), Math.round(rect.right / f), Math.round(rect.bottom / f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0149, code lost:
        com.ࢢ.ࢠ.ࢠ.ࢠ.C0379.m2046(r8, "VisibilityInfo", (java.lang.Object) null, "Short-circuiting cover retrieval, reached max");
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01ad, code lost:
        if ((r2.getZ() <= r4.getZ()) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x010a, code lost:
        if ((r4.getParent() instanceof android.view.ViewGroup ? 18 : 'S') != 'S') goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015d A[Catch: Exception -> 0x0203, TryCatch #0 {Exception -> 0x0203, blocks: (B:3:0x0005, B:4:0x000d, B:17:0x0037, B:41:0x0087, B:53:0x00a6, B:54:0x00b0, B:59:0x00bb, B:71:0x00e9, B:83:0x010c, B:95:0x0132, B:107:0x0152, B:112:0x015d, B:117:0x016a, B:129:0x018c, B:157:0x01da, B:135:0x019e, B:141:0x01b1, B:146:0x01bc, B:106:0x0149, B:101:0x013e, B:77:0x00fb, B:23:0x0043, B:34:0x0066, B:35:0x006e, B:40:0x0080), top: B:171:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f2  */
    @android.support.annotation.VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.C0364 m2020(android.graphics.Rect r17, @android.support.annotation.NonNull android.view.View r18) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.m2020(android.graphics.Rect, android.view.View):com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢢ");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Map<String, String> m2021(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put(AvidJSONUtil.KEY_X, String.valueOf(rect.left));
        hashMap.put(AvidJSONUtil.KEY_Y, String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
        if ((r9.getBackground() != null ? 'Y' : '0') != 'Y') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
        if ((r9.getBackground() != null ? '=' : 6) != 6) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
        if (r9.getBackground().getAlpha() != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        r3 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r3 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00af, code lost:
        if (r3 == 31) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b1, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d3, code lost:
        if ((r3) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00df, code lost:
        if ((r3 ? 'S' : '9') != '9') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e1, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0116 A[EDGE_INSN: B:133:0x0116->B:91:0x0116 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f8  */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m2022(com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.C0363 r13, android.graphics.Rect r14, com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.C0364 r15) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.m2022(com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢠ, android.graphics.Rect, com.ࢢ.ࢠ.ࢠ.ࢠ.އ$ࢢ):void");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m2023(View view, Rect rect) {
        if ((view.getGlobalVisibleRect(rect) ? 'Z' : (char) 1) != 'Z') {
            return false;
        }
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(iArr);
        int[] iArr2 = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr2);
        rect.offset(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        return true;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static float m2024(View view) {
        float alpha = view.getAlpha();
        while (true) {
            if ((view != null ? (char) 25 : 'E') == 25) {
                if (!(view.getParent() != null)) {
                    break;
                }
                if (!(((double) alpha) != 0.0d)) {
                    break;
                }
                if ((view.getParent() instanceof View ? (char) 27 : ']') != 27) {
                    break;
                }
                alpha *= ((View) view.getParent()).getAlpha();
                view = (View) view.getParent();
            } else {
                break;
            }
        }
        return alpha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static Rect m2025(View view) {
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0351, code lost:
        if ((r9.f2528 == r18.f2514.f2528 ? '&' : 'G') != 'G') goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x03ac, code lost:
        if (r10.equals(r18.f2517) == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0407, code lost:
        if ((r2.equals(r18.f2521)) != true) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
        if ((r6 != null ? '<' : '0') != '0') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
        if ((r20.getWindowToken() != null ? 'Z' : 20) != 'Z') goto L313;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014b A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0163 A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0213 A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0219 A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c5 A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02db A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03cb A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x043b A[Catch: Exception -> 0x04db, TryCatch #0 {Exception -> 0x04db, blocks: (B:8:0x001e, B:16:0x0037, B:27:0x0054, B:38:0x0075, B:40:0x0092, B:57:0x00bf, B:92:0x0123, B:112:0x014b, B:124:0x0163, B:126:0x0169, B:138:0x01ab, B:146:0x01cb, B:157:0x01ef, B:163:0x0213, B:165:0x021d, B:200:0x028a, B:212:0x02b4, B:217:0x02c5, B:218:0x02cd, B:224:0x02db, B:229:0x02ea, B:236:0x030d, B:238:0x0319, B:239:0x031c, B:206:0x02a2, B:240:0x0320, B:248:0x0337, B:256:0x0353, B:261:0x0364, B:266:0x0387, B:272:0x03a6, B:275:0x03c0, B:280:0x03cb, B:283:0x03e5, B:290:0x03fa, B:297:0x040c, B:304:0x042f, B:310:0x043b, B:327:0x04c7, B:329:0x04ce, B:321:0x0482, B:330:0x04d1, B:296:0x0409, B:282:0x03d3, B:274:0x03ae, B:251:0x0342, B:265:0x0371, B:164:0x0219, B:99:0x0133, B:63:0x00cd, B:75:0x00ef, B:33:0x0064, B:39:0x0086), top: B:338:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.util.HashSet, java.util.Set<android.graphics.Rect>] */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2026(java.lang.String r19, android.view.View r20) {
        /*
            Method dump skipped, instructions count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢢ.ࢠ.ࢠ.ࢠ.C0362.m2026(java.lang.String, android.view.View):void");
    }
}
