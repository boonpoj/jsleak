package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
/* loaded from: assets/classes2.dex */
public class VastExtensionParentXmlManager {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f998;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastExtensionParentXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f998 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public List<VastExtensionXmlManager> m874() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f998, "Extension");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            arrayList.add(new VastExtensionXmlManager(node));
        }
        return arrayList;
    }
}
