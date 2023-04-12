package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0238 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final List<Node> f1264;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0238(@NonNull List<Node> list) {
        Preconditions.checkNotNull(list);
        this.f1264 = list;
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m1070(@Nullable Node node) {
        if (node == null || !node.hasAttributes()) {
            return null;
        }
        return String.format(Locale.US, "<ViewableImpression id=\"%s\"><![CDATA[%s]]</ViewableImpression>", XmlUtils.getAttributeValue(node, "id"), XmlUtils.getNodeValue(node));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Set<String> m1071() {
        String m1070;
        HashSet hashSet = new HashSet();
        for (Node node : this.f1264) {
            if (node != null && (m1070 = m1070(XmlUtils.getFirstMatchingChildNode(node, "ViewableImpression"))) != null) {
                hashSet.add(m1070);
            }
        }
        return hashSet;
    }
}
