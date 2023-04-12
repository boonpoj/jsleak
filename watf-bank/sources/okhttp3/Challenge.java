package okhttp3;

import okhttp3.internal.Util;
/* loaded from: classes.dex */
public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String scheme, String realm) {
        this.scheme = scheme;
        this.realm = realm;
    }

    public String scheme() {
        return this.scheme;
    }

    public String realm() {
        return this.realm;
    }

    public boolean equals(Object o) {
        return (o instanceof Challenge) && Util.equal(this.scheme, ((Challenge) o).scheme) && Util.equal(this.realm, ((Challenge) o).realm);
    }

    public int hashCode() {
        int i = 29 * 31;
        String str = this.realm;
        int result = i + (str != null ? str.hashCode() : 0);
        int result2 = result * 31;
        String str2 = this.scheme;
        return result2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}
