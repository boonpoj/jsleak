package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
/* renamed from: com.mopub.nativeads.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0278 {
    @VisibleForTesting

    /* renamed from: ࢨ  reason: contains not printable characters */
    static final C0278 f1908 = new C0278();
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    View f1909;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    MediaLayout f1910;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    TextView f1911;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    TextView f1912;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    ImageView f1913;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    TextView f1914;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    ImageView f1915;

    private C0278() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0278 m1497(@NonNull View view, @NonNull MediaViewBinder mediaViewBinder) {
        C0278 c0278 = new C0278();
        c0278.f1909 = view;
        try {
            c0278.f1911 = (TextView) view.findViewById(mediaViewBinder.f1592);
            c0278.f1912 = (TextView) view.findViewById(mediaViewBinder.f1593);
            c0278.f1914 = (TextView) view.findViewById(mediaViewBinder.f1594);
            c0278.f1910 = (MediaLayout) view.findViewById(mediaViewBinder.f1591);
            c0278.f1913 = (ImageView) view.findViewById(mediaViewBinder.f1595);
            c0278.f1915 = (ImageView) view.findViewById(mediaViewBinder.f1596);
            return c0278;
        } catch (ClassCastException e) {
            MoPubLog.w("Could not cast from id in MediaViewBinder to expected View type", e);
            return f1908;
        }
    }
}
