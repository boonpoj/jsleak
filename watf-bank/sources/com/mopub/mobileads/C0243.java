package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0243 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1278;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final VastResourceXmlManager f1279;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0243(@NonNull Node node) {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        this.f1278 = node;
        this.f1279 = new VastResourceXmlManager(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m1101() {
        return XmlUtils.getAttributeValueAsInt(this.f1278, "width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Integer m1102() {
        return XmlUtils.getAttributeValueAsInt(this.f1278, "height");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m1103() {
        return XmlUtils.getAttributeValue(this.f1278, "adSlotID");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public VastResourceXmlManager m1104() {
        return this.f1279;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢥ  reason: contains not printable characters */
    public String m1105() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f1278, "CompanionClickThrough"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public List<VastTracker> m1106() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f1278, "CompanionClickTracking");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (!TextUtils.isEmpty(nodeValue)) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢧ  reason: contains not printable characters */
    public List<VastTracker> m1107() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1278, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList("creativeView"))) {
            arrayList.add(new VastTracker(XmlUtils.getNodeValue(node)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public boolean m1108() {
        return (TextUtils.isEmpty(this.f1279.m893()) && TextUtils.isEmpty(this.f1279.m896()) && TextUtils.isEmpty(this.f1279.m895())) ? false : true;
    }
}
