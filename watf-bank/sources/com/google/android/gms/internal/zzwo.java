package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.R;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
@zzzv
/* loaded from: classes.dex */
public final class zzwo extends zzxb {
    private final Context mContext;
    private final Map<String, String> zzbsr;
    private String zzcge;
    private long zzcgf;
    private long zzcgg;
    private String zzcgh;
    private String zzcgi;

    public zzwo(zzanh zzanhVar, Map<String, String> map) {
        super(zzanhVar, "createCalendarEvent");
        this.zzbsr = map;
        this.mContext = zzanhVar.zzsi();
        this.zzcge = zzbk("description");
        this.zzcgh = zzbk("summary");
        this.zzcgf = zzbl("start_ticks");
        this.zzcgg = zzbl("end_ticks");
        this.zzcgi = zzbk("location");
    }

    private final String zzbk(String str) {
        return TextUtils.isEmpty(this.zzbsr.get(str)) ? "" : this.zzbsr.get(str);
    }

    private final long zzbl(String str) {
        String str2 = this.zzbsr.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzcge);
        data.putExtra("eventLocation", this.zzcgi);
        data.putExtra("description", this.zzcgh);
        long j = this.zzcgf;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzcgg;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return data;
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbm("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzbs.zzei();
        if (!zzahn.zzal(this.mContext).zziu()) {
            zzbm("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzbs.zzei();
        AlertDialog.Builder zzak = zzahn.zzak(this.mContext);
        Resources resources = com.google.android.gms.ads.internal.zzbs.zzem().getResources();
        zzak.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzak.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzak.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzwp(this));
        zzak.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzwq(this));
        zzak.create().show();
    }
}
