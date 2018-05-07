package wuxiang.miku.scorpio.wuxiang.adapters.eating;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.EatingItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/7.
 */

public class FindEatingListAdapter extends BaseMultiItemQuickAdapter<EatingItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FindEatingListAdapter(List<EatingItem> data) {
        super(data);
        addItemType(ConstantUtils.TYPE_FIND_NORMAL, R.layout.item_find_normal);
    }

    @Override
    protected void convert(BaseViewHolder helper, EatingItem item) {
        helper.setText(R.id.tv_hot_name, item.getName())
                .setText(R.id.tv_hot_desc, item.getDesc())
                .setText(R.id.tv_hot_showInfo, item.getInformation())
                .setImageResource(R.id.iv_hot_image, R.drawable.test_image);
    }
}
