package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
/* loaded from: assets/classes2.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        BitArray bitArray;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i8 = 0;
        if (i2 == 0) {
            BitArray bitArray2 = null;
            int i9 = 0;
            int i10 = 0;
            while (i9 <= 32) {
                boolean z2 = i9 <= 3;
                int i11 = z2 ? i9 + 1 : i9;
                int i12 = totalBitsInLayer(i11, z2);
                if (size2 <= i12) {
                    if (i10 != WORD_SIZE[i11]) {
                        i10 = WORD_SIZE[i11];
                        bitArray2 = stuffBits(encode, i10);
                    }
                    int i13 = i12 - (i12 % i10);
                    if ((!z2 || bitArray2.getSize() <= (i10 << 6)) && bitArray2.getSize() + size <= i13) {
                        i3 = i10;
                        bitArray = bitArray2;
                        z = z2;
                        i4 = i11;
                        i5 = i12;
                    }
                }
                i9++;
                i8 = 0;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i2 < 0;
        i4 = Math.abs(i2);
        if (i4 > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
        }
        i5 = totalBitsInLayer(i4, z);
        i3 = WORD_SIZE[i4];
        int i14 = i5 - (i5 % i3);
        bitArray = stuffBits(encode, i3);
        if (bitArray.getSize() + size > i14) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && bitArray.getSize() > (i3 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i5, i3);
        int size3 = bitArray.getSize() / i3;
        BitArray generateModeMessage = generateModeMessage(z, i4, size3);
        int i15 = (z ? 11 : 14) + (i4 << 2);
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < iArr.length; i17++) {
                iArr[i17] = i17;
            }
            i6 = i15;
        } else {
            int i18 = i15 / 2;
            i6 = i15 + 1 + (((i18 - 1) / 15) * 2);
            int i19 = i6 / 2;
            for (int i20 = 0; i20 < i18; i20++) {
                iArr[(i18 - i20) - 1] = (i19 - i7) - 1;
                iArr[i18 + i20] = (i20 / 15) + i20 + i19 + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i21 = 0;
        int i22 = 0;
        while (i21 < i4) {
            int i23 = ((i4 - i21) << i16) + (z ? 9 : 12);
            int i24 = 0;
            while (i24 < i23) {
                int i25 = i24 << 1;
                while (i8 < i16) {
                    if (generateCheckWords.get(i22 + i25 + i8)) {
                        int i26 = i21 << 1;
                        bitMatrix.set(iArr[i26 + i8], iArr[i26 + i24]);
                    }
                    if (generateCheckWords.get((i23 << 1) + i22 + i25 + i8)) {
                        int i27 = i21 << 1;
                        bitMatrix.set(iArr[i27 + i24], iArr[((i15 - 1) - i27) - i8]);
                    }
                    if (generateCheckWords.get((i23 << 2) + i22 + i25 + i8)) {
                        int i28 = (i15 - 1) - (i21 << 1);
                        bitMatrix.set(iArr[i28 - i8], iArr[i28 - i24]);
                    }
                    if (generateCheckWords.get((i23 * 6) + i22 + i25 + i8)) {
                        int i29 = i21 << 1;
                        bitMatrix.set(iArr[((i15 - 1) - i29) - i24], iArr[i29 + i8]);
                    }
                    i8++;
                    i16 = 2;
                }
                i24++;
                i8 = 0;
                i16 = 2;
            }
            i22 += i23 << 3;
            i21++;
            i8 = 0;
            i16 = 2;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i30 = i6 / 2;
            drawBullsEye(bitMatrix, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i31 < (i15 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i6; i33 += 2) {
                    int i34 = i30 - i32;
                    bitMatrix.set(i34, i33);
                    int i35 = i30 + i32;
                    bitMatrix.set(i35, i33);
                    bitMatrix.set(i33, i34);
                    bitMatrix.set(i33, i35);
                }
                i31 += 15;
                i32 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i4);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - (bitArray.getSize() / i2));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : bitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        int i3;
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            i3 = 28;
        } else {
            bitArray.appendBits(i - 1, 5);
            bitArray.appendBits(i2 - 1, 11);
            i3 = 40;
        }
        return generateCheckWords(bitArray, i3, 4);
    }

    private static GenericGF getGF(int i) {
        if (i != 4) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i == 12) {
                            return GenericGF.AZTEC_DATA_12;
                        }
                        throw new IllegalArgumentException("Unsupported word size " + i);
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 != i2) {
                if (i7 == 0) {
                    i7 = i4 | 1;
                } else {
                    bitArray2.appendBits(i4, i);
                    i3 += i;
                }
            }
            bitArray2.appendBits(i7, i);
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
