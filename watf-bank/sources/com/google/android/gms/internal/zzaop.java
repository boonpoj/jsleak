package com.google.android.gms.internal;

import android.webkit.ConsoleMessage;
/* loaded from: classes.dex */
final /* synthetic */ class zzaop {
    static final /* synthetic */ int[] zzdnr = new int[ConsoleMessage.MessageLevel.values().length];

    static {
        try {
            zzdnr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzdnr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzdnr[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzdnr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzdnr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
