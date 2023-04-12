package com.google.android.gms.internal;

import android.text.TextUtils;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzl {
    private final String mName;
    private final String mValue;

    public zzl(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzl zzlVar = (zzl) obj;
            if (TextUtils.equals(this.mName, zzlVar.mName) && TextUtils.equals(this.mValue, zzlVar.mValue)) {
                return true;
            }
        }
        return false;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public final String toString() {
        String str = this.mName;
        String str2 = this.mValue;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
