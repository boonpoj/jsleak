package com.mopub.nativeads;

import android.support.annotation.NonNull;
import com.mopub.mobileads.MoPubError;
/* loaded from: assets/classes2.dex */
public enum NativeErrorCode implements MoPubError {
    AD_SUCCESS("ad successfully loaded."),
    EMPTY_AD_RESPONSE("Server returned empty response."),
    INVALID_RESPONSE("Unable to parse response from server."),
    IMAGE_DOWNLOAD_FAILURE("Unable to download images associated with ad."),
    INVALID_REQUEST_URL("Invalid request url."),
    UNEXPECTED_RESPONSE_CODE("Received unexpected response code from server."),
    SERVER_ERROR_RESPONSE_CODE("Server returned erroneous response code."),
    CONNECTION_ERROR("Network is unavailable."),
    UNSPECIFIED("Unspecified error occurred."),
    NETWORK_INVALID_REQUEST("Third-party network received invalid request."),
    NETWORK_TIMEOUT("Third-party network failed to respond in a timely manner."),
    NETWORK_NO_FILL("Third-party network failed to provide an ad."),
    NETWORK_INVALID_STATE("Third-party network failed due to invalid internal state."),
    NATIVE_RENDERER_CONFIGURATION_ERROR("A required renderer was not registered for the CustomEventNative."),
    NATIVE_ADAPTER_CONFIGURATION_ERROR("CustomEventNative was configured incorrectly."),
    NATIVE_ADAPTER_NOT_FOUND("Unable to find CustomEventNative.");
    

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f1755;

    NativeErrorCode(String str) {
        this.f1755 = str;
    }

    @Override // com.mopub.mobileads.MoPubError
    public int getIntCode() {
        switch (this) {
            case NETWORK_TIMEOUT:
                return 2;
            case NATIVE_ADAPTER_NOT_FOUND:
                return 1;
            case AD_SUCCESS:
                return 0;
            default:
                return 10000;
        }
    }

    @Override // java.lang.Enum
    @NonNull
    public final String toString() {
        return this.f1755;
    }
}
