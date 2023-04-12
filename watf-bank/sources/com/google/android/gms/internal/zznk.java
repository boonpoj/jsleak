package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznk {
    private Context mContext;
    private String zzavn;
    private String zzbsa;
    private BlockingQueue<zznu> zzbsc;
    private ExecutorService zzbsd;
    private LinkedHashMap<String, String> zzbse = new LinkedHashMap<>();
    private Map<String, zzno> zzbsf = new HashMap();
    private AtomicBoolean zzbsg = new AtomicBoolean(false);
    private File zzbsh;

    public zznk(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzavn = str;
        this.zzbsa = str2;
        this.zzbsg.set(((Boolean) zzkb.zzif().zzd(zznh.zzbjn)).booleanValue());
        if (this.zzbsg.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzbsh = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzbse.put(entry.getKey(), entry.getValue());
        }
        this.zzbsc = new ArrayBlockingQueue(30);
        this.zzbsd = Executors.newSingleThreadExecutor();
        this.zzbsd.execute(new zznl(this));
        this.zzbsf.put("action", zzno.zzbsk);
        this.zzbsf.put("ad_format", zzno.zzbsk);
        this.zzbsf.put("e", zzno.zzbsl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzjb() {
        FileOutputStream fileOutputStream;
        while (true) {
            try {
                zznu take = this.zzbsc.take();
                String zzjg = take.zzjg();
                if (!TextUtils.isEmpty(zzjg)) {
                    Map<String, String> zza = zza(this.zzbse, take.zzjh());
                    Uri.Builder buildUpon = Uri.parse(this.zzbsa).buildUpon();
                    for (Map.Entry<String, String> entry : zza.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    String str = buildUpon.build().toString() + "&it=" + zzjg;
                    if (this.zzbsg.get()) {
                        File file = this.zzbsh;
                        if (file != null) {
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(file, true);
                                } catch (IOException e) {
                                    e = e;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileOutputStream.write(str.getBytes());
                                fileOutputStream.write(10);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    zzagf.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream2 = fileOutputStream;
                                zzagf.zzc("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e4) {
                                        zzagf.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            zzagf.zzcu("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzbs.zzei();
                        zzahn.zze(this.mContext, this.zzavn, str);
                    }
                }
            } catch (InterruptedException e5) {
                zzagf.zzc("CsiReporter:reporter interrupted", e5);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzam(key).zze(str, entry.getValue()));
        }
        return linkedHashMap;
    }

    public final boolean zza(zznu zznuVar) {
        return this.zzbsc.offer(zznuVar);
    }

    public final zzno zzam(String str) {
        zzno zznoVar = this.zzbsf.get(str);
        return zznoVar != null ? zznoVar : zzno.zzbsj;
    }

    public final void zzg(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzbse.put("e", TextUtils.join(",", list));
    }
}
