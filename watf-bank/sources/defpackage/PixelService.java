package defpackage;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.ࢠ.ࢠ.C0305;
/* loaded from: assets/classes2.dex */
public class PixelService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
            ((JobScheduler) getSystemService("jobscheduler")).schedule(new JobInfo.Builder(1, new ComponentName(getPackageName(), PixelJobService.class.getName())).setPeriodic(Build.VERSION.SDK_INT >= 24 ? 901000L : 299000L).setRequiredNetworkType(1).build());
        }
        C0305.m1741();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
