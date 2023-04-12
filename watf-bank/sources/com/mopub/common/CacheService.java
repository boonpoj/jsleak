package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.DiskLruCache;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: assets/classes2.dex */
public class CacheService {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static DiskLruCache f274;

    /* loaded from: assets/classes2.dex */
    public interface DiskLruCacheGetListener {
        void onComplete(String str, byte[] bArr);
    }

    /* renamed from: com.mopub.common.CacheService$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class AsyncTaskC0163 extends AsyncTask<Void, Void, byte[]> {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final DiskLruCacheGetListener f275;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f276;

        AsyncTaskC0163(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
            this.f275 = diskLruCacheGetListener;
            this.f276 = str;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            if (this.f275 != null) {
                this.f275.onComplete(this.f276, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void onPostExecute(byte[] bArr) {
            if (isCancelled()) {
                onCancelled();
            } else if (this.f275 != null) {
                this.f275.onComplete(this.f276, bArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public byte[] doInBackground(Void... voidArr) {
            return CacheService.getFromDiskCache(this.f276);
        }
    }

    /* renamed from: com.mopub.common.CacheService$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class AsyncTaskC0164 extends AsyncTask<Void, Void, Void> {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f277;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final byte[] f278;

        AsyncTaskC0164(String str, byte[] bArr) {
            this.f277 = str;
            this.f278 = bArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public Void doInBackground(Void... voidArr) {
            CacheService.putToDiskCache(this.f277, this.f278);
            return null;
        }
    }

    @VisibleForTesting
    @Deprecated
    public static void clearAndNullCaches() {
        if (f274 != null) {
            try {
                f274.delete();
                f274 = null;
            } catch (IOException unused) {
                f274 = null;
            }
        }
    }

    public static boolean containsKeyDiskCache(String str) {
        if (f274 == null) {
            return false;
        }
        try {
            return f274.get(createValidDiskCacheKey(str)) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String createValidDiskCacheKey(String str) {
        return Utils.sha1(str);
    }

    @Nullable
    public static File getDiskCacheDirectory(@NonNull Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String path = cacheDir.getPath();
        return new File(path + File.separator + "mopub-cache");
    }

    @VisibleForTesting
    @Deprecated
    public static DiskLruCache getDiskLruCache() {
        return f274;
    }

    public static String getFilePathDiskCache(String str) {
        if (f274 == null) {
            return null;
        }
        return f274.getDirectory() + File.separator + createValidDiskCacheKey(str) + ".0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
        if (r6 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
        if (r6 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] getFromDiskCache(java.lang.String r6) {
        /*
            com.mopub.common.DiskLruCache r0 = com.mopub.common.CacheService.f274
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.mopub.common.DiskLruCache r0 = com.mopub.common.CacheService.f274     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            java.lang.String r6 = createValidDiskCacheKey(r6)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            com.mopub.common.DiskLruCache$Snapshot r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            if (r6 != 0) goto L18
            if (r6 == 0) goto L17
            r6.close()
        L17:
            return r1
        L18:
            r0 = 0
            java.io.InputStream r2 = r6.getInputStream(r0)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L55
            if (r2 == 0) goto L39
            long r3 = r6.getLength(r0)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L55
            int r0 = (int) r3     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L55
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L55
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L55
            r1.<init>(r2)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L55
            com.mopub.common.util.Streams.readStream(r1, r0)     // Catch: java.lang.Throwable -> L32
            com.mopub.common.util.Streams.closeStream(r1)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L55
            goto L3a
        L32:
            r2 = move-exception
            com.mopub.common.util.Streams.closeStream(r1)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L55
            throw r2     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L55
        L37:
            r1 = move-exception
            goto L4c
        L39:
            r0 = r1
        L3a:
            if (r6 == 0) goto L54
        L3c:
            r6.close()
            goto L54
        L40:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4c
        L45:
            r0 = move-exception
            r6 = r1
            goto L56
        L48:
            r6 = move-exception
            r0 = r1
            r1 = r6
            r6 = r0
        L4c:
            java.lang.String r2 = "Unable to get from DiskLruCache"
            com.mopub.common.logging.MoPubLog.d(r2, r1)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L54
            goto L3c
        L54:
            return r0
        L55:
            r0 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()
        L5b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.CacheService.getFromDiskCache(java.lang.String):byte[]");
    }

    public static void getFromDiskCacheAsync(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
        new AsyncTaskC0163(str, diskLruCacheGetListener).execute(new Void[0]);
    }

    public static void initialize(Context context) {
        initializeDiskCache(context);
    }

    public static boolean initializeDiskCache(Context context) {
        if (context == null) {
            return false;
        }
        if (f274 == null) {
            File diskCacheDirectory = getDiskCacheDirectory(context);
            if (diskCacheDirectory == null) {
                return false;
            }
            try {
                f274 = DiskLruCache.open(diskCacheDirectory, 1, 1, DeviceUtils.diskCacheSizeBytes(diskCacheDirectory));
            } catch (IOException e) {
                MoPubLog.d("Unable to create DiskLruCache", e);
                return false;
            }
        }
        return true;
    }

    public static boolean putToDiskCache(String str, InputStream inputStream) {
        DiskLruCache.Editor editor;
        if (f274 == null) {
            return false;
        }
        try {
            editor = f274.edit(createValidDiskCacheKey(str));
            if (editor == null) {
                return false;
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(editor.newOutputStream(0));
                Streams.copyContent(inputStream, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                f274.flush();
                editor.commit();
                return true;
            } catch (Exception e) {
                e = e;
                MoPubLog.d("Unable to put to DiskLruCache", e);
                if (editor != null) {
                    try {
                        editor.abort();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            editor = null;
        }
    }

    public static boolean putToDiskCache(String str, byte[] bArr) {
        return putToDiskCache(str, new ByteArrayInputStream(bArr));
    }

    public static void putToDiskCacheAsync(String str, byte[] bArr) {
        new AsyncTaskC0164(str, bArr).execute(new Void[0]);
    }
}
