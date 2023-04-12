package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;
/* loaded from: assets/classes2.dex */
public class VastResourceXmlManager {
    public static final String CREATIVE_TYPE = "creativeType";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String STATIC_RESOURCE = "StaticResource";
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1013;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastResourceXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1013 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m893() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f1013, STATIC_RESOURCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m894() {
        String attributeValue = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.f1013, STATIC_RESOURCE), CREATIVE_TYPE);
        if (attributeValue != null) {
            return attributeValue.toLowerCase();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m895() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f1013, IFRAME_RESOURCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public String m896() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f1013, HTML_RESOURCE));
    }
}
