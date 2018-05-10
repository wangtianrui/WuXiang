package wuxiang.miku.scorpio.wuxiang.adapters.findscenic;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import butterknife.BindView;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FindScenicItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class ScenicRecyclerAdapter extends BaseMultiItemQuickAdapter<FindScenicItem, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ScenicRecyclerAdapter(List<FindScenicItem> data) {
        super(data);
        addItemType(ConstantUtils.TYPE_SCENIC, R.layout.item_find_fragment_scenic);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindScenicItem item) {
        MZBannerView itemRowView = (MZBannerView) helper.getView(R.id.item_row_view);
        itemRowView.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
        itemRowView.setPages(item.getImageUrls(), new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
    }
}
