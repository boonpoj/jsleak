package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.VisibleForTesting;
/* loaded from: assets/classes2.dex */
public class NativeClickHandler {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f1746;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f1747;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f1748;

    public NativeClickHandler(@NonNull Context context) {
        this(context, null);
    }

    public NativeClickHandler(@NonNull Context context, @Nullable String str) {
        Preconditions.checkNotNull(context);
        this.f1746 = context.getApplicationContext();
        this.f1747 = str;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1437(@NonNull View view, @Nullable View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m1437(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    public void clearOnClickListener(@NonNull View view) {
        if (Preconditions.NoThrow.checkNotNull(view, "Cannot clear click listener from a null view")) {
            m1437(view, (View.OnClickListener) null);
        }
    }

    public void openClickDestinationUrl(@NonNull String str, @Nullable View view) {
        m1439(str, view, new C0287(this.f1746));
    }

    public void setOnClickListener(@NonNull View view, @NonNull final ClickInterface clickInterface) {
        if (Preconditions.NoThrow.checkNotNull(view, "Cannot set click listener on a null view") && Preconditions.NoThrow.checkNotNull(clickInterface, "Cannot set click listener with a null ClickInterface")) {
            m1437(view, new View.OnClickListener() { // from class: com.mopub.nativeads.NativeClickHandler.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    clickInterface.handleClick(view2);
                }
            });
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1439(@NonNull String str, @Nullable final View view, @NonNull final C0287 c0287) {
        if (Preconditions.NoThrow.checkNotNull(str, "Cannot open a null click destination url")) {
            Preconditions.checkNotNull(c0287);
            if (this.f1748) {
                return;
            }
            this.f1748 = true;
            if (view != null) {
                c0287.m1551(view);
            }
            UrlHandler.Builder builder = new UrlHandler.Builder();
            if (!TextUtils.isEmpty(this.f1747)) {
                builder.withDspCreativeId(this.f1747);
            }
            builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.nativeads.NativeClickHandler.2
                /* renamed from: ࢠ  reason: contains not printable characters */
                private void m1440() {
                    if (view != null) {
                        c0287.m1550();
                    }
                }

                @Override // com.mopub.common.UrlHandler.ResultActions
                public void urlHandlingFailed(@NonNull String str2, @NonNull UrlAction urlAction) {
                    m1440();
                    NativeClickHandler.this.f1748 = false;
                }

                @Override // com.mopub.common.UrlHandler.ResultActions
                public void urlHandlingSucceeded(@NonNull String str2, @NonNull UrlAction urlAction) {
                    m1440();
                    NativeClickHandler.this.f1748 = false;
                }
            }).build().handleUrl(this.f1746, str);
        }
    }
}
