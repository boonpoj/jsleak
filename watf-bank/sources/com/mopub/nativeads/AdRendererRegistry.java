package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: assets/classes2.dex */
public class AdRendererRegistry {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final ArrayList<MoPubAdRenderer> f1419 = new ArrayList<>();

    public int getAdRendererCount() {
        return this.f1419.size();
    }

    @Nullable
    public MoPubAdRenderer getRendererForAd(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        Iterator<MoPubAdRenderer> it = this.f1419.iterator();
        while (it.hasNext()) {
            MoPubAdRenderer next = it.next();
            if (next.supports(baseNativeAd)) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public MoPubAdRenderer getRendererForViewType(int i) {
        try {
            return this.f1419.get(i - 1);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @NonNull
    public Iterable<MoPubAdRenderer> getRendererIterable() {
        return this.f1419;
    }

    public int getViewTypeForAd(@NonNull NativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        for (int i = 0; i < this.f1419.size(); i++) {
            if (nativeAd.getMoPubAdRenderer() == this.f1419.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        this.f1419.add(moPubAdRenderer);
    }
}
