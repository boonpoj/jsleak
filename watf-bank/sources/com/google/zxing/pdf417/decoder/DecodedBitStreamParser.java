package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: assets/classes2.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: assets/classes2.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = MACRO_PDF417_TERMINATOR;
        int i7 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i8 = 928;
        int i9 = NUMERIC_COMPACTION_MODE_LATCH;
        long j = 900;
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i10 = iArr[i2];
            i3 = i2 + 1;
            boolean z = false;
            loop0: while (true) {
                i4 = 0;
                long j2 = 0;
                while (i3 < iArr[0] && !z) {
                    int i11 = i4 + 1;
                    iArr2[i4] = i10;
                    j2 = (j2 * j) + i10;
                    int i12 = i3 + 1;
                    i10 = iArr[i3];
                    if (i10 == TEXT_COMPACTION_MODE_LATCH || i10 == BYTE_COMPACTION_MODE_LATCH || i10 == NUMERIC_COMPACTION_MODE_LATCH || i10 == BYTE_COMPACTION_MODE_LATCH_6 || i10 == 928 || i10 == i7 || i10 == i6) {
                        i3 = i12 - 1;
                        i4 = i11;
                        i6 = MACRO_PDF417_TERMINATOR;
                        i7 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                        z = true;
                    } else if (i11 % 5 != 0 || i11 <= 0) {
                        i3 = i12;
                        i4 = i11;
                        i6 = MACRO_PDF417_TERMINATOR;
                        i7 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                    } else {
                        int i13 = 0;
                        while (i13 < 6) {
                            byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                            i13++;
                            i6 = MACRO_PDF417_TERMINATOR;
                            i7 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        }
                        i3 = i12;
                        j = 900;
                    }
                }
            }
            if (i3 != iArr[0] || i10 >= TEXT_COMPACTION_MODE_LATCH) {
                i5 = i4;
            } else {
                i5 = i4 + 1;
                iArr2[i4] = i10;
            }
            for (int i14 = 0; i14 < i5; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
            boolean z2 = false;
            int i15 = 0;
            long j3 = 0;
            while (i3 < iArr[0] && !z2) {
                int i16 = i3 + 1;
                int i17 = iArr[i3];
                if (i17 < TEXT_COMPACTION_MODE_LATCH) {
                    i15++;
                    j3 = (j3 * 900) + i17;
                    i3 = i16;
                } else {
                    if (i17 != TEXT_COMPACTION_MODE_LATCH && i17 != BYTE_COMPACTION_MODE_LATCH && i17 != i9 && i17 != BYTE_COMPACTION_MODE_LATCH_6 && i17 != i8) {
                        if (i17 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                            if (i17 != MACRO_PDF417_TERMINATOR) {
                                i3 = i16;
                            }
                            i3 = i16 - 1;
                            z2 = true;
                        }
                    }
                    i3 = i16 - 1;
                    z2 = true;
                }
                if (i15 % 5 == 0 && i15 > 0) {
                    for (int i18 = 0; i18 < 6; i18++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i18) * 8)));
                    }
                    i15 = 0;
                    j3 = 0;
                }
                i8 = 928;
                i9 = NUMERIC_COMPACTION_MODE_LATCH;
            }
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.common.DecoderResult decode(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.DEFAULT_ENCODING
            r2 = r6[r2]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L68
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L53
            switch(r2) {
                case 900: goto L23;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
        L23:
            int r2 = textCompaction(r6, r4, r0)
            goto L5b
        L28:
            int r2 = decodeMacroBlock(r6, r4, r3)
            goto L5b
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L5b
        L3e:
            int r2 = r4 + 2
            goto L5b
        L41:
            int r2 = r4 + 1
            goto L5b
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = numericCompaction(r6, r4, r0)
            goto L5b
        L4e:
            int r2 = byteCompaction(r2, r6, r1, r4, r0)
            goto L5b
        L53:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L5b:
            int r4 = r6.length
            if (r2 >= r4) goto L63
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L63:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L68:
            int r6 = r0.length()
            if (r6 == 0) goto L7c
            com.google.zxing.common.DecoderResult r6 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.setOther(r3)
            return r6
        L7c:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                if (iArr[textCompaction] == MACRO_PDF417_TERMINATOR) {
                    pDF417ResultMetadata.setLastSegment(true);
                    return textCompaction + 1;
                }
                return textCompaction;
            }
            int i4 = textCompaction + 1;
            int[] iArr3 = new int[iArr[0] - i4];
            boolean z = false;
            int i5 = 0;
            while (i4 < iArr[0] && !z) {
                int i6 = i4 + 1;
                int i7 = iArr[i4];
                if (i7 < TEXT_COMPACTION_MODE_LATCH) {
                    iArr3[i5] = i7;
                    i4 = i6;
                    i5++;
                } else if (i7 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                } else {
                    pDF417ResultMetadata.setLastSegment(true);
                    i4 = i6 + 1;
                    z = true;
                }
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
            return i4;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ab, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cd, code lost:
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void decodeTextCompaction(int[] r14, int[] r15, int r16, java.lang.StringBuilder r17) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                            break;
                        default:
                            switch (i4) {
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }
}
