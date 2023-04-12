package com.mopub.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: assets/classes2.dex */
public class MraidNativeCommandHandler {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String[] f1370 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class AsyncTaskC0249 extends AsyncTask<String, Void, Boolean> {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Context f1378;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final InterfaceC0250 f1379;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$ࢠ$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public interface InterfaceC0250 {
            void onFailure();

            void onSuccess();
        }

        public AsyncTaskC0249(@NonNull Context context, @NonNull InterfaceC0250 interfaceC0250) {
            this.f1378 = context.getApplicationContext();
            this.f1379 = interfaceC0250;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private File m1220() {
            return new File(Environment.getExternalStorageDirectory(), "Pictures");
        }

        @Nullable
        /* renamed from: ࢠ  reason: contains not printable characters */
        private String m1221(@NonNull URI uri, @Nullable Map<String, List<String>> map) {
            Preconditions.checkNotNull(uri);
            String path = uri.getPath();
            if (path == null || map == null) {
                return null;
            }
            String name = new File(path).getName();
            List<String> list = map.get(ResponseHeader.CONTENT_TYPE.getKey());
            if (list == null || list.isEmpty()) {
                return name;
            }
            if (list.get(0) == null) {
                return name;
            }
            for (String str : list.get(0).split(";")) {
                if (str.contains("image/")) {
                    String str2 = "." + str.split("/")[1];
                    if (name.endsWith(str2)) {
                        return name;
                    }
                    return name + str2;
                }
            }
            return name;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private void m1222(String str) {
            C0251 c0251 = new C0251(str, null);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f1378, c0251);
            c0251.m1225(mediaScannerConnection);
            mediaScannerConnection.connect();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v15, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable] */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public Boolean doInBackground(@NonNull String[] strArr) {
            BufferedInputStream bufferedInputStream;
            ?? r8;
            Throwable th;
            HttpURLConnection httpUrlConnection;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return false;
            }
            File m1220 = m1220();
            m1220.mkdirs();
            String str = strArr[0];
            URI create = URI.create(str);
            BufferedInputStream bufferedInputStream2 = null;
            try {
                httpUrlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                bufferedInputStream = new BufferedInputStream(httpUrlConnection.getInputStream());
            } catch (Exception unused) {
                r8 = 0;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
            try {
                String headerField = httpUrlConnection.getHeaderField(ResponseHeader.LOCATION.getKey());
                if (!TextUtils.isEmpty(headerField)) {
                    create = URI.create(headerField);
                }
                File file = new File(m1220, m1221(create, httpUrlConnection.getHeaderFields()));
                r8 = new FileOutputStream(file);
                try {
                    Streams.copyContent(bufferedInputStream, r8);
                    m1222(file.toString());
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(r8);
                    return true;
                } catch (Exception unused2) {
                    bufferedInputStream2 = bufferedInputStream;
                    r8 = r8;
                    try {
                        Streams.closeStream(bufferedInputStream2);
                        Streams.closeStream(r8);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedInputStream2 = r8;
                        th = th;
                        Streams.closeStream(bufferedInputStream);
                        Streams.closeStream(bufferedInputStream2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream2 = r8;
                    th = th;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(bufferedInputStream2);
                    throw th;
                }
            } catch (Exception unused3) {
                r8 = 0;
            } catch (Throwable th5) {
                th = th5;
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(bufferedInputStream2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void onPostExecute(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                this.f1379.onFailure();
            } else {
                this.f1379.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0251 implements MediaScannerConnection.MediaScannerConnectionClient {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f1380;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f1381;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private MediaScannerConnection f1382;

        private C0251(String str, String str2) {
            this.f1380 = str;
            this.f1381 = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m1225(MediaScannerConnection mediaScannerConnection) {
            this.f1382 = mediaScannerConnection;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            if (this.f1382 != null) {
                this.f1382.scanFile(this.f1380, this.f1381);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            if (this.f1382 != null) {
                this.f1382.disconnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0252 {
        void onFailure(C0253 c0253);
    }

    public static boolean isStorePictureSupported(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && DeviceUtils.isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m1205(int i) throws IllegalArgumentException {
        switch (i) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + i);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Date m1206(String str) {
        Date parse;
        Date date = null;
        for (String str2 : f1370) {
            try {
                parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            } catch (ParseException unused) {
            }
            if (parse != null) {
                return parse;
            }
            date = parse;
        }
        return date;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Map<String, Object> m1207(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("description") && map.containsKey("start")) {
            hashMap.put("title", map.get("description"));
            if (!map.containsKey("start") || map.get("start") == null) {
                throw new IllegalArgumentException("Invalid calendar event: start is null.");
            }
            Date m1206 = m1206(map.get("start"));
            if (m1206 != null) {
                hashMap.put("beginTime", Long.valueOf(m1206.getTime()));
                if (map.containsKey("end") && map.get("end") != null) {
                    Date m12062 = m1206(map.get("end"));
                    if (m12062 == null) {
                        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                    }
                    hashMap.put("endTime", Long.valueOf(m12062.getTime()));
                }
                if (map.containsKey("location")) {
                    hashMap.put("eventLocation", map.get("location"));
                }
                if (map.containsKey("summary")) {
                    hashMap.put("description", map.get("summary"));
                }
                if (map.containsKey("transparency")) {
                    hashMap.put("availability", Integer.valueOf(map.get("transparency").equals("transparent") ? 1 : 0));
                }
                hashMap.put("rrule", m1210(map));
                return hashMap;
            }
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m1208(int i) throws IllegalArgumentException {
        if (i == 0 || i < -31 || i > 31) {
            throw new IllegalArgumentException("invalid day of month " + i);
        }
        return "" + i;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m1209(String str) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            if (parseInt == 7) {
                parseInt = 0;
            }
            if (!zArr[parseInt]) {
                sb.append(m1205(parseInt) + ",");
                zArr[parseInt] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m1210(Map<String, String> map) throws IllegalArgumentException {
        String m1211;
        StringBuilder sb;
        String str;
        String sb2;
        StringBuilder sb3 = new StringBuilder();
        if (map.containsKey("frequency")) {
            String str2 = map.get("frequency");
            int parseInt = map.containsKey("interval") ? Integer.parseInt(map.get("interval")) : -1;
            if ("daily".equals(str2)) {
                sb3.append("FREQ=DAILY;");
                if (parseInt != -1) {
                    sb2 = "INTERVAL=" + parseInt + ";";
                    sb3.append(sb2);
                }
            } else {
                if ("weekly".equals(str2)) {
                    sb3.append("FREQ=WEEKLY;");
                    if (parseInt != -1) {
                        sb3.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInWeek")) {
                        m1211 = m1209(map.get("daysInWeek"));
                        if (m1211 == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        sb = new StringBuilder();
                        str = "BYDAY=";
                        sb.append(str);
                        sb.append(m1211);
                        sb.append(";");
                        sb2 = sb.toString();
                    }
                } else if (!"monthly".equals(str2)) {
                    throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                } else {
                    sb3.append("FREQ=MONTHLY;");
                    if (parseInt != -1) {
                        sb3.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInMonth")) {
                        m1211 = m1211(map.get("daysInMonth"));
                        if (m1211 == null) {
                            throw new IllegalArgumentException();
                        }
                        sb = new StringBuilder();
                        str = "BYMONTHDAY=";
                        sb.append(str);
                        sb.append(m1211);
                        sb.append(";");
                        sb2 = sb.toString();
                    }
                }
                sb3.append(sb2);
            }
        }
        return sb3.toString();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String m1211(String str) throws IllegalArgumentException {
        int parseInt;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt2 = Integer.parseInt(str2) + 31;
            if (!zArr[parseInt2]) {
                sb.append(m1208(parseInt) + ",");
                zArr[parseInt2] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m1212(final Context context, final String str, final InterfaceC0252 interfaceC0252) {
        new AlertDialog.Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: com.mopub.mraid.MraidNativeCommandHandler.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MraidNativeCommandHandler.this.m1218(context, str, interfaceC0252);
            }
        }).setCancelable(true).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static boolean m1213(Context context) {
        return Intents.deviceCanHandleIntent(context, new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1214(@NonNull Context context, @NonNull String str, @NonNull InterfaceC0252 interfaceC0252) throws C0253 {
        if (!isStorePictureSupported(context)) {
            MoPubLog.d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            throw new C0253("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
        } else if (context instanceof Activity) {
            m1212(context, str, interfaceC0252);
        } else {
            Toast.makeText(context, "Downloading image to Picture gallery...", 0).show();
            m1218(context, str, interfaceC0252);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1215(Context context, Map<String, String> map) throws C0253 {
        if (!m1213(context)) {
            MoPubLog.d("unsupported action createCalendarEvent for devices pre-ICS");
            throw new C0253("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
        try {
            Map<String, Object> m1207 = m1207(map);
            Intent type = new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE);
            for (String str : m1207.keySet()) {
                Object obj = m1207.get(str);
                if (obj instanceof Long) {
                    type.putExtra(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    type.putExtra(str, ((Integer) obj).intValue());
                } else {
                    type.putExtra(str, (String) obj);
                }
            }
            type.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(type);
        } catch (ActivityNotFoundException unused) {
            MoPubLog.d("no calendar app installed");
            throw new C0253("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e) {
            MoPubLog.d("create calendar: invalid parameters " + e.getMessage());
            throw new C0253(e);
        } catch (Exception e2) {
            MoPubLog.d("could not create calendar event");
            throw new C0253(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1216(@NonNull Activity activity, @NonNull View view) {
        while (view.isHardwareAccelerated() && !Utils.bitMaskContainsFlag(view.getLayerType(), 1)) {
            if (!(view.getParent() instanceof View)) {
                Window window = activity.getWindow();
                return window != null && Utils.bitMaskContainsFlag(window.getAttributes().flags, 16777216);
            }
            view = (View) view.getParent();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1217(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1218(final Context context, String str, final InterfaceC0252 interfaceC0252) {
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0249(context, new AsyncTaskC0249.InterfaceC0250() { // from class: com.mopub.mraid.MraidNativeCommandHandler.1
            @Override // com.mopub.mraid.MraidNativeCommandHandler.AsyncTaskC0249.InterfaceC0250
            public void onFailure() {
                Toast.makeText(context, "Image failed to download.", 0).show();
                MoPubLog.d("Error downloading and saving image file.");
                interfaceC0252.onFailure(new C0253("Error downloading and saving image file."));
            }

            @Override // com.mopub.mraid.MraidNativeCommandHandler.AsyncTaskC0249.InterfaceC0250
            public void onSuccess() {
                MoPubLog.d("Image successfully saved.");
            }
        }), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m1219(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }
}
