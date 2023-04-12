package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mopub.nativeads.FlurryCustomEventNative;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class FlurryNativeAdRenderer implements MoPubAdRenderer<FlurryCustomEventNative.C0261> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final FlurryViewBinder f1532;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WeakHashMap<View, C0262> f1533 = new WeakHashMap<>();

    /* loaded from: assets/classes2.dex */
    public static class FlurryViewBinder {

        /* renamed from: ࢠ  reason: contains not printable characters */
        ViewBinder f1534;

        /* renamed from: ࢢ  reason: contains not printable characters */
        int f1535;

        /* renamed from: ࢣ  reason: contains not printable characters */
        int f1536;

        /* loaded from: assets/classes2.dex */
        public static final class Builder {

            /* renamed from: ࢠ  reason: contains not printable characters */
            ViewBinder f1537;

            /* renamed from: ࢢ  reason: contains not printable characters */
            int f1538;

            /* renamed from: ࢣ  reason: contains not printable characters */
            int f1539;

            public Builder(ViewBinder viewBinder) {
                this.f1537 = viewBinder;
            }

            @NonNull
            public final Builder advertiserNameViewId(int i) {
                this.f1539 = i;
                return this;
            }

            @NonNull
            public final FlurryViewBinder build() {
                return new FlurryViewBinder(this);
            }

            @NonNull
            public final Builder videoViewId(int i) {
                this.f1538 = i;
                return this;
            }
        }

        private FlurryViewBinder(@NonNull Builder builder) {
            this.f1534 = builder.f1537;
            this.f1536 = builder.f1538;
            this.f1535 = builder.f1539;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.nativeads.FlurryNativeAdRenderer$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0262 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final C0288 f1540;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final ViewGroup f1541;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final TextView f1542;

        private C0262(C0288 c0288, ViewGroup viewGroup, TextView textView) {
            this.f1540 = c0288;
            this.f1541 = viewGroup;
            this.f1542 = textView;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        static C0262 m1315(View view, FlurryViewBinder flurryViewBinder) {
            return new C0262(C0288.m1552(view, flurryViewBinder.f1534), (ViewGroup) view.findViewById(flurryViewBinder.f1536), (TextView) view.findViewById(flurryViewBinder.f1535));
        }
    }

    public FlurryNativeAdRenderer(@NonNull FlurryViewBinder flurryViewBinder) {
        this.f1532 = flurryViewBinder;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1313(@NonNull C0262 c0262, int i) {
        if (c0262.f1540.f1960 != null) {
            c0262.f1540.f1960.setVisibility(i);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1314(C0262 c0262, FlurryCustomEventNative.C0261 c0261) {
        NativeImageHelper.loadImageView(c0261.getIconImageUrl(), c0262.f1540.f1965);
        NativeRendererHelper.addTextView(c0262.f1540.f1963, c0261.getCallToAction());
        NativeRendererHelper.addTextView(c0262.f1540.f1961, c0261.getTitle());
        NativeImageHelper.loadImageView(c0261.getSponsoredMarkerImageUrl(), c0262.f1540.f1966);
        NativeRendererHelper.addTextView(c0262.f1542, c0261.getAdvertiserName());
        if (c0261.m1312()) {
            if (c0262.f1541 != null) {
                c0262.f1541.setVisibility(0);
                c0261.m1311(c0262.f1541);
            }
            if (c0262.f1540.f1964 != null) {
                c0262.f1540.f1964.setVisibility(8);
                return;
            }
            return;
        }
        if (c0262.f1541 != null) {
            c0262.f1541.setVisibility(8);
        }
        if (c0262.f1540.f1964 != null) {
            c0262.f1540.f1964.setVisibility(0);
            NativeImageHelper.loadImageView(c0261.getMainImageUrl(), c0262.f1540.f1964);
        }
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    @NonNull
    public View createAdView(@NonNull Context context, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f1532.f1534.f1880, viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(@NonNull View view, @NonNull FlurryCustomEventNative.C0261 c0261) {
        C0262 c0262 = this.f1533.get(view);
        if (c0262 == null) {
            c0262 = C0262.m1315(view, this.f1532);
            this.f1533.put(view, c0262);
        }
        m1314(c0262, c0261);
        NativeRendererHelper.updateExtras(c0262.f1540.f1960, this.f1532.f1534.f1887, c0261.getExtras());
        m1313(c0262, 0);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        return baseNativeAd instanceof FlurryCustomEventNative.C0261;
    }
}
