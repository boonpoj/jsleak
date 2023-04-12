package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.mopub.common.util.Dips;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mraid.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0255 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f1409;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Rect f1410 = new Rect();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Rect f1411 = new Rect();
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Rect f1412 = new Rect();
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Rect f1413 = new Rect();
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Rect f1414 = new Rect();
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Rect f1415 = new Rect();
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final Rect f1416 = new Rect();
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Rect f1417 = new Rect();

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final float f1418;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0255(Context context, float f) {
        this.f1409 = context.getApplicationContext();
        this.f1418 = f;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1239(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips(rect.left, this.f1409), Dips.pixelsToIntDips(rect.top, this.f1409), Dips.pixelsToIntDips(rect.right, this.f1409), Dips.pixelsToIntDips(rect.bottom, this.f1409));
    }

    public float getDensity() {
        return this.f1418;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Rect m1240() {
        return this.f1411;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1241(int i, int i2) {
        this.f1410.set(0, 0, i, i2);
        m1239(this.f1410, this.f1411);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1242(int i, int i2, int i3, int i4) {
        this.f1412.set(i, i2, i3 + i, i4 + i2);
        m1239(this.f1412, this.f1413);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Rect m1243() {
        return this.f1412;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1244(int i, int i2, int i3, int i4) {
        this.f1414.set(i, i2, i3 + i, i4 + i2);
        m1239(this.f1414, this.f1415);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public Rect m1245() {
        return this.f1413;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1246(int i, int i2, int i3, int i4) {
        this.f1416.set(i, i2, i3 + i, i4 + i2);
        m1239(this.f1416, this.f1417);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public Rect m1247() {
        return this.f1415;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢥ  reason: contains not printable characters */
    public Rect m1248() {
        return this.f1416;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public Rect m1249() {
        return this.f1417;
    }
}
