package wuxiang.miku.scorpio.wuxiang.adapters.restaurantdetail;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.DetailPhotoItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;
import wuxiang.miku.scorpio.wuxiang.utils.GlideUtils;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class DetailPhotoAdapter extends BaseMultiItemQuickAdapter<DetailPhotoItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DetailPhotoAdapter(List<DetailPhotoItem> data) {
        super(data);
        addItemType(ConstantUtils.TYPE_DETAIL_PHOTO, R.layout.item_detail_photo);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailPhotoItem item) {
        GlideUtils.loadImage(mContext, R.drawable.test_image,
                (ImageView) helper.getView(R.id.detail_show_photo_imageview));
    }
}
