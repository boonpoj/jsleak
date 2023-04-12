package com.mopub.nativeads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mopub.common.Preconditions;
import com.mopub.nativeads.AppLovinMediationNative;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class AppLovinAdRenderer implements MoPubAdRenderer<AppLovinMediationNative.C0257> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    final WeakHashMap<View, C0256> f1424 = new WeakHashMap<>();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AppLovinViewBinder f1425;

    /* loaded from: assets/classes2.dex */
    public static class AppLovinViewBinder {

        /* renamed from: ࢠ  reason: contains not printable characters */
        final Builder f1428;

        /* loaded from: assets/classes2.dex */
        public static class Builder {

            /* renamed from: ࢠ  reason: contains not printable characters */
            private final int f1429;

            /* renamed from: ࢢ  reason: contains not printable characters */
            private int f1430;

            /* renamed from: ࢣ  reason: contains not printable characters */
            private int f1431;

            /* renamed from: ࢤ  reason: contains not printable characters */
            private int f1432;

            /* renamed from: ࢥ  reason: contains not printable characters */
            private int f1433;

            /* renamed from: ࢦ  reason: contains not printable characters */
            private int f1434;

            /* renamed from: ࢧ  reason: contains not printable characters */
            private int f1435;
            @NonNull

            /* renamed from: ࢨ  reason: contains not printable characters */
            private Map<String, Integer> f1436;

            public Builder(int i) {
                this.f1436 = Collections.emptyMap();
                this.f1429 = i;
                this.f1436 = new HashMap();
            }

            @NonNull
            public final Builder addExtra(String str, int i) {
                this.f1436.put(str, Integer.valueOf(i));
                return this;
            }

            @NonNull
            public final Builder addExtras(Map<String, Integer> map) {
                this.f1436 = new HashMap(map);
                return this;
            }

            @NonNull
            public AppLovinViewBinder build() {
                return new AppLovinViewBinder(this);
            }

            @NonNull
            public final Builder callToActionId(int i) {
                this.f1434 = i;
                return this;
            }

            @NonNull
            public final Builder iconImageId(int i) {
                this.f1430 = i;
                return this;
            }

            @NonNull
            public final Builder mediaPlaceHolderId(int i) {
                this.f1435 = i;
                return this;
            }

            @NonNull
            public final Builder ratingImageId(int i) {
                this.f1431 = i;
                return this;
            }

            @NonNull
            public final Builder textId(int i) {
                this.f1433 = i;
                return this;
            }

            @NonNull
            public final Builder titleId(int i) {
                this.f1432 = i;
                return this;
            }
        }

        private AppLovinViewBinder(Builder builder) {
            this.f1428 = builder;
        }

        public int getCallToActionViewId() {
            return this.f1428.f1434;
        }

        public Map<String, Integer> getExtras() {
            return this.f1428.f1436;
        }

        public int getIconImgId() {
            return this.f1428.f1430;
        }

        public int getLayoutResourceId() {
            return this.f1428.f1429;
        }

        public int getMediaPlaceHolderId() {
            return this.f1428.f1435;
        }

        public int getRatingImgId() {
            return this.f1428.f1431;
        }

        public int getTextViewId() {
            return this.f1428.f1433;
        }

        public int getTitleViewId() {
            return this.f1428.f1432;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.nativeads.AppLovinAdRenderer$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0256 {
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        View f1437;
        @Nullable

        /* renamed from: ࢢ  reason: contains not printable characters */
        ImageView f1438;
        @Nullable

        /* renamed from: ࢣ  reason: contains not printable characters */
        ImageView f1439;
        @Nullable

        /* renamed from: ࢤ  reason: contains not printable characters */
        TextView f1440;
        @Nullable

        /* renamed from: ࢥ  reason: contains not printable characters */
        TextView f1441;
        @Nullable

        /* renamed from: ࢦ  reason: contains not printable characters */
        TextView f1442;
        @Nullable

        /* renamed from: ࢧ  reason: contains not printable characters */
        FrameLayout f1443;

        private C0256() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        static C0256 m1262(@NonNull View view, @NonNull AppLovinViewBinder appLovinViewBinder) {
            C0256 c0256 = new C0256();
            c0256.f1437 = view;
            try {
                c0256.f1438 = (ImageView) view.findViewById(appLovinViewBinder.getIconImgId());
                c0256.f1439 = (ImageView) view.findViewById(appLovinViewBinder.getRatingImgId());
                c0256.f1440 = (TextView) view.findViewById(appLovinViewBinder.getTitleViewId());
                c0256.f1441 = (TextView) view.findViewById(appLovinViewBinder.getTextViewId());
                c0256.f1442 = (TextView) view.findViewById(appLovinViewBinder.getCallToActionViewId());
                c0256.f1443 = (FrameLayout) view.findViewById(appLovinViewBinder.getMediaPlaceHolderId());
            } catch (Throwable unused) {
            }
            return c0256;
        }
    }

    public AppLovinAdRenderer(@NonNull AppLovinViewBinder appLovinViewBinder) {
        this.f1425 = null;
        this.f1425 = appLovinViewBinder;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1252(@NonNull C0256 c0256, int i) {
        if (c0256.f1437 != null) {
            c0256.f1437.setVisibility(i);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1253(@NonNull C0256 c0256, @NonNull final AppLovinMediationNative.C0257 c0257) {
        Context applicationContext = c0256.f1437.getContext().getApplicationContext();
        c0256.f1443.removeAllViews();
        c0256.f1443.addView(c0257.getMediaView());
        AppLovinSdkUtils.safePopulateImageView(c0256.f1438, Uri.parse(c0257.getIconImageUrl()), AppLovinSdkUtils.dpToPx(applicationContext, 50));
        c0256.f1439.setImageDrawable(c0257.getRatingImage());
        NativeRendererHelper.addTextView(c0256.f1440, c0257.getTitle());
        NativeRendererHelper.addTextView(c0256.f1441, c0257.getText());
        NativeRendererHelper.addTextView(c0256.f1442, c0257.getCta());
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(c0256.f1438);
        arrayList.add(c0256.f1440);
        arrayList.add(c0256.f1442);
        arrayList.add(c0256.f1443);
        for (View view : arrayList) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.AppLovinAdRenderer.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c0257.adIsClicked(view2);
                }
            });
        }
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    @NonNull
    public View createAdView(@NonNull Context context, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f1425.getLayoutResourceId(), viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(@NonNull View view, @NonNull AppLovinMediationNative.C0257 c0257) {
        C0256 c0256 = this.f1424.get(view);
        if (c0256 == null) {
            c0256 = C0256.m1262(view, this.f1425);
            this.f1424.put(view, c0256);
        }
        m1253(c0256, c0257);
        NativeRendererHelper.updateExtras(c0256.f1437, this.f1425.getExtras(), c0257.getExtras());
        m1252(c0256, 0);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof AppLovinMediationNative.C0257;
    }
}
