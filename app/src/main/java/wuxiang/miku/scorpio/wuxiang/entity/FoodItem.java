package wuxiang.miku.scorpio.wuxiang.entity;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class FoodItem {
    private String name;
    private String desc;
    private EatingItem eatingItem;
    private int distance;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public FoodItem() {
    }

    public FoodItem(String name, String desc, String eatingItem, int distance,int image) {
        this.name = name;
        this.desc = desc;
        this.eatingItem = new EatingItem();
        this.eatingItem.setName(eatingItem);
        this.distance = distance;
        this.image =image;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public EatingItem getEatingItem() {
        return eatingItem;
    }

    public void setEatingItem(EatingItem eatingItem) {
        this.eatingItem = eatingItem;
    }
}
