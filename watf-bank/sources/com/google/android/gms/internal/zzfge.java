package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public class zzfge extends IOException {
    private zzfhe zzphw;

    public zzfge(String str) {
        super(str);
        this.zzphw = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcya() {
        return new zzfge("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyb() {
        return new zzfge("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyc() {
        return new zzfge("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyd() {
        return new zzfge("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcye() {
        return new zzfge("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfgf zzcyf() {
        return new zzfgf("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyg() {
        return new zzfge("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyh() {
        return new zzfge("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfge zzcyi() {
        return new zzfge("Protocol message had invalid UTF-8.");
    }

    public final zzfge zzi(zzfhe zzfheVar) {
        this.zzphw = zzfheVar;
        return this;
    }
}
