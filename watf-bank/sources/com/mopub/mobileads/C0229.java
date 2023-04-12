package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.network.TrackingRequest;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0229 extends AdLoader {

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f1226;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f1227;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0229(@NonNull String str, @NonNull AdFormat adFormat, @NonNull String str2, @NonNull Context context, @NonNull AdLoader.Listener listener) {
        super(str, adFormat, str2, context, listener);
        this.f1226 = false;
        this.f1227 = false;
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    List<String> m1041() {
        return this.f1970 != null ? this.f1970.getImpressionTrackingUrls() : Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1042(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (this.f1970 == null || this.f1226) {
            return;
        }
        this.f1226 = true;
        TrackingRequest.makeTrackingHttpRequest(m1041(), context);
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    String m1043() {
        if (this.f1970 != null) {
            return this.f1970.getClickTrackingUrl();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1044(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (this.f1970 == null || this.f1227) {
            return;
        }
        this.f1227 = true;
        TrackingRequest.makeTrackingHttpRequest(m1043(), context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public AdResponse m1045() {
        return this.f1970;
    }
}
