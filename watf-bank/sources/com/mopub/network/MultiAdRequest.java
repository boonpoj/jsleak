package com.mopub.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
/* loaded from: assets/classes2.dex */
public class MultiAdRequest extends MoPubRequest<MultiAdResponse> {
    @NonNull
    public final Listener mListener;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    final AdFormat f2065;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    final String f2066;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Context f2067;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2068;

    /* loaded from: assets/classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onSuccessResponse(MultiAdResponse multiAdResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiAdRequest(@NonNull String str, @NonNull AdFormat adFormat, @Nullable String str2, @NonNull Context context, @NonNull Listener listener) {
        super(context, m1604(str), listener);
        this.f2068 = 0;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        this.f2066 = str2;
        this.mListener = listener;
        this.f2065 = adFormat;
        this.f2067 = context.getApplicationContext();
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (personalInformationManager != null) {
            personalInformationManager.requestSync(false);
        }
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1604(@NonNull String str) {
        if (MoPub.getPersonalInformationManager() == null || !MoPub.isSdkInitialized()) {
            MoPubLog.e("Make sure to call MoPub#initializeSdk before loading an ad.");
            return "";
        }
        return str;
    }

    @Override // com.mopub.volley.Request
    public void cancel() {
        super.cancel();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiAdRequest) {
            MultiAdRequest multiAdRequest = (MultiAdRequest) obj;
            return (this.f2066 != null ? multiAdRequest.f2066 == null ? 1 : this.f2066.compareTo(multiAdRequest.f2066) : multiAdRequest.f2066 != null ? -1 : 0) == 0 && this.f2065 == multiAdRequest.f2065 && getUrl().compareTo(multiAdRequest.getUrl()) == 0;
        }
        return false;
    }

    public int hashCode() {
        if (this.f2068 == 0) {
            this.f2068 = ((((this.f2066 == null ? 29 : this.f2066.hashCode()) * 31) + this.f2065.hashCode()) * 31) + getOriginalUrl().hashCode();
        }
        return this.f2068;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    @Nullable
    /* renamed from: ࢠ */
    public Response<MultiAdResponse> mo502(NetworkResponse networkResponse) {
        try {
            return Response.success(new MultiAdResponse(this.f2067, networkResponse, this.f2065, this.f2066), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            return e instanceof MoPubNetworkError ? Response.error((MoPubNetworkError) e) : Response.error(new MoPubNetworkError(e, MoPubNetworkError.Reason.UNSPECIFIED));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(MultiAdResponse multiAdResponse) {
        if (isCanceled()) {
            return;
        }
        this.mListener.onSuccessResponse(multiAdResponse);
    }
}
