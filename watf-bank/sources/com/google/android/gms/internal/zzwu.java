package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzwu extends zzxb {
    private final Context mContext;
    private final Map<String, String> zzbsr;

    public zzwu(zzanh zzanhVar, Map<String, String> map) {
        super(zzanhVar, "storePicture");
        this.zzbsr = map;
        this.mContext = zzanhVar.zzsi();
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbm("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzbs.zzei();
        if (!zzahn.zzal(this.mContext).zzit()) {
            zzbm("Feature is not supported by the device.");
            return;
        }
        String str = this.zzbsr.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzbm("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzbm(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            com.google.android.gms.ads.internal.zzbs.zzei();
            if (!zzahn.zzcf(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzbm(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = com.google.android.gms.ads.internal.zzbs.zzem().getResources();
            com.google.android.gms.ads.internal.zzbs.zzei();
            AlertDialog.Builder zzak = zzahn.zzak(this.mContext);
            zzak.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
            zzak.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzak.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzwv(this, str, lastPathSegment));
            zzak.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzww(this));
            zzak.create().show();
        }
    }
}
