package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0288 {
    @VisibleForTesting

    /* renamed from: ࢨ  reason: contains not printable characters */
    static final C0288 f1959 = new C0288();
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    View f1960;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    TextView f1961;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    TextView f1962;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    TextView f1963;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    ImageView f1964;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    ImageView f1965;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    ImageView f1966;

    private C0288() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0288 m1552(@NonNull View view, @NonNull ViewBinder viewBinder) {
        C0288 c0288 = new C0288();
        c0288.f1960 = view;
        try {
            c0288.f1961 = (TextView) view.findViewById(viewBinder.f1881);
            c0288.f1962 = (TextView) view.findViewById(viewBinder.f1882);
            c0288.f1963 = (TextView) view.findViewById(viewBinder.f1883);
            c0288.f1964 = (ImageView) view.findViewById(viewBinder.f1884);
            c0288.f1965 = (ImageView) view.findViewById(viewBinder.f1885);
            c0288.f1966 = (ImageView) view.findViewById(viewBinder.f1886);
            return c0288;
        } catch (ClassCastException e) {
            MoPubLog.w("Could not cast from id in ViewBinder to expected View type", e);
            return f1959;
        }
    }
}
