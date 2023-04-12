package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
/* loaded from: assets/classes2.dex */
public class VastIconXmlManager {
    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String OFFSET = "offset";
    public static final String WIDTH = "width";
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1001;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final VastResourceXmlManager f1002;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastIconXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1001 = node;
        this.f1002 = new VastResourceXmlManager(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m879() {
        return XmlUtils.getAttributeValueAsInt(this.f1001, "width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Integer m880() {
        return XmlUtils.getAttributeValueAsInt(this.f1001, "height");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public Integer m881() {
        String attributeValue = XmlUtils.getAttributeValue(this.f1001, OFFSET);
        try {
            return Strings.parseAbsoluteOffset(attributeValue);
        } catch (NumberFormatException unused) {
            MoPubLog.d(String.format("Invalid VAST icon offset format: %s:", attributeValue));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public Integer m882() {
        String attributeValue = XmlUtils.getAttributeValue(this.f1001, DURATION);
        try {
            return Strings.parseAbsoluteOffset(attributeValue);
        } catch (NumberFormatException unused) {
            MoPubLog.d(String.format("Invalid VAST icon duration format: %s:", attributeValue));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢥ  reason: contains not printable characters */
    public VastResourceXmlManager m883() {
        return this.f1002;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public List<VastTracker> m884() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1001, ICON_CLICKS);
        ArrayList arrayList = new ArrayList();
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, ICON_CLICK_TRACKING)) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢧ  reason: contains not printable characters */
    public String m885() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1001, ICON_CLICKS);
        if (firstMatchingChildNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, ICON_CLICK_THROUGH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢨ  reason: contains not printable characters */
    public List<VastTracker> m886() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f1001, ICON_VIEW_TRACKING);
        ArrayList arrayList = new ArrayList();
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }
}
