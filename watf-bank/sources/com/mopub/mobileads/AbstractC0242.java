package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
abstract class AbstractC0242 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected final Node f1277;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0242(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1277 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public List<VastTracker> m1096() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f1277, "Impression");
        ArrayList arrayList = new ArrayList();
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
    /* renamed from: ࢢ  reason: contains not printable characters */
    public List<VastTracker> m1097() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f1277, "Error");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (!TextUtils.isEmpty(nodeValue)) {
                arrayList.add(new VastTracker(nodeValue, true));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public List<C0217> m1098() {
        List<Node> matchingChildNodes;
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1277, "Creatives");
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative")) == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(node, "Linear");
            if (firstMatchingChildNode2 != null) {
                arrayList.add(new C0217(firstMatchingChildNode2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public List<C0243> m1099() {
        List<Node> matchingChildNodes;
        List<Node> matchingChildNodes2;
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1277, "Creatives");
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative")) == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(node, "CompanionAds");
            if (firstMatchingChildNode2 != null && (matchingChildNodes2 = XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Companion")) != null) {
                for (Node node2 : matchingChildNodes2) {
                    arrayList.add(new C0243(node2));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢥ  reason: contains not printable characters */
    public VastExtensionParentXmlManager m1100() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1277, "Extensions");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return new VastExtensionParentXmlManager(firstMatchingChildNode);
    }
}
