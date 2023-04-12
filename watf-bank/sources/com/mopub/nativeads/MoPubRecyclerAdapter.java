package com.mopub.nativeads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public final class MoPubRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final RecyclerView.AdapterDataObserver f1697;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RecyclerView f1698;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MoPubStreamAdPlacer f1699;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final RecyclerView.Adapter f1700;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final VisibilityTracker f1701;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final WeakHashMap<View, Integer> f1702;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private ContentChangeStrategy f1703;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private MoPubNativeAdLoadedListener f1704;

    /* loaded from: assets/classes2.dex */
    public enum ContentChangeStrategy {
        INSERT_AT_END,
        MOVE_ALL_ADS_WITH_CONTENT,
        KEEP_ADS_FIXED
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull RecyclerView.Adapter adapter) {
        this(activity, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull RecyclerView.Adapter adapter, @NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), adapter, new VisibilityTracker(activity));
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull RecyclerView.Adapter adapter, @NonNull MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), adapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubRecyclerAdapter(@NonNull MoPubStreamAdPlacer moPubStreamAdPlacer, @NonNull RecyclerView.Adapter adapter, @NonNull VisibilityTracker visibilityTracker) {
        this.f1703 = ContentChangeStrategy.INSERT_AT_END;
        this.f1702 = new WeakHashMap<>();
        this.f1700 = adapter;
        this.f1701 = visibilityTracker;
        this.f1701.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() { // from class: com.mopub.nativeads.MoPubRecyclerAdapter.1
            @Override // com.mopub.common.VisibilityTracker.VisibilityTrackerListener
            public void onVisibilityChanged(List<View> list, List<View> list2) {
                MoPubRecyclerAdapter.this.m1413(list, list2);
            }
        });
        m1414(this.f1700.hasStableIds());
        this.f1699 = moPubStreamAdPlacer;
        this.f1699.setAdLoadedListener(new MoPubNativeAdLoadedListener() { // from class: com.mopub.nativeads.MoPubRecyclerAdapter.2
            @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
            public void onAdLoaded(int i) {
                MoPubRecyclerAdapter.this.m1417(i);
            }

            @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
            public void onAdRemoved(int i) {
                MoPubRecyclerAdapter.this.m1418(i);
            }
        });
        this.f1699.setItemCount(this.f1700.getItemCount());
        this.f1697 = new RecyclerView.AdapterDataObserver() { // from class: com.mopub.nativeads.MoPubRecyclerAdapter.3
            public void onChanged() {
                MoPubRecyclerAdapter.this.f1699.setItemCount(MoPubRecyclerAdapter.this.f1700.getItemCount());
                MoPubRecyclerAdapter.this.notifyDataSetChanged();
            }

            public void onItemRangeChanged(int i, int i2) {
                int adjustedPosition = MoPubRecyclerAdapter.this.f1699.getAdjustedPosition((i2 + i) - 1);
                int adjustedPosition2 = MoPubRecyclerAdapter.this.f1699.getAdjustedPosition(i);
                MoPubRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition2, (adjustedPosition - adjustedPosition2) + 1);
            }

            public void onItemRangeInserted(int i, int i2) {
                int adjustedPosition = MoPubRecyclerAdapter.this.f1699.getAdjustedPosition(i);
                int itemCount = MoPubRecyclerAdapter.this.f1700.getItemCount();
                MoPubRecyclerAdapter.this.f1699.setItemCount(itemCount);
                boolean z = i + i2 >= itemCount;
                if (ContentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.this.f1703 || (ContentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.this.f1703 && z)) {
                    MoPubRecyclerAdapter.this.notifyDataSetChanged();
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    MoPubRecyclerAdapter.this.f1699.insertItem(i);
                }
                MoPubRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i2);
            }

            public void onItemRangeMoved(int i, int i2, int i3) {
                MoPubRecyclerAdapter.this.notifyDataSetChanged();
            }

            public void onItemRangeRemoved(int i, int i2) {
                int adjustedPosition = MoPubRecyclerAdapter.this.f1699.getAdjustedPosition(i);
                int itemCount = MoPubRecyclerAdapter.this.f1700.getItemCount();
                MoPubRecyclerAdapter.this.f1699.setItemCount(itemCount);
                boolean z = i + i2 >= itemCount;
                if (ContentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.this.f1703 || (ContentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.this.f1703 && z)) {
                    MoPubRecyclerAdapter.this.notifyDataSetChanged();
                    return;
                }
                int adjustedCount = MoPubRecyclerAdapter.this.f1699.getAdjustedCount(itemCount + i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    MoPubRecyclerAdapter.this.f1699.removeItem(i);
                }
                int adjustedCount2 = adjustedCount - MoPubRecyclerAdapter.this.f1699.getAdjustedCount(itemCount);
                MoPubRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (adjustedCount2 - i2), adjustedCount2);
            }
        };
        this.f1700.registerAdapterDataObserver(this.f1697);
    }

    public static int computeScrollOffset(@NonNull LinearLayoutManager linearLayoutManager, @Nullable RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return 0;
        }
        View view = viewHolder.itemView;
        if (linearLayoutManager.canScrollVertically()) {
            return linearLayoutManager.getStackFromEnd() ? view.getBottom() : view.getTop();
        } else if (linearLayoutManager.canScrollHorizontally()) {
            return linearLayoutManager.getStackFromEnd() ? view.getRight() : view.getLeft();
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1413(List<View> list, List<View> list2) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (View view : list) {
            Integer num = this.f1702.get(view);
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        this.f1699.placeAdsInRange(i, i2 + 1);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1414(boolean z) {
        super.setHasStableIds(z);
    }

    public void clearAds() {
        this.f1699.clearAds();
    }

    public void destroy() {
        this.f1700.unregisterAdapterDataObserver(this.f1697);
        this.f1699.destroy();
        this.f1701.destroy();
    }

    public int getAdjustedPosition(int i) {
        return this.f1699.getAdjustedPosition(i);
    }

    public int getItemCount() {
        return this.f1699.getAdjustedCount(this.f1700.getItemCount());
    }

    public long getItemId(int i) {
        if (this.f1700.hasStableIds()) {
            Object adData = this.f1699.getAdData(i);
            return adData != null ? -System.identityHashCode(adData) : this.f1700.getItemId(this.f1699.getOriginalPosition(i));
        }
        return -1L;
    }

    public int getItemViewType(int i) {
        int adViewType = this.f1699.getAdViewType(i);
        return adViewType != 0 ? adViewType - 56 : this.f1700.getItemViewType(this.f1699.getOriginalPosition(i));
    }

    public int getOriginalPosition(int i) {
        return this.f1699.getOriginalPosition(i);
    }

    public boolean isAd(int i) {
        return this.f1699.isAd(i);
    }

    public void loadAds(@NonNull String str) {
        this.f1699.loadAds(str);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        this.f1699.loadAds(str, requestParameters);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f1698 = recyclerView;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Object adData = this.f1699.getAdData(i);
        if (adData != null) {
            this.f1699.bindAdView((NativeAd) adData, viewHolder.itemView);
            return;
        }
        this.f1702.put(viewHolder.itemView, Integer.valueOf(i));
        this.f1701.addView(viewHolder.itemView, 0, null);
        this.f1700.onBindViewHolder(viewHolder, this.f1699.getOriginalPosition(i));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i < -56 || i > this.f1699.getAdViewTypeCount() - 56) {
            return this.f1700.onCreateViewHolder(viewGroup, i);
        }
        MoPubAdRenderer adRendererForViewType = this.f1699.getAdRendererForViewType(i - (-56));
        if (adRendererForViewType == null) {
            MoPubLog.w("No view binder was registered for ads in MoPubRecyclerAdapter.");
            return null;
        }
        return new MoPubRecyclerViewHolder(adRendererForViewType.createAdView((Activity) viewGroup.getContext(), viewGroup));
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f1698 = null;
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return viewHolder instanceof MoPubRecyclerViewHolder ? super.onFailedToRecycleView(viewHolder) : this.f1700.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MoPubRecyclerViewHolder) {
            super.onViewAttachedToWindow(viewHolder);
        } else {
            this.f1700.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MoPubRecyclerViewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
        } else {
            this.f1700.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MoPubRecyclerViewHolder) {
            super.onViewRecycled(viewHolder);
        } else {
            this.f1700.onViewRecycled(viewHolder);
        }
    }

    public void refreshAds(@NonNull String str) {
        refreshAds(str, null);
    }

    public void refreshAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        String str2;
        if (this.f1698 == null) {
            str2 = "This adapter is not attached to a RecyclerView and cannot be refreshed.";
        } else {
            LinearLayoutManager layoutManager = this.f1698.getLayoutManager();
            if (layoutManager != null) {
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    MoPubLog.w("This LayoutManager can't be refreshed.");
                    return;
                }
                LinearLayoutManager linearLayoutManager = layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int computeScrollOffset = computeScrollOffset(linearLayoutManager, this.f1698.findViewHolderForLayoutPosition(findFirstVisibleItemPosition));
                int max = Math.max(0, findFirstVisibleItemPosition - 1);
                while (this.f1699.isAd(max) && max > 0) {
                    max--;
                }
                int itemCount = getItemCount();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                while (this.f1699.isAd(findLastVisibleItemPosition) && findLastVisibleItemPosition < itemCount - 1) {
                    findLastVisibleItemPosition++;
                }
                int originalPosition = this.f1699.getOriginalPosition(max);
                this.f1699.removeAdsInRange(this.f1699.getOriginalPosition(findLastVisibleItemPosition), this.f1700.getItemCount());
                int removeAdsInRange = this.f1699.removeAdsInRange(0, originalPosition);
                if (removeAdsInRange > 0) {
                    linearLayoutManager.scrollToPositionWithOffset(findFirstVisibleItemPosition - removeAdsInRange, computeScrollOffset);
                }
                loadAds(str, requestParameters);
                return;
            }
            str2 = "Can't refresh ads when there is no layout manager on a RecyclerView.";
        }
        MoPubLog.w(str2);
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            this.f1699.registerAdRenderer(moPubAdRenderer);
        }
    }

    public void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.f1704 = moPubNativeAdLoadedListener;
    }

    public void setContentChangeStrategy(@NonNull ContentChangeStrategy contentChangeStrategy) {
        if (Preconditions.NoThrow.checkNotNull(contentChangeStrategy)) {
            this.f1703 = contentChangeStrategy;
        }
    }

    public void setHasStableIds(boolean z) {
        m1414(z);
        this.f1700.unregisterAdapterDataObserver(this.f1697);
        this.f1700.setHasStableIds(z);
        this.f1700.registerAdapterDataObserver(this.f1697);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1417(int i) {
        if (this.f1704 != null) {
            this.f1704.onAdLoaded(i);
        }
        notifyItemInserted(i);
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1418(int i) {
        if (this.f1704 != null) {
            this.f1704.onAdRemoved(i);
        }
        notifyItemRemoved(i);
    }
}
