package com.mopub.common;

import android.os.Build;
import android.support.annotation.NonNull;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class AdReport implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AdResponse f255;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f256;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f257;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final String f258;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Locale f259;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final AdvertisingId f260;

    public AdReport(@NonNull String str, @NonNull ClientMetadata clientMetadata, @NonNull AdResponse adResponse) {
        this.f256 = str;
        this.f257 = clientMetadata.getSdkVersion();
        this.f258 = clientMetadata.getDeviceModel();
        this.f259 = clientMetadata.getDeviceLocale();
        this.f260 = clientMetadata.getMoPubIdentifier().getAdvertisingInfo();
        this.f255 = adResponse;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m326(long j) {
        if (j != -1) {
            return new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(new Date(j));
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m327(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        sb.append("\n");
    }

    public String getDspCreativeId() {
        return this.f255.getDspCreativeId();
    }

    public String getResponseString() {
        return this.f255.getStringBody();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m327(sb, "sdk_version", this.f257);
        m327(sb, "creative_id", this.f255.getDspCreativeId());
        m327(sb, "platform_version", Integer.toString(Build.VERSION.SDK_INT));
        m327(sb, "device_model", this.f258);
        m327(sb, "ad_unit_id", this.f256);
        m327(sb, "device_locale", this.f259 == null ? null : this.f259.toString());
        m327(sb, "device_id", this.f260.getIdentifier(MoPub.canCollectPersonalInformation()));
        m327(sb, "network_type", this.f255.getNetworkType());
        m327(sb, "platform", "android");
        m327(sb, AvidJSONUtil.KEY_TIMESTAMP, m326(this.f255.getTimestamp()));
        m327(sb, "ad_type", this.f255.getAdType());
        Object width = this.f255.getWidth();
        Object height = this.f255.getHeight();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (width == null) {
            width = "0";
        }
        sb2.append(width);
        sb2.append(", ");
        if (height == null) {
            height = "0";
        }
        sb2.append(height);
        sb2.append("}");
        m327(sb, "ad_size", sb2.toString());
        return sb.toString();
    }
}
