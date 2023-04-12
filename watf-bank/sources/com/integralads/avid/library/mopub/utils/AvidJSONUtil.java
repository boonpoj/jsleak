package com.integralads.avid.library.mopub.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidJSONUtil {
    public static final String KEY_CHILD_VIEWS = "childViews";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_FRIENDLY_OBSTRUCTION_FOR = "isFriendlyObstructionFor";
    public static final String KEY_ROOT_VIEW = "rootView";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static String[] f97 = {KEY_X, KEY_Y, "width", "height"};

    /* renamed from: ࢠ  reason: contains not printable characters */
    static float f96 = Resources.getSystem().getDisplayMetrics().density;

    public static void addAvidId(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("id", str);
        } catch (JSONException e) {
            AvidLogs.e("Error with setting avid id", e);
        }
    }

    public static void addChildState(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put(KEY_CHILD_VIEWS, optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addFriendlyObstruction(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put(KEY_IS_FRIENDLY_OBSTRUCTION_FOR, jSONArray);
        } catch (JSONException e) {
            AvidLogs.e("Error with setting friendly obstruction", e);
        }
    }

    public static boolean equalStates(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        return jSONObject2 != null && m66(jSONObject, jSONObject2) && m67(jSONObject, jSONObject2) && m68(jSONObject, jSONObject2) && m69(jSONObject, jSONObject2);
    }

    public static void fixStateFrame(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt(KEY_X);
                int optInt2 = optJSONObject.optInt(KEY_Y);
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

    public static JSONObject getEmptyTreeJSONObject() {
        return getTreeJSONObject(getViewState(0, 0, 0, 0), AvidTimestamp.getCurrentTime());
    }

    public static JSONObject getTreeJSONObject(JSONObject jSONObject, double d) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(KEY_TIMESTAMP, d);
            jSONObject2.put(KEY_ROOT_VIEW, jSONObject);
        } catch (JSONException e) {
            AvidLogs.e("Error with creating treeJSONObject", e);
        }
        return jSONObject2;
    }

    public static JSONObject getViewState(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_X, m64(i));
            jSONObject.put(KEY_Y, m64(i2));
            jSONObject.put("width", m64(i3));
            jSONObject.put("height", m64(i4));
        } catch (JSONException e) {
            AvidLogs.e("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void init(Context context) {
        if (context != null) {
            f96 = context.getResources().getDisplayMetrics().density;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static float m64(int i) {
        return i / f96;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m65(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray != null || jSONArray2 == null) && (jSONArray == null || jSONArray2 != null) && jSONArray.length() == jSONArray2.length();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m66(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f97) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean m67(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("id", "").equals(jSONObject2.optString("id", ""));
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m68(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_IS_FRIENDLY_OBSTRUCTION_FOR);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(KEY_IS_FRIENDLY_OBSTRUCTION_FOR);
        if (m65(optJSONArray, optJSONArray2)) {
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

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static boolean m69(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(KEY_CHILD_VIEWS);
        if (m65(optJSONArray, optJSONArray2)) {
            if (optJSONArray == null) {
                return true;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!equalStates(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
