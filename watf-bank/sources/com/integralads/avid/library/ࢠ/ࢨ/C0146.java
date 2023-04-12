package com.integralads.avid.library.ࢠ.ࢨ;

import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import com.integralads.avid.library.ࢠ.ࢢ.AbstractC0087;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0108;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢨ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0146 extends AbstractC0087 implements InterfaceC0145 {
    public C0146(AbstractC0107 abstractC0107, C0108 c0108) {
        super(abstractC0107, c0108);
    }

    /* renamed from: ހ  reason: contains not printable characters */
    private void m292() {
        if (!m97().m201()) {
            throw new IllegalStateException("The AVID ad session is not ready. Please ensure you have called recordReadyEvent for the deferred AVID ad session before recording any video event.");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m293(String str, JSONObject jSONObject) {
        m99();
        m292();
        m98().m215(str, jSONObject);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    public void e_() {
        m293(AvidVideoPlaybackListenerImpl.AD_IMPRESSION, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    public void f_() {
        m293(AvidVideoPlaybackListenerImpl.AD_STARTED, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    public void g_() {
        m293(AvidVideoPlaybackListenerImpl.AD_LOADED, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    public void h_() {
        m293(AvidVideoPlaybackListenerImpl.AD_VIDEO_START, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ֏ */
    public void mo281() {
        m293(AvidVideoPlaybackListenerImpl.AD_USER_CLOSE, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ؠ */
    public void mo282() {
        m293(AvidVideoPlaybackListenerImpl.AD_SKIPPED, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢠ */
    public void mo283(Integer num) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AvidVideoPlaybackListenerImpl.VOLUME, num);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m293(AvidVideoPlaybackListenerImpl.AD_VOLUME_CHANGE, jSONObject);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢥ */
    public void mo284() {
        m293(AvidVideoPlaybackListenerImpl.AD_STOPPED, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢦ */
    public void mo285() {
        m293(AvidVideoPlaybackListenerImpl.AD_VIDEO_COMPLETE, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢧ */
    public void mo286() {
        m293(AvidVideoPlaybackListenerImpl.AD_CLICK_THRU, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢨ */
    public void mo287() {
        m293(AvidVideoPlaybackListenerImpl.AD_VIDEO_FIRST_QUARTILE, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢩ */
    public void mo288() {
        m293(AvidVideoPlaybackListenerImpl.AD_VIDEO_MIDPOINT, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢪ */
    public void mo289() {
        m293(AvidVideoPlaybackListenerImpl.AD_VIDEO_THIRD_QUARTILE, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢫ */
    public void mo290() {
        m293(AvidVideoPlaybackListenerImpl.AD_PAUSED, null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢨ.InterfaceC0145
    /* renamed from: ࢬ */
    public void mo291() {
        m293(AvidVideoPlaybackListenerImpl.AD_PLAYING, null);
    }
}
