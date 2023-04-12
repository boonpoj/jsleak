package com.mopub.mobileads;

import android.content.Context;
import com.applovin.sdk.AppLovinSdk;
import com.mopub.common.MoPubAdvancedBidder;
/* loaded from: assets/classes2.dex */
public class AppLovinAdvancedBidder implements MoPubAdvancedBidder {
    @Override // com.mopub.common.MoPubAdvancedBidder
    public String getCreativeNetworkName() {
        return "applovin_sdk";
    }

    @Override // com.mopub.common.MoPubAdvancedBidder
    public String getToken(Context context) {
        return AppLovinSdk.getInstance(context).getAdService().getBidToken();
    }
}
