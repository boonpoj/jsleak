package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class AdAlertReporter {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f684 = new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(DateAndTime.now());

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final View f685;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Context f686;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Intent f687;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f688;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f689;

    public AdAlertReporter(Context context, View view, @Nullable AdReport adReport) {
        this.f685 = view;
        this.f686 = context;
        m625();
        String m624 = m624(m627());
        this.f688 = "";
        this.f689 = "";
        if (adReport != null) {
            this.f688 = adReport.toString();
            this.f689 = adReport.getResponseString();
        }
        m628();
        m626(this.f688, this.f689, m624);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m624(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 25, byteArrayOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m625() {
        this.f687 = new Intent("android.intent.action.SENDTO");
        this.f687.setData(Uri.parse("mailto:creative-review@mopub.com"));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m626(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append("\n=================\n");
            }
        }
        this.f687.putExtra("android.intent.extra.TEXT", sb.toString());
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Bitmap m627() {
        if (this.f685 == null || this.f685.getRootView() == null) {
            return null;
        }
        View rootView = this.f685.getRootView();
        boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        rootView.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m628() {
        Intent intent = this.f687;
        intent.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.f684);
    }

    public void send() {
        try {
            Intents.startActivity(this.f686, this.f687);
        } catch (IntentNotResolvableException unused) {
            Toast.makeText(this.f686, "No email client available", 0).show();
        }
    }
}
