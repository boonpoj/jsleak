package com.mopub.nativeads;

import android.app.Activity;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class MoPubAdAdapter extends BaseAdapter {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final WeakHashMap<View, Integer> f1606;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Adapter f1607;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MoPubStreamAdPlacer f1608;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final VisibilityTracker f1609;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private MoPubNativeAdLoadedListener f1610;

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter) {
        this(activity, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter, @NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), adapter, new VisibilityTracker(activity));
    }

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter, @NonNull MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), adapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubAdAdapter(@NonNull MoPubStreamAdPlacer moPubStreamAdPlacer, @NonNull Adapter adapter, @NonNull VisibilityTracker visibilityTracker) {
        this.f1607 = adapter;
        this.f1608 = moPubStreamAdPlacer;
        this.f1606 = new WeakHashMap<>();
        this.f1609 = visibilityTracker;
        this.f1609.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() { // from class: com.mopub.nativeads.MoPubAdAdapter.1
            @Override // com.mopub.common.VisibilityTracker.VisibilityTrackerListener
            public void onVisibilityChanged(@NonNull List<View> list, List<View> list2) {
                MoPubAdAdapter.this.m1343(list);
            }
        });
        this.f1607.registerDataSetObserver(new DataSetObserver() { // from class: com.mopub.nativeads.MoPubAdAdapter.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                MoPubAdAdapter.this.f1608.setItemCount(MoPubAdAdapter.this.f1607.getCount());
                MoPubAdAdapter.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                MoPubAdAdapter.this.notifyDataSetInvalidated();
            }
        });
        this.f1608.setAdLoadedListener(new MoPubNativeAdLoadedListener() { // from class: com.mopub.nativeads.MoPubAdAdapter.3
            @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
            public void onAdLoaded(int i) {
                MoPubAdAdapter.this.m1345(i);
            }

            @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
            public void onAdRemoved(int i) {
                MoPubAdAdapter.this.m1346(i);
            }
        });
        this.f1608.setItemCount(this.f1607.getCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1343(@NonNull List<View> list) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (View view : list) {
            Integer num = this.f1606.get(view);
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        this.f1608.placeAdsInRange(i, i2 + 1);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return (this.f1607 instanceof ListAdapter) && ((ListAdapter) this.f1607).areAllItemsEnabled();
    }

    public void clearAds() {
        this.f1608.clearAds();
    }

    public void destroy() {
        this.f1608.destroy();
        this.f1609.destroy();
    }

    public int getAdjustedPosition(int i) {
        return this.f1608.getAdjustedPosition(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1608.getAdjustedCount(this.f1607.getCount());
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i) {
        Object adData = this.f1608.getAdData(i);
        return adData != null ? adData : this.f1607.getItem(this.f1608.getOriginalPosition(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Object adData = this.f1608.getAdData(i);
        return adData != null ? -System.identityHashCode(adData) : this.f1607.getItemId(this.f1608.getOriginalPosition(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int adViewType = this.f1608.getAdViewType(i);
        return adViewType != 0 ? (adViewType + this.f1607.getViewTypeCount()) - 1 : this.f1607.getItemViewType(this.f1608.getOriginalPosition(i));
    }

    public int getOriginalPosition(int i) {
        return this.f1608.getOriginalPosition(i);
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        View adView = this.f1608.getAdView(i, view, viewGroup);
        if (adView == null) {
            adView = this.f1607.getView(this.f1608.getOriginalPosition(i), view, viewGroup);
        }
        this.f1606.put(adView, Integer.valueOf(i));
        this.f1609.addView(adView, 0, null);
        return adView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f1607.getViewTypeCount() + this.f1608.getAdViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f1607.hasStableIds();
    }

    public void insertItem(int i) {
        this.f1608.insertItem(i);
    }

    public boolean isAd(int i) {
        return this.f1608.isAd(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.f1607.isEmpty() && this.f1608.getAdjustedCount(0) == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return isAd(i) || ((this.f1607 instanceof ListAdapter) && ((ListAdapter) this.f1607).isEnabled(this.f1608.getOriginalPosition(i)));
    }

    public void loadAds(@NonNull String str) {
        this.f1608.loadAds(str);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        this.f1608.loadAds(str, requestParameters);
    }

    public void refreshAds(@NonNull ListView listView, @NonNull String str) {
        refreshAds(listView, str, null);
    }

    public void refreshAds(@NonNull ListView listView, @NonNull String str, @Nullable RequestParameters requestParameters) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.refreshAds with a null ListView")) {
            View childAt = listView.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int max = Math.max(firstVisiblePosition - 1, 0);
            while (this.f1608.isAd(max) && max > 0) {
                max--;
            }
            int lastVisiblePosition = listView.getLastVisiblePosition();
            while (this.f1608.isAd(lastVisiblePosition) && lastVisiblePosition < getCount() - 1) {
                lastVisiblePosition++;
            }
            int originalPosition = this.f1608.getOriginalPosition(max);
            this.f1608.removeAdsInRange(this.f1608.getOriginalCount(lastVisiblePosition + 1), this.f1608.getOriginalCount(getCount()));
            int removeAdsInRange = this.f1608.removeAdsInRange(0, originalPosition);
            if (removeAdsInRange > 0) {
                listView.setSelectionFromTop(firstVisiblePosition - removeAdsInRange, top);
            }
            loadAds(str, requestParameters);
        }
    }

    public final void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Tried to set a null ad renderer on the placer.")) {
            this.f1608.registerAdRenderer(moPubAdRenderer);
        }
    }

    public void removeItem(int i) {
        this.f1608.removeItem(i);
    }

    public final void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.f1610 = moPubNativeAdLoadedListener;
    }

    public void setOnClickListener(@NonNull ListView listView, @Nullable final AdapterView.OnItemClickListener onItemClickListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnClickListener with a null ListView")) {
            if (onItemClickListener == null) {
                listView.setOnItemClickListener(null);
            } else {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mopub.nativeads.MoPubAdAdapter.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (MoPubAdAdapter.this.f1608.isAd(i)) {
                            return;
                        }
                        onItemClickListener.onItemClick(adapterView, view, MoPubAdAdapter.this.f1608.getOriginalPosition(i), j);
                    }
                });
            }
        }
    }

    public void setOnItemLongClickListener(@NonNull ListView listView, @Nullable final AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView")) {
            if (onItemLongClickListener == null) {
                listView.setOnItemLongClickListener(null);
            } else {
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.mopub.nativeads.MoPubAdAdapter.5
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        return MoPubAdAdapter.this.isAd(i) || onItemLongClickListener.onItemLongClick(adapterView, view, MoPubAdAdapter.this.f1608.getOriginalPosition(i), j);
                    }
                });
            }
        }
    }

    public void setOnItemSelectedListener(@NonNull ListView listView, @Nullable final AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView")) {
            if (onItemSelectedListener == null) {
                listView.setOnItemSelectedListener(null);
            } else {
                listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.mopub.nativeads.MoPubAdAdapter.6
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (MoPubAdAdapter.this.isAd(i)) {
                            return;
                        }
                        onItemSelectedListener.onItemSelected(adapterView, view, MoPubAdAdapter.this.f1608.getOriginalPosition(i), j);
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        onItemSelectedListener.onNothingSelected(adapterView);
                    }
                });
            }
        }
    }

    public void setSelection(@NonNull ListView listView, int i) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setSelection with a null ListView")) {
            listView.setSelection(this.f1608.getAdjustedPosition(i));
        }
    }

    public void smoothScrollToPosition(@NonNull ListView listView, int i) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView")) {
            listView.smoothScrollToPosition(this.f1608.getAdjustedPosition(i));
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1345(int i) {
        if (this.f1610 != null) {
            this.f1610.onAdLoaded(i);
        }
        notifyDataSetChanged();
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1346(int i) {
        if (this.f1610 != null) {
            this.f1610.onAdRemoved(i);
        }
        notifyDataSetChanged();
    }
}
