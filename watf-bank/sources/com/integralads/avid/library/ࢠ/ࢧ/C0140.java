package com.integralads.avid.library.ࢠ.ࢧ;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0140 {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static String[] f227 = {AvidJSONUtil.KEY_X, AvidJSONUtil.KEY_Y, "width", "height"};

    /* renamed from: ࢠ  reason: contains not printable characters */
    static float f226 = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: ࢠ  reason: contains not printable characters */
    static float m261(int i) {
        return i / f226;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static JSONObject m262() {
        return m264(m263(0, 0, 0, 0), C0142.m278());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static JSONObject m263(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AvidJSONUtil.KEY_X, m261(i));
            jSONObject.put(AvidJSONUtil.KEY_Y, m261(i2));
            jSONObject.put("width", m261(i3));
            jSONObject.put("height", m261(i4));
        } catch (JSONException e) {
            C0141.m277("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static JSONObject m264(JSONObject jSONObject, double d) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(AvidJSONUtil.KEY_TIMESTAMP, d);
            jSONObject2.put(AvidJSONUtil.KEY_ROOT_VIEW, jSONObject);
        } catch (JSONException e) {
            C0141.m277("Error with creating treeJSONObject", e);
        }
        return jSONObject2;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m265(Context context) {
        if (context != null) {
            f226 = context.getResources().getDisplayMetrics().density;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m266(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(AvidJSONUtil.KEY_CHILD_VIEWS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt(AvidJSONUtil.KEY_X);
                int optInt2 = optJSONObject.optInt(AvidJSONUtil.KEY_Y);
                int optInt3 = optJSONObject.optInt("width");
                int optInt4 = optJSONObject.optInt("height");
                i = Math.max(i, optInt + optInt3);
                i2 = Math.max(i2, optInt2 + optInt4);
            }
        }
        try {
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m267(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("id", str);
        } catch (JSONException e) {
            C0141.m277("Error with setting avid id", e);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m268(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put(AvidJSONUtil.KEY_IS_FRIENDLY_OBSTRUCTION_FOR, jSONArray);
        } catch (JSONException e) {
            C0141.m277("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m269(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(AvidJSONUtil.KEY_CHILD_VIEWS);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put(AvidJSONUtil.KEY_CHILD_VIEWS, optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m270(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray != null || jSONArray2 == null) && (jSONArray == null || jSONArray2 != null) && jSONArray.length() == jSONArray2.length();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static boolean m271(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        return jSONObject2 != null && m272(jSONObject, jSONObject2) && m273(jSONObject, jSONObject2) && m274(jSONObject, jSONObject2) && m275(jSONObject, jSONObject2);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m272(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f227) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static boolean m273(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("id", "").equals(jSONObject2.optString("id", ""));
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static boolean m274(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray(AvidJSONUtil.KEY_IS_FRIENDLY_OBSTRUCTION_FOR);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(AvidJSONUtil.KEY_IS_FRIENDLY_OBSTRUCTION_FOR);
        if (m270(optJSONArray, optJSONArray2)) {
            if (optJSONArray == null) {
                return true;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static boolean m275(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray(AvidJSONUtil.KEY_CHILD_VIEWS);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(AvidJSONUtil.KEY_CHILD_VIEWS);
        if (m270(optJSONArray, optJSONArray2)) {
            if (optJSONArray == null) {
                return true;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!m271(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
