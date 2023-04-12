package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ࢠ.ࢠ.C0303;
import com.ࢠ.ࢠ.C0323;
import com.ࢠ.ࢠ.C0327;
/* loaded from: assets/classes2.dex */
public class PixelActivity extends Activity {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2583;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0303 f2584;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private long f2585 = 0;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f2586 = false;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m2086() {
        try {
            this.f2584 = new C0303(this, this.f2583);
            this.f2584.m1721();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f2586 = true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f2585 >= 10000) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        this.f2583 = extras.getInt("step");
        setContentView(C0323.C0326.activity_pixel);
        sendBroadcast(new Intent("QUBU0tfNU5f0xFQQQ"));
        this.f2585 = System.currentTimeMillis();
        m2086();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2584 != null) {
            this.f2584.m1722();
            this.f2584 = null;
        }
        if (this.f2586) {
            sendBroadcast(new Intent(this.f2583 == 1 ? "Ne0hGmDkkivy0aYpZYm" : "PzLLQeMlZSxOpi"));
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C0327.m1835(this, PixelService.class.getName())) {
            return;
        }
        startService(new Intent(getApplicationContext(), PixelService.class));
    }
}
