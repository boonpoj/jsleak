package com.mopub.mraid;

import android.support.annotation.NonNull;
/* loaded from: assets/classes2.dex */
public enum MraidJavascriptCommand {
    CLOSE("close"),
    EXPAND("expand") { // from class: com.mopub.mraid.MraidJavascriptCommand.1
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN("open") { // from class: com.mopub.mraid.MraidJavascriptCommand.2
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return true;
        }
    },
    RESIZE("resize") { // from class: com.mopub.mraid.MraidJavascriptCommand.3
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") { // from class: com.mopub.mraid.MraidJavascriptCommand.4
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") { // from class: com.mopub.mraid.MraidJavascriptCommand.5
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") { // from class: com.mopub.mraid.MraidJavascriptCommand.6
        @Override // com.mopub.mraid.MraidJavascriptCommand
        /* renamed from: ࢠ */
        boolean mo1204(@NonNull PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");
    
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f1369;

    MraidJavascriptCommand(String str) {
        this.f1369 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static MraidJavascriptCommand m1202(@NonNull String str) {
        MraidJavascriptCommand[] values;
        for (MraidJavascriptCommand mraidJavascriptCommand : values()) {
            if (mraidJavascriptCommand.f1369.equals(str)) {
                return mraidJavascriptCommand;
            }
        }
        return UNSPECIFIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m1203() {
        return this.f1369;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean mo1204(@NonNull PlacementType placementType) {
        return false;
    }
}
