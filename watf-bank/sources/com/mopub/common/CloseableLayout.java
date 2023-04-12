package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
/* loaded from: assets/classes2.dex */
public class CloseableLayout extends FrameLayout {

    /* renamed from: ֏  reason: contains not printable characters */
    private boolean f300;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private RunnableC0165 f301;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f302;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private OnCloseListener f303;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final StateListDrawable f304;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ClosePosition f305;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final int f306;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final int f307;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final int f308;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f309;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Rect f310;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final Rect f311;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final Rect f312;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final Rect f313;

    /* loaded from: assets/classes2.dex */
    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final int f315;

        ClosePosition(int i) {
            this.f315 = i;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        int m380() {
            return this.f315;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* renamed from: com.mopub.common.CloseableLayout$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private final class RunnableC0165 implements Runnable {
        private RunnableC0165() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloseableLayout.this.setClosePressed(false);
        }
    }

    public CloseableLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    public CloseableLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseableLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f310 = new Rect();
        this.f311 = new Rect();
        this.f312 = new Rect();
        this.f313 = new Rect();
        this.f304 = new StateListDrawable();
        this.f305 = ClosePosition.TOP_RIGHT;
        this.f304.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(context));
        this.f304.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(context));
        this.f304.setState(EMPTY_STATE_SET);
        this.f304.setCallback(this);
        this.f302 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f306 = Dips.asIntPixels(50.0f, context);
        this.f307 = Dips.asIntPixels(30.0f, context);
        this.f308 = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.f300 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == m379()) {
            return;
        }
        this.f304.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
        invalidate(this.f311);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m373(ClosePosition closePosition, int i, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.m380(), i, i, rect, rect2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m374(ClosePosition closePosition, Rect rect, Rect rect2) {
        m373(closePosition, this.f307, rect, rect2);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m376() {
        playSoundEffect(0);
        if (this.f303 != null) {
            this.f303.onClose();
        }
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        m373(closePosition, this.f306, rect, rect2);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f309) {
            this.f309 = false;
            this.f310.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.f305, this.f310, this.f311);
            this.f313.set(this.f311);
            this.f313.inset(this.f308, this.f308);
            m374(this.f305, this.f313, this.f312);
            this.f304.setBounds(this.f312);
        }
        if (this.f304.isVisible()) {
            this.f304.draw(canvas);
        }
    }

    @VisibleForTesting
    Rect getCloseBounds() {
        return this.f311;
    }

    @VisibleForTesting
    public boolean isCloseVisible() {
        return this.f304.isVisible();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return m378((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f309 = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!m378((int) motionEvent.getX(), (int) motionEvent.getY(), this.f302) || !m377()) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    setClosePressed(true);
                    break;
                case 1:
                    if (m379()) {
                        if (this.f301 == null) {
                            this.f301 = new RunnableC0165();
                        }
                        postDelayed(this.f301, ViewConfiguration.getPressedStateDuration());
                        m376();
                        break;
                    }
                    break;
            }
        } else {
            setClosePressed(false);
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean z) {
        this.f300 = z;
    }

    @VisibleForTesting
    void setCloseBoundChanged(boolean z) {
        this.f309 = z;
    }

    @VisibleForTesting
    void setCloseBounds(Rect rect) {
        this.f311.set(rect);
    }

    public void setClosePosition(@NonNull ClosePosition closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.f305 = closePosition;
        this.f309 = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.f304.setVisible(z, false)) {
            invalidate(this.f311);
        }
    }

    public void setOnCloseListener(@Nullable OnCloseListener onCloseListener) {
        this.f303 = onCloseListener;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m377() {
        return this.f300 || this.f304.isVisible();
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m378(int i, int i2, int i3) {
        return i >= this.f311.left - i3 && i2 >= this.f311.top - i3 && i < this.f311.right + i3 && i2 < this.f311.bottom + i3;
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    boolean m379() {
        return this.f304.getState() == SELECTED_STATE_SET;
    }
}
