package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ބ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0226 extends AbstractC0242 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0226(@NonNull Node node) {
        super(node);
        Preconditions.checkNotNull(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢦ  reason: contains not printable characters */
    public String m1032() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f1277, "VASTAdTagURI"));
    }
}
