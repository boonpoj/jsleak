package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ࢩ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0241 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1276;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0241(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1276 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public C0216 m1093() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1276, "InLine");
        if (firstMatchingChildNode != null) {
            return new C0216(firstMatchingChildNode);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public C0226 m1094() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1276, "Wrapper");
        if (firstMatchingChildNode != null) {
            return new C0226(firstMatchingChildNode);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m1095() {
        return XmlUtils.getAttributeValue(this.f1276, "sequence");
    }
}
