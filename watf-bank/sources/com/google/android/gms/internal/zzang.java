package com.google.android.gms.internal;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@zzzv
/* loaded from: classes.dex */
public final class zzang extends zzana {
    private static final Set<String> zzdki = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzdkj = new DecimalFormat("#,###");
    private File zzdkk;
    private boolean zzdkl;

    public zzang(zzamp zzampVar) {
        super(zzampVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzagf.zzcu("Context.getCacheDir() returned null");
            return;
        }
        this.zzdkk = new File(cacheDir, "admobVideoStreams");
        if (!this.zzdkk.isDirectory() && !this.zzdkk.mkdirs()) {
            String valueOf = String.valueOf(this.zzdkk.getAbsolutePath());
            zzagf.zzcu(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzdkk = null;
        } else if (this.zzdkk.setReadable(true, false) && this.zzdkk.setExecutable(true, false)) {
        } else {
            String valueOf2 = String.valueOf(this.zzdkk.getAbsolutePath());
            zzagf.zzcu(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzdkk = null;
        }
    }

    private final File zzc(File file) {
        return new File(this.zzdkk, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.zzana
    public final void abort() {
        this.zzdkl = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02ca, code lost:
        r15 = "sizeExceeded";
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02da, code lost:
        if (r1.length() == 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02dc, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02e2, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ee, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02f2, code lost:
        r2 = r0;
        r26 = r4;
        r29 = r10;
        r10 = r1;
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0394, code lost:
        r26 = r4;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x039a, code lost:
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x039c, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03c7, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03cb, code lost:
        r2 = r0;
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03e0, code lost:
        r26 = r4;
        r24 = r10;
        r21 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03e6, code lost:
        r26.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03ee, code lost:
        if (com.google.android.gms.internal.zzagf.zzae(3) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03f0, code lost:
        r1 = com.google.android.gms.internal.zzang.zzdkj.format(r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.zzagf.zzbx(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0432, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0439, code lost:
        if (r0.isFile() == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x043b, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0443, code lost:
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x045c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x045f, code lost:
        r1 = r24;
     */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0501  */
    @Override // com.google.android.gms.internal.zzana
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzcx(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 1309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzang.zzcx(java.lang.String):boolean");
    }
}
