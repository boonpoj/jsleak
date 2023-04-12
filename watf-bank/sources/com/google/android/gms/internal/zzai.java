package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class zzai implements zzm {
    private static boolean DEBUG = zzae.DEBUG;
    @Deprecated
    private zzaq zzbp;
    private final zzah zzbq;
    private zzaj zzbr;

    public zzai(zzah zzahVar) {
        this(zzahVar, new zzaj(4096));
    }

    private zzai(zzah zzahVar, zzaj zzajVar) {
        this.zzbq = zzahVar;
        this.zzbp = zzahVar;
        this.zzbr = zzajVar;
    }

    @Deprecated
    public zzai(zzaq zzaqVar) {
        this(zzaqVar, new zzaj(4096));
    }

    @Deprecated
    private zzai(zzaq zzaqVar, zzaj zzajVar) {
        this.zzbp = zzaqVar;
        this.zzbq = new zzag(zzaqVar);
        this.zzbr = zzajVar;
    }

    private static List<zzl> zza(List<zzl> list, zzc zzcVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (zzl zzlVar : list) {
                treeSet.add(zzlVar.getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (zzcVar.zzg != null) {
            if (!zzcVar.zzg.isEmpty()) {
                for (zzl zzlVar2 : zzcVar.zzg) {
                    if (!treeSet.contains(zzlVar2.getName())) {
                        arrayList.add(zzlVar2);
                    }
                }
            }
        } else if (!zzcVar.zzf.isEmpty()) {
            for (Map.Entry<String, String> entry : zzcVar.zzf.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new zzl(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(String str, zzr<?> zzrVar, zzad zzadVar) throws zzad {
        zzaa zzi = zzrVar.zzi();
        int zzh = zzrVar.zzh();
        try {
            zzi.zza(zzadVar);
            zzrVar.zzb(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzh)));
        } catch (zzad e) {
            zzrVar.zzb(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzh)));
            throw e;
        }
    }

    private final byte[] zza(InputStream inputStream, int i) throws IOException, zzab {
        zzat zzatVar = new zzat(this.zzbr, i);
        try {
            if (inputStream != null) {
                byte[] zzb = this.zzbr.zzb(1024);
                while (true) {
                    int read = inputStream.read(zzb);
                    if (read == -1) {
                        break;
                    }
                    zzatVar.write(zzb, 0, read);
                }
                byte[] byteArray = zzatVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zzae.zza("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzbr.zza(zzb);
                zzatVar.close();
                return byteArray;
            }
            throw new zzab();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zzae.zza("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.zzbr.zza(null);
            zzatVar.close();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.zzm
    public zzp zzc(zzr<?> zzrVar) throws zzad {
        zzad zzacVar;
        String str;
        List list;
        zzap zzapVar;
        byte[] bArr;
        Map<String, String> map;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List emptyList = Collections.emptyList();
            try {
                try {
                    zzc zze = zzrVar.zze();
                    if (zze == null) {
                        map = Collections.emptyMap();
                    } else {
                        HashMap hashMap = new HashMap();
                        if (zze.zza != null) {
                            hashMap.put("If-None-Match", zze.zza);
                        }
                        if (zze.zzc > 0) {
                            hashMap.put("If-Modified-Since", zzao.zzb(zze.zzc));
                        }
                        map = hashMap;
                    }
                    zzapVar = this.zzbq.zza(zzrVar, map);
                    try {
                        int statusCode = zzapVar.getStatusCode();
                        List<zzl> zzp = zzapVar.zzp();
                        if (statusCode == 304) {
                            zzc zze2 = zzrVar.zze();
                            return zze2 == null ? new zzp(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, zzp) : new zzp(304, zze2.data, true, SystemClock.elapsedRealtime() - elapsedRealtime, zza(zzp, zze2));
                        }
                        InputStream content = zzapVar.getContent();
                        byte[] zza = content != null ? zza(content, zzapVar.getContentLength()) : new byte[0];
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (DEBUG || elapsedRealtime2 > 3000) {
                            Object[] objArr = new Object[5];
                            objArr[0] = zzrVar;
                            objArr[1] = Long.valueOf(elapsedRealtime2);
                            objArr[2] = zza != null ? Integer.valueOf(zza.length) : "null";
                            objArr[3] = Integer.valueOf(statusCode);
                            objArr[4] = Integer.valueOf(zzrVar.zzi().zzc());
                            zzae.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                        }
                        if (statusCode < 200 || statusCode > 299) {
                            throw new IOException();
                        }
                        return new zzp(statusCode, zza, false, SystemClock.elapsedRealtime() - elapsedRealtime, zzp);
                    } catch (IOException e) {
                        e = e;
                        list = emptyList;
                        bArr = null;
                        if (zzapVar == null) {
                            throw new zzq(e);
                        }
                        int statusCode2 = zzapVar.getStatusCode();
                        zzae.zzc("Unexpected response code %d for %s", Integer.valueOf(statusCode2), zzrVar.getUrl());
                        if (bArr != null) {
                            zzp zzpVar = new zzp(statusCode2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, (List<zzl>) list);
                            if (statusCode2 != 401 && statusCode2 != 403) {
                                if (statusCode2 < 400 || statusCode2 > 499) {
                                    if (statusCode2 < 500 || statusCode2 > 599) {
                                        throw new zzab(zzpVar);
                                    }
                                    throw new zzab(zzpVar);
                                }
                                throw new zzg(zzpVar);
                            }
                            zzacVar = new zza(zzpVar);
                            str = "auth";
                        } else {
                            zzacVar = new zzo();
                            str = "network";
                        }
                        zza(str, zzrVar, zzacVar);
                    }
                } catch (IOException e2) {
                    e = e2;
                    list = emptyList;
                    zzapVar = null;
                    bArr = null;
                }
            } catch (MalformedURLException e3) {
                String valueOf = String.valueOf(zzrVar.getUrl());
                throw new RuntimeException(valueOf.length() != 0 ? "Bad URL ".concat(valueOf) : new String("Bad URL "), e3);
            } catch (SocketTimeoutException e4) {
                zzacVar = new zzac();
                str = "socket";
            }
            zza(str, zzrVar, zzacVar);
        }
    }
}
