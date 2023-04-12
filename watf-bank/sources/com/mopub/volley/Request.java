package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.volley.Cache;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* renamed from: ֏  reason: contains not printable characters */
    private RetryPolicy f2121;

    /* renamed from: ؠ  reason: contains not printable characters */
    private Cache.Entry f2122;

    /* renamed from: ހ  reason: contains not printable characters */
    private Object f2123;

    /* renamed from: ށ  reason: contains not printable characters */
    private InterfaceC0295 f2124;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final VolleyLog.C0296 f2125;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int f2126;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f2127;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f2128;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Object f2129;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Response.ErrorListener f2130;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Integer f2131;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private RequestQueue f2132;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f2133;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f2134;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private boolean f2135;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private boolean f2136;

    /* loaded from: assets/classes2.dex */
    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    /* loaded from: assets/classes2.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* renamed from: com.mopub.volley.Request$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0295 {
        void onNoUsableResponseReceived(Request<?> request);

        void onResponseReceived(Request<?> request, Response<?> response);
    }

    public Request(int i, String str, Response.ErrorListener errorListener) {
        this.f2125 = VolleyLog.C0296.ENABLED ? new VolleyLog.C0296() : null;
        this.f2129 = new Object();
        this.f2133 = true;
        this.f2134 = false;
        this.f2135 = false;
        this.f2136 = false;
        this.f2122 = null;
        this.f2126 = i;
        this.f2127 = str;
        this.f2130 = errorListener;
        setRetryPolicy(new DefaultRetryPolicy());
        this.f2128 = m1634(str);
    }

    @Deprecated
    public Request(String str, Response.ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int m1634(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private byte[] m1636(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public void addMarker(String str) {
        if (VolleyLog.C0296.ENABLED) {
            this.f2125.add(str, Thread.currentThread().getId());
        }
    }

    public void cancel() {
        synchronized (this.f2129) {
            this.f2134 = true;
            this.f2130 = null;
        }
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        return priority == priority2 ? this.f2131.intValue() - request.f2131.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    public void deliverError(VolleyError volleyError) {
        Response.ErrorListener errorListener;
        synchronized (this.f2129) {
            errorListener = this.f2130;
        }
        if (errorListener != null) {
            errorListener.onErrorResponse(volleyError);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void deliverResponse(T t);

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> mo1475 = mo1475();
        if (mo1475 == null || mo1475.size() <= 0) {
            return null;
        }
        return m1636(mo1475, m1643());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + m1643();
    }

    public Cache.Entry getCacheEntry() {
        return this.f2122;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public Response.ErrorListener getErrorListener() {
        return this.f2130;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.f2126;
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> m1640 = m1640();
        if (m1640 == null || m1640.size() <= 0) {
            return null;
        }
        return m1636(m1640, m1642());
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public RetryPolicy getRetryPolicy() {
        return this.f2121;
    }

    public final int getSequence() {
        if (this.f2131 != null) {
            return this.f2131.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object getTag() {
        return this.f2123;
    }

    public final int getTimeoutMs() {
        return this.f2121.getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.f2128;
    }

    public String getUrl() {
        return this.f2127;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.f2129) {
            z = this.f2135;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f2129) {
            z = this.f2134;
        }
        return z;
    }

    public void markDelivered() {
        synchronized (this.f2129) {
            this.f2135 = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(Cache.Entry entry) {
        this.f2122 = entry;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.f2132 = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.f2121 = retryPolicy;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i) {
        this.f2131 = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.f2133 = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.f2136 = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.f2123 = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.f2133;
    }

    public final boolean shouldRetryServerErrors() {
        return this.f2136;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2134 ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.f2131);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public abstract Response<T> mo502(NetworkResponse networkResponse);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public VolleyError m1637(VolleyError volleyError) {
        return volleyError;
    }

    /* renamed from: ࢠ */
    protected Map<String, String> mo1475() throws AuthFailureError {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1638(InterfaceC0295 interfaceC0295) {
        synchronized (this.f2129) {
            this.f2124 = interfaceC0295;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1639(Response<?> response) {
        InterfaceC0295 interfaceC0295;
        synchronized (this.f2129) {
            interfaceC0295 = this.f2124;
        }
        if (interfaceC0295 != null) {
            interfaceC0295.onResponseReceived(this, response);
        }
    }

    @Deprecated
    /* renamed from: ࢢ  reason: contains not printable characters */
    protected Map<String, String> m1640() throws AuthFailureError {
        return mo1475();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1641(final String str) {
        if (this.f2132 != null) {
            this.f2132.m1645(this);
        }
        if (VolleyLog.C0296.ENABLED) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mopub.volley.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.f2125.add(str, id);
                        Request.this.f2125.finish(Request.this.toString());
                    }
                });
                return;
            }
            this.f2125.add(str, id);
            this.f2125.finish(toString());
        }
    }

    @Deprecated
    /* renamed from: ࢣ  reason: contains not printable characters */
    protected String m1642() {
        return m1643();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected String m1643() {
        return "UTF-8";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m1644() {
        InterfaceC0295 interfaceC0295;
        synchronized (this.f2129) {
            interfaceC0295 = this.f2124;
        }
        if (interfaceC0295 != null) {
            interfaceC0295.onNoUsableResponseReceived(this);
        }
    }
}
