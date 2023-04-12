package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;
/* loaded from: assets/classes2.dex */
public class VastExtensionXmlManager {
    public static final String AD_VERIFICATIONS = "AdVerifications";
    public static final String AVID = "AVID";
    public static final String ID = "id";
    public static final String MOAT = "Moat";
    public static final String TYPE = "type";
    public static final String VENDOR = "vendor";
    public static final String VERIFICATION = "Verification";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f999;

    public VastExtensionXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f999 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public VideoViewabilityTracker m875() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f999, VIDEO_VIEWABILITY_TRACKER);
        if (firstMatchingChildNode == null) {
            return null;
        }
        VideoViewabilityTrackerXmlManager videoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(firstMatchingChildNode);
        Integer m994 = videoViewabilityTrackerXmlManager.m994();
        Integer m995 = videoViewabilityTrackerXmlManager.m995();
        String m996 = videoViewabilityTrackerXmlManager.m996();
        if (m994 == null || m995 == null || TextUtils.isEmpty(m996)) {
            return null;
        }
        return new VideoViewabilityTracker(m994.intValue(), m995.intValue(), m996);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Set<String> m876() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f999, AVID);
        if (firstMatchingChildNode == null) {
            return null;
        }
        return new C0230(firstMatchingChildNode).m1046();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public Set<String> m877() {
        List<Node> matchingChildNodes;
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f999, AD_VERIFICATIONS);
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, VERIFICATION, VENDOR, Collections.singletonList(MOAT))) == null || matchingChildNodes.isEmpty()) {
            return null;
        }
        return new C0238(matchingChildNodes).m1071();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public String m878() {
        return XmlUtils.getAttributeValue(this.f999, TYPE);
    }
}
