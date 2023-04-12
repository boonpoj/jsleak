package com.mopub.nativeads;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class MediaViewBinder {

    /* renamed from: ࢠ  reason: contains not printable characters */
    final int f1590;

    /* renamed from: ࢢ  reason: contains not printable characters */
    final int f1591;

    /* renamed from: ࢣ  reason: contains not printable characters */
    final int f1592;

    /* renamed from: ࢤ  reason: contains not printable characters */
    final int f1593;

    /* renamed from: ࢥ  reason: contains not printable characters */
    final int f1594;

    /* renamed from: ࢦ  reason: contains not printable characters */
    final int f1595;

    /* renamed from: ࢧ  reason: contains not printable characters */
    final int f1596;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    final Map<String, Integer> f1597;

    /* loaded from: assets/classes2.dex */
    public static final class Builder {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final int f1598;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1599;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private int f1600;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private int f1601;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private int f1602;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private int f1603;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private int f1604;
        @NonNull

        /* renamed from: ࢨ  reason: contains not printable characters */
        private Map<String, Integer> f1605;

        public Builder(int i) {
            this.f1605 = Collections.emptyMap();
            this.f1598 = i;
            this.f1605 = new HashMap();
        }

        @NonNull
        public final Builder addExtra(String str, int i) {
            this.f1605.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f1605 = new HashMap(map);
            return this;
        }

        @NonNull
        public final MediaViewBinder build() {
            return new MediaViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i) {
            this.f1603 = i;
            return this;
        }

        @NonNull
        public final Builder iconImageId(int i) {
            this.f1602 = i;
            return this;
        }

        @NonNull
        public final Builder mediaLayoutId(int i) {
            this.f1599 = i;
            return this;
        }

        @NonNull
        public final Builder privacyInformationIconImageId(int i) {
            this.f1604 = i;
            return this;
        }

        @NonNull
        public final Builder textId(int i) {
            this.f1601 = i;
            return this;
        }

        @NonNull
        public final Builder titleId(int i) {
            this.f1600 = i;
            return this;
        }
    }

    private MediaViewBinder(@NonNull Builder builder) {
        this.f1590 = builder.f1598;
        this.f1591 = builder.f1599;
        this.f1592 = builder.f1600;
        this.f1593 = builder.f1601;
        this.f1594 = builder.f1603;
        this.f1595 = builder.f1602;
        this.f1596 = builder.f1604;
        this.f1597 = builder.f1605;
    }
}
