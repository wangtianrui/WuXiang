package wuxiang.miku.scorpio.wuxiang.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class DetailPhotoItem implements MultiItemEntity {
    @Override
    public int getItemType() {
        return ConstantUtils.TYPE_DETAIL_PHOTO;
    }
}
