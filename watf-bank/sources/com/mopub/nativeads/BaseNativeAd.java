package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: assets/classes2.dex */
public abstract class BaseNativeAd {
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private NativeEventListener f1506;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Set<String> f1504 = new HashSet();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Set<String> f1505 = new HashSet();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f1507 = false;

    /* loaded from: assets/classes2.dex */
    public interface NativeEventListener {
        void onAdClicked();

        void onAdImpressed();
    }

    public final void addClickTracker(@NonNull String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "clickTracker url is not allowed to be null")) {
            this.f1505.add(str);
        }
    }

    public final void addImpressionTracker(@NonNull String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "impressionTracker url is not allowed to be null")) {
            this.f1504.add(str);
        }
    }

    public abstract void clear(@NonNull View view);

    public abstract void destroy();

    public void invalidate() {
        this.f1507 = true;
    }

    public boolean isInvalidated() {
        return this.f1507;
    }

    public abstract void prepare(@NonNull View view);

    public void setNativeEventListener(@Nullable NativeEventListener nativeEventListener) {
        this.f1506 = nativeEventListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1296() {
        if (this.f1506 != null) {
            this.f1506.onAdImpressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1297(Object obj) throws ClassCastException {
        if (!(obj instanceof JSONArray)) {
            throw new ClassCastException("Expected impression trackers of type JSONArray.");
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                addImpressionTracker(jSONArray.getString(i));
            } catch (JSONException unused) {
                MoPubLog.d("Unable to parse impression trackers.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final void m1298() {
        if (this.f1506 != null) {
            this.f1506.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final void m1299(Object obj) throws ClassCastException {
        if (!(obj instanceof JSONArray)) {
            throw new ClassCastException("Expected click trackers of type JSONArray.");
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                addClickTracker(jSONArray.getString(i));
            } catch (JSONException unused) {
                MoPubLog.d("Unable to parse click trackers.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public Set<String> m1300() {
        return new HashSet(this.f1504);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public Set<String> m1301() {
        return new HashSet(this.f1505);
    }
}
