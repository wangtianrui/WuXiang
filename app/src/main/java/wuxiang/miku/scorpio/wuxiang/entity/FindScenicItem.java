package wuxiang.miku.scorpio.wuxiang.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class FindScenicItem implements MultiItemEntity {
    private ArrayList<Integer> imageUrls;
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<Integer> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public int getItemType() {
        return ConstantUtils.TYPE_SCENIC;
    }
}
