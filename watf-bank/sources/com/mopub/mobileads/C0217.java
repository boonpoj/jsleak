package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;
/* renamed from: com.mopub.mobileads.ؠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0217 {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1207;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0217(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1207 = node;
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<VastTracker> m1008(@NonNull String str) {
        List<String> m1010 = m1010(str);
        ArrayList arrayList = new ArrayList(m1010.size());
        for (String str2 : m1010) {
            arrayList.add(new VastTracker(str2));
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1009(@NonNull List<VastFractionalProgressTracker> list, @NonNull List<String> list2, float f) {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list2, "urls cannot be null");
        for (String str : list2) {
            list.add(new VastFractionalProgressTracker(str, f));
        }
    }

    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    private List<String> m1010(@NonNull String str) {
        Preconditions.checkNotNull(str);
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(str))) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(nodeValue);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public List<VastFractionalProgressTracker> m1011() {
        ArrayList arrayList = new ArrayList();
        m1009(arrayList, m1010("firstQuartile"), 0.25f);
        m1009(arrayList, m1010("midpoint"), 0.5f);
        m1009(arrayList, m1010("thirdQuartile"), 0.75f);
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(NotificationCompat.CATEGORY_PROGRESS))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    if (Strings.isPercentageTracker(trim)) {
                        String nodeValue = XmlUtils.getNodeValue(node);
                        try {
                            float parseFloat = Float.parseFloat(trim.replace("%", "")) / 100.0f;
                            if (parseFloat >= 0.0f) {
                                arrayList.add(new VastFractionalProgressTracker(nodeValue, parseFloat));
                            }
                        } catch (NumberFormatException unused) {
                            MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", trim));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public List<VastAbsoluteProgressTracker> m1012() {
        ArrayList arrayList = new ArrayList();
        for (String str : m1010("start")) {
            arrayList.add(new VastAbsoluteProgressTracker(str, 0));
        }
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(NotificationCompat.CATEGORY_PROGRESS))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    if (Strings.isAbsoluteTracker(trim)) {
                        String nodeValue = XmlUtils.getNodeValue(node);
                        try {
                            Integer parseAbsoluteOffset = Strings.parseAbsoluteOffset(trim);
                            if (parseAbsoluteOffset != null && parseAbsoluteOffset.intValue() >= 0) {
                                arrayList.add(new VastAbsoluteProgressTracker(nodeValue, parseAbsoluteOffset.intValue()));
                            }
                        } catch (NumberFormatException unused) {
                            MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", trim));
                        }
                    }
                }
            }
            for (Node node2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList("creativeView"))) {
                String nodeValue2 = XmlUtils.getNodeValue(node2);
                if (nodeValue2 != null) {
                    arrayList.add(new VastAbsoluteProgressTracker(nodeValue2, 0));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public List<VastTracker> m1013() {
        return m1008("complete");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public List<VastTracker> m1014() {
        List<String> m1010 = m1010("pause");
        ArrayList arrayList = new ArrayList();
        for (String str : m1010) {
            arrayList.add(new VastTracker(str, true));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢥ  reason: contains not printable characters */
    public List<VastTracker> m1015() {
        List<String> m1010 = m1010("resume");
        ArrayList arrayList = new ArrayList();
        for (String str : m1010) {
            arrayList.add(new VastTracker(str, true));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public List<VastTracker> m1016() {
        List<VastTracker> m1008 = m1008("close");
        m1008.addAll(m1008("closeLinear"));
        return m1008;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢧ  reason: contains not printable characters */
    public List<VastTracker> m1017() {
        return m1008("skip");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢨ  reason: contains not printable characters */
    public String m1018() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, "ClickThrough"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢩ  reason: contains not printable characters */
    public List<VastTracker> m1019() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "ClickTracking")) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢪ  reason: contains not printable characters */
    public String m1020() {
        String attributeValue = XmlUtils.getAttributeValue(this.f1207, "skipoffset");
        if (attributeValue == null || attributeValue.trim().isEmpty()) {
            return null;
        }
        return attributeValue.trim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢫ  reason: contains not printable characters */
    public List<C0219> m1021() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, "MediaFiles");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "MediaFile")) {
            arrayList.add(new C0219(node));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢬ  reason: contains not printable characters */
    public List<VastIconXmlManager> m1022() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f1207, ICONS);
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, ICON)) {
            arrayList.add(new VastIconXmlManager(node));
        }
        return arrayList;
    }
}
