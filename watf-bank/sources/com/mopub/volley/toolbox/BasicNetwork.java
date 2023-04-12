package com.mopub.volley.toolbox;

import com.mopub.volley.Cache;
import com.mopub.volley.Header;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.ServerError;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: assets/classes2.dex */
public class BasicNetwork implements Network {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static final boolean f2161 = VolleyLog.DEBUG;
    @Deprecated

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected final HttpStack f2162;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected final ByteArrayPool f2163;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final BaseHttpStack f2164;

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.f2164 = baseHttpStack;
        this.f2162 = baseHttpStack;
        this.f2163 = byteArrayPool;
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(4096));
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.f2162 = httpStack;
        this.f2164 = new C0302(httpStack);
        this.f2163 = byteArrayPool;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static List<Header> m1649(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (entry.allResponseHeaders != null) {
            if (!entry.allResponseHeaders.isEmpty()) {
                for (Header header2 : entry.allResponseHeaders) {
                    if (!treeSet.contains(header2.getName())) {
                        arrayList.add(header2);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Map<String, String> m1650(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (entry.etag != null) {
            hashMap.put("If-None-Match", entry.etag);
        }
        if (entry.lastModified > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.m1680(entry.lastModified));
        }
        return hashMap;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1651(long j, Request<?> request, byte[] bArr, int i) {
        if (f2161 || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1652(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private byte[] m1653(InputStream inputStream, int i) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.f2163, i);
        byte[] bArr = null;
        try {
            if (inputStream != null) {
                byte[] buf = this.f2163.getBuf(1024);
                while (true) {
                    try {
                        int read = inputStream.read(buf);
                        if (read == -1) {
                            break;
                        }
                        poolingByteArrayOutputStream.write(buf, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        bArr = buf;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                            }
                        }
                        this.f2163.returnBuf(bArr);
                        poolingByteArrayOutputStream.close();
                        throw th;
                    }
                }
                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f2163.returnBuf(buf);
                poolingByteArrayOutputStream.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // com.mopub.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mopub.volley.NetworkResponse performRequest(com.mopub.volley.Request<?> r29) throws com.mopub.volley.VolleyError {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.BasicNetwork.performRequest(com.mopub.volley.Request):com.mopub.volley.NetworkResponse");
    }
}
