package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0230 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1228;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0230(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1228 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Set<String> m1046() {
        List<Node> matchingChildNodes;
        HashSet hashSet = new HashSet();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1228, VastExtensionXmlManager.AD_VERIFICATIONS);
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, VastExtensionXmlManager.VERIFICATION)) == null) {
            return hashSet;
        }
        for (Node node : matchingChildNodes) {
            Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(node, "JavaScriptResource");
            if (firstMatchingChildNode2 != null) {
                hashSet.add(XmlUtils.getNodeValue(firstMatchingChildNode2));
            }
        }
        return hashSet;
    }
}
