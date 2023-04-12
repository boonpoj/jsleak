package com.mopub.common;

import android.support.annotation.NonNull;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: assets/classes2.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: ֏  reason: contains not printable characters */
    private int f320;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final File f324;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final File f325;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final File f326;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final File f327;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final int f328;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private long f329;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final int f330;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private Writer f332;

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final Pattern f319 = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: ށ  reason: contains not printable characters */
    private static final OutputStream f318 = new OutputStream() { // from class: com.mopub.common.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };

    /* renamed from: ࢪ  reason: contains not printable characters */
    private long f331 = 0;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final LinkedHashMap<String, C0167> f333 = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: ؠ  reason: contains not printable characters */
    private long f321 = 0;

    /* renamed from: ࢢ  reason: contains not printable characters */
    final ThreadPoolExecutor f323 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: ހ  reason: contains not printable characters */
    private final Callable<Void> f322 = new Callable<Void>() { // from class: com.mopub.common.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f332 == null) {
                    return null;
                }
                DiskLruCache.this.m404();
                if (DiskLruCache.this.m401()) {
                    DiskLruCache.this.m398();
                    DiskLruCache.this.f320 = 0;
                }
                return null;
            }
        }
    };

    /* loaded from: assets/classes2.dex */
    public final class Editor {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final C0167 f336;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final boolean[] f337;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f338;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private boolean f339;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.mopub.common.DiskLruCache$Editor$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public class C0166 extends FilterOutputStream {
            private C0166(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    Editor.this.f338 = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    Editor.this.f338 = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    Editor.this.f338 = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(@NonNull byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    Editor.this.f338 = true;
                }
            }
        }

        private Editor(C0167 c0167) {
            this.f336 = c0167;
            this.f337 = c0167.f349 ? null : new boolean[DiskLruCache.this.f330];
        }

        public void abort() throws IOException {
            DiskLruCache.this.m387(this, false);
        }

        public void abortUnlessCommitted() {
            if (this.f339) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        public void commit() throws IOException {
            if (this.f338) {
                DiskLruCache.this.m387(this, false);
                DiskLruCache.this.remove(this.f336.f347);
            } else {
                DiskLruCache.this.m387(this, true);
            }
            this.f339 = true;
        }

        public String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.m392(newInputStream);
            }
            return null;
        }

        public InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f336.f350 == this) {
                    if (this.f336.f349) {
                        try {
                            return new FileInputStream(this.f336.getCleanFile(i));
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                    return null;
                }
                throw new IllegalStateException();
            }
        }

        public OutputStream newOutputStream(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0166 c0166;
            synchronized (DiskLruCache.this) {
                if (this.f336.f350 != this) {
                    throw new IllegalStateException();
                }
                if (!this.f336.f349) {
                    this.f337[i] = true;
                }
                File dirtyFile = this.f336.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException unused) {
                    DiskLruCache.this.f324.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException unused2) {
                        return DiskLruCache.f318;
                    }
                }
                c0166 = new C0166(fileOutputStream);
            }
            return c0166;
        }

        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), DiskLruCacheUtil.f353);
                try {
                    outputStreamWriter2.write(str);
                    DiskLruCacheUtil.m420(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    DiskLruCacheUtil.m420(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public final class Snapshot implements Closeable {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f342;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final long f343;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final InputStream[] f344;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final long[] f345;

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f342 = str;
            this.f343 = j;
            this.f344 = inputStreamArr;
            this.f345 = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f344) {
                DiskLruCacheUtil.m420(inputStream);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.m383(this.f342, this.f343);
        }

        public InputStream getInputStream(int i) {
            return this.f344[i];
        }

        public long getLength(int i) {
            return this.f345[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.m392(getInputStream(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.DiskLruCache$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public final class C0167 {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f347;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final long[] f348;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f349;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private Editor f350;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private long f351;

        private C0167(String str) {
            this.f347 = str;
            this.f348 = new long[DiskLruCache.this.f330];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m412(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f330) {
                throw m414(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f348[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m414(strArr);
                }
            }
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        private IOException m414(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File getCleanFile(int i) {
            File file = DiskLruCache.this.f324;
            return new File(file, this.f347 + "." + i);
        }

        public File getDirtyFile(int i) {
            File file = DiskLruCache.this.f324;
            return new File(file, this.f347 + "." + i + ".tmp");
        }

        public String getLengths() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f348) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f324 = file;
        this.f328 = i;
        this.f325 = new File(file, "journal");
        this.f326 = new File(file, "journal.tmp");
        this.f327 = new File(file, "journal.bkp");
        this.f330 = i2;
        this.f329 = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        m390(file2, file3, false);
                    }
                }
                DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
                if (diskLruCache.f325.exists()) {
                    try {
                        diskLruCache.m393();
                        diskLruCache.m396();
                        diskLruCache.f332 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f325, true), DiskLruCacheUtil.f352));
                        return diskLruCache;
                    } catch (IOException e) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                        diskLruCache.delete();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                diskLruCache2.m398();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public synchronized Editor m383(String str, long j) throws IOException {
        m403();
        m395(str);
        C0167 c0167 = this.f333.get(str);
        if (j == -1 || (c0167 != null && c0167.f351 == j)) {
            if (c0167 == null) {
                c0167 = new C0167(str);
                this.f333.put(str, c0167);
            } else if (c0167.f350 != null) {
                return null;
            }
            Editor editor = new Editor(c0167);
            c0167.f350 = editor;
            Writer writer = this.f332;
            writer.write("DIRTY " + str + '\n');
            this.f332.flush();
            return editor;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public synchronized void m387(Editor editor, boolean z) throws IOException {
        C0167 c0167 = editor.f336;
        if (c0167.f350 != editor) {
            throw new IllegalStateException();
        }
        if (z && !c0167.f349) {
            for (int i = 0; i < this.f330; i++) {
                if (!editor.f337[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!c0167.getDirtyFile(i).exists()) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f330; i2++) {
            File dirtyFile = c0167.getDirtyFile(i2);
            if (!z) {
                m389(dirtyFile);
            } else if (dirtyFile.exists()) {
                File cleanFile = c0167.getCleanFile(i2);
                dirtyFile.renameTo(cleanFile);
                long j = c0167.f348[i2];
                long length = cleanFile.length();
                c0167.f348[i2] = length;
                this.f331 = (this.f331 - j) + length;
            }
        }
        this.f320++;
        c0167.f350 = null;
        if (c0167.f349 || z) {
            c0167.f349 = true;
            this.f332.write("CLEAN " + c0167.f347 + c0167.getLengths() + '\n');
            if (z) {
                long j2 = this.f321;
                this.f321 = 1 + j2;
                c0167.f351 = j2;
            }
        } else {
            this.f333.remove(c0167.f347);
            this.f332.write("REMOVE " + c0167.f347 + '\n');
        }
        this.f332.flush();
        if (this.f331 > this.f329 || m401()) {
            this.f323.submit(this.f322);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m389(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m390(File file, File file2, boolean z) throws IOException {
        if (z) {
            m389(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m391(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f333.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        C0167 c0167 = this.f333.get(substring);
        if (c0167 == null) {
            c0167 = new C0167(substring);
            this.f333.put(substring, c0167);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0167.f349 = true;
            c0167.f350 = null;
            c0167.m412(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0167.f350 = new Editor(c0167);
        } else if (indexOf2 == -1 && indexOf == "READ".length() && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m392(InputStream inputStream) throws IOException {
        return DiskLruCacheUtil.m419((Reader) new InputStreamReader(inputStream, DiskLruCacheUtil.f353));
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m393() throws IOException {
        C0190 c0190 = new C0190(new FileInputStream(this.f325), DiskLruCacheUtil.f352);
        try {
            String readLine = c0190.readLine();
            String readLine2 = c0190.readLine();
            String readLine3 = c0190.readLine();
            String readLine4 = c0190.readLine();
            String readLine5 = c0190.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.f328).equals(readLine3) || !Integer.toString(this.f330).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m391(c0190.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.f320 = i - this.f333.size();
                    DiskLruCacheUtil.m420(c0190);
                    return;
                }
            }
        } catch (Throwable th) {
            DiskLruCacheUtil.m420(c0190);
            throw th;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m395(String str) {
        if (f319.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m396() throws IOException {
        m389(this.f326);
        Iterator<C0167> it = this.f333.values().iterator();
        while (it.hasNext()) {
            C0167 next = it.next();
            int i = 0;
            if (next.f350 == null) {
                while (i < this.f330) {
                    this.f331 += next.f348[i];
                    i++;
                }
            } else {
                next.f350 = null;
                while (i < this.f330) {
                    m389(next.getCleanFile(i));
                    m389(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public synchronized void m398() throws IOException {
        if (this.f332 != null) {
            this.f332.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f326), DiskLruCacheUtil.f352));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f328));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f330));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0167 c0167 : this.f333.values()) {
            bufferedWriter.write(c0167.f350 != null ? "DIRTY " + c0167.f347 + '\n' : "CLEAN " + c0167.f347 + c0167.getLengths() + '\n');
        }
        bufferedWriter.close();
        if (this.f325.exists()) {
            m390(this.f325, this.f327, true);
        }
        m390(this.f326, this.f325, false);
        this.f327.delete();
        this.f332 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f325, true), DiskLruCacheUtil.f352));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m401() {
        return this.f320 >= 2000 && this.f320 >= this.f333.size();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m403() {
        if (this.f332 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public void m404() throws IOException {
        while (this.f331 > this.f329) {
            remove(this.f333.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f332 == null) {
            return;
        }
        Iterator it = new ArrayList(this.f333.values()).iterator();
        while (it.hasNext()) {
            C0167 c0167 = (C0167) it.next();
            if (c0167.f350 != null) {
                c0167.f350.abort();
            }
        }
        m404();
        this.f332.close();
        this.f332 = null;
    }

    public void delete() throws IOException {
        close();
        DiskLruCacheUtil.m421(this.f324);
    }

    public Editor edit(String str) throws IOException {
        return m383(str, -1L);
    }

    public synchronized void flush() throws IOException {
        m403();
        m404();
        this.f332.flush();
    }

    public synchronized Snapshot get(String str) throws IOException {
        m403();
        m395(str);
        C0167 c0167 = this.f333.get(str);
        if (c0167 == null) {
            return null;
        }
        if (c0167.f349) {
            InputStream[] inputStreamArr = new InputStream[this.f330];
            for (int i = 0; i < this.f330; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(c0167.getCleanFile(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.f330 && inputStreamArr[i2] != null; i2++) {
                        DiskLruCacheUtil.m420(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.f320++;
            this.f332.append((CharSequence) ("READ " + str + '\n'));
            if (m401()) {
                this.f323.submit(this.f322);
            }
            return new Snapshot(str, c0167.f351, inputStreamArr, c0167.f348);
        }
        return null;
    }

    public File getDirectory() {
        return this.f324;
    }

    public synchronized long getMaxSize() {
        return this.f329;
    }

    public synchronized boolean isClosed() {
        return this.f332 == null;
    }

    public synchronized boolean remove(String str) throws IOException {
        m403();
        m395(str);
        C0167 c0167 = this.f333.get(str);
        if (c0167 != null && c0167.f350 == null) {
            for (int i = 0; i < this.f330; i++) {
                File cleanFile = c0167.getCleanFile(i);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new IOException("failed to delete " + cleanFile);
                }
                this.f331 -= c0167.f348[i];
                c0167.f348[i] = 0;
            }
            this.f320++;
            this.f332.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f333.remove(str);
            if (m401()) {
                this.f323.submit(this.f322);
            }
            return true;
        }
        return false;
    }

    public synchronized void setMaxSize(long j) {
        this.f329 = j;
        this.f323.submit(this.f322);
    }

    public synchronized long size() {
        return this.f331;
    }
}
