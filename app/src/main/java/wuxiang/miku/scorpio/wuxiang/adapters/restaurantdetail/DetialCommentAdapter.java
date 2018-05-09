package wuxiang.miku.scorpio.wuxiang.adapters.restaurantdetail;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.CommentItem;
import wuxiang.miku.scorpio.wuxiang.utils.GlideUtils;
import wuxiang.miku.scorpio.wuxiang.utils.TimeUtils;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class DetialCommentAdapter extends BaseQuickAdapter<CommentItem, BaseViewHolder> {


    public DetialCommentAdapter(@Nullable List<CommentItem> data) {
        super(R.layout.item_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentItem item) {
        helper.setText(R.id.tv_author_name, "测试用户")
                .setText(R.id.tv_comment_title, item.getCommment())
                .setText(R.id.tv_view_count, String.format("%s", 120))
                .setText(R.id.tv_pub_time, "05-09");
        GlideUtils.loadImage(mContext, R.drawable.user_avatar_test,
                (ImageView) helper.getView(R.id.civ_author));
    }
}
