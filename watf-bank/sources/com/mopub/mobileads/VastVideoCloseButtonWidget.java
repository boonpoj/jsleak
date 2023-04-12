package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
/* loaded from: assets/classes2.dex */
public class VastVideoCloseButtonWidget extends RelativeLayout {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private TextView f1024;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ImageView f1025;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ImageLoader f1026;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private CloseButtonDrawable f1027;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final int f1028;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final int f1029;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final int f1030;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final int f1031;

    public VastVideoCloseButtonWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f1028 = Dips.dipsToIntPixels(6.0f, context);
        this.f1030 = Dips.dipsToIntPixels(15.0f, context);
        this.f1031 = Dips.dipsToIntPixels(56.0f, context);
        this.f1029 = Dips.dipsToIntPixels(0.0f, context);
        this.f1027 = new CloseButtonDrawable();
        this.f1026 = Networking.getImageLoader(context);
        m900();
        m901();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f1031);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m900() {
        this.f1025 = new ImageView(getContext());
        this.f1025.setId((int) Utils.generateUniqueId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1031, this.f1031);
        layoutParams.addRule(11);
        this.f1025.setImageDrawable(this.f1027);
        this.f1025.setPadding(this.f1030, this.f1030 + this.f1028, this.f1030 + this.f1028, this.f1030);
        addView(this.f1025, layoutParams);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m901() {
        this.f1024 = new TextView(getContext());
        this.f1024.setSingleLine();
        this.f1024.setEllipsize(TextUtils.TruncateAt.END);
        this.f1024.setTextColor(-1);
        this.f1024.setTextSize(20.0f);
        this.f1024.setTypeface(DrawableConstants.CloseButton.TEXT_TYPEFACE);
        this.f1024.setText("");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, this.f1025.getId());
        this.f1024.setPadding(0, this.f1028, 0, 0);
        layoutParams.setMargins(0, 0, this.f1029, 0);
        addView(this.f1024, layoutParams);
    }

    @VisibleForTesting
    @Deprecated
    ImageView getImageView() {
        return this.f1025;
    }

    @VisibleForTesting
    @Deprecated
    TextView getTextView() {
        return this.f1024;
    }

    @VisibleForTesting
    @Deprecated
    void setImageView(ImageView imageView) {
        this.f1025 = imageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnTouchListenerToContent(@Nullable View.OnTouchListener onTouchListener) {
        this.f1025.setOnTouchListener(onTouchListener);
        this.f1024.setOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m902(@Nullable String str) {
        if (this.f1024 != null) {
            this.f1024.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m903(@NonNull final String str) {
        this.f1026.get(str, new ImageLoader.ImageListener() { // from class: com.mopub.mobileads.VastVideoCloseButtonWidget.1
            @Override // com.mopub.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                MoPubLog.d("Failed to load image.", volleyError);
            }

            @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                Bitmap bitmap = imageContainer.getBitmap();
                if (bitmap != null) {
                    VastVideoCloseButtonWidget.this.f1025.setImageBitmap(bitmap);
                } else {
                    MoPubLog.d(String.format("%s returned null bitmap", str));
                }
            }
        });
    }
}
