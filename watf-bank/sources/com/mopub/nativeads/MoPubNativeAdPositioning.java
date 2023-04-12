package com.mopub.nativeads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/classes2.dex */
public final class MoPubNativeAdPositioning {

    /* loaded from: assets/classes2.dex */
    public static class MoPubClientPositioning {
        public static final int NO_REPEAT = Integer.MAX_VALUE;
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final ArrayList<Integer> f1695 = new ArrayList<>();

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1696 = Integer.MAX_VALUE;

        @NonNull
        public MoPubClientPositioning addFixedPosition(int i) {
            int binarySearch;
            if (Preconditions.NoThrow.checkArgument(i >= 0) && (binarySearch = Collections.binarySearch(this.f1695, Integer.valueOf(i))) < 0) {
                this.f1695.add(binarySearch ^ (-1), Integer.valueOf(i));
            }
            return this;
        }

        @NonNull
        public MoPubClientPositioning enableRepeatingPositions(int i) {
            if (Preconditions.NoThrow.checkArgument(i > 1, "Repeating interval must be greater than 1")) {
                this.f1696 = i;
                return this;
            }
            this.f1696 = Integer.MAX_VALUE;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        /* renamed from: ࢠ  reason: contains not printable characters */
        public List<Integer> m1409() {
            return this.f1695;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢢ  reason: contains not printable characters */
        public int m1410() {
            return this.f1696;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class MoPubServerPositioning {
    }

    @NonNull
    public static MoPubClientPositioning clientPositioning() {
        return new MoPubClientPositioning();
    }

    @NonNull
    public static MoPubServerPositioning serverPositioning() {
        return new MoPubServerPositioning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static MoPubClientPositioning m1405(@NonNull MoPubClientPositioning moPubClientPositioning) {
        Preconditions.checkNotNull(moPubClientPositioning);
        MoPubClientPositioning moPubClientPositioning2 = new MoPubClientPositioning();
        moPubClientPositioning2.f1695.addAll(moPubClientPositioning.f1695);
        moPubClientPositioning2.f1696 = moPubClientPositioning.f1696;
        return moPubClientPositioning2;
    }
}
