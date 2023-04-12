package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Numbers;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.NativeImageHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MoPubCustomEventNative extends CustomEventNative {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0264 f1620;

    /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0264 extends StaticNativeAd {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Context f1622;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final CustomEventNative.CustomEventNativeListener f1623;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final JSONObject f1624;
        @NonNull

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final ImpressionTracker f1625;
        @NonNull

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final NativeClickHandler f1626;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$ࢠ$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public enum EnumC0265 {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT("text", false),
            MAIN_IMAGE("mainimage", false),
            ICON_IMAGE("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            STAR_RATING("starrating", false),
            PRIVACY_INFORMATION_ICON_IMAGE_URL("privacyicon", false),
            PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL("privacyclkurl", false);
            
            @NonNull
            @VisibleForTesting

            /* renamed from: ࢣ  reason: contains not printable characters */
            static final Set<String> f1628 = new HashSet();
            @NonNull

            /* renamed from: ࢠ  reason: contains not printable characters */
            final String f1630;

            /* renamed from: ࢢ  reason: contains not printable characters */
            final boolean f1631;

            static {
                EnumC0265[] values;
                for (EnumC0265 enumC0265 : values()) {
                    if (enumC0265.f1631) {
                        f1628.add(enumC0265.f1630);
                    }
                }
            }

            EnumC0265(String str, boolean z) {
                this.f1630 = str;
                this.f1631 = z;
            }

            @Nullable
            /* renamed from: ࢠ  reason: contains not printable characters */
            static EnumC0265 m1355(@NonNull String str) {
                EnumC0265[] values;
                for (EnumC0265 enumC0265 : values()) {
                    if (enumC0265.f1630.equals(str)) {
                        return enumC0265;
                    }
                }
                return null;
            }
        }

        C0264(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull ImpressionTracker impressionTracker, @NonNull NativeClickHandler nativeClickHandler, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener) {
            this.f1624 = jSONObject;
            this.f1622 = context.getApplicationContext();
            this.f1625 = impressionTracker;
            this.f1626 = nativeClickHandler;
            this.f1623 = customEventNativeListener;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private void m1348(@NonNull EnumC0265 enumC0265, @Nullable Object obj) throws ClassCastException {
            try {
                switch (enumC0265) {
                    case MAIN_IMAGE:
                        setMainImageUrl((String) obj);
                        break;
                    case ICON_IMAGE:
                        setIconImageUrl((String) obj);
                        break;
                    case IMPRESSION_TRACKER:
                        m1297(obj);
                        break;
                    case CLICK_DESTINATION:
                        setClickDestinationUrl((String) obj);
                        break;
                    case CLICK_TRACKER:
                        m1351(obj);
                        break;
                    case CALL_TO_ACTION:
                        setCallToAction((String) obj);
                        break;
                    case TITLE:
                        setTitle((String) obj);
                        break;
                    case TEXT:
                        setText((String) obj);
                        break;
                    case STAR_RATING:
                        setStarRating(Numbers.parseDouble(obj));
                        break;
                    case PRIVACY_INFORMATION_ICON_IMAGE_URL:
                        setPrivacyInformationIconImageUrl((String) obj);
                        break;
                    case PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL:
                        setPrivacyInformationIconClickThroughUrl((String) obj);
                        break;
                    default:
                        MoPubLog.d("Unable to add JSON key to internal mapping: " + enumC0265.f1630);
                        break;
                }
            } catch (ClassCastException e) {
                if (enumC0265.f1631) {
                    throw e;
                }
                MoPubLog.d("Ignoring class cast exception for optional key: " + enumC0265.f1630);
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean m1349(@Nullable String str) {
            return str != null && str.toLowerCase(Locale.US).endsWith("image");
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean m1350(@NonNull JSONObject jSONObject) {
            HashSet hashSet = new HashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
            return hashSet.containsAll(EnumC0265.f1628);
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        private void m1351(@NonNull Object obj) {
            if (obj instanceof JSONArray) {
                m1299(obj);
            } else {
                addClickTracker((String) obj);
            }
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public void clear(@NonNull View view) {
            this.f1625.removeView(view);
            this.f1626.clearOnClickListener(view);
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public void destroy() {
            this.f1625.destroy();
            super.destroy();
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.ClickInterface
        public void handleClick(@Nullable View view) {
            m1298();
            this.f1626.openClickDestinationUrl(getClickDestinationUrl(), view);
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public void prepare(@NonNull View view) {
            this.f1625.addView(view, this);
            this.f1626.setOnClickListener(view, this);
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.ImpressionInterface
        public void recordImpression(@NonNull View view) {
            m1296();
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        void m1352() throws IllegalArgumentException {
            if (!m1350(this.f1624)) {
                throw new IllegalArgumentException("JSONObject did not contain required keys.");
            }
            Iterator<String> keys = this.f1624.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                EnumC0265 m1355 = EnumC0265.m1355(next);
                if (m1355 != null) {
                    try {
                        m1348(m1355, this.f1624.opt(next));
                    } catch (ClassCastException unused) {
                        throw new IllegalArgumentException("JSONObject key (" + next + ") contained unexpected value.");
                    }
                } else {
                    addExtra(next, this.f1624.opt(next));
                }
            }
            if (TextUtils.isEmpty(getPrivacyInformationIconClickThroughUrl())) {
                setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
            }
            NativeImageHelper.preCacheImages(this.f1622, m1354(), new NativeImageHelper.ImageListener() { // from class: com.mopub.nativeads.MoPubCustomEventNative.ࢠ.1
                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesCached() {
                    if (C0264.this.isInvalidated()) {
                        return;
                    }
                    C0264.this.f1623.onNativeAdLoaded(C0264.this);
                }

                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
                    if (C0264.this.isInvalidated()) {
                        return;
                    }
                    C0264.this.f1623.onNativeAdFailed(nativeErrorCode);
                }
            });
        }

        @NonNull
        /* renamed from: ࢦ  reason: contains not printable characters */
        List<String> m1353() {
            ArrayList arrayList = new ArrayList(getExtras().size());
            for (Map.Entry<String, Object> entry : getExtras().entrySet()) {
                if (m1349(entry.getKey()) && (entry.getValue() instanceof String)) {
                    arrayList.add((String) entry.getValue());
                }
            }
            return arrayList;
        }

        @NonNull
        /* renamed from: ࢧ  reason: contains not printable characters */
        List<String> m1354() {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(getMainImageUrl())) {
                arrayList.add(getMainImageUrl());
            }
            if (!TextUtils.isEmpty(getIconImageUrl())) {
                arrayList.add(getIconImageUrl());
            }
            if (!TextUtils.isEmpty(getPrivacyInformationIconImageUrl())) {
                arrayList.add(getPrivacyInformationIconImageUrl());
            }
            arrayList.addAll(m1353());
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ */
    public void mo1302() {
        if (this.f1620 == null) {
            return;
        }
        this.f1620.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ */
    public void mo1268(@NonNull Context context, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        if (this.f1620 == null || this.f1620.isInvalidated()) {
            Object obj = map.get(DataKeys.JSON_BODY_KEY);
            if (!(obj instanceof JSONObject)) {
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            this.f1620 = new C0264(context, (JSONObject) obj, new ImpressionTracker(context), new NativeClickHandler(context), customEventNativeListener);
            if (map2.containsKey(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT)) {
                try {
                    this.f1620.setImpressionMinPercentageViewed(Integer.parseInt(map2.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT)));
                } catch (NumberFormatException unused) {
                    MoPubLog.d("Unable to format min visible percent: " + map2.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT));
                }
            }
            if (map2.containsKey(DataKeys.IMPRESSION_VISIBLE_MS)) {
                try {
                    this.f1620.setImpressionMinTimeViewed(Integer.parseInt(map2.get(DataKeys.IMPRESSION_VISIBLE_MS)));
                } catch (NumberFormatException unused2) {
                    MoPubLog.d("Unable to format min time: " + map2.get(DataKeys.IMPRESSION_VISIBLE_MS));
                }
            }
            if (map2.containsKey(DataKeys.IMPRESSION_MIN_VISIBLE_PX)) {
                try {
                    this.f1620.setImpressionMinVisiblePx(Integer.valueOf(Integer.parseInt(map2.get(DataKeys.IMPRESSION_MIN_VISIBLE_PX))));
                } catch (NumberFormatException unused3) {
                    MoPubLog.d("Unable to format min visible px: " + map2.get(DataKeys.IMPRESSION_MIN_VISIBLE_PX));
                }
            }
            try {
                this.f1620.m1352();
            } catch (IllegalArgumentException unused4) {
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            }
        }
    }
}
