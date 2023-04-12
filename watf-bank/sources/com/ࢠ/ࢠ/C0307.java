package com.ࢠ.ࢠ;

import android.text.TextUtils;
import com.ࢠ.ࢠ.C0333;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.ࢠ.ࢠ.ނ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0307 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static List<C0333.C0335> f2269 = new ArrayList();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static List<C0333.C0335> f2270 = null;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static long f2271 = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final boolean m1756() {
        return C0328.m1838().m1841(C0309.m1774("r8oqpZ8WJ29HpfzDAKJW/k9CTwHeSAvZZPSzN30arZI"), false).booleanValue();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static List<C0333.C0335> m1757() {
        List<C0333.C0335> m1759 = m1759();
        return (m1759 == null || m1759.isEmpty()) ? f2269 : m1759;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1758(ࢤ r1, ࢧ r2, ࢦ r3, int i, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        C0333.C0335 c0335 = new C0333.C0335();
        c0335.f2366 = r1;
        c0335.f2368 = r2;
        c0335.f2370 = r3;
        c0335.f2369 = strArr;
        c0335.f2367 = i;
        f2269.add(c0335);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static List<C0333.C0335> m1759() {
        ࢤ[] r1;
        C0333.C0335 c0335;
        String[] strArr;
        C0333.C0335 c03352;
        String[] strArr2;
        if (System.currentTimeMillis() - f2271 < 3600000) {
            return f2270;
        }
        f2271 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ࢤ r5 : new ࢤ[]{ࢤ.ࢠ, ࢤ.ࢢ, ࢤ.ࢥ}) {
            try {
                JSONArray jSONArray = new JSONArray(C0328.m1838().m1843(C0309.m1774("N1sCJCO5F59k+Hb4cQKvKA") + "_" + C0309.m1774(r5.toString())));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ࢧ r9 = ࢧ.ࢠ(jSONObject.optString(C0309.m1774("VelBMveE3NyXR2WO3u5cow"), null));
                    ࢦ r11 = ࢦ.ࢠ(jSONObject.optString(C0309.m1774("Tg8bUrOe9jIri9Dv+HFUdA"), null));
                    int optInt = jSONObject.optInt("priority", 0);
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("ids");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2, null);
                            if (!TextUtils.isEmpty(optString)) {
                                arrayList2.add(optString);
                            }
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        if (r11 != null) {
                            c0335 = new C0333.C0335();
                            c0335.f2366 = r5;
                            c0335.f2368 = r9;
                            c0335.f2370 = r11;
                            c0335.f2367 = optInt;
                            strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                        } else if (ࢤ.ࢠ.equals(r5)) {
                            if (ࢧ.ࢠ.equals(r9) || ࢧ.ࢣ.equals(r9)) {
                                C0333.C0335 c03353 = new C0333.C0335();
                                c03353.f2366 = r5;
                                c03353.f2368 = r9;
                                c03353.f2370 = ࢦ.ࢠ;
                                c03353.f2367 = optInt;
                                c03353.f2369 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                                arrayList.add(c03353);
                                c03352 = new C0333.C0335();
                                c03352.f2366 = r5;
                                c03352.f2368 = r9;
                                c03352.f2370 = ࢦ.ࢢ;
                                c03352.f2367 = optInt;
                                strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                                c03352.f2369 = strArr2;
                                arrayList.add(c03352);
                            }
                            if (!ࢧ.ࢢ.equals(r9) || ࢧ.ࢤ.equals(r9)) {
                                c0335 = new C0333.C0335();
                                c0335.f2366 = r5;
                                c0335.f2368 = r9;
                                c0335.f2370 = ࢦ.ࢣ;
                                c0335.f2367 = optInt;
                                strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                            }
                        } else {
                            if (ࢤ.ࢥ.equals(r5) && ࢧ.ࢣ.equals(r9)) {
                                C0333.C0335 c03354 = new C0333.C0335();
                                c03354.f2366 = r5;
                                c03354.f2368 = r9;
                                c03354.f2370 = ࢦ.ࢠ;
                                c03354.f2367 = optInt;
                                c03354.f2369 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                                arrayList.add(c03354);
                                c03352 = new C0333.C0335();
                                c03352.f2366 = r5;
                                c03352.f2368 = r9;
                                c03352.f2370 = ࢦ.ࢢ;
                                c03352.f2367 = optInt;
                                strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                                c03352.f2369 = strArr2;
                                arrayList.add(c03352);
                            }
                            if (!ࢧ.ࢢ.equals(r9)) {
                            }
                            c0335 = new C0333.C0335();
                            c0335.f2366 = r5;
                            c0335.f2368 = r9;
                            c0335.f2370 = ࢦ.ࢣ;
                            c0335.f2367 = optInt;
                            strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                        }
                        c0335.f2369 = strArr;
                        arrayList.add(c0335);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        f2270 = arrayList;
        return f2270;
    }
}
