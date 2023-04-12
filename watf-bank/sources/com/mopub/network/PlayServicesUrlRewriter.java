package com.mopub.network;

import android.net.Uri;
import com.mopub.common.ClientMetadata;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.volley.toolbox.HurlStack;
/* loaded from: assets/classes2.dex */
public class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {
    public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
    public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";

    @Override // com.mopub.volley.toolbox.HurlStack.UrlRewriter
    public String rewriteUrl(String str) {
        ClientMetadata clientMetadata;
        if ((str.contains(UDID_TEMPLATE) || str.contains(DO_NOT_TRACK_TEMPLATE)) && (clientMetadata = ClientMetadata.getInstance()) != null) {
            AdvertisingId advertisingInfo = clientMetadata.getMoPubIdentifier().getAdvertisingInfo();
            return str.replace(UDID_TEMPLATE, Uri.encode(advertisingInfo.getIdWithPrefix(MoPub.canCollectPersonalInformation()))).replace(DO_NOT_TRACK_TEMPLATE, advertisingInfo.isDoNotTrack() ? "1" : "0");
        }
        return str;
    }
}
