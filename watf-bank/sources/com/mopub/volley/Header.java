package com.mopub.volley;

import android.text.TextUtils;
/* loaded from: assets/classes2.dex */
public final class Header {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f2114;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f2115;

    public Header(String str, String str2) {
        this.f2114 = str;
        this.f2115 = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.f2114, header.f2114) && TextUtils.equals(this.f2115, header.f2115);
    }

    public final String getName() {
        return this.f2114;
    }

    public final String getValue() {
        return this.f2115;
    }

    public int hashCode() {
        return (this.f2114.hashCode() * 31) + this.f2115.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f2114 + ",value=" + this.f2115 + "]";
    }
}
