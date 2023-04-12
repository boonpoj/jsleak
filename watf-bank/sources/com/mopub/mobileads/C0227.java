package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ޅ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0227 {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Document f1223;

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public List<C0241> m1033() {
        ArrayList arrayList = new ArrayList();
        if (this.f1223 == null) {
            return arrayList;
        }
        NodeList elementsByTagName = this.f1223.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new C0241(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1034(@NonNull String str) throws ParserConfigurationException, IOException, SAXException {
        Preconditions.checkNotNull(str, "xmlString cannot be null");
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        this.f1223 = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader("<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public VastTracker m1035() {
        if (this.f1223 == null) {
            return null;
        }
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f1223, "Error");
        if (TextUtils.isEmpty(firstMatchingStringData)) {
            return null;
        }
        return new VastTracker(firstMatchingStringData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public List<VastTracker> m1036() {
        List<String> stringDataAsList = XmlUtils.getStringDataAsList(this.f1223, "MP_TRACKING_URL");
        ArrayList arrayList = new ArrayList(stringDataAsList.size());
        for (String str : stringDataAsList) {
            arrayList.add(new VastTracker(str));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public String m1037() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f1223, "MoPubCtaText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 15) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢥ  reason: contains not printable characters */
    public String m1038() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f1223, "MoPubSkipText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 8) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢦ  reason: contains not printable characters */
    public String m1039() {
        return XmlUtils.getFirstMatchingStringData(this.f1223, "MoPubCloseIcon");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢧ  reason: contains not printable characters */
    public DeviceUtils.ForceOrientation m1040() {
        return DeviceUtils.ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.f1223, "MoPubForceOrientation"));
    }
}
