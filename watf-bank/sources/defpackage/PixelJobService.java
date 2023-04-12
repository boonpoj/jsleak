package defpackage;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.RequiresApi;
@RequiresApi(api = 21)
/* loaded from: assets/classes2.dex */
public class PixelJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        try {
            startService(new Intent(getApplicationContext(), PixelService.class));
            jobFinished(jobParameters, false);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
