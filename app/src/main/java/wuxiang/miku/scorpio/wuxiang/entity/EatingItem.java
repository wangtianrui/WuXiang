package wuxiang.miku.scorpio.wuxiang.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class EatingItem implements MultiItemEntity {
    private String name;
    private String desc;
    private String information;
    private int imageResource;
    private int distance;

    public EatingItem() {
    }

    public EatingItem(String name, String desc, String information, int imageResource, int distance) {
        this.name = name;
        this.desc = desc;
        this.information = information;
        this.imageResource = imageResource;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public int getItemType() {
        return ConstantUtils.TYPE_HOT_NORMAL;
    }
}
