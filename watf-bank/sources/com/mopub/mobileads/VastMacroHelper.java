package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: assets/classes2.dex */
public class VastMacroHelper {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final List<String> f1003;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Map<EnumC0218, String> f1004;

    public VastMacroHelper(@NonNull List<String> list) {
        Preconditions.checkNotNull(list, "uris cannot be null");
        this.f1003 = list;
        this.f1004 = new HashMap();
        this.f1004.put(EnumC0218.CACHEBUSTING, m887());
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m887() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m888(int i) {
        long j = i;
        return String.format("%02d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Integer.valueOf(i % 1000));
    }

    @NonNull
    public List<String> getUris() {
        EnumC0218[] values;
        ArrayList arrayList = new ArrayList();
        for (String str : this.f1003) {
            if (!TextUtils.isEmpty(str)) {
                for (EnumC0218 enumC0218 : EnumC0218.values()) {
                    String str2 = this.f1004.get(enumC0218);
                    if (str2 == null) {
                        str2 = "";
                    }
                    str = str.replaceAll("\\[" + enumC0218.name() + "\\]", str2);
                }
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @NonNull
    public VastMacroHelper withAssetUri(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                MoPubLog.w("Failed to encode url", e);
            }
            this.f1004.put(EnumC0218.ASSETURI, str);
        }
        return this;
    }

    @NonNull
    public VastMacroHelper withContentPlayHead(@Nullable Integer num) {
        if (num != null) {
            String m888 = m888(num.intValue());
            if (!TextUtils.isEmpty(m888)) {
                this.f1004.put(EnumC0218.CONTENTPLAYHEAD, m888);
            }
        }
        return this;
    }

    @NonNull
    public VastMacroHelper withErrorCode(@Nullable VastErrorCode vastErrorCode) {
        if (vastErrorCode != null) {
            this.f1004.put(EnumC0218.ERRORCODE, vastErrorCode.m873());
        }
        return this;
    }
}
