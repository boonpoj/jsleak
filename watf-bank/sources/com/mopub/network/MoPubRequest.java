package com.mopub.network;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public abstract class MoPubRequest<T> extends Request<T> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f2051;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f2052;

    public MoPubRequest(@NonNull Context context, @NonNull String str, @Nullable Response.ErrorListener errorListener) {
        super(MoPubRequestUtils.chooseMethod(str), MoPubRequestUtils.truncateQueryParamsIfPost(str), errorListener);
        this.f2051 = str;
        this.f2052 = context.getApplicationContext();
    }

    @Override // com.mopub.volley.Request
    public byte[] getBody() {
        String generateBodyFromParams = MoPubRequestUtils.generateBodyFromParams(mo1475(), getUrl());
        if (generateBodyFromParams == null) {
            return null;
        }
        return generateBodyFromParams.getBytes();
    }

    @Override // com.mopub.volley.Request
    public String getBodyContentType() {
        return MoPubRequestUtils.isMoPubRequest(getUrl()) ? "application/json; charset=UTF-8" : super.getBodyContentType();
    }

    @Override // com.mopub.volley.Request
    public Map<String, String> getHeaders() {
        Locale locale;
        String trim;
        TreeMap treeMap = new TreeMap();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = this.f2052.getResources().getConfiguration().getLocales();
            locale = locales.size() > 0 ? locales.get(0) : null;
        } else {
            locale = this.f2052.getResources().getConfiguration().locale;
        }
        if (locale == null || TextUtils.isEmpty(locale.toString().trim())) {
            trim = Locale.getDefault().getLanguage().trim();
            locale = Locale.getDefault();
        } else {
            trim = locale.getLanguage().trim();
        }
        String trim2 = locale.getCountry().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (!TextUtils.isEmpty(trim2)) {
                trim = trim + "-" + trim2.toLowerCase();
            }
            treeMap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), trim);
        }
        return treeMap;
    }

    @NonNull
    public String getOriginalUrl() {
        return this.f2051;
    }

    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    protected Map<String, String> mo1475() {
        if (MoPubRequestUtils.isMoPubRequest(getUrl())) {
            return MoPubRequestUtils.convertQueryToMap(this.f2052, this.f2051);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m1599(@NonNull NetworkResponse networkResponse) {
        Preconditions.checkNotNull(networkResponse);
        try {
            return new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            return new String(networkResponse.data);
        }
    }
}
