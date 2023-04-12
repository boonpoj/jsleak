package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.ࢠ.ࢠ.C0305;
/* loaded from: assets/classes2.dex */
public class BootupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                C0305.m1741();
            } else {
                context.startService(new Intent(context, PixelService.class));
            }
        } catch (Throwable unused) {
        }
    }
}
