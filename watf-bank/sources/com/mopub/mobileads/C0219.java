package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ށ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0219 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1209;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0219(@NonNull Node node) {
        Preconditions.checkNotNull(node, "mediaNode cannot be null");
        this.f1209 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m1023() {
        return XmlUtils.getAttributeValueAsInt(this.f1209, "width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Integer m1024() {
        return XmlUtils.getAttributeValueAsInt(this.f1209, "height");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m1025() {
        return XmlUtils.getAttributeValue(this.f1209, VastExtensionXmlManager.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public String m1026() {
        return XmlUtils.getNodeValue(this.f1209);
    }
}
