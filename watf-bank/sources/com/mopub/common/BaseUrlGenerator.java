package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.mopub.network.Networking;
import com.mopub.network.PlayServicesUrlRewriter;
/* loaded from: assets/classes2.dex */
public abstract class BaseUrlGenerator {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private StringBuilder f272;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f273;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m358() {
        if (this.f273) {
            this.f273 = false;
            return "?";
        }
        return "&";
    }

    public abstract String generateUrlString(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ֏  reason: contains not printable characters */
    public void m359(String str) {
        m365("v", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ؠ  reason: contains not printable characters */
    public void m360(String str) {
        m365("av", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m361(@NonNull Point point) {
        m365("w", "" + point.x);
        m365("h", "" + point.y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m362(String str, Boolean bool) {
        if (bool == null) {
            return;
        }
        this.f272.append(m358());
        this.f272.append(str);
        this.f272.append("=");
        this.f272.append(bool.booleanValue() ? "1" : "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m363(String str, String str2) {
        StringBuilder sb = new StringBuilder(Networking.getScheme());
        sb.append("://");
        sb.append(str);
        sb.append(str2);
        this.f272 = sb;
        this.f273 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m364(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr == null || strArr.length < 1) {
            return;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            sb.append(strArr[i]);
            sb.append(",");
        }
        sb.append(strArr[strArr.length - 1]);
        m365("dn", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m365(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f272.append(m358());
        this.f272.append(str);
        this.f272.append("=");
        this.f272.append(Uri.encode(str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m366(boolean z) {
        m365("android_perms_ext_storage", z ? "1" : "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public String m367() {
        return this.f272.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m368() {
        m365("udid", PlayServicesUrlRewriter.UDID_TEMPLATE);
        m365("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
    }
}
