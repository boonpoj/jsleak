package com.mopub.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.util.MoPubCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class SdkConfiguration {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f411;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final List<Class<? extends MoPubAdvancedBidder>> f412;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MediationSettings[] f413;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final List<String> f414;

    /* loaded from: assets/classes2.dex */
    public static class Builder {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String f415;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final List<Class<? extends MoPubAdvancedBidder>> f416 = new ArrayList();
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private MediationSettings[] f417 = new MediationSettings[0];
        @Nullable

        /* renamed from: ࢤ  reason: contains not printable characters */
        private List<String> f418;

        public Builder(@NonNull String str) {
            this.f415 = str;
        }

        public SdkConfiguration build() {
            return new SdkConfiguration(this.f415, this.f416, this.f417, this.f418);
        }

        public Builder withAdvancedBidder(@NonNull Class<? extends MoPubAdvancedBidder> cls) {
            Preconditions.checkNotNull(cls);
            this.f416.add(cls);
            return this;
        }

        public Builder withAdvancedBidders(@NonNull Collection<Class<? extends MoPubAdvancedBidder>> collection) {
            Preconditions.NoThrow.checkNotNull(collection);
            MoPubCollections.addAllNonNull(this.f416, collection);
            return this;
        }

        public Builder withMediationSettings(@NonNull MediationSettings... mediationSettingsArr) {
            Preconditions.checkNotNull(mediationSettingsArr);
            this.f417 = mediationSettingsArr;
            return this;
        }

        public Builder withNetworksToInit(@Nullable List<String> list) {
            if (list == null) {
                return this;
            }
            this.f418 = new ArrayList();
            MoPubCollections.addAllNonNull(this.f418, list);
            return this;
        }
    }

    private SdkConfiguration(@NonNull String str, @NonNull List<Class<? extends MoPubAdvancedBidder>> list, @NonNull MediationSettings[] mediationSettingsArr, @Nullable List<String> list2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(list);
        this.f411 = str;
        this.f412 = list;
        this.f413 = mediationSettingsArr;
        this.f414 = list2;
    }

    @NonNull
    public String getAdUnitId() {
        return this.f411;
    }

    @NonNull
    public List<Class<? extends MoPubAdvancedBidder>> getAdvancedBidders() {
        return Collections.unmodifiableList(this.f412);
    }

    @NonNull
    public MediationSettings[] getMediationSettings() {
        return (MediationSettings[]) Arrays.copyOf(this.f413, this.f413.length);
    }

    @Nullable
    public List<String> getNetworksToInit() {
        if (this.f414 == null) {
            return null;
        }
        return Collections.unmodifiableList(this.f414);
    }
}
