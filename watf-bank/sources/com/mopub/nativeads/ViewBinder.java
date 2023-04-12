package com.mopub.nativeads;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class ViewBinder {

    /* renamed from: ࢠ  reason: contains not printable characters */
    final int f1880;

    /* renamed from: ࢢ  reason: contains not printable characters */
    final int f1881;

    /* renamed from: ࢣ  reason: contains not printable characters */
    final int f1882;

    /* renamed from: ࢤ  reason: contains not printable characters */
    final int f1883;

    /* renamed from: ࢥ  reason: contains not printable characters */
    final int f1884;

    /* renamed from: ࢦ  reason: contains not printable characters */
    final int f1885;

    /* renamed from: ࢧ  reason: contains not printable characters */
    final int f1886;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    final Map<String, Integer> f1887;

    /* loaded from: assets/classes2.dex */
    public static final class Builder {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final int f1888;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1889;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private int f1890;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private int f1891;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private int f1892;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private int f1893;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private int f1894;
        @NonNull

        /* renamed from: ࢨ  reason: contains not printable characters */
        private Map<String, Integer> f1895;

        public Builder(int i) {
            this.f1895 = Collections.emptyMap();
            this.f1888 = i;
            this.f1895 = new HashMap();
        }

        @NonNull
        public final Builder addExtra(String str, int i) {
            this.f1895.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f1895 = new HashMap(map);
            return this;
        }

        @NonNull
        public final ViewBinder build() {
            return new ViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i) {
            this.f1891 = i;
            return this;
        }

        @NonNull
        public final Builder iconImageId(int i) {
            this.f1893 = i;
            return this;
        }

        @NonNull
        public final Builder mainImageId(int i) {
            this.f1892 = i;
            return this;
        }

        @NonNull
        public final Builder privacyInformationIconImageId(int i) {
            this.f1894 = i;
            return this;
        }

        @NonNull
        public final Builder textId(int i) {
            this.f1890 = i;
            return this;
        }

        @NonNull
        public final Builder titleId(int i) {
            this.f1889 = i;
            return this;
        }
    }

    private ViewBinder(@NonNull Builder builder) {
        this.f1880 = builder.f1888;
        this.f1881 = builder.f1889;
        this.f1882 = builder.f1890;
        this.f1883 = builder.f1891;
        this.f1884 = builder.f1892;
        this.f1885 = builder.f1893;
        this.f1886 = builder.f1894;
        this.f1887 = builder.f1895;
    }
}
