package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
/* loaded from: assets/classes2.dex */
public class ViewGestureDetector extends GestureDetector {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final View f1163;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AdAlertGestureListener f1164;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private UserClickListener f1165;

    /* loaded from: assets/classes2.dex */
    public interface UserClickListener {
        void onResetUserClick();

        void onUserClick();

        boolean wasClicked();
    }

    public ViewGestureDetector(@NonNull Context context, @NonNull View view, @Nullable AdReport adReport) {
        this(context, view, new AdAlertGestureListener(view, adReport));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.f1164 = adAlertGestureListener;
        this.f1163 = view;
        setIsLongpressEnabled(false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m997(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= 0.0f && x <= ((float) view.getWidth()) && y >= 0.0f && y <= ((float) view.getHeight());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void sendTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                break;
            case 1:
                if (this.f1165 != null) {
                    this.f1165.onUserClick();
                } else {
                    MoPubLog.d("View's onUserClick() is not registered.");
                }
                this.f1164.m622();
                return;
            case 2:
                if (!m997(motionEvent, this.f1163)) {
                    m998();
                    return;
                }
                break;
            default:
                return;
        }
        onTouchEvent(motionEvent);
    }

    public void setUserClickListener(UserClickListener userClickListener) {
        this.f1165 = userClickListener;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m998() {
        this.f1164.m623();
    }
}
