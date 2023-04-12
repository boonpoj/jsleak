package com.mopub.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.volley.Cache;
import com.mopub.volley.Header;
import com.mopub.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class DiskBasedCache implements Cache {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Map<String, C0298> f2172;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private long f2173;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final File f2174;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f2175;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0298 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        long f2176;

        /* renamed from: ࢢ  reason: contains not printable characters */
        final String f2177;

        /* renamed from: ࢣ  reason: contains not printable characters */
        final String f2178;

        /* renamed from: ࢤ  reason: contains not printable characters */
        final long f2179;

        /* renamed from: ࢥ  reason: contains not printable characters */
        final long f2180;

        /* renamed from: ࢦ  reason: contains not printable characters */
        final long f2181;

        /* renamed from: ࢧ  reason: contains not printable characters */
        final long f2182;

        /* renamed from: ࢨ  reason: contains not printable characters */
        final List<Header> f2183;

        C0298(String str, Cache.Entry entry) {
            this(str, entry.etag, entry.serverDate, entry.lastModified, entry.ttl, entry.softTtl, m1672(entry));
            this.f2176 = entry.data.length;
        }

        private C0298(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.f2177 = str;
            this.f2178 = "".equals(str2) ? null : str2;
            this.f2179 = j;
            this.f2180 = j2;
            this.f2181 = j3;
            this.f2182 = j4;
            this.f2183 = list;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        static C0298 m1671(C0299 c0299) throws IOException {
            if (DiskBasedCache.m1655((InputStream) c0299) == 538247942) {
                return new C0298(DiskBasedCache.m1656(c0299), DiskBasedCache.m1656(c0299), DiskBasedCache.m1665((InputStream) c0299), DiskBasedCache.m1665((InputStream) c0299), DiskBasedCache.m1665((InputStream) c0299), DiskBasedCache.m1665((InputStream) c0299), DiskBasedCache.m1666(c0299));
            }
            throw new IOException();
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static List<Header> m1672(Cache.Entry entry) {
            return entry.allResponseHeaders != null ? entry.allResponseHeaders : HttpHeaderParser.m1682(entry.responseHeaders);
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        Cache.Entry m1673(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.f2178;
            entry.serverDate = this.f2179;
            entry.lastModified = this.f2180;
            entry.ttl = this.f2181;
            entry.softTtl = this.f2182;
            entry.responseHeaders = HttpHeaderParser.m1683(this.f2183);
            entry.allResponseHeaders = Collections.unmodifiableList(this.f2183);
            return entry;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        boolean m1674(OutputStream outputStream) {
            try {
                DiskBasedCache.m1659(outputStream, 538247942);
                DiskBasedCache.m1661(outputStream, this.f2177);
                DiskBasedCache.m1661(outputStream, this.f2178 == null ? "" : this.f2178);
                DiskBasedCache.m1660(outputStream, this.f2179);
                DiskBasedCache.m1660(outputStream, this.f2180);
                DiskBasedCache.m1660(outputStream, this.f2181);
                DiskBasedCache.m1660(outputStream, this.f2182);
                DiskBasedCache.m1663(this.f2183, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.d("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0299 extends FilterInputStream {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final long f2184;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private long f2185;

        C0299(InputStream inputStream, long j) {
            super(inputStream);
            this.f2184 = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f2185++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f2185 += read;
            }
            return read;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        long m1675() {
            return this.f2184 - this.f2185;
        }
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    public DiskBasedCache(File file, int i) {
        this.f2172 = new LinkedHashMap(16, 0.75f, true);
        this.f2173 = 0L;
        this.f2174 = file;
        this.f2175 = i;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static int m1655(InputStream inputStream) throws IOException {
        return (m1668(inputStream) << 24) | (m1668(inputStream) << 0) | 0 | (m1668(inputStream) << 8) | (m1668(inputStream) << 16);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static String m1656(C0299 c0299) throws IOException {
        return new String(m1664(c0299, m1665((InputStream) c0299)), "UTF-8");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m1657(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1658(int i) {
        long j;
        long j2 = i;
        if (this.f2173 + j2 < this.f2175) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f2173;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, C0298>> it = this.f2172.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C0298 value = it.next().getValue();
            if (getFileForKey(value.f2177).delete()) {
                j = j2;
                this.f2173 -= value.f2176;
            } else {
                j = j2;
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", value.f2177, m1657(value.f2177));
            }
            it.remove();
            i2++;
            if (((float) (this.f2173 + j)) < this.f2175 * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f2173 - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1659(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1660(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1661(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m1660(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1662(String str, C0298 c0298) {
        if (this.f2172.containsKey(str)) {
            this.f2173 += c0298.f2176 - this.f2172.get(str).f2176;
        } else {
            this.f2173 += c0298.f2176;
        }
        this.f2172.put(str, c0298);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1663(List<Header> list, OutputStream outputStream) throws IOException {
        if (list == null) {
            m1659(outputStream, 0);
            return;
        }
        m1659(outputStream, list.size());
        for (Header header : list) {
            m1661(outputStream, header.getName());
            m1661(outputStream, header.getValue());
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static byte[] m1664(C0299 c0299, long j) throws IOException {
        long m1675 = c0299.m1675();
        if (j >= 0 && j <= m1675) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(c0299).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + m1675);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    static long m1665(InputStream inputStream) throws IOException {
        return ((m1668(inputStream) & 255) << 0) | 0 | ((m1668(inputStream) & 255) << 8) | ((m1668(inputStream) & 255) << 16) | ((m1668(inputStream) & 255) << 24) | ((m1668(inputStream) & 255) << 32) | ((m1668(inputStream) & 255) << 40) | ((m1668(inputStream) & 255) << 48) | ((255 & m1668(inputStream)) << 56);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    static List<Header> m1666(C0299 c0299) throws IOException {
        int m1655 = m1655((InputStream) c0299);
        if (m1655 < 0) {
            throw new IOException("readHeaderList size=" + m1655);
        }
        List<Header> emptyList = m1655 == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < m1655; i++) {
            emptyList.add(new Header(m1656(c0299).intern(), m1656(c0299).intern()));
        }
        return emptyList;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1667(String str) {
        C0298 remove = this.f2172.remove(str);
        if (remove != null) {
            this.f2173 -= remove.f2176;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static int m1668(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    @Override // com.mopub.volley.Cache
    public synchronized void clear() {
        File[] listFiles = this.f2174.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.f2172.clear();
        this.f2173 = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    @Override // com.mopub.volley.Cache
    public synchronized Cache.Entry get(String str) {
        C0298 c0298 = this.f2172.get(str);
        if (c0298 == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            C0299 c0299 = new C0299(new BufferedInputStream(m1669(fileForKey)), fileForKey.length());
            try {
                C0298 m1671 = C0298.m1671(c0299);
                if (TextUtils.equals(str, m1671.f2177)) {
                    return c0298.m1673(m1664(c0299, c0299.m1675()));
                }
                VolleyLog.d("%s: key=%s, found=%s", fileForKey.getAbsolutePath(), str, m1671.f2177);
                m1667(str);
                return null;
            } finally {
                c0299.close();
            }
        } catch (IOException e) {
            VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    public File getFileForKey(String str) {
        return new File(this.f2174, m1657(str));
    }

    @Override // com.mopub.volley.Cache
    public synchronized void initialize() {
        long length;
        C0299 c0299;
        if (!this.f2174.exists()) {
            if (!this.f2174.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", this.f2174.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f2174.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                c0299 = new C0299(new BufferedInputStream(m1669(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                C0298 m1671 = C0298.m1671(c0299);
                m1671.f2176 = length;
                m1662(m1671.f2177, m1671);
                c0299.close();
            } catch (Throwable th) {
                c0299.close();
                throw th;
                break;
            }
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        m1658(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m1670(fileForKey));
            C0298 c0298 = new C0298(str, entry);
            if (!c0298.m1674(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.data);
            bufferedOutputStream.close();
            m1662(str, c0298);
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        m1667(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, m1657(str));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    InputStream m1669(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    OutputStream m1670(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }
}
