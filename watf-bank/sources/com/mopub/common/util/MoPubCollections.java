package com.mopub.common.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.util.Collection;
import java.util.Collections;
/* loaded from: assets/classes2.dex */
public class MoPubCollections {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void addAllNonNull(@NonNull Collection<? super T> collection, @NonNull Collection<T> collection2) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(collection2);
        collection.addAll(collection2);
        collection.removeAll(Collections.singleton(null));
    }

    public static <T> void addAllNonNull(@NonNull Collection<? super T> collection, @Nullable T... tArr) {
        Collections.addAll(collection, tArr);
        collection.removeAll(Collections.singleton(null));
    }
}
