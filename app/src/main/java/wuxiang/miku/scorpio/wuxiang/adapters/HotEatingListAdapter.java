package wuxiang.miku.scorpio.wuxiang.adapters;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.HotEatingItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;
import wuxiang.miku.scorpio.wuxiang.utils.ImgUtil;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class HotEatingListAdapter extends BaseMultiItemQuickAdapter<HotEatingItem, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HotEatingListAdapter(List<HotEatingItem> data) {
        super(data);
        addItemType(ConstantUtils.TYPE_HOT_NORMAL, R.layout.item_hot_normal);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotEatingItem item) {
        helper.setText(R.id.tv_hot_name, item.getName())
                .setText(R.id.tv_hot_desc, item.getDesc())
                .setText(R.id.tv_hot_showInfo, item.getInformation())
                .setImageResource(R.id.iv_hot_image,R.drawable.test_image);
//        final String imageUtl = ImgUtil
    }
}
