package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class HeaderUtils {
    public static boolean extractBooleanHeader(JSONObject jSONObject, ResponseHeader responseHeader, boolean z) {
        return m1596(extractHeader(jSONObject, responseHeader), z);
    }

    @NonNull
    public static String extractHeader(@Nullable JSONObject jSONObject, @NonNull ResponseHeader responseHeader) {
        Preconditions.checkNotNull(responseHeader);
        return jSONObject == null ? "" : jSONObject.optString(responseHeader.getKey());
    }

    @Nullable
    public static Integer extractIntegerHeader(JSONObject jSONObject, ResponseHeader responseHeader) {
        return m1594(extractHeader(jSONObject, responseHeader));
    }

    @Nullable
    public static Integer extractPercentHeader(JSONObject jSONObject, ResponseHeader responseHeader) {
        return m1597(extractHeader(jSONObject, responseHeader));
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Integer m1594(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception unused) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
            numberFormat.setParseIntegerOnly(true);
            try {
                return Integer.valueOf(numberFormat.parse(str.trim()).intValue());
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static List<String> m1595(@NonNull JSONObject jSONObject, @NonNull ResponseHeader responseHeader) {
        Preconditions.checkNotNull(jSONObject);
        Preconditions.checkNotNull(responseHeader);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(responseHeader.getKey());
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                arrayList.add(optJSONArray.getString(i));
            } catch (JSONException unused) {
                MoPubLog.d("Unable to parse item " + i + " from " + responseHeader.getKey());
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m1596(@Nullable String str, boolean z) {
        return str == null ? z : str.equals("1");
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Integer m1597(@Nullable String str) {
        Integer m1594;
        if (str != null && (m1594 = m1594(str.replace("%", ""))) != null && m1594.intValue() >= 0 && m1594.intValue() <= 100) {
            return m1594;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m1598(JSONObject jSONObject, ResponseHeader responseHeader) {
        Integer extractPercentHeader = extractPercentHeader(jSONObject, responseHeader);
        if (extractPercentHeader != null) {
            return extractPercentHeader.toString();
        }
        return null;
    }
}
