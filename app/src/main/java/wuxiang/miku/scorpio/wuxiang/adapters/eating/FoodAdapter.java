package wuxiang.miku.scorpio.wuxiang.adapters.eating;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FoodItem;
import wuxiang.miku.scorpio.wuxiang.utils.GlideUtils;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class FoodAdapter extends BaseQuickAdapter<FoodItem, BaseViewHolder> {
    public FoodAdapter(@Nullable List<FoodItem> data) {
        super(R.layout.item_eating_food, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, FoodItem item) {
        helper.setText(R.id.tv_food_name, item.getName())
                .setText(R.id.tv_food_restaurant_name, item.getEatingItem().getName())
                .setText(R.id.tv_food_showInfo, item.getDesc())
        .setText(R.id.tv_food_audience,"距离你"+item.getDistance()+"米");
        GlideUtils.loadImage(mContext, item.getImage(), (ImageView) helper.getView(R.id.iv_food_image));

    }
}
