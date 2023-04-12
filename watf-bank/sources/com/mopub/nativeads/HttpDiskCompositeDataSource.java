package com.mopub.nativeads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Predicate;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class HttpDiskCompositeDataSource implements DataSource {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final HttpDataSource f1543;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private byte[] f1544;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1545;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final TreeSet<IntInterval> f1546;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f1547;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1548;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f1549;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f1550;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f1551;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private Integer f1552;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private DataSpec f1553;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private boolean f1554;

    public HttpDiskCompositeDataSource(@NonNull Context context, @NonNull String str) {
        this(context, str, new DefaultHttpDataSource(str, (Predicate) null));
    }

    @VisibleForTesting
    HttpDiskCompositeDataSource(@NonNull Context context, @NonNull String str, @NonNull HttpDataSource httpDataSource) {
        this.f1552 = null;
        this.f1543 = httpDataSource;
        CacheService.initialize(context);
        this.f1546 = new TreeSet<>();
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static int m1319(int i, @NonNull TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(treeSet);
        Iterator<IntInterval> it = treeSet.iterator();
        while (it.hasNext()) {
            IntInterval next = it.next();
            if (next.getStart() <= i) {
                i = Math.max(i, next.getStart() + next.getLength());
            }
        }
        return i;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Integer m1320(@NonNull String str) {
        Preconditions.checkNotNull(str);
        byte[] fromDiskCache = CacheService.getFromDiskCache("expectedsize-" + str);
        if (fromDiskCache != null) {
            try {
                return Integer.valueOf(Integer.parseInt(new String(fromDiskCache)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1321() {
        CacheService.putToDiskCache(this.f1549 + this.f1545, this.f1544);
        m1323(this.f1546, this.f1547, this.f1548);
        this.f1550 = 0;
        this.f1547 = this.f1547 + this.f1548;
        this.f1548 = 0;
        this.f1549 = this.f1547 / 512000;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1322(@NonNull String str, @NonNull TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(treeSet);
        treeSet.clear();
        byte[] fromDiskCache = CacheService.getFromDiskCache("intervals-sorted-" + str);
        if (fromDiskCache != null) {
            try {
                JSONArray jSONArray = new JSONArray(new String(fromDiskCache));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = new JSONObject((String) jSONArray.get(i));
                    treeSet.add(new IntInterval(jSONObject.getInt("start"), jSONObject.getInt("length")));
                }
            } catch (ClassCastException unused) {
                MoPubLog.d("clearing cache since unable to read json data");
                treeSet.clear();
            } catch (JSONException e) {
                MoPubLog.d("clearing cache since invalid json intervals found", e);
                treeSet.clear();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1323(@NonNull TreeSet<IntInterval> treeSet, int i, int i2) {
        Preconditions.checkNotNull(treeSet);
        if (m1319(i, treeSet) >= i + i2) {
            return;
        }
        treeSet.add(new IntInterval(i, i2));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1324(@NonNull TreeSet<IntInterval> treeSet, @NonNull String str) {
        Preconditions.checkNotNull(treeSet);
        Preconditions.checkNotNull(str);
        JSONArray jSONArray = new JSONArray();
        Iterator<IntInterval> it = treeSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        CacheService.putToDiskCache("intervals-sorted-" + str, jSONArray.toString().getBytes());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m1325(int i, int i2, int i3) {
        return i > i2 + i3;
    }

    public void close() throws IOException {
        if (!TextUtils.isEmpty(this.f1545) && this.f1544 != null) {
            CacheService.putToDiskCache(this.f1549 + this.f1545, this.f1544);
            m1323(this.f1546, this.f1547, this.f1548);
            m1324(this.f1546, this.f1545);
        }
        this.f1544 = null;
        this.f1543.close();
        this.f1551 = false;
        this.f1547 = 0;
        this.f1548 = 0;
        this.f1550 = 0;
        this.f1552 = null;
        this.f1554 = false;
    }

    public Uri getUri() {
        if (this.f1553 != null) {
            return this.f1553.uri;
        }
        return null;
    }

    public long open(@NonNull DataSpec dataSpec) throws IOException {
        Preconditions.checkNotNull(dataSpec);
        if (dataSpec.uri == null) {
            return -1L;
        }
        this.f1554 = false;
        this.f1553 = dataSpec;
        this.f1545 = dataSpec.uri.toString();
        if (this.f1545 == null) {
            return -1L;
        }
        this.f1547 = (int) dataSpec.absoluteStreamPosition;
        this.f1549 = this.f1547 / 512000;
        this.f1544 = CacheService.getFromDiskCache(this.f1549 + this.f1545);
        this.f1550 = this.f1547 % 512000;
        this.f1548 = 0;
        this.f1552 = m1320(this.f1545);
        m1322(this.f1545, this.f1546);
        int m1319 = m1319(this.f1547, this.f1546);
        if (this.f1544 == null) {
            this.f1544 = new byte[512000];
            if (m1319 > this.f1547) {
                MoPubLog.d("Cache segment " + this.f1549 + " was evicted. Invalidating cache");
                this.f1546.clear();
                m1319 = (int) dataSpec.absoluteStreamPosition;
            }
        }
        if (this.f1552 != null && m1319 == this.f1552.intValue()) {
            return dataSpec.length == -1 ? this.f1552.intValue() - this.f1547 : dataSpec.length;
        }
        long j = this.f1553.length == -1 ? -1L : this.f1553.length - (m1319 - this.f1547);
        try {
            long open = this.f1543.open(new DataSpec(dataSpec.uri, m1319, j, dataSpec.key, dataSpec.flags));
            if (this.f1552 == null && j == -1) {
                this.f1552 = Integer.valueOf((int) (this.f1547 + open));
                CacheService.putToDiskCache("expectedsize-" + this.f1545, String.valueOf(this.f1552).getBytes());
            }
            this.f1551 = true;
            return open;
        } catch (HttpDataSource.InvalidResponseCodeException e) {
            if (e.responseCode == 416) {
                long intValue = this.f1552 == null ? m1319 - this.f1547 : this.f1552.intValue() - this.f1547;
                this.f1551 = false;
                return intValue;
            }
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        String str;
        if (i2 > 512000) {
            str = "Reading more than the block size (512000 bytes) at once is not possible. length = " + i2;
        } else if (this.f1553 == null) {
            str = "Unable to read from data source when no spec provided";
        } else if (this.f1544 == null) {
            str = "No cache set up. Call open before read.";
        } else {
            int i4 = (512000 - this.f1550) - this.f1548;
            int m1319 = m1319(this.f1547 + this.f1548, this.f1546);
            int min = Math.min((m1319 - this.f1547) - this.f1548, i2);
            if (!m1325(m1319, this.f1547, this.f1548)) {
                min = 0;
            } else if (min <= i4) {
                System.arraycopy(this.f1544, this.f1550 + this.f1548, bArr, i, min);
                this.f1548 += min;
                min += 0;
            } else {
                System.arraycopy(this.f1544, this.f1550 + this.f1548, bArr, i, i4);
                this.f1548 += i4;
                int i5 = i4 + 0;
                m1321();
                this.f1544 = CacheService.getFromDiskCache(this.f1549 + this.f1545);
                if (this.f1544 == null) {
                    MoPubLog.d("Unexpected cache miss. Invalidating cache");
                    this.f1546.clear();
                    this.f1544 = new byte[512000];
                    this.f1543.close();
                    this.f1543.open(new DataSpec(this.f1553.uri, this.f1547 + this.f1548, -1L, this.f1553.key, this.f1553.flags));
                    this.f1551 = true;
                    min = i5;
                } else {
                    int i6 = i + i5;
                    int i7 = min - i5;
                    System.arraycopy(this.f1544, this.f1550 + this.f1548, bArr, i6, i7);
                    this.f1548 += i7;
                }
            }
            int i8 = i2 - min;
            if (i8 <= 0) {
                return min;
            }
            this.f1554 = true;
            if (this.f1551) {
                int i9 = i + min;
                int read = this.f1543.read(bArr, i9, i8);
                int i10 = (512000 - this.f1550) - this.f1548;
                if (i10 < read) {
                    System.arraycopy(bArr, i9, this.f1544, this.f1550 + this.f1548, i10);
                    this.f1548 += i10;
                    m1321();
                    this.f1544 = CacheService.getFromDiskCache(this.f1549 + this.f1545);
                    if (this.f1544 == null) {
                        this.f1544 = new byte[512000];
                    }
                    int i11 = read - i10;
                    System.arraycopy(bArr, i + i10 + min, this.f1544, this.f1550 + this.f1548, i11);
                    i3 = this.f1548 + i11;
                } else {
                    System.arraycopy(bArr, i9, this.f1544, this.f1550 + this.f1548, read);
                    i3 = this.f1548 + read;
                }
                this.f1548 = i3;
                return read + min;
            }
            str = "end of cache reached. No http source open";
        }
        MoPubLog.d(str);
        return -1;
    }
}
