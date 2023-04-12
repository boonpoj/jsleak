package com.google.android.gms.internal;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzplx uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class zzfiy {
    public static final zzfiy zzplp = new zzfiy("DOUBLE", 0, zzfjd.DOUBLE, 1);
    public static final zzfiy zzplq = new zzfiy("FLOAT", 1, zzfjd.FLOAT, 5);
    public static final zzfiy zzplr = new zzfiy("INT64", 2, zzfjd.LONG, 0);
    public static final zzfiy zzpls = new zzfiy("UINT64", 3, zzfjd.LONG, 0);
    public static final zzfiy zzplt = new zzfiy("INT32", 4, zzfjd.INT, 0);
    public static final zzfiy zzplu = new zzfiy("FIXED64", 5, zzfjd.LONG, 1);
    public static final zzfiy zzplv = new zzfiy("FIXED32", 6, zzfjd.INT, 5);
    public static final zzfiy zzplw = new zzfiy("BOOL", 7, zzfjd.BOOLEAN, 0);
    public static final zzfiy zzplx;
    public static final zzfiy zzply;
    public static final zzfiy zzplz;
    public static final zzfiy zzpma;
    public static final zzfiy zzpmb;
    public static final zzfiy zzpmc;
    public static final zzfiy zzpmd;
    public static final zzfiy zzpme;
    public static final zzfiy zzpmf;
    public static final zzfiy zzpmg;
    private static final /* synthetic */ zzfiy[] zzpmj;
    private final zzfjd zzpmh;
    private final int zzpmi;

    static {
        final zzfjd zzfjdVar = zzfjd.STRING;
        zzplx = new zzfiy("STRING", 8, zzfjdVar, 2) { // from class: com.google.android.gms.internal.zzfiz
        };
        final zzfjd zzfjdVar2 = zzfjd.MESSAGE;
        zzply = new zzfiy("GROUP", 9, zzfjdVar2, 3) { // from class: com.google.android.gms.internal.zzfja
        };
        final zzfjd zzfjdVar3 = zzfjd.MESSAGE;
        zzplz = new zzfiy("MESSAGE", 10, zzfjdVar3, 2) { // from class: com.google.android.gms.internal.zzfjb
        };
        final zzfjd zzfjdVar4 = zzfjd.BYTE_STRING;
        zzpma = new zzfiy("BYTES", 11, zzfjdVar4, 2) { // from class: com.google.android.gms.internal.zzfjc
        };
        zzpmb = new zzfiy("UINT32", 12, zzfjd.INT, 0);
        zzpmc = new zzfiy("ENUM", 13, zzfjd.ENUM, 0);
        zzpmd = new zzfiy("SFIXED32", 14, zzfjd.INT, 5);
        zzpme = new zzfiy("SFIXED64", 15, zzfjd.LONG, 1);
        zzpmf = new zzfiy("SINT32", 16, zzfjd.INT, 0);
        zzpmg = new zzfiy("SINT64", 17, zzfjd.LONG, 0);
        zzpmj = new zzfiy[]{zzplp, zzplq, zzplr, zzpls, zzplt, zzplu, zzplv, zzplw, zzplx, zzply, zzplz, zzpma, zzpmb, zzpmc, zzpmd, zzpme, zzpmf, zzpmg};
    }

    private zzfiy(String str, int i, zzfjd zzfjdVar, int i2) {
        this.zzpmh = zzfjdVar;
        this.zzpmi = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfiy(String str, int i, zzfjd zzfjdVar, int i2, zzfix zzfixVar) {
        this(str, i, zzfjdVar, i2);
    }

    public static zzfiy[] values() {
        return (zzfiy[]) zzpmj.clone();
    }

    public final zzfjd zzdad() {
        return this.zzpmh;
    }

    public final int zzdae() {
        return this.zzpmi;
    }
}
