package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
/* loaded from: assets/classes2.dex */
abstract class Token {
    static final Token EMPTY = new SimpleToken(null, 0, 0);
    private final Token previous;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token(Token token) {
        this.previous = token;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token add(int i, int i2) {
        return new SimpleToken(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token addBinaryShift(int i, int i2) {
        return new BinaryShiftToken(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void appendTo(BitArray bitArray, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token getPrevious() {
        return this.previous;
    }
}
