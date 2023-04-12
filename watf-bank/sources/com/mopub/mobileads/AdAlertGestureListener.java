package com.mopub.mobileads;

import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;
/* loaded from: assets/classes2.dex */
public class AdAlertGestureListener extends GestureDetector.SimpleOnGestureListener {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AdReport f672;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f673;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f674;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f675;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f676;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private AdAlertReporter f677;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f678;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private float f679;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private EnumC0192 f680 = EnumC0192.UNSET;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private View f681;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.AdAlertGestureListener$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0192 {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdAlertGestureListener(View view, @Nullable AdReport adReport) {
        this.f673 = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f673 = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.f681 = view;
        this.f672 = adReport;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m613(float f) {
        if (f > this.f679) {
            this.f680 = EnumC0192.GOING_RIGHT;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m614(float f, float f2) {
        return Math.abs(f2 - f) > 100.0f;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m615(float f) {
        if (m618(f) && m621(f)) {
            this.f680 = EnumC0192.GOING_LEFT;
            this.f679 = f;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m616() {
        this.f678++;
        if (this.f678 >= 4) {
            this.f680 = EnumC0192.FINISHED;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m617(float f) {
        if (m619(f) && m620(f)) {
            this.f680 = EnumC0192.GOING_RIGHT;
            this.f679 = f;
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean m618(float f) {
        if (this.f676) {
            return true;
        }
        if (f >= this.f679 + this.f673) {
            this.f675 = false;
            this.f676 = true;
            return true;
        }
        return false;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean m619(float f) {
        if (this.f675) {
            return true;
        }
        if (f <= this.f679 - this.f673) {
            this.f676 = false;
            this.f675 = true;
            m616();
            return true;
        }
        return false;
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean m620(float f) {
        return f > this.f674;
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean m621(float f) {
        return f < this.f674;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f680 == EnumC0192.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (m614(motionEvent.getY(), motionEvent2.getY())) {
            this.f680 = EnumC0192.FAILED;
        } else {
            switch (this.f680) {
                case UNSET:
                    this.f679 = motionEvent.getX();
                    m613(motionEvent2.getX());
                    break;
                case GOING_RIGHT:
                    m615(motionEvent2.getX());
                    break;
                case GOING_LEFT:
                    m617(motionEvent2.getX());
                    break;
            }
            this.f674 = motionEvent2.getX();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m622() {
        EnumC0192 enumC0192 = this.f680;
        EnumC0192 enumC01922 = this.f680;
        if (enumC0192 == EnumC0192.FINISHED) {
            this.f677 = new AdAlertReporter(this.f681.getContext(), this.f681, this.f672);
            this.f677.send();
        }
        m623();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m623() {
        this.f678 = 0;
        this.f680 = EnumC0192.UNSET;
    }
}
