package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.MoPubAdvancedBidder;
/* loaded from: assets/classes2.dex */
public class AdColonyAdvancedBidder implements MoPubAdvancedBidder {
    @Override // com.mopub.common.MoPubAdvancedBidder
    public String getCreativeNetworkName() {
        return "adcolony";
    }

    @Override // com.mopub.common.MoPubAdvancedBidder
    public String getToken(Context context) {
        return "1";
    }
}
