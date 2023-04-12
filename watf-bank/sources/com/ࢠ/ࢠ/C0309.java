package com.ࢠ.ࢠ;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.ࢠ.ࢠ.ބ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0309 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String f2293 = "Service Wombat";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static String f2294 = "Service Bradypus";

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static int m1773(float f) {
        return (int) ((f * C0337.m1878().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m1774(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, m1775(), m1776());
            return new String(cipher.doFinal(decode));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static Key m1775() {
        try {
            return new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(f2293.getBytes("UTF-8")), "AES");
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    static AlgorithmParameterSpec m1776() {
        try {
            return new IvParameterSpec(f2294.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
