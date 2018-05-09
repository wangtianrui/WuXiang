package wuxiang.miku.scorpio.wuxiang.entity;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class TagItem {
    public TagItem() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public TagItem(int count, int restaurantId, int tag, String tagName) {
        this.count = count;
        this.restaurantId = restaurantId;
        this.tag = tag;
        this.tagName = tagName;
    }

    private int count;
    private int restaurantId;
    private int tag;
    private String tagName;
}
