package com.mopub.common.util;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: assets/classes2.dex */
public class Json {
    public static <T> T getJsonValue(JSONObject jSONObject, String str, Class<T> cls) {
        StringBuilder sb;
        String str2;
        if (jSONObject == null || str == null || cls == null) {
            throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
        }
        Object opt = jSONObject.opt(str);
        if (opt == null) {
            sb = new StringBuilder();
            sb.append("Tried to get Json value with key: ");
            sb.append(str);
            str2 = ", but it was null";
        } else if (cls.isInstance(opt)) {
            return cls.cast(opt);
        } else {
            sb = new StringBuilder();
            sb.append("Tried to get Json value with key: ");
            sb.append(str);
            sb.append(", of type: ");
            sb.append(cls.toString());
            str2 = ", its type did not match";
        }
        sb.append(str2);
        MoPubLog.w(sb.toString());
        return null;
    }

    public static String[] jsonArrayToStringArray(String str) {
        try {
            JSONArray jSONArray = ((JSONObject) new JSONTokener("{key:" + str + "}").nextValue()).getJSONArray("key");
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            return strArr;
        } catch (JSONException unused) {
            return new String[0];
        }
    }

    public static Map<String, String> jsonStringToMap(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }

    public static String mapToJsonString(Map<String, String> map) {
        if (map == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(entry.getKey());
            sb.append("\":\"");
            sb.append(entry.getValue());
            sb.append("\"");
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
